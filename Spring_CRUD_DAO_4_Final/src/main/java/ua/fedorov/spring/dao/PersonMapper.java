package ua.fedorov.spring.dao;

import org.springframework.jdbc.core.RowMapper;
import ua.fedorov.spring.models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {

        Person person = new Person();

        person.setId(rs.getInt("id"));
        person.setName(rs.getString("name"));
        person.setAge(rs.getInt("age"));
        person.setEmail(rs.getString("email"));

        return person;
    }
}
