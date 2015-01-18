use cinematickets;

insert into movies (actors, description, directors, duration, imageURL, language, rating, releaseDate, title)
values ('Marlon Brando, Al Pacino, James Caan', 
'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.',
'Francis Ford Coppola', 120,'/pictures/godfather.jpg' ,'ENGLISH', 9.2, current_date(), 'Godfather'),
(' Matthew McConaughey, Anne Hathaway', 
'A team of explorers travel through a wormhole in an attempt to ensure humanity''s survival.',
'Christopher Nolan', 169,'/pictures/interstellar.jpeg' ,'ENGLISH', 8.9, current_date(), 'Interstellar'),
('Martin Freeman, Ian McKellen, Richard Armitage', 
'A reluctant hobbit, Bilbo Baggins, sets out to the Lonely Mountain with a spirited group of dwarves to reclaim their mountain home - and the gold within it - from the dragon Smaug.',
'Peter Jackson', 169,'/pictures/hobbit-poster.jpeg' ,'ENGLISH', 8.0, current_date(), 'The Hobbit: An Unexpected Journey'),
('Martin Freeman, Ian McKellen, Richard Armitage', 
'The dwarves, along with Bilbo Baggins and Gandalf the Grey, continue their quest to reclaim Erebor, their homeland, from Smaug. Bilbo Baggins is in possession of a mysterious and magical ring.',
'Christopher Nolan', 161,'/pictures/hobbit-poster.jpeg' ,'ENGLISH', 9.2, current_date(), 'The Hobbit: The Desolation of Smaug'),
('Martin Freeman, Ian McKellen, Richard Armitage', 
'The dwarves, along with Bilbo Baggins and Gandalf the Grey, continue their quest to reclaim Erebor, their homeland, from Smaug. Bilbo Baggins is in possession of a mysterious and magical ring.',
'Christopher Nolan', 161,'/pictures/hobbit-poster.jpeg' ,'ENGLISH', 9.2, current_date(), 'The Hobbit: The Battle of the Five Armies'),
('James Franco, Seth Rogen', 
'Dave Skylark and producer Aaron Rapoport run the celebrity tabloid show "Skylark Tonight." When they land an interview with a surprise fan.',
'Evan Goldberg, Seth Rogen', 112,'/pictures/the-interview.jpg' ,'ENGLISH', 7.1, current_date(), 'The Interview'),
('Benedict Cumberbatch, Keira Knightley', 
'During World War II, mathematician Alan Turing tries to crack the enigma code with help from fellow mathematicians.',
'Morten Tyldum', 114,'/pictures/imitation-game.jpg' ,'ENGLISH', 8.2, current_date(), 'The Imitation Game');

select * from movies;

