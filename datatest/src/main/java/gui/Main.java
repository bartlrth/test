/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import api.PersonService;
import model.Person;
import persistence.PersonPersistence;
import persistence.PersonPersistenceDatabase;

/**
 *
 * @author Thomas
 */
public class Main {
    
    public static void main(String[] args) {
        Person person = new Person();
        person.setNachname("Dampf");
        person.setVorname("Hans");
        System.out.println(person);
        
        PersonPersistence personPersistence = new PersonPersistenceDatabase();
        PersonService personService = new PersonService(personPersistence);
        personService.savePerson(person);
        System.out.println(personService.readPerson(person.getId()));
    }
    
}
