package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.inject.Inject;
import java.io.IOException;


@javax.servlet.annotation.WebServlet("/githubers")
public class GithubersServlet extends javax.servlet.http.HttpServlet {

    @Inject GithubersService githubersService;

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        //GithuberDAO githuberDAO = new DumbGithuberDAO();
        //GithubersService githubersService = new GithubersService(githuberDAO);

        request.setAttribute( "githubersAttribute",githubersService.getAllGithubers());
        this.getServletContext().getRequestDispatcher( "/githubers.jsp" ).forward( request, response);
    }
}