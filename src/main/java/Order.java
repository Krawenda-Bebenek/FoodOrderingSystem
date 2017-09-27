import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Bartuś on 22.09.2017.
 */
public class Order {


    private static List<Meal>order = new ArrayList<Meal>();
    private static Double orderPrice = 0.00;

    public Order() {
        this.order = order;
    }

    public List<Meal> getOrder() {
        return order;
    }

    public void setOrder(List<Meal> order) {
        this.order = order;
    }

    public static void addDessertToOrder(String chosenDessertString){
        String[] spliTable = chosenDessertString.split(" ");
        String name="";
        for(int i=1; i<spliTable.length-1; i++){
            name += spliTable[i] + " ";
        };
        Double price = Double.parseDouble(spliTable[spliTable.length-1]);
        Lunch dessert = new Lunch(name,price);
        order.add(dessert);
        orderPrice=orderPrice+dessert.getPrice();
        System.out.println("Dessert has been added to your order.");

    }

    public static void addDrinkToOrder(String chosenDrink, Integer add){
        String[] spliTable = chosenDrink.split(" ");
        String name="";
        for(int i=1; i<spliTable.length-1; i++){
            name += spliTable[i] + " ";
        };
        Double price = Double.parseDouble(spliTable[spliTable.length-1]);
        Drink drink = new Drink(name,price,Additives.fromInteger(add));
        order.add(drink);
        orderPrice=orderPrice+drink.getPrice();
        System.out.println("Drink has been added to your order.");
    }

    public static void addLunchToOrder(String chosenLunchString) {
        String[] spliTable = chosenLunchString.split(" ");
        String name="";
        for(int i=1; i<spliTable.length-1; i++){
            name += spliTable[i] + " ";
        };
        Double price = Double.parseDouble(spliTable[spliTable.length-1]);
        Lunch lunch = new Lunch(name,price);
        order.add(lunch);
        orderPrice=orderPrice+lunch.getPrice();
        System.out.println("Main course has been added to your order.");
    }

    public static void showMyOrder(){
        System.out.println();
        System.out.println("------------ Your order contains: -----------");
        for(Meal meal : order){
            System.out.println(meal.toString());
        }
        System.out.println("TOTAL: "+orderPrice+"zł");
        System.out.println("\n");
    }

    public static void createNewOrder() throws FileNotFoundException {
        System.out.println();
        System.out.println("Welcome in our restaurant! Let's start your order.\nChoose by pressing adequate number.\n");
        int chosenNumber=0;
        while (true){
            System.out.println("\n...........What do you want to do?..........");
            System.out.println(" 1. Add to my order\n 2. Show my order\n 3. Submit my order \n 4. Exit");
            while(true) {
                try{
                Scanner scanner1 = new Scanner(System.in);
                chosenNumber = scanner1.nextInt();
                break;
            } catch(InputMismatchException exception){
                    System.out.println("You have pressed incorrect character. Try once again.");
                }
            }

        switch(chosenNumber){
            case 1: System.out.println("\n.............What do u want do order?.............\n 1. Lunch (main course + dessert) \n 2. Drink \n 3. Back to main menu");
                    int chosenNumber1=0;
                    while(true) {
                        try{
                            Scanner scanner = new Scanner(System.in);
                            chosenNumber1=scanner.nextInt();
                            break;
                        } catch(InputMismatchException exception){
                            System.out.println("You have pressed incorrect character. Try once again.");
                        }
                }
                    switch(chosenNumber1){
                    case 1: addLunchToOrder(Lunch.showLunchMenu());
                            addDessertToOrder(Lunch.showDessertMenu());
                            break;
                    case 2: String chosenDrink = Drink.showDrinksList();
                            Integer chosenAdditives = Drink.showAdditives();
                            addDrinkToOrder(chosenDrink,chosenAdditives);
                            break;
                    case 3: break;
                    }
                    break;
            case 2: showMyOrder();
                    break;
            case 3: showMyOrder();
                    System.out.println("----- Are you ready to submit your order? ----\n 1. Submit \n 2. Back to main menu");
                    int chosenNumber2=0;
                    while(true) {
                        try{
                            Scanner scanner = new Scanner(System.in);
                            chosenNumber2=scanner.nextInt();
                            break;
                        } catch(InputMismatchException exception){
                            System.out.println("You have pressed incorrect character. Try once again.");
                        }
                        }
                    switch(chosenNumber2){
                     case 1: System.out.println("You have finished your order. We are preparing your food. Thank you for using Food Ordering System.\nGOODBYE!");
                             System.exit(0);
                     case 2: break;
                     default: System.out.println("You have pressed incorrect character. Try once again.");
                              break;
                    }
                    break;
            case 4: System.out.println("Thanks for visiting us! Goodbye!");
                    System.exit(0);
            default: System.out.println("You have pressed incorrect character. Try once again.");
                break;
        }


}}}
