package it.sincon.p2_presentazione_istanze_v2.be.DataAccess.commons;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(AuditableListener.class)
public class Auditable {
    
    @Column(name = "\"CREATED_BY\"", nullable = false, updatable = false)
    private String createdBy;

    @Column(name = "\"CREATED_DATE\"", updatable = false)
    private Date createdDate;

    @Column(name = "\"LAST_MODIFIED_BY\"")
    private String modifiedBy;

    @Column(name = "\"LAST_MODIFIED_DATE\"")
    private Date modifiedDate;


    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

}
