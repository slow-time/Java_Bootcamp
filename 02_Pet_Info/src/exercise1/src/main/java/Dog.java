public class Dog extends Animal {
    Dog(String name, Integer age){
        super(name, age);
    }
    @Override
    public String toString(){
        return "Dog name = " + getName() + ", age = " + getAge();
    }
}
