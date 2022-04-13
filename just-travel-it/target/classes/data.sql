DROP TABLE IF EXISTS pokemons;

CREATE TABLE user (
  name VARCHAR(20)  PRIMARY KEY,
  password VARCHAR(40) NOT NULL
);

CREATE TABLE Airport (
  id INTEGER PRIMARY KEY,
  city VARCHAR(20) NOT NULL,
  cod VARCHAR(20) NOT NULL,
  name VARCHAR(20) NOT NULL
);

CREATE TABLE Hotel (
  id INTEGER PRIMARY KEY,
  name VARCHAR(20) NOT NULL,
  stars INTEGER NOT NULL,
  city VARCHAR(20) NOT NULL
);

INSERT INTO user (name, password) VALUES
  ('Pikachu', '1234'),
  ('Bulbasaur', 'root'),
  ('Charizard', 'qwerty');

INSERT INTO Airport (id, city, cod, name) VALUES
  ('1', 'Plateada', '9342','brock'),
  ('2', 'Celeste', '5279','misty'),
  ('3', 'Carmin', '7690','Lt.Surge');

INSERT INTO Hotel (id, name, stars, city) VALUES
  ('1', 'Silver', '5','Plateada'),
  ('2', 'Blue', '4','Celeste'),
  ('3', 'Red', '5','Carmin');

