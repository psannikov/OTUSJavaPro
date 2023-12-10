package ru.otus.pro.psannikov.di.appcontainer;

import ru.otus.pro.psannikov.di.appcontainer.api.AppComponent;
import ru.otus.pro.psannikov.di.appcontainer.api.AppComponentsContainer;
import ru.otus.pro.psannikov.di.appcontainer.api.AppComponentsContainerConfig;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

public class AppComponentsContainerImpl implements AppComponentsContainer {

    private final List<Method> appComponents = new ArrayList<>();
    private final Map<String, Object> appComponentsByName = new HashMap<>();

    public AppComponentsContainerImpl(Class<?> initialConfigClass) throws Exception {
        processConfig(initialConfigClass);
    }

    private void processConfig(Class<?> configClass) throws Exception {
        checkConfigClass(configClass);
        checkDublicateAnnotationName(configClass);
        for (Method method : configClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(AppComponent.class)) {
                appComponents.add(method);
            }
        }
        for (int i = 0; i < appComponents.size(); i++) {
            for (Method method : appComponents) {
                if (method.getAnnotation(AppComponent.class).order() == i) {
                    Parameter[] params = method.getParameters();
                    List<Object> args = new ArrayList<>();
                    for (Parameter parameter : params) {
                        args.add(appComponentsByName.get(parameter.getType().getSimpleName().toLowerCase()));
                    }
                    Object[] argsArray = args.toArray();
                    var obj = method.invoke(configClass.newInstance(), argsArray);
                    appComponentsByName.put(method.getName().toLowerCase(), obj);
                }
            }
        }
    }

    private void checkConfigClass(Class<?> configClass) {
        if (!configClass.isAnnotationPresent(AppComponentsContainerConfig.class)) {
            throw new IllegalArgumentException(String.format("Given class is not config %s", configClass.getName()));
        }
    }

    private void checkDublicateAnnotationName(Class<?> configClass) throws Exception {
        List<Method> methodForCheck = new ArrayList<>();
        List<String> annotationNames = new ArrayList<>();
        for (Method method : configClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(AppComponent.class)) {
                if (annotationNames.contains(method.getAnnotation(AppComponent.class).name())) {
                    annotationNames.add(method.getAnnotation(AppComponent.class).name());
                } else {
                    throw new Exception("Dublicate annotation name exception");
                }
            }
        }
    }

    @Override
    public <C> C getAppComponent(Class<C> componentClass) throws Exception {
        var component = appComponentsByName.get(componentClass.getSimpleName().toLowerCase());
        if (component == null) {
            throw new Exception("Component not found");
        } else {
            return (C) component;
        }
    }

    @Override
    public <C> C getAppComponent(String componentName) throws Exception {
        var component = appComponentsByName.get(componentName.toLowerCase());
        if (component == null) {
            throw new Exception("Component not found");
        } else {
            return (C) component;
        }
    }
}
