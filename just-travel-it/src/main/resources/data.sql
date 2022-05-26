CREATE TABLE User (
  name VARCHAR(20)  PRIMARY KEY,
  password VARCHAR(40) NOT NULL,
  nif VARCHAR(9) NOT NULL,
  email VARCHAR(40) NOT NULL
);

CREATE TABLE Airport (
  id INTEGER PRIMARY KEY AUTO_INCREMENT ,
  city VARCHAR(20) NOT NULL,
  cod VARCHAR(20) NOT NULL,
  name VARCHAR(20) NOT NULL
);

CREATE TABLE Hotel (
  id INTEGER PRIMARY KEY AUTO_INCREMENT ,
  name VARCHAR(20) NOT NULL,
  stars INTEGER NOT NULL,
  city VARCHAR(20) NOT NULL,
  cod INTEGER UNIQUE
);

CREATE TABLE Flight (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  codigo VARCHAR(20) NOT NULL,
  aeropuertoSalida BIGINT NOT NULL,
  aeropuertoLlegada BIGINT NOT NULL,
  fechaSalida DATE NOT NULL,
  fechaLlegada DATE NOT NULL
  
);

INSERT INTO User (name, password, nif, email) VALUES
  ('Pikachu', '1234', '00000000A', 'a@gmail.com'),
  ('Bulbasaur', 'root', '11111111B', 'b@gmail.com'),
  ('Charizard', 'qwerty', '22222222C', 'c@gmail.com');



INSERT INTO Hotel (id, name, stars, city, cod) VALUES
  ('11111', 'Silver', '5','Plateada', '111'),
  ('11112', 'Blue', '4','Celeste', '112'),
  ('11113', 'Red', '5','Carmin', '113');


INSERT INTO Airport (id, city, cod, name) VALUES
  ('11111','Madrid', 'BAR', 'Barajas'),
	('11112','Barcelona', 'PRT', 'El Prat'),
	('11113','Londres','LON','Londres Airport'),
	('11114','Paris','FRP','France Port');


INSERT INTO Flight (id, codigo, aeropuertoSalida, aeropuertoLlegada, fechaSalida, fechaLlegada) VALUES
  ('11111', 'ML1', '11111', '11113', '2021-05-08', '2021-05-08'),
	('11112', 'BP1', '11112', '11114', '2021-05-08', '2021-05-08'),
  ('11113', 'ML2', '11111', '11113', '2021-05-08', '2021-05-08'),
  ('11114', 'LP1', '11113', '11112', '2021-05-08', '2021-05-08');
