package fr.wildcodeschool.githubtracker.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.inject.Inject;
import java.net.URL;

public class GithubUtils {

    @Inject
    private ObjectMapper om;

    private final String APIURL = "https://api.github.com/users/";

    public Githuber parseGithuber(String login) {
        Githuber newGithuber = null;
        String githuberAPI = APIURL + login;
        try {
            newGithuber = om.readValue(new URL(githuberAPI), Githuber.class);
        } catch (Exception e) {
            e.getMessage();
        }
        return newGithuber;
    }
}
