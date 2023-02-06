package it.sincon.p2_presentazione_istanze_v2.DataAccess.commons;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(FullAuditableListener.class)
public class FullAuditable extends Auditable{
    
    @Column(name = "\"DELETED_BY\"",  nullable = true, length = 50, updatable = true)
    private String deletedBy;

    @Column(name = "\"DELETED_DATE\"", updatable = true)
    private Date deletedDate;


    public String getDeletedBy() {
        return this.deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Date getDeletedDate() {
        return this.deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }
}
