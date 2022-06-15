package de.htwberlin.web.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PersonManipulationRequest {
    @Size(min = 3, message = "Please provide a first name with 3 characters or more.")
    private String firstname;

    @NotBlank(message = "The last name must not be empty.")
    private String lastname;

    @Pattern(
            regexp = "MALE|FEMALE|DIVERSE|UNKOWN",
            message = "Please provide 'MALE', 'FEMALE', 'DIVERSE' or 'UNKNOWN' for gender"
    )
    private String gender;

    private boolean vaccinated;

    public PersonManipulationRequest() {}

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
