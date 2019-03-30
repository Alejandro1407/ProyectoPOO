create database POO;

use POO;

create table departamento(
	id int primary key auto_increment,
    codigo varchar(20) unique,
    nombre varchar(50) not null unique,
    descripcion varchar(100) not null default 'Sin descripcion'
);

/*Procedimiento para la insercion de departamentos*/
delimiter $$
create procedure insertar_departamento (v_nombre varchar(50),v_descripcion varchar(100))
begin
	declare v_aux varchar(15);
    declare v_id int;
    if(length(v_descripcion) = 0) then
		insert into departamento(nombre,descripcion) values (v_nombre,default);
	else 
		insert into departamento(nombre,descripcion) values (v_nombre,v_descripcion);
    end if;
    set v_id = (select id from departamento where nombre = v_nombre);
    set v_aux = concat('D',UPPER(substr(v_nombre,1,3)), cast(v_id as char(4)));
    update departamento set codigo = (v_aux) where id = v_id ;
end$$
delimiter ;
call insertar_departamento('Ventas','');
call insertar_departamento('Ventas2','Este departamento lleva el control de las ventas de la empresa');

/*Procedimiento para la actualizacion de departamentos*/
delimiter $$
create procedure actualizar_departamento (v_id int, v_nombre varchar(50),v_descripcion varchar(100))
begin
	if(length(v_descripcion) = 0) then
		update departamento set codigo=concat('D',UPPER(substr(v_nombre,1,3)),v_id), nombre = v_nombre, descripcion = default where id = v_id;
	else 
		update departamento set codigo=concat('D',UPPER(substr(v_nombre,1,3)),v_id), nombre = v_nombre, descripcion = v_descripcion where id = v_id;
    end if;
end$$
delimiter ;
call actualizar_departamento (2,'Nuevo','');

/*Procedimiento para la eliminacion de departamentos*/
delimiter $$
create procedure eliminar_departamento (v_id int)
begin
	delete from departamento where id = v_id;
end$$
delimiter ;
call eliminar_departamento (1);

/*Procedimiento para mostrar departamentos*/
delimiter $$
create procedure mostrar_departamento ()
begin
	select D.codigo, D.nombre, D.descripcion  from departamento D;
end$$
delimiter ;
call mostrar_departamento ();

/*Procedimiento para buscar departamentos*/
delimiter $$
create procedure buscar_departamento(v_buscar varchar(50))
begin
	select D.codigo, D.nombre, D.descripcion  from departamento D where D.codigo LIKE concat('%',v_buscar,'%') OR D.nombre LIKE concat('%',v_buscar,'%');
end$$
delimiter ;
call buscar_departamento('vent');




create table rol(
	id int primary key auto_increment,
    rol varchar(25) not null unique,
    descripcion varchar(100) not null default 'Sin descripcion'
);

/*Procedimiento para la insercion de roles*/
delimiter $$
create procedure insertar_rol (v_rol varchar(25),v_descripcion varchar(100))
begin
	if(length(v_descripcion) = 0) then
		insert into rol(rol,descripcion) values (v_rol,default);
	else 
		insert into rol(rol,descripcion) values (v_rol,v_descripcion);
    end if;
end$$
delimiter ;
call insertar_rol('Programador','');

/*Procedimiento para la actualizacion de departamentos*/
delimiter $$
create procedure actualizar_rol (v_id int, v_rol varchar(25),v_descripcion varchar(100))
begin
	if(length(v_descripcion) = 0) then
		update rol set rol = v_rol, descripcion = default where id = v_id;
	else 
		update rol set rol = v_rol, descripcion = v_descripcion where id = v_id;
    end if;
end$$
delimiter ;
call actualizar_rol (1,'su','');

/*Procedimiento para la eliminacion de departamentos*/
delimiter $$
create procedure eliminar_rol (v_id int)
begin
	delete from rol where id = v_id;
end$$
delimiter ;
call eliminar_rol (1);

/*Procedimiento para mostrar departamentos*/
delimiter $$
create procedure mostrar_rol ()
begin
	select R.rol, R.descripcion  from rol R;
end$$
delimiter ;
call mostrar_rol ();

/*Procedimiento para buscar departamentos*/
delimiter $$
create procedure buscar_rol(v_buscar varchar(50))
begin
	select R.rol, R.descripcion  from rol R where R.rol LIKE concat('%',v_buscar,'%') OR R.descripcion LIKE concat('%',v_buscar,'%');
end$$
delimiter ;
call buscar_rol('sin des');
/*
drop procedure buscar_departamento
truncate departamento
*/


