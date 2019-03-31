create database POO;

use POO;

set SQL_SAFE_UPDATES = 0;

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

/*Procedimiento para la eliminacion de departamentos*/
delimiter $$
create procedure eliminar_departamento (v_id int)
begin
	delete from departamento where id = v_id;
end$$
delimiter ;

/*Procedimiento para mostrar departamentos*/
delimiter $$
create procedure mostrar_departamento ()
begin
	select D.codigo, D.nombre, D.descripcion  from departamento D;
end$$
delimiter ;

/*Procedimiento para buscar departamentos*/
delimiter $$
create procedure buscar_departamento(v_buscar varchar(50))
begin
	select D.codigo, D.nombre, D.descripcion  from departamento D where D.codigo LIKE concat('%',v_buscar,'%') OR D.nombre LIKE concat('%',v_buscar,'%');
end$$
delimiter ;


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

/*Procedimiento para la eliminacion de departamentos*/
delimiter $$
create procedure eliminar_rol (v_id int)
begin
	delete from rol where id = v_id;
end$$
delimiter ;

/*Procedimiento para mostrar departamentos*/
delimiter $$
create procedure mostrar_rol ()
begin
	select R.id, R.rol, R.descripcion  from rol R;
end$$
delimiter ;

/*Procedimiento para buscar departamentos*/
delimiter $$
create procedure buscar_rol(v_buscar varchar(50))
begin
	select R.id, R.rol, R.descripcion  from rol R where R.rol LIKE concat('%',v_buscar,'%') OR R.descripcion LIKE concat('%',v_buscar,'%');
end$$
delimiter ;
/*call buscar_rol('sin des');

drop procedure buscar_departamento
truncate departamento
*/

/*Empleado*/
CREATE TABLE empleado(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL check (nombre NOT LIKE '%[0-9]%'),
    apellidos VARCHAR(50) NOT NULL check (apellidos NOT LIKE '%[0-9]%'),
    email VARCHAR(50) NOT NULL unique check(email LIKE '%_@_%_.__%'),
    contrasenia VARCHAR(50) NOT NULL,
    idRol INT not null,
    idDepartamento INT,
    FOREIGN KEY (idRol) REFERENCES rol(id) on update cascade,
    FOREIGN KEY (idDepartamento) REFERENCES departamento(id) on update cascade
);

/*INSERT INTO Empleado VALUES(null,'Alejandro','Alejo','alejandroalejo714@gmail.com','password',1,1);
select * from empleado;
select * from departamento;
call insertar_empleado('Denys','Inestroza','dennyscr@gmail.com',2,1);
call actualizar_empleado(2,'Enrique','Inestroza','enr@gmail.com',4,1);
call actualizar_empleado(3,'Denys','Inestroza','de@gmail.com',3,1);
call mostrar_empleados;
select * from empleado;
*/

delimiter $$
CREATE PROCEDURE insertar_empleado (v_nombre VARCHAR(50), v_apellidos VARCHAR(50), v_email varchar(50), v_rol int, v_depto int)
    BEGIN
		declare v_cnt int;
        declare v_sdepto varchar(50);
        declare v_mail_exist int;
        set v_mail_exist = (select count(*) from empleado where email = v_email limit 1);
        if v_mail_exist = 0 then 
			if v_rol = 2 then
				set v_cnt = (select count(*) from empleado where idDepartamento = v_depto and idRol = 2);
				if v_cnt != 0 then
					set v_sdepto = (select nombre from departamento where id = v_depto);
					select concat('Ya existe un jefe para el departamento: ',v_sdepto);
				else
					insert into empleado(nombre,apellidos,email,contrasenia,idRol,idDepartamento) values
					(v_nombre,v_apellidos,v_email,concat(lower(reverse(v_nombre)),503),v_rol,v_depto);
					set v_sdepto = (select nombre from departamento where id = v_depto);
					select concat('Insercion correcta de un nuevo miembro al departamento: ',v_sdepto);
				end if;
			elseif v_rol = 3 then
				set v_cnt = (select count(*) from empleado where idDepartamento = v_depto and idRol = 3);
				if v_cnt != 0 then
					set v_sdepto = (select nombre from departamento where id = v_depto);
					select concat('Ya existe un jefe de desarrollo para el departamento: ',v_sdepto);
				else
					insert into empleado(nombre,apellidos,email,contrasenia,idRol,idDepartamento) values
					(v_nombre,v_apellidos,v_email,concat(lower(reverse(v_nombre)),503),v_rol,v_depto);
					set v_sdepto = (select nombre from departamento where id = v_depto);
					select concat('Insercion correcta de un nuevo miembro al departamento: ',v_sdepto);
				end if;
			else
				insert into empleado(nombre,apellidos,email,contrasenia,idRol,idDepartamento) values
				(v_nombre,v_apellidos,v_email,concat(lower(reverse(v_nombre)),503),v_rol,v_depto);
				set v_sdepto = (select nombre from departamento where id = v_depto);
				select concat('Insercion correcta de un nuevo miembro al departamento: ',v_sdepto);
			end if;
		else
			select concat('El correo: ',v_email,', ya esta registrado');
		end if;
    END $$
