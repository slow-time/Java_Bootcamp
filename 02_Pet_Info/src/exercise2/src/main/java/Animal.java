public abstract class Animal{
    private String name;
    private Integer age;
    private Double weight;
    Animal (String name, Integer age, Double weight){
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
    public String getName(){
        return name;
    }
    public Integer getAge(){
        return age;
    }
    public Double getWeight(){
        return weight;
    }
    abstract public Double getFeedInfoKg();
    abstract public String toString();
}
