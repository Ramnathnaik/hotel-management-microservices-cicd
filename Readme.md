# Microservice Architecture along with CI/CD Pipeline

In this project I am going to implement a Hotel Management project using Microservices architecture along with CI/CD pipeline using Jenkins.

## Tech stacks used to implement are:

1. Spring boot (For service creation)
2. Docker (For containerization)
3. Jenkins (For CI/CD pipeline)

## Microservices implementation

### Creation of services

I have created 3 main services.

1. <b>User Service: </b>

- This service provides the functionality of creating, updating, and deleting users.
- Also, it provides the functionality of getting all the users of the service and getting the user details based on the user ID.
- The database used for this service is MySQL.

2. <b>Hotel Service:</b>

- This service provides the functionality of creating the hotel, getting all the hotel details, and getting the hotel details based on the hotel ID.
- The database used for this service is Postgres.

3. <b>Rating Service:</b>

- This service stores the rating given to all the hotels for users.
- This service provides the functionality of creating, getting the rating, getting the rating based on the user ID, and getting the rating based on the hotel ID.
- The database used is MySQL.

We need to make all the 3 services as Eureka Client Services.

### Creation of a Service Registry

- It is also a service or a project to track all the information of the other microservices. It follows a client-server architecture.
- For making the project a Eureka Client we need to add the following annotation into the main class: @EnableEurekaServer.

### Feign Client

- To interact between two microservices we need the interface service which makes use of @FeignClient annotation.

### API Gateway

- API Gateway is a service that helps us route all the service calls through it so that even if the port and host of the other microservice changes it should not affect the application's working.
- In the application.properties file we need to define the configuration of it using spring.cloud.gateway.routes[index]

### Config Server

- Most common configuration can be handled from another service called Config server.
- It will also be a spring boot application which acts as Eureka client.
- If we want to make other services to use config server, we need to make them as config client by,
  1. Adding config client dependency
  2. Add spring.config.import property to application.property file.

### Fault Tolerance

- In a microservice architecture, we will have different services for all components. Each component will communicate with the other components. In this process, if any element is down then the dependent component will face the problem. To resolve this issue we need a mechanism to handle it.
- In a microservice architecture, we can use circuit breakers to handle this scenario. There is a library that helps us to perform fault tolerance. The most popular ones are Hystrix and Resilience4j.
- In this project I have handled it through Resilience4j.

### Rate Limiter

- A rate limiter is a functionality that allows limiting access to some services. It makes service highly available by limiting the number of calls we could process in a specific window.
- I have also implemented this functionality in the project.

## Docker Implementation

### Creation of Dockerfile for each service

For the creating of docker images for each service we need to create a Dockerfile.

- As each service is a spring boot application, the docker file must have a base image as maven.
- Then we can create a jar file out of it using mvn clean package command.
- Later we can expose the required port for the other service to communicate with it using EXPOSE command.
- Then we can define the entry point to start the service.

### Creation of docker-compose.yml file

Since we have multiple services to run and also different databases to setup, it's better to go with creation of docker-compose.yml file.

- At first, I have defined the creation of mysql and postgres database images.
- Then I need to create images for Spring boot services such as user service, hotel service, rating service, service registry, api gateway, config server.
- Then create volumes for application.

## CI/CD Implementation with Jenkins

### Setup Jenkins

To setup Jenkins we can download from the Internet. Jenkins a simple software. Plugins makes it powerful. Once we setup Jenkins, we need to install few plugins.

1. Docker
2. Docker Pipeline
3. Maven (Not mandatory for this project)
4. Java (Not mandatory for this project)

### Creation of Jenkinsfile

Jenkinsfile is a text file that contains the defination of a Jenkins pipeline and is checked into source control.

- I have created Jenkins file in this project consisting of Pipeline defination.
- In the Jenkinsfile there are several stages which are defined:
  1. verify tools: Check whether all the available tools installed or not.
  2. Check Running Docker Container: Check if there are any containers running. If running then stop it.
  3. Start container: Start the docker container. And then check the containers running.

### Creation of CI/CD pipeline

For the creation CI/CD pipeline, below steps needs to be followed:

1. Select new Item
2. Give a name to pipeline.
3. Select Pipeline as an option.
4. In this project I will be pulling the Jenkins file from the Git repo. Hence I will choose "Pipeline from SCM" and give details of Github repo to pull Jenkins file from.
5. Save the pipeline.
6. Click on "Build Now".

## CI/CD Implementation with Jenkins on AWS EC2 Instance

For implementing the Jenkins on EC2 instance, follow the below steps:

1. Create a EC2 Instance: I have used a t2.large instance as the smaller instances were not working fine.
2. Install the Jenkins into EC2 Instance.
3. Install Docker into EC2 Instance.
4. Setup the Jenkins with all the required plugin.
5. Create a pipeline by following the same steps as we did earlier.
6. Now we can click on "Build Now".

## Setting up Github Webhook for Automatic Deployment on Jenkins

Webhooks is a way to inform an application over HTTP that an event has occured and now it can perform the specified task.

- For setting up the webook on Github, we can create a webhook under the settings option of the repository.
- Then in Jenkins we need to select "Github Hook trigger for GITScm polling" under Build Triggers.
- Now whenever we commit anything on to the Github, a new build will get started.
