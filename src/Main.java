import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    private static ArrayList<Item> tasks;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        tasks = new ArrayList<>(); /* amogus */

        String selection;

        System.out.println("TODO:");

        System.out.print("Press N for New, E for Edit, D for Delete, L to List, or Q to exit: ");


        while (true) {
            if (in.hasNext()) {
                selection = in.next();
                if (selection.equalsIgnoreCase("N")) {
                    System.out.println("New Item");
                    newItem();
                } else if (selection.equalsIgnoreCase("E")) {
                    System.out.println("Edit Item");
                    System.out.print("Please enter the index of the item you wish to edit. ");
                    if (in.hasNextInt()) {
                        editItem(in.nextInt());
                    } else {
                        System.out.println("Please only enter a number.");
                    }
                } else if (selection.equalsIgnoreCase("D")) {
                    System.out.println("Delete Item");
                    System.out.print("Please enter the index of the item you wish to delete. ");
                    if (in.hasNextInt()) {
                        deleteItem(in.nextInt());
                    } else {
                        System.out.println("Please only enter a number.");
                    }
                } else if (selection.equalsIgnoreCase("L")) {
                    int i = 1;
                    if (tasks.size() == 0) {
                        System.out.println("No tasks");
                    } else {
                        for (Item n : tasks) {
                            System.out.printf("%d) %s - %s, due: %s%n", i, n.getName(), n.getDesc(), n.getDueDate());
                            i++;
                        }
                    }
                } else if (selection.equalsIgnoreCase("Q")) {
                    System.out.println("Exiting...");
                    System.exit(0);
                } else {
                    System.out.print("Press N for New, E for Edit, D for Delete, L to List, or Q to exit: ");
                }
            }
        }
    }

    private static void newItem() {
        // initialize new instance of item with name, desc, and date
        Scanner in = new Scanner(System.in);
        String name, desc, date;

        System.out.print("Please enter the name of the item: ");
        name = in.next();
        System.out.print("Please enter the description of the item: ");
        desc = in.next();
        System.out.printf("Please enter the due date of %s: ", name);
        date = in.next();

        tasks.add(new Item(name, desc, date));

        System.out.println("Returning to main menu.");
    }

    private static void editItem(int pos) {
        /*
        if array is empty, exit user out, no way to edit a task
        if array size > 0, array.get(num-1).set<whatever>(newString)
         */
        Scanner in = new Scanner(System.in);
        String selection;
        
        if (tasks.size() == 0) {
            System.out.println("There is nothing to edit. Please add items.");
        } else if (pos < 0 || pos > tasks.size() + 1) {
            System.out.println("Chosen index is out of bounds.");
        } else {
            System.out.print("Press 1 for name, 2 for description, or 3 for due date: ");
            while (true) {
                if (in.hasNext()) {
                    selection = in.next();
                    if (selection.equalsIgnoreCase("1")) {
                        System.out.print("Enter new name: ");
                        tasks.get(pos-1).setName(in.next());
                        break;
                    } else if (selection.equalsIgnoreCase("2")) {
                        System.out.print("Enter new description: ");
                        tasks.get(pos-1).setDesc(in.next());
                        break;
                    } else if (selection.equalsIgnoreCase("3")) {
                        System.out.print("Enter new due date: ");
                        tasks.get(pos-1).setDueDate(in.next());
                        break;
                    } else {
                        System.out.print("Press 1 for name, 2 for description, or 3 for due date: ");
                    }
                }
            }
        }

        System.out.println("Returning to main menu.");
    }

    private static void deleteItem(int pos) {
        // delete item at position

        if (tasks.size() == 0) {
            System.out.println("There is nothing to delete. Please add items.");
        } else if (pos < 0 || pos > tasks.size() + 1) { // +1 or -1
            System.out.println("Chosen index is out of bounds.");
        } else {
            tasks.remove(pos - 1);
            System.out.printf("Deleted item %d.%n", pos);
        }

        System.out.println("Returning to main menu.");
    }

}
