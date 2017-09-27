import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Bartuś on 22.09.2017.
 */
public class Drink extends Meal {

    private Additives additives;

    public Additives getAdditives() {
        return additives;
    }

    public void setAdditives(Additives additives) {
        this.additives = additives;
    }

    public Drink(String name, Double price, Additives additives)  {
        super(name, price);
        this.additives=additives;
    }
    @Override
    public String toString() {
        return name + " " + price + "zł" + " " + additives;
    }

    public static String showDrinksList() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("menu/drinksMenu.txt"));
        List<String>drinksList= new LinkedList<String>();
        do {
            String line = scanner.nextLine();
            drinksList.add(line);
        } while (scanner.hasNext());
        System.out.println("\n");
        for(String line : drinksList){
            System.out.println(line);
        }
        System.out.println("\nChoose drink by pressing adequate number.");
        while(true){
            try {
                Scanner scanner2 = new Scanner(System.in);
                Integer choosenDrink = scanner2.nextInt();
                if(choosenDrink<1||choosenDrink>10){
                    System.out.println("You have pressed incorrect character. Try once again.");
                    continue;
                }
                String orderedDrink=drinksList.get(choosenDrink);
                return orderedDrink;
            } catch(InputMismatchException exception){
                System.out.println("You have pressed incorrect character. Try once again.");
            }
        }
    }

    public static int showAdditives(){
        System.out.println("\nAny additives to your drink?\n1 Ice cubes\n2 Lemon\n3 Ice cubes + Lemon\n4 No, thanks!");
        System.out.println("\nChoose additives by pressing adequate number.");
        while(true){
            try {
                Scanner scanner = new Scanner(System.in);
                Integer chosenAdditive = scanner.nextInt();
                if(chosenAdditive<1||chosenAdditive>4){
                    System.out.println("You have pressed incorrect character. Try once again.");
                    continue;
                }
                return chosenAdditive;
            } catch(InputMismatchException exception){
                System.out.println("You have pressed incorrect character. Try once again.");
            }
        }
    }
}
