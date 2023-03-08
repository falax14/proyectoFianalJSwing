CREATE DATABASE IF NOT EXISTS AtiloMan;
USE AtiloMan;

/* Eliminamos la Primera parte */
DROP TABLE IF EXISTS basica;
DROP TABLE IF EXISTS calendario_festivo;
DROP TABLE IF EXISTS cambio_turno;
DROP TABLE IF EXISTS categoria_equipo;
DROP TABLE IF EXISTS ciclo_detail;
DROP TABLE IF EXISTS cobertura_equipo;
DROP TABLE IF EXISTS contrato_ausencia;
DROP TABLE IF EXISTS jornada_teorica;
DROP TABLE IF EXISTS planificacion;
DROP TABLE IF EXISTS puesto_ciclo;
DROP TABLE IF EXISTS rol_recurso;
DROP TABLE IF EXISTS rol_usuario;
DROP TABLE IF EXISTS servicios_previos;
DROP TABLE IF EXISTS tarea;
DROP TABLE IF EXISTS turno_detail;
DROP TABLE IF EXISTS turno_master;
DROP TABLE IF EXISTS usuario_estructura;

/* Eliminamos la Segunda parte */
DROP TABLE IF EXISTS ausencia;
DROP TABLE IF EXISTS ciclo_master;
DROP TABLE IF EXISTS contrato;
DROP TABLE IF EXISTS estructura;
DROP TABLE IF EXISTS persona;
DROP TABLE IF EXISTS recurso;
DROP TABLE IF EXISTS rol;
DROP TABLE IF EXISTS unit;
DROP TABLE IF EXISTS usuario;

/* Eliminamos la Tercera parte */
DROP TABLE IF EXISTS cargo;
DROP TABLE IF EXISTS categoria_profesional;
DROP TABLE IF EXISTS tipo_unit;

