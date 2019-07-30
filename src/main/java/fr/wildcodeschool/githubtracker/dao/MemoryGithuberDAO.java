package fr.wildcodeschool.githubtracker.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.wildcodeschool.githubtracker.model.Githuber;
import fr.wildcodeschool.githubtracker.service.GithubersService;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.net.URL;
import java.util.*;

@InMemory
@ApplicationScoped
public class MemoryGithuberDAO implements GithuberDAO {
    private final String APIURL = "https://api.github.com/users/";

    @Inject private ObjectMapper om;

    @Inject GithubersService githubersService;

    private Map<String, Githuber> githubersMap= new HashMap<>();

    Logger logger = Logger.getLogger("logger");

    @PostConstruct
    private void postConstruct() {
        String[] loginArray = {"veropichon","manza33", "valerianm", "mariehelene","Laureenrinadumas" };
        for ( String login : loginArray){
            try{
                saveGithuber(parseGithuber(login));
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    public Githuber parseGithuber(String login) throws IOException {
        String githuberAPI = APIURL + login;
        //ObjectMapper mapper = new ObjectMapper();
        Githuber newGithuber = om.readValue(new URL(githuberAPI), Githuber.class);
        return newGithuber;
    }


    @Override
    public List<Githuber> getGithubers() throws IOException {
        List<Githuber> finalGithubersList =  new ArrayList<>(githubersMap.values());
        return finalGithubersList;
    }

    //@PostConstruct
    @Override
    public void saveGithuber(Githuber githuber) throws IOException {
        githubersMap.put(githuber.getLogin(), githuber);
    }
}
