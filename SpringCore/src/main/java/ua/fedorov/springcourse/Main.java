package ua.fedorov.springcourse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {


           RockMusic rockMusic = new RockMusic();
           ClassicalMusic cm = new ClassicalMusic();

        System.out.println(
           rockMusic.getSong().get(2)
                   + " |||| " +
                   cm.getSong().get(1));

    }
}
