package it.sincon.p2_presentazione_istanze_v2.be.Services.commons;

import it.sincon.p2_presentazione_istanze_v2.be.Services.interfaces.IDTO;

public class BaseDTO<T> implements IDTO<T> {

    protected T id;

    @Override
    public T getId() {
        return id;
    }

    @Override
    public void setId(T id) {
        this.id = id;
    }
    
}