package PA_PolymorphismAndInheritance;

public class StoneMonster extends Monster {
    String power = "stones!";
    public StoneMonster(String name){
        super(name);
    }
    @Override
    public String attack(){
       return "Attack with " + power;
    }
}
