/* Script de Base de Datos POO Ciclo 01 2019 Universidad Don Bosco */

/*
* Administrador (SU): 1
* Jefes de area: 2
* Jefe de desarrollo: 3
* Empleado: 4
* Programador: 5
*/

set SQL_SAFE_UPDATES = 0;

create database SistemaPOO;

use SistemaPOO;

create table departamento(
    id int primary key auto_increment,
    codigo varchar(20) unique,
    nombre varchar(50) not null unique,
    descripcion varchar(100) not null default 'Sin descripcion'
);

/* CRUD Departamento */

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
delimiter //
create procedure eliminar_departamento(v_depto int)
begin
    DECLARE empl_dep INT;
    SET empl_dep = (SELECT COUNT(e.id) FROM empleado e WHERE e.idDepartamento = v_depto);
    if(empl_dep = 0) then
        DELETE FROM departamento WHERE id = v_depto;
        SELECT CONCAT ('Se elimino correctamente'); 
    else
        SELECT CONCAT ('Aun hay ' ,empl_dep, ' en este Departamento'); 
    end if;
end //
delimiter ;


/*Procedimiento para mostrar departamentos*/
delimiter $$
create procedure mostrar_departamento ()
begin
	select D.id, D.nombre, D.descripcion  from departamento D;
end$$
delimiter ;

/*Procedimiento para buscar departamentos*/
delimiter $$
create procedure buscar_departamento(v_buscar varchar(50))
begin
	select D.codigo, D.nombre, D.descripcion  from departamento D where D.codigo LIKE concat('%',v_buscar,'%') OR D.nombre LIKE concat('%',v_buscar,'%');
end$$
delimiter ;

call insertar_departamento ('Desarrollo','Departamento mas importante de todos');
call insertar_departamento ('Ventas','Marketing de la compañia');
call insertar_departamento ('Finanzas','Encargados de las Finanzas de la compañia');
call insertar_departamento ('Facturación Fija','Encargados de la linea fija');
call insertar_departamento ('Facturación Móvil','Encargadaos de la linea Movil');

/* Fin CRUD Departamento */

create table rol(
	id int primary key auto_increment,
    rol varchar(25) not null unique,
    descripcion varchar(100) not null default 'Sin descripcion'
);

/* CRUD Rol */

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
delimiter //
create procedure eliminar_rol(v_rol int)
begin
    DECLARE empl_dep INT;
    SET empl_dep = (SELECT COUNT(e.id) FROM empleado e WHERE e.idRol = v_rol);
    if(empl_dep = 0) then
        DELETE FROM rol WHERE id = v_rol;
        SELECT CONCAT ('Se elimino correctamente'); 
    else
        SELECT CONCAT ('Aun hay ' ,empl_dep, ' desempeñando este rol'); 
    end if;
end //
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
	select R.id, R.rol, R.descripcion  from rol R where R.rol LIKE concat('%',v_buscar,'%') OR R.descripcion LIKE      concat('%',v_buscar,'%');
end$$
delimiter ;

call insertar_rol ('Administrador','Con la capacidad de registrar y gestionar áreas departamentos de la empresa,jefes de áreas funcionales y jefes de desarrollo.');

call insertar_rol ('Jefe de Area','Con la capacidad de solicitar la apertura de casos y monitorear el porcentaje de progreso y bitácora de los casos aperturados.');

call insertar_rol ('Jefe de Desarrollo','Tiene la capacidad de aceptar o rechazar las solicitudes de casos realizadas por los jefes de las áreas funcionales que tiene a su cargo. Además, debe tener la capacidad de monitorear el trabajo de los programadores que tiene a su cargo.');

call insertar_rol ('Empleado','Pueden ser asignados como “probadores” de un caso, en tal situación deben monitorear el porcentaje de progreso y bitácoras de trabajo de dicho caso y aprobarlo o rechazarlo una vez que este haya sido entregado por el programador asignado.');