/*Empleado*/
CREATE TABLE Empleado(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL check (nombre NOT LIKE '%[0-9]%'),
    apellidos VARCHAR(50) NOT NULL check (apellidos NOT LIKE '%[0-9]%'),
    email VARCHAR(50) NOT NULL unique check(email LIKE '%_@_%_.__%'),
    contrasenia VARCHAR(50) NOT NULL,
    idRol INT not null default 4,
    idDepartamento INT not null,
    FOREIGN KEY (idRol) REFERENCES rol(id) on update cascade,
    FOREIGN KEY (idDepartamento) REFERENCES departamento(id) on update cascade
);

INSERT INTO Empleado VALUES(null,'Alejandro','Alejo','alejandroalejo714@gmail.com','password',1,1);
select * from empleado;
select * from departamento;
call insertar_empleado('Denys','Inestroza','dennyscr@gmail.com',2,1);
call actualizar_empleado(2,'Enrique','Inestroza','enr@gmail.com',4,1);
call actualizar_empleado(3,'Denys','Inestroza','de@gmail.com',3,1);
call mostrar_empleados;
select * from empleado;

delimiter $$
CREATE PROCEDURE insertar_empleado (v_nombre VARCHAR(50), v_apellidos VARCHAR(50), v_email varchar(50), v_rol int, v_depto int)
    BEGIN
		declare v_cnt int;
        declare v_sdepto varchar(50);
		if v_rol = 2 then
			set v_cnt = (select count(*) from empleado where idDepartamento = v_depto and idRol = 2);
            if v_cnt != 0 then
				set v_sdepto = (select nombre from departamento where id = v_depto);
				select concat('Ya existe un jefe para el departamento: ',v_sdepto);
			else
				if v_rol = 0 then
					insert into empleado(nombre,apellidos,email,contrasenia,idRol,idDepartamento) values
					(v_nombre,v_apellidos,v_email,concat(lower(reverse(v_nombre)),503),default,v_depto);
                    set v_sdepto = (select nombre from departamento where id = v_depto);
					select concat('Insercion correcta de un nuevo miembro al departamento: ',v_sdepto);
				else
					insert into empleado(nombre,apellidos,email,contrasenia,idRol,idDepartamento) values
					(v_nombre,v_apellidos,v_email,concat(lower(reverse(v_nombre)),503),v_rol,v_depto);
                    set v_sdepto = (select nombre from departamento where id = v_depto);
					select concat('Insercion correcta de un nuevo miembro al departamento: ',v_sdepto);
				end if;
			end if;
		elseif v_rol = 3 then
			set v_cnt = (select count(*) from empleado where idDepartamento = v_depto and idRol = 3);
            if v_cnt != 0 then
				set v_sdepto = (select nombre from departamento where id = v_depto);
				select concat('Ya existe un jefe de desarrollo para el departamento: ',v_sdepto);
			else
				if v_rol = 0 then
					insert into empleado(nombre,apellidos,email,contrasenia,idRol,idDepartamento) values
					(v_nombre,v_apellidos,v_email,concat(lower(reverse(v_nombre)),503),default,v_depto);
                    set v_sdepto = (select nombre from departamento where id = v_depto);
					select concat('Insercion correcta de un nuevo miembro al departamento: ',v_sdepto);
				else
					insert into empleado(nombre,apellidos,email,contrasenia,idRol,idDepartamento) values
					(v_nombre,v_apellidos,v_email,concat(lower(reverse(v_nombre)),503),v_rol,v_depto);
                    set v_sdepto = (select nombre from departamento where id = v_depto);
					select concat('Insercion correcta de un nuevo miembro al departamento: ',v_sdepto);
				end if;
			end if;
		else
			if v_rol = 0 then
				insert into empleado(nombre,apellidos,email,contrasenia,idRol,idDepartamento) values
				(v_nombre,v_apellidos,v_email,concat(lower(reverse(v_nombre)),503),default,v_depto);
                set v_sdepto = (select nombre from departamento where id = v_depto);
				select concat('Insercion correcta de un nuevo miembro al departamento: ',v_sdepto);
			else
				insert into empleado(nombre,apellidos,email,contrasenia,idRol,idDepartamento) values
				(v_nombre,v_apellidos,v_email,concat(lower(reverse(v_nombre)),503),v_rol,v_depto);
                set v_sdepto = (select nombre from departamento where id = v_depto);
				select concat('Insercion correcta de un nuevo miembro al departamento: ',v_sdepto);
			end if;
		end if;
    END $$
delimiter ;

set SQL_SAFE_UPDATES = 0;

call insertar_empleado('Jose','Alejo','alejo@gmail.com',2,2);
call actualizar_empleado(1,'Denys','Inestroza','contrasenia','denny@gmail.com',2,2);
select * from empleado;


