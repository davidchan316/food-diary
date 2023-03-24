START TRANSACTION;

DROP TABLE IF EXISTS entry_tag, restaurant_tag CASCADE;
DROP TABLE IF EXISTS entry, tag, restaurant, diary, app_user CASCADE;
DROP SEQUENCE IF EXISTS user_serial, diary_serial, restaurant_serial, entry_serial, tag_serial;

-- user table
CREATE SEQUENCE user_serial;
CREATE TABLE app_user (
    user_id INT NOT NULL DEFAULT nextval('user_serial'),
    username VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(200) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
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

-- restaurant table
CREATE SEQUENCE restaurant_serial;
CREATE TABLE restaurant (
    restaurant_id INT NOT NULL DEFAULT nextval('restaurant_serial'),
    restaurant_name VARCHAR(100) NOT NULL,
    address VARCHAR(100) NOT NULL UNIQUE,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    postal_code VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL,
    CONSTRAINT pk_restaurant PRIMARY KEY(restaurant_id),
);

-- entry table
CREATE SEQUENCE entry_serial;
CREATE TABLE entry (
    entry_id INT NOT NULL DEFAULT nextval('entry_serial'),
    diary_id INT NOT NULL,
    entry_name VARCHAR(100) NOT NULL,
    restaurant_id INT,
    date_time TIMESTAMP NOT NULL,
    description VARCHAR(500),
    price DECIMAL(5,2),
    rating DECIMAL(3,2),
    
    CONSTRAINT pk_entry PRIMARY KEY(entry_id),
    CONSTRAINT fk_entry_diary FOREIGN KEY(diary_id) REFERENCES diary(diary_id),
    CONSTRAINT fk_entry_restaurant FOREIGN KEY(restaurant_id) REFERENCES restaurant(restaurant_id),
    CONSTRAINT ck_price_gt_0 CHECK (price > 0),
    CONSTRAINT ck_rating_between_0_and_5 CHECK ((rating >= 0) AND (rating <= 5))
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

-- Populate tag table
-- 1: Price Point
INSERT INTO tag (tag_type, tag_name) VALUES (1, '$');
INSERT INTO tag (tag_type, tag_name) VALUES (1, '$$');
INSERT INTO tag (tag_type, tag_name) VALUES (1, '$$$');
INSERT INTO tag (tag_type, tag_name) VALUES (1, '$$$$');

-- 2: Category
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'American (New)');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'American (Traditional)');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Asian Fusion');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Bars');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Beer, Wine & Spirits');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Breakfast & Brunch');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Bubble Tea');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Buffets');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Chinese');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Coffee & Tea');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Desserts');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Fast Food');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Food');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Food Delivery Service');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Grocery');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Health Markets');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Italian');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Japanese');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Karaoke');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Korean');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Kosher');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Malaysian');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Nightlife');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Noodles');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Organic Stores');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Pan Asian');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Poke');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Ramen');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Restaurants');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Salad');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Seafood');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Soup');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Specialty Food');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Steakhouses');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Sushi Bars');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Szechuan');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Teppanyaki');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Thai');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Vegan');
INSERT INTO tag (tag_type, tag_name) VALUES (2, 'Vietnamese');

-- 3: General Features
INSERT INTO tag (tag_type, tag_name) VALUES (3, 'Accepts Apple Pay');
INSERT INTO tag (tag_type, tag_name) VALUES (3, 'Accepts Credit Cards');
INSERT INTO tag (tag_type, tag_name) VALUES (3, 'Cash Only');
INSERT INTO tag (tag_type, tag_name) VALUES (3, 'Good for Groups');
INSERT INTO tag (tag_type, tag_name) VALUES (3, 'Good for Kids');
INSERT INTO tag (tag_type, tag_name) VALUES (3, 'Offers Delivery');
INSERT INTO tag (tag_type, tag_name) VALUES (3, 'Offers Military Discount');
INSERT INTO tag (tag_type, tag_name) VALUES (3, 'Offers Takeout');
INSERT INTO tag (tag_type, tag_name) VALUES (3, 'Open to All');
INSERT INTO tag (tag_type, tag_name) VALUES (3, 'Outdoor Seating');
INSERT INTO tag (tag_type, tag_name) VALUES (3, 'Proof of Vaccination Required');
INSERT INTO tag (tag_type, tag_name) VALUES (3, 'Reservations');
INSERT INTO tag (tag_type, tag_name) VALUES (3, 'Takes Reservations');
INSERT INTO tag (tag_type, tag_name) VALUES (3, 'Waiter Service');
INSERT INTO tag (tag_type, tag_name) VALUES (3, 'Wheelchair Accessible');

-- 4: Alcohol
INSERT INTO tag (tag_type, tag_name) VALUES (4, 'Beer & Wine Only');
INSERT INTO tag (tag_type, tag_name) VALUES (4, 'Full Bar');
INSERT INTO tag (tag_type, tag_name) VALUES (4, 'Good For Happy Hour');

-- 5: Meals Served
INSERT INTO tag (tag_type, tag_name) VALUES (5, 'Breakfast');
INSERT INTO tag (tag_type, tag_name) VALUES (5, 'Brunch');
INSERT INTO tag (tag_type, tag_name) VALUES (5, 'Lunch');
INSERT INTO tag (tag_type, tag_name) VALUES (5, 'Dinner');
INSERT INTO tag (tag_type, tag_name) VALUES (5, 'Dessert');
INSERT INTO tag (tag_type, tag_name) VALUES (5, 'Late Night');

-- 6: Parking
INSERT INTO tag (tag_type, tag_name) VALUES (6, 'Garage');
INSERT INTO tag (tag_type, tag_name) VALUES (6, 'Private Lot');
INSERT INTO tag (tag_type, tag_name) VALUES (6, 'Street');
INSERT INTO tag (tag_type, tag_name) VALUES (6, 'Valet');
INSERT INTO tag (tag_type, tag_name) VALUES (6, 'Validated');

-- 7: Wifi
INSERT INTO tag (tag_type, tag_name) VALUES (7, 'Free');
INSERT INTO tag (tag_type, tag_name) VALUES (7, 'Paid');

COMMIT;