call insertar_rol ('Programador','Debe actualizar los porcentajes de progreso y bitácoras de trabajo de los casos a los que ha sido asignado.');

/* Fin CRUD Rol */


/*Empleado*/
CREATE TABLE empleado(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL check (nombre NOT LIKE '%[0-9]%'),
    apellidos VARCHAR(50) NOT NULL check (apellidos NOT LIKE '%[0-9]%'),
    email VARCHAR(50) NOT NULL unique check(email LIKE '%_@_%_.__%'),
    contrasenia VARCHAR(100) NOT NULL,
    idRol INT not null,
    idDepartamento INT,
    FOREIGN KEY (idRol) REFERENCES rol(id) on update cascade,
    FOREIGN KEY (idDepartamento) REFERENCES departamento(id) on update cascade
);

/* CRUD Empleado */

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
					(v_nombre,v_apellidos,v_email,SHA2(concat(lower(reverse(v_nombre)),503),256),v_rol,v_depto);
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
					(v_nombre,v_apellidos,v_email,SHA2(concat(lower(reverse(v_nombre)),503),256),v_rol,v_depto);
					set v_sdepto = (select nombre from departamento where id = v_depto);
					select concat('Insercion correcta de un nuevo miembro al departamento: ',v_sdepto);
				end if;
			else
				insert into empleado(nombre,apellidos,email,contrasenia,idRol,idDepartamento) values
				(v_nombre,v_apellidos,v_email,SHA2(concat(lower(reverse(v_nombre)),503),256),v_rol,v_depto);
				set v_sdepto = (select nombre from departamento where id = v_depto);
				select concat('Insercion correcta de un nuevo miembro al departamento: ',v_sdepto);
			end if;
		else
			select concat('El correo: ',v_email,', ya esta registrado');
		end if;
    END $$
delimiter ;

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
		SELECT e.id,e.nombre,e.apellidos,e.email,r.id,r.rol,d.id,d.Nombre 
        FROM empleado e INNER JOIN rol r ON e.idRol = r.id 
        INNER JOIN departamento d ON e.idDepartamento = d.id;
    end//
delimiter ;

delimiter $$
CREATE PROCEDURE Loguearse (Usuario VARCHAR(50),Contrasenia VARCHAR(50))
    BEGIN
        SELECT e.id,e.Nombre,r.rol,d.id,d.Nombre
        FROM empleado e
        INNER JOIN rol r
        ON e.idRol = r.id
        INNER JOIN departamento d
        ON e.idDepartamento = d.id
        WHERE e.Email = Usuario AND e.Contrasenia = SHA2(Contrasenia,256); 
    END $$
delimiter ;
							     
delimiter //
create procedure actualizar_contrasenia(idempleado INT,newcontrasenia VARCHAR(50))
begin
    UPDATE empleado SET contrasenia=SHA2(newcontrasenia,256) WHERE id = idempleado;
end //
delimiter ;

INSERT INTO empleado VALUES (null,'root','root','root',SHA2('root',256),1,1);

/* Fin CRUD Empleado */

/* Para diferenciar los estados y solo mostrar los estados de solicitudes para las opciones de solicitudes y de igual manera para los casos */
create table tipo_estado(
    id int primary key auto_increment,
    tipo_estado varchar(50) not null unique
);

insert into tipo_estado(tipo_estado) values ('Solicitud');
insert into tipo_estado(tipo_estado) values ('Caso');
insert into tipo_estado(tipo_estado) values ('Ambos');
insert into tipo_estado(tipo_estado) values ('Probador');

/* Estado */
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
insert into estado(estado,tipo) values ('Finalizado',3);

/* Los estados que se mostraran para los diferentes usuarios */

delimiter //
create procedure estados_programador()
	begin
		select E.id, E.estado from estado E join tipo_estado TE on E.tipo = TE.id where TE.id = 2 OR TE.id = 3 order by E.id;
	end//
delimiter ;

delimiter //
create procedure estados_probador()
	begin
		select E.id, E.estado from estado E join tipo_estado TE on E.tipo = TE.id where TE.id = 4 order by E.id;
	end//
