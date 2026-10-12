import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.lang.Integer;

public class Ex9 {
    public static void main(String[] args) {
        System.out.println("Enter number, strings and substring: ");
        Scanner scanner = new Scanner(System.in);
        StringList myList = new StringList();
        if(scanLength(scanner, myList) && scanStrings(scanner, myList) && scanSubstring(scanner, myList)) {
           List<String> result = findSubstring(myList);
           printList(result);
        }
        scanner.close();
    }
    static boolean scanLength(Scanner s, StringList m){
        boolean res = true;
        try{
            m.i = s.nextInt();
        } catch (Exception e){
            System.err.println("Error: " + e);
            res = false;
        }
        s.nextLine();
        return res;
    }
    static boolean scanStrings(Scanner s, StringList m){
        boolean res = true;
        m.l = new ArrayList<>();
        for(int i = 0; i < m.i; i++){
            try{
                m.l.add(s.nextLine());
            } catch (Exception e){
                System.err.println("Error: " + e);
                res = false;
            }
        }
        return res;
    }
    static boolean scanSubstring(Scanner s, StringList m){
        boolean res = true;
        try{
            m.s = s.nextLine();
        } catch (Exception e){
            System.err.println("Error: " + e);
            res = false;
        }
        return  res;
    }
    static List<String> findSubstring(StringList m){
        List<String> res = new ArrayList<>();
        for(String element : m.l){
            if(element.indexOf(m.s) != -1) {
                res.add(element);
            }
        }

        return res;
    }

    static void printList(List<String> s){
        boolean first = true;
        for(String element : s){
            if(!first) {
                System.out.print(", ");
            }
            System.out.print(element);
            first = false;
        }
        System.out.printf("\n");
    }
}

class StringList {
    Integer i;
    String s;
    List<String> l;
}
