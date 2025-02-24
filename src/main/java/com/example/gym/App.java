package com.example.gym;

import com.example.gym.view.View;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * The GYM CRM Application
 */
@ComponentScan ( basePackages = "com.example.gym" )
public class App {
    
    public static void main (String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        View view = context.getBean(View.class);
        view.start();
    }
}
