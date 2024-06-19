CREATE DATABASE Blockbuster;
USE Blockbuster;

CREATE TABLE Pelicula (
  id_peliculas INT UNSIGNED NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  genero_principal VARCHAR(45),
  descripcion VARCHAR(250),
  precio DOUBLE UNSIGNED NOT NULL,
  veces_alquilada INT UNSIGNED NOT NULL DEFAULT 0,
  esta_alquilada TINYINT UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (id_peliculas));

INSERT INTO Pelicula (id_peliculas, nombre, genero_principal, descripcion, precio, veces_alquilada, esta_alquilada)
	VALUES
	(1, 'Pulp Fiction', 'Drama', 'Violencia y humor negro se entrelazan en las vidas de varios personajes en Los Ángeles.', 15.00, 5, 0),
	(2, 'Forrest Gump', 'Drama', 'La vida de Forrest Gump, un hombre con un coeficiente intelectual bajo pero con una vida increíble.', 11.25, 4, 0),
	(3, 'Titanic', 'Romance', 'El trágico romance entre Jack y Rose en el fatídico viaje inaugural del Titanic.', 16.00, 5, 0),
	(4, 'El Quinto Elemento', 'Ciencia Ficción', 'Un taxista y una joven se embarcan en una misión para salvar el universo.', 12.00, 3, 1),
	(5, 'Matrix', 'Ciencia Ficción', 'Un hacker descubre que el mundo que conoce es una simulación controlada por máquinas.', 13.75, 3, 0),
	(6, 'El Show de Truman', 'Drama', 'La vida aparentemente perfecta de Truman Burbanck resulta ser un elaborado programa de televisión.', 12.75, 3, 0),
	(7, 'El Club de la Pelea', 'Drama', 'Un insomne y un vendedor de jabón crean un club secreto de pelea que se sale de control.', 14.50, 6, 1),
	(8, 'Misión Imposible', 'Acción', 'Ethan Hunt debe limpiar su nombre mientras evita que un grupo terrorista adquiera una bomba nuclear.', 14.75, 6, 1),
	(9, 'El Quinto Elemento', 'Ciencia Ficción', 'Un taxista y una joven se embarcan en una misión para salvar el universo.', 12.00, 5, 0),
	(10, 'Pulp Fiction', 'Drama', 'Violencia y humor negro se entrelazan en las vidas de varios personajes en Los Ángeles.', 15.00, 6, 0),
	(11, 'Forrest Gump', 'Drama', 'La vida de Forrest Gump, un hombre con un coeficiente intelectual bajo pero con una vida increíble.', 11.25, 5, 1),
	(12, 'Pulp Fiction', 'Drama', 'Violencia y humor negro se entrelazan en las vidas de varios personajes en Los Ángeles.', 15.00, 6, 0),
	(13, 'Matrix', 'Ciencia Ficción', 'Un hacker descubre que el mundo que conoce es una simulación controlada por máquinas.', 13.75, 5, 1),
	(14, 'El Club de la Pelea', 'Drama', 'Un insomne y un vendedor de jabón crean un club secreto de pelea que se sale de control.', 14.50, 4, 0),
	(15, 'Matrix', 'Ciencia Ficción', 'Un hacker descubre que el mundo que conoce es una simulación controlada por máquinas.', 13.75, 6, 1),
	(16, 'Misión Imposible', 'Acción', 'Ethan Hunt debe limpiar su nombre mientras evita que un grupo terrorista adquiera una bomba nuclear.', 14.75, 3, 0),
	(17, 'El Club de la Pelea', 'Drama', 'Un insomne y un vendedor de jabón crean un club secreto de pelea que se sale de control.', 14.50, 6, 1),
	(18, 'El Show de Truman', 'Drama', 'La vida aparentemente perfecta de Truman Burbank resulta ser un elaborado programa de televisión.', 12.75, 5, 1),
	(19, 'Pulp Fiction', 'Drama', 'Violencia y humor negro se entrelazan en las vidas de varios personajes en Los Ángeles.', 15.00, 4, 1),
	(20, 'El Show de Truman', 'Drama', 'La vida aparentemente perfecta de Truman Burbank resulta ser un elaborado programa de televisión.', 12.75, 4, 0),
	(21, 'Matrix', 'Ciencia Ficción', 'Un hacker descubre que el mundo que conoce es una simulación controlada por máquinas.', 13.75, 6, 1),
	(22, 'Titanic', 'Romance', 'El trágico romance entre Jack y Rose en el fatídico viaje inaugural del Titanic.', 16.00, 4, 1),
	(23, 'El Quinto Elemento', 'Ciencia Ficción', 'Un taxista y una joven se embarcan en una misión para salvar el universo.', 12.00, 4, 1),
	(24, 'Forrest Gump', 'Drama', 'La vida de Forrest Gump, un hombre con un coeficiente intelectual bajo pero con una vida increíble.', 11.25, 3, 0),
	(25, 'El Club de la Pelea', 'Drama', 'Un insomne y un vendedor de jabón crean un club secreto de pelea que se sale de control.', 14.50, 5, 1),
	(26, 'Pulp Fiction', 'Drama', 'Violencia y humor negro se entrelazan en las vidas de varios personajes en Los Ángeles.', 15.00, 6, 0),
	(27, 'Pulp Fiction', 'Drama', 'Violencia y humor negro se entrelazan en las vidas de varios personajes en Los Ángeles.', 15.00, 6, 0),
	(28, 'Misión Imposible', 'Acción', 'Ethan Hunt debe limpiar su nombre mientras evita que un grupo terrorista adquiera una bomba nuclear.', 14.75, 4, 0),
	(29, 'Pulp Fiction', 'Drama', 'Violencia y humor negro se entrelazan en las vidas de varios personajes en Los Ángeles.', 15.00, 6, 0),
	(30, 'Titanic', 'Romance', 'El trágico romance entre Jack y Rose en el fatídico viaje inaugural del Titanic.', 16.00, 3, 0),
	(31, 'Matrix', 'Ciencia Ficción', 'Un hacker descubre que el mundo que conoce es una simulación controlada por máquinas.', 13.75, 6, 1),
	(32, 'Matrix', 'Ciencia Ficción', 'Un hacker descubre que el mundo que conoce es una simulación controlada por máquinas.', 13.75, 6, 1);