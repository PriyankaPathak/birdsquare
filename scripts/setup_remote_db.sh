ssh -t root@$1.birdsquare.in mysql -uroot < "database/create_schema.sql"
ssh -t root@$1.birdsquare.in mysql -uroot --local-infile < "database/populate_data.sql"