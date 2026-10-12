import java.util.Scanner;

public class Ex3 {

    public static void main(String[] arg) {
        System.out.println("Enter n number Fibonacci:");
        Scanner scanner = new Scanner(System.in);
        boolean err;
        int input = 0;
        do {
            err = false;
            try{
                input = scanner.nextInt();
            } catch(Exception e) {
                System.out.println("Could not parse a number. Please, try again");
                scanner.nextLine();
                err = true;
            }
        } while (err);

        if (input > 46) {
            System.out.println("Too large n");
        } else {
            int res = calculeteFibonachi(input);
            System.out.println(res);
        }
        scanner.close();
    }



    static int calculeteFibonachi(int n) {
        int res = 0;
        if(n == 1) {
            res = 1;
        } else if (n > 1) {
            res = Math.addExact(calculeteFibonachi(n - 1), calculeteFibonachi(n - 2));
        }
        return res;
    }
}


