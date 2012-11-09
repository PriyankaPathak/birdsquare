scp -r artifacts/database root@$1.birdsquare.in:/usr/local/

ssh -t root@$1.birdsquare.in mysql -uroot < "database/create_schema.sql"
ssh -t root@$1.birdsquare.in mysql -uroot --local-infile < "/usr/local/database/populate_data.sql"
