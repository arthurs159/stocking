INSERT INTO PRODUCT (name, quantity) VALUES ('KIT PC', '0');
INSERT INTO PRODUCT (name, quantity) VALUES ('TORTA DE MAÇÃ', '0');

INSERT INTO RAW_MATERIAL (name, price, quantity, unit, product_id, created_At, expired_Date) VALUES ('Mouse', '20', '5', '4','1', now(), now());
INSERT INTO RAW_MATERIAL (name, price, quantity, unit, product_id, created_At, expired_Date) VALUES ('Teclado', '300', '3', '3', '1', now(), now());
INSERT INTO RAW_MATERIAL (name, price, quantity, unit, product_id, created_At, expired_Date) VALUES ('Processador', '900', '2','2', '1', now(), now());
INSERT INTO RAW_MATERIAL (name, price, quantity, unit, created_At, expired_Date) VALUES ('Placa mãe', '450', '1', '2', now(), now());
INSERT INTO RAW_MATERIAL (name, price, quantity, unit, created_At, expired_Date) VALUES ('Placa de vídeo', '1200', '4', '4', now(), now());


INSERT INTO PRODUCT_RAW_MATERIAL(product_id, raw_material_id, quantity) values (1, 1, 1);
INSERT INTO PRODUCT_RAW_MATERIAL(product_id, raw_material_id, quantity) values (1, 2, 1);
INSERT INTO PRODUCT_RAW_MATERIAL(product_id, raw_material_id, quantity) values (2, 4, 1);
INSERT INTO PRODUCT_RAW_MATERIAL(product_id, raw_material_id, quantity) values (2, 5, 2);