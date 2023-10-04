package com.plannerbe.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UseBeanComponent {
    private final List<String> stringList;
    private final List<Integer> integersList;

    @Autowired
    public UseBeanComponent(List<String> stringList, List<Integer> integersList) {
        this.stringList = stringList;
        this.integersList = integersList;
    }

    public void printList() {
        for (String item : stringList) {
            System.out.println(item);
        }
        System.out.println(integersList.stream());
    }
}
