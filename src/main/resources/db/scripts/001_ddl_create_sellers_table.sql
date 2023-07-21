CREATE TABLE IF NOT EXISTS sellers(
id SERIAL PRIMARY KEY,
seller_name VARCHAR(255) not null,
email VARCHAR(255) not null unique,
phone_number varchar(255) not null
);