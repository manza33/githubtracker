package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface GithuberDAO {


    List<Githuber> getGithubers() throws IOException, SQLException;

    void saveGithuber(Githuber githuber) throws IOException, SQLException;

    void deleteGithuber(String login) throws SQLException;
}