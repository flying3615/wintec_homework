package Graph;

import java.util.*;

public class Graph {
    private Map<Integer,Node> nodeLookup = new HashMap<>();

    private static class Node {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return id == node.id;
        }

        @Override
        public int hashCode() {
            return id;
        }

        private int id;
        LinkedList<Node> adjacent = new LinkedList<>();
        private Node(int id){this.id=id;}
    }

    public static Node getNode(int id){return new Node(id);}

    public static void addEdge(Node source,Node destination){
        source.adjacent.add(destination);
    }

    public static boolean hasPathDFS(Node source,Node destination){
        Set<Integer> visited = new HashSet();
        boolean flag = hasPathRecDFS(source,destination,visited);
        System.out.println(source.id);
        return flag;
    }

    private static boolean hasPathRecDFS(Node source, Node destination, Set<Integer> visited) {
        if(visited.contains(source.id)){
            //cannot go to itself
            return false;
        }
        visited.add(source.id);
        if(source == destination){
            return true;
        }
        for(Node child:source.adjacent){
            if(hasPathRecDFS(child,destination,visited)){
                System.out.print(child.id+"<--");
                return true;
            }
        }
        return false;
    }

    public static boolean hasPathBFS(Node source, Node destination){
        List<Node> nextToVisit = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        nextToVisit.add(source);
        while(!nextToVisit.isEmpty()){
            //remove the very first one from a queue
            Node node = nextToVisit.remove(0);
            System.out.println(node.id);

            if(node.equals(destination)){
                return true;
            }
            if(visited.contains(node)){
                //the node already visited
                continue;
            }else{
                //add the node as visited
                visited.add(node);
            }

            //layer by layer
            for(Node child:node.adjacent){
                nextToVisit.add(child);
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Node n1 = Graph.getNode(1);
        Node n2 = Graph.getNode(2);
        Node n3 = Graph.getNode(3);
        Node n4 = Graph.getNode(4);
        Node n5 = Graph.getNode(5);
        Node n6 = Graph.getNode(6);
        Node n7 = Graph.getNode(7);
        Node n8 = Graph.getNode(8);

        Node n9 = Graph.getNode(9); //isolated

        Graph.addEdge(n1,n2);
        Graph.addEdge(n2,n4);
        Graph.addEdge(n2,n6);

        Graph.addEdge(n4,n8);
        Graph.addEdge(n8,n1);

        Graph.addEdge(n1,n3);
        Graph.addEdge(n3,n5);
        Graph.addEdge(n3,n7);


        System.out.println(Graph.hasPathDFS(n8,n7));
        System.out.println(Graph.hasPathBFS(n8,n9));

    }

}
