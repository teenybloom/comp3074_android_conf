package com.example.a101019479.conference_app_mockup.model;

public class Presenter {

    private long id;
    private String firstName;
    private String lastName;
    private String affiliation;
    private String email;
    private String bio;

    public Presenter(long id, String firstName, String lastName, String affiliation, String email, String bio) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.affiliation = affiliation;
        this.email = email;
        this.bio = bio;
    }

    public Presenter(String firstName, String lastName, String affiliation, String email, String bio) {
        this(-1, firstName, lastName, affiliation, email, bio);
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public String getEmail() {
        return email;
    }

    public String getBio() {
        return bio;
    }
}
