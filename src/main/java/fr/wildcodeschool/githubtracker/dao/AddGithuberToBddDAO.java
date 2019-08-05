package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.*;

public class AddGithuberToBddDAO {

    @Resource(mappedName = "jdbc/githuber")
    private DataSource dataSource;

    public void githubersToBdd(HttpServletRequest request, Githuber githuber) throws SQLException {

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
}