# Dinastia Tudorilor ISS
Dinastia Tudorilor repo for ISS Project regarding a *Conference Manangement System*

## Content

* *diagrams/* -- all of our diagrams
* *app/* -- our current app
* *cms/* -- first structure (failed)
* *old_app/* -- second structure (failed)

## Requirements

* [Java JDK 13](https://www.oracle.com/java/technologies/javase-jdk13-downloads.html) (JDK 11 should work too)
* [Tomcat 9.0.34](https://tomcat.apache.org/download-90.cgi)
* [NodeJS 12.16.1](https://nodejs.org/en/) (LTS should work too)
* Angular CLI 9.1.1 (see below)

Install Angular 9 locally (run command inside project)

```console
> npm install @angular/cli@9.1.1
```

* [PostgreSQL 12](https://www.postgresql.org/download/)

For now, a *local postgresql* database is required in order to run the current application.

```config
database: catalogngjpa
user: postgres
password: admin
```

## Setup

1. Open [app/](app) project with IntelliJ
2. Create *Tomcat Local Server* configuration
![Image](https://i.imgur.com/zrnLDba.png)
3. Start Tomcat Server from IntelliJ
4. Go inside [webapp/](app/app-web/src/main/webapp) directory and install dependencies by running `npm install`
5. Start Angular by running `ng serve`
