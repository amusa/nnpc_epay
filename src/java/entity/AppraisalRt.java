/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Ayemi
 */
@Entity
@Table(name = "appraisal_rt")
@NamedQueries({
    @NamedQuery(name = "AppraisalRt.findAll", query = "SELECT a FROM AppraisalRt a"),
    @NamedQuery(name = "AppraisalRt.findByEmployeeId", query = "SELECT a FROM AppraisalRt a WHERE a.appraisalRtPK.employeeId = :employeeId"),
    @NamedQuery(name = "AppraisalRt.findByYear", query = "SELECT a FROM AppraisalRt a WHERE a.appraisalRtPK.year = :year"),
    @NamedQuery(name = "AppraisalRt.findByIncrement", query = "SELECT a FROM AppraisalRt a WHERE a.increment = :increment"),
    @NamedQuery(name = "AppraisalRt.findByNewLevel", query = "SELECT a FROM AppraisalRt a WHERE a.newLevel = :newLevel"),
    @NamedQuery(name = "AppraisalRt.findByOldLevel", query = "SELECT a FROM AppraisalRt a WHERE a.oldLevel = :oldLevel")})
public class AppraisalRt implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AppraisalRtPK appraisalRtPK;
    @Column(name = "increment")
    private BigDecimal increment;
    @Column(name = "new_level")
    private String newLevel;
    @Column(name = "old_level")
    private String oldLevel;

    public AppraisalRt() {
    }

    public AppraisalRt(AppraisalRtPK appraisalRtPK) {
        this.appraisalRtPK = appraisalRtPK;
    }

    public AppraisalRt(String employeeId, long year) {
        this.appraisalRtPK = new AppraisalRtPK(employeeId, year);
    }

    public AppraisalRtPK getAppraisalRtPK() {
        return appraisalRtPK;
    }

    public void setAppraisalRtPK(AppraisalRtPK appraisalRtPK) {
        this.appraisalRtPK = appraisalRtPK;
    }

    public BigDecimal getIncrement() {
        return increment;
    }

    public void setIncrement(BigDecimal increment) {
        this.increment = increment;
    }

    public String getNewLevel() {
        return newLevel;
    }

    public void setNewLevel(String newLevel) {
        this.newLevel = newLevel;
    }

    public String getOldLevel() {
        return oldLevel;
    }

    public void setOldLevel(String oldLevel) {
        this.oldLevel = oldLevel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appraisalRtPK != null ? appraisalRtPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppraisalRt)) {
            return false;
        }
        AppraisalRt other = (AppraisalRt) object;
        if ((this.appraisalRtPK == null && other.appraisalRtPK != null) || (this.appraisalRtPK != null && !this.appraisalRtPK.equals(other.appraisalRtPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AppraisalRt[appraisalRtPK=" + appraisalRtPK + "]";
    }

}
