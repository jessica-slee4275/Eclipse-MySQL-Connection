# Eclipse-MySQL-Connection
Download mysql https://www.mysql.com/  
Set environment variables -> path (ex. C:\Program Files\MySQL\MySQL Server 8.0\bin)  

# In Cmd, start mysql (ex. mysql -uroot -p and input password)
create database [database name];  
use [database name];  
create table [table name] etc..  

# In Eclipse,
Start eclipse and create 'Dynamic Web Project'  
Copy jar file in Connector J (ex. C:\Program Files (x86)\MySQL\Connector J 8.0\mysql-connector-java-8.0.19.jar)  
Paste jar file in WebContent\WEB-INF\lib  
'Window' -> 'Show View' -> 'Data Source Explorer'  
Right click 'DataBase Connection' and 'new' Select 'MySQL'and change name  
Select MySQL JDBC Drivers and input exist database name in 'database' and 'url'  
Test Connection  
