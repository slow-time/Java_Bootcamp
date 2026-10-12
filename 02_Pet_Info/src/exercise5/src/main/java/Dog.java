import java.util.concurrent.TimeUnit;

public class Dog extends Animal {
    Dog(String name, Integer age){
        super(name, age);
    }
    @Override
    public String toString(){
        return "Dog name = " + getName() + ", age = " + getAge();
    }
    @Override
    public Double goToWalk(){
        try{
            TimeUnit.SECONDS.sleep((long)(getAge() * 0.5));
        } catch(InterruptedException e){
            System.err.println("Error: " + e);
        }
        return getAge() * 0.5;
    }
}