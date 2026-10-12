import java.util.Scanner;
import java.util.Locale;
import java.util.InputMismatchException;
import java.text.DecimalFormat;

public class Ex6 {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        Array arr = new Array();
        System.out.println("Enter length: ");
        inputLength(scanner, arr);
        if (arr.length <= 0) {
            System.out.println("Input error. Size <= 0");
        } else {
            System.out.println("Enter numbers: ");
            inputArray(scanner, arr);
            sortArray(arr);
            printArray(arr);
        }
        scanner.close();
    }

    static void printArray(Array a){
        DecimalFormat d = new DecimalFormat("#.0#####");
        for(int i = 0; i < a.length; i++){
            if(i == a.length - 1) {
                System.out.println(d.format(a.arr[i]));
            } else {
                System.out.printf("%s ", d.format(a.arr[i]));
            }
        }
    }

    static void sortArray(Array a) {
        for(int i = 0; i < a.length; i++){
            double min = a.arr[i];
            int index = i;
            for(int j = i; j < a.length; j++){
                if(a.arr[j] < min){
                    min = a.arr[j];
                    index = j;
                }
            }
            swap(a, i, index);
        }
    }

    static void swap(Array a, int i1, int i2) {
        double tmp = a.arr[i1];
        a.arr[i1] = a.arr[i2];
        a.arr[i2] = tmp;
    }

    static void inputLength(Scanner s, Array a) {
        boolean err;
        do {
            try {
                a.length = s.nextInt();
                err = false;
            } catch (InputMismatchException e) {
                System.out.println("Could not parse a number. Please, try again");
                s.nextLine();
                err = true;
            }
        } while (err);
    }


    static void inputArray (Scanner s, Array a){
        a.arr = new double[a.length];
        boolean err = false;
        for(int i = 0; i < a.length; i++) {
            do {
                try {
                    a.arr[i] = s.nextDouble();
                        err = false;
                } catch (InputMismatchException e) {
                    System.out.println("Could not parse a number. Please, try again");
                    s.nextLine();
                    err = true;
                }
            } while (err);
        }
    }
}


class Array {
    double []arr;
    int length;
}
