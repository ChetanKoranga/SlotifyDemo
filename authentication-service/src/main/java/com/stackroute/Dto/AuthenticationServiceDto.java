package com.stackroute.Dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "AuthServiceDTO")
public class AuthenticationServiceDto {

    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;


    @Column(name = "userName")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "userRole")
    private String userRole;

    @Column(name = "email")
    private String email;



    /*
     * public AuthenticationServiceDto(int userId, String userName, String password,
     * String userRole, String email) { super(); this.userId = userId; this.userName
     * = userName; this.password = password; this.userRole = userRole; this.email =
     * email; }
     */

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /*
     * public AuthenticationServiceDto() { super(); }
     */


}