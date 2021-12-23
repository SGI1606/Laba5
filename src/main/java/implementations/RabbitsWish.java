package implementations;

import interfaces.Rabbit;

public class RabbitsWish implements Rabbit {
    @Override
    public void doRabbitSound() {
        System.out.println("Pryg pryg");
    }
}
