INSERT INTO reserva_hotel (id, fecha_entrada, fecha_salida, num_personas, Habitacion_id, Cliente_id, plan_id, cobro_total)
SELECT
    ROWNUM,
    TO_DATE('2022-01-01', 'YYYY-MM-DD') + TRUNC(DBMS_RANDOM.VALUE(1, 365)) AS fecha_entrada,
    TO_DATE('2022-01-01', 'YYYY-MM-DD') + TRUNC(DBMS_RANDOM.VALUE(1, 365)) + 1 AS fecha_salida,
    TRUNC(DBMS_RANDOM.VALUE(1, 5)) AS num_personas,
    TRUNC(DBMS_RANDOM.VALUE(1, 5)) AS Habitacion_id,
    c.documento AS Cliente_id,
    NULL AS plan_id,
    ROUND(DBMS_RANDOM.VALUE(100, 500), 2) AS cobro_total
FROM cliente c
CONNECT BY ROWNUM <= 20000;
