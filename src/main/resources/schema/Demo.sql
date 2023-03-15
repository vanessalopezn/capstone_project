insert into role values ("ADMIN");
insert into role values ("USER");
insert into users_roles values (1,2);

insert user values (1,'vlopez@test.com','Vanessa','Lopez','$2a$11$jglOxN4RNzJZo0MkixaDme8j/Imqp7/aUEBxLcVdeaMvVrVO9Pwd2');

insert into national_park_visit values (1,'2019-07-20', 56, '2019-07-21');
insert into national_park_visit values (2,'2020-06-26', 54, '2020-06-28');
insert into national_park_visit values (3,'2021-07-20', 48, '2021-07-22');
insert into national_park_visit values (4,'2021-07-23', 50, '2021-07-25');
 
insert into user_visits values (1, 1);
insert into user_visits values (1, 2);
insert into user_visits values (1, 3);
insert into user_visits values (1, 4);
 
 
insert into visit_media values (1, 'Olympic','1_ol.jpg', 1);
insert into visit_media values (2, 'Olympic','2_ol.jpg', 1);
insert into visit_media values (3, 'Olympic','3_ol.jpg', 1);
insert into visit_media values (4, 'Olympic','4_ol.jpg', 1);

insert into visit_media values (5,'Lake in Mount Rainier','1_mr.jpg',2);
insert into visit_media values (6,'Mount Rainier View','2_mr.jpg',2);
insert into visit_media values (7,'Mount Rainier View with flowers','3_mr.jpg',2);
 
insert into visit_media values (8, 'Bryce Canyon','1_bc.jpg', 3);
insert into visit_media values (9, 'Bryce Canyon','2_bc.jpg', 3);
insert into visit_media values (10, 'Bryce Canyon','3_bc.jpg', 3);
insert into visit_media values (11, 'Bryce Canyon','4_bc.jpg', 3);

insert into visit_media values (12,'Capitol Reef','1_cr.jpg',4);
insert into visit_media values (13,'Capitol Reef','2_cr.jpg',4);
insert into visit_media values (14,'Capitol Reef','3_cr.jpg',4);