delimiter ;
/*
call insertar_empleado('Jose','Alejo','alejo@gmail.com',2,2);
call actualizar_empleado(1,'Denys','Inestroza','contrasenia','denny@gmail.com',2,2);
select * from empleado;
*/

/*
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
*/

delimiter $$
CREATE PROCEDURE actualizar_empleado (v_id int, v_nombre VARCHAR(50), v_apellidos VARCHAR(50), v_email varchar(50), v_rol int, v_depto int)
    BEGIN
		declare v_cnt_rol_f int;
        declare v_cnt_rol_t int;
        declare v_sdepto varchar(50);
        declare v_cnt_email_t int;
        declare v_cnt_email_f int;
        
        set v_cnt_email_f = (select count(*) from empleado where email = v_email);
        set v_cnt_email_t = (select count(*) from empleado where email = v_email and id = v_id);
        if v_cnt_email_f = v_cnt_email_t then
        
			if v_rol = 2 then
            
				set v_cnt_rol_f = (select count(*) from empleado where idDepartamento = v_depto and idRol = 2);
				set v_cnt_rol_t = (select count(*) from empleado where idDepartamento = v_depto and idRol = 2 and id = v_id);
                
				if v_cnt_rol_f = v_cnt_rol_t then
					update empleado set nombre = v_nombre, apellidos = v_apellidos, email = v_email, idRol = v_rol, idDepartamento = v_depto where id = v_id;
					set v_sdepto = (select nombre from departamento where id = v_depto);
					select concat('Se actualizo un miembro del departamento: ',v_sdepto);
				else
					set v_sdepto = (select nombre from departamento where id = v_depto);
					select concat('Ya existe un jefe para el departamento: ',v_sdepto);
				end if;
                
			else if v_rol = 3 then
            
				set v_cnt_rol_f = (select count(*) from empleado where idDepartamento = v_depto and idRol = 3);
				set v_cnt_rol_t = (select count(*) from empleado where idDepartamento = v_depto and idRol = 3 and id = v_id);
                
				if v_cnt_rol_f = v_cnt_rol_t then
					update empleado set nombre = v_nombre, apellidos = v_apellidos, email = v_email, idRol = v_rol, idDepartamento = v_depto where id = v_id;
					set v_sdepto = (select nombre from departamento where id = v_depto);
					select concat('Se actualizo un miembro del departamento: ',v_sdepto);
				else
					set v_sdepto = (select nombre from departamento where id = v_depto);
					select concat('Ya existe un jefe de desarrollo para el departamento: ',v_sdepto);
				end if;
			else
				update empleado set nombre = v_nombre, apellidos = v_apellidos, email = v_email, idRol = v_rol, idDepartamento = v_depto where id = v_id;
				set v_sdepto = (select nombre from departamento where id = v_depto);
				select concat('Se actualizo un miembro del departamento: ',v_sdepto);
			end if;
		end if;
		else
			select concat('El correo: ',v_email,', ya esta registrado');
		end if;
    END $$
delimiter ;


delimiter $$
CREATE PROCEDURE Loguearse  (Usuario VARCHAR(50),Contrasenia VARCHAR(50))
    BEGIN
        SELECT e.Nombre,r.rol AS Rol,d.Nombre AS departamento
        FROM empleado e
        INNER JOIN rol r
        ON e.idRol = r.id
        INNER JOIN departamento d
        ON e.idDepartamento = d.id
        WHERE e.Email = Usuario AND e.Contrasenia = Contrasenia; 
    END $$
delimiter ;


/*
CALL Loguearse ('alejandroalejo714@gmail.com','password');
*/
delimiter //
create procedure eliminar_empleado(v_id int)
	begin
		delete from empleado where id = v_id;
        if (row_count() > 0 ) then
			select 'Se elimino con exito';
		else
			select 'No se pudo eliminar';
		end if;
    end //
