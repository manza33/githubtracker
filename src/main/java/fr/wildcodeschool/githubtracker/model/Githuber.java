package fr.wildcodeschool.githubtracker.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Githuber {

    private String name;
    private  String email;
    private String login;
    private int id;
    private String avatarUrl;

    @JsonCreator
    public Githuber(
        @JsonProperty("id") int id,
        @JsonProperty("name") String name,
        @JsonProperty("email") String email,
        @JsonProperty("login") String login,
        @JsonProperty("avatar_url") String avatar_url) {

        this.name = name;
        this.email = email;
        this.login = login;
        this.avatarUrl = avatar_url;
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
