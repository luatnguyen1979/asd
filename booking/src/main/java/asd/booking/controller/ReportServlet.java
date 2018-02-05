package asd.booking.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import asd.framework.booking.dao.proxy.ReportDaoProxy;
import asd.framework.booking.domain.Report;
import asd.framework.booking.logger.AbstractLogger;
import asd.framework.booking.logger.ChainBuilderLogger;
import asd.framework.booking.logger.LogLevel;

public class ReportServlet extends HttpServlet {

	private AbstractLogger logger = ChainBuilderLogger.getLogger();
    public ReportServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	logger.logMessage(LogLevel.INFO, "Starting ReportServlet");    
    	List<Report> reportList = null;
        try {
            String startDate = "2017-01-01";
            String endDate = "2018-12-31";
            if (startDate == null || startDate.isEmpty() || endDate == null || endDate.isEmpty()) {
                resp.sendRedirect("error.jsp");
            }
            ReportDaoProxy reportDaoProxy = new ReportDaoProxy(req);
            //ReportDAO reportProxy = new ReportDAO();
            
//            DAOFactory daoFactory = DAOFactory.getInstance("javabase.jdbc");
//			ReportDAO reportDAO = daoFactory.getReportDAO();
			
			
            //reportList = reportProxy.getList(startDate, endDate);
			reportList = reportDaoProxy.getList(startDate, endDate);
            if (reportList != null && !reportList.isEmpty()) {
                HttpSession session = req.getSession(true);
                session.setAttribute("reportlist", reportList);
                resp.sendRedirect("report.jsp"); // logged-in page
            }
        } catch (Exception e) {
            e.printStackTrace();
        	logger.logMessage(LogLevel.DEBUG, e.getMessage());
            resp.sendRedirect("errorreport.jsp"); // logged-in page
        } finally {
        	logger.logMessage(LogLevel.INFO, "Ending ReportServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
