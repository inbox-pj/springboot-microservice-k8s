# Microservices with Spring Boot and Spring Cloud on Kubernetes


## Getting Started 
- **gateway-service** - a module that Spring Cloud Netflix Zuul for running Spring Boot application that acts as a proxy/gateway in our architecture.
- **employee-service** - a module containing the first of our sample microservices that allows to perform CRUD operation on Mongo repository of employees
- **department-service** - a module containing the second of our sample microservices that allows to perform CRUD operation on Mongo repository of departments. It communicates with employee-service. 
- **organization-service** - a module containing the third of our sample microservices that allows to perform CRUD operation on Mongo repository of organizations. It communicates with both employee-service and department-service.
- **admin-service** - a module containing embedded Spring Boot Admin Server used for monitoring Spring Boot microservices running on Kubernetes

## Usage
- Download and run **Minikube** using command: ``minikube start --vm-driver=virtualbox --memory='4000mb'``
- Build Maven project with using command: ``mvn clean install``
- Build Docker images for each module using command, for example: ``docker build -t pjaiswal/employee:1.1 .``
- Go to ``/k8s`` directory in repository
- Apply all templates to Minikube using command: ``kubectl apply -f <filename>.yaml``
- Check status with ``kubectl get pods``

## Before you start
Inside k8s directory, there are several YAML scripts need to be applied before running applications.

1. `privileges.yaml` - `Role` and `RoleBinding` for Spring Cloud Kubernetes to allow access Kubernetes API from pod
2. `mongo-secret.yaml` - credentials for MongoDB
3. `mongo-configmap.yaml` - user for MongoDB
4. `mongo-deployment.yaml` - `Deployment` for MongoDB
Just apply those scripts using `kubectl apply`.

we can easily deploy all applications using `skaffold dev` command.
