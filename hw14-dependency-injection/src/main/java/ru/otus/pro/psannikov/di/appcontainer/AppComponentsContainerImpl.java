package ru.otus.pro.psannikov.di.appcontainer;

import ru.otus.pro.psannikov.di.appcontainer.api.AppComponent;
import ru.otus.pro.psannikov.di.appcontainer.api.AppComponentsContainer;
import ru.otus.pro.psannikov.di.appcontainer.api.AppComponentsContainerConfig;

import java.lang.reflect.Method;
import java.util.*;

public class AppComponentsContainerImpl implements AppComponentsContainer {

    private final List<Method> appComponents = new ArrayList<>();
    private final Map<String, Object> appComponentsByName = new HashMap<>();

    public AppComponentsContainerImpl(Class<?> initialConfigClass) {
        processConfig(initialConfigClass);
    }

    private void processConfig(Class<?> configClass) {
        checkConfigClass(configClass);
        for (Method method : configClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(AppComponent.class)) {
                appComponents.add(method);
//                appComponentsByName.put(method.getAnnotation(AppComponent.class).name().toLowerCase(), method);
            }
        }
        for (int i = 0; i < appComponents.size(); i++) {
            for (Method method : appComponents) {
                if (method.getAnnotation(AppComponent.class).order() == i) {
                    System.out.println("i="+ i+ " method " + method);
                    try {
                        // Если метод принимает аргументы, то получаем их значения из других компонентов, помеченных аннотацией @AppComponent
                        Object[] args = Arrays.stream(method.getParameters())
                                .map(parameter -> {
                                    if (parameter.isAnnotationPresent(AppComponent.class)) {
                                        String componentName = parameter.getAnnotation(AppComponent.class).name();
                                        return appComponents.stream()
                                                .filter(m -> m.isAnnotationPresent(AppComponent.class))
                                                .filter(m -> m.getAnnotation(AppComponent.class).name().equals(componentName))
                                                .findFirst()
                                                .map(m -> {
                                                    try {
                                                        System.out.println("configClass.newInstance()" + method);
                                                        return m.invoke(configClass.newInstance());
                                                    } catch (Exception e) {
                                                        throw new RuntimeException("Error invoking method " + m.getName(), e);
                                                    }
                                                })
                                                .orElseThrow(() -> new RuntimeException("Component " + componentName + " not found"));
                                    } else {
                                        return null;
                                    }
                                })
                                .toArray();
//                        System.out.println(args);
                        appComponentsByName.put(method.getAnnotation(AppComponent.class).name().toLowerCase(),method.invoke(configClass.newInstance(), args));
                        System.out.println("Вызов метода " + method);
                    } catch (Exception e) {
                        throw new RuntimeException("Error invoking method " + method.getName(), e);
                    }
                }
            }
        }
    }

    private void checkConfigClass(Class<?> configClass) {
        if (!configClass.isAnnotationPresent(AppComponentsContainerConfig.class)) {
            throw new IllegalArgumentException(String.format("Given class is not config %s", configClass.getName()));
        }
    }

    @Override
    public <C> C getAppComponent(Class<C> componentClass) {
        System.out.println(appComponentsByName.keySet());
        System.out.println(componentClass.getSimpleName());
        System.out.println(appComponentsByName.get(componentClass.getSimpleName().toLowerCase()));
        return (C) appComponentsByName.get(componentClass.getSimpleName().toLowerCase());
    }

    @Override
    public <C> C getAppComponent(String componentName) {
        return null;
    }
}
