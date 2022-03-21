DROP TABLE IF EXISTS pokemons;

CREATE TABLE user (
  name VARCHAR(20)  PRIMARY KEY,
  password VARCHAR(40) NOT NULL
);

INSERT INTO user (name, password) VALUES
  ('Pikachu', '1234'),
  ('Bulbasaur', 'root'),
  ('Charizard', 'qwerty');
