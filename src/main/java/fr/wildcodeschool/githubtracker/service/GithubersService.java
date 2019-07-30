package fr.wildcodeschool.githubtracker.service;

import fr.wildcodeschool.githubtracker.dao.DumbGithuberDAO;
import fr.wildcodeschool.githubtracker.dao.GithuberDAO;
import fr.wildcodeschool.githubtracker.dao.InMemory;
import fr.wildcodeschool.githubtracker.dao.MemoryGithuberDAO;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
public class GithubersService {

    //GithuberDAO githuberDAO;
    @InMemory
    MemoryGithuberDAO githuberDAO;


    /*public GithubersService(GithuberDAO githuberDAO) {
        this.githuberDAO = githuberDAO;
    }*/

    @Inject
    public GithubersService(MemoryGithuberDAO githuberDAO) {
        this.githuberDAO = githuberDAO;
    }

    public List<Githuber> getAllGithubers() throws IOException {
        return githuberDAO.getGithubers();
    }

    public Githuber getGithuber(String login) throws IOException {
        List<Githuber> allGithuber = getAllGithubers();

        Githuber theGithuber = allGithuber.stream()
                .filter(githuber -> login.equals(githuber.getLogin()))
                .findAny()
                .orElse(null);

        return theGithuber;
    }


    public void track(String login){
        //TODO
    }


}
