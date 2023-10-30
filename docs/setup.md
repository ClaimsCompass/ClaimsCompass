# Spring Boot Setup
* First, navigate to [https://start.spring.io/](https://start.spring.io/). Select "Maven"
  under Project, "Java" under Language and 3.1.4 (latest stable release as of 2023-10-01)
  for the version of Spring Boot.
* Dependencies are:
    * Rest Repositories
    * MongoDB
    * Web
    * JPA
    * Thymeleaf
    * PostgreSQL Driver
* Click generate to create the project, you will get a zip file containing the entire project
  with proper dependencies
* Guide to understanding maven project structure https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html.
* Mongo with Spring Data REST https://spring.io/guides/gs/accessing-mongodb-data-rest/.
* https://hackernoon.com/using-postgres-effectively-in-spring-boot-applications -> psql with
* Postgres quick start https://developer.fedoraproject.org/tech/database/postgresql/about.html
* https://docs.fedoraproject.org/en-US/quick-docs/postgresql/

# Postgresql Setup
* Install postgres using your favourite package manager
* Helpful windows instructions: https://www.datacamp.com/tutorial/installing-postgresql-windows-macosx
* Mac: Follow guide here or you can install with `brew install postgresql` https://www.postgresql.org/download/macosx/.
* Windows: You can get the graphical installer here: https://www.postgresql.org/download/windows/
* Try to get postgres running, not sure how this will work on windows.
* Create a user that matches our database owner (for now just make it "securian", and keep password
  as "hello".
* Create a table that matches the one we use (will temporarily be named "claimsdb"
```sh
# For mac
sudo -u postgres psql

# Should be in postgres prompt now
postgres=#CREATE USER securian WITH PASSWORD 'hello';
postgres=#CREATE DATABASE claims_db OWNER securian;
```
* Now build and run the Maven project in Intellij, it should *hopefully* work out of the box, and we'll have
  a server running with a very barebones ReST API that was totally not taken from a tutorial.
* If you see something like "Ident authentication failed for user securian" after trying to run postgres, 
  you will need to change one of the config files for postgres. Follow this stack overflow answer
  https://stackoverflow.com/questions/18664074/getting-error-peer-authentication-failed-for-user-postgres-when-trying-to-ge
