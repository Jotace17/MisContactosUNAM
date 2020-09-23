package com.caselles.miscontactos;

public class contacto {
    private String nombre;
    private String telefono;
    private String email;
    private String nacimiento;
    private String descripcion;


    public contacto(String nombre, String telefono, String email, String nacimiento, String descripcion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.nacimiento = nacimiento;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
