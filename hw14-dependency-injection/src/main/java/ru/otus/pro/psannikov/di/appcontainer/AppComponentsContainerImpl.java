package ru.otus.pro.psannikov.di.appcontainer;

import ru.otus.pro.psannikov.di.appcontainer.api.AppComponent;
import ru.otus.pro.psannikov.di.appcontainer.api.AppComponentsContainer;
import ru.otus.pro.psannikov.di.appcontainer.api.AppComponentsContainerConfig;
import ru.otus.pro.psannikov.di.config.AppConfig;
import ru.otus.pro.psannikov.di.services.IOServiceStreams;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppComponentsContainerImpl implements AppComponentsContainer {

    private final List<Method> appComponents = new ArrayList<>();
    private final Map<String, Object> appComponentsByName = new HashMap<>();

    public AppComponentsContainerImpl(Class<?> initialConfigClass) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        processConfig(initialConfigClass);
    }

    private void processConfig(Class<?> configClass) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        checkConfigClass(configClass);
        for (Method method : configClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(AppComponent.class)) {
                appComponents.add(method);
            }
        }
        for (int i = 0; i < appComponents.size(); i++) {
            for (Method method : appComponents) {
                if (method.getAnnotation(AppComponent.class).order() == i) {
                    System.out.println("Сортирова " + method + " " + method.getAnnotation(AppComponent.class).order());
                    System.out.println("Метод " + method);
                    Parameter[] params = method.getParameters();
                    List<Object> args = new ArrayList<>();
                    for (Parameter parameter : params) {
                        args.add(appComponentsByName.get(parameter.getType().getSimpleName().toLowerCase()));
                    }
                    Object[] argsArray = args.toArray();
                    var obj = method.invoke(configClass.newInstance(), argsArray);
                    appComponentsByName.put(method.getName().toLowerCase(), obj);
                    System.out.println("Содержимое appComponentsByName " + appComponentsByName);
                }

            }
            System.out.println("=".repeat(30));
        }
        System.out.println("appComponentsByName содержит элементов " + appComponentsByName.size());
        System.out.println(appComponentsByName);
    }

    private void checkConfigClass(Class<?> configClass) {
        if (!configClass.isAnnotationPresent(AppComponentsContainerConfig.class)) {
            throw new IllegalArgumentException(String.format("Given class is not config %s", configClass.getName()));
        }
    }

    @Override
    public <C> C getAppComponent(Class<C> componentClass) {
        System.out.println("Вызов метода getAppComponent(Class<C> componentClass)");
        return (C) appComponentsByName.get(componentClass.getSimpleName().toLowerCase());
    }

    @Override
    public <C> C getAppComponent(String componentName) {
        System.out.println("Вызов метода getAppComponent(String componentName)");
        return null;
    }
}