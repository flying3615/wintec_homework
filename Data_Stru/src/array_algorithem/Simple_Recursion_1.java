package array_algorithem;

public class Simple_Recursion_1 {

	public static void recursion(int n) {
		if(n==1){
			System.out.println(n);
			return;
		}
		System.out.println(n);
		recursion(n-1);
		return;
	}
	
	public static void main(String[] args) {
		System.out.println("Hello - Simple recursio");
		recursion(3);
	}
}
