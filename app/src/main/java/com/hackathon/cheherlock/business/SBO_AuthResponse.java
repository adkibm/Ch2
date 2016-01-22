package com.hackathon.cheherlock.business;

import com.hackathon.cheherlock.business.*;
import com.hackathon.cheherlock.interfaces.SportusBusinessObject;

/**
 * Created by Ravinder Nath Kamra on 8/30/2015.
 */
public class SBO_AuthResponse implements SportusBusinessObject {

    private String action_type = "";
    private boolean error = false;
    private String uid = "";
    private String error_msg="";
    private com.hackathon.cheherlock.business.SBO_User user = null;

    public void setAction_type(String action_type) {
        this.action_type = action_type;
    }

    public boolean getError() {return this.error;}

    public void setError(boolean error) {
        this.error = error;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setUser(com.hackathon.cheherlock.business.SBO_User user) {
        this.user = user;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public String getError_msg(){return this.error_msg;}

    @Override
    public String parseToJson() {
        return null;
    }
}
