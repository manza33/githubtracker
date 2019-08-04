package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;
import fr.wildcodeschool.githubtracker.utils.ConnectionSQL;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;

public class AddGithuberToBddDAO {


    public AddGithuberToBddDAO() {
    }

    public void githubersToBdd (HttpServletRequest request, Githuber githuber) throws SQLException{

        ResultSet resultat = null;
        PreparedStatement preparedStatement = null;

        // Connexion a SQL
        ConnectionSQL connectionSQL = new ConnectionSQL();
        Connection connection = connectionSQL.startConnection();

        try {

            preparedStatement = connection.prepareStatement("INSERT INTO githuber (name, email, login, avatar_url, github_id)" + "  VALUES (?, ?, ?, ?, ?);");

            preparedStatement.setObject(1,githuber.getName(),Types.VARCHAR);
            preparedStatement.setObject(2,githuber.getEmail(),Types.VARCHAR);
            preparedStatement.setObject(3,githuber.getLogin(),Types.VARCHAR);
            preparedStatement.setObject(4,githuber.getAvatarUrl(),Types.VARCHAR);
            preparedStatement.setObject(5,new Integer(githuber.getGithub_id()),Types.INTEGER);
            preparedStatement.executeUpdate();


        } catch ( SQLException e ) {

        }finally {

            // Deconnexion SQL
            ConnectionSQL closeSQL = new ConnectionSQL();
            closeSQL.closeSQL(resultat,preparedStatement,connection);
        }

    }
}
