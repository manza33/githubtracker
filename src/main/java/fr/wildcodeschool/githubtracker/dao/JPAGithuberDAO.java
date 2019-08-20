package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

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
        entityManager.persist( githuber );
    }

    @Override
    public void deleteGithuber(String id){
        Integer intId = Integer.parseInt(id);
        Githuber git = entityManager.find( Githuber.class, intId );
        entityManager.remove(git);
    }
}
