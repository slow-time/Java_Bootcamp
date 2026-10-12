import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    Array arr = new Array();
    boolean err;
    inputLength(scanner, arr);
    if (arr.length <= 0) {
        System.out.println("Input error. Size <= 0");
    } else {
        inputArray(scanner, arr);
        if(average(arr)){
            System.out.println(arr.average);
        } else {
            System.out.println("There are no negative elements");
        }
    }
    scanner.close();
    }

    static void inputLength(Scanner scanner, Array arr){
        System.out.println("Enter length:");
        boolean err;
        do {
            err = false;
            try {
                arr.length = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Could not parse a number. Please, try again");
                scanner.nextLine();
                err = true;
            }
        } while (err);
    }

    static void inputArray(Scanner scanner, Array arr){
        System.out.println("Enter numbers:");
        arr.array = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
                try {
                    arr.array[i] = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Could not parse a number. Please, try again");
                    i--;
                    scanner.nextLine();
                }
        }
        scanner.nextLine();
    }


    static boolean average(Array arr) {
        boolean res = false;
        int counter = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr.array[i] < 0) {
                arr.average += arr.array[i];
                res = true;
                counter++;
            }
        }
        if(res) {
            arr.average /= counter;
        }
        return res;
    }
}

class Array {
    int length;
    int array[];
    int average;
}