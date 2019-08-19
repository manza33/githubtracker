package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;
import fr.wildcodeschool.githubtracker.utils.GithubUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
@Jpa
public class JPAGithuberDAO implements GithuberDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private GithubUtils githubUtils;

    private Map<String, Githuber> githubersMap = new HashMap<>();

    @Override
    public List<Githuber> getGithubers() throws IOException, SQLException {
        List<Githuber> githubersFromBdd = new ArrayList<>();

        /*ResultSet resultat = null;

        // Connexion a SQL
        //Connection connection = dataSource.getConnection();
        //statement = connection.createStatement();

        try (Statement statement = connection.createStatement()) {

            resultat = statement.executeQuery("SELECT * FROM githuber;");

            while (resultat.next()) {
                String name = resultat.getString("name");
                String email = resultat.getString("email");
                String login = resultat.getString("login");
                String avatarUrl = resultat.getString("avatar_url");
                int github_id = resultat.getInt("github_id");

                githubersFromBdd.add(new Githuber(github_id, name, email, login, avatarUrl));
            }
            resultat.close();
        }*/


        //TypedQuery<Githuber> query = entityManager.createQuery("from BlogEntry be", BlogEntry.class);
        //return query.getResultList();

        return githubersFromBdd;
    }

    @Override
    public void saveGithuber(Githuber githuber) throws IOException, SQLException {

    }

    @Override
    public void deleteGithuber(String login) throws SQLException {

    }
}
