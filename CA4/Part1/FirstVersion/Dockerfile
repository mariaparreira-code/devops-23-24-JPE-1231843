# First stage: Build the application
FROM gradle:jdk17 as builder
LABEL author="mariaparreira"

# Define the working directory
WORKDIR /CA4/Part1

# Copy the entire project into the container
COPY ./CA2.Part1 .

# Run the Gradle build
RUN ./gradlew clean build

# Second stage: Create the final image
FROM openjdk:17-jdk-slim

# Define the working directory
WORKDIR /CA4/Part1

# Copy the built JAR file from the first stage
COPY --from=builder /CA4/Part1/build/libs/*.jar /CA4/Part1.jar

# Specify the command to run the application
ENTRYPOINT ["java", "-cp", "/CA4/Part1.jar", "basic_demo.ChatServerApp", "59001"]