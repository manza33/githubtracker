package fr.wildcodeschool.githubtracker.dao;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.*;

public class DeleteGithuberFromBdd {

    @Resource(mappedName = "jdbc/githuber")
    private DataSource dataSource;

    public void deleteGithuberFromBdd(HttpServletRequest request, String login) throws SQLException {

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
