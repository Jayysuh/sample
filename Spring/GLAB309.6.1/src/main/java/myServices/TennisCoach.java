package myServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


/*Here, we have a constructor in our class for injections, so our
“TennisCoach” will simply add a constructor, and then we pass in our
dependency (FortuneService).
*/
@Component
public class TennisCoach implements Coach {
   /*(Constructor-Based Injection using @Autowired Annotation:)

   private FortuneServices fortuneService;

    public TennisCoach() {
    //default contructor
    }

    /* @Autowired: we are indicating that we intended Spring boot to
    automatically wire this component based on the argument that is
    supplied to FortuneService*/

    /*
    @Autowired
    public TennisCoach(FortuneServices theFortuneService) {
        fortuneService = theFortuneService;
    }*/

    //(Field/Property base injection using @Autowired annotation)
  /*  @Autowired
    private FortuneServices fortuneService;
    public TennisCoach(FortuneServices theFortuneService){
        fortuneService = theFortuneService;
    }*/

    /*In the above code, the variable fortuneService is private, but Spring
will still set this value behind the scenes. The first thing Spring will construct
is the class by calling the default constructor. Then it will actually inject a
FortuneService implementation directly into this class, making use of some
Java technology called Reflection; it all happens behind the scenes for
you.*/

    /*@Autowired
    @Qualifier("randomFortuneService")
    private FortuneServices fortuneService;*/

    @Autowired
    @Qualifier("databaseFortuneService")
    private FortuneServices fortuneService;

    public TennisCoach(){}

    public TennisCoach(FortuneServices theFortuneService){
        fortuneService = theFortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

}