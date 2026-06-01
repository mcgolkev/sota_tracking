-- data.sql
-- === Sample Data ===
INSERT INTO activations (summit_ref, activation_date, frequency_mhz, mode, notes, rig, antenna, power_source)
VALUES
('W6/NC-432', '2025-10-29 15:30:00', 14.285, 'SSB',
 'Sunny and calm. Great propagation!', 'Yaesu FT-891',
 'End-fed half-wave resonant', 'Battery');

INSERT INTO chaser_contacts (activation_id, chaser_callsign)
VALUES
(1, 'K6ABC'),
(1, 'W7XYZ'),
(1, 'N0CALL');
