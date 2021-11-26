package io.knowit.backend.proto.response;

public class GetUserLoginResponse {
    private String id;
    private String email;
    private String name;
    private String imageUrl;
    private Boolean emailVerified;

    public GetUserLoginResponse() {
    }

    public GetUserLoginResponse(String id, String email, String name, String imageUrl, Boolean emailVerified) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.imageUrl = imageUrl;
        this.emailVerified = emailVerified;
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
}
