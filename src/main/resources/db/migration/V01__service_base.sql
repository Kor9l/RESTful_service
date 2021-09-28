CREATE TYPE "role" AS ENUM (
  'ROLE_USER',
  'ROLE_ADMIN'
);

CREATE TABLE "user" (
  "id" SERIAL PRIMARY KEY NOT NULL,
  "full_name" varchar(255) NOT NULL,
  "email" varchar(255) NOT NULL,
  "password" varchar(255) NOT NULL,
  "role" role NOT NULL
);

CREATE TABLE "brand" (
  "id" SERIAL PRIMARY KEY NOT NULL,
  "name" varchar(255) NOT NULL
);

CREATE TABLE "model" (
  "id" SERIAL PRIMARY KEY NOT NULL,
  "name" varchar(255) NOT NULL
);

CREATE TABLE "gear_box" (
  "id" SERIAL PRIMARY KEY NOT NULL,
  "name" varchar(255) NOT NULL
);

CREATE TABLE "fuel" (
  "id" SERIAL PRIMARY KEY NOT NULL,
  "name" varchar(255) NOT NULL
);

CREATE TABLE "city" (
  "id" SERIAL PRIMARY KEY NOT NULL,
  "name" varchar(255) NOT NULL
);

CREATE TABLE "car_offer" (
  "id" SERIAL PRIMARY KEY NOT NULL,
  "seller" int NOT NULL,
  "brand" int NOT NULL,
  "model" int NOT NULL,
  "gear_box" int NOT NULL,
  "fuel" int NOT NULL,
  "city" int NOT NULL,
  "description" varchar(2000),
  "year" int NOT NULL,
  "mileage" int NOT NULL,
  "price" float NOT NULL,
  "delete" boolean
);

ALTER TABLE "car_offer" ADD FOREIGN KEY ("seller") REFERENCES "user" ("id");

ALTER TABLE "car_offer" ADD FOREIGN KEY ("brand") REFERENCES "brand" ("id");

ALTER TABLE "car_offer" ADD FOREIGN KEY ("model") REFERENCES "model" ("id");

ALTER TABLE "car_offer" ADD FOREIGN KEY ("gear_box") REFERENCES "gear_box" ("id");

ALTER TABLE "car_offer" ADD FOREIGN KEY ("fuel") REFERENCES "fuel" ("id");

ALTER TABLE "car_offer" ADD FOREIGN KEY ("city") REFERENCES "city" ("id");
