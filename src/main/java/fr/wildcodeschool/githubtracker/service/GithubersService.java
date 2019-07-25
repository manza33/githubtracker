package fr.wildcodeschool.githubtracker.service;

import fr.wildcodeschool.githubtracker.dao.DumbGithuberDAO;
import fr.wildcodeschool.githubtracker.dao.GithuberDAO;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
public class GithubersService {

    GithuberDAO githuberDAO;

    @Inject
    public GithubersService(GithuberDAO githuberDAO) {
        this.githuberDAO = githuberDAO;
    }

    public List<Githuber> getAllGithubers(){
        GithuberDAO githuberDAO = new DumbGithuberDAO();
        return githuberDAO.getGithubers();
    }

    public Githuber getGithuber(String login){
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
