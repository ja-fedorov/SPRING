package ua.fedorov.spring.dao;

import org.springframework.stereotype.Component;
import ua.fedorov.spring.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Neil Alishev
 */
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;

    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "0663060306";

    private static Connection connection;

    static {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Person> index() {
        List<Person> people = new ArrayList<>();

    try {
        Statement statement = connection.createStatement();
        String SQL = "SELECT * FROM Person";
        ResultSet resultSet = statement.executeQuery(SQL);

        while (resultSet.next()) {
            Person person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setEmail(resultSet.getString("email"));
            person.setAge(resultSet.getInt("age"));

            people.add(person);
        }

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    return people;

    }

    public Person show(int id) {

        Person person = null;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM Person WHERE id=?");
            preparedStatement.setInt(1, id);

           ResultSet resultSet = preparedStatement.executeQuery();
           resultSet.next();

           person = new Person();

           person.setId(resultSet.getInt("id"));
           person.setName(resultSet.getString("name"));
           person.setAge(resultSet.getInt("age"));
           person.setEmail(resultSet.getString("email"));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    public void save(Person person) {
//        person.setId(++PEOPLE_COUNT);
//        people.add(person);
        try {
//            Statement statement = connection.createStatement();
//            String SQL = "INSERT INTO Person VALUES (" + 1 + ",'" + person.getName() +
//                    "'," + person.getAge() + ",'" + person.getEmail() + "')";
            // INSERT INTO Person VALUES (1, 'Tom', 18, 'asdf@mail.com');
//
//            statement.executeUpdate(SQL);
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO Person VALUES(1, ?, ?, ?)");
            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2, person.getAge());
            preparedStatement.setString(3, person.getEmail());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void update(int id, Person updatedPerson) {
//        Person personToBeUpdated = show(id);
//
//        personToBeUpdated.setName(updatedPerson.getName());
//        personToBeUpdated.setAge(updatedPerson.getAge());
//        personToBeUpdated.setEmail(updatedPerson.getEmail());

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE Person SET name=?, age=?, email=? WHERE id=?");

            preparedStatement.setString(1, updatedPerson.getName());
            preparedStatement.setInt(2, updatedPerson.getAge());
            preparedStatement.setString(3, updatedPerson.getEmail());
            preparedStatement.setInt(4, updatedPerson.getId());

            preparedStatement.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
//        people.removeIf(p -> p.getId() == id);
        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM Person WHERE id=?");
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}