delimiter $$
CREATE PROCEDURE actualizar_empleado (v_id int, v_nombre VARCHAR(50), v_apellidos VARCHAR(50), v_email varchar(50), v_rol int, v_depto int)
    BEGIN
		declare v_cnt int;
        declare v_sdepto varchar(50);
			update empleado set nombre = v_nombre, apellidos = v_apellidos, email = v_email, idRol = v_rol, idDepartamento = v_depto where id = v_id;
			set v_sdepto = (select nombre from departamento where id = v_depto);
			select concat('Se actualizo un miembro del departamento: ',v_sdepto);
    END $$
delimiter ;


delimiter $$
CREATE PROCEDURE Loguearse  (Usuario VARCHAR(50),Contrasenia VARCHAR(50))
    BEGIN
        SELECT e.Nombre,r.rol AS Rol,d.Nombre AS Departamento
        FROM Empleado e
        INNER JOIN rol r
        ON e.idRol = r.id
        INNER JOIN departamento d
        ON e.idDepartamento = d.id
        WHERE e.Email = Usuario AND e.Contrasenia = Contrasenia; 
    END $$
delimiter ;
CALL Loguearse ('alejandroalejo714@gmail.com','password');

delimiter //
create procedure eliminar_empleado(v_id int)
	begin
		delete from empleado where id = v_id;
        if (row_count() > 0 ) then
			select 'No se pudo eliminar';
		else
			select 'Se elimino con exito';
		end if;
    end //
delimiter ;


delimiter //
create procedure buscar_empleados(v_buscar varchar(50))
	begin
		SELECT e.id,e.nombre,e.apellidos,e.email,r.rol,d.Nombre 
        FROM empleado e INNER JOIN rol r ON e.idRol = r.id 
        INNER JOIN departamento d ON e.idDepartamento = d.id
        where e.nombre LIKE concat('%',v_buscar,'%') OR e.apellidos LIKE concat('%',v_buscar,'%') OR e.email LIKE concat('%',v_buscar,'%')
        OR r.rol LIKE concat('%',v_buscar,'%') OR d.nombre LIKE concat('%',v_buscar,'%') and e.idRol not in(1,2,3);
    end //
delimiter ;


delimiter //
create procedure mostrar_empleados()
	begin
		SELECT e.id,e.nombre,e.apellidos,e.email,r.rol,d.Nombre 
        FROM empleado e INNER JOIN rol r ON e.idRol = r.id 
        INNER JOIN departamento d ON e.idDepartamento = d.id;
    end//
delimiter ;

/*
Administrador (SU): 1
Jefes de area: 2
Jefe de desarrollo: 3
Empleado: 4
Programador: 5
*/
delimiter //
create procedure mostrar_administradores()
	begin
		SELECT e.id,e.nombre,e.apellidos,e.email,r.rol,d.Nombre 
        FROM empleado e INNER JOIN rol r ON e.idRol = r.id 
        INNER JOIN departamento d ON e.idDepartamento = d.id
        where e.idRol = 1;
    end//
delimiter ;


delimiter //
create procedure mostrar_solo_empleados()
	begin
		SELECT e.id,e.nombre,e.apellidos,e.email,r.id,r.rol,d.id,d.Nombre 
        FROM empleado e INNER JOIN rol r ON e.idRol = r.id 
        INNER JOIN departamento d ON e.idDepartamento = d.id
        where e.idRol not in(1,2,3);
    end//
delimiter ;


delimiter //
create procedure mostrar_jefes_area()
	begin
		SELECT e.id,e.nombre,e.apellidos,e.email,r.rol,d.Nombre 
        FROM empleado e INNER JOIN rol r ON e.idRol = r.id 
        INNER JOIN departamento d ON e.idDepartamento = d.id
        where e.idRol = 2;
    end//
delimiter ;

delimiter //
create procedure mostrar_jefes_desarrollo()
	begin
		SELECT e.id,e.nombre,e.apellidos,e.email,r.rol,d.Nombre 
        FROM empleado e INNER JOIN rol r ON e.idRol = r.id 
        INNER JOIN departamento d ON e.idDepartamento = d.id
        where e.idRol = 3;
    end//
delimiter ;


delimiter //
create procedure mostrar_jefes_todos()
	begin
		SELECT e.id,e.nombre,e.apellidos,e.email,r.rol,d.Nombre 
        FROM empleado e INNER JOIN rol r ON e.idRol = r.id 
        INNER JOIN departamento d ON e.idDepartamento = d.id
        where e.idRol = 3 and e.idRol = 2;
    end//
delimiter ;


call mostrar_empleados;

