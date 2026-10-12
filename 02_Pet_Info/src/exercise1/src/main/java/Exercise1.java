import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;

public class Exercise1 {
    public static void main(String argv[]){
        List<Animal> pets = input();
        printPets(pets);
    }

    static void printPets(List<Animal> p){
        for(Animal pet : p){
            System.out.println(pet.toString());
        }
    }

    static List<Animal> input(){
        Scanner scanner = new Scanner(System.in);
        List<Animal> pets = new ArrayList<>();
        Integer counter = inputNumber(scanner);
        for(int i = 0; i < counter; i++) {
            String pet = scanner.nextLine();
            Animal tmp = null;
                switch(pet){
                    case "dog": tmp = addDog(scanner); break;
                    case "cat": tmp = addCat(scanner); break;
                    default: System.err.println("Incorrect input. Unsupported pet type");
                }
                if (tmp != null){
                    pets.add(tmp);
                }
        }
        scanner.close();
        return pets;
    }

    static Dog addDog(Scanner s){
        String name = s.nextLine();
        Integer age = inputNumber(s);
        Dog d = null;
        if(age > 0){
            d = new Dog(name, age);
        } else {
            System.err.println("Incorrect input. Age <= 0");
        }
        return d;
    }

    static Cat addCat(Scanner s){
        String name = s.nextLine();
        Integer age = inputNumber(s);
        Cat c = null;
        if(age > 0){
            c = new Cat(name, age);
        } else {
            System.err.println("Incorrect input. Age <= 0");
        }
        return c;
    }

    static Integer inputNumber(Scanner scanner){
        Integer num = null;
        boolean err_counter = false;
        do{
            try{
                num = scanner.nextInt();
                err_counter = false;
            }catch(InputMismatchException e){
                System.out.println("Could not parse a number. Please, try again");
                err_counter = true;
            }
        } while(err_counter);
        scanner.nextLine();
        return num;
    }

}





