package PA_PolymorphismAndInheritance;

public class WaterMonster extends Monster{
    String power = "water!";
    public WaterMonster(String name){
        super(name);
    }
    @Override
    public String attack(){
        return "Attack with " + power;
    }
}
