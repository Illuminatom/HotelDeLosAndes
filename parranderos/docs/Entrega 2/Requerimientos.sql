--RFC1 Estas consultas dan la cantidad de dinero gastada en cada habitación para los consumos de servicios y de productos en el último año
SELECT habitacion.id, SUM(cliente_consume_producto.costo) as total FROM habitacion INNER JOIN reserva_hotel ON habitacion.id = reserva_hotel.habitacion_id INNER JOIN cliente_consume_producto ON reserva_hotel.id = cliente_consume_producto.Reserva_Hotel_id WHERE cliente_consume_producto.fecha >= SYSDATE - INTERVAL '1' YEAR GROUP BY habitacion.id;
SELECT habitacion.id, SUM(consumo_servicio_cliente.costo) as total FROM habitacion INNER JOIN reserva_hotel ON habitacion.id = reserva_hotel.habitacion_id INNER JOIN consumo_servicio_cliente ON reserva_hotel.id = consumo_servicio_cliente.Reserva_Hotel_id WHERE consumo_servicio_cliente.fecha >= SYSDATE - INTERVAL '1' YEAR GROUP BY habitacion.id;

--RFC2 Esta consulta da los servicios mas populares en un intervalo de tiempo dado por el usuario basado en la cantidad de veces que fueron consumidos
SELECT DISTINCT sb.* FROM (SELECT servicio_basico.* FROM consumo_servicio_cliente INNER JOIN servicio_basico ON servicio_basico.id = consumo_servicio_cliente.servicio_basico_id WHERE fecha >= :fecha_menor AND fecha <= :fecha_mayor ORDER BY fecha) sb WHERE ROWNUM <=20;

--RFC3 Esta consulta da la cantidad de días que cada habitación fue ocupada en el ultimo año desde la fecha actual, para sacar el índice de ocupación se divide cada cantidad entre 365 y se multiplica el resultado por 100 para sacar el porcentaje.
SELECT habitacion_id, SUM(TO_DATE(FECHA_SALIDA, 'DD-MON-RR') - TO_DATE(FECHA_ENTRADA, 'DD-MON-RR')) AS dias_ocupada FROM reserva_hotel WHERE FECHA_ENTRADA >= TRUNC(SYSDATE - 365) GROUP BY habitacion_id;

--RFC4 Esta consulta da los servicios filtrados por características que da el usuario, como su nombre, su capacidad máxima y mínima, su precio máximo y mínimo, su hora de apertura y de cierre, y su id o un intervalo de id’s
SELECT * FROM servicio_basico WHERE id >= :idMenor AND id <= :idMayor AND capacidad >= :capacidadPiso AND capacidad <= :capacidadTecho AND nombre LIKE '%' || :nombre || '%' AND costo >= :precioPiso AND costo <= :precioTecho AND TO_DATE(hora_apertura, 'HH24:MI') >= TO_DATE(:horaApertura, 'HH24:MI') AND TO_DATE(hora_cierre, 'HH24:MI') >= TO_DATE(:horaCierre, 'HH24:MI');

--RFC5 Estas sentencias dan el consumo de productos y servicios para un usuario dado en un intervalo de fechas 
SELECT SUM(Cliente_consume_producto.costo) as total FROM Cliente INNER JOIN reserva_hotel ON Cliente.documento = reserva_hotel.Cliente_id INNER JOIN Cliente_consume_producto ON reserva_hotel.id = Cliente_consume_producto.Reserva_Hotel_id WHERE Cliente.documento=:documento AND Cliente_consume_producto.fecha >= :fechaMenor AND Cliente_consume_producto.fecha <= :fechaMayor GROUP BY Cliente.documento;
SELECT SUM (consumo_servicio_Cliente.costo) as total FROM Cliente INNER JOIN reserva_hotel ON Cliente.documento = reserva_hotel.Cliente_id INNER JOIN consumo_servicio_Cliente ON reserva_hotel.id = consumo_servicio_Cliente.Reserva_Hotel_id WHERE Cliente.documento=:documento AND consumo_servicio_Cliente.fecha >= :fechaMenor AND consumo_servicio_Cliente.fecha <= :fechaMayor GROUP BY Cliente.documento;

--RF7
SELECT * FROM (SELECT SUM(TO_DATE(FECHA_SALIDA, 'DD-MON-RR') - TO_DATE(FECHA_ENTRADA, 'DD-MON-RR')) AS diasAlojado FROM reserva_hotel WHERE FECHA_ENTRADA >= TRUNC(SYSDATE - 365) GROUP BY reserva_hotel.cliente_id) WHERE diasAlojado >=14 ORDER BY diasAlojado;
SELECT cliente.documento , SUM(cliente_consume_producto.costo) as consumo FROM cliente INNER JOIN reserva_hotel ON reserva_hotel.cliente_id = cliente.documento INNER JOIN cliente_consume_producto ON cliente_consume_producto.reserva_hotel_id = reserva_hotel.id WHERE cliente_consume_producto.fecha >= SYSDATE INTERVAL '1' YEAR AND cliente.documento = :documento GROUP BY cliente.documento
SELECT cliente.docu me nto, SUM(consumo_servicio_cliente.costo) as consumo FROM cliente
INNER JOIN reserva_hotel ON reserva_hotel.cliente_id = cliente.documento INNER JOIN
consumo_servicio_cliente ON consumo_servicio_cliente.reserva_hotel_id = reserva_hotel.id
WHERE consumo_servicio_cliente.fecha >= SYSDATE INTERVAL '1' YEAR AND cliente.documento
= :documento GROUP BY cliente.documento