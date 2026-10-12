import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Ex8 {
    static public void main (String [] arg){
        System.out.println("Enter numbers: ");
        Scanner scanner = new Scanner(System.in);
        if(!scanNumber(scanner)) {
        System.out.println("YES");
        }
        scanner.close();
    }

    static boolean scanNumber(Scanner s) {
        int counter = 0;
        int number_one = 0, number_two;
        String line;
        line = s.nextLine();
        Scanner scanLine = new Scanner(line);
        boolean repeat = true, err = false;
        while (repeat) {
            try {
                if(counter == 0){
                    number_one = scanLine.nextInt();
                } else {
                    number_two = scanLine.nextInt();
                    repeat = checkNumb(number_one, number_two, counter);
                    err = !repeat;
                    number_one = number_two;
                }
            } catch (InputMismatchException e) {
                if (counter == 0) {
                    System.err.println("Input error");
                } else {
                    System.err.println("The sequence is ordered in ascending order");
                }
                repeat = false;
                err = true;
            } catch (NoSuchElementException e) {
                repeat = false;
            }
            counter++;
        }
        scanLine.close();
        return err;
    }
    static boolean checkNumb(int n1, int n2, int c){
        boolean res = true;
            if(n1 > n2) {
                System.out.println("The sequence is not ordered from the ordinal number of the number " + c);
                res = false;
            }
        return res;
    }
}
