package fr.wildcodeschool.githubtracker.model;

public class Githuber {


    private String name;
    private  String email;
    private String login;
    private String id;
    private String avatarUrl;

    public Githuber(String name, String email, String login, String avatarUrl) {
        this.name = name;
        this.email = email;
        this.login = login;
        this.avatarUrl = avatarUrl;
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

    public String getId() {
        return id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

}
