package list_stacks_queue.pluralsight_queue;

/**
 * Created by liuyufei on 27/10/16.
 */
public class Enquiry {

    private final Customer customer;
    private final Category category;


    public Enquiry(Customer customer, Category category) {
        this.customer = customer;
        this.category = category;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Enquiry{" +
                "customer=" + customer +
                ", category=" + category +
                '}';
    }
}
