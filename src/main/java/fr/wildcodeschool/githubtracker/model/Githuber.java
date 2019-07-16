package fr.wildcodeschool.githubtracker.model;

public class Githuber {


    private String name;
    private  String email;
    private String login;
    private int id;
    private String avatarUrl;

    public Githuber(int id, String name, String email, String login, String avatarUrl) {
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
