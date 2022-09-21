package ua.fedorov.springcourse;


import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassicalMusic implements Music {


    @PostConstruct
    public void doMyInit() {
        System.out.println("Doint the initialization");
    }
    @PreDestroy
    public void doMyDestroy () {
        System.out.println("Doing the destroy");
    }


    private List <String> classicalMusicList = new ArrayList<>();

    {
        classicalMusicList.add("Classical_1");
        classicalMusicList.add("Classical_2");
        classicalMusicList.add("Classical_3");
    }

    public List <String> getSong() {
        return classicalMusicList;
    }
}
