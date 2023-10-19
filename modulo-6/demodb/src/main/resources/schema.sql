create table USUARIO(
  ID int not null AUTO_INCREMENT,
  NOMBRE varchar(100) not null,
  NUMERODOCUMENTO varchar(50) not null,
  ESTADO int,
  TIPO varchar(100) not null,
  PRIMARY KEY ( ID )
);


INSERT INTO USUARIO (NOMBRE,NUMERODOCUMENTO,ESTADO,TIPO) VALUES ('Carlos Belloda Saavedra','dni-43843823',1,'PREMIUM');
INSERT INTO USUARIO (NOMBRE,NUMERODOCUMENTO,ESTADO,TIPO) VALUES ('Rossmery Salvatierra','dni-40012355',1,'NORMAL');