/* Creamos las tablas */
CREATE TABLE IF NOT EXISTS `usuario`
(
    `id`         INTEGER      NOT NULL AUTO_INCREMENT,
    `persona_id` INTEGER,
    `nick`       VARCHAR(16)  NOT NULL UNIQUE,
    `passwd`     VARCHAR(300) NOT NULL,
    `fecha_alta` DATE         NOT NULL,
    `fecha_baja` DATE,
    `intentos`   INTEGER      NOT NULL DEFAULT 5,
    `activo`     VARCHAR(1)   NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `persona`
(
    `id`            INTEGER      NOT NULL AUTO_INCREMENT,
    `dni`           VARCHAR(9)   NOT NULL UNIQUE,
    `nombre`        VARCHAR(100) NOT NULL,
    `apellidos`     VARCHAR(150) NOT NULL,
    `direccion`     VARCHAR(300),
    `cp`            VARCHAR(5),
    `poblacion`     VARCHAR(100),
    `provincia`     VARCHAR(50),
    `pais`          VARCHAR(50),
    `tlfno1`        VARCHAR(20),
    `tlfno2`        VARCHAR(20),
    `email`         VARCHAR(50),
    `observaciones` VARCHAR(500),
    `sexo`          VARCHAR(1),
    `fnac`          DATE,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `tipo_unit`
(
    `id`            INTEGER      NOT NULL AUTO_INCREMENT,
    `codigo`        VARCHAR(5)   NOT NULL UNIQUE,
    `descripcion`   VARCHAR(255) NOT NULL,
    `activo`        VARCHAR(1)   NOT NULL,
    `observaciones` VARCHAR(255),
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `turno_master`
(
    `id`           INTEGER      NOT NULL AUTO_INCREMENT,
    `codigo`       VARCHAR(5)   NOT NULL UNIQUE,
    `descripcion`  VARCHAR(255) NOT NULL UNIQUE,
    `cuenta_horas` VARCHAR(1)   NOT NULL,
    `activo`       VARCHAR(1)   NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `planificacion`
(
    `mes`                  INTEGER    NOT NULL,
    `anno`                 INTEGER    NOT NULL,
    `puesto_id`            INTEGER    NOT NULL,
    `fecha_inicio`         DATE       NOT NULL,
    `ciclo_master_id`      INTEGER    NOT NULL,
    `fecha_fin`            DATE       NOT NULL,
    `total_dias`           INTEGER    NOT NULL,
    `semana`               INTEGER    NOT NULL,
    `dia1`                 VARCHAR(5),
    `dia2`                 VARCHAR(5),
    `dia3`                 VARCHAR(5),
    `dia4`                 VARCHAR(5),
    `dia5`                 VARCHAR(5),
    `dia6`                 VARCHAR(5),
    `dia7`                 VARCHAR(5),
    `dia8`                 VARCHAR(5),
    `dia9`                 VARCHAR(5),
    `dia10`                VARCHAR(5),
    `dia11`                VARCHAR(5),
    `dia12`                VARCHAR(5),
    `dia13`                VARCHAR(5),
    `dia14`                VARCHAR(5),
    `dia15`                VARCHAR(5),
    `dia16`                VARCHAR(5),
    `dia17`                VARCHAR(5),
    `dia18`                VARCHAR(5),
    `dia19`                VARCHAR(5),
    `dia20`                VARCHAR(5),
    `dia21`                VARCHAR(5),
    `dia22`                VARCHAR(5),
    `dia23`                VARCHAR(5),
    `dia24`                VARCHAR(5),
    `dia25`                VARCHAR(5),
    `dia26`                VARCHAR(5),
    `dia27`                VARCHAR(5),
    `dia28`                VARCHAR(5),
    `dia29`                VARCHAR(5),
    `dia30`                VARCHAR(5),
    `dia31`                VARCHAR(5),
    `es_lunes_festivo`     VARCHAR(1) NOT NULL,
    `es_martes_festivo`    VARCHAR(1) NOT NULL,
    `es_miercoles_festivo` VARCHAR(1) NOT NULL,
    `es_jueves_festivo`    VARCHAR(1) NOT NULL,
    `es_viernes_festivo`   VARCHAR(1) NOT NULL,
    `es_sabado_festivo`    VARCHAR(1) NOT NULL,
    `es_domingo_festivo`   VARCHAR(1) NOT NULL,
    `turno_libre_id`       INTEGER    NOT NULL,
    PRIMARY KEY (`mes`, `anno`, `puesto_id`, `fecha_inicio`)
);

CREATE TABLE IF NOT EXISTS `cargo`
(
    `id`            INTEGER      NOT NULL AUTO_INCREMENT,
    `codigo`        VARCHAR(5)   NOT NULL UNIQUE,
    `descripcion`   VARCHAR(255) NOT NULL UNIQUE,
    `observaciones` VARCHAR(500),
    `activo`        VARCHAR(1)   NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `categoria_profesional`
(
    `id`          INTEGER      NOT NULL AUTO_INCREMENT,
    `codigo`      VARCHAR(5)   NOT NULL UNIQUE,
    `descripcion` VARCHAR(255) NOT NULL UNIQUE,
    `activo`      VARCHAR(1)   NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ausencia`
(
    `id`                       INTEGER      NOT NULL AUTO_INCREMENT,
    `codigo`                   VARCHAR(5)   NOT NULL UNIQUE,
    `descripcion`              VARCHAR(255) NOT NULL UNIQUE,
    `cuenta_horas`             VARCHAR(1)   NOT NULL,
    `cuenta_dias`              VARCHAR(1)   NOT NULL,
    `max_ausencia_anual`       INTEGER,
    `activar_control_ausencia` VARCHAR(1)   NOT NULL,
    `forzar_ausencia`          VARCHAR(1)   NOT NULL,
    `observaciones`            VARCHAR(500),
    `activo`                   VARCHAR(1)   NOT NULL,
    `estado_devengo`           INTEGER      NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `basica`
(
    `id`                   INTEGER      NOT NULL,
    `version`              VARCHAR(20)  NOT NULL,
    `revision`             VARCHAR(20)  NOT NULL,
    `nombre`               VARCHAR(20)  NOT NULL,
    `descripcion`          VARCHAR(255) NOT NULL,
    `es_lunes_festivo`     INTEGER      NOT NULL,
    `es_martes_festivo`    INTEGER      NOT NULL,
    `es_miercoles_festivo` INTEGER      NOT NULL,
    `es_jueves_festivo`    INTEGER      NOT NULL,
    `es_viernes_festivo`   INTEGER      NOT NULL,
    `es_sabado_festivo`    VARCHAR(1)   NOT NULL,
    `es_domingo_festivo`   VARCHAR(1)   NOT NULL,
    `licencia`             TEXT         NOT NULL,
    `empresa`              VARCHAR(100),
    `m_inicio`             VARCHAR(5),
    `m_fin`                VARCHAR(5),
    `t_inicio`             VARCHAR(5),
    `t_fin`                VARCHAR(5),
    `n_inicio`             VARCHAR(5),
    `n_fin`                VARCHAR(5),
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `rol`
(
    `id`            INTEGER      NOT NULL AUTO_INCREMENT,
    `codigo`        VARCHAR(5)   NOT NULL UNIQUE,
    `descripcion`   VARCHAR(255) NOT NULL UNIQUE,
    `observaciones` VARCHAR(500),
    `activo`        VARCHAR(1)   NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `recurso`
(
    `id`            INTEGER      NOT NULL AUTO_INCREMENT,
    `codigo`        VARCHAR(5)   NOT NULL UNIQUE,
    `descripcion`   VARCHAR(255) NOT NULL UNIQUE,
    `activo`        VARCHAR(1)   NOT NULL,
    `observaciones` VARCHAR(500),
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ciclo_master`
(
    `id`             INTEGER      NOT NULL,
    `codigo`         VARCHAR(5)   NOT NULL UNIQUE,
    `descripcion`    VARCHAR(255) NOT NULL UNIQUE,
    `cuenta_festivo` VARCHAR(1)   NOT NULL,
    `activo`         VARCHAR(1)   NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `turno_detail`
(
    `turno_master_id` INTEGER    NOT NULL,
    `id`              INTEGER    NOT NULL,
    `dia_inicial`     INTEGER    NOT NULL,
    `dia_final`       INTEGER    NOT NULL,
    `hora_inicio`     VARCHAR(5) NOT NULL,
    `hora_fin`        VARCHAR(5) NOT NULL,
    PRIMARY KEY (`turno_master_id`, `id`),
    FOREIGN KEY (`turno_master_id`) REFERENCES `turno_master` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS `unit`
(
    `id`            INTEGER      NOT NULL AUTO_INCREMENT,
    `tipo_unit_id`  INTEGER      NOT NULL,
    `codigo`        VARCHAR(5)   NOT NULL UNIQUE,
    `descripcion`   VARCHAR(255) NOT NULL UNIQUE,
    `activo`        VARCHAR(1)   NOT NULL,
    `direccion`     VARCHAR(255),
    `poblacion`     VARCHAR(255),
    `cp`            VARCHAR(5),
    `provincia`     VARCHAR(50),
    `pais`          VARCHAR(50),
    `telefono1`     VARCHAR(20),
    `telefono2`     VARCHAR(20),
    `observaciones` VARCHAR(500),
    `email`         VARCHAR(50),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`tipo_unit_id`) REFERENCES `tipo_unit` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS `estructura`
(
    `centro_fisico_id` INTEGER    NOT NULL,
    `servicio_id`      INTEGER    NOT NULL,
    `categoria_id`     INTEGER    NOT NULL,
    `puesto_id`        INTEGER    NOT NULL,
    `observaciones`    VARCHAR(500),
    `activo`           VARCHAR(1) NOT NULL,
    PRIMARY KEY (`centro_fisico_id`, `servicio_id`, `categoria_id`, `puesto_id`),
    FOREIGN KEY (`categoria_id`) REFERENCES `unit` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (`puesto_id`) REFERENCES `unit` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (`servicio_id`) REFERENCES `unit` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (`centro_fisico_id`) REFERENCES `unit` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS `calendario_festivo`
(
    `centro_fisico_id` INTEGER      NOT NULL,
    `fecha`            DATE         NOT NULL,
    `descripcion`      VARCHAR(255) NOT NULL,
    `observaciones`    VARCHAR(500),
    PRIMARY KEY (`centro_fisico_id`, `fecha`),
    FOREIGN KEY (`centro_fisico_id`) REFERENCES `unit` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS `puesto_ciclo`
(
    `id`              INTEGER NOT NULL AUTO_INCREMENT,
    `ciclo_master_id` INTEGER NOT NULL,
    `fecha_inicio`    DATE    NOT NULL,
    `puesto_id`       INTEGER NOT NULL,
    `observaciones`   VARCHAR(500),
    `fecha_fin`       DATE    NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`puesto_id`) REFERENCES `unit` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (`ciclo_master_id`) REFERENCES `ciclo_master` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS `jornada_teorica`
(
    `centro_fisico_id`  INTEGER NOT NULL,
    `anno`              INTEGER NOT NULL,
    `total_horas_anual` INTEGER,
    `observaciones`     VARCHAR(500),
    PRIMARY KEY (`centro_fisico_id`, `anno`),
    FOREIGN KEY (`centro_fisico_id`) REFERENCES `unit` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS `servicios_previos`
(
    `id`         INTEGER NOT NULL AUTO_INCREMENT,
    `persona_id` INTEGER NOT NULL,
    `anno`       INTEGER NOT NULL,
    `horas`      INTEGER NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`persona_id`) REFERENCES `persona` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS `categoria_equipo`
(
    `id`                       INTEGER NOT NULL AUTO_INCREMENT,
    `categoria_id`             INTEGER NOT NULL,
    `categoria_profesional_id` INTEGER NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`categoria_id`) REFERENCES `unit` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (`categoria_profesional_id`) REFERENCES `categoria_profesional` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS `cobertura_equipo`
(
    `id`           INTEGER NOT NULL,
    `fecha_inicio` DATE    NOT NULL,
    `categoria_id` INTEGER NOT NULL,
    `lunes`        INTEGER NOT NULL,
    `martes`       INTEGER NOT NULL,
    `miercoles`    INTEGER NOT NULL,
    `jueves`       INTEGER NOT NULL,
    `viernes`      INTEGER NOT NULL,
    `sabado`       INTEGER NOT NULL,
    `domingo`      INTEGER NOT NULL,
    `fecha_fin`    DATE    NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`categoria_id`) REFERENCES `unit` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS `rol_recurso`
(
    `id`            INTEGER    NOT NULL AUTO_INCREMENT,
    `rol_id`        INTEGER    NOT NULL,
    `recurso_id`    INTEGER    NOT NULL,
    `ejecucion`     VARCHAR(1) NOT NULL,
    `lectura`       VARCHAR(1) NOT NULL,
    `escritura`     VARCHAR(1) NOT NULL,
    `observaciones` VARCHAR(500),
    `activo`        VARCHAR(1) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (`recurso_id`) REFERENCES `recurso` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS `rol_usuario`
(
    `id`            INTEGER    NOT NULL AUTO_INCREMENT,
    `rol_id`        INTEGER    NOT NULL,
    `usuario_id`    INTEGER    NOT NULL,
    `observaciones` VARCHAR(500),
    `activo`        VARCHAR(1) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS `usuario_estructura`
(
    `id`               INTEGER    NOT NULL,
    `usuario_id`       INTEGER    NOT NULL,
    `centro_fisico_id` INTEGER,
    `servicio_id`      INTEGER,
    `equipo_id`        INTEGER,
    `puesto_id`        INTEGER,
    `observaciones`    VARCHAR(500),
    `activo`           VARCHAR(1) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`centro_fisico_id`, `servicio_id`, `equipo_id`, `puesto_id`) REFERENCES `estructura` (`centro_fisico_id`, `servicio_id`, `categoria_id`, `puesto_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS `contrato`
(
    `id`                       INTEGER NOT NULL AUTO_INCREMENT,
    `cargo_id`                 INTEGER NOT NULL,
    `fecha_inicio`             DATE    NOT NULL,
    `fecha_fin`                DATE,
    `categoria_profesional_id` INTEGER NOT NULL,
    `persona_id`               INTEGER NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`cargo_id`) REFERENCES `cargo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (`categoria_profesional_id`) REFERENCES `categoria_profesional` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (`persona_id`) REFERENCES `persona` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS `tarea`
(
    `id`             INTEGER    NOT NULL AUTO_INCREMENT,
    `puesto_id`      INTEGER    NOT NULL,
    `fecha_inicio`   DATE       NOT NULL,
    `fecha_fin`      DATE       NOT NULL,
    `observaciones`  VARCHAR(500),
    `contrato_id`    INTEGER    NOT NULL,
    `solapado`       VARCHAR(1) NOT NULL,
    `tarea_anterior` INTEGER,
    `activo`         VARCHAR(1) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`contrato_id`) REFERENCES `contrato` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (`puesto_id`) REFERENCES `unit` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS `ciclo_detail`
(
    `ciclo_master_id` INTEGER NOT NULL,
    `id`              INTEGER NOT NULL,
    `turno_master_id` INTEGER NOT NULL,
    PRIMARY KEY (`ciclo_master_id`, `id`),
    FOREIGN KEY (`ciclo_master_id`) REFERENCES `ciclo_master` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (`turno_master_id`) REFERENCES `turno_master` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS `cambio_turno`
(
    `dia`              DATE       NOT NULL,
    `tarea_id`         INTEGER    NOT NULL,
    `turno_modificado` VARCHAR(5) NOT NULL,
    `turno_original`   VARCHAR(5) NOT NULL,
    `observaciones`    VARCHAR(500),
    PRIMARY KEY (`dia`, `tarea_id`),
    FOREIGN KEY (`tarea_id`) REFERENCES `tarea` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS `contrato_ausencia`
(
    `id`               INTEGER    NOT NULL AUTO_INCREMENT,
    `contrato_id`      INTEGER    NOT NULL,
    `ausencia_id`      INTEGER    NOT NULL,
    `fecha_inicio`     DATE       NOT NULL,
    `fecha_fin`        DATE       NOT NULL,
    `anno_devengo`     INTEGER    NOT NULL,
    `activo`           VARCHAR(1) NOT NULL,
    `ausencia_parcial` VARCHAR(1) NOT NULL,
    `hora_inicio`      VARCHAR(5),
    `hora_fin`         VARCHAR(5),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`contrato_id`) REFERENCES `contrato` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (`ausencia_id`) REFERENCES `ausencia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

/* Insertamos datos previos */
INSERT INTO `usuario`
VALUES (101, 1101, 'admin', 'admin', '2017-03-14', '', 5, 'S'),
       (102, 1102, 'camino', 'camino', '2017-03-14', '', 5, 'S'),
       (103, 1103, 'angel', 'angel', '2017-03-14', '', 5, 'S'),
       (104, 1104, 'antonio', 'antonio', '2017-03-14', '', 5, 'S'),
       (105, 1105, 'yolanda', 'yolanda', '2017-03-14', '', 5, 'S'),
       (106, 1106, 'Javi', 'Javi', '2017-03-14', '', 5, 'S'),
       (107, 1107, 'Javier', 'Javier', '2017-03-14', '', 5, 'S'),
       (108, 1108, 'Pepe', 'Pepe', '2017-03-14', '', 5, 'S'),
       (109, 1109, 'Ernesto', 'Ernesto', '2017-03-14', '', 5, 'S'),
       (110, 1110, 'Feliz', 'Feliz', '2017-03-14', '', 5, 'S'),
       (111, 1111, 'Felix', 'Felix', '2017-03-14', '', 5, 'S'),
       (112, 1112, 'Ana', 'Ana', '2017-03-14', '', 5, 'S'),
       (113, 1113, 'Fernandez', 'Fernandez', '2017-03-14', '', 5, 'S'),
       (114, 1114, 'Gonzalo', 'Gonzalo', '2017-03-14', '', 5, 'S'),
       (115, 1115, 'Christian', 'Christian', '2017-03-14', '', 5, 'S'),
       (116, 1116, 'Christiano', 'Christiano', '2017-03-14', '', 5, 'S');

INSERT INTO `persona`
VALUES (1101, '12345678A', 'Juan', 'Pérez García', 'Calle 1', '28000', 'Madrid', 'Madrid', 'España', '612345678',
        '967890123', 'juan.perez@gmail.com', 'Cliente fiel de la empresa desde hace 5 años.', 'H', '1980-01-01'),
       (1102, '23456789L', 'María', 'González López', 'Calle 2', '28100', 'Madrid', 'Madrid', 'España', '945678901',
        '612345679', 'maria.gonzalez@gmail.com', 'Observaciones Isabel Pérez', 'M', '1981-02-02'),
       (1103, '34567890C', 'Pedro', 'Martínez Sánchez', 'Calle 3', '28200', 'Madrid', 'Madrid', 'España', '612345680',
        '934567890', 'pedro.martinez@gmail.com', 'Sin Observaciones', 'H', '1982-03-03'),
       (1104, '45678901D', 'Ana', 'Rodríguez Pérez', 'Calle 4', '28300', 'Madrid', 'Madrid', 'España', '923456789',
        '612345681', 'ana.rodriguez@gmail.com', 'Observaciones Pedro Sánchez', 'M', '1983-04-04'),
       (1105, '56789012E', 'José', 'García Martínez', 'Calle 5', '28400', 'Madrid', 'Madrid', 'España', '612345682',
        '923456789', 'jose.garcia@gmail.com', 'Sin observaciones', 'H', '1984-05-05'),
       (1106, '67890123F', 'Isabel', 'López Sánchez', 'Calle 6', '28500', 'Barcelona', 'Barcelona', 'España',
        '978901234', '612345683', 'isabel.lopez@gmail.com', 'Cliente antiguo', 'M', '1985-06-06'),
       (1107, '78901234G', 'Francisco', 'Pérez Rodríguez', 'Calle 7', '28600', 'Barcelona', 'Barcelona', 'España',
        '612345684', '989012345', 'francisco.perez@gmail.com', '', 'H', '1986-07-07'),
       (1108, '89012345H', 'Laura', 'García González', 'Calle 8', '28700', 'Barcelona', 'Barcelona', 'España',
        '989012345', '612345685', 'laura.garcia@gmail.com', 'Cliente VIP', 'M', '1987-08-08'),
       (1109, '90123456I', 'Javier', 'Martínez López', 'Calle 9', '28800', 'Barcelona', 'Barcelona', 'España',
        '612345686', '999012345', 'javier.martinez@gmail.com', 'Sin observaciones', 'H', '1988-09-09'),
       (1110, '12345678F', 'María', 'García Díaz', 'Calle del Sol 1', '28000', 'Madrid', 'Madrid', 'España',
        '612345678', '912345678', 'maria.garcia@email.com', 'Cliente frecuente', 'H', '1990-01-01'),
       (1111, '23456789B', 'Juan', 'Pérez García', 'Calle de la Luna 2', '28001', 'Madrid', 'Madrid', 'España',
        '612345679', '912345670', 'juan.perez@email.com', 'Nuevo cliente', 'M', '1991-02-01'),
       (1112, '34567890R', 'Pedro', 'Martínez Sánchez', 'Calle del Sol 3', '28002', 'Madrid', 'Madrid', 'España',
        '612345680', '912345671', 'pedro.martinez@email.com', 'Cliente ocasional', 'M', '1992-03-01'),
       (1113, '45678901E', 'Ana', 'Rodríguez López', 'Calle de la Luna 4', '28003', 'Madrid', 'Madrid', 'España',
        '612345681', '912345672', 'ana.rodriguez@email.com', 'Cliente habitual', 'H', '1993-04-01'),
       (1114, '56789012D', 'Luis', 'González Fernández', 'Calle del Sol 5', '28004', 'Madrid', 'Madrid', 'España',
        '612345682', '912345673', 'luis.gonzalez@email.com', 'Cliente infrecuente', 'M', '1994-05-01'),
       (1115, '67890123H', 'Isabel', 'Ruiz García', 'Calle de la Luna 6', '28005', 'Madrid', 'Madrid', 'España',
        '612345683', '912345674', 'isabel.ruiz@email.com', 'Cliente esporádico', 'H', '1995-06-01'),
       (1116, '78901234J', 'Miguel', 'Hernández Díaz', 'Calle del Sol 7', '28006', 'Madrid', 'Madrid', 'España',
        '612345684', '912345675', 'miguel.hernandez@email.com', 'Cliente recurrente', 'M', '1996-07-01');
INSERT INTO `tipo_unit`
VALUES (1, 'CF', 'Centro Físico', 'S', 'Centro físico de unidad organizativa'),
       (2, 'SE', 'Servicio', 'S', 'Servicio funcional de unidad organizativa'),
       (3, 'CA', 'Categoría', 'S', 'Categoría profesional de unidad organizativa'),
       (4, 'PU', 'Puesto', 'S', 'Puesto de trabajo');
INSERT INTO `turno_master`
VALUES (16, 'M', 'MAÑANA', 'S', 'S'),
       (17, 'T', 'TARDE', 'S', 'S'),
       (18, 'N', 'NOCHE', 'S', 'S'),
       (19, 'MT', 'MAÑANA TARDE', 'S', 'S'),
       (20, 'TN', 'TARDE NOCHE', 'S', 'S'),
       (21, '-', 'SALIENTE', 'N', 'S'),
       (22, 'L', 'LIBRE', 'N', 'S'),
       (23, 'M1', 'PRUEBA MAÑANA', 'S', 'S');
INSERT INTO `planificacion`
VALUES (6, 2017, 28, '2017-06-01', 4, '2017-06-30', 30, 5, 'N', 'L', 'L', 'L', 'T', 'T', 'N', 'L', 'L', 'M1', 'L', 'T',
        'N', 'L', 'L', 'M1', 'T', 'L', 'N', 'L', 'L', 'M1', 'T', 'T', 'L', 'L', 'L', 'M1', 'T', 'T', '', 'N', 'N',
        'N', 'N', 'N', 'N', 'S', 22),
       (6, 2017, 29, '2017-06-01', 4, '2017-06-30', 30, 5, 'N', 'L', 'L', 'L', 'T', 'T', 'N', 'L', 'L', 'M1', 'L', 'T',
        'N', 'L', 'L', 'M1', 'T', 'L', 'N', 'L', 'L', 'M1', 'T', 'T', 'L', 'L', 'L', 'M1', 'T', 'T', '', 'N', 'N',
        'N', 'N', 'N', 'N', 'S', 22),
       (6, 2017, 30, '2017-06-01', 4, '2017-06-30', 30, 5, 'N', 'L', 'L', 'L', 'T', 'T', 'N', 'L', 'L', 'M1', 'L', 'T',
        'N', 'L', 'L', 'M1', 'T', 'L', 'N', 'L', 'L', 'M1', 'T', 'T', 'L', 'L', 'L', 'M1', 'T', 'T', '', 'N', 'N',
        'N', 'N', 'N', 'N', 'S', 22),
       (6, 2017, 31, '2017-06-01', 1, '2017-06-30', 30, 1, 'M', 'M', 'L', 'L', 'M', 'M', 'M', 'M', 'M', 'L', 'L', 'M',
        'M', 'M', 'M', 'M', 'L', 'L', 'M', 'M', 'M', 'M', 'M', 'L', 'L', 'M', 'M', 'M', 'M', 'M', '', 'N', 'N', 'N',
        'N', 'N', 'N', 'S', 22),
       (6, 2017, 32, '2017-06-01', 3, '2017-06-30', 30, 5, '-', 'L', 'M', 'L', 'N', '-', 'L', 'M', 'T', 'N', 'L', 'L',
        'M', 'T', 'N', '-', 'L', 'L', 'T', 'N', '-', 'L', 'M', 'T', 'L', '-', 'L', 'M', 'T', 'N', '', 'N', 'N', 'N',
        'N', 'N', 'N', 'S', 22);
INSERT INTO `cargo`
VALUES (7, 'G', 'GERENTE', '', 'S'),
       (8, 'D', 'DIRECTOR/A DE OPERACIONES', '', 'S'),
       (9, 'A', 'ANALISTA SOFTWARE', '', 'S'),
       (10, 'T', 'TÉCNICO HARDWARE', '', 'S'),
       (11, 'C', 'CONSULTOR', '', 'S'),
       (12, 'DP', 'DIRECTOR DE PROYECTO', '', 'S');
INSERT INTO `categoria_profesional`
VALUES (18, 'INF', 'INGENIERO INFORMÁTICO', 'S'),
       (19, 'ADM', 'ADMINISTRATIVO', 'S'),
       (20, 'AUX', 'AUXILIAR ADMINISTRATIVO', 'S'),
       (21, 'ADE', 'LICENCIADO EN ADMINISTRACIÓN Y DIRECCIÓN DE EMPRESAS', 'S'),
       (22, 'ECO', 'LICENCIADO EN CIENCIAS ECONÓMICAS', 'S'),
       (23, 'TINF', 'TÉCNICO EN SISTEMAS INFORMÁTICOS', 'S');
INSERT INTO `ausencia`
VALUES (4, 'VAC', 'VACACIONES HABILES', 'N', 'N', 0, 'N', 'N', '', 'S', 0),
       (5, 'LD', 'LIBRE DISPOSICION', 'N', 'N', 0, 'N', 'N', '', 'S', 0),
       (6, 'IT', 'INCAPACIDAD TEMPORAL', 'S', 'S', 0, 'N', 'N', '', 'S', 0);
INSERT INTO `basica`
VALUES (1, 'beta 0.0.2', '0.0.0.0', 'AtiLoMan', 'Gestor de Turnos de Trabajo', 0, 0, 0, 0, 0, 0, 1,
        'Copyright 2023 AtiLoMan', 'M·3 Informática', '08:00', '15:00', '15:00', '22:00', '22:00',
        '08:00');
INSERT INTO `rol`
VALUES (1, 'ADMIN', 'Administrador', 'Administrador de Turnos', 'S'),
       (2, 'SUPER', 'Supervisor', 'Supervisor de Turnos', 'S');
INSERT INTO `recurso`
VALUES (1, 'SEGUR', 'Módulo de seguridad', 'S', ''),
       (2, 'CONFI', 'Módulo de configuración', 'S', ''),
       (3, 'TRABA', 'Módulo de trabajadores', 'S', ''),
       (4, 'PLANI', 'Módulo de planilla', 'S', ''),
       (5, 'BALAN', 'Gestión de balance horario, en módulo Planilla', 'S', ''),
       (6, 'GPLAN', 'Gestión de planificación de puestos, en módulo Planilla', 'S', ''),
       (7, 'ASIGN', 'Gestión de asignaciones, en módulo Planilla, opción Planilla', 'S', ''),
       (8, 'GPAUS', 'Gestión de ausencias en la planilla, en módulo Planilla, opción Planilla', 'S', ''),
       (9, 'GCAMT', 'Gestión de cambio de turno en la planilla, en módulo Planilla, opción Planilla', 'S', '');
INSERT INTO `ciclo_master`
VALUES (1, 'M1', 'NORMAL MAÑANA', 'S', 'S'),
       (2, 'M2', 'NORMAL MAÑANA 1 SABADO CADA 3 SEMANAS', 'S', 'S'),
       (3, 'N1', 'ROTARIO DE 5 SEMANAS', 'N', 'S'),
       (4, 'P1', 'PRUEBA DE CICLO', 'N', 'S');

INSERT INTO `turno_detail`
VALUES (16, 1, 0, 0, '08:00', '15:00'),
       (17, 1, 0, 0, '15:00', '22:00'),
       (18, 1, 0, 1, '22:00', '08:00'),
       (19, 1, 0, 0, '08:00', '22:00'),
       (20, 1, 0, 0, '22:00', '08:00'),
       (21, 1, 0, 0, '00:00', '00:00'),
       (22, 1, 0, 0, '00:00', '00:00'),
       (23, 1, 0, 0, '09:00', '17:00');
INSERT INTO `unit`
VALUES (18, 1, 'MAD', 'Central Madrid', 'S', 'Calle Medea, 4', 'Madrid', '', 'Madrid', 'España', '', '', '', ''),
       (19, 1, 'MUR', 'Órganos Centrales Murcia', 'S', 'Calle Central', 'Espinardo', '', 'Murcia', 'España', '', '', '',
        ''),
       (20, 4, 'T1', 'Operador técnico', 'S', '', '', '', '', '', '', '', '', ''),
       (21, 4, 'D1', 'Director de operaciones', 'S', '', '', '', '', '', '', '', '', ''),
       (22, 4, 'D2', 'Director comercial', 'S', '', '', '', '', '', '', '', '', ''),
       (23, 4, 'D3', 'Director de sistemas', 'S', '', '', '', '', '', '', '', '', ''),
       (24, 4, 'D4', 'Director de desarrollo', 'S', '', '', '', '', '', '', '', '', ''),
       (25, 4, 'C1', 'Consultor 1', 'S', '', '', '', '', '', '', '', '', ''),
       (26, 4, 'C2', 'Consultor 2', 'S', '', '', '', '', '', '', '', '', ''),
       (27, 4, 'C3', 'Consultor 3', 'S', '', '', '', '', '', '', '', '', ''),
       (28, 4, 'C4', 'Consultor 4', 'S', '', '', '', '', '', '', '', '', ''),
       (29, 4, 'C5', 'Consultor 5', 'S', '', '', '', '', '', '', '', '', ''),
       (30, 4, 'C6', 'Consultor 6', 'S', '', '', '', '', '', '', '', '', ''),
       (31, 4, 'C7', 'Consultor 7', 'S', '', '', '', '', '', '', '', '', ''),
       (32, 4, 'C8', 'Consultor 8', 'S', '', '', '', '', '', '', '', '', ''),
       (33, 4, 'DE1', 'Desarrollo 1', 'S', '', '', '', '', '', '', '', '', ''),
       (34, 4, 'DE2', 'Desarrollo 2', 'S', '', '', '', '', '', '', '', '', ''),
       (35, 4, 'DE3', 'Desarrollo 3', 'S', '', '', '', '', '', '', '', '', ''),
       (36, 4, 'DE4', 'Desarrollo 4', 'S', '', '', '', '', '', '', '', '', ''),
       (37, 4, 'DE5', 'Desarrollo 5', 'S', '', '', '', '', '', '', '', '', ''),
       (38, 4, 'C14', 'Consultor 14', 'S', '', '', '', '', '', '', '', '', ''),
       (39, 4, 'C15', 'Consultor 15', 'S', '', '', '', '', '', '', '', '', ''),
       (40, 4, 'C16', 'Consultor 16', 'S', '', '', '', '', '', '', '', '', ''),
       (41, 4, 'C17', 'Consultor 17', 'S', '', '', '', '', '', '', '', '', ''),
       (42, 4, 'C18', 'Consultor 18', 'S', '', '', '', '', '', '', '', '', ''),
       (43, 4, 'C19', 'Consultor 19', 'S', '', '', '', '', '', '', '', '', ''),
       (44, 4, 'C20', 'Consultor 20', 'S', '', '', '', '', '', '', '', '', ''),
       (45, 4, 'C21', 'Consultor 21', 'S', '', '', '', '', '', '', '', '', ''),
       (46, 4, 'C22', 'Consultor 22', 'S', '', '', '', '', '', '', '', '', ''),
       (47, 4, 'C23', 'Consultor 23', 'S', '', '', '', '', '', '', '', '', ''),
       (48, 4, 'C24', 'Consultor 24', 'S', '', '', '', '', '', '', '', '', ''),
       (49, 4, 'C25', 'Consultor 25', 'S', '', '', '', '', '', '', '', '', ''),
       (50, 4, 'C26', 'Consultor 26', 'S', '', '', '', '', '', '', '', '', ''),
       (51, 2, 'CONS', 'Consultoría', 'S', '', '', '', '', '', '', '', '', ''),
       (52, 2, 'DESA', 'Desarrollo', 'S', '', '', '', '', '', '', '', '', ''),
       (53, 2, 'ADMON', 'Administración', 'S', '', '', '', '', '', '', '', '', ''),
       (54, 2, 'DIREC', 'Dirección', 'S', '', '', '', '', '', '', '', '', ''),
       (55, 2, 'DTEC', 'Departamento técnico', 'S', '', '', '', '', '', '', '', '', ''),
       (56, 3, 'SMS', 'Consultoría SMS', 'S', '', '', '', '', '', '', '', '', ''),
       (57, 3, 'SESCA', 'Consultoría SESCAM', 'S', '', '', '', '', '', '', '', '', ''),
       (58, 3, 'SACYL', 'Consultoría SACYL', 'S', '', '', '', '', '', '', '', '', ''),
       (59, 3, 'INGE', 'Consultoría INGESA', 'S', '', '', '', '', '', '', '', '', ''),
       (60, 3, 'DES', 'Desarrollo software', 'S', '', '', '', '', '', '', '', '', ''),
       (61, 3, 'DESS', 'Desarrollo - Soporte', 'S', '', '', '', '', '', '', '', '', ''),
       (62, 3, 'TEC', 'Técnico sistemas', 'S', '', '', '', '', '', '', '', '', ''),
       (63, 3, 'ADM', 'Administrativo', 'S', '', '', '', '', '', '', '', '', ''),
       (64, 3, 'DIR', 'Dirección empresa', 'S', '', '', '', '', '', '', '', '', ''),
       (65, 4, 'A1', 'Administrativo 1', 'S', '', '', '', '', '', '', '', '', ''),
       (66, 4, 'A2', 'Administrativo 2', 'S', '', '', '', '', '', '', '', '', ''),
       (67, 4, 'A3', 'Administrativo 3', 'S', '', '', '', '', '', '', '', '', ''),
       (68, 2, 'CO1', 'Consultoría permanente Murcia', 'S', '', '', '', '', '', '', '', '', '');
INSERT INTO `estructura`
VALUES (18, 53, 63, 65, '', 'S'),
       (18, 53, 63, 66, '', 'S'),
       (18, 53, 63, 67, '', 'S'),
       (18, 54, 64, 22, '', 'S'),
       (18, 54, 64, 24, '', 'S'),
       (18, 54, 64, 21, '', 'S'),
       (18, 54, 64, 23, '', 'S'),
       (18, 55, 62, 20, '', 'S'),
       (18, 51, 59, 49, '', 'S'),
       (18, 51, 58, 25, '', 'S'),
       (18, 51, 58, 26, '', 'S'),
       (18, 51, 58, 27, '', 'S'),
       (18, 51, 57, 28, '', 'S'),
       (18, 51, 57, 29, '', 'S'),
       (18, 51, 57, 30, '', 'S'),
       (18, 51, 57, 31, '', 'S'),
       (18, 51, 57, 32, '', 'S'),
       (19, 68, 56, 48, '', 'S'),
       (19, 68, 56, 47, '', 'S'),
       (19, 68, 56, 46, '', 'S'),
       (18, 52, 61, 33, '', 'S'),
       (18, 52, 60, 34, '', 'S'),
       (18, 52, 60, 35, '', 'S'),
       (18, 52, 60, 36, '', 'S'),
       (18, 52, 60, 37, '', 'S'),
       (18, 51, 59, 38, '', 'S'),
       (19, 68, 56, 44, '', 'S');
INSERT INTO `calendario_festivo`
VALUES (18, '2017-03-20', 'SAN JOSÉ', ''),
       (19, '2017-06-09', 'FIESTA AUTONÓMICA REGIÓN DE MURCIA', ''),
       (19, '2017-09-12', 'Festividad local ciudad de Murcia (Romería)', ''),
       (19, '2017-12-06', 'Día de la Constitución', ''),
       (19, '2017-12-08', 'Inmaculada Concepción', ''),
       (19, '2017-01-01', 'Día de Año Nuevo', ''),
       (19, '2017-01-06', 'Día de Reyes', '');
INSERT INTO `puesto_ciclo`
VALUES (94, 2, '2017-04-01', 44, 'sfasdf', '2017-12-31'),
       (97, 2, '2017-03-01', 44, 'fhfghgf', '2017-03-14'),
       (98, 3, '2017-03-15', 44, 'aaa', '2017-03-31'),
       (99, 3, '2017-03-15', 46, '', '2017-03-31'),
       (100, 3, '2017-04-01', 46, '', '2017-12-31'),
       (106, 4, '2017-06-01', 28, '', '2017-06-30'),
       (107, 4, '2017-06-01', 29, '', '2017-06-30'),
       (108, 4, '2017-06-01', 30, '', '2017-06-30'),
       (109, 1, '2017-06-01', 31, '', '2017-06-30'),
       (110, 3, '2017-06-01', 32, '', '2017-06-30');
INSERT INTO `jornada_teorica`
VALUES (18, 2017, 1600, ''),
       (19, 2017, 1600, '');
INSERT INTO `servicios_previos` /* id, persona_id, anno, horas */
VALUES (264, 1101, 2017, 100);
INSERT INTO `categoria_equipo`
VALUES (15, 63, 19),
       (16, 59, 21),
       (17, 58, 21),
       (18, 57, 21),
       (19, 56, 21),
       (20, 56, 18),
       (21, 57, 18),
       (22, 58, 18),
       (23, 59, 18),
       (24, 60, 18),
       (25, 61, 18),
       (26, 64, 18),
       (27, 64, 21),
       (28, 64, 22),
       (29, 62, 23),
       (30, 63, 22),
       (31, 63, 21),
       (32, 57, 22);
INSERT INTO `cobertura_equipo`
VALUES (1, '2017-01-01', 63, 3, 3, 3, 3, 3, 0, 0, '2017-12-31'),
       (2, '2017-01-01', 59, 2, 2, 2, 2, 2, 0, 0, '2017-12-31'),
       (3, '2017-01-01', 58, 3, 3, 3, 3, 3, 0, 0, '2017-12-31'),
       (4, '2017-01-01', 57, 5, 5, 5, 5, 5, 5, 5, '2017-12-31'),
       (5, '2017-01-01', 56, 4, 4, 4, 4, 4, 0, 0, '2017-12-31'),
       (6, '2017-01-01', 61, 1, 1, 1, 1, 1, 0, 0, '2017-12-31'),
       (7, '2017-01-01', 60, 4, 4, 4, 4, 4, 0, 0, '2017-12-31'),
       (8, '2017-01-01', 64, 4, 4, 4, 4, 4, 0, 0, '2017-12-31'),
       (9, '2017-01-01', 62, 1, 1, 1, 1, 1, 0, 0, '2017-12-31');
INSERT INTO `rol_recurso` /* id, rol_id, recurso_id, ejecucion, lectura, escritura, observaciones, activo */
VALUES (5, 1, 7, 'S', 'S', 'S', 'S', 'S'),
       (6, 1, 8, 'S', 'S', 'S', 'S', 'S'),
       (7, 1, 5, 'S', 'S', 'S', 'S', 'S'),
       (8, 1, 9, 'S', 'S', 'S', 'S', 'S'),
       (11, 2, 4, 'S', 'S', 'S', 'S', 'S'),
       (13, 2, 3, 'S', 'S', 'S', 'S', 'S'),
       (14, 1, 6, 'S', 'S', 'S', 'S', 'S'),
       (15, 1, 2, 'S', 'S', 'S', 'S', 'S'),
       (16, 1, 4, 'S', 'S', 'S', 'S', 'S'),
       (17, 1, 1, 'S', 'S', 'S', 'S', 'S'),
       (18, 1, 3, 'S', 'S', 'S', 'S', 'S');
INSERT INTO `rol_usuario` /* id, rol_id, usuario_id 1102, observaciones, activo */
VALUES (1, 1, 101, 'Administrador técnico.', 'S'),
       (2, 1, 102, 'Administrador dirección.', 'S'),
       (3, 2, 103, '', 'S'),
       (4, 2, 104, '', 'S'),
       (5, 1, 105, 'Administrador técnico.', 'S'),
       (6, 1, 106, 'Administrador dirección.', 'S'),
       (7, 2, 107, '', 'S'),
       (8, 2, 108, '', 'S'),
       (9, 2, 109, '', 'S'),
       (10, 2, 110, '', 'S'),
       (11, 2, 111, '', 'S'),
       (12, 2, 112, '', 'S'),
       (13, 2, 113, '', 'S'),
       (14, 2, 114, '', 'S'),
       (15, 2, 115, '', 'S'),
       (16, 2, 116, '', 'S');
INSERT INTO `ciclo_detail`
VALUES (1, 1, 16),
       (1, 2, 16),
       (1, 3, 16),
       (1, 4, 16),
       (1, 5, 16),
       (1, 6, 22),
       (1, 7, 22),
       (2, 1, 16),
       (2, 2, 16),
       (2, 3, 16),
       (2, 4, 16),
       (2, 5, 16),
       (2, 6, 22),
       (2, 7, 22),
       (2, 8, 16),
       (2, 9, 16),
       (2, 10, 16),
       (2, 11, 16),
       (2, 12, 16),
       (2, 13, 22),
       (2, 14, 22),
       (2, 15, 16),
       (2, 16, 16),
       (2, 17, 16),
       (2, 18, 16),
       (2, 19, 16),
       (2, 20, 16),
       (2, 21, 22),
       (3, 1, 16),
       (3, 2, 17),
       (3, 3, 18),
       (3, 4, 21),
       (3, 5, 22),
       (4, 1, 23),
       (4, 2, 17),
       (4, 3, 17),
       (4, 4, 18),
       (4, 5, 22),
       (4, 6, 22);


INSERT INTO `contrato` /* id, cargo_id, fecha_inicio, fecha_fin, categoria_profesional_id, persona_id */
VALUES (10, 12, '2017-01-01', '2099-12-31', 22, 1101),
       (11, 11, '2017-01-01', '2099-12-31', 22, 1102),
       (12, 11, '2017-01-01', '2099-12-31', 21, 1103),
       (13, 11, '2017-01-01', '2099-12-31', 21, 1104),
       (14, 9, '2017-01-01', '2099-12-31', 18, 1105),
       (15, 11, '2017-01-01', '2099-12-31', 22, 1106),
       (16, 11, '2017-01-01', '2099-12-31', 22, 1107),
       (17, 11, '2017-01-01', '2099-12-31', 21, 1108),
       (18, 8, '2017-01-01', '2099-12-31', 18, 1109),
       (19, 9, '2017-01-01', '2099-12-31', 18, 1110),
       (20, 7, '2017-01-01', '2099-12-31', 18, 1111),
       (21, 10, '2017-01-01', '2099-12-31', 23, 1112),
       (22, 7, '2017-01-01', '2099-12-31', 18, 1113),
       (23, 9, '2017-01-01', '2099-12-31', 18, 1114),
       (24, 11, '2017-01-01', '2099-12-31', 22, 1115);

INSERT INTO `contrato_ausencia` /* id, contrato_id, ausencia_id, fecha_inicio, fecha_fin, anno_devengo, activo, ausencia_parcial, hora_inicio, hora_fin */
VALUES (45, 24, 4, '2017-06-23', '2017-06-23', 2017, 'S', 'N', '', ''),
       (46, 19, 5, '2017-06-25', '2017-06-25', 2017, 'S', 'N', '', '');

/* id, puesto_id, fecha_inicio, fecha_fin, observaciones, contrato_id, solapado, tarea_anterior, activo */

INSERT INTO `tarea` /* id, puesto_id, fecha_inicio, fecha_fin, observaciones, contrato_id, solapado, tarea_anterior, activo */
VALUES (22, 28, '2017-06-01', '2017-06-30', '', 19, 'N', NULL, 'S'),
       (23, 29, '2017-06-01', '2017-06-30', '', 24, 'N', NULL, 'S'),
       (24, 30, '2017-06-01', '2017-06-30', '', 14, 'N', NULL, 'S'),
       (25, 31, '2017-06-01', '2017-06-30', '', 23, 'N', NULL, 'S'),
       (26, 32, '2017-06-01', '2017-06-30', '', 20, 'N', NULL, 'S');

INSERT INTO `cambio_turno`
VALUES ('2017-06-09', 22, 'MT', 'T', ''),
       ('2017-06-04', 22, 'MT', 'L', ''),
       ('2017-06-25', 22, 'M', 'L', ''),
       ('2017-06-25', 23, 'M', 'L', ''),
       ('2017-06-25', 24, 'L', 'L', ''),
       ('2017-06-25', 25, 'M', 'L', ''),
       ('2017-06-25', 26, 'M', 'L', '');

INSERT INTO `usuario_estructura` /* id, usuario_id, centro_fisico_id, servicio_id, equipo_id, puesto_id, observaciones, activo */
VALUES (1, 101, 18, 53, 63, 65, '', 'S'),
       (2, 101, 18, 51, 59, 49, '', 'S'),
       (3, 101, 18, 51, 58, 25, '', 'S'),
       (4, 101, 18, 51, 57, 29, '', 'S'),
       (5, 101, 18, 55, 62, 20, '', 'S'),
       (6, 101, 18, 52, 61, 33, '', 'S'),
       (7, 101, 18, 52, 60, 36, '', 'S'),
       (8, 101, 18, 54, 64, 21, '', 'S'),
       (9, 101, 19, 68, 56, 47, '', 'S'),
       (10, 102, 19, 68, 56, 46, '', 'S'),
       (11, 103, 18, 51, 57, 30, '', 'S'),
       (12, 103, 18, 51, 58, 26, '', 'S'),
       (13, 103, 18, 51, 59, 49, '', 'S'),
       (14, 104, 18, 51, 59, 49, '', 'S'),
       (15, 104, 18, 51, 58, 26, '', 'S'),
       (16, 104, 18, 51, 57, 32, '', 'S'),
       (17, 104, 18, 53, 63, 66, '', 'S');

/* Creamos los Procedimientos */
DROP PROCEDURE IF EXISTS usp_rol_select;
CREATE PROCEDURE usp_rol_select()
SELECT id, codigo, descripcion, observaciones, activo
FROM rol;

DROP PROCEDURE IF EXISTS usp_rol_insert;
CREATE PROCEDURE usp_rol_insert(id1 INT, codigo1 varchar(5), descripcion1 varchar(255), observaciones1 varchar(500),
                                activo1 varchar(1))
INSERT INTO rol
VALUES (NULL, codigo1, descripcion1, observaciones1, activo1);

DROP PROCEDURE IF EXISTS usp_rol_update;
CREATE PROCEDURE usp_rol_update(id1 INT, codigo1 varchar(5), descripcion1 varchar(255), observaciones1 varchar(500),
                                activo1 varchar(1))
update rol
set id            = id1,
    codigo        = codigo1,
    descripcion   = descripcion1,
    observaciones = observaciones1,
    activo        = activo1
where id = id1;

DROP PROCEDURE IF EXISTS usp_rol_delete;
CREATE PROCEDURE usp_rol_delete(p_id INT)
DELETE
FROM rol
WHERE id = p_id;

DROP PROCEDURE IF EXISTS usp_usuario_select;
CREATE PROCEDURE usp_usuario_select()
SELECT persona.id,
       nombre,
       apellidos,
       dni,
       email,
       tlfno1,
       direccion,
       cp,
       poblacion,
       provincia,
       pais,
       persona.observaciones,
       sexo,
       fnac,
       usuario.nick,
       rol.descripcion
FROM persona
         LEFT JOIN usuario ON persona.id = usuario.persona_id
         LEFT JOIN rol_usuario ON usuario.id = rol_usuario.usuario_id
         LEFT JOIN rol on rol_usuario.rol_id = rol.id
ORDER BY persona.id DESC;

DROP PROCEDURE IF EXISTS usp_insertar_Datos;
delimiter //
CREATE PROCEDURE usp_insertar_Datos(dni1 varchar(9), nombre1 varchar(100), apellidos1 varchar(150),
                                    direccion1 varchar(300), cp1 varchar(5), poblacion1 varchar(100),
                                    provincia1 varchar(50), pais1 varchar(50), tlfno12 varchar(20), email1 varchar(50),
                                    observaciones1 varchar(500), sexo1 varchar(1), fnac1 date, nick1 varchar(16),
                                    passwd1 varchar(300), codigo1 varchar(5), OUT ID_PERSONA INT, OUT ID_ROL INT,
                                    OUT ID_USUARIO INT)
BEGIN
    DECLARE ID_PERSONA INT;
    insert into persona(dni, nombre, apellidos, direccion, cp, poblacion, provincia, pais, tlfno1, email, observaciones,
                        sexo, fnac)
    values (dni1, nombre1, apellidos1, direccion1, cp1, poblacion1, provincia1, pais1, tlfno12, email1, observaciones1,
            sexo1, fnac1);
    select persona.id
    INTO ID_PERSONA
    from persona
    where persona.dni = dni1;
    insert into usuario(persona_id, nick, passwd)
    values (ID_PERSONA, nick1, passwd1);
    select id
    INTO ID_ROL
    from rol
    where codigo = codigo1;
    select id
    INTO ID_USUARIO
    from usuario
    where persona_id = ID_PERSONA;
    insert into rol_usuario(rol_id, usuario_id)
    values (ID_ROL, ID_USUARIO);
end //
delimiter ;

DROP PROCEDURE IF EXISTS usp_modificar_Datos;
delimiter //
CREATE PROCEDURE usp_modificar_Datos(id_usu INT, dni1 varchar(9), nombre1 varchar(100), apellidos1 varchar(150),
                                     direccion1 varchar(300), cp1 varchar(5), poblacion1 varchar(100),
                                     provincia1 varchar(50), pais1 varchar(50), tlfno12 varchar(20), email1 varchar(50),
                                     observaciones1 varchar(500), sexo1 varchar(1), fnac1 date,
                                     codigo1 varchar(5), OUT ID_PERSONA INT, OUT ID_ROL INT,
                                     OUT ID_USUARIO INT)
BEGIN
    DECLARE ID_PERSONA INT;
    select id INTO ID_PERSONA from persona where id = id_usu;
    update persona
    set dni           = dni1,
        nombre        = nombre1,
        apellidos     = apellidos1,
        direccion     = direccion1,
        cp            = cp1,
        poblacion     = poblacion1,
        provincia     = provincia1,
        pais          = pais1,
        tlfno1        = tlfno12,
        email         = email1,
        observaciones = observaciones1,
        sexo          = sexo1,
        fnac          = fnac1
    where id = ID_PERSONA;
    select id INTO ID_ROL from rol where codigo = codigo1;
    select id INTO ID_USUARIO from usuario where persona_id = ID_PERSONA;
    update rol_usuario set rol_id = ID_ROL where usuario_id = ID_USUARIO;
end //
delimiter ;

DROP PROCEDURE IF EXISTS usp_modificar_Datos_Pass;
delimiter //
CREATE PROCEDURE usp_modificar_Datos_Pass(id_usu INT, dni1 varchar(9), nombre1 varchar(100), apellidos1 varchar(150),
                                     direccion1 varchar(300), cp1 varchar(5), poblacion1 varchar(100),
                                     provincia1 varchar(50), pais1 varchar(50), tlfno12 varchar(20), email1 varchar(50),
                                     observaciones1 varchar(500), sexo1 varchar(1), fnac1 date, nick1 varchar(16),
                                     passwd1 varchar(300), codigo1 varchar(5), OUT ID_PERSONA INT, OUT ID_ROL INT,
                                     OUT ID_USUARIO INT)
BEGIN
    DECLARE ID_PERSONA INT;
    select id INTO ID_PERSONA from persona where id = id_usu;
    update persona
    set dni           = dni1,
        nombre        = nombre1,
        apellidos     = apellidos1,
        direccion     = direccion1,
        cp            = cp1,
        poblacion     = poblacion1,
        provincia     = provincia1,
        pais          = pais1,
        tlfno1        = tlfno12,
        email         = email1,
        observaciones = observaciones1,
        sexo          = sexo1,
        fnac          = fnac1
    where id = ID_PERSONA;
    update usuario set nick   = nick1, passwd = passwd1 where persona_id = ID_PERSONA;
    select id INTO ID_ROL from rol where codigo = codigo1;
    select id INTO ID_USUARIO from usuario where persona_id = ID_PERSONA;
    update rol_usuario set rol_id = ID_ROL where usuario_id = ID_USUARIO;
end //
delimiter ;