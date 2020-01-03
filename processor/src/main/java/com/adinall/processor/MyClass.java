package com.adinall.processor;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.lang.model.element.Modifier;

public class MyClass {

    public static void main(String[] args) throws Exception {
        ClassName namedBoards = ClassName.get("com.mattel", "Hoverboard", "Boards");

        MethodSpec methodSpec = MethodSpec.methodBuilder("main")
                .returns(int.class)
                .addStatement("int result = 0")
                .beginControlFlow("for (int i = $S; i < $L; i++)", "22", 3)
                .addStatement("result = result $L i", 3)
                .endControlFlow()
                .addStatement("return result")
                .build();

        FieldSpec fieldSpec =FieldSpec.builder(String.class,"name",Modifier.STATIC,Modifier.FINAL)
                .initializer("3333").build();

        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addField(String.class,"name",Modifier.PUBLIC,Modifier.FINAL,Modifier.STATIC)
                .addMethod(methodSpec)
                .build();

        JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld)
                .addStaticImport(namedBoards, "*")
                .build();

        File file = new File(MyClass.class.getClass().getResource("/").getPath());

        System.out.println(MyClass.class.getClass().getResource("/").getPath());

        javaFile.writeTo(file);
    }
}
