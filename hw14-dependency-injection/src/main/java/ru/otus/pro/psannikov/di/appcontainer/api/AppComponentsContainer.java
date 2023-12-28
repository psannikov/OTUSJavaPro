package ru.otus.pro.psannikov.di.appcontainer.api;

public interface AppComponentsContainer {
    <C> C getAppComponent(Class<C> componentClass) throws Exception;

    <C> C getAppComponent(String componentName) throws Exception;
}
