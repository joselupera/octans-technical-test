CREATE TABLE
    IF NOT EXISTS rol (

        id_rol      INTEGER         NOT NULL,
        nombre_rol  VARCHAR(64)     NOT NULL,

        PRIMARY KEY (id_rol)
    );

CREATE TABLE
    IF NOT EXISTS usuario (

        id_usuario  INTEGER         NOT NULL AUTO_INCREMENT,
        id_rol      INT             NOT NULL,
        nombre      VARCHAR (130)   NOT NULL,
        activo      CHAR            NOT NULL,

        PRIMARY KEY (id_usuario),
        FOREIGN KEY (id_rol) REFERENCES rol(id_rol)
    );

INSERT INTO rol (id_rol, nombre_rol) values (1, 'ADMINISTRADOR') ON DUPLICATE KEY UPDATE id_rol = id_rol;
INSERT INTO rol (id_rol, nombre_rol) values (2, 'AUDITOR') ON DUPLICATE KEY UPDATE id_rol = id_rol;
INSERT INTO rol (id_rol, nombre_rol) values (3, 'AUXILIAR') ON DUPLICATE KEY UPDATE id_rol = id_rol;