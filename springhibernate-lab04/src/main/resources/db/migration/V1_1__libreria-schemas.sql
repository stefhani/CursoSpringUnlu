create table autor (
  id       bigint    not null,
  created_on  timestamp not null,
  modified_on timestamp not null,
  apellido    varchar(255),
  nombre      varchar(255),
  primary key (id)
);

create table libro (
  id_libro     bigint       not null,
  created_on  timestamp    not null,
  modified_on timestamp    not null,
  isbn        varchar(255) not null,
  titulo      varchar(255) not null,
  sinopsis    varchar(3000) not null,
  precio      varchar(255) not null,
  id_autor    bigint       not null,
  primary key (id_libro)
);
create table usuario (
  id   bigint  not null,
  created_on  timestamp not null,
  modified_on timestamp not null,
  dni  varchar(255) not null,
  apellido  varchar(255),
  nombre    varchar(255),
  telefono  varchar(255),
  email     varchar(255),
  password     varchar(255),
  primary key (id)
);
create table compra (
  id_compra   bigint not null,
  estado       integer not null,
  fechaP  timestamp not null,
  fechaL timestamp not null,
  tipoC   tinyint not null,
  cantidad     integer not null,
  monto_total double precision not null,
  id_usuario   bigint not null,
  primary key (id_compra)
);

create table compra_libro(
id_compra bigint not null,
id_libro bigint not null,
primary key (id_compra,id_libro)
);



alter table libro
  add constraint UK_unique_isbn unique (isbn);

alter table libro
  add constraint FK_autor foreign key (id_autor) references autor;

alter table compra
  add constraint FK_usuario foreign key (id_usuario) references usuario;

  alter table compra_libro
    add constraint FK_libro foreign key (id_libro) references libro;
  alter table compra_libro
    add constraint FK_compra foreign key (id_compra) references compra;

create sequence hibernate_sequence
  start with 10
  increment by 1;