delimiter ;

delimiter //
create procedure estados_solicitud()
	begin
		select E.id, E.estado from estado E join tipo_estado TE on E.tipo = TE.id where TE.id = 1 OR TE.id = 3 order by E.id;
	end//
delimiter ;

/* Solicitud */

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

/* CRUD Solicitudes */
/* Cancelar solicitudes */
delimiter //
create procedure cancelar_soli(v_soli INT)
begin
    DELETE FROM solicitud WHERE id = v_soli;
end //
delimiter ;

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
			SELECT CONCAT('Se inserto la Solicitud ',v_nombre);
        else 
			insert into solicitud(nombre, descripcion,idDepartamento) values (v_nombre,v_descripcion,v_depto);
			SELECT CONCAT('Se inserto la Solicitud ',v_nombre);
		end if;
	else
		select concat('ya existe una solicitud con el nombre: ',v_nombre,', en el departamento: ', sdepto);
	end if;
end//
delimiter ;

delimiter //
create procedure mostrar_solicitudes(v_idDepto int)
begin
       SELECT id,nombre,descripcion FROM solicitud WHERE idDepartamento = v_idDepto AND idEstado = 1 AND idEstado != 7;
end //
delimiter ;

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

delimiter //
create procedure eliminar_solicitud (v_id int)
begin
	delete from solicitud where id= v_id;
    if (row_count() > 0 ) then
			select 'Se elimino con exito';
		else
			select 'No se pudo eliminar';
		end if;
end //
delimiter ;
										 
/* Reporte Solicitudes */
delimiter //
create procedure reporte_todo()
	begin
	SELECT (SELECT COUNT(id) FROM solicitud) AS Totales, (SELECT COUNT(id) FROM solicitud WHERE idEstado = 9) AS Finalizados
	,(SELECT COUNT(id) FROM solicitud WHERE idEstado in (1,3,5,6)) AS Desarrollo, (SELECT COUNT(id) FROM solicitud WHERE idEstado = 2) AS Rechazados;
end //
delimiter ;
	
/* Reporte departamento */
delimiter //
create procedure reporte_dep(v_depid int)
	begin
	SELECT (SELECT COUNT(id) FROM solicitud WHERE idDepartamento = v_depid ) AS Totales, (SELECT COUNT(id) FROM solicitud WHERE idEstado = 9 && idDepartamento = v_depid ) AS Finalizados
    ,(SELECT COUNT(id) FROM solicitud WHERE idEstado in (1,3,5,6) && idDepartamento = v_depid ) AS Desarrollo, (SELECT COUNT(id) FROM solicitud WHERE idEstado = 2 && idDepartamento = v_depid ) AS Rechazados;
end //
delimiter ;
						     

/* Tabla Caso */

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

/*Encontrar programadores y empleados sin caso */

delimiter //
create procedure programadores_sin_caso(v_depto int)
begin
	select e.id, e.nombre from empleado e left join caso c on e.id = c.idEncargado where c.idEncargado is null and e.idRol = 5 and e.idDepartamento = v_depto;
end//
delimiter ;

delimiter //
create procedure empleados_sin_caso(v_depto int)
begin
	select e.id, e.nombre from empleado e left join caso c on e.id = c.idTester where c.idEncargado is null and e.idRol = 4 and e.idDepartamento = v_depto;
end//
delimiter ;

create table bitacora(
	id int primary key auto_increment,
    idCaso int unique not null,
    informacion varchar(1000) not null,
    porcentajeAvance int not null check(porcentajeAvance < 101 AND porcentajeAvance > 0),
    finalizado boolean,
    foreign key (idCaso) references caso(id)
);
alter table bitacora
add observaciones_tester varchar(200);

