--Address
insert into Museum_Address(id, line_one, line_two, state, post_code, country)
values (1, 'Cromwell Rd', '', 'London', 'SW7 2RL', 'UK');

-- Museums
insert into Museum (id, museum_name, location, curator, total_number_of_art_work)
values (9, 'The National Gallery', 'London', 'Gabriele Finaldi', 80000);
insert into Museum (id, museum_name, location, curator, total_number_of_art_work)
values (10, 'National Portrait Gallery', 'London', 'Bree Pickering', 50000);

-- Artists
insert into Artist (id, artist_name, year_born, year_down, number_of_work, museum_id)
values (9, 'Dante Gabriel Rossetti', '12 May 1828', '9 April 1882', 50, 9);
insert into Artist (id, artist_name, year_born, year_down, number_of_work, museum_id)
values (10, 'Artist Unknown', 'Unknown', 'Unknown', 100, 10);

-- Art
insert into Art (id, name, location, artist_id, artist_name, art_type, year_completed, medium, backstory)
values (10, 'The Day Dream', 'London', 9, 'Dante Gabriel Rossetti', 'Painting', '1880', 'Oil in canvas', 'During 1878 Rossetti completed a chalk sketch of Morris,[1] his secret lover, whom he had met at the Theatre Royal, Drury Lane, in 1857.[2] She was the model for several of his well-known paintings');

-- Paintings
insert into Painting (id, number_of_paintings_by_given_artist, style, museum_paintings_id, artist_painting_id)
values (10, 6000, 'Impressionist', 10, 9);


-- Sculptures
insert into Sculpture (id, number_of_sculptures_by_given_artist, museum_sculptures_id, artist_sculpture_id, sculpture_name)
values (10, 3, 9, 10, 'Sleeping Hermaphrodite On Bed, David, Medusa');
