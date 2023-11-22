# ClaimsCompass
Created by Andrew Xie, Derek Hyunh, Krisha Kalsi, Maryam Taj, and Pratibha Thakur, along with the help of the University of Toronto's Technology Leadership Initiative professors and teaching assistants.

A service to optimize the creditors insurance claims processing through categorizing claims by complexity and urgency, and through a dashboard allowing employees responsible for processing claims to view key details and GPT-generated claims insights at a glance.
Our dashboard-based web application provided an alternative to the existing 'Queue-based' claims processing system. It will allow Securian employees to prioritise the most urgent and complex claims which require more attention and resources while simultaneously keeping track of more straightforward claims.

1. [Installation](#installation)
2. [Usage](#usage)
3. [Features](#features)
4. [Contributing](#contributing)
5. [Documentation](#documentation)
6. [License](#license)
7. [Roadmap](#roadmap)
8. [Credits](#credits)
9. [Support](#support)
10. [Examples or Screenshots](#examples-or-screenshots)
11. [FAQ](#faq)
12. [Contact Information](#contact-information)

## Installation<a name="installation"></a>

Instructions on how to install and configure the project.

Prerequisites: Have a working installation of postgresql and Java 17 SDK and JDK.
Optional steps for installing postgres are included in case they are not available.

### PostgreSQL Setup<a name="postgres-setup"></a>
1. If you don't have it, install postgresql using your favourite package manager, version should be
15+.

OSX
```sh
brew install postgresql@15
```

Ubuntu
```sh
sudo apt-get install postgresql-15
```

If you would like, you can also let the postgres service run on boot:

Linux (with systemd)
```sh
sudo systemctl enable postgresql
```

Or manually initialize it:
```
sudo systemctl start postgresql
```

You can check that this has been successfully done by running:

```
sudo systemctl start postgresql
```

2. Create a user that matches our database owner (for now just make it "securian", and keep password
  as "hello".
```sh
# For mac + linux
sudo -u postgres psql

# Should be in postgres prompt now
postgres=#CREATE USER securian WITH PASSWORD 'hello';
postgres=#CREATE DATABASE claimscompassmain OWNER securian;
```
* If you see something like "Ident authentication failed for user securian" after trying to run psql, you will need to change one of the config files for postgres. 
* Follow this stack overflow answer https://stackoverflow.com/questions/18664074/getting-error-peer-authentication-failed-for-user-postgres-when-trying-to-ge

3. Create a data base and corresponding tables filled with dummy data.
```sh
# From the source directory
psql -U securian -d claimscompassmain -f schema/claims_table.sql
psql -U securian -d claimscompassmain -f schema/examiner_table.sql
```

### Java Setup<a name="java-setup"></a>
Assuming you have the proper version installed for Java, all you need to do is run the jar file,
which is currently located in `targets/` and named `creditcompass-0.0.1-SNAPSHOT.jar` (subject to change). To do so, all you need to do is run the following command in the project's root 
directory:

NOTE: You should have a postgresql daemon running, see the steps above to ensure that.

```sh
java -jar creditcompass-0.0.1-SNAPSHOT.jar
```

and the app should be running on the standard 8080 port, which you can access by entering
`localhost:8080` in your web browser of choice. 

## Usage<a name="usage"></a>
Usage of the project.

## Features<a name="features"></a>

List of the key features of the project.

## Contributing<a name="contributing"></a>

Information on how to contribute to the project.

## Documentation<a name="documentation"></a>

Links to or explanations of project documentation.

## License<a name="license"></a>

'MIT License' is a permissive, open-source software license. It allows users to use, copy, modify, merge, publish, distribute, sublicense, and sell copies of the software, provided that the license and copyright notice must be included in all copies or substantial portions of this MIT-licensed software

## Roadmap<a name="roadmap"></a>

Outline of the project's future plans and development goals.

## Credits<a name="credits"></a>

Acknowledgments for contributors, libraries, or tools.

## Support<a name="support"></a>

Information on seeking help and reporting issues.

## Examples or Screenshots<a name="examples-or-screenshots"></a>

Visuals or links to live demos if applicable.

## FAQ<a name="faq"></a>

Answers to frequently asked questions.

## Contact Information<a name="contact-information"></a>

Ways to contact project maintainers.

## Acknowledgments<a name="acknowledgments"></a>

Special thanks or acknowledgments.

## Changelog<a name="changelog"></a>

A record of changes and updates to the project.
