package fr.wildcodeschool.githubtracker.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="githuber")
public class Githuber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="login")
    private String login;

    @Column(name="github_id")
    private Long github_id;

    @Column(name="avatar_url")
    private String avatarUrl;
    

    @JsonCreator
    public Githuber(
            @JsonProperty("id") Long github_id,
            @JsonProperty("name") String name,
            @JsonProperty("email") String email,
            @JsonProperty("login") String login,
            @JsonProperty("avatar_url") String avatar_url) {

        this.name = name;
        this.email = email;
        this.login = login;
        this.avatarUrl = avatar_url;
        this.github_id = github_id;
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

    public Long getGithub_id() {
        return github_id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

}
