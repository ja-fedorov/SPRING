package ua.fedorov.springcourse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class TestSpring {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );

        MusicalPlayer musicalPlayer = context.getBean("musicalPlayer", MusicalPlayer.class);

        System.out.println(musicalPlayer.getName());
        System.out.println(musicalPlayer.getVolume());

        context.close();
    }
}