delimiter ;

delimiter //
create procedure buscar_empleados(v_buscar varchar(50))
    begin
        SELECT e.id,e.nombre,e.apellidos,e.email,r.id,r.rol,d.id,d.Nombre 
        FROM empleado e INNER JOIN rol r ON e.idRol = r.id 
        INNER JOIN departamento d ON e.idDepartamento = d.id
        where e.nombre LIKE concat('%',v_buscar,'%') OR e.apellidos LIKE concat('%',v_buscar,'%') OR e.email LIKE concat('%',v_buscar,'%');
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
		SELECT e.id,e.nombre,e.apellidos,e.email,r.id,r.rol,d.id,d.Nombre 
        FROM empleado e INNER JOIN rol r ON e.idRol = r.id 
        INNER JOIN departamento d ON e.idDepartamento = d.id
        where e.idRol in (1,2,3);
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


delimiter //
create procedure realizar_solicitud(v_nombre varchar(50), v_descripcion varchar(1000),v_depto int)
begin
	declare sdepto varchar(50);
    declare count_nombre varchar(50);
    set count_nombre = (select count(*) from solicitud where nombre = v_nombre and idDepartamento = v_depto);
    set sdepto = (select d.nombre from departamento d where d.id = v_depto);
    if count_nombre = 0 then
		if length(v_descripcion) = 0 then
			insert into solicitud(nombre, descripcion,idDepartamento) values (v_nombre,default,v_depto);
        else 
			insert into solicitud(nombre, descripcion,idDepartamento) values (v_nombre,v_descripcion,v_depto);
		end if;
	else
		select concat('ya existe una solicitud con el nombre: ',v_nombre,', en el departamento: ', sdepto);
	end if;
end//
delimiter ;
call realizar_solicitud('solicitud v2','',1);


delimiter //
create procedure mostrar_solicitudes(v_idDepto int)
begin
       SELECT id,nombre,descripcion FROM solicitud WHERE idDepartamento = v_idDepto AND idEstado = 1;
end //
delimiter ;
/*call mostrar_solicitud_jefe(1);*/


delimiter //
create procedure buscar_solicitud_jefe(v_buscar varchar(50), v_depto int)
	begin
		declare v_count_soli int;
        set v_count_soli = (select count(*) from solicitud s inner join departamento d on s.idDepartamento = d.id where s.idDepartamento = v_depto 
							and s.nombre LIKE concat('%',v_buscar,'%'));
        if v_count_soli != 0 then
			select s.id, s.nombre, s.descripcion, s.idDepartamento, d.nombre from solicitud s inner join departamento d on s.idDepartamento = d.id
			where s.idDepartamento = v_depto and s.nombre LIKE concat('%',v_buscar,'%');
		else
			select 'No existen coincidencias';
		end if;
	end//
delimiter ;
/*call buscar_solicitud_jefe('you',1);*/



select * from solicitud;
select * from departamento;

delimiter //
create procedure modificar_solicitud_jefe(v_id int, v_nombre varchar(50), v_descripcion varchar(1000), v_depto int)
begin
	declare count_name_f int;
    declare count_name_t int;
    set count_name_f = (select count(*) from solicitud where nombre = v_nombre and idDepartamento = v_depto);
    set count_name_t = (select count(*) from solicitud where nombre = v_nombre and idDepartamento = v_depto and id = v_id);
    if (count_name_f = count_name_t) then
		if (length(v_descripcion) = 0) then
			update solicitud set nombre = v_nombre, descripcion = default where id = v_id;
		else 
			update solicitud set nombre = v_nombre, descripcion = v_descripcion where id = v_id;
		end if;
	else
		select 'El nombre de la solicitud ya existe, intente con un nombre diferente';
    end if;
end//
delimiter ;
/*call modificar_solicitud_jefe(3,'Prueba','con descripcion',1);*/

delimiter //
create procedure eliminar_solicitud (v_id int)
begin
	delete from solicitud where id=v_id;
    if (row_count() > 0 ) then
			select 'Se elimino con exito';
		else
			select 'No se pudo eliminar';
		end if;
end//
delimiter ;
call eliminar_solicitud (7);

select * from empleado;

