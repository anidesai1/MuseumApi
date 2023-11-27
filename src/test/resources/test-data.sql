insert into Museum (id, museum_name, location, curator, total_number_of_art_work)
                values (7, 'Victoria and Albert Museum', 'London', 'Joanna Norman', 70000);
insert into Museum (id, museum_name, location, curator, total_number_of_art_work)
                values (2, 'The National Gallery', 'London', 'Gabriele Finaldi', 80000);
insert into Museum (id, museum_name, location, curator, total_number_of_art_work)
                values (3, 'National Portrait Gallery', 'London', 'Bree Pickering', 50000);
insert into Artist (id, artist_name, year_born, year_down, number_of_work, museum_id)
    values (2, 'John Constable', '11 June 1776', '31 March 1837', 100, 7);
insert into Artist (id, artist_name, year_born, year_down, number_of_work, museum_id)
    values (3, 'Dante Gabriel Rossetti', '12 May 1828', '9 April 1882', 50, 7);
insert into Art (id, name, artist_id, artist_name, art_type, year_completed, medium, backstory)
    values (2, 'Salisbury Cathedral from the Bishops Grounds',2, 'John Constable', 'Painting', '1823', 'Oil in canvas', 'The artist selected a viewpoint from the bishop''s garden (the south-east) and returned in 1820 to make further drawings and an open-air oil sketch, now in the National Gallery of Canada in Ottawa,[3] which served as the model for the London version.');
insert into Art (id, name, artist_id, artist_name, art_type, year_completed, medium, backstory)
    values(3, 'The Day Dream', 3, 'Dante Gabriel Rossetti', 'Painting', '1880', 'Oil in canvas', 'During 1878 Rossetti completed a chalk sketch of Morris,[1] his secret lover, whom he had met at the Theatre Royal, Drury Lane, in 1857.[2] She was the model for several of his well-known paintings');
