CREATE TABLE cliente (
    documento  NUMBER NOT NULL,
    metodo_pago VARCHAR2(30) NOT NULL
);

ALTER TABLE cliente ADD CONSTRAINT cliente_pk PRIMARY KEY ( documento );

CREATE TABLE cliente_consume_producto (
    reserva_hotel_id NUMBER NOT NULL,
    producto_id     NUMBER NOT NULL,
    cantidad        NUMBER NOT NULL,
    fecha           DATE NOT NULL,
    costo           NUMBER NOT NULL,
    descripcion     VARCHAR2(500)
);

ALTER TABLE cliente_consume_producto ADD CONSTRAINT clienteconsume_pk PRIMARY KEY ( producto_id,
                                                                                  reserva_hotel_id, fecha );

CREATE TABLE consumo_servicio_cliente (
    reserva_hotel_id   NUMBER NOT NULL,
    servicio_basico_id NUMBER NOT NULL,
    fecha             DATE NOT NULL,
    descripcion       VARCHAR2(500) NOT NULL,
    costo             NUMBER NOT NULL
);

ALTER TABLE consumo_servicio_cliente
    ADD CONSTRAINT consumo_servicio_cliente_pk PRIMARY KEY ( servicio_basico_id,
                                                           fecha,
                                                           reserva_hotel_id );

CREATE TABLE dotacion (
    tipo_habitacion_id NUMBER NOT NULL,
    producto_id       NUMBER NOT NULL
);

ALTER TABLE dotacion ADD CONSTRAINT dotacion_pk PRIMARY KEY ( tipo_habitacion_id,
                                                              producto_id );

CREATE TABLE equipos_sala (
    sala_id     NUMBER NOT NULL,
    producto_id NUMBER NOT NULL
);

ALTER TABLE equipos_sala ADD CONSTRAINT equipos_sala_pk PRIMARY KEY ( sala_id,
                                                                    producto_id );

CREATE TABLE gimnasio (
    id NUMBER NOT NULL
);

ALTER TABLE gimnasio ADD CONSTRAINT gimnasio_pk PRIMARY KEY ( id );

CREATE TABLE habitacion (
    id                NUMBER NOT NULL,
    disponible        VARCHAR2(3) NOT NULL CHECK (UPPER(disponible) IN ('SI', 'NO')),
    hotel_id          NUMBER NOT NULL,
    tipo_habitacion_id NUMBER NOT NULL
    );

ALTER TABLE habitacion ADD CONSTRAINT habitacion_pk PRIMARY KEY ( id );

CREATE TABLE habitacion_plan (
    tipo_habitacion_id NUMBER NOT NULL,
    plan_id           NUMBER NOT NULL
);

ALTER TABLE habitacion_plan ADD CONSTRAINT habitacion_plan_pk PRIMARY KEY ( tipo_habitacion_id,
                                                                          plan_id );

CREATE TABLE hotel (
    id           NUMBER NOT NULL,
    nombre       VARCHAR2(500) NOT NULL,
    num_estrellas NUMBER NOT NULL
);

ALTER TABLE hotel ADD CONSTRAINT hotel_pk PRIMARY KEY ( id );

CREATE TABLE hotel_ofrece (
    hotel_id          NUMBER NOT NULL,
    servicio_basico_id NUMBER NOT NULL
);

ALTER TABLE hotel_ofrece ADD CONSTRAINT hotel_ofrece_pk PRIMARY KEY ( hotel_id,
                                                                    servicio_basico_id );

CREATE TABLE lavanderia (
    id                 NUMBER NOT NULL,
    costo_por_prenda     NUMBER NOT NULL,
    costo_por_par_zapatos NUMBER NOT NULL
);

ALTER TABLE lavanderia ADD CONSTRAINT lavanderia_pk PRIMARY KEY ( id );

CREATE TABLE maquinas_gimnasio (
    gimnasio_id NUMBER NOT NULL,
    producto_id NUMBER NOT NULL
);

ALTER TABLE maquinas_gimnasio ADD CONSTRAINT maquinas_gimnasio_pk PRIMARY KEY ( gimnasio_id,
                                                                              producto_id );

CREATE TABLE piscina (
    id          NUMBER NOT NULL,
    profundidad NUMBER NOT NULL
);

ALTER TABLE piscina ADD CONSTRAINT piscina_pk PRIMARY KEY ( id );

CREATE TABLE plan (
    id                  NUMBER NOT NULL,
    nombre              VARCHAR2(500) NOT NULL,
    descuento_habitacion NUMBER NOT NULL
);

ALTER TABLE plan ADD CONSTRAINT plan_pk PRIMARY KEY ( id );

