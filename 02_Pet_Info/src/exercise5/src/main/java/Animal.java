public abstract class Animal{
    private String name;
    private Integer age;
    Animal(String name, Integer age){
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public Integer getAge(){
        return age;
    }
    abstract public String toString();
    abstract public Double goToWalk();
}