/*
update solicitud set idEstado = 3 where id = 4;
*/
create table caso(
	id int primary key auto_increment,
    codigo char(9) not null,
	nombre varchar(50) not null,
    idSolicitud int not null,
    descripcion varchar(1000) not null default 'Sin descripcion',
    fechaInicio date check(fechaInicio >= now()),
    fechaFinal date check(fechaFinal > fechaInicio),
    idDepartamento int not null,
    idEstado int not null default 3,
    idEncargado int,
    pdf bit(64),
    descripcionElementos varchar(1000),
    idTester int,
    fechaLanzamiento date check(fechaLanzamiento >= fechaFinal),
    foreign key (idDepartamento) references departamento(id) on update cascade,
    foreign key (idEstado) references estado(id) on update cascade,
    foreign key (idEncargado) references empleado(id) on update cascade,
    foreign key (idTester) references empleado(id) on update cascade
);


create table rechazo(
	id int primary key auto_increment,
    idSolicitud int unique not null,
    motivo varchar(500),
    foreign key(idSolicitud) references solicitud(id)
);


/*Encontrar programadores y empleados sin caso*/
delimiter //
create procedure programadores_sin_caso(v_depto int)
begin
	select e.id, e.nombre from empleado e left join caso c on e.id = c.idEncargado where c.idEncargado is null and e.idRol = 5 and e.idDepartamento = v_depto;
end//
delimiter ;
call programadores_sin_caso(1);


delimiter //
create procedure empleados_sin_caso(v_depto int)
begin
	select e.id, e.nombre from empleado e left join caso c on e.id = c.tester where c.idEncargado is null and e.idRol = 4 and e.idDepartamento = v_depto;
end//
delimiter ;
call empleados_sin_caso(1);

delimiter //
create trigger solicitud_accion after update on solicitud
for each row
begin
	declare sdepto varchar(9);
    declare scodigo varchar(9);
	if new.idEstado = 3 then
		set sdepto = (select substring(d.codigo,1,3) from departamento d inner join solicitud s on s.idDepartamento = d.id where s.idDepartamento = new.idDepartamento limit 1);
		set scodigo = concat(sdepto,date_format(new.fecha,'%y'),100 + round(rand() * 899 ));
		insert into caso(idSolicitud,nombre,descripcion,idDepartamento,idEstado,codigo) values
		(new.id,new.nombre,new.descripcion,new.idDepartamento,new.idEstado,scodigo);
    else
		if new.idEstado = 2 then
			insert into rechazo(idSolicitud,nombre) values
			(new.id,new.nombre);
		end if;
	end if;
end//
delimiter ;

/*
select * from solicitud;

use poo;
call insertar_departamento('Administracion','');
select * from departamento;

/*
insert into solicitud(nombre,descripcion,pdf,idDepartamento,fecha,idEstado) values ('prueba v2',default,null,2,default,default);

update solicitud set idEstado = 3 where id = 8;
*/

select * from departamento;
select * from solicitud;
select * from caso;
select * from rechazo;

create table bitacora(
	id int primary key auto_increment,
    idCaso int unique not null,
    informacion varchar(1000) not null,
    porcentajeAvance int not null check(porcentajeAvance < 101 AND porcentajeAvance > 0),
    finalizado boolean,
    foreign key (idCaso) references caso(id)
);

select now();

create table prueba(
	fecha date
);
select * from prueba;
insert into prueba values ('2019/03/31');*/

delimiter //
create procedure crear_caso(v_solicitud int, v_fecha date, v_programador int, v_tester int, v_descripcion varchar(1000))
begin
	declare count_soli int;
    set count_soli = (select count(*) from caso c inner join solicitud s on s.id = c.idSolicitud where c.idSolicitud = v_solicitud);
    if count_soli != 0 then
		select 'Esta solicitud ya pertenece a un caso';
	else
		set count_soli = (select count(*) from rechazo r inner join solicitud s on s.id = r.idSolicitud where r.idSolicitud = v_solicitud);
		if count_soli != 0 then
			select 'Esta solicitud ya fue rechazada';
		else
			update solicitud set idEstado = 3 where id = v_solicitud;
            if length(v_descripcion) != 0 then
				update caso set fechaInicio = now(),fechaFinal = v_fecha,idEncargado = v_programador, idTester = v_tester, descripcionElementos = v_descripcion where idSolicitud = v_solicitud;
            else
				update caso set fechaInicio = now(),fechaFinal = v_fecha,idEncargado = v_programador, idTester = v_tester, descripcionElementos = 'Sin descripcion de elementos clave' where idSolicitud = v_solicitud;
			end if;
        end if;
	end if;
end//
delimiter ;

select * from caso;
