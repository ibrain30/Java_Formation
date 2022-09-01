import java.util.Random;
import java.util.Scanner;

public class Main {
    /**
     * Function Convert Int To String and separate String to Caraatere
     */
    public static char convertIntReturnChar(int entre, int position){
        String sEntre = String.valueOf(entre);
        return sEntre.charAt(position);
    }

    public static void main(String[] args) {

        // Scanner Declaration :
        Scanner scanner = new Scanner(System.in);

        System.out.println("<============= Bulls and Cows =============>");
        System.out.println("Bulls : correct code, correct position.\n" +
                           "Cows : correct code, wrong position =====> \n");

        // Generate hidden code with two digits
        Random random = new Random();
        int hiddenCode = random.nextInt(99);

        // Hidden code must superior 10
        if(hiddenCode < 10){
            hiddenCode += 10;
        }
        System.out.println("Hidden Code   :  " +  hiddenCode );

        /*
         * Convert the hidden code to string to manipulate this
         * Recuperates character hidden code
         * */
        char cHiddenCode1 = convertIntReturnChar(hiddenCode,0);
        char cHiddenCode2 = convertIntReturnChar(hiddenCode,1);

        int defineCode = 0;
        while(true) {
            // User enter code Guess
            do {
                System.out.println("Enter Code to guess  : ");
                defineCode = scanner.nextInt();
                if(defineCode < 10 || defineCode > 99){
                    System.out.println("Warning : Please enter code between [10 - 99 ] ");
                }
            }while(defineCode < 10 || defineCode > 99); // Control to input

            /*
             * Convert the defined code to string to manipulate this
             * Recuperates character defined code
             * */
            char cDefineCode1 = convertIntReturnChar(defineCode, 0);
            char cDefineCode2 = convertIntReturnChar(defineCode, 1);

            // Tests
            if (cHiddenCode1 == cDefineCode1 && cHiddenCode2 == cDefineCode2) {
                System.out.println("Bulls : 2 - Cows : 0 ");
                System.out.println("====> Congratulations   !!!! ");
                return; // To Quit the loop while

            } else if (cHiddenCode1 == cDefineCode2 && cHiddenCode2 == cDefineCode1) {

                System.out.println("Bulls : 0 - Cows : 2 ");

            } else {

                if (cHiddenCode1 == cDefineCode1 || cHiddenCode2 == cDefineCode2) {

                    System.out.println("Bulls : 1 - Cows : 0 ");

                } else if (cHiddenCode1 == cDefineCode2 || cHiddenCode2 == cDefineCode1) {

                    System.out.println("Bulls : 0 - Cows : 1 ");

                } else {
                    System.out.println("Bulls : 0 - Cows : 0 ");
                }
            }


        }

    }
}
