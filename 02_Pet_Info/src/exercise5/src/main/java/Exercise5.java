import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;
import java.util.stream.IntStream;
import java.util.InputMismatchException;


public class Exercise5 {
    public static void main(String[] args) {
        Long startTime = System.nanoTime();
        List<Animal> pets = input();
        walkPets(pets, startTime);
    }


    static void walkPets(List<Animal> p, Long startTime){
        p.stream()
                .forEach( pet -> {
                    Runnable walkPet = () -> {
                        Double startWalk = (System.nanoTime() - startTime) / 1_000_000_000.0;
                        Double endWalk = startWalk + pet.goToWalk();
                        System.out.print(pet.toString());
                        DecimalFormat df = new DecimalFormat("#0.00");
                        System.out.println(", start time = " + df.format(startWalk) + ", end time = " + df.format(endWalk));
                    };
                    Thread walk = new Thread(walkPet, "walk: " + pet);
                            walk.start();


                });
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
}





