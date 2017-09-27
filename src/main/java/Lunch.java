import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Bartuś on 22.09.2017.
 */
public class Lunch extends Meal {


    public Lunch(String name, Double price) {
        super(name, price);

    }

    public static String getLunchLine(Integer chosenLunch, List<String> menuList) {
        String chosenLunchString = chosenLunch.toString();
        for (String lunch : menuList) {
            if (lunch.contains(chosenLunchString + " ") == true) return lunch;
        }
        return null;
    }

    public static String showDessertMenu() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("menu/dessertsMenu.txt"));
        List<String> menuList = new ArrayList<String>();

        do {
            String line = scanner.nextLine();
            menuList.add(line);
        }
        while (scanner.hasNext());
        System.out.println();
        for (String dessert : menuList) {
            System.out.println(dessert);
        }
        System.out.println("\nChoose dessert by pressing adequate number.");
        while (true) {
                try {
                    Scanner scanner2 = new Scanner(System.in);
                    Integer chosenDessert = scanner2.nextInt();
                    if(1>chosenDessert||chosenDessert>10){
                        System.out.println("You have pressed incorrect character. Try once again.");
                        continue;
                    }
                    return menuList.get(chosenDessert);
                } catch (InputMismatchException exception) {
                    System.out.println("You have pressed incorrect character. Try once again.");
                }
        }
    }

    public static String showLunchMenu() throws FileNotFoundException {
        List<String> menuList = new ArrayList<String>();
        File[] fileArray = new File("menu/MainCourses").listFiles();
        System.out.println("\n");
        System.out.println("        ---> Main Courses Menu <---");
        System.out.println("\n");
        for (File file : fileArray) {
            Scanner scanner = new Scanner(file);
            do {
                String line = scanner.nextLine();
                menuList.add(line);
            } while (scanner.hasNext());
            menuList.add("\n");
            ;
        }
        for (String line : menuList) {
            System.out.println(line);
        }
        System.out.println("Choose main course by pressing adequate number.");
        while (true) {
                try {
                    Scanner scanner2 = new Scanner(System.in);
                    Integer chosenMainCourse = scanner2.nextInt();
                    if(chosenMainCourse<1||chosenMainCourse>30){
                        System.out.println("You have pressed incorrect character. Try once again.");
                        continue;
                    }
                    return getLunchLine(chosenMainCourse, menuList);
                } catch (InputMismatchException exception) {
                    System.out.println("You have pressed incorrect character. Try once again.");
                }
        }
    }
}
