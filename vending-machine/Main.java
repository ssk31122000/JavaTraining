import java.util.Scanner;

public class Main {

    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("\t************************************************");
        System.out.println("\t             WELCOME TO JAVA DRINKS!            ");
        System.out.println("\t************************************************");
        
        Item[][] items = new Item[][] {
            { new Item("Pepsi", 1.99, 3) , new Item("Fresca", 1.49, 3), new Item("Brisk", 2.49, 2) },
            { new Item("Fanta", 1.99, 2) , new Item("Barq's", 1.49, 2), new Item("A & W", 2.49, 3) },
            { new Item("Crush", 1.99, 2) , new Item("C-Cola", 1.49, 2), new Item("Berry", 2.49, 1) }
        };
        
        Machine machine = new Machine(items);
        System.out.print(machine);

        String next="1";
        int row;
        int spot;
        while(next.equals("1")){
            System.out.print("\nPick a row: ");
            row=scan.nextInt();
            System.out.print("\nPick a spot: ");
            spot=scan.nextInt();

            if(machine.dispense(row, spot)){
                System.out.print("\n" + machine);
                System.out.print("\nEnjoy your drink! Press 1 to purchase another: ");
            }else{
                System.out.print("\n" + machine);
                System.out.print("\nSorry, we're out of this item. Press 1 to purchase another: ");
            }

            next=scan.next();
        }

        scan.close();
    }
}
