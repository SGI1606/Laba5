import di.Injector;

public class Main {

    public static void main(String[] args) {
        SomeBean sb = Injector.getInstance().inject(new SomeBean());
        sb.foo();
    }
}
