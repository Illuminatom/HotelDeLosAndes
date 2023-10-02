INSERT INTO Servicio_Basico (id,nombre, capacidad) VALUES (1,'Piscina al aire libre', 100);

INSERT INTO Servicio_Basico (id,nombre, capacidad) VALUES (2,'Piscina cubierta', 50);

INSERT INTO Servicio_Basico (id,nombre, capacidad) VALUES (3,'Gimnasio con entrenador personal', 30);

INSERT INTO Servicio_Basico (id,nombre, capacidad) VALUES (4,'Gimnasio basico', 50);

INSERT INTO Servicio_Basico (id,nombre, capacidad) VALUES (5,'Bar de cocteles', 40);

INSERT INTO Servicio_Basico (id,nombre, capacidad) VALUES (6,'Bar deportivo', 60);

INSERT INTO Servicio_Basico (id,nombre, capacidad) VALUES (7,'Restaurante gourmet', 50);

INSERT INTO Servicio_Basico (id,nombre, capacidad) VALUES (8,'Restaurante buffet', 80);

INSERT INTO Servicio_Basico (id,nombre, capacidad) VALUES (9,'Tienda de souvenirs', 20);

INSERT INTO Servicio_Basico (id,nombre, capacidad) VALUES (10,'Tienda de ropa', 30);

INSERT INTO Servicio_Basico (id,nombre, capacidad) VALUES (11,'SPA con tratamientos de lujo', 10);

INSERT INTO Servicio_Basico (id,nombre, capacidad) VALUES (12,'SPA relajante', 15);

INSERT INTO Servicio_Basico (id,nombre, capacidad) VALUES (13,'Servicio de lavanderia rapido', 40);

INSERT INTO Servicio_Basico (id,nombre, capacidad) VALUES (14,'Lavanderia de autoservicio', 60);

INSERT INTO Servicio_Basico (id,nombre, capacidad) VALUES (15,'Prestamo de libros', 25);

INSERT INTO Servicio_Basico (id,nombre, capacidad) VALUES (16,'Prestamo de bicicletas', 20);

INSERT INTO Servicio_Basico (id, nombre, capacidad) VALUES (17,'Sala de conferencias grande', 300);

INSERT INTO Servicio_Basico (id, nombre, capacidad) VALUES (18,'Sala de reuniones pequenia', 30);

--Insertar Restaurantes
INSERT INTO Restaurante_Bar (id, estilo) VALUES (7, 'Restaurante con Bar al aire libre');

INSERT INTO Restaurante_Bar (id, estilo) VALUES (8, 'Restaurante Bar de lujo');

--Insertar Bares
INSERT INTO restaurante_bar (id, estilo) VALUES (5, 'Dark');

INSERT INTO restaurante_bar (id, estilo) VALUES (6, 'Moderno');


--Insertar Salas
INSERT INTO sala (id, tipo, costo) VALUES (17, 'Tipo de Sala 1', 100);

INSERT INTO sala (id, tipo, costo) VALUES (18, 'Tipo de Sala 2', 120);

--Insertar Gimnasios
INSERT INTO gimnasio (id, costo) VALUES (3, 50);

INSERT INTO gimnasio (id, costo) VALUES (4, 60);

--Insertar Lavanderias  
INSERT INTO lavanderia (id, costo_por_prenda, costo_por_par_zapatos) VALUES (13, 1500, 1000);

INSERT INTO lavanderia (id, costo_por_prenda, costo_por_par_zapatos) VALUES (14, 1200, 800);

--Insertar piscinas
INSERT INTO piscina (id, profundidad, costo) VALUES (1, 150, 10);

INSERT INTO piscina (id, profundidad, costo) VALUES (2, 200, 15);

--Insertar Tiendas
INSERT INTO tienda (id, tipo) VALUES (9, 'Recuerdos');

INSERT INTO tienda (id, tipo) VALUES (10, 'Boutique');

--Insertar SPA's
INSERT INTO spa (id) VALUES (11);

INSERT INTO spa (id) VALUES (12);

--Insertar Platos restaurante
INSERT INTO producto (id, nombre, precio, tipo_Producto) 
VALUES (1, 'Filete de Salmon a la Parrilla', 20, 'Plato Principal');

INSERT INTO producto (id, nombre, precio, tipo_Producto) 
VALUES (2, 'Ensalada Caesar', 10, 'Entrada');

