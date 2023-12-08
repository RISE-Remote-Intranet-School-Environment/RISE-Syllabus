# RISE-Syllabus

# Table of contents

* [Project participants](#project-participants)
* [About the project](#question-about-the-project)
* [Getting started](#rocket-getting-started)
    * [Frameworks](#zap-frameworks)
    * [Prerequesites](#exclamation-prerequesites)
* [Test](#test)
* [Documentation](#documentation)
* [Tree structure](#deciduoustree-tree-structure)
* [API](#boom-api)

## **Project participants**

### 2023-24

- Van Olffen Victor 20253
- Maillard Corentin 21306
- Mettioui Mourad 195019

### 2022-23

- Kuijpers Nick 20324
- Baudouin Losseau 19593
- Quentin Jadoul 18155
- Theo Engels 195367

## :question: About the project

The purpose of this project is to allow students to buy syllabus online using our API.

## :rocket: Getting started

### :zap: Frameworks

The project is built using the **Java Programming Language** under the **Spring Boot** framework.

Spring Boot is a framework used to build stand-alone application and production ready spring applications. It facilitates the way to launch and deploy API REST based application without huge configurations.

For more information about Spring Boot, view the [official documentation][spring-boot].

### :exclamation: Prerequesites

Before launch the application, you have to satisfy the following requirements.

You need to use IntelliJ in order to use Java and [Maven][maven].

[Git][git] must be installed and configured on your machine in order to clone the repository and pull the new updates.

A [MySql][mysql] server must be installed on your machine so that the application can connect to the database. It is recommended to have a good knowledge of relational databases. Click here to download [MySql community server][mysql-download].

In MySQL Workbench, import the SQL files located in /Assets/Sylla/ in a schema called "syllabus".

When you have succesfully imported the database and cloned the repository, you have to run the file "SyllaApplication" located in "sylla/src/main/java/com/RISE/sylla/SyllaApplication.java".

You can test that the application is running properly with postman. 
For example, use a GET request with the link "http://localhost:8081/users" to return all the users from the database.

## TEST

The Unit-tests are made on src/test/java/com/RISE/sylla.java you can run this javaClass to verify the status of the test.

## DOCUMENTATION

The documentation for this Java program is generated using the JavaDoc tool. 
You can see there the goal of each function, the params they need and what they return.

To generate the documentation, follow these steps:

-Open the project in IntelliJ IDEA. \
-Click on the "Generate JavaDoc" button in the toolbar (as shown in the image you provided). \
-Specify the output directory \
-Click "OK" to generate the documentation. \
-The documentation will be generated in HTML format, and can be viewed by opening the index.html file in a web browser. \

You can generated this documentation in intellij \
![image](https://user-images.githubusercontent.com/67092457/206734346-17a032eb-96a4-48f8-8d07-697ed877d6ef.png) \
We generate the documentation at the end of our project but you can do it by yourself 

Download the repository and open one html file the open this documentation \

## :deciduous_tree: Tree Structure

```bash
RISE-Syllabus
    ├───.mvn
    │   └───wrapper
    ├───Assets
    │   ├───javaDoc
    │   └───Sylla
    └───src
        ├───main
        │   ├───java
        │   │   └───com
        │   │       └───RISE
        │   │           └───sylla
        │   │               ├───controller
        │   │               ├───model
        │   │               ├───repository
        │   │               └───service
        │   └───resources
        │       └───static
        └───test
            └───java
                └───com
                    └───RISE
                        └───sylla
```

## :boom: API

For our API, we did all our tests using Postman. Then, we exported the Postman Collection v2.1 as a JSON file.
Finally, we converted the Postman Collection v2.1 to OpenAPI v3.0. Detailed instructions can be found in this [repository][postman-to-openapi].

The resulting OpenAPI schema is in [schema.yaml][open-api-schema].

With the schema generated, we host our API documentation online using [Stoplight][stoplight]. The documentation is available at [API online documentation][api-documentation].

<!-- Internal file links -->
[open-api-schema]: ./schema.yaml

<!-- Links -->
[spring-boot]: https://spring.io/projects/spring-boot
[maven]: https://www.jetbrains.com/help/idea/maven-support.html
[git]: https://git-scm.com/
[mysql]: https://www.mysql.com
[mysql-download]: https://dev.mysql.com/downloads/mysql/
[postman-to-openapi]: https://github.com/joolfe/postman-to-openapi
[stoplight]: https://stoplight.io/
[api-documentation]: https://rise-syllabus.stoplight.io/docs/rise-syllabus/y56oaj5r29p3c-rise-syllabus
