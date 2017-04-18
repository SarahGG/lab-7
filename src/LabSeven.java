import java.util.InputMismatchException;
import java.util.Scanner;

public class LabSeven {
    private static boolean doAgain;
    private static Scanner scnr = new Scanner(System.in);

    public static void main(String[] args) {
        String[][] students = {
                {"Marin", "Bizbiqi", "marinib"}, {"Megan", "Boczar", "mlboczar"},
                {"Allie", "Born", "allieborn"}, {"Stephanie", "Broadwell", "broadwells"},
                {"Trina", "Chowdhury", "trinini93"}, {"Lhea", "Copeland", "LheaJCopeland"},
                {"Sean", "Dunn", "Seandunn92"}, {"Sarah", "Guarino", "SarahGG"},
                {"Saritha", "Karunanithi", "Saritha06"}, {"Nick", "Katsarelas", "nickkatz22"},
                {"Lydia", "Latocki", "LydiaLab"}, {"Michael", "Riley", "mlriley77"},
                {"Peter", "Setianwan", "peterpreneur"}, {"Jeremy", "Villa", "jvilla1991"}
        };
        int MIN_STUDENTS = 1;
        int MAX_STUDENTS = students.length;
        int num;

        // this do .. while prompts for input, validates, and then stores it if it's a good value
        do {
            System.out.printf("Please enter a number between %d and %d: ", MIN_STUDENTS, MAX_STUDENTS);
            try {
                num = scnr.nextInt();
                System.out.printf("Student %d: %s %s\n\t GitHub: %s\n\n",
                        num,
                        students[num][0],
                        students[num][1],
                        students[num][2]);

            } catch(InputMismatchException notANumber) {
                System.out.println("Incorrect input.");
                scnr.next();
            } catch(ArrayIndexOutOfBoundsException notInRange) {
                System.out.println("That number is just no good.");
            }

            getPermission();
        } while (doAgain);
    }
    private static void getPermission() {
        boolean correctInput;
        char userContinueCheck;

        do {
            // collects input the first character (a-z regardless of case)
            // switches to lowercase
            System.out.print("Would you like to continue? (y/n): ");
            userContinueCheck = Character.toLowerCase(scnr.next().charAt(0));

            if (userContinueCheck == 'y') {
                correctInput = true;
                doAgain = true;
            }
            else if (userContinueCheck == 'n') {
                correctInput = true;
                doAgain = false;
            }
            else {
                System.out.println("Incorrect input.\n");
                correctInput = false;
            }
            System.out.println("");
        }
        // only repeats if user input y or n
        while(!correctInput);
    }
}
