/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.EpayBean;
import entity.AppraisalRt;
import entity.Employee;
import exception.NoAppraisalException;
import exception.NoSuchEmployeeException;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.StreamedContent;
import utility.CombinationGauge;
import utility.GaugeFactory;

/**
 *
 * @author Ayemi
 */
@ManagedBean
@ViewScoped
public class EmployeeBean {

    @EJB
    private EpayBean epayBean;
    @ManagedProperty(value = "#{frontBean}")
    private FrontBean frontBean;
    private Employee employee;
    private GaugeFactory ageChart, serviceChart;
    private CombinationGauge appraisalChart;
    private AppraisalRt appraisal;

    /** Creates a new instance of EmployeeBean */
    public EmployeeBean() {
    }

    @PostConstruct
    public void init() throws NoSuchEmployeeException, NoAppraisalException {
        employee = epayBean.findEmployee(frontBean.getUserId());
        ageChart = new GaugeFactory(40, 50, 60, employee.getAge(), "Age Gauge");
        System.out.println("Age :" + employee.getAge());
        serviceChart = new GaugeFactory(25, 30, 35, employee.getYearsOfService(), "Service Gauge");
        System.out.println("Service year :" + employee.getYearsOfService());
        appraisal = epayBean.findAppraisal(frontBean.getUserId());
        appraisalChart = new CombinationGauge(appraisal.getIncrement().toString());

    }

    public void setFrontBean(FrontBean frontBean) {
        this.frontBean = frontBean;
    }

    public StreamedContent getAgeChart() {
        return ageChart.getChart();
    }

    public StreamedContent getServiceChart() {
        return serviceChart.getChart();
    }

    public StreamedContent getAppraisalChart() {
        return appraisalChart.getChart();
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public AppraisalRt getAppraisal() {
        return appraisal;
    }

    public void setAppraisal(AppraisalRt appraisal) {
        this.appraisal = appraisal;
    }

    public long getAgePerc() {
        return Math.round(employee.getAge() / 60.0 * 100.0);
    }

    public long getServPerc() {
        double percent = employee.getYearsOfService() / 35.0 * 100.0;
        return Math.round(percent);
    }
}
