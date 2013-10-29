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
@Table(name = "one_off_payment")
@NamedQueries({
    @NamedQuery(name = "OneOffPayment.findAll", query = "SELECT o FROM OneOffPayment o"),
    @NamedQuery(name = "OneOffPayment.findByYear", query = "SELECT o FROM OneOffPayment o WHERE o.oneOffPaymentPK.year = :year"),
    @NamedQuery(name = "OneOffPayment.findByWageType", query = "SELECT o FROM OneOffPayment o WHERE o.oneOffPaymentPK.wageType = :wageType"),
    @NamedQuery(name = "OneOffPayment.findByEmployeeId", query = "SELECT o FROM OneOffPayment o WHERE o.oneOffPaymentPK.employeeId = :employeeId"),
    @NamedQuery(name = "OneOffPayment.findByDescription", query = "SELECT o FROM OneOffPayment o WHERE o.description = :description"),
    @NamedQuery(name = "OneOffPayment.findByAmount", query = "SELECT o FROM OneOffPayment o WHERE o.amount = :amount")})
public class OneOffPayment implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OneOffPaymentPK oneOffPaymentPK;
    @Column(name = "description")
    private String description;
    @Column(name = "amount")
    private BigDecimal amount;

    public OneOffPayment() {
    }

    public OneOffPayment(OneOffPaymentPK oneOffPaymentPK) {
        this.oneOffPaymentPK = oneOffPaymentPK;
    }

    public OneOffPayment(long year, String wageType, String employeeId) {
        this.oneOffPaymentPK = new OneOffPaymentPK(year, wageType, employeeId);
    }

    public OneOffPaymentPK getOneOffPaymentPK() {
        return oneOffPaymentPK;
    }

    public void setOneOffPaymentPK(OneOffPaymentPK oneOffPaymentPK) {
        this.oneOffPaymentPK = oneOffPaymentPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oneOffPaymentPK != null ? oneOffPaymentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OneOffPayment)) {
            return false;
        }
        OneOffPayment other = (OneOffPayment) object;
        if ((this.oneOffPaymentPK == null && other.oneOffPaymentPK != null) || (this.oneOffPaymentPK != null && !this.oneOffPaymentPK.equals(other.oneOffPaymentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OneOffPayment[oneOffPaymentPK=" + oneOffPaymentPK + "]";
    }

}
