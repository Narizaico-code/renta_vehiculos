drop database if exists renta_vehiculos_db;
create database renta_vehiculos_db;
use renta_vehiculos_db;

  create table Usuarios(
	 codigo_usuario integer auto_increment,
     correo varchar(128),
     contrasena varchar(128),
	 telefono varchar(18),
     tipo_usuario enum('cliente','admin') default 'cliente',
	 constraint pk_clientes primary key (codigo_usuario)
);

  create table Vehiculos(
	codigo_vehiculo integer,
    modelo varchar(64),
    año int,
    precio_diario double,
    disponible enum('Disponible', 'No disponible'),
    codigo_usuario integer, 
    constraint pk_vehiculos primary key (codigo_vehiculo),
    constraint fk_vehiculos_usuarios foreign key (codigo_usuario)
		references Usuarios(codigo_usuario) on delete cascade
 );
 

  create table Reservas(
	 codigo_reserva integer,
	 fecha_inicio date,
	 fecha_fin date,
	 costo_total double,
	 constraint pk_reservas primary key (codigo_reserva)
 );
 
 create table ReservasUsuarios(
	codigo_usuario integer,
    codigo_reserva integer,
    constraint pk_reservas_usuarios primary key(codigo_usuario, codigo_reserva),
	constraint fk_reservas_usuarios_reservas foreign key(codigo_reserva)
		references Reservas(codigo_reserva),
    constraint fk_reservas_usuarios_usuarios foreign key(codigo_usuario)
		references Usuarios (codigo_usuario) on delete cascade
 );
 