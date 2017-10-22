INSERT INTO actor (name, first_name, birthday, death_date) VALUES
  ( 'Reno', 'Jean', '1948-07-30', NULL),
  ('Portman', 'Natalie', '1981-06-09', NULL),
  ('Dujardin', 'Jean', '1972-06-19', NULL),
  ('Bourvil', '', '1917-07-27', '1970-09-23'),
  ('De Funes', 'Louis', '1914-07-31', '1983-01-27'),
  ('Anglade', 'Jean-Hugues', '1955-07-29', NULL),
  ('Lambert', 'Christophe', '1957-03-29', NULL);

INSERT INTO category (code, name) VALUES
  ('AC', 'Action'),
  ('CO', 'Comédie'),
  ('PO', 'Policier'),
  ('WE', 'Western');

INSERT INTO director (name, first_name) VALUES
  ('Oury', 'Gérard'),
  ('Chabrol', 'Claude'),
  ('Besson', 'Luc'),
  ('Besnard', 'Eric');

INSERT INTO film (title, duration, release_date, budget, grossing, id_director, code_category) VALUES
  ('Léon', 110, '1994-04-14', 17531000, 69250000, 3, 'PO'),
  ('Cash', 100, '2008-04-23', 18340000, 60340000, 4, 'PO'),
  ('La grande vadrouille', 132, '1966-12-01', 7227000, 51258000, 2, 'AC'),
  ('Subway', 104, '1985-04-10', 10567000, 70500000, 3, 'PO');

INSERT INTO characters (id_film, id_actor, name) VALUES
  (1, 1, 'Léon'),
  (1, 2, 'Mathilda'),
  (2, 1, 'Maxime Dubreuil'),
  (2, 3, 'Cash'),
  (3, 4, 'Augustin Bouvet'),
  (3, 5, 'Stanislas Lefort'),
  (4, 1, 'Le Batteur'),
  (4, 6, 'Le Roller'),
  (4, 7, 'Fred');