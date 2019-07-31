package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;
import fr.wildcodeschool.githubtracker.utils.GithubUtils;

import org.apache.log4j.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.util.*;

@ApplicationScoped @InMemory
public class MemoryGithuberDAO implements GithuberDAO {

    @Inject private GithubUtils githubUtils;

    private Map<String, Githuber> githubersMap= new HashMap<>();

    Logger logger = Logger.getLogger("logger");

    @PostConstruct
    private void postConstruct() {
        String[] loginArray = {"veropichon","manza33", "valerianm", "mariehelene","Laureenrinadumas" };
        for ( String login : loginArray){
            try{
                saveGithuber(githubUtils.parseGithuber(login));
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    @Override
    public List<Githuber> getGithubers() throws IOException {
        List<Githuber> finalGithubersList =  new ArrayList<>(githubersMap.values());
        return finalGithubersList;
    }

    @Override
    public void saveGithuber(Githuber githuber) throws IOException {
        githubersMap.put(githuber.getLogin(), githuber);
    }
}