package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.inject.Inject;
import java.io.IOException;
import java.sql.SQLException;


@javax.servlet.annotation.WebServlet("/githubers")
public class GithubersServlet extends javax.servlet.http.HttpServlet {

    @Inject
    GithubersService githubersService;

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        try {
            request.setAttribute("githubersAttribute", githubersService.getAllGithubers());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher("/githubers.jsp").forward(request, response);
    }
}