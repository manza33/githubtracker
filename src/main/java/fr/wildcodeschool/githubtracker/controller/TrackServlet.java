package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.dao.MemoryGithuberDAO;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TrackServlet", urlPatterns = "/track")
public class TrackServlet extends HttpServlet {


    @Inject MemoryGithuberDAO memoryGithuberDAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        memoryGithuberDAO.saveGithuber(memoryGithuberDAO.parseGithuber(login));

        response.sendRedirect("githubers" );
    }

}

