DROP SCHEMA IF EXISTS logistics;
CREATE SCHEMA logistics;
USE logistics;

CREATE TABLE IF NOT EXISTS `product` (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255),
	price INT
	
--	CONSTRAINT pk_product_id KEY(id)/
);

CREATE TABLE IF NOT EXISTS `customer` (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255),
	phone VARCHAR(255),
	address VARCHAR(255)

--	CONSTRAINT pk_customer_id KEY(id)
);

CREATE TABLE IF NOT EXISTS `order` (
	id INT PRIMARY KEY AUTO_INCREMENT,
	customer_id INT,
	total INT,
	status ENUM('PENDING', 'SUCCESS', 'FAILED'),
	payment_status ENUM('PENDING', 'SUCCESS', 'FAILED'),
	created_at DATE,
	
	FOREIGN KEY (customer_id) REFERENCES customer (id)
	
--	CONSTRAINT pk_order_id KEY (id),
--	CONSTRAINT fk_order_customer_id FOREIGN KEY (customer_id),
--	REFERENCES customer (customer_id)
);

CREATE TABLE IF NOT EXISTS `order_item` (
	id INT PRIMARY KEY AUTO_INCREMENT,
	order_id INT,
	product_id INT,
	quantity INT,
	price INT,
	
	FOREIGN KEY (order_id) REFERENCES `order` (id),
	FOREIGN KEY (product_id) REFERENCES product (id)
	
--	CONSTRAINT pk_order_item_id KEY (id),
--	CONSTRAINT fk_order KEY (order_id) REFERENCES order(order_id),
--	CONSTRAINT fk_order_product_id KEY(product_id) REFERENCES product(product_id)
	
);

CREATE TABLE IF NOT EXISTS `shipment` (
	id INT PRIMARY KEY AUTO_INCREMENT,
	order_id INT,
	method ENUM('COD','BANK'),
	amount INT,
	paid_at DATE,
	
	FOREIGN KEY (order_id) REFERENCES `order` (id)
	
--	CONSTRAINT pk_shipment_id KEY (id),
--	CONSTRAINT pk_shipment_order_id KEY (order_id) REFERENCES order(order_id) 
);