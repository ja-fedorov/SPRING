package ua.fedorov.spring.dao;

import org.springframework.stereotype.Component;
import ua.fedorov.spring.models.Person;

import java.util.ArrayList;
import java.util.List;


@Component
public class PersonDAO {

    private List<Person> people;
    private static int COUNT_PEOPLE;

     {
        people = new ArrayList<>();

        people.add(new Person(++COUNT_PEOPLE, "Tamara"));
        people.add(new Person(++COUNT_PEOPLE, "Clara"));
        people.add(new Person(++COUNT_PEOPLE, "Mark"));
        people.add(new Person(++COUNT_PEOPLE, "John"));
        people.add(new Person(++COUNT_PEOPLE, "Lara"));
    }


    public List<Person> index(){
        return people;
    }

    public Person  show (int id) {
        return people.stream().filter(person -> person.getId()==id).findAny().orElse(null);
    }

}
