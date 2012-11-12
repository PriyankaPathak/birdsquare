use birdsquare;


load data local infile 'data.csv'
into table bird
fields terminated by ','
enclosed by '"'
lines terminated by '\n'
(common_name, scientific_name, family_name, order_name);



