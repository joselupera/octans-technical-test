package com.octans.technicaltest.repository.dao;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "rol")
public class RoleData {
    @Id
    @Column(name = "id_rol")
    private int id;

    @Column(name = "nombre_rol")
    private String name;
}
