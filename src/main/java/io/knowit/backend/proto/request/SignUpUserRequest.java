package io.knowit.backend.proto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SignUpUserRequest {
    @NotNull(message = "Please enter a valid email.")
    @Size(min = 5, max = 100, message = "Please enter a valid email.")
    @Email(message = "Please enter a valid email.")
    private String email;

    @NotNull(message = "Please enter your first name.")
    @Size(min = 1, max = 50, message = "Please enter your first name.")
    private String firstName;

    @NotNull(message = "Please enter your last name.")
    @Size(min = 1, max = 50, message = "Please enter your last name.")
    private String lastName;

    @NotNull(message = "Please enter a password.")
    @Size(min = 6, max = 100, message = "Make sure your password is more tha 6 characters.")
    private String password;

    public SignUpUserRequest(String email, String firstName, String lastName, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
