import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.util.InputMismatchException;
import java.util.stream.IntStream;

public class Exercise4 {
    public static void main(String argv[]){
        List<Animal> pets = input();
        pets = checkAge(pets);
        printPets(pets);
    }

    static void printPets(List<Animal> p){
        p.stream()
                .forEach(print ->
                        System.out.println(print.toString()));
    }

    static List<Animal> input(){
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        List<Animal> pets = new ArrayList<>();
        Integer counter = inputNumber(scanner);
        IntStream.range(0, counter)
                .forEach(ignore -> {
                            String pet = scanner.nextLine();
                            Animal tmp = null;
                            switch (pet) {
                                case "dog":
                                    tmp = addDog(scanner);
                                    break;
                                case "cat":
                                    tmp = addCat(scanner);
                                    break;
                                default:
                                    System.err.println("Incorrect input. Unsupported pet type");
                            }
                            if (tmp != null) {
                                pets.add(tmp);
                            }
                        }
                );

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

    static List<Animal> checkAge(List<Animal> pets){
        List<Animal> result = new ArrayList<>();
        pets.stream()
                .forEach(pet -> {
                    Integer age = pet.getAge();
                    if (pet.getAge() > 10){
                        age += 1;
                    }
                    if(pet instanceof Cat){
                        result.add(new Cat(pet.getName(), age));
                    } else {
                        result.add(new Dog(pet.getName(), age));
                    }
                });
        return result;
    }
}








