CREATE TABLE tariffs (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    speed INTEGER NOT NULL CHECK (speed > 0),
    price DECIMAL(10, 2) NOT NULL CHECK (price >= 0),
    description VARCHAR(255)
);

CREATE TABLE services (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    price DECIMAL(10, 2) NOT NULL CHECK (price >= 0),
    is_available BOOLEAN NOT NULL,
    installation_url VARCHAR(255)
);

CREATE TABLE bonus_products (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    points_cost INTEGER NOT NULL CHECK (points_cost >= 0),
    description VARCHAR(255),
    type VARCHAR(255) NOT NULL
);

CREATE TABLE promotions (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    image_url VARCHAR(255)
);