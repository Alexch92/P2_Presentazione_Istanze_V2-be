package it.sincon.p2_presentazione_istanze_v2.be.Services.interfaces;

import java.util.List;
import java.util.Set;

import it.sincon.p2_presentazione_istanze_v2.be.DataAccess.interfaces.IEntity;

@SuppressWarnings("rawtypes")
public interface IMapper<E extends IEntity, D> {

    public List<D> toMinDTOList(List<E> entities);
    public List<D> toMinDTOList(Iterable<E> entities);
    public Set<D> toMinDTOList(Set<E> entities);
    public List<D> toDTOList(List<E> entities);
    public List<D> toDTOList(Iterable<E> entities);
    public Set<D> toDTOList(Set<E> entities);
    public D toDTO(E entity);
    public D toMinDTO(E entity);

    public E toEntity(D dto);
    public E toEntity(E entity, D dto);
    public List<E> toEntityList(List<D> dtos);
    public Set<E> toEntityList(Set<D> dtos);

    public Set<?> toIdList(Set<E> entities);

    public E dtoToEntity(E entity, D dto);
}
