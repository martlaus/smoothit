insert into component(id, calories, description, name, price, weight) VALUES (6600, 100, 'Raw lemon', 'Lemon', 1.0, 50);
insert into component(id, calories, description, name, price, weight) VALUES (6601, 150, 'Raw apple', 'Apple', 0.8, 70);

insert into smoothie(id, calories, description, name, price, weight) values (7700, 1000, 'Wake up smoothie', 'Pick me up!', 5.0, 200);

insert into smoothie_components(smoothie_id, component_id) VALUES (7700, 6600);