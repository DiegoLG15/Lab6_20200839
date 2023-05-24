package com.example.lab6_sol.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    @Size(min = 3, max = 100, message = "El tamaño debe estar entre 3 y 100 caracteres")
    @NotBlank
    private String nombres;

    @Column(nullable = false)
    @Size(min = 3, max = 100, message = "El tamaño debe estar entre 3 y 100 caracteres")
    @NotBlank
    private String apellidos;

    @Column(nullable = false)
    @Digits(integer = 8, fraction = 0, message = "El valor debe ser un número entero de 8 dígitos")
    private String dni;

    @Digits(integer = 3, fraction = 0, message = "El valor debe ser un número entero de 3 dígitos")
    @Min(value = 0, message = "El valor debe ser positivo")
    @Column(nullable = false)
    private int edad;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean activo;

    @Column(nullable = false)
    private int rolid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public int getRolid() {
        return rolid;
    }

    public void setRolid(int rolid) {
        this.rolid = rolid;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}