package mx.com.icvt.model;

/**
 * Created by lnx1337 on 27/04/14.
 */

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable(table="user")
public class User {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    public int id;

    @Persistent
    public int unidad_economica_id;

    @Persistent
    public int role_site_id;

    @Persistent
    public int role_social_id;

    @Persistent
    public String identity;

    @Persistent
    public String password;

    @Persistent
    public String name;

    @Persistent
    public  String first_name;

    @Persistent
    public String last_name;

    @Persistent
    public String phone;

    @Persistent
    public String avatar;

    @Persistent
    public int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUnidad_economica_id() {
        return unidad_economica_id;
    }

    public void setUnidad_economica_id(int unidad_economica_id) {
        this.unidad_economica_id = unidad_economica_id;
    }

    public int getRole_site_id() {
        return role_site_id;
    }

    public void setRole_site_id(int role_site_id) {
        this.role_site_id = role_site_id;
    }

    public int getRole_social_id() {
        return role_social_id;
    }

    public void setRole_social_id(int role_social_id) {
        this.role_social_id = role_social_id;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setStatus(int status) {
        this.status = status;
    }



}
