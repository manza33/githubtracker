package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.dao.GithuberDAO;
import fr.wildcodeschool.githubtracker.dao.InMemory;
import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "TrackServlet", urlPatterns = "/track")
public class TrackServlet extends HttpServlet {


    @Inject GithubersService githubersService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String login = request.getParameter("login");

        try {
            githubersService.track(request, login); // Passe par la method Track dans service au lieu d'utiliser directement MemoryGithuberDAO
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("githubers" );
    }
}