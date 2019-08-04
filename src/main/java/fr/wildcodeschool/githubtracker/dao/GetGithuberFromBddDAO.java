package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;
import fr.wildcodeschool.githubtracker.utils.ConnectionSQL;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetGithuberFromBddDAO {

    public List<Githuber> getGithubersFromBdd (HttpServletRequest request) throws SQLException {

        List<Githuber> githubersFromBdd = new ArrayList<>();

        Statement statement = null;
        ResultSet resultat = null;

        // Connexion a SQL
        ConnectionSQL connectionSQL = new ConnectionSQL();
        Connection connection = connectionSQL.startConnection();

        try {

            statement = connection.createStatement();

            resultat = statement.executeQuery( "SELECT * FROM githuber;" );

            while ( resultat.next() )  {
                String name = resultat.getString( "name" );
                String email = resultat.getString( "email" );
                String login = resultat.getString( "login" );
                String avatarUrl = resultat.getString( "avatar_url" );
                int github_id = resultat.getInt( "github_id" );

                githubersFromBdd.add(new Githuber(github_id, name, email, login, avatarUrl));
            }

        } catch ( SQLException e ) {

        }finally {

            // Deconnexion SQL
            ConnectionSQL closeSQL = new ConnectionSQL();
            closeSQL.closeSQL(resultat,statement,connection);
        }

        return githubersFromBdd;
    }
}
