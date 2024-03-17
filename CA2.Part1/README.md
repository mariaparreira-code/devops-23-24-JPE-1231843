# Technical Report for Class Assignment 1

## Introduction

This is a technical report for de Class Assignment 2 about **Gradle** (a build automation tool that is designed to automate the building, testing, publishing, and deployment of software projects), made by Maria Parreira n.º 1231843, ISEP and Switch student.

This report provides a detailed account of the steps taken to complete the assignment, including the commands used, the issues encountered, and the solutions implemented.

To support this assignment will be used an example application : gradle_basic_demo.

(source code available at https://bitbucket.org/pssmatos/gradle_basic_demo/)

## Gradle Tutorial

Description of the steps used to achieve the requirements using Git and Gradle and its commands.

1.Add a new task to execute the server:
```bash
task runServer(type: Exec) {
    commandLine 'java', '-jar', 'build/libs/basic_demo-0.1.0.jar'
}
```

2.Add a simple unit test: 

```bash
public class AppTest {
    @Test public void testAppHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting()); }
}
```
3.Add a new task of type Copy:

```bash
task backup(type: Copy) {
    from 'src'
    into 'backup'
}
```

4.Add a new task of type Zip
```bash
task archive(type: Zip) {
    from 'src'
    archiveFileName = "app-source.zip"
    destinationDir = file('archives')
}
```
5.At the end of the part 1 of this assignment mark your repository with the tag:

```bash
ca2-part1
```


ys
![gradle.png](images/gradle.png)
from:https://tomgregory.com/gradle/gradle-tutorial-for-complete-beginners/