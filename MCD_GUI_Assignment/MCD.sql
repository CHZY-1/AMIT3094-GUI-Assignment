CREATE TABLE PRODUCT_CATEGORY (
        CATEGORY_ID VARCHAR(20) NOT NULL PRIMARY KEY, 
        CATEGORY_NAME VARCHAR(50)
);

CREATE TABLE STAFF_ROLE (
	ROLE_ID VARCHAR(10) NOT NULL PRIMARY KEY,
	ROLE_NAME VARCHAR(20),
	ORDERS VARCHAR(10),
	CUSTOMER VARCHAR(10),
	MENU VARCHAR(10),
	SALE VARCHAR(10),
	ADMIN VARCHAR(10)
);

CREATE TABLE ADDRESS(
        ADDRESS_ID VARCHAR(15) NOT NULL PRIMARY KEY,
        ADDRESS_STREET VARCHAR(50),
        ADDRESS_STATE VARCHAR(20),
        POSTCODE VARCHAR(10)
);

CREATE TABLE CUSTOMER (
        CUSTOMER_ID VARCHAR(20) NOT NULL PRIMARY KEY, 
        CUSTOMER_NAME VARCHAR(50),
        EMAIL VARCHAR(30),
        PHONE VARCHAR(15),
        PASSWORD VARCHAR(10),
        ADDRESS_ID VARCHAR(15) REFERENCES ADDRESS(ADDRESS_ID)
);

CREATE TABLE PRODUCT (
        PRODUCT_ID VARCHAR(20) NOT NULL PRIMARY KEY, 
        PRODUCT_NAME VARCHAR(50),
        PRODUCT_IMAGE BLOB(16M),
        PRODUCT_PRICE DOUBLE,
	  HIDDEN BOOLEAN,
        CATEGORY_ID VARCHAR(20) REFERENCES PRODUCT_CATEGORY(CATEGORY_ID) 
           
);

CREATE TABLE CARD (
        CARD_NO VARCHAR(30) NOT NULL PRIMARY KEY,
        CARD_HOLDER_NAME VARCHAR(20),
        CARD_TYPE VARCHAR(10),
        EXPIRED_MONTH VARCHAR(10),
        EXPIRED_YEAR INT
);


CREATE TABLE STAFF (
	STAFF_ID VARCHAR(10) NOT NULL PRIMARY KEY,
	STAFF_NAME VARCHAR(20),
	IC VARCHAR(15),
	PASSWORD VARCHAR(20),
	STATUS VARCHAR(10),
	PHONE_NO VARCHAR(15),
	GENDER VARCHAR(6),
	SALARY DOUBLE,
	ADDRESS_ID VARCHAR(15) REFERENCES ADDRESS(ADDRESS_ID),
	ROLE_ID VARCHAR(10) REFERENCES STAFF_ROLE(ROLE_ID) 
);

CREATE TABLE PAYMENT(
        PAYMENT_ID VARCHAR(20) NOT NULL PRIMARY KEY,
        PAYMENT_METHOD VARCHAR(10),
        TOTAL_PAYMENT_AMOUNT DOUBLE,
	  ORDER_STATUS VARCHAR(30),
        DATE_TIME TIMESTAMP,
        CUSTOMER_ID VARCHAR(20) REFERENCES CUSTOMER(CUSTOMER_ID),
        CARD_NO VARCHAR(30) REFERENCES CARD(CARD_NO)
);
CREATE TABLE ORDERS(
	ORDER_ID VARCHAR(30) NOT NULL PRIMARY KEY,
	ORDER_QUANTITY INTEGER,
	COMMENT VARCHAR(200),
	RATING VARCHAR(10),
	PAYMENT_ID VARCHAR(20),
	PRODUCT_ID VARCHAR(20)
);

INSERT INTO STAFF_ROLE VALUES ('RO-001','Manager','True','True','True','True','True');
INSERT INTO STAFF_ROLE VALUES ('RO-002','Assistant Manager','True','True','True','True','False');
INSERT INTO STAFF_ROLE VALUES ('RO-003','Worker','True','True','True','False','False');