CREATE TABLE plato (
    id          NUMBER NOT NULL,
    descripcion VARCHAR2(500) NOT NULL
);

ALTER TABLE plato ADD CONSTRAINT plato_pk PRIMARY KEY ( id );

CREATE TABLE platos_restaurante_bar (
    restaurante_bar_id NUMBER NOT NULL,
    plato_id          NUMBER NOT NULL
);

ALTER TABLE platos_restaurante_bar ADD CONSTRAINT platos_restaurante_bar_pk PRIMARY KEY ( restaurante_bar_id,
                                                                                      plato_id );

CREATE TABLE prestamo (
    id          NUMBER NOT NULL,
    producto_id NUMBER NOT NULL
);

ALTER TABLE prestamo ADD CONSTRAINT prestamo_pk PRIMARY KEY ( id );

CREATE TABLE producto (
    id                 NUMBER NOT NULL,
    nombre             VARCHAR2(500) NOT NULL,
    precio             NUMBER NOT NULL,
    tipo_producto       VARCHAR2(500) NOT NULL,
    cantidad_disponible NUMBER
);

ALTER TABLE producto ADD CONSTRAINT producto_pk PRIMARY KEY ( id );

CREATE TABLE producto_plan (
    producto_id NUMBER NOT NULL,
    plan_id     NUMBER NOT NULL,
    cantidad    NUMBER NOT NULL,
    descripcion VARCHAR2(500) NOT NULL
);

ALTER TABLE producto_plan ADD CONSTRAINT producto_plan_pk PRIMARY KEY ( producto_id,
                                                                      plan_id );

CREATE TABLE productos_tienda (
    tienda_id   NUMBER NOT NULL,
    producto_id NUMBER NOT NULL
);

ALTER TABLE productos_tienda ADD CONSTRAINT productos_tienda_pk PRIMARY KEY ( tienda_id,
                                                                            producto_id );

CREATE TABLE reserva_hotel (
    id            NUMBER NOT NULL,
    fecha_entrada  DATE NOT NULL,
    fecha_salida   DATE NOT NULL,
    num_personas   NUMBER NOT NULL,
    habitacion_id NUMBER NOT NULL,
    cliente_id    NUMBER NOT NULL,
    plan_id       NUMBER,
    cobro_total    NUMBER NOT NULL
);

ALTER TABLE reserva_hotel ADD CONSTRAINT reserva_hotel_pk PRIMARY KEY ( id );

CREATE TABLE restaurante_bar (
    id     NUMBER NOT NULL,
    estilo VARCHAR2(300) NOT NULL
);

ALTER TABLE restaurante_bar ADD CONSTRAINT restaurante_bar_pk PRIMARY KEY ( id );

CREATE TABLE sala (
    id   NUMBER NOT NULL,
    tipo VARCHAR2(500) NOT NULL
);

ALTER TABLE sala ADD CONSTRAINT sala_pk PRIMARY KEY ( id );

CREATE TABLE servicio_basico (
    id           NUMBER NOT NULL,
    nombre       VARCHAR2(500) NOT NULL,
    capacidad    NUMBER NOT NULL,
    costo        NUMBER NOT NULL,
    hora_apertura TIMESTAMP(0) NOT NULL,
    hora_cierre   TIMESTAMP(0) NOT NULL
);

ALTER TABLE servicio_basico ADD CONSTRAINT servicio_basico_pk PRIMARY KEY ( id );

CREATE TABLE servicio_plan (
    plan_id           NUMBER NOT NULL,
    servicio_basico_id NUMBER NOT NULL,
    descuento         NUMBER NOT NULL
);

ALTER TABLE servicio_plan ADD CONSTRAINT servicio_plan_pk PRIMARY KEY ( plan_id,
                                                                      servicio_basico_id );

CREATE TABLE servicio_spa (
    id       NUMBER NOT NULL,
    duracion VARCHAR2(200) NOT NULL
);

ALTER TABLE servicio_spa ADD CONSTRAINT servicio_spa_pk PRIMARY KEY ( id );

CREATE TABLE servicios_spa (
    spa_id         NUMBER NOT NULL,
    servicio_spa_id NUMBER NOT NULL
);

ALTER TABLE servicios_spa ADD CONSTRAINT servicios_spa_pk PRIMARY KEY ( spa_id,
                                                                      servicio_spa_id );

CREATE TABLE spa (
    id NUMBER NOT NULL
);

ALTER TABLE spa ADD CONSTRAINT spa_pk PRIMARY KEY ( id );

CREATE TABLE tienda (
    id   NUMBER NOT NULL,
    tipo VARCHAR2(200) NOT NULL
);

