# Technical Report for Class Assignment 4 Part 2

## Introduction

- This tutorial aims to demonstrate how to set up a **Dockerized environment** to run the basic Spring application using Gradle, as requested in the assignment. 
- In this tutorial, will be used **Docker** and **Docker Compose** to create two services: one to run the Spring application and another to run the H2 Database server.

- ### Requirements

1. [Docker](https://www.docker.com) installed on your machine
2. [Docker Hub](https://hub.docker.com) account (if you want to publish the images)


### The report is divided into sections:

1. **Clone the Repository**
2. **Dockerfile for Web Service**
3. **Dockerfile for Database Service (H2)**
4. **Docker Compose**
5. **Build and Run the Containers**
6. **Accessing the Application and Database**
7. **Kubernetes**


## Step 1: Clone the Repository

- Clone the repository with the Spring application:

```bash

git clone https://github.com/mariaparreira-code/devops-23-24-JPE-1231843.git
```

## Step 2: Dockerfile for Web Service

```Dockerfile
FROM openjdk:17-jdk-slim

# Install Git
RUN apt-get update && apt-get install -y git

# Set the working directory
WORKDIR /CA4/Part1

# Clone the repository
RUN git clone https://github.com/mariaparreira-code/devops-23-24-JPE-1231843.git

# Set the working directory for the cloned application
WORKDIR /CA4/Part1/devops-23-24-JPE-1231843/CA2.Part2/demoWithGradle

# Grant execution permission to the Gradle script
RUN chmod +x gradlew

# Build the application
RUN ./gradlew build

# Command
CMD ["./gradlew", "bootRun"]
```

## Step 3: Dockerfile for Database Service (H2)

```Dockerfile
FROM openjdk:17-jdk-slim

# Install Git
RUN apt-get update && apt-get install -y git

# Set the working directory
WORKDIR /CA4/Part1

# Clone the repository
RUN git clone https://github.com/mariaparreira-code/devops-23-24-JPE-1231843.git

# Set the working directory for the cloned application
WORKDIR /CA4/Part1/devops-23-24-JPE-1231843/CA2.Part2/demoWithGradle

# Grant execution permission to the Gradle script
RUN chmod +x gradlew

# Build the application
RUN ./gradlew build

# Command
CMD ["./gradlew", "bootRun"]
```

## Step 4: Docker Compose

- Create a docker-compose.yml file with the following configuration:

```yml
version: '3'  # Specify the version of the Docker Compose file format

services:  # Define the services that make up the application

  db:  # Define the database service
    build:  
      context: .  # Use the current directory as the build context
      dockerfile: DockerfileDb  
    container_name: database  # Name the container as "database"
    ports:  # Map the container's ports to the host
      - "8082:8082"  # Map port 8082 on the host to port 8082 in the container (for H2 console)
      - "9092:9092"  # Map port 9092 on the host to port 9092 in the container (for H2 database connections)
    environment:  # Set environment variables for the container
      - H2_OPTIONS=-tcp -tcpAllowOthers -ifNotExists  # Configure H2 database options to allow TCP connections
    volumes:  
      - h2-data:/opt/h2-data  # Mount the "h2-data" volume to /opt/h2-data in the container to persist H2 database data

  web:  # Define the web application service
    build: 
      context: .  # Use the current directory as the build context
      dockerfile: DockerfileWeb  # Specify the Dockerfile to use for building the web application image
    container_name: spring-web-application 
    ports: 
      - "8080:8080"  # Map port 8080 on the host to port 8080 in the container (for the Spring Boot application)
    environment: 
      - SPRING_DATASOURCE_URL=jdbc:h2:tcp://database:9092/./jpadb  # Configure Spring Boot to use the H2 database hosted in the "database" container
    depends_on:  # Specify service dependencies
      - db  # Ensure the "db" service starts before the "web" service to ensure the database is available
      
volumes:
  h2-data:  
    driver: local
```


## Step 5: Build and Run the Containers

- In the terminal, execute the following command in the root of your project:

```bash
docker-compose up --build
```
- This will build and run the containers defined in the docker-compose.yml file.

## Step 6: Accessing the Application and Database

   - Spring Application: Access http://localhost:8080/basic-0.0.1-SNAPSHOT
   - H2 Database Console: Access http://localhost:9092 and enter the credentials as configured in the Spring application

- To publish your images to Docker Hub, follow the steps described in the official Docker documentation.

## Kubernetes

- Kubernetes is an open-source container orchestration system that automates the deployment, scaling, and management of containerized applications. 
- It complements Docker by adding advanced orchestration capabilities, such as automatic scaling, load balancing, and fault recovery. 
- Kubernetes leverages Docker's popularity and knowledge while providing centralized and efficient management of distributed containers across clusters. 
- Its flexibility in supporting various containerization technologies makes it a valuable addition to Docker, enabling seamless management of containerized applications at scale.




