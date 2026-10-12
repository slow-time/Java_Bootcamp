import java.lang.Double;
import java.util.*;

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
        scanner.useLocale(Locale.US);
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
        if(age <= 0){
            System.err.println("Incorrect input. Age <= 0");
            return null;
        }
        Double weight = inputMass(s);
        if (weight <= 0){
            System.err.println("Incorrect input. Mass <= 0");
            return null;
        }
            return new Dog(name, age, weight);
    }

    static Cat addCat(Scanner s){
        String name = s.nextLine();
        Integer age = inputNumber(s);
        if(age <= 0){
            System.err.println("Incorrect input. Age <= 0");
            return null;
        }
        Double weight = inputMass(s);
        if (weight <= 0){
            System.err.println("Incorrect input. Mass <= 0");
            return null;
        }
        return new Cat(name, age, weight);
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
            scanner.nextLine();
        } while(err_counter);
        return num;
    }

    static Double inputMass(Scanner scanner){
        Double num = null;
        boolean err_counter = false;
        do{
            try{
                num = scanner.nextDouble();
                err_counter = false;
            }catch(InputMismatchException e){
                System.out.println("Could not parse a number. Please, try again");
                err_counter = true;
            }
            scanner.nextLine();
        } while(err_counter);
        return num;
    }
}