delimiter //
create procedure crear_caso(v_solicitud int, v_fecha date, v_programador int, v_tester int, v_descripcion varchar(1000))
begin
	declare count_soli int;
    declare scodigo varchar(9);
    declare sdepto varchar(4);
    declare sfecha date;
    
    declare snombre varchar(50);
    declare sdescripcion varchar(1000);
    declare ndepartamento int;
    select * from caso;
    set count_soli = (select count(*) from caso c inner join solicitud s on s.id = c.idSolicitud where c.idSolicitud = v_solicitud);
    if count_soli != 0 then
		select 'Esta solicitud ya pertenece a un caso';
	else
		set count_soli = (select count(*) from rechazo r inner join solicitud s on s.id = r.idSolicitud where r.idSolicitud = v_solicitud);
		if count_soli != 0 then
			select 'Esta solicitud ya fue rechazada';
		else
			update solicitud set idEstado = 3 where id = v_solicitud;
            if length(v_descripcion) = 0 then
				set sfecha = (select fecha from solicitud where id = v_solicitud limit 1);
                set snombre = (select nombre from solicitud where id = v_solicitud limit 1);
                set sdescripcion = (select descripcion from solicitud where id = v_solicitud limit 1);
                set ndepartamento = (select idDepartamento from solicitud where id = v_solicitud limit 1);
                set sdepto = (select substring(nombre,1,3) from departamento where id = ndepartamento limit 1);
				set scodigo = concat(sdepto,date_format(sfecha,'%y'), 100 + round(rand() * 899 ));
				insert into caso(idSolicitud,nombre,descripcion,idDepartamento,idEstado,codigo, fechaInicio,fechaFinal,idEncargado,idTester,descripcionElementos) 
                values
				(v_solicitud,snombre,sdescripcion,ndepartamento,3,scodigo,current_date(),v_fecha,v_programador,v_tester,'Sin descripcion de elementos clave');
                update solicitud set idEstado = 3 where id = v_solicitud;
                set sdepto = (select nombre from departamento where id = ndepartamento limit 1);
                select concat('Se ha añadio un nuevo caso para el departamento: ',sdepto);
            else
				set sfecha = (select fecha from solicitud where id = v_solicitud limit 1);
                set snombre = (select nombre from solicitud where id = v_solicitud limit 1);
                set sdescripcion = (select descripcion from solicitud where id = v_solicitud limit 1);
                set ndepartamento = (select idDepartamento from solicitud where id = v_solicitud limit 1);
                set sdepto = (select substring(nombre,1,3) from departamento where id = ndepartamento limit 1);
				set scodigo = concat(sdepto,date_format(sfecha,'%y'), 100 + round(rand() * 899 ));
				insert into caso(idSolicitud,nombre,descripcion,idDepartamento,idEstado,codigo, fechaInicio,fechaFinal,idEncargado,idTester,descripcionElementos) 
                values
				(v_solicitud,snombre,sdescripcion,ndepartamento,3,scodigo,current_date(),v_fecha,v_programador,v_tester,v_descripcion);
                update solicitud set idEstado = 3 where id = v_solicitud;
                set sdepto = (select nombre from departamento where id = ndepartamento limit 1);
                select concat('Se ha añadio un nuevo caso para el departamento: ',sdepto);
			end if;
        end if;
	end if;
end//
delimiter ;


delimiter //
create procedure crear_rechazo(v_solicitud int, v_motivo varchar(500))
begin
	declare sdepto varchar(50);
	declare count_soli int;
        declare ssoli varchar(50);
    set count_soli = (select count(*) from caso c inner join solicitud s on s.id = c.idSolicitud where c.idSolicitud = v_solicitud);
    if count_soli != 0 then
		select 'Esta solicitud ya pertenece a un caso';
	else
		set count_soli = (select count(*) from rechazo r inner join solicitud s on s.id = r.idSolicitud where r.idSolicitud = v_solicitud);
		if count_soli != 0 then
			select 'Esta solicitud ya fue rechazada';
		else
            if length(v_motivo) = 0 then
				set ssoli = (select nombre from solicitud where id = v_solicitud);
				select concat('Debe escribir el motivo para rechazar la solicitud: ',ssoli);
            else
				insert into rechazo(idSolicitud,motivo) 
                values
				(v_solicitud,v_motivo);
                update solicitud set idEstado = 2 where id = v_solicitud;
                set ssoli = (select nombre from solicitud where id = v_solicitud);
                set sdepto = (select d.nombre from departamento d inner join solicitud s on s.idDepartamento = d.id where s.id = v_solicitud);
                select concat('Se ha rechazado la solicitud; ',ssoli,', del departamento: ',sdepto);
			end if;
        end if;
	end if;
