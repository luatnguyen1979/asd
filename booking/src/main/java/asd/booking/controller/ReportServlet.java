package asd.booking.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import asd.booking.dao.proxy.ReportDaoProxy;
import asd.booking.domain.Report;

public class ReportServlet extends HttpServlet {

    public ReportServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Report> reportList = null;
        try {
            String startDate = req.getParameter("startdate");
            String endDate = req.getParameter("enddate");
            if (startDate == null || startDate.isEmpty() || endDate == null || endDate.isEmpty()) {
                resp.sendRedirect("error.jsp");
            }
            ReportDaoProxy reportDaoProxy = new ReportDaoProxy(req);
            reportList = reportDaoProxy.getList(startDate, endDate);
            if (reportList != null && reportList.isEmpty()) {
                HttpSession session = req.getSession(true);
                session.setAttribute("reportlist", reportList);
                resp.sendRedirect("report.jsp"); // logged-in page
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("report.jsp"); // logged-in page
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
