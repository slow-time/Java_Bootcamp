import java.util.Scanner;
import java.util.InputMismatchException;

public class Ex5 {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        Array arr = new Array();
        System.out.println("Enter length: ");
        inputLength(scanner, arr);
        if(arr.length <= 0){
            System.out.println("Input error. Size <= 0");
        } else {
            System.out.println("Enter numbers: ");
            inputArray(scanner, arr);
            if(arr.newLength != 0) {
                printArray(arr);
            } else {
                System.out.println("There are no such elements");
            }
        }
        scanner.close();
    }

    static void printArray(Array a) {
        for(int i = 0; i < a.newLength; i++){
            if (i == a.newLength - 1){
                System.out.println(a.newArr[i]);
            } else {
                System.out.printf("%d ", a.newArr[i]);
            }
        }
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
    a.arr = new int[a.length];
    a.newArr = new int[a.length];
    boolean err = false;
            for(int i = 0, j = 0; i < a.length; i++) {
                do {
                    try {
                        a.arr[i] = s.nextInt();
                        if(checkNumber(a.arr[i])) {
                            a.newArr[j] = a.arr[i];
                            a.newLength++;
                            j++;
                            err = false;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Could not parse a number. Please, try again");
                        s.nextLine();
                        err = true;
                    }
                } while (err);
            }
}

static boolean checkNumber(int n){
        n = Math.abs(n);
        boolean result = false;
        if (n < 10) {
            result = true;
        } else {
            int last = n % 10;
            while (n > 9) {
                n /= 10;
            }
            if(n == last) {
                result = true;
            }
        }
    return result;
}

}


class Array {
    int []arr;
    int []newArr;
    int length;
    int newLength;
}
