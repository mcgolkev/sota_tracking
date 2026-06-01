-- schema-clean.sql

-- Ensures that the tables exist; will preserves existing data.

-- === Schema Definition ===
CREATE TABLE IF NOT EXISTS activations (
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

CREATE TABLE IF NOT EXISTS chaser_contacts (
    id SERIAL PRIMARY KEY,
    activation_id INTEGER NOT NULL REFERENCES activations(id) ON DELETE CASCADE,
    chaser_callsign VARCHAR(20) NOT NULL
);