end //
delimiter ;
										    
delimiter //
create procedure mostrar_casos(idDepartamento int)
begin
    SELECT c.id,c.nombre,c.codigo,c.descripcion,c.fechaFinal,c.descripcionElementos,c.idEncargado,p.nombre,c.idTester,t.nombre,d.nombre
    FROM caso c 
    INNER JOIN empleado p
    ON c.idEncargado = p.id
    INNER JOIN empleado t
    ON c.idTester = t.id
    INNER JOIN departamento d
    ON c.idDepartamento = d.id
    WHERE c.idDepartamento = idDepartamento AND c.idEstado != 7;
end //
delimiter ;

delimiter //
create procedure actualizar_caso(idCaso INT,fechalimite DATE,idEncargado INT,idTester INT,Observaciones VARCHAR(1000))
begin
    UPDATE caso SET fechaFinal = fechalimite ,idEncargado = idEncargado,idTester = idTester,descripcionElementos = Observaciones WHERE id = idCaso;
end //
delimiter ;

select * from empleado;

delimiter //
create trigger crear_bitacora after insert on caso
for each row
begin
	insert into bitacora(idCaso,informacion,porcentajeAvance,finalizado) values (new.id,'Sin registro de avances',0,0);
end//
delimiter ;


delimiter //
create procedure ingresar_en_bitacora(v_id int, v_informacion varchar(1000), v_porcentaje int)
begin
	declare ncaso int;
	if length(v_informacion) = 0 then
		select 'La descripcion de avance no puede quedar vacia';
	else
		if v_porcentaje = 100 then
			update bitacora set informacion = v_informacion, porcentajeAvance = v_porcentaje, finalizado = 0 where id = v_id;
            set ncaso = (select idCaso from bitacora where id = v_id);
            update caso set idEstado = 5 where id = ncaso;
            select 'Bitacora actualizada con exito';
		else
			update bitacora set informacion = v_informacion, porcentajeAvance = v_porcentaje, finalizado = 0 where id = v_id;
            select 'Bitacora actualizada con exito';
		end if;
	end if;
end//
delimiter ;

delimiter //
create procedure finalizar_caso(v_id int)
begin
	declare nsoli int;
	update caso set idEstado = 7 where id = v_id;
    update bitacora set finalizado = 1 where idCaso = v_id;
    set nsoli = (select s.id from solicitud s join caso c on c.idSolicitud = s.id where c.id = v_id limit 1);
    update solicitud set idEstado = 7 where id = nsoli;
    select 'El caso ha sido aprobado';
end//
delimiter ;

delimiter //
create procedure agregar_observacion(v_id int, v_observacion varchar(200))
begin
	update bitacora set observaciones_tester = v_observacion, porcentajeAvance = 0 where idCaso = v_id;
    update caso set idEstado = 6 where id = v_id;
    select 'Se ha enviado las observaciones';
end//
delimiter ;

delimiter //
create procedure mostrar_al_tester(v_id int)
begin
	select c.id,c.nombre, c.descripcion from caso c where idTester = v_id;
end//
delimiter ;

delimiter //
create procedure mostrar_bitacoras(v_programador int)
begin
	select b.id, b.informacion, b.porcentajeAvance, c.nombre, b.observaciones_tester from bitacora b inner join caso c on b.idCaso = c.id
	where c.idEncargado = v_programador and c.idEstado != 7;
end//
delimiter ;