package com.sincon.p2_presentazione_istanze_v2.be.DataAccess.interfaces;

public interface IEntity<T extends Object> {
    
    public T getId();
    public void setId(T id);
}
