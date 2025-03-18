-- Sample data for Seasons
INSERT INTO seasons (year) VALUES (2024);
-- Sample data for Circuits
INSERT INTO circuits (name, location, country, length)
VALUES ('Bahrain International Circuit', 'Sakhir', 'Bahrain', 5.412);
INSERT INTO circuits (name, location, country, length)
VALUES ('Jeddah Corniche Circuit', 'Jeddah', 'Saudi Arabia', 6.174);
-- Sample data for Teams
INSERT INTO teams (name, nationality, base_location, team_principal,
                   constructor)
VALUES ('Mercedes-AMG Petronas F1 Team', 'German', 'Brackley, United
Kingdom', 'Toto Wolff', 'Mercedes');
INSERT INTO teams (name, nationality, base_location, team_principal,
                   constructor)
VALUES ('Oracle Red Bull Racing', 'Austrian', 'Milton Keynes, United
Kingdom', 'Christian Horner', 'Red Bull');
-- Sample data for Drivers
INSERT INTO drivers (first_name, last_name, nationality, date_of_birth,
                     number, code, team_id)
VALUES ('Lewis', 'Hamilton', 'British', '1985-01-07', 44, 'HAM', 1);
INSERT INTO drivers (first_name, last_name, nationality, date_of_birth,
                     number, code, team_id) VALUES ('Max', 'Verstappen', 'Dutch', '1997-09-30', 1, 'VER', 2);
-- Sample data for Races
INSERT INTO races (name, circuit_id, season_id, race_date, round)
VALUES ('Bahrain Grand Prix', 1, 1, '2024-03-02', 1);
INSERT INTO races (name, circuit_id, season_id, race_date, round)
VALUES ('Saudi Arabian Grand Prix', 2, 1, '2024-03-09', 2);
-- Sample data for Race Results
INSERT INTO race_results (race_id, driver_id, team_id, position, points,
                          grid, laps, status, fastest_lap_time)
VALUES (1, 2, 2, 1, 25, 1, 57, 'Finished', '1:33.824');
INSERT INTO race_results (race_id, driver_id, team_id, position, points,
                          grid, laps, status, fastest_lap_time)
VALUES (1, 1, 1, 2, 18, 3, 57, 'Finished', '1:34.120');