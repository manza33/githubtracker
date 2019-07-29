package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.Dependent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Dependent
public class DumbGithuberDAO implements GithuberDAO {


    @Override
    public List<Githuber> getGithubers() {

        List<Githuber> githubers = new ArrayList<Githuber>();

        githubers.add(new Githuber(1,"Boubou", "titi@mail.com", "TitiBoubou", "image.com"));
        githubers.add(new Githuber(2,"Baj", "nico@mail.com", "Guaca", "image.com"));
        githubers.add(new Githuber(3,"Ousselin", "jen@mail.com", "Reptilihome", "image.com"));
        githubers.add(new Githuber(4,"Remy", "pascalou@mail.com", "Kiki64", "image.com"));
        githubers.add(new Githuber(5,"Gillamot", "mimi@mail.com", "Mimi", "image.com"));

        return Collections.unmodifiableList(githubers);
    }

    @Override
    public void saveGithuber(Githuber githuber) throws UnsupportedOperationException  {

    }
}
