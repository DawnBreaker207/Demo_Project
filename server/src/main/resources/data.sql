-- Products
INSERT INTO product (name,sku, price, is_delete) VALUES
('Apple iPhone 14 Pro Max', '0001' , 29000000 , 0),
('Samsung Galaxy S23 Ultra','0002' , 27000000, 0),
('Dell XPS 13','0003' , 32000000, 0),
('MacBook Pro 14"','0004' , 45000000, 0),
('Logitech MX Master 3 Mouse','0005' , 1800000, 0),
('Sony WH-1000XM5 Headphones','0006' , 7900000, 0),
('Apple Watch Series 9','0007' , 11500000, 0),
('Nintendo Switch OLED','0008' , 9500000, 0),
('LG 27" 4K Monitor','0009' , 8700000, 0),
('Microsoft Surface Laptop 5','0010' , 36000000, 0),
('JBL Charge 5 Bluetooth Speaker','0011' , 3300000, 0),
('Razer BlackWidow V4 Keyboard','0012' , 3200000, 0),
('Asus ROG Strix G16 Laptop','0013' , 42000000, 0),
('GoPro HERO12 Black','0014' , 11500000, 0),
('Anker PowerCore 20K Power Bank','0015' , 950000, 0),
('Google Pixel 8','0016' , 21000000, 0),
('Xiaomi Redmi Note 13 Pro+','0017' , 12000000, 0),
('TP-Link AX55 WiFi 6 Router','0018' , 1900000, 0),
('Amazon Kindle Paperwhite','0019' , 3500000, 0),
('Canon EOS R50 Camera','0020' , 19900000, 0);

-- Customer
INSERT INTO customer (name, phone, address) VALUES
('Alice', '123456789', 'Hanoi'),
('Bob', '234567891', 'HCMC'),
('Charlie', '345678912', 'Danang'),
('David', '456789123', 'Hue'),
('Eve', '567891234', 'Can Tho'),
('Frank', '678912345', 'Quang Ninh'),
('Grace', '789123456', 'Vung Tau'),
('Hannah', '891234567', 'Haiphong'),
('Ivy', '912345678', 'Bac Ninh'),
('Jack', '102938475', 'Ninh Binh');

-- Shipments
INSERT INTO shipment (method, amount, paid_at) VALUES
('COD', 2000, '2024-04-01'), ('BANK', 1000, '2024-04-02'),
('COD', 1500, '2024-04-03'), ('COD', 300, '2024-04-04'),
('BANK', 200, '2024-04-05'), ('COD', 1000, '2024-04-06'),
('BANK', 1500, '2024-04-07'), ('COD', 2000, '2024-04-08'),
('BANK', 300, '2024-04-09'), ('COD', 200, '2024-04-10'),
('BANK', 1800, '2024-04-11'), ('COD', 1200, '2024-04-12'),
('BANK', 900, '2024-04-13'), ('COD', 1700, '2024-04-14'),
('BANK', 1400, '2024-04-15'), ('COD', 1600, '2024-04-16'),
('BANK', 500, '2024-04-17'), ('COD', 1300, '2024-04-18'),
('BANK', 600, '2024-04-19'), ('COD', 700, '2024-04-20'),
('BANK', 1100, '2024-04-21'), ('COD', 800, '2024-04-22'),
('BANK', 400, '2024-04-23'), ('COD', 100, '2024-04-24'),
('BANK', 2100, '2024-04-25'), ('COD', 1900, '2024-04-26'),
('BANK', 1700, '2024-04-27'), ('COD', 1600, '2024-04-28'),
('BANK', 900, '2024-04-29'), ('COD', 1500, '2024-04-30');


