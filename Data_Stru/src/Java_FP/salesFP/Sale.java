package Java_FP.salesFP;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by liuyufei on 19/10/16.
 */
public class Sale {
    private Store store;
    private Date date;
    private Optional<String> customer;
    private List<Item> items;

    public Sale(Store store, Date date, Optional<String> customer, List<Item> items) {
        this.store = store;
        this.date = date;
        this.customer = customer;
        this.items = items;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Optional<String> getCustomer() {
        return customer;
    }

    public void setCustomer(Optional<String> customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double total() {
        return items.stream().mapToDouble(item->item.getPrice()).sum();
    }
}
