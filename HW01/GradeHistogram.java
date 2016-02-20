import java.util.Scanner;
import java.io.File;
//import java.io.FileNotFoundException;

public class GradeHistogram {
    public static void main(String[] args) throws Exception {
        Scanner s2 = new Scanner(new File(args[0]));
        int numberofLines = 0;
        /*Find out the number of lines to create the array of desired size*/
        while (s2.hasNext()) {
            String lines = s2.nextLine();
            numberofLines++;
        }
        int[] myArray = new int[numberofLines];
        int j = 0;

        /*Split the grades from the name and place it in the array*/
        Scanner s1 = new Scanner(new File(args[0]));
        while (s1.hasNext()) {
            String grade =  s1.nextLine().split(",")[1].trim();
            myArray[j] = Integer.parseInt(grade);
            j++;
        }
        //Ask the user for the interval size
        Scanner input = new Scanner(System.in);
        int interval;
        if (args.length == 1) {
            System.out.println("What interval size would you like? ");
            System.out.print(">>> ");
            String tempHolder = input.nextLine();
            interval = Integer.parseInt(tempHolder);
        } else {
            interval = Integer.parseInt(args[1]);
        }

        for (int i = 100; i > 0; i -= interval) {
            int firstNumber = i;
            int secondNumber = i - (interval - 1);

            if (secondNumber < 0) {
                secondNumber = 0;
            }

            System.out.printf("%3d - %3d |", firstNumber, secondNumber);

            for (int x : myArray) {
                if (x <= firstNumber && x >= secondNumber) {
                    System.out.print("[]");
                }
            }
            System.out.print("\n");
        }

        int la = 100 % interval;
        if (la == 0) {
            int fir = 0;
            int sec = 0;
            System.out.printf("%3d - %3d |", fir, sec);

            for (int y : myArray) {
                if (y == 0) {
                    System.out.print("[]");
                }
            }
            System.out.print("\n");
        }
    }
}