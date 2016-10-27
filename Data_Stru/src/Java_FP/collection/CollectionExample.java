package Java_FP.collection;

/**
 * Created by liuyufei on 19/10/16.
 */
public class CollectionExample {

    final static String[] food = new String[]{
            "Crunchy carrots",
            "Golden-hued bananas",
            "",
            "Bright orange pumpkins",
            "Little trees of broccoli",
            "meat"
    };

    public static void main(String[] args) {

        final String summary = summarize(food);

        final String desiredSummary =
                "carrots & bananas & pumpkins & broccoli & meat";
        System.out.println(summary);
        if(summary.equals(desiredSummary)) System.out.println("yay!");
    }

    private static String summarize(String[] food) {
        StringBuilder output = new StringBuilder();
        boolean isFirst = true;
        for(String d:food){
            if(!d.isEmpty()){
                String word = lastWord(d);
                if(!isFirst){
                    output.append(" & ");
                }
                output.append(word);
                isFirst = false;
            }
        }
        return output.toString();
    }

    private static String lastWord(final String phrase){
        final int lastSpace = phrase.lastIndexOf(" ");
        if(lastSpace<0){
            return phrase;
        }else{
            return phrase.substring(lastSpace+1,phrase.length());
        }
    }
}
