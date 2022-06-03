package de.htwberlin.web.api;

import java.util.List;

public class Person {

    private long id;
    private String firstname;
    private String lastname;
    private String gender;
    private boolean vaccinated;
    private List<Long> pets;

    public Person(long id, String firstname, String lastname, String gender, boolean vaccinated, List<Long> petIds) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.vaccinated = vaccinated;
        this.pets = petIds;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public List<Long> getPets() {
        return pets;
    }

    public void setPets(List<Long> pets) {
        this.pets = pets;
    }
}
