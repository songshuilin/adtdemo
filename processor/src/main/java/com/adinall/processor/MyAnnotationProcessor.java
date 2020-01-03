package com.adinall.processor;


import com.adinall.anno.MyAnno;
import com.google.auto.service.AutoService;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

/**
 * created by ： 游戏人日常
 * Date ： 2019/12/31
 * Desc ：
 */

@AutoService(Processor.class)
public class MyAnnotationProcessor extends AbstractProcessor {

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> supportTypes = new LinkedHashSet<>();
        supportTypes.add(MyAnno.class.getCanonicalName());
        return supportTypes;
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {


        MethodSpec methodSpec = MethodSpec.methodBuilder("getName")
                .addModifiers(Modifier.PUBLIC)
                .addParameter(String.class,"name")
                .addStatement("$T.out.print($S)", System.class,"Hello")
                .build();

        TypeSpec student = TypeSpec.classBuilder("Student")
                .addMethod(methodSpec)
                .addModifiers(Modifier.PUBLIC)
                .build();
        JavaFile javaFile = JavaFile.builder("com.apt.demo", student).build();
        try {
            javaFile.writeTo(processingEnv.getFiler());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
