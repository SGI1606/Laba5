import di.AutoInjectable;
import interfaces.Rabbit;
import interfaces.Fish;

public class SomeBean {
    @AutoInjectable
    private Rabbit rabbit;
    @AutoInjectable
    private Fish fish;

    public void foo(){
        rabbit.doRabbitSound();
        fish.doFishSound();
    }
}
