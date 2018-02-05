package asd.framework.booking.dao;

import java.util.List;

import asd.framework.booking.domain.Report;

public interface ReportDAO {

    
    public List<Report> getList(String startDate, String endDate);
    public void insert(Report report);
}
