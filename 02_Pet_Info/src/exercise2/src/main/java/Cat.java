import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Cat extends Animal{
    Cat(String name, Integer age, Double weight){
        super(name, age, weight);
    }
    @Override
    public Double getFeedInfoKg(){
        return getWeight() * 0.1;
    }
    public String toString(){
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("0.00", symbols);
        return "Cat name = " + getName() + ", age = " + getAge() + ", mass = " + df.format(getWeight()) + ", feed = " + df.format(getFeedInfoKg());
    }
}
