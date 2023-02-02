package com.sincon.p2_presentazione_istanze_v2.be.Services.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sincon.p2_presentazione_istanze_v2.be.Commons.Enums.LogArea;
import com.sincon.p2_presentazione_istanze_v2.be.Services.commons.BaseService;
import com.sincon.p2_presentazione_istanze_v2.be.DataAccess.entities.User;
import com.sincon.p2_presentazione_istanze_v2.be.Services.dtos.UserDTO;
import com.sincon.p2_presentazione_istanze_v2.be.Services.mappers.UserMapper;
import com.sincon.p2_presentazione_istanze_v2.be.DataAccess.repositories.UserRepository;

@Service
public class UserService extends BaseService<User, UserDTO> {
    

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        super(userRepository, userMapper, LogArea.SERVICE);
    }

    
    public UserDTO GetById(Integer id) {
        
        log.debug("Area: " + logArea + this.getClass().getName() + " " + "GetById");

        UserDTO userDTO = null;

        Optional<User> optional = ((UserRepository)repository).findById(id);

        if(optional.isPresent()){

            User user = optional.get();
            userDTO = ((UserMapper)mapper).toDTO(user);
        }

        return userDTO;
    }

    public List<UserDTO> GetAll() {

        log.debug("Area: " + logArea + this.getClass().getName() + " " + "GetAll");
        
        List<UserDTO> userDTOs = null;

        List<User> entities = ((UserRepository)repository).findAll();

        if(entities != null && !entities.isEmpty()){

            userDTOs = ((UserMapper)mapper).toDTOList(entities);
        }

        return userDTOs;
    }

    public UserDTO Create(UserDTO userDTO) {
        
        log.debug("Area: " + logArea + this.getClass().getName() + " " + "Create");

        User user = ((UserMapper)mapper).toEntity(userDTO);
        user.setId(null);
        user = ((UserRepository)repository).save(user);
        userDTO = ((UserMapper)mapper).toDTO(user);

        return userDTO;
    }

    public UserDTO Update(Integer id, UserDTO userDTO) {
        
        log.debug("Area: " + logArea + this.getClass().getName() + " " + "Update");

        Optional<User> optional = ((UserRepository)repository).findById(id);

        if(optional.isPresent()){

            User user = optional.get();
            userDTO.setId(id);
            user = ((UserMapper)mapper).dtoToEntity(user, userDTO);
            user = ((UserRepository)repository).save(user);
            userDTO = ((UserMapper)mapper).toDTO(user);
        }

        return userDTO;
    }

    public UserDTO Delete(Integer id) {
        
        log.debug("Area: " + logArea + this.getClass().getName() + " " + "Update");

        UserDTO userDTO = null;
        Optional<User> optional = ((UserRepository)repository).findById(id);

        if(optional.isPresent()){

            User user = optional.get();
            ((UserRepository)repository).delete(user);
            userDTO = ((UserMapper)mapper).toDTO(user);
        }

        return userDTO;
    }

}
