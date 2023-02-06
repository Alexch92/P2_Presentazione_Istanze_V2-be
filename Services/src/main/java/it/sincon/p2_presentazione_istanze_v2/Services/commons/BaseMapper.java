package it.sincon.p2_presentazione_istanze_v2.Services.commons;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import it.sincon.p2_presentazione_istanze_v2.Services.interfaces.IDTO;
import it.sincon.p2_presentazione_istanze_v2.Services.interfaces.IMapper;

@SuppressWarnings("rawtypes")
public abstract class BaseMapper<E extends IEntity, D extends IDTO> implements IMapper<E, D> {

    @Override
    public List<D> toMinDTOList(List<E> entities) {
        return entities.stream()
                       .filter(Objects::nonNull)
                       .map(this::toMinDTO)
                       .collect(Collectors.toList());
    }

    @Override
    public List<D> toMinDTOList(Iterable<E> entities) {
        return StreamSupport.stream(entities.spliterator(), false)
                            .filter(Objects::nonNull)
                            .map(this::toMinDTO)
                            .collect(Collectors.toList());
    }

    @Override
    public Set<D> toMinDTOList(Set<E> entities) {
    	if(entities == null)
    		return null;
    	
        return entities.stream()
                       .filter(Objects::nonNull)
                       .map(this::toMinDTO)
                       .collect(Collectors.toSet());
    }

    @Override
    public List<D> toDTOList(List<E> entities) {
        return entities.stream()
                       .filter(Objects::nonNull)
                       .map(this::toDTO)
                       .collect(Collectors.toList());
    }

    @Override
    public List<D> toDTOList(Iterable<E> entities) {
        return StreamSupport.stream(entities.spliterator(), false)
                            .filter(Objects::nonNull)
                            .map(this::toDTO)
                            .collect(Collectors.toList());
    }

    @Override
    public Set<D> toDTOList(Set<E> entities) {
    	if(entities == null)
    		return null;
    	
        return entities.stream()
                       .filter(Objects::nonNull)
                       .map(this::toDTO)
                       .collect(Collectors.toSet());
    }

    @Override
    public List<E> toEntityList(List<D> dtos) {
        return dtos.stream()
                   .filter(Objects::nonNull)
                   .map(this::toEntity)
                   .collect(Collectors.toList());
    }

    @Override
    public Set<E> toEntityList(Set<D> dtos) {
    	if(dtos == null)
    		return null;
    	
        return dtos.stream()
                   .filter(Objects::nonNull)
                   .map(this::toEntity)
                   .collect(Collectors.toSet());
    }

    @Override
    public Set<?> toIdList(Set<E> entities) {
        return entities.stream()
                       .filter(Objects::nonNull)
                       .map(E::getId)
                       .collect(Collectors.toSet());
    }

    public Optional<D> toDTO(Optional<E> entity) {
        if (entity.isPresent()) {
            D dto = toMinDTO(entity.get());
            return Optional.of(dto);
        }

        return Optional.empty();
    }

    public E toEntity(E entity, D dto) {
        if (dto == null) {
            return null;
        } else {
            entity = dtoToEntity(entity, dto);
            return entity;
        }
    }

}
