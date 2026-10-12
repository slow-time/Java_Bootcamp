import java.util.List;

public class AnimalIterator implements BaseIterator<Animal>{
    private List<Animal> list;
    private Integer index;
    AnimalIterator(List<Animal> list){
        this.list = list;
        index = 0;
    }
    @Override
    public Animal next(){
        Animal animal = list.get(index);
        index++;
        return animal;
    }
    @Override
    public boolean hasNext(){
        return index < list.size();
    }
    @Override
    public void reset(){
        index = 0;
    }
}
