-- Extended data for Seasons
INSERT INTO seasons (year) VALUES (2022);
INSERT INTO seasons (year) VALUES (2023);
INSERT INTO seasons (year) VALUES (2024);
INSERT INTO seasons (year) VALUES (2025);
INSERT INTO seasons (year) VALUES (2026);
INSERT INTO seasons (year) VALUES (2027);

-- Extended data for Circuits
INSERT INTO circuits (name, location, country, length) VALUES ('Bahrain International Circuit', 'Sakhir', 'Bahrain', 5.412);
INSERT INTO circuits (name, location, country, length) VALUES ('Jeddah Corniche Circuit', 'Jeddah', 'Saudi Arabia', 6.174);
INSERT INTO circuits (name, location, country, length) VALUES ('Albert Park Circuit', 'Melbourne', 'Australia', 5.278);
INSERT INTO circuits (name, location, country, length) VALUES ('Suzuka Circuit', 'Suzuka', 'Japan', 5.807);
INSERT INTO circuits (name, location, country, length) VALUES ('Circuit de Monaco', 'Monaco', 'Monaco', 3.337);
INSERT INTO circuits (name, location, country, length) VALUES ('Circuit de Spa-Francorchamps', 'Stavelot', 'Belgium', 7.004);
INSERT INTO circuits (name, location, country, length) VALUES ('Silverstone Circuit', 'Silverstone', 'United Kingdom', 5.891);
INSERT INTO circuits (name, location, country, length) VALUES ('Circuit Gilles Villeneuve', 'Montreal', 'Canada', 4.361);
INSERT INTO circuits (name, location, country, length) VALUES ('Circuit of the Americas', 'Austin', 'United States', 5.513);
INSERT INTO circuits (name, location, country, length) VALUES ('Interlagos Circuit', 'São Paulo', 'Brazil', 4.309);

-- Extended data for Teams
INSERT INTO teams (name, nationality, base_location, team_principal, constructor) VALUES ('Mercedes-AMG Petronas F1 Team', 'German', 'Brackley, United Kingdom', 'Toto Wolff', 'Mercedes');
INSERT INTO teams (name, nationality, base_location, team_principal, constructor) VALUES ('Oracle Red Bull Racing', 'Austrian', 'Milton Keynes, United Kingdom', 'Christian Horner', 'Red Bull');
INSERT INTO teams (name, nationality, base_location, team_principal, constructor) VALUES ('Scuderia Ferrari', 'Italian', 'Maranello, Italy', 'Frédéric Vasseur', 'Ferrari');
INSERT INTO teams (name, nationality, base_location, team_principal, constructor) VALUES ('McLaren F1 Team', 'British', 'Woking, United Kingdom', 'Andrea Stella', 'McLaren');
INSERT INTO teams (name, nationality, base_location, team_principal, constructor) VALUES ('Aston Martin Aramco Cognizant Formula One Team', 'British', 'Silverstone, United Kingdom', 'Mike Krack', 'Aston Martin');
INSERT INTO teams (name, nationality, base_location, team_principal, constructor) VALUES ('Alpine F1 Team', 'French', 'Enstone, United Kingdom', 'Laurent Rossi', 'Alpine');
INSERT INTO teams (name, nationality, base_location, team_principal, constructor) VALUES ('Alfa Romeo F1 Team', 'Swiss', 'Hinwil, Switzerland', 'Frederic Vasseur', 'Alfa Romeo');
INSERT INTO teams (name, nationality, base_location, team_principal, constructor) VALUES ('Haas F1 Team', 'American', 'Kannapolis, United States', 'Guenther Steiner', 'Haas');
INSERT INTO teams (name, nationality, base_location, team_principal, constructor) VALUES ('Williams Racing', 'British', 'Grove, United Kingdom', 'James Vowles', 'Williams');

