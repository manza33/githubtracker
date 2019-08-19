package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class JPAGithuberDAO implements GithuberDAO {
    @Override
    public List<Githuber> getGithubers() throws IOException, SQLException {
        return null;
    }

    @Override
    public void saveGithuber(Githuber githuber) throws IOException, SQLException {

    }

    @Override
    public void deleteGithuber(String login) throws SQLException {

    }
}
