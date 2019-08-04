package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetGithuberFromBddDAO {

    @Resource(mappedName = "jdbc/githuber")
    private DataSource dataSource;

    public List<Githuber> getGithubersFromBdd(HttpServletRequest request) throws SQLException {

        List<Githuber> githubersFromBdd = new ArrayList<>();

        Statement statement = null;
        ResultSet resultat = null;

        // Connexion a SQL
        Connection connection = dataSource.getConnection();
        statement = connection.createStatement();

        resultat = statement.executeQuery("SELECT * FROM githuber;");

        while (resultat.next()) {
            String name = resultat.getString("name");
            String email = resultat.getString("email");
            String login = resultat.getString("login");
            String avatarUrl = resultat.getString("avatar_url");
            int github_id = resultat.getInt("github_id");

            githubersFromBdd.add(new Githuber(github_id, name, email, login, avatarUrl));
        }

        // Deconnexion
        if (resultat != null) {
            resultat.close();
        }
        if (statement != null) {
            statement.close();
        }

        return githubersFromBdd;
    }
}
