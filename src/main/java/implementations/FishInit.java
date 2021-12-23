package implementations;

import interfaces.Fish;

public class FishInit implements Fish {
    @Override
    public void doFishSound() {
        System.out.println("I am a fish");
    }
}
