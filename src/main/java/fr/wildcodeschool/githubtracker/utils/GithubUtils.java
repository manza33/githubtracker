package fr.wildcodeschool.githubtracker.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.inject.Inject;
import java.io.IOException;
import java.net.URL;

public class GithubUtils {

    @Inject private ObjectMapper om;

    private final String APIURL = "https://api.github.com/users/";
    private  Githuber newGithuber = null;

    public Githuber parseGithuber(String login) throws IOException {
        String githuberAPI = APIURL + login;
        try{
            newGithuber = om.readValue(new URL(githuberAPI), Githuber.class);
        }catch (Exception e){
            e.getMessage();
        }
        if (newGithuber != null){
            return newGithuber;
        }else {
            throw new java.lang.Error("This githuber doesn't exist");
        }

    }
}
