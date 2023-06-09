package org.example;

import java.util.ArrayList;
import java.util.List;

public class EDevletService {
    private String nationalityId;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private List<EDevletService> mernis;

    public EDevletService(String nationalityId, String firstName, String lastName, String dateOfBirth) {
        this.nationalityId = nationalityId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }
    public EDevletService() {
        mernis = new ArrayList<EDevletService>();
        mernis.add(new EDevletService("12345678910", "John", "Doe", "1990"));
        mernis.add(new EDevletService("12345678911", "Jane", "Doe", "1991"));
        mernis.add(new EDevletService("12345678912", "Jack", "Doe", "1992"));
        mernis.add(new EDevletService("12345678913", "Jill", "Doe", "1993"));
        mernis.add(new EDevletService("12345678914", "Jenny", "Doe", "1994"));
    }

    public String getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(String nationalityId) {
        this.nationalityId = nationalityId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean checkUser(String tcNo, String firstName, String lastName, String birthYear) {
        System.out.println("Checking user with E-Devlet service");
        for (EDevletService eDevlet : mernis) {
            if (tcNo.equals(eDevlet.getNationalityId()) && firstName.equals(eDevlet.getFirstName()) && lastName.equals(eDevlet.getLastName()) && birthYear.equals(eDevlet.getDateOfBirth())) {
                return true;
            }
        }
        return false;
    }
}
