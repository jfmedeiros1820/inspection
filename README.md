# Inspection Application

## About
Application created to inspect pieces of metal to identify spots and its characteristics using only Java EE native tools.

## Tools
[Jersey](https://jersey.github.io/) - Jersey framework is more than the JAX-RS Reference Implementation. Jersey provides it’s own API that extend the JAX-RS toolkit with additional features and utilities to further simplify RESTful service and client development

[Grizzly](https://javaee.github.io/grizzly/) - Grizzly’s goal is to help developers to build scalable and robust servers using NIO as well as offering extended framework components: Web Framework (HTTP/S), WebSocket, Comet, and more!

[SLF4J](https://www.slf4j.org/) - The Simple Logging Facade for Java (SLF4J) serves as a simple facade or abstraction for various logging frameworks (e.g. java.util.logging, logback, log4j) allowing the end user to plug in the desired logging framework at deployment time.

[JUnit 4](https://junit.org/) - Unit is a test framework which uses annotations to identify methods that specify a test.

[PowerMock](https://powermock.github.io/) - PowerMock is a Java framework that allows you to unit test code normally regarded as untestable.

[Apache Maven](https://maven.apache.org/) - Apache Maven is a software project management and comprehension tool. Based on the concept of a project object model (POM), Maven can manage a project's build, reporting and documentation from a central piece of information.

## Installation
Install the project:

`mvn install`

## Run the project:
Execute class: ```Main.java```

## Request Example
### Inspect Piece:
URI: `http://localhost:8080/spot_check`

Method: `POST`

Content-Type: `application/json`

Body: 
```
{
    "squares": "[[1,1,0,0],[1,1,0,0],[0,0,1,1],[0,0,1,1]]"
}
```

## Unit Tests

`mvn test`
