/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import utility.DateDiff;

/**
 *
 * @author Ayemi
 */
@Entity
@Table(name = "employee")
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id"),
    @NamedQuery(name = "Employee.findByFirstName", query = "SELECT e FROM Employee e WHERE e.firstName = :firstName"),
    @NamedQuery(name = "Employee.findByLastName", query = "SELECT e FROM Employee e WHERE e.lastName = :lastName"),
    @NamedQuery(name = "Employee.findByDept", query = "SELECT e FROM Employee e WHERE e.dept = :dept"),
    @NamedQuery(name = "Employee.findByMiddleName", query = "SELECT e FROM Employee e WHERE e.middleName = :middleName"),
    @NamedQuery(name = "Employee.findByGradeLevel", query = "SELECT e FROM Employee e WHERE e.gradeLevel = :gradeLevel"),
    @NamedQuery(name = "Employee.findByLocation", query = "SELECT e FROM Employee e WHERE e.location = :location"),
    @NamedQuery(name = "Employee.findByBankn", query = "SELECT e FROM Employee e WHERE e.bankn = :bankn"),
    @NamedQuery(name = "Employee.findByAcctNumber", query = "SELECT e FROM Employee e WHERE e.acctNumber = :acctNumber"),
    @NamedQuery(name = "Employee.findByDateInNnpc", query = "SELECT e FROM Employee e WHERE e.dateInNnpc = :dateInNnpc"),
    @NamedQuery(name = "Employee.findByPosition", query = "SELECT e FROM Employee e WHERE e.position = :position"),
    @NamedQuery(name = "Employee.findByPersonnelArea", query = "SELECT e FROM Employee e WHERE e.personnelArea = :personnelArea"),
    @NamedQuery(name = "Employee.findByCompany", query = "SELECT e FROM Employee e WHERE e.company = :company"),
    @NamedQuery(name = "Employee.findByDob", query = "SELECT e FROM Employee e WHERE e.dob = :dob"),
    @NamedQuery(name = "Employee.findByServiceYearsTransfered", query = "SELECT e FROM Employee e WHERE e.serviceYearsTransfered = :serviceYearsTransfered"),
    @NamedQuery(name = "Employee.findByCas", query = "SELECT e FROM Employee e WHERE e.cas = :cas")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "dept")
    private String dept;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "grade_level")
    private String gradeLevel;
    @Column(name = "location")
    private String location;
    @Column(name = "bankn")
    private String bankn;
    @Column(name = "acct_number")
    private String acctNumber;
    @Column(name = "date_in_nnpc")
    @Temporal(TemporalType.DATE)
    private Date dateInNnpc;
    @Column(name = "position")
    private String position;
    @Column(name = "personnel_area")
    private String personnelArea;
    @Column(name = "company")
    private String company;
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(name = "service_years_transfered")
    private Integer serviceYearsTransfered;
    @Column(name = "cas")
    private BigDecimal cas;

    public Employee() {
    }

    public Employee(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBankn() {
        return bankn;
    }

    public void setBankn(String bankn) {
        this.bankn = bankn;
    }

    public String getAcctNumber() {
        return acctNumber;
    }

    public void setAcctNumber(String acctNumber) {
        this.acctNumber = acctNumber;
    }

    public Date getDateInNnpc() {
        return dateInNnpc;
    }

    public void setDateInNnpc(Date dateInNnpc) {
        this.dateInNnpc = dateInNnpc;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPersonnelArea() {
        return personnelArea;
    }

    public void setPersonnelArea(String personnelArea) {
        this.personnelArea = personnelArea;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Integer getServiceYearsTransfered() {
        return serviceYearsTransfered;
    }

    public void setServiceYearsTransfered(Integer serviceYearsTransfered) {
        this.serviceYearsTransfered = serviceYearsTransfered;
    }

    public BigDecimal getCas() {
        return cas;
    }

    public void setCas(BigDecimal cas) {
        this.cas = cas;
    }

    public int getAge() {
        DateDiff diff = new DateDiff(dob, new Date());
        return diff.getYearDiff();
    }

    public int getServiceYearsNnpc() {
        DateDiff diff = new DateDiff(dateInNnpc, new Date());
        return diff.getYearDiff();
    }

    public int getYearsOfService() {

        return getServiceYearsNnpc() + serviceYearsTransfered;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName + " " + middleName;
    }
}
