START TRANSACTION;

DROP TABLE IF EXISTS diary_entry, entry_tag, restaurant_tag CASCADE;
DROP TABLE IF EXISTS entry, tag, location, restaurant, diary, app_user CASCADE;
DROP SEQUENCE IF EXISTS user_serial, diary_serial, location_serial, restaurant_serial, entry_serial, tag_serial;

-- user table
CREATE SEQUENCE user_serial;
CREATE TABLE app_user (
    user_id INT NOT NULL DEFAULT nextval('user_serial'),
    username VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(200) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100),
    CONSTRAINT pk_user PRIMARY KEY(user_id)
);

-- diary table
CREATE SEQUENCE diary_serial;
CREATE TABLE diary (
    diary_id INT NOT NULL DEFAULT nextval('diary_serial'),
    diary_name VARCHAR(100) NOT NULL,
    user_id INT NOT NULL,
    CONSTRAINT pk_diary PRIMARY KEY(diary_id),
    CONSTRAINT fk_diary_user FOREIGN KEY(user_id) REFERENCES app_user(user_id)
);

-- location table
CREATE SEQUENCE location_serial;
CREATE TABLE location (
    location_id INT NOT NULL DEFAULT nextval('location_serial'),
    address VARCHAR(100) NOT NULL UNIQUE,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    postal_code VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL,
    CONSTRAINT pk_location PRIMARY KEY(location_id)
);

-- restaurant table
CREATE SEQUENCE restaurant_serial;
CREATE TABLE restaurant (
    restaurant_id INT NOT NULL DEFAULT nextval('restaurant_serial'),
    location_id INT NOT NULL,
    restaurant_name VARCHAR(100) NOT NULL,
    CONSTRAINT pk_restaurant PRIMARY KEY(restaurant_id),
    CONSTRAINT fk_restaurant_location FOREIGN KEY(location_id) REFERENCES location(location_id)
);

-- entry table
CREATE SEQUENCE entry_serial;
CREATE TABLE entry (
    entry_id INT NOT NULL DEFAULT nextval('entry_serial'),
    food_name VARCHAR(100) NOT NULL,
    location_id INT,
    restaurant_id INT,
    date_time TIMESTAMP NOT NULL,
    description VARCHAR(500),
    price DECIMAL(5,2),
    rating DECIMAL(3,2),
    CONSTRAINT pk_entry PRIMARY KEY(entry_id),
    CONSTRAINT fk_entry_location FOREIGN KEY(location_id) REFERENCES location(location_id),
    CONSTRAINT fk_entry_restaurant FOREIGN KEY(restaurant_id) REFERENCES restaurant(restaurant_id)
);

-- diary_entry table
CREATE TABLE diary_entry (
    diary_id INT NOT NULL,
    entry_id INT NOT NULL,
    CONSTRAINT pk_diary_entry PRIMARY KEY(diary_id, entry_id),
    CONSTRAINT fk_diary_entry_diary FOREIGN KEY(diary_id) REFERENCES diary(diary_id),
    CONSTRAINT fk_diary_entry_entry FOREIGN KEY(entry_id) REFERENCES entry(entry_id)
);

-- tag table
CREATE SEQUENCE tag_serial;
CREATE TABLE tag (
    tag_id INT NOT NULL DEFAULT nextval('tag_serial'),
    tag_type INT NOT NULL,
    tag_name VARCHAR(100) NOT NULL UNIQUE,
    CONSTRAINT pk_tag PRIMARY KEY(tag_id)
);

-- entry_tag table
CREATE TABLE entry_tag (
    entry_id INT NOT NULL,
    tag_id INT NOT NULL,
    CONSTRAINT pk_entry_tag PRIMARY KEY(entry_id, tag_id),
    CONSTRAINT fk_entry_tag_entry FOREIGN KEY(entry_id) REFERENCES entry(entry_id),
    CONSTRAINT fk_entry_tag_tag FOREIGN KEY(tag_id) REFERENCES tag(tag_id)
);

-- restaurant_tag table
CREATE TABLE restaurant_tag (
    restaurant_id INT NOT NULL,
    tag_id INT NOT NULL,
    CONSTRAINT pk_restaurant_tag PRIMARY KEY(restaurant_id, tag_id),
    CONSTRAINT fk_restaurant_tag_restaurant FOREIGN KEY(restaurant_id) REFERENCES restaurant(restaurant_id),
    CONSTRAINT fk_restaurant_tag_tag FOREIGN KEY(tag_id) REFERENCES tag(tag_id)
);

COMMIT;