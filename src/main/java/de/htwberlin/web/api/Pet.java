package de.htwberlin.web.api;

public class Pet {

    private long id;
    private String name;
    private String gender;
    private Person person;

    public Pet(long id, String name, String gender, Person person) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.person = person;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