-- Extended data for Drivers
-- Mercedes Drivers
INSERT INTO drivers (first_name, last_name, nationality, dob, number, code, team_id) VALUES ('Lewis', 'Hamilton', 'British', '1985-01-07', 44, 'HAM', 1);
INSERT INTO drivers (first_name, last_name, nationality, dob, number, code, team_id) VALUES ('George', 'Russell', 'British', '1998-02-15', 63, 'RUS', 1);
-- Red Bull Drivers
INSERT INTO drivers (first_name, last_name, nationality, dob, number, code, team_id) VALUES ('Max', 'Verstappen', 'Dutch', '1997-09-30', 1, 'VER', 2);
INSERT INTO drivers (first_name, last_name, nationality, dob, number, code, team_id) VALUES ('Sergio', 'Pérez', 'Mexican', '1990-01-26', 11, 'PER', 2);
-- Ferrari Drivers
INSERT INTO drivers (first_name, last_name, nationality, dob, number, code, team_id) VALUES ('Charles', 'Leclerc', 'Monegasque', '1997-10-16', 16, 'LEC', 3);
INSERT INTO drivers (first_name, last_name, nationality, dob, number, code, team_id) VALUES ('Carlos', 'Sainz', 'Spanish', '1994-09-01', 55, 'SAI', 3);
-- McLaren Drivers
INSERT INTO drivers (first_name, last_name, nationality, dob, number, code, team_id) VALUES ('Lando', 'Norris', 'British', '1999-11-13', 4, 'NOR', 4);
INSERT INTO drivers (first_name, last_name, nationality, dob, number, code, team_id) VALUES ('Oscar', 'Piastri', 'Australian', '2001-04-06', 81, 'PIA', 4);
-- Additional Drivers
INSERT INTO drivers (first_name, last_name, nationality, dob, number, code, team_id) VALUES ('Esteban', 'Ocon', 'French', '1996-09-17', 31, 'OCO', 5);
INSERT INTO drivers (first_name, last_name, nationality, dob, number, code, team_id) VALUES ('Fernando', 'Alonso', 'Spanish', '1981-07-29', 14, 'ALO', 5);
INSERT INTO drivers (first_name, last_name, nationality, dob, number, code, team_id) VALUES ('Valtteri', 'Bottas', 'Finnish', '1989-08-28', 77, 'BOT', 6);
INSERT INTO drivers (first_name, last_name, nationality, dob, number, code, team_id) VALUES ('Zhou', 'Guanyu', 'Chinese', '1999-05-30', 24, 'ZHO', 6);
-- Haas Drivers
INSERT INTO drivers (first_name, last_name, nationality, dob, number, code, team_id) VALUES ('Kevin', 'Magnussen', 'Danish', '1992-10-05', 20, 'MAG', 7);
INSERT INTO drivers (first_name, last_name, nationality, dob, number, code, team_id) VALUES ('Nico', 'Hülkenberg', 'German', '1987-08-19', 27, 'HUL', 7);

-- Extended data for Races
-- Bahrain, Saudi Arabia, Australia, Japanese GP already included
INSERT INTO races (name, circuit_id, season_id, race_date, round) VALUES ('Monaco Grand Prix', 5, 3, '2024-05-26', 5);
INSERT INTO races (name, circuit_id, season_id, race_date, round) VALUES ('Belgian Grand Prix', 6, 3, '2024-08-25', 6);
INSERT INTO races (name, circuit_id, season_id, race_date, round) VALUES ('British Grand Prix', 7, 3, '2024-07-07', 7);
INSERT INTO races (name, circuit_id, season_id, race_date, round) VALUES ('Canadian Grand Prix', 8, 3, '2024-06-16', 8);
INSERT INTO races (name, circuit_id, season_id, race_date, round) VALUES ('United States Grand Prix', 9, 3, '2024-10-20', 9);
INSERT INTO races (name, circuit_id, season_id, race_date, round) VALUES ('Brazilian Grand Prix', 10, 3, '2024-11-03', 10);

-- Extended data for Race Results
-- Bahrain Grand Prix Results
INSERT INTO race_results (race_id, driver_id, team_id, position, points, grid, laps, status, fastest_lap_time) VALUES (1, 3, 2, 1, 25, 1, 57, 'Finished', '1:33.824');
INSERT INTO race_results (race_id, driver_id, team_id, position, points, grid, laps, status, fastest_lap_time) VALUES (1, 1, 1, 2, 18, 3, 57, 'Finished', '1:34.120');
INSERT INTO race_results (race_id, driver_id, team_id, position, points, grid, laps, status, fastest_lap_time) VALUES (1, 5, 3, 3, 15, 2, 57, 'Finished', '1:34.500');
-- Saudi Arabian Grand Prix Results
INSERT INTO race_results (race_id, driver_id, team_id, position, points, grid, laps, status, fastest_lap_time) VALUES (2, 3, 2, 1, 25, 1, 50, 'Finished', '1:29.550');
INSERT INTO race_results (race_id, driver_id, team_id, position, points, grid, laps, status, fastest_lap_time) VALUES (2, 2, 1, 2, 18, 2, 50, 'Finished', '1:30.100');
INSERT INTO race_results (race_id, driver_id, team_id, position, points, grid, laps, status, fastest_lap_time) VALUES (2, 7, 4, 3, 15, 3, 50, 'Finished', '1:30.500');
-- Australian Grand Prix Results
INSERT INTO race_results (race_id, driver_id, team_id, position, points, grid, laps, status, fastest_lap_time) VALUES (3, 6, 5, 1, 25, 1, 58, 'Finished', '1:32.000');
INSERT INTO race_results (race_id, driver_id, team_id, position, points, grid, laps, status, fastest_lap_time) VALUES (3, 1, 1, 2, 18, 3, 58, 'Finished', '1:32.400');
INSERT INTO race_results (race_id, driver_id, team_id, position, points, grid, laps, status, fastest_lap_time) VALUES (3, 8, 4, 3, 15, 2, 58, 'Finished', '1:32.800');
-- And more results for other races...
