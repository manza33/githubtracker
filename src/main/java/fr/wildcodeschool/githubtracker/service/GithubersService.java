package fr.wildcodeschool.githubtracker.service;

import fr.wildcodeschool.githubtracker.dao.GithuberDAO;
import fr.wildcodeschool.githubtracker.dao.InMemory;
import fr.wildcodeschool.githubtracker.model.Githuber;
import fr.wildcodeschool.githubtracker.utils.GithubUtils;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

@Dependent
public class GithubersService {

    @Inject @InMemory GithuberDAO githuberDAO;
    @Inject private GithubUtils githubUtils;

    @Inject
    public GithubersService(GithuberDAO githuberDAO) {
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

    public void track(String login) throws IOException {
        githuberDAO.saveGithuber(githubUtils.parseGithuber(login));
    }
}
