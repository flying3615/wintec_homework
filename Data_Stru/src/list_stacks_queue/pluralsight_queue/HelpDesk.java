package list_stacks_queue.pluralsight_queue;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Predicate;

/**
 * Created by liuyufei on 27/10/16.
 */
public class HelpDesk {


    private static final Comparator<Enquiry> BY_CATEGORY = (o1, o2) ->
            o1.getCategory().compareTo(o2.getCategory());

    //priority Queue
    private Queue<Enquiry> enquiries_priori = new PriorityQueue<>(BY_CATEGORY);

    private final Queue<Enquiry> enquiries = new ArrayDeque<>();

    public void enquire(final Customer customer, final Category category) {
//        insert element->offer()&add()
        //offer returns false if the queue is full
        //add exceptions if the queue is full

        enquiries.offer(new Enquiry(customer, category));
    }


    public void processPrinterEnquiry() {
        processEnquire(enq->enq.getCategory()==Category.PRINTER,
                "Is it out of paper");
    }

    public void processGeneralEnquiry() {
        processEnquire(enq->enq.getCategory()!=Category.PRINTER,
                "Have you tried turning it off and on again?");
    }

    private void processEnquire(Predicate<Enquiry> predicate, String message) {
//        Read without removing->element()&peek()
//        element throws exception when empty
//        peek returns null when empty


        final Enquiry enquiry = enquiries.peek();
        if (enquiry != null && predicate.test(enquiry)) {
            //using peek, need to remove the element
            enquiries.remove();
            enquiry.getCustomer().reply(message);
        } else {
            System.out.println("No work to do, let's have some coffee");
        }
    }




    public void processAllEnquires() {
//        remove element->remove()&poll()

//        1. using remove and isEmpty check queue
//        remove throws exception when empty
//        while (!enquiries.isEmpty()){
//            final Enquiry enquiry = enquiries.remove();
//            enquiry.getCustomer().reply("Have you tried turning it off and on again?");
//        }

//        2. using poll and check is it's null
//        poll returns null when empty
        Enquiry enquiry;
        while ((enquiry = enquiries.poll()) != null) {
            enquiry.getCustomer().reply("Have you tried turning it off and on again?");
        }


    }

    public static void main(String[] args) {
        HelpDesk helpDesk = new HelpDesk();

        //process depends on offer order
        helpDesk.enquire(Customer.JACK, Category.PHONE);
        helpDesk.enquire(Customer.JILL, Category.PRINTER);

        helpDesk.processPrinterEnquiry();
        helpDesk.processGeneralEnquiry();
        helpDesk.processPrinterEnquiry();

    }
}
