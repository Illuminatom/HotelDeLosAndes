SELECT 'cliente' AS tabla, COUNT(*) AS cantidad FROM cliente
UNION ALL
SELECT 'cliente_consume_producto' AS tabla, COUNT(*) AS cantidad FROM cliente_consume_producto
UNION ALL
SELECT 'consumo_servicio_cliente' AS tabla, COUNT(*) AS cantidad FROM consumo_servicio_cliente
UNION ALL
SELECT 'dotacion' AS tabla, COUNT(*) AS cantidad FROM dotacion
UNION ALL
SELECT 'equipos_sala' AS tabla, COUNT(*) AS cantidad FROM equipos_sala
UNION ALL
SELECT 'gimnasio' AS tabla, COUNT(*) AS cantidad FROM gimnasio
UNION ALL
SELECT 'habitacion' AS tabla, COUNT(*) AS cantidad FROM habitacion
UNION ALL
SELECT 'habitacion_plan' AS tabla, COUNT(*) AS cantidad FROM habitacion_plan
UNION ALL
SELECT 'hotel' AS tabla, COUNT(*) AS cantidad FROM hotel
UNION ALL
SELECT 'hotel_ofrece' AS tabla, COUNT(*) AS cantidad FROM hotel_ofrece
UNION ALL
SELECT 'lavanderia' AS tabla, COUNT(*) AS cantidad FROM lavanderia
UNION ALL
SELECT 'maquinas_gimnasio' AS tabla, COUNT(*) AS cantidad FROM maquinas_gimnasio
UNION ALL
SELECT 'piscina' AS tabla, COUNT(*) AS cantidad FROM piscina
UNION ALL
SELECT 'plan' AS tabla, COUNT(*) AS cantidad FROM plan
UNION ALL
SELECT 'plato' AS tabla, COUNT(*) AS cantidad FROM plato
UNION ALL
SELECT 'plato_restaurante_bar' AS tabla, COUNT(*) AS cantidad FROM platos_restaurante_bar
UNION ALL
SELECT 'prestamo' AS tabla, COUNT(*) AS cantidad FROM prestamo
UNION ALL
SELECT 'producto' AS tabla, COUNT(*) AS cantidad FROM producto
UNION ALL
SELECT 'producto_plan' AS tabla, COUNT(*) AS cantidad FROM producto_plan
UNION ALL
SELECT 'productos_tienda' AS tabla, COUNT(*) AS cantidad FROM productos_tienda
UNION ALL
SELECT 'reserva_hotel' AS tabla, COUNT(*) AS cantidad FROM reserva_hotel
UNION ALL
SELECT 'restaurante_bar' AS tabla, COUNT(*) AS cantidad FROM restaurante_bar
UNION ALL
SELECT 'sala' AS tabla, COUNT(*) AS cantidad FROM sala
UNION ALL
SELECT 'servicio_basico' AS tabla, COUNT(*) AS cantidad FROM servicio_basico
UNION ALL
SELECT 'servicio_plan' AS tabla, COUNT(*) AS cantidad FROM servicio_plan
UNION ALL
SELECT 'servicio_spa' AS tabla, COUNT(*) AS cantidad FROM servicio_spa
UNION ALL
SELECT 'servicios_spa' AS tabla, COUNT(*) AS cantidad FROM servicios_spa
UNION ALL
SELECT 'spa' AS tabla, COUNT(*) AS cantidad FROM spa
UNION ALL
SELECT 'tienda' AS tabla, COUNT(*) AS cantidad FROM tienda
UNION ALL
SELECT 'tipo_habitacion' AS tabla, COUNT(*) AS cantidad FROM tipo_habitacion
UNION ALL
SELECT 'tipo_usuario' AS tabla, COUNT(*) AS cantidad FROM tipo_usuario
UNION ALL
SELECT 'usuario' AS tabla, COUNT(*) AS cantidad FROM usuario;