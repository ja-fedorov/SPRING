package ua.fedorov.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class MusicalPlayer {

    @Value("${musicPlayer.volume}")
    private int volume;

    @Value("${musicPlayer.name}")
    private String name;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Music music1;
private Music music2;

@Autowired
    public MusicalPlayer( @Qualifier("classicalMusic") Music music1,
                          @Qualifier("rockMusic") Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }

    public void playMusic(MusicGenre genre) {
        Random random = new Random();
        int number = random.nextInt(3);

        if (genre == MusicGenre.CLASSICAL)
            System.out.println(music1.getSong().get(number));
        else
            System.out.println(music2.getSong().get(number));

    }

}
