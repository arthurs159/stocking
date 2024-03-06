INSERT INTO PRODUCT (name, quantity, unit_price) VALUES ('KIT PC', '0', '100');
INSERT INTO PRODUCT (name, quantity, unit_price) VALUES ('TORTA DE MAÇÃ', '0', '200');

INSERT INTO RAW_MATERIAL (name, price, quantity, unit, product_id, created_At, expired_Date) VALUES ('Mouse', '20', '5', '4','1', now(), now());
INSERT INTO RAW_MATERIAL (name, price, quantity, unit, product_id, created_At, expired_Date) VALUES ('Teclado', '300', '3', '3', '1', now(), now());
INSERT INTO RAW_MATERIAL (name, price, quantity, unit, product_id, created_At, expired_Date) VALUES ('Processador', '900', '2','2', '1', now(), now());