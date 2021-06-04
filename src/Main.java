import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    private static ArrayList<Item> tasks;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        tasks = new ArrayList<Item>(); /* amogus */

        boolean running = true;
        String selection = "";

        System.out.println("TODO:");

        System.out.print("Press N for New, E for Edit, D for Delete, or Q to exit: ");

        while (running) {
            if (in.hasNext()) {
                selection = in.next();
                if (selection.equalsIgnoreCase("N")) {
                    newItem();
                    break;
                } else if (selection.equalsIgnoreCase("E")) {
                    editItem();
                    break;
                } else if (selection.equalsIgnoreCase("D")) {
                    deleteItem();
                    break;
                } else if (selection.equalsIgnoreCase("Q")) {
                    System.out.println("Exiting...");
                    break;
                } else {
                    System.out.println("Not a valid selection.");
                    System.out.print("Please press N for New, E for Edit, D for Delete, or Q to exit: ");

                }
            }
        }
    }

    private static void newItem() {
        // initialize new instance of item with name, desc, and date
        System.out.println("New Item");
    }

    private static void editItem() {
        /*
        if array is empty, exit user out, no way to edit a task
        if array size > 0, array.get(num-1).set<whatever>(newString)
         */
        System.out.println("Edit Item");
    }

    private static void deleteItem() {
        // tasks.remove(num-1);
        System.out.println("Delete Item");
    }

}
