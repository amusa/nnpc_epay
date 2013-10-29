/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Ayemi
 */
@Embeddable
public class AppraisalRtPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "employee_id")
    private String employeeId;
    @Basic(optional = false)
    @Column(name = "year")
    private long year;

    public AppraisalRtPK() {
    }

    public AppraisalRtPK(String employeeId, long year) {
        this.employeeId = employeeId;
        this.year = year;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        hash += (int) year;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppraisalRtPK)) {
            return false;
        }
        AppraisalRtPK other = (AppraisalRtPK) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AppraisalRtPK[employeeId=" + employeeId + ", year=" + year + "]";
    }

}
