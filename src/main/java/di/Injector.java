package di;

import implementations.RabbitInit;
import interfaces.Rabbit;
import org.reflections.Reflections;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Injector {
    private Reflections scanner = new Reflections();
    private final Properties properties = new Properties();

    private Injector() {
        File f = new File("src/main/resources/app.properties");
        try {
            properties.load(new FileReader(f));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Injector instance;

    public <T> T inject(T object) {
        for (Field f : object.getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(AutoInjectable.class) && f.getType().isInterface()) {
                Class<?> bean = null;
                try {
                    bean = Class.forName(properties.getProperty(f.getName()));
                    if(f.getType().isAssignableFrom(bean)){
                        f.setAccessible(true);
                        f.set(object, bean.getConstructor().newInstance());
                    }
                } catch (ClassNotFoundException | InvocationTargetException | IllegalAccessException | InstantiationException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        return object;
    }

    public static Injector getInstance() {
        if (instance == null) {
            instance = new Injector();
        }
        return instance;
    }
}
