
INSERT INTO "users" (full_name, email, password, role)  VALUES ('Pavel' , 'pavel@gg.com', '$2a$12$I.a7mceew6brNR8TcexLAuDUvLjqQ0SWSaUbbs5DJdxM6vW0CMm.6', 'ROLE_USER');
INSERT INTO "users" (full_name, email, password, role)  VALUES ('Alex' , 'alex@gg.com', '$2a$12$I.a7mceew6brNR8TcexLAuDUvLjqQ0SWSaUbbs5DJdxM6vW0CMm.6', 'ROLE_USER');
INSERT INTO "users" (full_name, email, password, role)  VALUES ('Tom' , 'tom@gg.com', '$2a$12$I.a7mceew6brNR8TcexLAuDUvLjqQ0SWSaUbbs5DJdxM6vW0CMm.6', 'ROLE_USER');
INSERT INTO "users" (full_name, email, password, role)  VALUES ('Jhon' , 'jhon@gg.com', '$2a$12$I.a7mceew6brNR8TcexLAuDUvLjqQ0SWSaUbbs5DJdxM6vW0CMm.6', 'ROLE_USER');
INSERT INTO "users" (full_name, email, password, role)  VALUES ('admin' , 'admin@gg.com', '$2a$12$I.a7mceew6brNR8TcexLAuDUvLjqQ0SWSaUbbs5DJdxM6vW0CMm.6', 'ROLE_ADMIN');

INSERT INTO "brand" (name) VALUES ('Audi');
INSERT INTO "brand" (name) VALUES ('Renault');
INSERT INTO "brand" (name) VALUES ('BMW');
INSERT INTO "brand" (name) VALUES ('Mersedes');
INSERT INTO "brand" (name) VALUES ('WV');
INSERT INTO "brand" (name) VALUES ('Citroen');
INSERT INTO "brand" (name) VALUES ('Peguet');

INSERT INTO "city" (name) VALUES ('Minsk');
INSERT INTO "city" (name) VALUES ('Brest');
INSERT INTO "city" (name) VALUES ('Vitebsk');
INSERT INTO "city" (name) VALUES ('Grodno');
INSERT INTO "city" (name) VALUES ('Gomel');

INSERT INTO "fuel" (type) VALUES ('Gasolin');
INSERT INTO "fuel" (type) VALUES ('Diesel');
INSERT INTO "fuel" (type) VALUES ('Electro');
INSERT INTO "fuel" (type) VALUES ('Hybrid');


INSERT INTO "gear_box" (type) VALUES ('Auto');
INSERT INTO "gear_box" (type) VALUES ('Auto 4x4');
INSERT INTO "gear_box" (type) VALUES ('Manual');
INSERT INTO "gear_box" (type) VALUES ('Manual 4x4');

INSERT INTO "model" (name) VALUES ('TT');
INSERT INTO "model" (name) VALUES ('Logan');
INSERT INTO "model" (name) VALUES ('740');
INSERT INTO "model" (name) VALUES ('Crafter');
INSERT INTO "model" (name) VALUES ('Berlingo');
INSERT INTO "model" (name) VALUES ('Partner');

INSERT INTO "car_offer" (seller_full_name, brand_name, model_name, gear_box_type, fuel_type, city_name, description, year, mileage, price, delete)
VALUES ('Pavel', 'Audi' , 'TT', 'Auto' , 'Gasolin', 'Minsk', 'super car' , '1999' , '1312312', '100000', 'false');
INSERT INTO "car_offer" (seller_full_name, brand_name, model_name, gear_box_type, fuel_type, city_name, description, year, mileage, price, delete)
VALUES ('Alex', 'Renault' , 'Logan', 'Manual' , 'Gasolin', 'Minsk', 'midle car' , '2005' , '1312312', '110000', 'false');
INSERT INTO "car_offer" (seller_full_name, brand_name, model_name, gear_box_type, fuel_type, city_name, description, year, mileage, price, delete)
VALUES ('Tom', 'BMW' , '740', 'Auto' , 'Diesel', 'Brest', 'bad car' , '1998' , '1312312', '111000', 'false');
INSERT INTO "car_offer" (seller_full_name, brand_name, model_name, gear_box_type, fuel_type, city_name, description, year, mileage, price, delete)
VALUES ('Pavel', 'Mersedes' , 'Crafter', 'Auto 4x4' , 'Diesel', 'Grodno', 'old car' , '1997' , '1312312', '111100', 'false');
INSERT INTO "car_offer" (seller_full_name, brand_name, model_name, gear_box_type, fuel_type, city_name, description, year, mileage, price, delete)
VALUES ('Tom', 'WV' , 'Crafter', 'Auto 4x4' , 'Electro', 'Grodno', 'trash car' , '1994' , '1312312', '1222020', 'false');
INSERT INTO "car_offer" (seller_full_name, brand_name, model_name, gear_box_type, fuel_type, city_name, description, year, mileage, price, delete)
VALUES ('Alex', 'Citroen' , 'Berlingo', 'Manual 4x4' , 'Electro', 'Gomel', 'uber car' , '1995' , '1312312', '330300', 'false');
INSERT INTO "car_offer" (seller_full_name, brand_name, model_name, gear_box_type, fuel_type, city_name, description, year, mileage, price, delete)
VALUES ('Jhon', 'Peguet' , 'Partner', 'Manual' , 'Hybrid', 'Gomel', 'not a car' , '1993' , '1312312', '400040', 'false');