ALTER TABLE tienda ADD CONSTRAINT tienda_pk PRIMARY KEY ( id );

CREATE TABLE tipo_habitacion (
    id          NUMBER NOT NULL,
    nombre      VARCHAR2(500) NOT NULL,
    capacidad   NUMBER NOT NULL,
    precio_noche NUMBER NOT NULL
);

ALTER TABLE tipo_habitacion ADD CONSTRAINT tipo_habitacion_pk PRIMARY KEY ( id );

CREATE TABLE tipo_usuario (
    id          NUMBER NOT NULL,
    nombre      VARCHAR2(500) NOT NULL,
    descripcion VARCHAR2(500) NOT NULL
);

ALTER TABLE tipo_usuario ADD CONSTRAINT tipo_usuario_pk PRIMARY KEY ( id );

CREATE TABLE usuario (
    documento         NUMBER NOT NULL,
    tipo_documento     VARCHAR2(500) NOT NULL,
    nombre            VARCHAR2(500) NOT NULL,
    correo_electronico VARCHAR2(300) NOT NULL,
    hotel_id          NUMBER NOT NULL,
    tipo_usuario_id    NUMBER NOT NULL
);

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( documento );

ALTER TABLE cliente
    ADD CONSTRAINT cliente_usuario_fk FOREIGN KEY ( documento )
        REFERENCES usuario ( documento );

ALTER TABLE cliente_consume_producto
    ADD CONSTRAINT clienteconsume_producto_fk FOREIGN KEY ( producto_id )
        REFERENCES producto ( id );

ALTER TABLE cliente_consume_producto
    ADD CONSTRAINT cliente_consume_producto_reserva_hotel_fk FOREIGN KEY ( reserva_hotel_id )
        REFERENCES reserva_hotel ( id );

ALTER TABLE consumo_servicio_cliente
    ADD CONSTRAINT consumo_servicio_cliente_reserva_hotel_fk FOREIGN KEY ( reserva_hotel_id )
        REFERENCES reserva_hotel ( id );

ALTER TABLE consumo_servicio_cliente
    ADD CONSTRAINT consumo_servicio_cliente_servicio_basico_fk FOREIGN KEY ( servicio_basico_id )
        REFERENCES servicio_basico ( id );

ALTER TABLE dotacion
    ADD CONSTRAINT dotacion_producto_fk FOREIGN KEY ( producto_id )
        REFERENCES producto ( id );

ALTER TABLE dotacion
    ADD CONSTRAINT dotacion_tipo_habitacion_fk FOREIGN KEY ( tipo_habitacion_id )
        REFERENCES tipo_habitacion ( id );

ALTER TABLE equipos_sala
    ADD CONSTRAINT equipos_sala_producto_fk FOREIGN KEY ( producto_id )
        REFERENCES producto ( id );

ALTER TABLE equipos_sala
    ADD CONSTRAINT equipos_sala_sala_fk FOREIGN KEY ( sala_id )
        REFERENCES sala ( id );

ALTER TABLE gimnasio
    ADD CONSTRAINT gimnasio_servicio_basico_fk FOREIGN KEY ( id )
        REFERENCES servicio_basico ( id );

ALTER TABLE habitacion
    ADD CONSTRAINT habitacion_hotel_fk FOREIGN KEY ( hotel_id )
        REFERENCES hotel ( id );

ALTER TABLE habitacion
    ADD CONSTRAINT habitacion_tipo_habitacion_fk FOREIGN KEY ( tipo_habitacion_id )
        REFERENCES tipo_habitacion ( id );

ALTER TABLE habitacion_plan
    ADD CONSTRAINT habitacion_plan_plan_fk FOREIGN KEY ( plan_id )
        REFERENCES plan ( id );

ALTER TABLE habitacion_plan
    ADD CONSTRAINT habitacion_plan_tipo_habitacion_fk FOREIGN KEY ( tipo_habitacion_id )
        REFERENCES tipo_habitacion ( id );

ALTER TABLE hotel_ofrece
    ADD CONSTRAINT hotel_ofrece_hotel_fk FOREIGN KEY ( hotel_id )
        REFERENCES hotel ( id );

ALTER TABLE hotel_ofrece
    ADD CONSTRAINT hotel_ofrece_servicio_basico_fk FOREIGN KEY ( servicio_basico_id )
        REFERENCES servicio_basico ( id );

ALTER TABLE lavanderia
    ADD CONSTRAINT lavanderia_servicio_basico_fk FOREIGN KEY ( id )
        REFERENCES servicio_basico ( id );

ALTER TABLE maquinas_gimnasio
    ADD CONSTRAINT maquinas_gimnasio_gimnasio_fk FOREIGN KEY ( gimnasio_id )
        REFERENCES gimnasio ( id );

