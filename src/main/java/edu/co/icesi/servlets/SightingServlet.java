package edu.co.icesi.servlets;

import edu.co.icesi.Application;
import edu.co.icesi.services.SightingService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet
public class SightingServlet extends HttpServlet {

    private SightingService sightingService;

    @Override
    public void init() {
        sightingService = Application.getContext().getBean(SightingService.class);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {

    }
}
