INSERT INTO reserva_hotel (id, fecha_entrada, fecha_salida, num_personas, Habitacion_id, Cliente_id, plan_id, cobro_total)
SELECT
    ROWNUM,
    TO_DATE('2022-01-01', 'YYYY-MM-DD') + TRUNC(DBMS_RANDOM.VALUE(1, 365)) AS fecha_entrada,
    TO_DATE('2022-01-01', 'YYYY-MM-DD') + TRUNC(DBMS_RANDOM.VALUE(1, 365)) AS fecha_salida,
    TRUNC(DBMS_RANDOM.VALUE(1, 5)) AS num_personas,
    TRUNC(DBMS_RANDOM.VALUE(1, 5)) AS Habitacion_id,
    CASE WHEN ROWNUM <= 5 THEN 12345
         WHEN ROWNUM <= 10 THEN 23456
         WHEN ROWNUM <= 15 THEN 34567
         WHEN ROWNUM <= 20 THEN 45678
         ELSE 56789
    END AS Cliente_id,
    NULL AS plan_id,
    ROUND(DBMS_RANDOM.VALUE(100, 500), 2) AS cobro_total
FROM DUAL
WHERE TO_DATE('2022-01-01', 'YYYY-MM-DD') + TRUNC(DBMS_RANDOM.VALUE(1, 365)) < TO_DATE('2022-01-01', 'YYYY-MM-DD') + TRUNC(DBMS_RANDOM.VALUE(1, 365))
CONNECT BY ROWNUM <= 20; -- Cambia este valor según la cantidad de registros que desees insertar