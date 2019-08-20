package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;
import fr.wildcodeschool.githubtracker.utils.GithubUtils;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Transactional
@Jpa
public class JPAGithuberDAO implements GithuberDAO, Serializable {

    @PersistenceContext(name = "GitUnit")
    private EntityManager entityManager;

    @Override
    public List<Githuber> getGithubers() {
        return entityManager.createQuery("from Githuber gh", Githuber.class).getResultList();
    }

    @Override
    public void saveGithuber(Githuber githuber) {
        // Connexion a SQL
        /*Connection connection = dataSource.getConnection();

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
        }*/
        //entityManager.getTransaction().begin();
        entityManager.persist( githuber );
    }

    @Override
    public void deleteGithuber(String id){
        Integer intId = Integer.parseInt(id);
        Githuber git = entityManager.find( Githuber.class, intId );
        entityManager.remove(git);
    }
}
