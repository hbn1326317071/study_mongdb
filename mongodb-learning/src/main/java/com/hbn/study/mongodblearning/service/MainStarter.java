package com.hbn.study.mongodblearning.service;

import com.hbn.study.mongodblearning.MongodbLearningApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainStarter {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MongodbLearningApplication.class);

    }
}
