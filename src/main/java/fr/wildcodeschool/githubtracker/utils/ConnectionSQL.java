package fr.wildcodeschool.githubtracker.utils;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionSQL {

    @Resource(mappedName = "jdbc/githuber")
    private DataSource dataSource;

    //Connection connection = null;

    public Connection startConnection() throws SQLException {
        //connection = dataSource.getConnection();
        return dataSource.getConnection();
    }


    public void closeSQL(ResultSet resultat, Statement statement, Connection connexion) throws SQLException {

        if (resultat != null) {
            try {
                resultat.close();
            } catch (SQLException ignore) {
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ignore) {
            }
        }
        if (connexion != null) {
            try {
                connexion.close();
            } catch (SQLException ignore) {
            }
        }
    }
}

    /*public Connection startConnection() throws SQLException {
        try {
            Class.forName( "com.mysql.jdbc.Driver" );

        } catch ( ClassNotFoundException e ) {

        }

        String url = "jdbc:mysql://localhost:3306/githubtracker?serverTimezone=GMT";
        String utilisateur = "root";
        String motDePasse = "root";
        Connection connection = null;

        connection = DriverManager.getConnection( url, utilisateur, motDePasse );
        return connection;

    }*/