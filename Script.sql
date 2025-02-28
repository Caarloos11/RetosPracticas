drop database if exists GestionEventos;
create database GestionEventos;
use GestionEventos;

create table Usuario (
    id_usuario int auto_increment primary key,
    nombre varchar(50) not null,
    contraseña varchar(25) not null,
    correo varchar(50) not null unique
);

create table Organizador (
    id_organizador int auto_increment primary key,
    nombre varchar(50) not null,
    contacto varchar(50) not null
);

create table Ubicación (
    id_ubicacion int auto_increment primary key,
    tipo varchar(50) not null,
    direccion varchar(50) not null unique
);

create table Categoría (
    id_categoria int auto_increment primary key,
    nombre varchar(50) not null unique
);

create table Evento (
    id_evento int auto_increment primary key,
    nombre varchar(50) not null,
    fecha date not null,
	estado enum('Pendiente', 'En curso', 'Finalizado'),
    ubicacion int not null,
    foreign key (ubicacion) references Ubicación(id_ubicacion)
);

create table Inscripción (
    id_usuario int,
    id_evento int,
    primary key (id_usuario, id_evento),
    foreign key (id_usuario) references Usuario(id_usuario) on delete cascade,
    foreign key (id_evento) references Evento(id_evento) on delete cascade
);