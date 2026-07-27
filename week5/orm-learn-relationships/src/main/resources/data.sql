-- Country sample data
INSERT INTO country (co_code, co_name) VALUES ('IN', 'India');
INSERT INTO country (co_code, co_name) VALUES ('US', 'United States of America');
INSERT INTO country (co_code, co_name) VALUES ('BV', 'Bouvet Island');
INSERT INTO country (co_code, co_name) VALUES ('DJ', 'Djibouti');
INSERT INTO country (co_code, co_name) VALUES ('GP', 'Guadeloupe');
INSERT INTO country (co_code, co_name) VALUES ('GS', 'South Georgia and the South Sandwich Islands');
INSERT INTO country (co_code, co_name) VALUES ('LU', 'Luxembourg');
INSERT INTO country (co_code, co_name) VALUES ('SS', 'South Sudan');
INSERT INTO country (co_code, co_name) VALUES ('TF', 'French Southern Territories');
INSERT INTO country (co_code, co_name) VALUES ('UM', 'United States Minor Outlying Islands');
INSERT INTO country (co_code, co_name) VALUES ('ZA', 'South Africa');
INSERT INTO country (co_code, co_name) VALUES ('ZM', 'Zambia');
INSERT INTO country (co_code, co_name) VALUES ('ZW', 'Zimbabwe');

-- Stock sample data
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-09-03', 184.00, 182.39, 9779400);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-09-04', 184.65, 187.14, 11308000);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-09-05', 188.53, 190.90, 13876700);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-01-31', 165.60, 166.69, 77233600);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2018-10-31', 155.00, 151.79, 60101300);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2018-12-19', 141.21, 133.24, 57404900);

INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('GOOGL', '2019-04-22', 1236.67, 1253.76, 954200);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('GOOGL', '2019-04-23', 1256.64, 1270.59, 1593400);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('GOOGL', '2019-04-24', 1270.59, 1260.05, 1169800);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('GOOGL', '2019-04-25', 1270.30, 1267.34, 1567200);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('GOOGL', '2019-04-26', 1273.38, 1277.42, 1361400);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('GOOGL', '2019-04-29', 1280.51, 1296.20, 3618400);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('GOOGL', '2019-10-17', 1251.40, 1252.80, 1047900);

INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('NFLX', '2018-12-24', 242.00, 233.88, 9547600);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('NFLX', '2018-12-21', 263.83, 246.39, 21397600);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('NFLX', '2018-12-26', 233.92, 253.67, 14402700);

-- Payroll sample data (Department, Employee, Skill)
INSERT INTO department (dp_id, dp_name) VALUES (1, 'Information Technology');
INSERT INTO department (dp_id, dp_name) VALUES (2, 'Human Resources');

INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) 
VALUES (1, 'John Doe', 75000.00, true, '1995-05-15', 1);

INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) 
VALUES (2, 'Jane Smith', 85000.00, true, '1992-08-20', 1);

INSERT INTO skill (sk_id, sk_name) VALUES (1, 'Java');
INSERT INTO skill (sk_id, sk_name) VALUES (2, 'Spring Data JPA');
INSERT INTO skill (sk_id, sk_name) VALUES (3, 'React');

INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 2);
