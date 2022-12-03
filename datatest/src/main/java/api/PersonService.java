/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Person;
import persistence.PersonPersistence;

/**
 *
 * @author Thomas
 */
public class PersonService {
    
    private PersonPersistence personPersistence;
    
    public PersonService(PersonPersistence personPersistence) {
	this.personPersistence = personPersistence;
    }

    public Person newPerson() {
	Person person = new Person();
	setNewId(person);
	return person;
    }
	
    private void setNewId(Person person) {
	Random random = new Random();
	int id = random.nextInt(Integer.MAX_VALUE);
	person.setId(id);
    }

    public void savePerson(Person person) {
	personPersistence.write(person);
    }

    public Person readPerson(int id) {
	return personPersistence.read(id);
    }

    public List<Person> readAllPersons() {
	List<Person> persons= this.personPersistence.readAll();
	if (persons==null) {
            persons=new ArrayList<Person>();
	}
            return persons;
	}
	
    public void createCustomerInvoices (Person person) {
	// TO DO
    }
    
}
