package myfirstapp.ebuilders.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import retrofit2.http.POST;

/**
 * Created by acer on 12/22/2017.
 */

public class ResObj {

    @SerializedName("email")
    @Expose
   private String email ;
    @SerializedName("password")
    @Expose
   private String password ;



    public ResObj() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
