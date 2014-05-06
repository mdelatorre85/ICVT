package mx.com.icvt.persistence.impl.user;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int unidad_economica_id;
    private int role_site_id;
    private int role_social_id;
    private String identity;
    private String password;
    private String name;
    private String first_name;
    private String last_name;
    private String phone;
    private String avatar;
    private int status;

    public User() {
    }

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
