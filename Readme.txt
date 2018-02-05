1) check out the project from : https://github.com/luatnguyen1979/asd/tree/bookingframework

2) https://github.com/luatnguyen1979/asd/tree/bookingframework/dist
- booking.war
- myconfig.properties
- booking.sql

3) Modify the myconfig.properties as following:
	- javabase.jdbc.url=jdbc:mysql://localhost:3306/booking?useSSL=false
	- jdbc.username = root
	- jdbc.password = root
	
	* base on this configuration you need to create the database name "booking".
	* the username is root (you can change if you have difference username)
	* password is root. (based on your user's password)
4) copy "myconfig.properties" to ...Tomcat/conf folder

5) run the script "booking.sql" in MySQL to import data and structure

6) Deploy the booking.war to tomcat server.

7) Launch the application at http://localhost:8080/booking (the port is depended on your tomcat server is using)

8) by default we initial 3 credentials in "initial_data.sql"
- luatnguyen/123
- kimtey/123
- enkh/123
 
	

	