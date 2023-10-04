package com.plannerbe.practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
public class TestBeansConfiguration {
    @Bean
    public List<String> stringsCollection() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Item 1");
        stringList.add("Item 2");
        stringList.add("Item 3");
        return stringList;
    }

    @Bean
    @Scope("prototype")
    public List<Integer> integersCollection() {
        List<Integer> listIntegers = new Random().ints(5, 1, 10)
            .boxed().toList();
        return listIntegers;
    }
}
