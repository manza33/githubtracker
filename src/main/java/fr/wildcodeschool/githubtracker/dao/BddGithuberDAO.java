package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@InBdd
public class BddGithuberDAO implements GithuberDAO {


    @Resource(mappedName = "jdbc/githuber")
    DataSource dataSource;

    @Override
    public List<Githuber> getGithubers() throws IOException, SQLException {
        List<Githuber> githubersFromBdd = new ArrayList<>();

        //Statement statement = null;
        ResultSet resultat = null;

        // Connexion a SQL
        Connection connection = dataSource.getConnection();
        //statement = connection.createStatement();

        try (Statement statement = connection.createStatement()) {

            resultat = statement.executeQuery("SELECT * FROM githuber;");

            while (resultat.next()) {
                String name = resultat.getString("name");
                String email = resultat.getString("email");
                String login = resultat.getString("login");
                String avatarUrl = resultat.getString("avatar_url");
                int github_id = resultat.getInt("github_id");
                int id = resultat.getInt("id");

                githubersFromBdd.add(new Githuber(id, github_id, name, email, login, avatarUrl));
            }
            resultat.close();
        }

        return githubersFromBdd;
    }

    @Override
    public void saveGithuber(Githuber githuber) throws IOException, SQLException {
        // Connexion a SQL
        Connection connection = dataSource.getConnection();

        ResultSet resultat = null;
        PreparedStatement preparedStatement = null;

        preparedStatement = connection.prepareStatement("INSERT INTO githuber (name, email, login, avatar_url, github_id)" + "  VALUES (?, ?, ?, ?, ?);");

        preparedStatement.setString(1, githuber.getName());
        preparedStatement.setString(2, githuber.getEmail());
        preparedStatement.setString(3, githuber.getLogin());
        preparedStatement.setString(4, githuber.getAvatarUrl());
        preparedStatement.setInt(5, new Integer(githuber.getGithub_id()));
        preparedStatement.executeUpdate();

        // Deconnexion

        if (resultat != null) {
            resultat.close();
        }

        if (preparedStatement != null) {
            preparedStatement.close();
        }
    }

    @Override
    public void deleteGithuber(String id) throws SQLException {

        Integer intId = Integer.parseInt(id);
        ResultSet resultat = null;
        PreparedStatement preparedStatement = null;

        // Connexion a SQL
        Connection connection = dataSource.getConnection();

        preparedStatement = connection.prepareStatement("DELETE FROM githuber WHERE id = ?; ");

        preparedStatement.setInt(1, intId);
        preparedStatement.executeUpdate();

        // Deconnexion
        if (resultat != null) {
            resultat.close();
        }

        if (preparedStatement != null) {
            preparedStatement.close();
        }
    }
}
