import java.lang.Integer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.InputMismatchException;


public class Ex10 {
    public static void main(String[] args) {
        System.out.println("Enter number and users: ");
        Scanner scanner = new Scanner(System.in);
        Integer counter = null;
        try {
            counter = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        if(counter != null && counter >= 0){
            List<User> usersList = new ArrayList<>(counter);
            scanUsers(scanner,usersList, counter);
            printUsers(usersList);
        }
        scanner.close();
    }
    static void scanUsers(Scanner s, List<User> l, Integer c) {
        List<User> tmp = IntStream.range(0, c)
                .mapToObj(i -> new User())
                .collect(Collectors.toList());

        l.addAll(tmp);

       for(int i = 0; i < c; i++){
           try{
               l.get(i).name = s.nextLine();
               l.get(i).age = s.nextInt();
               if(l.get(i).age <= 0){
                   System.err.println("Incorrect input. Age <= 0");
                   i--;
               }
           } catch(InputMismatchException e){
               System.err.println("Could not parse a number. Please, try again");
               i--;
           }
           s.nextLine();
       }
    }
    static void printUsers(List<User> l){
        String result = l.stream()
                .filter(user -> user.age >= 18)
                .map(user -> user.name)
                .collect(Collectors.joining(", "));
        System.out.println(result);
    }
}
