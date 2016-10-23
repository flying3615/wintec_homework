package Java_FP.salesFP;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by liuyufei on 19/10/16.
 */
public class TodaySales {

    static final List<Sale> sales = Arrays.asList(
            new Sale(Store.KANSAS_CITY, new Date(), Optional.of("Sarah"),
                    Arrays.asList(
                            new Item("carrot", 12.00)
                    )),
            new Sale(Store.ST_LOUIS, new Date(), Optional.empty(),
                    Arrays.asList(
                            new Item("carrot", 12.00),
                            new Item("lizard", 99.90),
                            new Item("cookie", 1.99)
                    )),
            new Sale(Store.ST_LOUIS, new Date(), Optional.of("Jamie"),
                    Arrays.asList(
                            new Item("banana", 3.49),
                            new Item("cookie", 1.49)
                    ))
    );

    //cause stream only can be applied once
    //so each time we ask for a new stream to handle
    static Stream<Sale> saleStream() {
        return sales.stream();
    }

    public static void main(String[] args) {
        //how many sales?
        long saleCount = saleStream().count();
        System.out.println(saleCount);

        //any sales over $100,
        //anyMatch stop as soon as it encounter a sale total is bigger than 100
        //short-circuiting terminal operation
        boolean bigSaleDay = saleStream().anyMatch(sale -> sale.total() > 100.00);
        System.out.println("Big sale day? " + bigSaleDay);

        //statistic about the sale
        DoubleSummaryStatistics stats =
                saleStream().mapToDouble(Sale::total).summaryStatistics();
        System.out.println("Max sale amount " + stats.getMax());
        System.out.println("Max sale amount " + stats);

        //how many items were sold today?
        //flatMap used to combine all items stream together
        Supplier<Stream<Item>> itemStream = () ->
                saleStream().flatMap(sale -> sale.getItems().stream());

        long itemCount = itemStream.get().count();
        System.out.println("Count of items " + itemCount);

        //how many different items were sold today, by name
        long uniqueItemCount = itemStream.get().map(item -> item.getName()).distinct().count();
        System.out.println("Count of items " + uniqueItemCount);

        //distinct item names
        List<String> uniqueItem = itemStream.get().map(item -> item.getName())
                .distinct().collect(Collectors.toList());
        System.out.println("Distinct items' name " + uniqueItem);

        //join all distinct item names together
        String uniqueItemStr = itemStream.get().map(item -> item.getName())
                .distinct().collect(Collectors.joining(" & "));
        System.out.println("Distinct items' name " + uniqueItemStr);


        //summarize sales by store, collect to a Map
        Map<Store, DoubleSummaryStatistics> summary =
                saleStream().collect(Collectors.groupingBy(sale -> sale.getStore(),
                        Collectors.summarizingDouble(Sale::total)));
        System.out.println("Summary by store: "+summary);
        summary.keySet().stream().forEach(store ->
                System.out.println(store + " stats "+summary.get(store))
        );


        System.out.println("-----------parallel-----------");

        //summarize sales by store, collect to a Map in parallel
        Map<String, DoubleSummaryStatistics> summaryPara =
                saleStream().parallel().collect(Collectors.groupingBy(sale -> Thread.currentThread().getName(),
                        Collectors.summarizingDouble(Sale::total)));
        System.out.println("Summary by store: "+summaryPara);
        summaryPara.keySet().stream().sorted().forEach(store ->
                System.out.println(store + " stats "+summaryPara.get(store))
        );
    }

}
