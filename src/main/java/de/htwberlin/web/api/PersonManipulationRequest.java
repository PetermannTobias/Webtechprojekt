package de.htwberlin.web.api;

public class PersonManipulationRequest {
    private String firstname;
    private String lastname;
    private String gender;
    private boolean vaccinated;

    public PersonManipulationRequest(String firstname, String lastname,String gender, boolean vaccinated) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.vaccinated = vaccinated;
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
}
