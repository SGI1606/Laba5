package implementations;

import interfaces.Rabbit;

public class RabbitInit implements Rabbit {
    @Override
    public void doRabbitSound() {
        System.out.println("I am a rabbit");
    }
}
