import java.util.Locale;
import java.util.*;


public class Exercise3 {
    public static void main(String argv[]){
        List<Animal> pets = input();
        printPets(pets);
    }

    static void printPets(List<Animal> p){
        p.stream()
                .filter(pet -> pet instanceof Herbivore)
                .forEach(print ->
                        System.out.println(print.toString()));
        p.stream()
                .filter(pet -> pet instanceof Omnivore)
                .forEach(print ->
                        System.out.println(print.toString()));
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
                case "hamster": tmp = addHamster(scanner); break;
                case "guinea": tmp = addGuineaPig(scanner); break;
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
        return new Dog(name, age);
    }

    static Cat addCat(Scanner s){
        String name = s.nextLine();
        Integer age = inputNumber(s);
        if(age <= 0){
            System.err.println("Incorrect input. Age <= 0");
            return null;
        }
        return new Cat(name, age);
    }

    static Hamster addHamster(Scanner s){
        String name = s.nextLine();
        Integer age = inputNumber(s);
        if(age <= 0){
            System.err.println("Incorrect input. Age <= 0");
            return null;
        }
        return new Hamster(name, age);
    }

    static GuineaPig addGuineaPig(Scanner s){
        String name = s.nextLine();
        Integer age = inputNumber(s);
        if(age <= 0){
            System.err.println("Incorrect input. Age <= 0");
            return null;
        }
        return new GuineaPig(name, age);
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
}












