package it.sincon.p2_presentazione_istanze_v2.DataAccess.commons;

import java.net.UnknownHostException;
import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class AuditableListener {
    
    @PrePersist
    public void onPrePersist(Auditable object) {
        audit("INSERT", object);
    }
     
    @PreUpdate
    public void onPreUpdate(Auditable object) {
        audit("UPDATE", object);
    }
     
    private void audit(String operation, Auditable object) {

        System.out.print("-------------------------------------------------------------------------------------------------------------------------------");
        System.getProperty("user.name"); //platform independent 
        java.net.InetAddress localMachine = null;

        try {
            localMachine = java.net.InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        switch (operation){

            case "INSERT":
                if (localMachine != null) {
                    object.setCreatedBy(localMachine.getHostName());
                }
                object.setCreatedDate(new Date());
                break;

            case "UPDATE":
                if (localMachine != null) {
                    object.setModifiedBy(localMachine.getHostName());
                }
                object.setModifiedDate(new Date());
                break;

        }
    }

}
