# Movies challenge project - back end

## Back-end

The back end stores its data in a MySQL database via a java application served by the Tomcat web server.
The scripts to create the database and add some sample data are included in the root folder of the repo.
The java app was built with Eclipse (Dynamic web project).
The java app uses Hibernate to handle database communication and Jersey to expose web services. 
The file 'src\hibernate.cfg.xml' contains the configuration info to access the database.
Errors are logged in to file 'z_log.txt' (When the WAR is deployed Tomcat places it in its bin folder). 
Project libraries are included in the repo, because the Dynamic web project does not have a system to automatically download libraries.

## Build Tools
JDK v1.8
Eclipse EE 2019-09 (installed with JAVA EE edition)
JBoss Tools (Eclipse plugin)

## Dependencies
MySQL
JAVA v1.8
Apache-Tomcat v9
