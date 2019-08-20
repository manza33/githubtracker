package fr.wildcodeschool.githubtracker.service;

import fr.wildcodeschool.githubtracker.dao.GithuberDAO;
import fr.wildcodeschool.githubtracker.dao.InBdd;
import fr.wildcodeschool.githubtracker.dao.Jpa;
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
    @Inject
    private GithubUtils githubUtils;
    private Githuber trackGithuber = null;

    @Inject
    public GithubersService(@Jpa GithuberDAO githuberDAO) {
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

    public Githuber track(String login) throws IOException, SQLException {

        trackGithuber = githubUtils.parseGithuber(login);

        if (trackGithuber != null) {
            githuberDAO.saveGithuber(trackGithuber);
        }
        return trackGithuber;
    }

    public void unTrack(String id) throws SQLException {
        githuberDAO.deleteGithuber(id);
    }

}