package ua.fedorov.spring.dao;

import org.springframework.stereotype.Component;
import ua.fedorov.spring.models.Person;

import java.util.ArrayList;
import java.util.List;


@Component
public class PersonDAO {

    private List<Person> people;
    private static int COUNT_PEOPLE;

//    public PersonDAO(List<Person> people) {
//        this.people = people;
//
//        people.add(new Person(++COUNT_PEOPLE, "Tamara"));
//        people.add(new Person(++COUNT_PEOPLE, "Clara"));
//        people.add(new Person(++COUNT_PEOPLE, "Mark"));
//        people.add(new Person(++COUNT_PEOPLE, "John"));
//        people.add(new Person(++COUNT_PEOPLE, "Lara"));
//    }

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

    public void save(Person person) {
        person.setId(++COUNT_PEOPLE);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
    }

    public void delete(int id){
        people.removeIf(person -> person.getId()==id);
    }

}
