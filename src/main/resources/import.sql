insert into component (id, name, brand, kcal_per_unit, unit, unit_price_eur, color_hex) VALUES (1001, 'Banaan', 'Chiquita', 890, 'kg', 0.95, '#ffe135');
insert into component (id, name, brand, kcal_per_unit, unit, unit_price_eur, color_hex)
VALUES (1002, 'Õun GreenPrince', 'Schmöko Toode', 400, 'kg', 1.49, '#8db600');
insert into component (id, name, brand, kcal_per_unit, unit, unit_price_eur, color_hex) VALUES (1003, 'Piim', 'Alma', 640, 'kg', 0.79, '#dcd9cd');
insert into component (id, name, brand, kcal_per_unit, unit, unit_price_eur, color_hex) VALUES (1004, 'Piim', 'Tere', 750, 'kg', 0.59, '#dcd9cd');
insert into component (id, name, brand, kcal_per_unit, unit, unit_price_eur, color_hex) VALUES (1005, 'Mandlipiim', 'Alpro', 240, 'kg', 2.29, '#efdecd');
insert into component (id, name, brand, kcal_per_unit, unit, unit_price_eur, color_hex) VALUES (1006, 'Maasikad', 'NoBananas', 330, 'kg', 5.49, '#ff43a4');
insert into component (id, name, brand, kcal_per_unit, unit, unit_price_eur, color_hex) VALUES (1007, 'Maasikad', 'Eesti', 330, 'kg', 7.99, '#ff43a4');
insert into component (id, name, brand, kcal_per_unit, unit, unit_price_eur, color_hex) VALUES (1008, 'Vaarikad', 'NoBananas', 530, 'kg', 6.30, '#b3446c');
insert into component (id, name, brand, kcal_per_unit, unit, unit_price_eur, color_hex) VALUES (1009, 'Vaarikad', 'YesRaspberry', 530, 'kg', 7.4, '#b3446c');
insert into component (id, name, brand, kcal_per_unit, unit, unit_price_eur, color_hex)
VALUES (1010, 'Maitsestamata jogurt', 'Alma', 590, 'kg', 2.97, '#f8f8ff');
insert into component (id, name, brand, kcal_per_unit, unit, unit_price_eur, color_hex) VALUES (1011, 'Mango', 'Peruu', 600, 'kg', 2.19, '#dc8700');
insert into component (id, name, brand, kcal_per_unit, unit, unit_price_eur, color_hex) VALUES (1012, 'Arbuus', 'Arbuusia', 300, 'kg', 0.79, '#fc6c85');
insert into component (id, name, brand, kcal_per_unit, unit, unit_price_eur, color_hex)
VALUES (1013, 'Vanilli koorejäätis', 'Jäts', 1900, 'kg', 6.23, '#fcf9f0');
insert into component (id, name, brand, kcal_per_unit, unit, unit_price_eur, color_hex)
VALUES (1014, 'Šokolaadi koorejäätis', 'Premia', 2680, 'kg', 6.55, '#7b3f00');
insert into component (id, name, brand, kcal_per_unit, unit, unit_price_eur, color_hex) VALUES (1015, 'Kiivi korvis', 'Hispaania', 610, 'kg', 1.89, '#9dae5c');
insert into component (id, name, brand, kcal_per_unit, unit, unit_price_eur, color_hex)
VALUES (1016, 'Apelsin Valencia', 'Hispaania', 470, 'kg', 0.89, '#ffa500');
insert into component (id, name, brand, kcal_per_unit, unit, unit_price_eur, color_hex) VALUES (1017, 'Õunamahl', 'Cappy', 450, 'kg', 1.39, '#ddad76');
insert into component (id, name, brand, kcal_per_unit, unit, unit_price_eur, color_hex) VALUES (1018, 'Õunamahl', 'Aura', 470, 'kg', 0.99, '#ddad76');

insert into smoothie (id, calories, description, name, instructions) values (10001, 1254, 'Wake up smoothie', 'Pick me up!', 'Put everything in a blender');

insert into smoothie_component (id, smoothie_id, component_id, amount) VALUES (10000, 10001, 1001, 5);