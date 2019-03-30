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
call insertar_rol('Jefe','Este departamento lleva el control de las ventas de la empresa');

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
call actualizar_rol (1,'Nuevo2','');

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
    idRol INT not null default 3,
    idDepartamento INT not null,
    FOREIGN KEY (idRol) REFERENCES rol(id) on update cascade,
    FOREIGN KEY (idDepartamento) REFERENCES departamento(id) on update cascade
);


select concat(lower(reverse('Denys')),503,1);

INSERT INTO Empleado VALUES(null,'Alejandro','Alejo','alejandroalejo714@gmail.com','password',1,1);
select * from empleado;
select * from departamento;
call actualizar_empleado(1,'Denys','Inestroza','denny@gmail.com',2,1);

select * from empleado;
drop procedure actualizar_empleado
delimiter $$
CREATE PROCEDURE insertar_empleado (v_nombre VARCHAR(50), v_apellidos VARCHAR(50), v_email varchar(50), v_rol int, v_depto int)
    BEGIN
		declare v_cnt int;
        declare v_sdepto varchar(50);
		if v_rol = 1 then
			set v_cnt = (select count(*) from empleado where idDepartamento = v_depto and idRol = 1);
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
		elseif v_rol = 2 then
			set v_cnt = (select count(*) from empleado where idDepartamento = v_depto and idRol = 2);
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


select * from empleado;
select * from departamento;
call actualizar_empleado(1,'Denys','Inestroza','denny@gmail.com',1,1);
drop procedure actualizar_empleado
delimiter $$
CREATE PROCEDURE actualizar_empleado (v_id int, v_nombre VARCHAR(50), v_apellidos VARCHAR(50), v_email varchar(50), v_rol int, v_depto int)
    BEGIN
		declare v_cnt int;
        declare v_sdepto varchar(50);
		if v_rol = 1 then
			set v_cnt = (select count(*) from empleado where idDepartamento = v_depto and idRol = 1 and id = v_id);
            if v_cnt = 0 then
				set v_sdepto = (select nombre from departamento where id = v_depto);
				select concat('Ya existe un jefe para el departamento: ',v_sdepto);
			else
				if v_rol = 0 then
					update empleado set nombre = v_nombre, apellidos = v_apellidos, email = v_email, contrasenia = concat(lower(reverse(v_nombre)),503), idRol = default, idDepartamento = v_depto;
					set v_sdepto = (select nombre from departamento where id = v_depto);
					select concat('Se actualizo un miembro del departamento: ',v_sdepto);
				else
					update empleado set nombre = v_nombre, apellidos = v_apellidos, email = v_email, contrasenia = concat(lower(reverse(v_nombre)),503), idRol = v_rol, idDepartamento = v_depto;
					set v_sdepto = (select nombre from departamento where id = v_depto);
					select concat('Se actualizo un miembro del departamento: ',v_sdepto);
				end if;
			end if;
		elseif v_rol = 2 then
			set v_cnt = (select count(*) from empleado where idDepartamento = v_depto and idRol = 2 and id = v_id);
            if v_cnt = 0 then
				set v_sdepto = (select nombre from departamento where id = v_depto);
				select concat('Ya existe un jefe de desarrollo para el departamento: ',v_sdepto);
			else
				if v_rol = 0 then
					update empleado set nombre = v_nombre, apellidos = v_apellidos, email = v_email, contrasenia = concat(lower(reverse(v_nombre)),503), idRol = default, idDepartamento = v_depto;
					set v_sdepto = (select nombre from departamento where id = v_depto);
					select concat('Se actualizo un miembro del departamento: ',v_sdepto);
				else
					update empleado set nombre = v_nombre, apellidos = v_apellidos, email = v_email, contrasenia = concat(lower(reverse(v_nombre)),503), idRol = v_rol, idDepartamento = v_depto;
					set v_sdepto = (select nombre from departamento where id = v_depto);
					select concat('Se actualizo un miembro del departamento: ',v_sdepto);
				end if;
			end if;
		else
			if v_rol = 0 then
				update empleado set nombre = v_nombre, apellidos = v_apellidos, email = v_email, contrasenia = concat(lower(reverse(v_nombre)),503), idRol = default, idDepartamento = v_depto;
				set v_sdepto = (select nombre from departamento where id = v_depto);
				select concat('Se actualizo un miembro del departamento: ',v_sdepto);
			else
				update empleado set nombre = v_nombre, apellidos = v_apellidos, email = v_email, contrasenia = concat(lower(reverse(v_nombre)),503), idRol = v_rol, idDepartamento = v_depto;
				set v_sdepto = (select nombre from departamento where id = v_depto);
				select concat('Se actualizo un miembro del departamento: ',v_sdepto);
			end if;
		end if;
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
		select * from empleado E join rol R on R.id = E.idRol join departamento D on D.id = E.idDepartamento
        where E.nombre LIKE concat('%',v_buscar,'%') OR E.apellidos LIKE concat('%',v_buscar,'%') OR E.email LIKE concat('%',v_buscar,'%')
        OR R.rol LIKE concat('%',v_buscar,'%') OR D.nombre LIKE concat('%',v_buscar,'%');
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

delimiter //
create procedure mostrar_solo_empleados()
	begin
		SELECT e.id,e.nombre,e.apellidos,e.email,r.rol,d.Nombre 
        FROM empleado e INNER JOIN rol r ON e.idRol = r.id 
        INNER JOIN departamento d ON e.idDepartamento = d.id
        where e.idRol = 3;
    end//
delimiter ;

delimiter //
create procedure mostrar_jefes_area()
	begin
		SELECT e.id,e.nombre,e.apellidos,e.email,r.rol,d.Nombre 
        FROM empleado e INNER JOIN rol r ON e.idRol = r.id 
        INNER JOIN departamento d ON e.idDepartamento = d.id
        where e.idRol = 1;
    end//
delimiter ;

delimiter //
create procedure mostrar_jefes_desarrollo()
	begin
		SELECT e.id,e.nombre,e.apellidos,e.email,r.rol,d.Nombre 
        FROM empleado e INNER JOIN rol r ON e.idRol = r.id 
        INNER JOIN departamento d ON e.idDepartamento = d.id
        where e.idRol = 2;
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


create table caso(
	nombre varchar(50) not null,
    descripcion varchar(1000) not null default 'Sin descripcion',
    idDepartamento int not null,
    fecha TIMESTAMP default CURRENT_TIMESTAMP,
    idEstado int not null default 1
);


delimiter //
create trigger crear_caso before update on solicitud
for each row
begin
	if new.idEstado = 2 then
		insert into caso(nombre,descripcion,idDepartamento,idEstado,fecha) values (new.nombre,new.descripcion,new.idDepartamento,new.idEstado,default);
	end if;
end//
delimiter ;

drop trigger crear_caso;
insert into solicitud(nombre,descripcion,pdf,idDepartamento,fecha,idEstado) values ('Solicitud',default,null,1,default,default);
update solicitud set idEstado = 2 where id = 1;

select * from solicitud;
select * from caso;

