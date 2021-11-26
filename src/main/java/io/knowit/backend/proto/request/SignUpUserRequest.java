package io.knowit.backend.proto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SignUpUserRequest {
    @NotNull(message = "Please enter a valid email.")
    @Size(min = 5, max = 100, message = "Please enter a valid email.")
    @Email(message = "Please enter a valid email.")
    private String email;

    @NotNull(message = "Please enter your name.")
    @Size(min = 1, max = 50, message = "Please enter your name.")
    private String name;

    @NotNull(message = "Please enter a password.")
    @Size(min = 6, max = 100, message = "Make sure your password is more than 6 characters.")
    private String password;

    public SignUpUserRequest(@NotNull(message = "Please enter a valid email.") @Size(min = 5, max = 100, message = "Please enter a valid email.") @Email(message = "Please enter a valid email.") String email, @NotNull(message = "Please enter your name.") @Size(min = 1, max = 50, message = "Please enter your name.") String name, @NotNull(message = "Please enter a password.") @Size(min = 6, max = 100, message = "Make sure your password is more than 6 characters.") String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
