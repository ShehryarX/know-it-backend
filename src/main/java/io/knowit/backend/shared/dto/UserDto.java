package io.knowit.backend.shared.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.knowit.backend.io.entity.AuthProvider;

public class UserDto {
    private String id;
    private String email;
    private String name;
    private String imageUrl;
    private Boolean emailVerified;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private AuthProvider provider;

    @JsonIgnore
    private String providerId;

    public UserDto() {
    }

    public UserDto(String id, String email, String name, String imageUrl, Boolean emailVerified, String password, AuthProvider provider, String providerId) {
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
