# Iress Coding Challenge

## Problem statement
Create a toy robot application in which the robot is allowed to freely move on a table top. The following commands are
allowed on the toy robot:

```
PLACE X,Y,F
MOVE
LEFT
RIGHT
REPORT
```

The robot should be smart enough so that it doesn't fall off the table. 

Robot should be initialised first with the
```PLACE``` command until any other commands are accepted.

Any other commands are ignored by program. Commands are expected to be in CAPS, otherwise the command will be ignored.

---
# System requirement
- [JDK 1.8](https://www.oracle.com/au/java/technologies/javase/javase-jdk8-downloads.html)
- [Maven](https://maven.apache.org/install.html)

# How to run the project
The program takes a csv file as input. For example, see ```src/main/resources/example.csv```

To build the project into jar:
```shell
mvn package
```

To run the project once build is successful:
```shell
java -jar [jar] [threshold] [file]
```

For example:
```shell
java -jar target/toy-robot-0.0.1-SNAPSHOT.jar src/main/resources/example.csv
```

If the toy robot's ```REPORT``` is issued in csv, output similar to the following will be displayed:
```
Robot is currently at 0,1,NORTH
```

#### Debugging in IDE
To run application from your IDE, check out this [link](https://www.baeldung.com/java-command-line-arguments)
on how to set up command line arguments in editor.