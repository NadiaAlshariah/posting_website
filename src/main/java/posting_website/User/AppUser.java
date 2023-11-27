package posting_website.User;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String hashedPassword;
    private String displayName;
    private String email;
    private String phone;
    private Date dateJoined;

    public AppUser() {

    }

    public AppUser(Long id, String hashedPassword, String displayName, String email, String phone, Date dateJoined) {
        this.id = id;
        this.hashedPassword = hashedPassword;
        this.displayName = displayName;
        this.email = email;
        this.phone = phone;
        this.dateJoined = dateJoined;
    }

    public AppUser(String hashedPassword, String displayName, String email, String phone, Date dateJoined) {
        this.hashedPassword = hashedPassword;
        this.displayName = displayName;
        this.email = email;
        this.phone = phone;
        this.dateJoined = dateJoined;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashed_password) {
        this.hashedPassword = hashed_password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String display_name) {
        this.displayName = display_name;
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

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date date_joined) {
        this.dateJoined = date_joined;
    }
}
