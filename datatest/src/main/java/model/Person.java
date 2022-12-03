/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Thomas
 */
public class Person {
    private int id;
    private String nachname;
    private String vorname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Person [ID=");
        builder.append(id);
        builder.append(", Nachname=");
        builder.append(nachname);
        builder.append(", Vorname=");
        builder.append(vorname);
        builder.append("]");
        return builder.toString();
    }
    
    
    
}
