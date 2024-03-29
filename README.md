# RISE-Syllabus

[![Java CI with Maven](https://github.com/RISE-Remote-Intranet-School-Environment/RISE-Syllabus/actions/workflows/maven.yml/badge.svg)](https://github.com/RISE-Remote-Intranet-School-Environment/RISE-Syllabus/actions/workflows/maven.yml)
![GitHub contributors](https://img.shields.io/github/contributors/RISE-Remote-Intranet-School-Environment/RISE-Syllabus?color=blue)
![GitHub issues](https://img.shields.io/github/issues/RISE-Remote-Intranet-School-Environment/RISE-Syllabus?color=orange)

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

When you have succesfully imported the database and cloned the repository, you have to run the file "SyllaApplication" located in "src/main/java/com/RISE/sylla/SyllaApplication.java".

You can test that the application is running properly with postman.

[<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">][postman]

To update the collection, you can create a fork so that you will have a copy in your workspace :

![img.png](img.png)

For example, use a GET request with the link "http://localhost:8081/users" to return all the users from the database.

## TEST

If you have maven install, you can run the test with the command
```bash
mvn test
```
If you don't have maven installed you can run them manually by right clicking on "com.RISE.sylla" and "Run 'Tests' in 'sylla'"

![image](https://github.com/RISE-Remote-Intranet-School-Environment/RISE-Syllabus/assets/33122169/63f040d6-9dd9-4831-8cec-df9983a79c4b)

The test use a 'mock' that will simulate objects that mimic the behavior of real objects.

Then we will use the 'when' and '.thenReturn' that will create a mock of the model created previously in the code.

Lastly whe can verify that the HTTP request gives us the model contained in the mock, add a new model or even delete an existing one from the mock.

Example annotations for [DeleteCourseTest](https://github.com/RISE-Remote-Intranet-School-Environment/RISE-Syllabus/blob/main/src/test/java/com/RISE/sylla/DeleteCourseTest.java) :
- @Mock : It is used to mock the "CourseService" dependency
- @InjectMocks : It injects the mocked "CourseService" into the "CourseController"
- @BeforeEach : This method is annotated with @BeforeEach to set up the test environment before each test method is executed
- @Test : Define the test that will be executed

What is important the remember is that we are NOT using the database directly but we are creating simulated objects.

## DOCUMENTATION

The documentation for this Java program is generated using the JavaDoc tool. 
You can see there the goal of each function, the params they need and what they return.

To generate the documentation, follow these steps:

- Open the project in IntelliJ IDEA.
- Click on "Tools" in the toolbar, then "Generate javaDoc" (as shown in the image below).
- Below "JavaDoc Scope", choose "Whole project"
- Specify "...\RISE-Syllabus\Assets\javaDoc" as the output directory
- Click "GENERATE" to generate the documentation
- The documentation will be generated in HTML format, and can be viewed by opening the file "Assets/javaDoc/index.html" in a web browser

![image](https://user-images.githubusercontent.com/67092457/206734346-17a032eb-96a4-48f8-8d07-697ed877d6ef.png)

Download the repository and open any html file located in "Assets/javaDoc" to open the documentation.

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
[postman]: https://app.getpostman.com/run-collection/26399586-f5f0bd29-b3d8-41a2-a0b5-32077e4372b4?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D26399586-f5f0bd29-b3d8-41a2-a0b5-32077e4372b4%26entityType%3Dcollection%26workspaceId%3Da100556f-1a58-406a-86b4-fb8e148963c0
[git]: https://git-scm.com/
[mysql]: https://www.mysql.com
[mysql-download]: https://dev.mysql.com/downloads/mysql/
[postman-to-openapi]: https://github.com/joolfe/postman-to-openapi
[stoplight]: https://stoplight.io/
[api-documentation]: https://rise-syllabus.stoplight.io/docs/rise-syllabus/y56oaj5r29p3c-rise-syllabus
