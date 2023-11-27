package posting_website.User;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String hashed_password;
    private String display_name;
    private String email;
    private String phone;
    private Date date_joined;

    public AppUser() {

    }

    public AppUser(Long id, String hashed_password, String display_name, String email, String phone, Date date_joined) {
        this.id = id;
        this.hashed_password = hashed_password;
        this.display_name = display_name;
        this.email = email;
        this.phone = phone;
        this.date_joined = date_joined;
    }

    public AppUser(String hashed_password, String display_name, String email, String phone, Date date_joined) {
        this.hashed_password = hashed_password;
        this.display_name = display_name;
        this.email = email;
        this.phone = phone;
        this.date_joined = date_joined;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHashed_password() {
        return hashed_password;
    }

    public void setHashed_password(String hashed_password) {
        this.hashed_password = hashed_password;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate_joined() {
        return date_joined;
    }

    public void setDate_joined(Date date_joined) {
        this.date_joined = date_joined;
    }
}