INSERT INTO NBUSER.PRODUCT_CATEGORY (CATEGORY_ID, CATEGORY_NAME) 
	VALUES ('C1', 'Burger');
INSERT INTO NBUSER.PRODUCT_CATEGORY (CATEGORY_ID, CATEGORY_NAME) 
	VALUES ('C2', 'Drink');
INSERT INTO NBUSER.PRODUCT_CATEGORY (CATEGORY_ID, CATEGORY_NAME) 
	VALUES ('C3', 'Value Meals');
INSERT INTO NBUSER.PRODUCT_CATEGORY (CATEGORY_ID, CATEGORY_NAME) 
	VALUES ('C4', 'Family Set');



INSERT INTO NBUSER.PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_IMAGE, PRODUCT_PRICE, HIDDEN, CATEGORY_ID) 
	VALUES ('PROD-001', 'Spicy McCrispy Chicken',NULL, 11.6, false, 'C1');
INSERT INTO NBUSER.PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_IMAGE, PRODUCT_PRICE, HIDDEN, CATEGORY_ID) 
	VALUES ('PROD-002', 'Double Spicy McCrispy Chicken',NULL, 15.5, false, 'C1');
INSERT INTO NBUSER.PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_IMAGE, PRODUCT_PRICE, HIDDEN, CATEGORY_ID) 
	VALUES ('PROD-003', 'Double McChicken with Egg',NULL, 14.0, false, 'C1');
INSERT INTO NBUSER.PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_IMAGE, PRODUCT_PRICE, HIDDEN, CATEGORY_ID) 
	VALUES ('PROD-004', 'McChicken Super Value Meal',NULL, 18.0, false, 'C3');
INSERT INTO NBUSER.PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_IMAGE, PRODUCT_PRICE, HIDDEN, CATEGORY_ID) 
	VALUES ('PROD-005', 'Ayam Goreng Regular (2pcs) Super Value Meal',NULL, 22.0, false, 'C3');
INSERT INTO NBUSER.PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_IMAGE, PRODUCT_PRICE, HIDDEN, CATEGORY_ID) 
	VALUES ('PROD-006', 'Sprite',NULL, 5.0, false, 'C2');
INSERT INTO NBUSER.PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_IMAGE, PRODUCT_PRICE, HIDDEN, CATEGORY_ID) 
	VALUES ('PROD-007', 'Coca-Cola',NULL, 4.5, false, 'C2');
INSERT INTO NBUSER.PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_IMAGE, PRODUCT_PRICE, HIDDEN, CATEGORY_ID) 
	VALUES ('PROD-008', 'Family Meal A',NULL, 37.5, false, 'C4');
INSERT INTO NBUSER.PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_IMAGE, PRODUCT_PRICE, HIDDEN, CATEGORY_ID) 
	VALUES ('PROD-009', 'Family Meal B',NULL, 45.5, false, 'C4');



INSERT INTO CARD VALUES ('1234874512347894', 'John','Debit','January',2025);

INSERT INTO ADDRESS VALUES ('ADDR-001','JalanA','Penang','11200');
INSERT INTO ADDRESS VALUES ('ADDR-002','Jalan Baru','Penang','11200');
INSERT INTO ADDRESS VALUES ('ADDR-003','Jalan Klang','Kedah','08300');

INSERT INTO STAFF VALUES ('SF-001','Lim Sheng En','020323024581','limse4581','Active','0125158451','Male',4500.00,'ADDR-002','RO-001');
INSERT INTO STAFF VALUES ('SF-002','Lim Sheng Yang','020829025481','limsy123','Active','0165535351','Male',2500.00,'ADDR-003','RO-002');
INSERT INTO STAFF VALUES ('SF-003','Jack','208112255311','jack123','Active','0124785620','Male',2000.00,'ADDR-003','RO-003');

INSERT INTO CUSTOMER VALUES ('CUST-001', 'Christina', 'christina2022@gmail.com','01120183138', 'abc1234', 'ADDR-001');

INSERT INTO PAYMENT VALUES ('PAY-001','Debit', 30.00,'shipping',NULL,'CUST-001','1234874512347894');
INSERT INTO ORDERS VALUES ('ORD-001',2,NULL,NULL,'PAY-001','PROD-001');


