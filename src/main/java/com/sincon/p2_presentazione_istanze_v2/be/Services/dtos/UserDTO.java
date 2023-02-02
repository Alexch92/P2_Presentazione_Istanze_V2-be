package com.sincon.p2_presentazione_istanze_v2.be.Services.dtos;

import com.sincon.p2_presentazione_istanze_v2.be.Services.commons.BaseDTO;

public class UserDTO extends BaseDTO<Integer> {

    private String name;
    private String email;

    
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
