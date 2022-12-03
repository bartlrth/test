/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistence;

import java.util.List;

import model.Person;

/**
 *
 * @author Thomas
 */
public interface PersonPersistence {
    Person read(int personId);
    void write(Person person);
    List<Person> readAll();
}
