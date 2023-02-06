package it.sincon.p2_presentazione_istanze_v2.DataAccess.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IRepository<E extends IEntity<T>, T extends Object> extends JpaRepository<E, T> {
    
}
