[![CI Pipeline](https://github.com/dominikcebula/reverse_polish_notation/actions/workflows/maven.yml/badge.svg)](https://github.com/dominikcebula/reverse_polish_notation/actions/workflows/maven.yml)

# Reverse Polish Notation

## Intro

This code contains implementation of Reverse Polish Notation in Java as Maven Project.

## Compilation

To compile project execute:
```
mvn clean install
```

This will generate jar with dependencies in location:
```
target/rpn-1.0-SNAPSHOT-jar-with-dependencies.jar
```

## Execution by Maven

You can execute project by maven with this command:
```
mvn exec:java -Dexec.args="3 4 5 - +"
```

## Execution by CLI

After compilation, you can go into target directory and run application in following way:
```
java -jar rpn-1.0-SNAPSHOT-jar-with-dependencies.jar 3 4 5 - +
```
