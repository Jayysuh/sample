package PA_PolymorphismAndInheritance;

public class FireMonster extends Monster {
    String power = "fire!";
    public FireMonster(String name){
        super(name);
    }
    @Override
    public String attack(){
        return "Attack with " + power;
    }
}
