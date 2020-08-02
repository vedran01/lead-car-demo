-- Car brands
INSERT INTO car_brand (version, name) VALUES(1, 'Mercedes-Benz');
INSERT INTO car_brand (version, name) VALUES(1, 'BMW');
INSERT INTO car_brand (version, name) VALUES(1, 'Audi');
INSERT INTO car_brand (version, name) VALUES(1, 'VW');

-- Car Models
INSERT INTO car_model(version, name) VALUES( 1, 'A Class');
INSERT INTO car_model(version, name) VALUES( 1, 'B Class');
INSERT INTO car_model(version, name) VALUES( 1, 'C Class');
INSERT INTO car_model(version, name) VALUES( 1, 'E Class');
INSERT INTO car_model(version, name) VALUES( 1, 'S Class');

INSERT INTO car_model(version, name) VALUES( 1, '1 Series');
INSERT INTO car_model(version, name) VALUES( 1, '2 Series');
INSERT INTO car_model(version, name) VALUES( 1, '3 Series');
INSERT INTO car_model(version, name) VALUES( 1, '5 Series');
INSERT INTO car_model(version, name) VALUES( 1, '7 Series');

INSERT INTO car_model(version, name) VALUES( 1, 'A1');
INSERT INTO car_model(version, name) VALUES( 1, 'A3');
INSERT INTO car_model(version, name) VALUES( 1, 'A4');
INSERT INTO car_model(version, name) VALUES( 1, 'A5');
INSERT INTO car_model(version, name) VALUES( 1, 'A6');
INSERT INTO car_model(version, name) VALUES( 1, 'A7');
INSERT INTO car_model(version, name) VALUES( 1, 'A8');

INSERT INTO car_model(version, name) VALUES( 1, 'Polo');
INSERT INTO car_model(version, name) VALUES( 1, 'Golf');
INSERT INTO car_model(version, name) VALUES( 1, 'Passat');
INSERT INTO car_model(version, name) VALUES( 1, 'Toareg');
INSERT INTO car_model(version, name) VALUES( 1, 'Tiguan');
INSERT INTO car_model(version, name) VALUES( 1, 'Arteon');

-- Body type (Tip Karoserije)
INSERT INTO car_body (version, type) VALUES( 1, 'limousine');
INSERT INTO car_body (version, type) VALUES( 1, 'coupe');
INSERT INTO car_body (version, type) VALUES( 1, 'caravan');
INSERT INTO car_body (version, type) VALUES( 1, 'hatchback');
INSERT INTO car_body (version, type) VALUES( 1, 'cabriolet');
INSERT INTO car_body (version, type) VALUES( 1, 'SUV');
INSERT INTO car_body (version, type) VALUES( 1, 'minivan');

-- Engine types
INSERT INTO car_engine (version, type) VALUES( 1, 'DIESEL');
INSERT INTO car_engine (version, type) VALUES( 1, 'PETROL');
INSERT INTO car_engine (version, type) VALUES( 1, 'HYBRID');
INSERT INTO car_engine (version, type) VALUES( 1, 'ELECTRIC');

-- Cars
INSERT INTO car (name, version, engine_cc, power, price, body_id, brand_id, engine_id, model_id)
	VALUES('A 180', 1, 2000 ,100, 43456.987,
		(select body_id from car_body where type = 'hatchback'),
        (select brand_id from car_brand where name = 'Mercedes-Benz'),
        (select engine_id  from car_engine where type = 'DIESEL'),
        (select model_id from car_model where name = 'A Class'));

INSERT INTO car ( name, version, engine_cc, power, price, body_id, brand_id, engine_id, model_id)
	VALUES( 'B200 CDI', 1, 2000 ,110, 43900.99,
		(select body_id from car_body where type = 'minivan'),
        (select brand_id from car_brand where name = 'Mercedes-Benz'),
        (select engine_id  from car_engine where type = 'DIESEL'),
        (select model_id from car_model where name = 'B Class'));

INSERT INTO car ( name, version, engine_cc, power, price, body_id, brand_id, engine_id, model_id)
	VALUES( 'C250', 1, 2500 ,200, 51999.99,
		(select body_id from car_body where type = 'coupe'),
        (select brand_id from car_brand where name = 'Mercedes-Benz'),
        (select engine_id  from car_engine where type = 'PETROL'),
        (select model_id from car_model where name = 'C Class'));

INSERT INTO car ( name, version, engine_cc, power, price, body_id, brand_id, engine_id, model_id)
	VALUES( 'E320 CDI', 1, 3000 ,210, 81599.99,
		(select body_id from car_body where type = 'limousine'),
        (select brand_id from car_brand where name = 'Mercedes-Benz'),
        (select engine_id  from car_engine where type = 'DIESEL'),
        (select model_id from car_model where name = 'E Class'));

INSERT INTO car ( name, version, engine_cc, power, price, body_id, brand_id, engine_id, model_id)
	VALUES( 'S500', 1, 5000 , 450 , 100456.987,
		(select body_id from car_body where type = 'limousine'),
        (select brand_id from car_brand where name = 'Mercedes-Benz'),
        (select engine_id  from car_engine where type = 'DIESEL'),
        (select model_id from car_model where name = 'S Class'));

