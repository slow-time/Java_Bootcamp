import java.util.NoSuchElementException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.util.Locale;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Ex7 {
    public static void main(String[] args) {
        System.out.println("Enter file path: ");
        Scanner scanner = new Scanner(System.in);
        String addr = new String();

        addr = scanner.nextLine().trim();
        File file = new File(addr);
        Scanner scanFile = null;
        try {
            scanFile = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println("Input error. File doesn't exist");
        }
        if (scanFile != null) {
            scanFile.useLocale(Locale.US);
            Array arr = new Array();

            if(scanLength(scanFile, arr)) {
                if(scanArray(scanFile, arr)) {
                    printNumbers(arr);
                    double minMax[] = minMax(arr);
                    newFile(minMax);

                }
            }
            scanFile.close();
        }
        scanner.close();
    }

    static boolean scanLength(Scanner sf, Array a) {
        boolean res = true;
        try {
            a.length = sf.nextInt();
        } catch (Exception e) {
            res = false;
        }
        if (a.length <= 0) {
            System.err.println("Input error. Size <= 0");
            res = false;
        }
        return res;
    }

    static boolean scanArray(Scanner sf, Array a){
        boolean res = true;
        a.arr = new double[a.length];
        for(int i = 0; i < a.length; i++){
            if(res) {
                try{
                    a.arr[i] = sf.nextDouble();
                } catch (InputMismatchException e){
                    i--;
                    sf.next();
                } catch (NoSuchElementException e){
                    System.err.println("Input error. Insufficient number of elements");
                    res = false;
                }
            }
        }
        return res;
    }

    static void printNumbers(Array a){
        System.out.println(a.length);
        for(int i = 0; i < a.length; i++){
            if( i != a.length - 1) {
                System.out.print(a.arr[i] + " ");
            } else {
                System.out.println(a.arr[i]);
            }
        }
        System.out.println("Saving min and max values in file");
    }

    static double[] minMax(Array a){
        double[] res = new double[2];
        res[0] = a.arr[0];
        res[1] = a.arr[0];
        for(int i = 0; i < a.length; i++){
            if(a.arr[i] < res[0]) {
                res[0] = a.arr[i];
            }
            if(a.arr[i] > res[1]){
                res[1] = a.arr[i];
            }
        }
        return res;
    }

    static void newFile(double[] mn){
        Path path = Paths.get("./src/main/resources/result.txt");
        try{
            Files.createFile(path);
            Files.writeString(path, String.valueOf(mn[0]) + " " + String.valueOf(mn[1]));

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

}

class Array {
    double []arr;
    int length;
}
