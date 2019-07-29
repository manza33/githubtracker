package fr.wildcodeschool.githubtracker.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Githuber {


    private String name;
    private  String email;
    private String login;
    private int id;
    private String avatarUrl;

    @JsonCreator
    //public Githuber(int id, String name, String email, String login, String avatarUrl) {
    public Githuber(
        @JsonProperty("id") int id,
        @JsonProperty("name") String name,
        @JsonProperty("email") String email,
        @JsonProperty("login") String login,
        @JsonProperty("avatarUrl") String avatarUrl) {

        this.name = name;
        this.email = email;
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

}
