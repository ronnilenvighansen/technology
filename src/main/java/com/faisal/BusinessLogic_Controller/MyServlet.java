package com.faisal.BusinessLogic_Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import java.io.*;
/**
 * Created by faisaljarkass on 19/08/16.
 * mvn appengine:update
 * mvn appengine:devserver
 */
public class MyServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(MyServlet.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Scanner input = new Scanner(new File("C:\\Users\\Ronni\\IdeaProjects\\Technology1_startup_project\\web\\WEB-INF\\DAO\\user1.txt"));
        String word1 = "";
        String word2 = "";
        String word3 = "";
        boolean flag = true;
        logger.log(Level.INFO, "doPost start...");
        logger.log(Level.INFO, "Username: " + request.getParameter("username"));
        logger.log(Level.INFO, "Password: " + request.getParameter("password"));
        logger.log(Level.INFO, "Checkbox: " + request.getParameter("rememberMe"));
        while(input.hasNextLine())
        {
            flag = true;
            word1 = input.next();
            word2 = input.next();
            word3 = input.next();
            if(word1.equals(request.getParameter("username")) && word2.equals(request.getParameter("password")) && word3.equals("admin"))
            {
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                String title = "You are admin";
                String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
                out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" +
                        "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n" +
                        "<ul>\n" + "  <li><b>Username</b>: " + request.getParameter("username") + "\n" +
                        "  <li><b>Password</b>: " + request.getParameter("password") + "\n" + "<form method=\"POST\" action=\"HelloServlet\">\n" +
                                "            <textarea name=\"textarea\">\n" +
                                "            </textarea>\n" +
                                "        <input type=\"submit\" name=\"btn\" value=\"send\">\n" +
                                "    </form>" +
                        "</ul>\n" + "</body></html>");
                logger.log(Level.INFO, "doPost ended...");
                break;
            }

            else if(word1.equals(request.getParameter("username")) && word2.equals(request.getParameter("password")) && word3.equals("user"))
            {
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                String title = "You are user";
                String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
                out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" +
                        "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n" +
                        "<ul>\n" + "  <li><b>Username</b>: " + request.getParameter("username") + "\n" +
                        "  <li><b>Password</b>: " + request.getParameter("password") + "\n" +
                        "</ul>\n" + "</body></html>");
                logger.log(Level.INFO, "doPost ended...");
                break;
            }
            else
            {
                flag = false;
            }
        }
        if(flag == false)
        {
            RequestDispatcher dispatch = request.getRequestDispatcher("index.html");
            dispatch.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.log(Level.INFO, "doGet started...");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Using POST Method to Read Form Data";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>Username</b>: "
                + request.getParameter("username") + "\n" +
                "  <li><b>Password</b>: "
                + request.getParameter("password") + "\n" +
                "</ul>\n" +
                "</body></html>");
        logger.log(Level.INFO, "doGet ended...");
    }
}
