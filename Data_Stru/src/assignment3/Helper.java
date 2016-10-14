package assignment3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by liuyufei on 1/10/16.
 */
public class Helper {
    public static ItemList readInputFomeFile(String file) {
        File f = new File(Helper.class.getResource(file).getFile());
        ItemList ItemList = new ItemList();
        Scanner scanner = null;
        try {
            scanner = new Scanner(f);
            while (scanner.hasNext()) {
                ItemList.addItem(scanner.nextInt());
            }
        } catch (IOException e) {
            System.out.println("Unable to create: " + e.getMessage());
        } finally {
            if (scanner != null)
                scanner.close();
        }
        return ItemList;
    }// end of readInputFomeFile



}
