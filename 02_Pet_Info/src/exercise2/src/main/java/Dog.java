import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Dog extends Animal {
    Dog(String name, Integer age, Double weight){
        super(name, age, weight);
    }
    @Override
    public Double getFeedInfoKg(){
        return getWeight() * 0.3;
    }
    @Override
    public String toString(){
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("0.00", symbols);
        return "Dog name = " + getName() + ", age = " + getAge() + ", mass = " + df.format(getWeight()) + ", feed = " + df.format(getFeedInfoKg());
    }
}
