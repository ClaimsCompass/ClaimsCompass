# ClaimsCompass
Created by Andrew Xie, Derek Hyunh, Krisha Kalsi, Maryam Taj, and Pratibha Thakur. We would also like to appreciate University of Toronto's Technology Leadership Initiative team, particularly Mike McCarthy, Paul Gries, Gabe Guralnick and Jia Hao Choo. 

Claims Compass is a triaging system that organizes claims based on urgency and complexity. Thus, claim examiners can address complex claims faster and fast-track simpler claims. We used technologies such as React, Java Spring, and PostgreSQL. We would like to acknowledge MaterialUI's templates for the frontend: https://demos.adminmart.com/free/nextjs/modernize-nextjs-free/landingpage/index.html  


1. [Installation](#installation)
2. [License](#license)

## Installation<a name="installation"></a>

You can access Claims Compass here:

### Running Locally:

PostgreSQL Setup:
1. Install postgreSQL version 15+ using your favourite package manager.

macOS:
```sh
brew install postgresql@15
```

Ubuntu:
```sh
sudo apt-get install postgresql-15
```

You can also let the postgres service run on boot:

Linux (with systemd)
```sh
sudo systemctl enable postgresql

# You can also manually initialize it:
sudo systemctl start postgresql

# You can check that it has been successfully initialized by running:
sudo systemctl start postgresql
```

2. Create a user that has the owner "securian" and password "hello".
```sh
# macOS + Linux:
sudo -u postgres psql

postgres=#CREATE USER securian WITH PASSWORD 'hello';
postgres=#CREATE DATABASE ClaimsCompassMain OWNER securian;
```
* Note: If you see "Ident authentication failed for user securian", follow this stack overflow post:
https://stackoverflow.com/questions/18664074/getting-error-peer-authentication-failed-for-user-postgres-when-trying-to-ge

3. Create a database and populate it with dummy data using the following commands. Note: In the claim table, modify the creation date to the current date. 
```sh
# From the source directory
psql -U securian -d ClaimsCompassMain -f schema/claim.sql
psql -U securian -d ClaimsCompassMain -f schema/claimexaminer.sql
```

### Java Setup<a name="java-setup"></a>
Assuming you have Java installed, you just need to run the jar file currently located in `targets/` and named `creditcompass-0.0.1-SNAPSHOT.jar`. To do so, run the following command in the project's root directory:
NOTE: You should have a postgresql daemon running. If this is not true, follow the steps above.

```sh
java -jar creditcompass-0.0.1-SNAPSHOT.jar
```

The app should be running on the standard 8080 port, and you can access it by entering`localhost:8080` in your web browser. 


## License<a name="license"></a>

'MIT License' is a permissive, open-source software license. It allows users to use, copy, modify, merge, publish, distribute, sublicense, and sell copies of the software, provided that the license and copyright notice must be included in all copies or substantial portions of this MIT-licensed software.

