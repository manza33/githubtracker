package fr.wildcodeschool.githubtracker.service;

import fr.wildcodeschool.githubtracker.dao.*;
import fr.wildcodeschool.githubtracker.model.Githuber;
import fr.wildcodeschool.githubtracker.utils.GithubUtils;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Dependent
public class GithubersService {

    private GithuberDAO githuberDAO;
    @Inject private GithubUtils githubUtils;
    //@Inject private GetGithuberFromBddDAO getGithuberFromBddDAO;
    //@Inject private AddGithuberToBddDAO addGithuberToBddDAO;
    //@Inject private DeleteGithuberFromBdd deleteGithuberFromBdd;

    @Inject
    public GithubersService( @InBdd GithuberDAO githuberDAO) {
        this.githuberDAO = githuberDAO;
    }

    public List<Githuber> getAllGithubers() throws IOException, SQLException {
        return githuberDAO.getGithubers();

    }

    public Githuber getGithuber(HttpServletRequest request, String login) throws IOException, SQLException {
        List<Githuber> allGithuber = getAllGithubers();

        Githuber theGithuber = allGithuber.stream()
                .filter(githuber -> login.equals(githuber.getLogin()))
                .findAny()
                .orElse(null);

        return theGithuber;
    }

    public void track(String login) throws IOException, SQLException {
        githuberDAO.saveGithuber( githubUtils.parseGithuber(login));
    }

    public void unTrack(String login) throws IOException, SQLException {
        githuberDAO.deleteGithuber(login);
    }

}