INSERT INTO car ( name, version, engine_cc, power, price, body_id, brand_id, engine_id, model_id)
	VALUES( 'A3 2.0 TDI', 1, 2000 ,140, 43900.99,
		(select body_id from car_body where type = 'hatchback'),
        (select brand_id from car_brand where name = 'Audi'),
        (select engine_id  from car_engine where type = 'DIESEL'),
        (select model_id from car_model where name = 'A3'));

INSERT INTO car ( name, version, engine_cc, power, price, body_id, brand_id, engine_id, model_id)
	VALUES( 'A3 2.0 FSI', 1, 2000 ,160, 40900.99,
		(select body_id from car_body where type = 'hatchback'),
        (select brand_id from car_brand where name = 'Audi'),
        (select engine_id  from car_engine where type = 'PETROL'),
        (select model_id from car_model where name = 'A3'));

INSERT INTO car ( name, version, engine_cc, power, price, body_id, brand_id, engine_id, model_id)
	VALUES( 'A4 2.0 TDI', 1, 2000 ,160, 49900.99,
		(select body_id from car_body where type = 'caravan'),
        (select brand_id from car_brand where name = 'Audi'),
        (select engine_id  from car_engine where type = 'DIESEL'),
        (select model_id from car_model where name = 'A4'));

INSERT INTO car ( name, version, engine_cc, power, price, body_id, brand_id, engine_id, model_id)
	VALUES( 'A3 2.0 TSI', 1, 2000 ,180, 50900.99,
		(select body_id from car_body where type = 'limousine'),
        (select brand_id from car_brand where name = 'Audi'),
        (select engine_id  from car_engine where type = 'PETROL'),
        (select model_id from car_model where name = 'A3'));

INSERT INTO car ( name, version, engine_cc, power, price, body_id, brand_id, engine_id, model_id)
	VALUES( 'Audi A6 3.0 TDI', 1, 3000 , 450 , 100456.987,
		(select body_id from car_body where type = 'limousine'),
        (select brand_id from car_brand where name = 'Audi'),
        (select engine_id  from car_engine where type = 'DIESEL'),
        (select model_id from car_model where name = 'A6'));

INSERT INTO car ( name, version, engine_cc, power, price, body_id, brand_id, engine_id, model_id)
	VALUES( 'BMW 330d', 1, 3000 , 260 , 53299.99,
		(select body_id from car_body where type = 'limousine'),
        (select brand_id from car_brand where name = 'BMW'),
        (select engine_id  from car_engine where type = 'DIESEL'),
        (select model_id from car_model where name = '3 Series'));

INSERT INTO car ( name, version, engine_cc, power, price, body_id, brand_id, engine_id, model_id)
	VALUES( 'BMW 330i', 1, 3000 , 310 , 51339.99,
		(select body_id from car_body where type = 'limousine'),
        (select brand_id from car_brand where name = 'BMW'),
        (select engine_id  from car_engine where type = 'PETROL'),
        (select model_id from car_model where name = '3 Series'));

INSERT INTO car ( name, version, engine_cc, power, price, body_id, brand_id, engine_id, model_id)
	VALUES( 'BMW 530d', 1, 3000 , 280 , 100456.987,
		(select body_id from car_body where type = 'caravan'),
        (select brand_id from car_brand where name = 'BMW'),
        (select engine_id  from car_engine where type = 'DIESEL'),
        (select model_id from car_model where name = '5 Series'));


INSERT INTO car ( name, version, engine_cc, power, price, body_id, brand_id, engine_id, model_id)
	VALUES( 'BMW 740i', 1, 4000 , 450 , 120799.99,
		(select body_id from car_body where type = 'limousine'),
        (select brand_id from car_brand where name = 'BMW'),
        (select engine_id  from car_engine where type = 'PETROL'),
        (select model_id from car_model where name = '5 Series'));

INSERT INTO car ( name, version, engine_cc, power, price, body_id, brand_id, engine_id, model_id)
	VALUES( 'Polo 1.2 TDI', 1, 1200 , 70 , 21999.99,
		(select body_id from car_body where type = 'hatchback'),
        (select brand_id from car_brand where name = 'VW'),
        (select engine_id  from car_engine where type = 'DIESEL'),
        (select model_id from car_model where name = 'Polo'));

INSERT INTO car ( name, version, engine_cc, power, price, body_id, brand_id, engine_id, model_id)
	VALUES( 'Golf 1.6 TDI', 1, 1200 , 70 , 24999.99,
		(select body_id from car_body where type = 'hatchback'),
        (select brand_id from car_brand where name = 'VW'),
        (select engine_id  from car_engine where type = 'DIESEL'),
        (select model_id from car_model where name = 'Golf'));

INSERT INTO car ( name, version, engine_cc, power, price, body_id, brand_id, engine_id, model_id)
	VALUES( 'Passat 2.0 TDI', 1, 2000 , 140 , 28999.99,
		(select body_id from car_body where type = 'limousine'),
        (select brand_id from car_brand where name = 'VW'),
        (select engine_id  from car_engine where type = 'DIESEL'),
        (select model_id from car_model where name = 'Passat'));

INSERT INTO car ( name, version, engine_cc, power, price, body_id, brand_id, engine_id, model_id)
	VALUES( 'Golf 2.0 TSI', 1, 2000 ,200 , 23999.99,
		(select body_id from car_body where type = 'limousine'),
        (select brand_id from car_brand where name = 'VW'),
        (select engine_id  from car_engine where type = 'PETROL'),
        (select model_id from car_model where name = 'Golf'));