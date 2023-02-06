package it.sincon.p2_presentazione_istanze_v2.be.Services.mappers;

import org.springframework.stereotype.Service;

import it.sincon.p2_presentazione_istanze_v2.be.DataAccess.entities.User;
import it.sincon.p2_presentazione_istanze_v2.be.Services.commons.BaseMapper;
import it.sincon.p2_presentazione_istanze_v2.be.Services.dtos.UserDTO;

@Service
public class UserMapper extends BaseMapper<User, UserDTO> {

    @Override
    public UserDTO toDTO(User entity) {
        if (entity==null)
			return null;

		UserDTO result = toMinDTO(entity);
		return result;
    }

    @Override
    public UserDTO toMinDTO(User entity) {

        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        return dto;
    }

    @Override
    public User toEntity(UserDTO dto) {
        if (dto==null)
            return null;
        else {
            User result = new User();
            result = dtoToEntity(result, dto);
            return result;
        }
    }

    @Override
    public User dtoToEntity(User entity, UserDTO dto) {

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        return entity;
    }
    
}
