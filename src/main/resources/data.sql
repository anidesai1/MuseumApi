insert into Museum (id, museum_name, location, curator, total_number_of_art_work)
    values (4, 'Victoria and Albert Museum', 'London', 'Joanna Norman', 70000);
insert into Museum (id, museum_name, location, curator, total_number_of_art_work)
    values (5, 'The National Gallery', 'London', 'Gabriele Finaldi', 80000);
insert into Museum (id, museum_name, location, curator, total_number_of_art_work)
    values (6, 'National Portrait Gallery', 'London', 'Bree Pickering', 50000);
insert into Museum (id, museum_name, location, curator, total_number_of_art_work)
    values (8, 'Louvre Museum', 'Paris', 'Jean-Luc Martinez', 40000);

insert into Artist (id, artist_name, year_born, year_down, number_of_work, museum_id)
    values (4, 'John Constable', '11 June 1776', '31 March 1837', 100, 4);
insert into Artist (id, artist_name, year_born, year_down, number_of_work, museum_id)
    values (5, 'Dante Gabriel Rossetti', '12 May 1828', '9 April 1882', 50, 4);
insert into Artist (id, artist_name, year_born, year_down, number_of_work, museum_id)
    values (6, 'Artist Unknown', 'Unknown', 'Unknown', 100, 8);
insert into Artist (id, artist_name, year_born, year_down, number_of_work, museum_id)
    values (8, 'Gian Lorenzo Bernini', '7 December 1598', '28 November 1680', 200, 8);

insert into Art (id, name, location, artist_id, artist_name, art_type, year_completed, medium, backstory)
    values (4, 'Salisbury Cathedral from the Bishops Grounds', 'London', 4, 'John Constable', 'Painting', '1823', 'Oil in canvas', 'The artist selected a viewpoint from the bishop''s garden (the south-east) and returned in 1820 to make further drawings and an open-air oil sketch, now in the National Gallery of Canada in Ottawa,[3] which served as the model for the London version.');
insert into Art (id, name, location, artist_id, artist_name, art_type, year_completed, medium, backstory)
    values(5, 'The Day Dream', 'London', 5, 'Dante Gabriel Rossetti', 'Painting', '1880', 'Oil in canvas', 'During 1878 Rossetti completed a chalk sketch of Morris,[1] his secret lover, whom he had met at the Theatre Royal, Drury Lane, in 1857.[2] She was the model for several of his well-known paintings');
insert into Art (id, name, location, artist_id, artist_name, art_type, year_completed, medium, backstory)
    values (6, 'Winged Victory Of Samothrace', 'Paris', 6, 'Unknown', 'Sculpture', '190 BC', 'Parian marble', 'Its the greatest sculpture in the Louvre, which makes it one of the greatest in history. It’s rivaled by few with the exception of possibly the Lacöon Group in the Vatican Museums and David in Accademia.');
insert into Art (id, name, location, artist_id, artist_name, art_type, year_completed, medium, backstory)
    values (8, 'Sleeping Hermaphrodite On Bed', 'Paris', 8, 'Gian Lorenzo Bernini', 'Sculpture', 'Unknown', 'White marble', 'A hermaphrodite, in classical reference, is a female in appearance and swagger who possesses the “bits and pieces” of a male. Ancient Mediterraneans celebrated and sculpted the hermaphrodite as if she/he were a unicorn today.');

insert into Painting (id, number_of_paintings_by_given_artist, style, museum_paintings_id)
    values (5, 5000, 'Impressionist', 4);
insert into Painting (id, number_of_paintings_by_given_artist, style, museum_paintings_id)
    values (6, 6000, 'Impressionist', 5);
insert into Painting (id, number_of_paintings_by_given_artist, style, museum_paintings_id)
    values (8, 7000, 'Abstract', 5);

insert into Sculpture (id, number_of_sculptures_by_given_artist, museum_sculptures_id)
    values (6, 1000, 8);
insert into Sculpture (id, number_of_sculptures_by_given_artist, museum_sculptures_id)
    values (8, 2000, 5);