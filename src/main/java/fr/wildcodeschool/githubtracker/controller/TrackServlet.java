package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.dao.GithuberDAO;
import fr.wildcodeschool.githubtracker.dao.InMemory;
import fr.wildcodeschool.githubtracker.service.GithubersService;
import fr.wildcodeschool.githubtracker.utils.GithubUtils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TrackServlet", urlPatterns = "/track")
public class TrackServlet extends HttpServlet {

    @Inject @InMemory GithuberDAO memoryGithuberDAO;

    //@Inject GithubersService githubersService;

    @Inject private GithubUtils githubUtils;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        memoryGithuberDAO.saveGithuber(githubUtils.parseGithuber(login));
        //githubersService.track(login);

        response.sendRedirect("githubers" );
    }

}

