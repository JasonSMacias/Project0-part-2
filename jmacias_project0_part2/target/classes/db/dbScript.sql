DROP TABLE Car;
DROP TABLE AppUser;
DROP TABLE CarPayment;

CREATE TABLE Car (
  car_id NUMBER PRIMARY KEY,
  make_and_model VARCHAR(150),
  offer VARCHAR(10)
);

CREATE TABLE AppUser (
  u_name VARCHAR(100) PRIMARY KEY,
  u_password VARCHAR(100),
  u_role VARCHAR(10)
);

CREATE TABLE CarPayment (
  payments_left NUMBER,
  no_paid NUMBER,
  car_number NUMBER,
  buyer_name VARCHAR(100),
  PRIMARY KEY (car_number, buyer_name)
);