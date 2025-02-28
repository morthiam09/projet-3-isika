package com.formation.security.dto;

public class RegisterDTO {

    private String username;
    private String password;
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
    public RegisterDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public RegisterDTO() {
    }

    // Aojouter les autres champs de l'utilisateur si besoin
    // Ce dto sert à récupérer les données de l'utilisateur lors de son inscription, username, passeword, email, etc...
    // Il est utilisé dans le controller pour récupérer les données de l'utilisateur

}
