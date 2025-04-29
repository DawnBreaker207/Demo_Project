DROP SCHEMA IF EXISTS logistics;
CREATE SCHEMA logistics;
USE logistics;

CREATE TABLE IF NOT EXISTS product (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	sku VARCHAR(255) NOT NULL,
	price INT NOT NULL,
	is_delete BOOLEAN DEFAULT 0	
--	CONSTRAINT pk_product_id KEY(id)/
);

CREATE TABLE IF NOT EXISTS customer (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	phone VARCHAR(255),
	address VARCHAR(255)

--	CONSTRAINT pk_customer_id KEY(id)
);

CREATE TABLE IF NOT EXISTS shipment (
	id INT PRIMARY KEY AUTO_INCREMENT,
	method ENUM('COD','BANK') NOT NULL,
	status ENUM('SUCCESS', 'PENDING', 'FAILED') DEFAULT 'PENDING',
	amount INT NOT NULL,
	paid_at DATE
	
--	CONSTRAINT pk_shipment_id KEY (id),
--	CONSTRAINT pk_shipment_order_id KEY (order_id) REFERENCES order(order_id) 
);


CREATE TABLE IF NOT EXISTS orders (
	id INT PRIMARY KEY AUTO_INCREMENT,
	customer_id INT NOT NULL,
	shipment_id INT,
	total INT NOT NULL,
	status ENUM('SUCCESS', 'PENDING', 'FAILED') DEFAULT 'PENDING',
	payment_status ENUM('SUCCESS','PENDING', 'FAILED') DEFAULT 'PENDING',
	created_at DATE DEFAULT (CURRENT_DATE),
	is_delete BOOLEAN DEFAULT 0,
	
	FOREIGN KEY (customer_id) REFERENCES customer(id),
	FOREIGN KEY (shipment_id) REFERENCES shipment(id)
	
--	CONSTRAINT pk_order_id KEY (id),
--	CONSTRAINT fk_order_customer_id FOREIGN KEY (customer_id),
--	REFERENCES customer (customer_id)
);

CREATE TABLE IF NOT EXISTS order_item (
	id INT PRIMARY KEY AUTO_INCREMENT,
	order_id INT NOT NULL,
	product_id INT NOT NULL,
	quantity INT NOT NULL,
	price INT NOT NULL,
	
	FOREIGN KEY (order_id) REFERENCES orders(id ),
	FOREIGN KEY (product_id) REFERENCES product(id)
	
--	CONSTRAINT pk_order_item_id KEY (id),
--	CONSTRAINT fk_order KEY (order_id) REFERENCES order(order_id),
--	CONSTRAINT fk_order_product_id KEY(product_id) REFERENCES product(product_id)
	
);

