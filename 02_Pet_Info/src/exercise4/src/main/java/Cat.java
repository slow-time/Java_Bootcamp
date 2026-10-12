public class Cat extends Animal{
    Cat(String name, Integer age){
        super(name, age);
    }
    @Override
    public String toString(){
        return "Cat name = " + getName() + ", age = " + getAge();
    }
}
