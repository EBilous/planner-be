package com.plannerbe.practice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UseBeanComponent.class);

        UseBeanComponent useBeanComponent = context.getBean(UseBeanComponent.class);
        useBeanComponent.printList();

        context.close();

        List<UseBeanComponent> newList = List.of(useBeanComponent);

        System.out.println(newList);
    }


}
