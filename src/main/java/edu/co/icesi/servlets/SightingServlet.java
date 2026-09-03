package edu.co.icesi.servlets;

import edu.co.icesi.Application;
import edu.co.icesi.entities.Expedition;
import edu.co.icesi.entities.Sighting;
import edu.co.icesi.services.SightingService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet
public class SightingServlet extends HttpServlet {

    private SightingService sightingService;

    @Override
    public void init() {
        sightingService = Application.getContext().getBean(SightingService.class);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String path = req.getPathInfo();

        switch (path) {
            case "/get":
                getAllSightings(req, resp);
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
            addSighting(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void getAllSightings(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Sightings registered</h1>");

        resp.getWriter().println("<ul>");
        for (Sighting sighting : sightingService.getSightings()) {
            resp.getWriter().println("<li>" + sighting + "</li>");
        }
        resp.getWriter().println("</ul>");
    }

    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/sightings/add.html")
                .forward(req, resp);
    }

    private void addSighting(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String sightingCode = req.getParameter("sightingCode");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String scientificName = req.getParameter("scientificName");
        String sightedAt = req.getParameter("sightedAt");
        String location = req.getParameter("location");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int confidenceLevel = Integer.parseInt(req.getParameter("confidenceLevel"));
        int expeditionId = Integer.parseInt(req.getParameter("expeditionId"));

        Sighting sighting = new Sighting(id, sightingCode, name, description, scientificName, sightedAt, location, quantity, confidenceLevel, expeditionId);
        String log = sightingService.addSighting(sighting);
        resp.setContentType("text/html");
        resp.getWriter().println("<p>" + log + "</p>");
    }
}
