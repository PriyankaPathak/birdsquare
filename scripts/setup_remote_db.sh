scp database/data.csv root@$1.birdsquare.in:/tmp
scp database/populate_data.sql root@$1.birdsquare.in:/tmp

ssh -t root@$1.birdsquare.in mysql -uroot < "database/create_schema.sql"
ssh -t root@$1.birdsquare.in 'cd /tmp && mysql -uroot --local-infile < "populate_data.sql"'

# copy populate sql script to remote server
# run mysql and use that populate script that was copied to the server

