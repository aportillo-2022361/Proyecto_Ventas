package com.ventas.proyect.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "codigo_user")
    private Integer codigoUser;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public Integer getCodigoUser() {
        return codigoUser;
    }

    public void setCodigoUser(Integer codigoUser) {
        this.codigoUser = codigoUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
