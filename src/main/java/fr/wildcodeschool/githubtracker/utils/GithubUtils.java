package fr.wildcodeschool.githubtracker.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.wildcodeschool.githubtracker.model.Githuber;
import fr.wildcodeschool.githubtracker.producer.ObjectMapperProducer;

import javax.inject.Inject;
import java.io.IOException;
import java.net.URL;

public class GithubUtils {

    @Inject private ObjectMapper om;

    private final String APIURL = "https://api.github.com/users/";

    public Githuber parseGithuber(String login) throws IOException {
        String githuberAPI = APIURL + login;
        Githuber newGithuber = om.readValue(new URL(githuberAPI), Githuber.class);
        return newGithuber;
    }
}
