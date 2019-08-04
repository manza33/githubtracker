package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;
import fr.wildcodeschool.githubtracker.utils.ConnectionSQL;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;

public class DeleteGithuberFromBdd {

    public void deleteGithuberFromBdd(HttpServletRequest request, String login) throws SQLException {


        ResultSet resultat = null;
        PreparedStatement preparedStatement = null;

        // Connexion a SQL
        ConnectionSQL connectionSQL = new ConnectionSQL();
        Connection connection = connectionSQL.startConnection();

        try {

            preparedStatement = connection.prepareStatement("DELETE FROM githuber WHERE login = ?; ");

            preparedStatement.setObject(1, login, Types.VARCHAR);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {

        } finally {

            // Deconnexion SQL
            ConnectionSQL closeSQL = new ConnectionSQL();
            closeSQL.closeSQL(resultat, preparedStatement, connection);
        }

    }
}
