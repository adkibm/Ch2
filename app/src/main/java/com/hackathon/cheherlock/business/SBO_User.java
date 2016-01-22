package com.hackathon.cheherlock.business;

import com.hackathon.cheherlock.interfaces.SportusBusinessObject;

/**
 * Created by Ravinder Nath Kamra on 8/30/2015.
 */
public class SBO_User implements SportusBusinessObject {
    private String name;
    private String email;
    private String created_at;
    @Override
    public String parseToJson() {
        return null;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
}
