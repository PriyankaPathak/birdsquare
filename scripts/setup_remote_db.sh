ssh -t root@$1.birdsquare.in mysql -uroot < "database/create_schema.sql"

# copy populate sql script to remote server
# run mysql and use that populate script that was copied to the server