/*Para diferenciar los estados y solo mostrar los estados de solicitudes para las opciones de solicitudes y de igual manera para los casos*/
create table tipo_estado(
	id int primary key auto_increment,
    tipo_estado varchar(50) not null unique
);
/**/
insert into tipo_estado(tipo_estado) values ('Solicitud');
insert into tipo_estado(tipo_estado) values ('Caso');
insert into tipo_estado(tipo_estado) values ('Ambos');
insert into tipo_estado(tipo_estado) values ('Probador');

select * from tipo_estado order by id;

/*Estado*/
create table estado(
	id int primary key auto_increment,
    estado varchar(50) not null,
    tipo int not null check(tipo = 1 OR tipo = 2 OR tipo = 3 OR tipo = 4),
    foreign key (tipo) references tipo_estado(id) on update cascade
);
insert into estado(estado,tipo) values ('En espera de respuesta',1);
insert into estado(estado,tipo) values ('Solicitud rechazada',1);
insert into estado(estado,tipo) values ('En desarrollo',3);
insert into estado(estado,tipo) values ('Vencido',2);
insert into estado(estado,tipo) values ('Esperando aprobacion del area solicitante',2);
insert into estado(estado,tipo) values ('Devuelto con observaciones',4);
insert into estado(estado,tipo) values ('Aprobado',4);
insert into estado(estado,tipo) values ('Rechazado',4);

select * from estado;


/*Los estados que se mostraran para los diferentes usuarios*/
delimiter //
create procedure estados_programador()
	begin
		select E.id, E.estado from estado E join tipo_estado TE on E.tipo = TE.id where TE.id = 2 OR TE.id = 3 order by E.id;
	end//
delimiter ;
call estados_programador;


delimiter //
create procedure estados_probador()
	begin
		select E.id, E.estado from estado E join tipo_estado TE on E.tipo = TE.id where TE.id = 4 order by E.id;
	end//
delimiter ;
call estados_probador;


delimiter //
create procedure estados_solicitud()
	begin
		select E.id, E.estado from estado E join tipo_estado TE on E.tipo = TE.id where TE.id = 1 OR TE.id = 3 order by E.id;
	end//
delimiter ;
call estados_solicitud;


/*Solicitud*/

create table solicitud(
	id int primary key auto_increment,
    nombre varchar(50) not null,
    descripcion varchar(1000) not null default 'Sin descripcion',
    pdf bit(64),
    idDepartamento int not null,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    idEstado int not null default 1,
    foreign key (idDepartamento) references departamento(id),
    foreign key (idEstado) references estado(id)
);

select * from solicitud;

update solicitud set idEstado = 3 where id = 4;

create table caso(
	id int primary key auto_increment,
    codigo char(9) not null,
	nombre varchar(50) not null,
    descripcion varchar(1000) not null default 'Sin descripcion',
    fechaInicio date check(fechaInicio >= now()),
    fechaFinal date check(fechaFinal > fechaInicio),
    idDepartamento int not null,
    idEstado int not null default 3,
    idEncargado int,
    pdf bit(64),
    descripcionElementos varchar(1000),
    Tester int,
    fechaLanzamiento date check(fechaLanzamiento >= fechaFinal),
    foreign key (idDepartamento) references departamento(id) on update cascade,
    foreign key (idEstado) references estado(id) on update cascade,
    foreign key (idEncargado) references empleado(id) on update cascade,
    foreign key (Tester) references empleado(id) on update cascade
);

create table rechazo(
	id int primary key auto_increment,
    idSolicitud int unique not null,
    nombre varchar(50) not null,
    motivo varchar(500),
    foreign key(idSolicitud) references solicitud(id)
);


delimiter //
create trigger crear_caso after update on solicitud
for each row
begin
	insert into caso(nombre,descripcion,idDepartamento,idEstado,codigo) values
	(new.nombre,new.descripcion,new.idDepartamento,new.idEstado,concat('Depato',date_format(new.fecha,'%y'),100 + round(rand() * 889)));
end//
delimiter ;

select * from solicitud;
drop trigger crear_caso;

use poo;
call insertar_departamento('Administracion','');
select * from departamento;

use poo
drop trigger crear_rechazo

delimiter //
create trigger crear_rechazo before update on solicitud
for each row
begin
	if new.idEstado = 2 then
		insert into rechazo(idSolicitud,nombre) values (new.id,new.nombre);
	end if;
end//
delimiter ;

insert into solicitud(nombre,descripcion,pdf,idDepartamento,fecha,idEstado) values ('prueba',default,null,1,default,default);
delete from solicitud where id = 4;
update solicitud set idEstado = 2 where id = 5;

select * from solicitud;
select * from caso;
select * from rechazo;