ALTER TABLE maquinas_gimnasio
    ADD CONSTRAINT maquinas_gimnasio_producto_fk FOREIGN KEY ( producto_id )
        REFERENCES producto ( id );

ALTER TABLE piscina
    ADD CONSTRAINT piscina_servicio_basico_fk FOREIGN KEY ( id )
        REFERENCES servicio_basico ( id );

ALTER TABLE plato
    ADD CONSTRAINT plato_producto_fk FOREIGN KEY ( id )
        REFERENCES producto ( id );

ALTER TABLE platos_restaurante_bar
    ADD CONSTRAINT platos_restaurante_bar_plato_fk FOREIGN KEY ( plato_id )
        REFERENCES plato ( id );

ALTER TABLE platos_restaurante_bar
    ADD CONSTRAINT platos_restaurante_bar_restaurante_bar_fk FOREIGN KEY ( restaurante_bar_id )
        REFERENCES restaurante_bar ( id );

ALTER TABLE prestamo
    ADD CONSTRAINT prestamo_producto_fk FOREIGN KEY ( producto_id )
        REFERENCES producto ( id );

ALTER TABLE prestamo
    ADD CONSTRAINT prestamo_servicio_basico_fk FOREIGN KEY ( id )
        REFERENCES servicio_basico ( id );

ALTER TABLE producto_plan
    ADD CONSTRAINT producto_plan_plan_id_fk FOREIGN KEY ( plan_id )
        REFERENCES plan ( id );

ALTER TABLE producto_plan
    ADD CONSTRAINT producto_plan_producto_id_fk FOREIGN KEY ( producto_id )
        REFERENCES producto ( id );

ALTER TABLE productos_tienda
    ADD CONSTRAINT productos_tienda_producto_fk FOREIGN KEY ( producto_id )
        REFERENCES producto ( id );

ALTER TABLE productos_tienda
    ADD CONSTRAINT productos_tienda_tienda_fk FOREIGN KEY ( tienda_id )
        REFERENCES tienda ( id );

ALTER TABLE reserva_hotel
    ADD CONSTRAINT reserva_hotel_cliente_fk FOREIGN KEY ( cliente_id )
        REFERENCES cliente ( documento );

ALTER TABLE reserva_hotel
    ADD CONSTRAINT reserva_hotel_habitacion_fk FOREIGN KEY ( habitacion_id )
        REFERENCES habitacion ( id );

ALTER TABLE reserva_hotel
    ADD CONSTRAINT reserva_hotel_plan_fk FOREIGN KEY ( plan_id )
        REFERENCES plan ( id );

ALTER TABLE restaurante_bar
    ADD CONSTRAINT restaurante_bar_servicio_basico_fk FOREIGN KEY ( id )
        REFERENCES servicio_basico ( id );

ALTER TABLE sala
    ADD CONSTRAINT sala_servicio_basico_fk FOREIGN KEY ( id )
        REFERENCES servicio_basico ( id );

ALTER TABLE servicio_plan
    ADD CONSTRAINT servicio_plan_plan_fk FOREIGN KEY ( plan_id )
        REFERENCES plan ( id );

ALTER TABLE servicio_plan
    ADD CONSTRAINT servicio_plan_servicio_basico_fk FOREIGN KEY ( servicio_basico_id )
        REFERENCES servicio_basico ( id );

ALTER TABLE servicio_spa
    ADD CONSTRAINT servicio_spa_producto_fk FOREIGN KEY ( id )
        REFERENCES producto ( id );

ALTER TABLE servicios_spa
    ADD CONSTRAINT servicios_spa_servicio_spa_fk FOREIGN KEY ( servicio_spa_id )
        REFERENCES servicio_spa ( id );

ALTER TABLE servicios_spa
    ADD CONSTRAINT servicios_spa_spa_fk FOREIGN KEY ( spa_id )
        REFERENCES spa ( id );

ALTER TABLE spa
    ADD CONSTRAINT spa_servicio_basico_fk FOREIGN KEY ( id )
        REFERENCES servicio_basico ( id );

ALTER TABLE tienda
    ADD CONSTRAINT tienda_servicio_basico_fk FOREIGN KEY ( id )
        REFERENCES servicio_basico ( id );

ALTER TABLE usuario
    ADD CONSTRAINT usuario_hotel_fk FOREIGN KEY ( hotel_id )
        REFERENCES hotel ( id );

ALTER TABLE usuario
    ADD CONSTRAINT usuario_tipo_usuario_fk FOREIGN KEY ( tipo_usuario_id )
        REFERENCES tipo_usuario ( id );