-- Orders
INSERT INTO orders (customer_id, shipment_id, total, status, payment_status, created_at ,is_delete) VALUES
(1, 1, 2000, 'SUCCESS', 'SUCCESS', '2024-04-01', 0),
(2, 2, 1000, 'SUCCESS', 'SUCCESS', '2024-04-02', 0),
(3, 3, 1500, 'PENDING', 'PENDING', '2024-04-03', 0),
(4, 4, 300, 'FAILED', 'FAILED', '2024-04-04', 0),
(5, 5, 200, 'SUCCESS', 'SUCCESS', '2024-04-05', 0),
(6, 6, 1000, 'PENDING', 'PENDING', '2024-04-06', 0),
(7, 7, 1500, 'SUCCESS', 'SUCCESS', '2024-04-07', 0),
(8, 8, 2000, 'FAILED', 'FAILED', '2024-04-08', 0),
(9, 9, 300, 'SUCCESS', 'SUCCESS', '2024-04-09', 0),
(10, 10, 200, 'SUCCESS', 'SUCCESS', '2024-04-10', 0),
(1, 11, 1800, 'SUCCESS', 'SUCCESS', '2024-04-11', 0),
(2, 12, 1200, 'PENDING', 'PENDING', '2024-04-12', 0),
(3, 13, 900, 'SUCCESS', 'SUCCESS', '2024-04-13', 0),
(4, 14, 1700, 'FAILED', 'FAILED', '2024-04-14', 0),
(5, 15, 1400, 'SUCCESS', 'SUCCESS', '2024-04-15', 0),
(6, 16, 1600, 'PENDING', 'PENDING', '2024-04-16', 0),
(7, 17, 500, 'SUCCESS', 'SUCCESS', '2024-04-17', 0),
(8, 18, 1300, 'FAILED', 'FAILED', '2024-04-18', 0),
(9, 19, 600, 'SUCCESS', 'SUCCESS', '2024-04-19', 0),
(10, 20, 700, 'SUCCESS', 'SUCCESS', '2024-04-20', 0),
(1, 21, 1100, 'PENDING', 'PENDING', '2024-04-21', 0),
(2, 22, 800, 'FAILED', 'FAILED', '2024-04-22', 0),
(3, 23, 400, 'SUCCESS', 'SUCCESS', '2024-04-23', 0),
(4, 24, 100, 'SUCCESS', 'SUCCESS', '2024-04-24', 0),
(5, 25, 2100, 'SUCCESS', 'SUCCESS', '2024-04-25', 0),
(6, 26, 1900, 'PENDING', 'PENDING', '2024-04-26', 0),
(7, 27, 1700, 'FAILED', 'FAILED', '2024-04-27', 0),
(8, 28, 1600, 'SUCCESS', 'SUCCESS', '2024-04-28', 0),
(9, 29, 900, 'SUCCESS', 'SUCCESS', '2024-04-29', 0),
(10, 30, 1500, 'PENDING', 'PENDING', '2024-04-30', 0);


INSERT INTO order_item (order_id, product_id, quantity, price) VALUES
(1, 1, 1, 2000),
(2, 2, 1, 1000),
(3, 3, 1, 1500),
(4, 4, 1, 300),
(5, 5, 1, 200),
(6, 2, 1, 1000),
(7, 3, 1, 1500),
(8, 1, 1, 2000),
(9, 5, 1, 300),
(10, 4, 1, 200),
(11, 3, 1, 1800),
(12, 2, 1, 1200),
(13, 5, 1, 900),
(14, 1, 1, 1700),
(15, 2, 1, 1400),
(16, 3, 1, 1600),
(17, 4, 1, 500),
(18, 5, 1, 1300),
(19, 1, 1, 600),
(20, 2, 1, 700),
(21, 3, 1, 1100),
(22, 4, 1, 800),
(23, 5, 1, 400),
(24, 1, 1, 100),
(25, 2, 1, 2100),
(26, 3, 1, 1900),
(27, 4, 1, 1700),
(28, 5, 1, 1600),
(29, 1, 1, 900),
(30, 2, 1, 1500);


