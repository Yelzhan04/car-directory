CREATE TABLE cars (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    make VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL,
    year INT CHECK (year >= 1886 AND year <= EXTRACT(YEAR FROM CURRENT_DATE)),
    price NUMERIC CHECK (price > 0),
    vin VARCHAR(17) UNIQUE NOT NULL
);
INSERT INTO cars (make, model, year, price, vin) VALUES
('Toyota', 'Corolla', 2020, 20000.00, '1HGCM82633A123456'),
('Honda', 'Civic', 2019, 19000.00, '2HGCM82633A123457'),
('Ford', 'Focus', 2018, 18000.00, '3HGCM82633A123458'),
('Tesla', 'Model 3', 2021, 35000.00, '4HGCM82633A123459'),
('BMW', 'X5', 2022, 60000.00, '5HGCM82633A123450');