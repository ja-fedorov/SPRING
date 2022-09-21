package ua.fedorov.springcourse;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JazzMusic implements Music {

    private List<String> jazzMusicList = new ArrayList<>();

    {
        jazzMusicList.add("Jazz_1");
        jazzMusicList.add("Jazz_2");
        jazzMusicList.add("Jazz_3");
    }

    @Override
    public List<String> getSong() {
        return jazzMusicList;
    }
}
