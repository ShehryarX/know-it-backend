package io.knowit.backend.io.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document
public class User {
    @Id
    private String id;

    @NotNull
    @Size(min = 5, max = 100)
    private String email;

    @NotNull
    @Size(min = 1, max = 50)
    private String name;

    private String imageUrl;

    private Boolean emailVerified = false;

    @NotNull
    @JsonIgnore
    @Size(min = 6, max = 100)
    private String password;

    @NotNull
    @JsonIgnore
    private AuthProvider provider;

    @JsonIgnore
    private String providerId;

    public User() {
    }

    public User(String id, @NotNull @Size(min = 5, max = 100) String email, @NotNull @Size(min = 1, max = 50) String name, String imageUrl, Boolean emailVerified, @NotNull @Size(min = 6, max = 100) String password, @NotNull AuthProvider provider, String providerId) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.imageUrl = imageUrl;
        this.emailVerified = emailVerified;
        this.password = password;
        this.provider = provider;
        this.providerId = providerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AuthProvider getProvider() {
        return provider;
    }

    public void setProvider(AuthProvider provider) {
        this.provider = provider;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