INSERT INTO producto (id, nombre, precio, tipo_Producto) 
VALUES (3, 'Spaghetti Bolognese', 15, 'Plato Principal');

INSERT INTO producto (id, nombre, precio, tipo_Producto) 
VALUES (4, 'Tarta de Chocolate', 8, 'Postre');

INSERT INTO producto (id, nombre, precio, tipo_Producto) 
VALUES (5, 'Sopa de Tomate', 7, 'Entrada');

INSERT INTO producto (id, nombre, precio, tipo_Producto) 
VALUES (6, 'Tacos de Camarones', 18, 'Plato Principal');

--Insertar platos
INSERT INTO plato (id, descripcion) 
VALUES (1, 'Delicioso filete de salmon a la parrilla con acompanamiento de verduras asadas.');

INSERT INTO plato (id, descripcion) 
VALUES (2, 'Ensalada fresca con aderezo Caesar y crutones de ajo.');

INSERT INTO plato (id, descripcion) 
VALUES (3, 'Spaghetti con salsa Bolognese de carne molida y tomate.');

INSERT INTO plato (id, descripcion) 
VALUES (4, 'Tarta de chocolate indulgente con cobertura de ganache.');

INSERT INTO plato (id, descripcion) 
VALUES (5, 'Sopa de tomate casera con albahaca y crutones.');

INSERT INTO plato (id, descripcion) 
VALUES (6, 'Tacos de camarones con salsa de aguacate y col rallada.');

--Insertar platos en la carta
INSERT INTO platos_restaurante_bar (plato_id, restaurante_bar_id) VALUES (1, 7);

INSERT INTO platos_restaurante_bar (plato_id, restaurante_bar_id) VALUES (2, 7);

INSERT INTO platos_restaurante_bar (plato_id, restaurante_bar_id) VALUES (3, 7);

INSERT INTO platos_restaurante_bar (plato_id, restaurante_bar_id) VALUES (4, 8);

INSERT INTO platos_restaurante_bar (plato_id, restaurante_bar_id) VALUES (5, 8);

INSERT INTO platos_restaurante_bar (plato_id, restaurante_bar_id) VALUES (6, 8);

--Insertar Bebidas bares
INSERT INTO producto (id, nombre, precio, tipo_Producto) 
VALUES (7, 'Cerveza', 5, 'Bebida');

INSERT INTO producto (id, nombre, precio, tipo_Producto)
VALUES (8, 'Vino Tinto', 12, 'Bebida');

INSERT INTO producto (id, nombre, precio, tipo_Producto) 
VALUES (9, 'Cóctel Margarita', 8, 'Bebida');

INSERT INTO producto (id, nombre, precio, tipo_Producto) 
VALUES (10, 'Refresco de Naranja', 3, 'Bebida');

INSERT INTO producto (id, nombre, precio, tipo_Producto) 
VALUES (11, 'Whisky Escoces', 15, 'Bebida');

INSERT INTO producto (id, nombre, precio, tipo_Producto) 
VALUES (12, 'Cafe', 2, 'Bebida');

--Insertar bebidas en platos
INSERT INTO plato (id, descripcion)
VALUES (7, 'Cerveza');

INSERT INTO plato (id, descripcion)
VALUES (8, 'Vino Tinto');

INSERT INTO plato (id, descripcion)
VALUES (9, 'Cóctel Margarita');

INSERT INTO plato (id, descripcion)
VALUES (10, 'Refresco de Naranja');

INSERT INTO plato (id, descripcion)
VALUES (11, 'Whisky Escocés');

INSERT INTO plato (id, descripcion)
VALUES (12, 'Café');

--Insertar bebidas en la carta de los bares
INSERT INTO platos_restaurante_bar (plato_id, restaurante_bar_id) VALUES (7, 5);

INSERT INTO platos_restaurante_bar (plato_id, restaurante_bar_id) VALUES (8, 5);

INSERT INTO platos_restaurante_bar (plato_id, restaurante_bar_id) VALUES (9, 5);

INSERT INTO platos_restaurante_bar (plato_id, restaurante_bar_id) VALUES (10, 6);

INSERT INTO platos_restaurante_bar (plato_id, restaurante_bar_id) VALUES (11, 6);

INSERT INTO platos_restaurante_bar (plato_id, restaurante_bar_id) VALUES (12, 6);

