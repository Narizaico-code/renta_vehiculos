drop database if exists renta_vehiculos_db;
create database renta_vehiculos_db;
use renta_vehiculos_db;

  create table Vehiculos(
	codigo_vehículos integer,
    modelo varchar(64),
    año int,
    precio_diario double,
    disponible enum('Disponible', 'No disponible'),
    constraint pk_vehiculos primary key (codigo_vehículos)
 );
 
  create table Clientes(
	 codigo_cliente integer auto_increment,
	 telefono varchar(18),
	 codigo_reserva integer,
	 constraint pk_clientes primary key (codigo_cliente)
);

  create table Reservas(
	 codigo_reserva integer,
	 fecha_inicio date,
	 fecha_fin date,
	 costo_total double,
	 codigo_cliente integer,
	 constraint pk_reservas primary key (codigo_reserva)
 );
 
 create table ReservasClientes(
	codigo_cliente integer,
    codigo_reserva integer,
    constraint pk_reservas_clientes primary key(codigo_cliente, codigo_reserva),
	constraint fk_clientes_reservas_reservas foreign key(codigo_reserva)
		references Reservas(codigo_reserva),
    constraint fk_clientes_reservas_clientes foreign key(codigo_cliente)
		references Clientes (codigo_cliente) on delete cascade
 );