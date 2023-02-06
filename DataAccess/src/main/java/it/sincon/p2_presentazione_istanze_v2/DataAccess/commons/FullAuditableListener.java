package it.sincon.p2_presentazione_istanze_v2.DataAccess.commons;

import java.net.UnknownHostException;
import java.util.Date;

import javax.persistence.PreRemove;

public class FullAuditableListener extends AuditableListener {
    
    @PreRemove
    public void onPreRemove(FullAuditable object) {
        audit("DELETE", object);
    }

    private void audit(String operation, FullAuditable object) {

        System.out.print("-------------------------------------------------------------------------------------------------------------------------------");
        System.getProperty("user.name"); //platform independent 
        java.net.InetAddress localMachine = null;

        try {
            localMachine = java.net.InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        if (localMachine != null) {
            object.setDeletedBy(localMachine.toString());
            object.setDeletedDate(new Date());
        }
    }
}
