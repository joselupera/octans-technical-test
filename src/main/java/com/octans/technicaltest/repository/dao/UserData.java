package com.octans.technicaltest.repository.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table(name = "usuario")
public class UserData {
    @Id
    @Column(name = "id_usuario", nullable = false)
    private int id;
    @Column(name = "id_rol", nullable = false)
    private int idRol;
    @Column(name = "nombre", nullable = false)
    private String name;
    @Column(name = "activo", nullable = false)
    private String active;

    public UserData(int idRol, String name, String active) {
        this.idRol = idRol;
        this.name = name;
        this.active = active;
    }

    public UserData(int id, int idRol, String name, String active) {
        this.id = id;
        this.idRol = idRol;
        this.name = name;
        this.active = active;
    }
}
