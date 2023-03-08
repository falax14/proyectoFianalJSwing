CREATE PROCEDURE usp_usuario_select()
SELECT persona.id,
       usuario.nick,
       nombre,
       apellidos,
       dni,
       email,
       tlfno1,
       direccion,
       rol.descripcion
FROM persona
         LEFT JOIN usuario ON persona.id = usuario.persona_id
         LEFT JOIN rol_usuario ON usuario.id = rol_usuario.usuario_id
         LEFT JOIN rol on rol_usuario.rol_id = rol.id



CREATE PROCEDURE usp_rol_select()
SELECT id, codigo, descripcion, observaciones, activo
FROM rol



CREATE PROCEDURE usp_rol_update(id1 int(11),codigo1 varchar(5),descripcion1 varchar(255),observaciones1 varchar(500),activo1 varchar(1))
update rol
set id            = id1,
    codigo        = codigo1,
    descripcion   = descripcion1,
    observaciones = observaciones1,
    activo        = activo1
where id = id1

call usp_rol_update('7', 'ADMIN', 'Administrador', 'Administrador de ', 'S');

CREATE PROCEDURE usp_rol_insert(id1 int(11),codigo1 varchar(5),descripcion1 varchar(255),observaciones1 varchar(500),activo1 varchar(1))
INSERT INTO rol
VALUES (NULL, codigo1, descripcion1, observaciones1, activo1);

call usp_rol_insert(null, 'DOC', 'Pepe', 'Administrador de ', 'S')
INSERT INTO rol
VALUES (NULL, 'DOC', 'Pepe', 'Administrador de ', 'S')

CREATE PROCEDURE usp_rol_delete(p_id INT)
DELETE FROM rol WHERE id = p_id;


delimiter //
CREATE PROCEDURE usp_insertar_Datos(dni1 varchar(9), nombre1 varchar(100), apellidos1 varchar(150), direccion1 varchar(300), cp1 varchar(5), poblacion1 varchar(100), provincia1 varchar(50), pais1 varchar(50), tlfno12 varchar(20), email1 varchar(50), observaciones1 varchar(500), sexo1 varchar(1), fnac1 date, nick1 varchar(16), passwd1 varchar(300), codigo1 varchar(5), OUT ID_PERSONA int, OUT ID_ROL int, OUT ID_USUARIO int)
begin

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

end//

call insertar_Datos('203040501', 'juan', 'mansilla', 'Calle random6', '28922', 'Alcorcon', 'Madrid', 'Espana',
                    '123456789', 'pepecampos@gmail.com', 'Probando el procedimiento1', 'H', '1990-02-20', 'juan',
                    'juan1', 'ADMIN', @ID_PERSONA, @ID_ROL, @ID_USUARIO);


delimiter //
CREATE PROCEDURE usp_modificar_Datos(id_usu int(11), dni1 varchar(9), nombre1 varchar(100), apellidos1 varchar(150), direccion1 varchar(300), cp1 varchar(5), poblacion1 varchar(100), provincia1 varchar(50), pais1 varchar(50), tlfno12 varchar(20), email1 varchar(50), observaciones1 varchar(500), sexo1 varchar(1), fnac1 date, nick1 varchar(16), passwd1 varchar(300), codigo1 varchar(5), OUT ID_PERSONA int, OUT ID_ROL int, OUT ID_USUARIO int)
begin

select id
INTO ID_PERSONA
from persona
where id = id_usu;
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
update usuario
set nick   = nick1,
    passwd = passwd1
where persona_id = ID_PERSONA;
select id
INTO ID_ROL
from rol
where codigo = codigo1;
select id
INTO ID_USUARIO
from usuario
where persona_id = ID_PERSONA;
update rol_usuario
set rol_id = ID_ROL
where usuario_id = ID_USUARIO;

end //


call modificar_Datos('1133', '202122223', 'juano', 'mansillote', 'Calle random70', '28922', 'mostoles', 'Madrid',
                     'Espana', '444567892', 'juanomansillote@gmail.com', 'Probando el procedimiento1', 'H',
                     '1993-01-25', 'juano', 'juano1', 'JEFE', @ID_PERSONA, @ID_ROL, @ID_USUARIO);