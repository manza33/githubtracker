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

    @Override
    public void saveGithuber(Githuber githuber) throws IOException, SQLException {
        // Connexion a SQL
        Connection connection = dataSource.getConnection();

        ResultSet resultat = null;
        PreparedStatement preparedStatement = null;

        preparedStatement = connection.prepareStatement("INSERT INTO githuber (name, email, login, avatar_url, github_id)" + "  VALUES (?, ?, ?, ?, ?);");

        preparedStatement.setObject(1, githuber.getName(), Types.VARCHAR);
        preparedStatement.setObject(2, githuber.getEmail(), Types.VARCHAR);
        preparedStatement.setObject(3, githuber.getLogin(), Types.VARCHAR);
        preparedStatement.setObject(4, githuber.getAvatarUrl(), Types.VARCHAR);
        preparedStatement.setObject(5, new Integer(githuber.getGithub_id()), Types.INTEGER);
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
    public void deleteGithuber(String login) throws SQLException {
        ResultSet resultat = null;
        PreparedStatement preparedStatement = null;

        // Connexion a SQL
        Connection connection = dataSource.getConnection();

        preparedStatement = connection.prepareStatement("DELETE FROM githuber WHERE login = ?; ");

        preparedStatement.setObject(1, login, Types.VARCHAR);
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
