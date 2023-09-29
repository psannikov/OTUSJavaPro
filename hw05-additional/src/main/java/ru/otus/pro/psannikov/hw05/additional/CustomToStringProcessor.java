package ru.otus.pro.psannikov.hw05.additional;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;
import java.util.Set;

@SupportedAnnotationTypes("ru.otus.pro.psannikov.hw05.additional.CustomToString")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class CustomToStringProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(CustomToString.class)) {
            if (element.getKind() == ElementKind.CLASS) {
                generateToString((TypeElement) element);
            }
        }
        return true;
    }

    private void generateToString(TypeElement element) {
        // Extract necessary information about the class
        String className = element.getSimpleName().toString();
        String packageName = getPackageName(element);

        // Create the source code for the toString() method
        String source = generateToStringSource(className);

        // Get a filer to create a new source file
        Filer filer = processingEnv.getFiler();
        try {
            JavaFileObject fileObject = filer.createSourceFile(packageName + "." + className + "ToString");
            try (Writer writer = fileObject.openWriter()) {
                writer.write(source);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getPackageName(TypeElement typeElement) {
        Element enclosingElement = typeElement.getEnclosingElement();
        if (enclosingElement.getKind() == ElementKind.PACKAGE) {
            return ((PackageElement) enclosingElement).getQualifiedName().toString();
        }
        return "";
    }

    private String generateToStringSource(String className) {
        return "package com.yourpackage;\n\n" +
                "public class " + className + "ToString {\n" +
                "    @Override\n" +
                "    public String toString() {\n" +
                "        // Generate your custom toString logic here\n" +
                "        return \"Custom toString for " + className + "\";\n" +
                "    }\n" +
                "}\n";
    }
}

