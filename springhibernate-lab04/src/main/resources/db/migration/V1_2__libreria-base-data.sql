INSERT INTO AUTOR (id, apellido, nombre, created_on, modified_on)
VALUES (1, 'Cortázar', 'Julio', '2018-08-08 21:54:00', '2018-08-08 21:54:00'),
       (2, 'Borges', 'Jorge Luis', '2018-08-08 21:54:00', '2018-08-08 21:54:00'),
       (3, 'García Márquez', 'Gabriel', '2018-08-08 21:54:00', '2018-08-08 21:54:00'),
       (4, 'Vargas Llosa', 'Mario', '2018-08-08 21:54:00', '2018-08-08 21:54:00'),
       (5, 'Amado', 'Jorge', '2018-08-08 21:54:00', '2018-08-08 21:54:00'),
       (6, 'Viggetta', 'Martines', '2018-08-08 21:54:00', '2018-08-08 21:54:00'),
       (7, 'Fabbri', 'Alejandro', '2018-08-08 21:54:00', '2018-08-08 21:54:00'),
       (8, 'Stanley', 'Mandy', '2018-08-08 21:54:00', '2018-08-08 21:54:00');

INSERT INTO LIBRO (id_libro, titulo,sinopsis, isbn, precio, id_autor, created_on, modified_on)
VALUES (1, 'Rayuela','La historia se desarrolla en la ciudad de París, donde Horacio Oliveira vaga por los puentes de la ciudad en busca de su amante, una mujer uruguaya llamada Lucía. Su relación es apasionada pero sus caracteres son bien distintos: Lucía, más tarde conocida como La Maga, de temperamento pasional, está enamorada de Horacio, más analítico y frío, mientras que él parece no querer involucrarse emocionalmente con ella.','23471','790.00', 1, '2018-08-08 21:54:00', '2018-11-08 21:54:00'),
       (2, 'El Aleph','El Aleph es un libro icónico de Jorge Luis Borges, el gran autor argentino admirado por García Márquez, Vargas Llosa, John Banville, Michel Houellebecq y tantos otros escritores contemporáneos. Los cuentos que lo integran son un prodigio de puzles filosóficos, intrigas fantásticas o policiacas y personajes que se graban en la memoria, como Emma Zunz. «El inmortal» explora el efecto que la inmortalidad causaría en los hombres; «Los teólogos» es un sueño melancólico sobre la identidad personal; «La otra muerte», una fantasía sobre el tiempo.','21356','90.00', 2, '2018-08-08 21:54:00', '2018-11-08 21:54:00'),
       (3, 'Historias de cronopios y de famas','Postulación de una mirada poética capaz de enfrentar las miserias de la rutina y del sentido común, el escritor argentino toma aquí partido por la imaginación creadora y el humor corrosivo de los surrealistas.', '16434','90.00', 1,'2018-08-08 21:54:00', '2018-11-08 21:54:00'),
       (4, '100 años de soledad','Muchos años después, frente al pelotón de fusilamiento, el coronel Aureliano Buendía había de recordar aquella tarde remota en que su padre lo llevó a conocer el hielo. Macondo era entonces una aldea de veinte casas de barro y cañabrava construidas a la orilla de un río de aguas diáfanas que se precipitaban por un lecho de piedras pulidas, blancas y enormes como huevos prehistóricos. El mundo era tan reciente, que muchas cosas carecían de nombre, y para mencionarlas había que señalarlas con el dedo.','84755','190.00',  3, '2018-08-08 21:54:00', '2018-11-08 21:54:00'),
       (5, 'La guerra del fin del mundo','En circunstancias extremas como aquéllas, la consecución de la dignidad vital sólo podrá venir de la exaltación religiosa - el convencimiento fanático de la elección divina de los marginados del mundo- y del quebranto radical de las reglas que rigen el mundo de los poderosos.', '49233','192.00', 4,'2018-08-08 21:54:00', '2018-11-08 21:54:00'),
       (6, 'Doña Flor y sus dos maridos','Repentinamente viuda a los treinta años, Doña Flor, siempre desgarrada entre la voluntad y el instinto, se casa en segundas nupcias con Teodoro, el metódico y pudoroso farmacéutico de Bahía, con quien pretende estabilizar su vida.', '45036','182.00', 4, '2018-08-08 21:54:00', '2018-11-08 21:54:00'),
       (7, 'Wigetta y el mundo de trouman (ilustrado)','Historia sobre las aventuras de Wigetta .', '8899','340.00', 6, '2018-08-08 21:54:00', '2018-11-08 21:54:00'),
       (8, 'Clasicos pasado y presente de las grandes rivalidades ...','Historia de los clasicos en el futbol argentino.', '9089','992.00', 7, '2018-08-08 21:54:00', '2018-11-08 21:54:00'),
       (9, 'Dibuja copia colorea y corta (libros de actividades)','Libros de actividades para colorear y pintar.', '9765','659.90', 8, '2018-08-08 21:54:00', '2018-11-08 21:54:00'),
       (10, 'Pinta con los dedos ','Libros para pintar con los dedos y actividades.', '9766','1000', 8, '2018-08-08 21:54:00', '2018-11-08 21:54:00');

INSERT INTO USUARIO (id, dni, apellido, nombre, telefono, email, password,created_on, modified_on)
VALUES (1, '19019238', 'Snown','John','2838933443', 'snow.john@gmail.com','oracle123','2018-08-08 21:54:00', '2018-11-08 21:54:00'),
       (2, '93567890', 'Lopez','Lucas','2838933443',  'lopez.lucas@gmail.com','oracle123','2018-08-08 21:54:00', '2018-11-08 21:54:00'),
       (3, '97845769', 'Simpson','Lisa','2838933443', 'simpson.lisa@gmail.com','oracle123','2018-08-08 21:54:00', '2018-11-08 21:54:00'),
       (4, '18902384', 'Stuart','Little','2838933443',  'stuart.little@gmail.com','oracle123','2018-08-08 21:54:00', '2018-11-08 21:54:00'),
       (5, '93456283', 'Banderas','Antonio','2838933443', 'banderas.antonio@gmail.com','oracle123','2018-08-08 21:54:00', '2018-11-08 21:54:00'),
       (6, '19554123', 'Gimenez','Carlos','2838933443',  'gimenez.carlos@gmail.com','oracle123','2018-08-08 21:54:00', '2018-11-08 21:54:00');

INSERT INTO COMPRA (id_compra, estado, fechap, fechal, tipoc,cantidad,monto_total,id_usuario)
VALUES (10, 0, '2019-12-23 12:01:17.542914','2019-12-27 12:01:17.542914',0,1,'90.0',6),
      (11, 0, '2019-12-23 12:01:17.542914','2019-12-27 12:01:17.542914',0,2,'380.0',6),
      (12, 1, '2019-12-23 12:01:17.542914','2019-12-27 12:01:17.542914',0,1,'90.0',6),
      (13, 2, '2019-12-23 12:01:17.542914','2019-12-27 12:01:17.542914',0,1,'182.0',6);

INSERT INTO COMPRA_LIBRO(id_compra,id_libro)
VALUES (10,2),
        (11,4),
        (12,3),
        (13,6);
