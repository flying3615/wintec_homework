package Java_FP.optional;

import Java_FP.salesFP.Item;
import Java_FP.salesFP.Sale;
import Java_FP.salesFP.Store;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by liuyufei on 23/10/16.
 */
public class OptionalExample {

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

    static Stream<Sale> saleStream() {
        return sales.stream();
    }

    static Optional<Sale> findSaleOf(String itemName) {
        return saleStream().filter(sale ->
                sale.getItems().stream().anyMatch(item -> item.getName().equals(itemName))).findFirst();
    }

    //find the store sold a carrot
    static Optional<Store> carrotStore() {
        return findSaleOf("carrot").map(sale -> sale.getStore());
    }

    //customer who bought a carrot, optional in optional
    static Optional<String> carrotCustomer() {
        //use flatMap to wrap customer optional!!!
        return findSaleOf("carrot").flatMap(sale -> sale.getCustomer());
    }

    public static void main(String[] args) {

        System.out.println("which store sells carrot? ");
        carrotStore().ifPresent(System.out::println);

        //get rid of NPE
        System.out.println("Who bought a carrot? " +
                carrotCustomer().orElse("I can't say..."));
    }

}
