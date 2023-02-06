package it.sincon.p2_presentazione_istanze_v2.Services.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.sincon.p2_presentazione_istanze_v2.DataAccess.interfaces.IEntity;
import it.sincon.p2_presentazione_istanze_v2.DataAccess.interfaces.IRepository;
import it.sincon.p2_presentazione_istanze_v2.Services.interfaces.IDTO;
import it.sincon.p2_presentazione_istanze_v2.Services.interfaces.IMapper;

@SuppressWarnings("rawtypes")
public class BaseService<E extends IEntity, D extends IDTO> {
    
    protected final Logger log = LoggerFactory.getLogger(getClass());
 
	protected final IRepository repository;

	protected final IMapper mapper;

    protected final LogArea logArea;

	public BaseService(IRepository repository, IMapper mapper, LogArea logArea) {
    	this.repository=repository;
    	this.mapper=mapper;
        this.logArea = logArea;
    }


	protected E beforeSave(E entity) {
        return entity;
    }

    protected E beforeUpdate(E entity) {
        return entity;
    }

}
