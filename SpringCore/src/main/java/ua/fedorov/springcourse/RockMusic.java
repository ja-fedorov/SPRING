package ua.fedorov.springcourse;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class RockMusic implements Music{

    private List<String> rockMusicList = new ArrayList<>();

    {
        rockMusicList.add("Rock_1");
        rockMusicList.add("Rock_2");
        rockMusicList.add("Rock_3");
    }
    public List<String> getSong() {
        return  rockMusicList;
    }
}
