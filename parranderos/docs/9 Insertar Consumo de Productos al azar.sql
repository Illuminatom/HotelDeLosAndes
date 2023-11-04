INSERT INTO cliente_consume_producto (Reserva_Hotel_id, Producto_id, cantidad, fecha, costo, descripcion)
SELECT
    rh.id AS Reserva_Hotel_id,
    p.id AS Producto_id,
    TRUNC(DBMS_RANDOM.VALUE(1, 10)) AS cantidad,
    TO_DATE('2022-01-01', 'YYYY-MM-DD') + TRUNC(DBMS_RANDOM.VALUE(1, 365)) AS fecha,
    ROUND(DBMS_RANDOM.VALUE(10, 1000)) AS costo,
    CASE WHEN DBMS_RANDOM.VALUE < 0.5 THEN 'Sin descripción' ELSE 'Con descripción' END AS descripcion
FROM reserva_hotel rh, producto p
WHERE ROWNUM <= 100; -- Cambia este valor según la cantidad de registros que desees insertar
