package edu.co.icesi.servlets;

import edu.co.icesi.Application;
import edu.co.icesi.entities.Expedition;
import edu.co.icesi.services.ExpeditionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/expeditions/*")
public class ExpeditionServlet extends HttpServlet {

    private ExpeditionService expeditionService;

    @Override
    public void init() {
        expeditionService = Application.getContext().getBean(ExpeditionService.class);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String path = req.getPathInfo();

        switch (path) {
            case "/get":
                getAllExpeditions(req, resp);
                break;
            case "/add":
                showAddForm(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                break;
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String path = req.getPathInfo();

        if (path.equals("/add")) {
            addExpedition(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void getAllExpeditions(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Expeditions registered</h1>");

        resp.getWriter().println("<ul>");
        for (Expedition expedition : expeditionService.getExpeditions()) {
            resp.getWriter().println("<li>" + expedition + "</li>");
        }
        resp.getWriter().println("</ul>");
    }

    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/expeditions/add.html")
                .forward(req, resp);
    }

    private void addExpedition(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String code = req.getParameter("code");
        String region = req.getParameter("region");
        String baseCamp = req.getParameter("baseCamp");
        String leader = req.getParameter("leader");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        String state = req.getParameter("state");

        Expedition expedition = new Expedition(id, name, code, region, baseCamp, leader, startDate, endDate, state);
        String log = expeditionService.addExpedition(expedition);
        resp.setContentType("text/html");
        resp.getWriter().println("<p>" + log + "</p>");
    }
}
