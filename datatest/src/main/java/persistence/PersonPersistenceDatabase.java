/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import api.PersonService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Person;

/**
 *
 * @author Thomas
 */
public class PersonPersistenceDatabase implements PersonPersistence {
    
    private Connection dbConnection;
    private PersonPersistence personPersistence;
    private PersonService personService;
    
    @Override
    public Person read(int personId) {
        open();
        try (Statement sqlStatement = dbConnection.createStatement()) {
            String sqlCommand = "SELECT * FROM Test WHERE id =" + personId;

            ResultSet resultSet = sqlStatement.executeQuery(sqlCommand);
            Person person = null;

			while (resultSet.next()) {
				person = readOnePerson(resultSet);
			}

			close();
			return person;
		} catch (SQLException e) {
			e.printStackTrace();
			return new Person();
		}
    }

    private Person readOnePerson(ResultSet resultSet) throws SQLException {
	Person person = new Person();
	person.setId(resultSet.getInt(1));
	person.setNachname(resultSet.getString(2));
	person.setVorname(resultSet.getString(3));
	return person;    
    }

    /**
     *
     * @param person
     */
    @Override
    public void write(Person person) {
	String sqlCommand = "INSERT INTO Test " + "(nachname, vorname) "
            + "VALUES (?, ?)";
	open();
	try (PreparedStatement sqlStatement = dbConnection.prepareStatement(sqlCommand, Statement.RETURN_GENERATED_KEYS)) {
            sqlStatement.setString(1, person.getNachname());
            sqlStatement.setString(2, person.getVorname());
            sqlStatement.executeUpdate();
            ResultSet resultSet = sqlStatement.getGeneratedKeys();
            if (resultSet.next()) {
		int generatedIdOfNewCustomerRecord = resultSet.getInt(1);
                    person.setId(generatedIdOfNewCustomerRecord);
                }

	} catch (SQLException e) {
            e.printStackTrace();
	}
	close();
    }
    
    private void open() {
        try {
            dbConnection = DBManager.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void close() {
        DBManager.getInstance().close();
    }

    @Override
    public List<Person> readAll() {
		
        List<Person> persons = new ArrayList<>();
		
        open();
        try (Statement sqlStatement = dbConnection.createStatement()) {
            String sqlCommand = "SELECT * FROM Test";

            ResultSet resultSet = sqlStatement.executeQuery(sqlCommand);
            Person person = null;

            while (resultSet.next()) {
                person = readOnePerson(resultSet);
                persons.add(person);
            }
			
            close();
			
        } catch (SQLException e) {
            e.printStackTrace();
            //return new Customer();
        }
				
        return persons;
    }
    
}
