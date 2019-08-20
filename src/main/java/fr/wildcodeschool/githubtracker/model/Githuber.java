package fr.wildcodeschool.githubtracker.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "githuber")
public class Githuber implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "email", nullable = true)
    private String email;

    @Basic
    @Column(name = "login")
    private String login;

    @Basic
    @Column(name = "github_id")
    private Integer github_id;

    @Basic
    @Column(name = "avatar_url")
    private String avatarUrl;

    public Githuber() {
    }

    @JsonCreator
    public Githuber(
            @JsonProperty("id") Integer github_id,
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

    public Integer getGithub_id() {
        return github_id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public Integer getId() {
        return id;
    }
}