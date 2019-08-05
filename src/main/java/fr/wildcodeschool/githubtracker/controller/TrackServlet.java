package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.model.Githuber;
import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "TrackServlet", urlPatterns = "/track")
public class TrackServlet extends HttpServlet {

    @Inject
    GithubersService githubersService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Githuber git = null;
        String login = request.getParameter("login");
        String errorMessage = "";
        boolean isError = false;

        if (!login.isEmpty()) {
            try {
                git = githubersService.track(login);
                if (git == null) {
                    errorMessage = "Le githuber que vous avez saisi n'existe pas";
                    isError = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            errorMessage = "Vous n'avez pas saisi de githuber, veuillez en saisir un";
            isError = true;
        }

        if (isError) {
            try {
                request.setAttribute("githubersAttribute", githubersService.getAllGithubers());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("message", errorMessage);
            this.getServletContext().getRequestDispatcher("/githubers.jsp").forward(request, response);
        } else {
            response.sendRedirect("githubers");
        }
    }

}