package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

import java.io.IOException;
import java.util.List;

public interface GithuberDAO {


    List<Githuber> getGithubers() throws IOException;

    void saveGithuber(Githuber githuber) throws IOException;
}