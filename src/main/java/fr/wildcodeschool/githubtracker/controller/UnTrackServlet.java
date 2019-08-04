package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.WriteListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "unTrackServlet", urlPatterns = "/unTrack")
public class UnTrackServlet extends HttpServlet {
    @Inject
    GithubersService githubersService;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String deleteLogin = request.getParameter("deleteLogin");

        PrintWriter out = response.getWriter();
        out.println(deleteLogin);

        try {
            githubersService.unTrack(request, deleteLogin);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("githubers");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //PrintWriter out = response.getWriter();
    }
}
