package it.sincon.p2_presentazione_istanze_v2.be.DataAccess.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import it.sincon.p2_presentazione_istanze_v2.be.DataAccess.commons.FullAuditable;
import it.sincon.p2_presentazione_istanze_v2.be.DataAccess.interfaces.IEntity;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "\"USER\"")
public class User extends FullAuditable implements IEntity<Integer> {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "\"USR_ID\"")
    private Integer id;

    @Column(name= "\"USR_NAME\"")
    private String name;

    @Column(name= "\"USR_EMAIL\"")
    private String email;

    
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
