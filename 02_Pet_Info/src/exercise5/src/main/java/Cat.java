import java.util.concurrent.TimeUnit;

public
class Cat extends Animal{
    Cat(String name, Integer age){
        super(name, age);
    }
    @Override
    public String toString(){
        return "Cat name = " + getName() + ", age = " + getAge();
    }
    @Override
    public Double goToWalk(){
        try{
            TimeUnit.SECONDS.sleep((long) (getAge() * 0.25));
        } catch (InterruptedException e) {
            System.err.println("Error: " + e);
        }
        return getAge() * 0.25;
    }
}