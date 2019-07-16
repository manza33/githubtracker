package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.model.Githuber;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@javax.servlet.annotation.WebServlet("/GithubersServlet")
public class GithubersServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Githuber githuber1 = new Githuber(1,"Boubou", "titi@mail.com", "TitiBoubou", "image.com");
        Githuber githuber2 = new Githuber(2,"Baj", "nico@mail.com", "Guaca", "image.com");
        Githuber githuber3 = new Githuber(3,"Ousselin", "jen@mail.com", "Reptilihome", "image.com");
        Githuber githuber4 = new Githuber(4,"Remy", "pascalou@mail.com", "Kiki64", "image.com");
        Githuber githuber5 = new Githuber(5,"Gillamot", "mimi@mail.com", "Mimi", "image.com");

        List<Githuber> githubers = new ArrayList<Githuber>();
        githubers.add(githuber1);
        githubers.add(githuber2);
        githubers.add(githuber3);
        githubers.add(githuber4);
        githubers.add(githuber5);

        request.setAttribute( "githubersAttribute", githubers );
        this.getServletContext().getRequestDispatcher( "/githubers.jsp" ).forward( request, response);
    }
}
