package fr.wildcodeschool.githubtracker.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.wildcodeschool.githubtracker.model.Githuber;
import fr.wildcodeschool.githubtracker.service.GithubersService;
import org.apache.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class MemoryGithuberDAO implements GithuberDAO {
    private final String APIURL = "https://api.github.com/users/";

    @Inject
    GithubersService githubersService;

    private Map<String, Githuber> githubers= new HashMap<>();

    Logger logger = Logger.getLogger("logger");

    public Map<String, Githuber> getTheGithubers(Githuber theGithuber){
        //for (Githuber theGithuber : githubersService.getAllGithubers()) {
            githubers.put(theGithuber.getLogin(),theGithuber);
        //}
        return githubers;
    }

    public Githuber parseGithuber(String login) throws IOException {
        String githuberAPI = APIURL + login;
        ObjectMapper mapper = new ObjectMapper();
        Githuber newGithuber = mapper.readValue(new URL(githuberAPI), Githuber.class);
        return newGithuber;
    }


    @Override
    public List<Githuber> getGithubers() {
        return githubersService.getAllGithubers();
    }

    //@PostConstruct
    @Override
    public void saveGithuber(Githuber githuber) {
        for ( Githuber apiGitherber : githubersService.getAllGithubers()){
            try {
                Map<String ,Githuber> result = getTheGithubers(parseGithuber(apiGitherber.getLogin()));
                logger.info(result.get(apiGitherber.getLogin()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
