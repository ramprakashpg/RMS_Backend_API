# Movie Reviewing System
## Overview
The Movie Reviewing System is a full-fledged web application developed to showcase the implementation of various distributed system concepts. This project integrates replication, fault tolerance, consistency, and Kubernetes deployment to ensure a robust and scalable architecture. The system allows users to review and rate movies, providing an interactive platform for movie enthusiasts.
## Dataset (~ 7GB)
https://www.kaggle.com/datasets/ebiswas/imdb-review-dataset 

## Technologies Used
- Backend: Developed using Spring Boot, the backend services provide a resilient and efficient foundation for the application. Spring Boot facilitates the integration of distributed system features seamlessly.

- Frontend: The user interface is built using React, offering an intuitive and dynamic experience for users to browse, review, and rate movies.
- Database: CouchDB was used to handle the meta data. It was deployed on-premise with 3 replicas.

### Architecture:
The User Interface (UI), Backend API, and CouchDB database are all included in the layered architecture of the movie review system. Every layer in the system has a specific function that promotes data flow efficiency, scalability, and modularity. The overall architecture is structured into three distinct layers.

![image](https://github.com/ramprakashpg/RMS_Backend_API/assets/68699055/98a0b1f6-e130-4905-8de1-0d9e6021de59)

### Database Structure:
Data replication and dissemination across nodes are made possible by the deployment of one main container and several different database replicas inside Docker containers 

![image](https://github.com/ramprakashpg/RMS_Backend_API/assets/68699055/5c687455-14ba-4108-89b5-a7e4a7057bf6)

### Backend Deployment:
Backend was deployed in kubernetes clusters with 3 replicas.

## Distributed System Concepts:

- Replication: Implemented replication mechanisms to ensure data consistency across distributed nodes.
  
![Screenshot 2023-12-17 114119](https://github.com/ramprakashpg/RMS_Backend_API/assets/68699055/107378f4-4dd9-4629-82d9-83308d92a463)

- Fault Tolerance: Integrated measures to handle system failures and maintain uptime, enhancing the overall reliability of the application.
  Fault tolerance was attained by killing a docker container running inside the kubernetes cluster.
  ![Container getting created automatically](https://github.com/ramprakashpg/RMS_Backend_API/assets/68699055/a1a68b2f-f6ff-4829-b15b-4ac9f88d212e)

  
- Consistency: Ensured data consistency and coherence in a distributed environment.
- Containerization and Orchestration: Used docker to containarize the backend application and deployed 3 containers in a kubernetes cluster.
  ![containarization](https://github.com/ramprakashpg/RMS_Backend_API/assets/68699055/dbe7b224-7304-4966-9b2a-4794d9658fc0)


Utilized Kubernetes for on-premise deployment, allowing for efficient resource management, scalability, and ease of maintenance.

## Learning
- Handling Big data
- Kubernetes
- Docker



