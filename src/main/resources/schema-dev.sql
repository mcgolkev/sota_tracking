-- schema-dev.sql
-- EXISTING SCHEMA AND DATA WILL BE DELETED!!
-- Default seed data from data.sql will be restored to the database.
-- Drops and recreates tables each startup for a clean dev environment.

DROP TABLE IF EXISTS chaser_contacts;
DROP TABLE IF EXISTS activations;

CREATE TABLE activations (
    id SERIAL PRIMARY KEY,
    summit_ref VARCHAR(50) NOT NULL,
    activation_date TIMESTAMP NOT NULL,
    frequency_mhz DECIMAL(6, 3) NOT NULL,
    mode VARCHAR(20) NOT NULL CHECK (mode IN ('SSB', 'CW', 'FM', 'AM', 'DIGITAL')),
    notes TEXT,
    rig VARCHAR(100),
    antenna VARCHAR(100),
    power_source VARCHAR(50)
);

CREATE TABLE chaser_contacts (
    id SERIAL PRIMARY KEY,
    activation_id INTEGER NOT NULL REFERENCES activations(id) ON DELETE CASCADE,
    chaser_callsign VARCHAR(20) NOT NULL
);
