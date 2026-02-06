# Microservices order system
A microservice based order management system that demonstrates communications between individual services, REST APIs, and independent database architecture.

## Architecture
This project consists of two seperate and independent microservices:

- **Product service** on Port 8081, which manages product catalog and inventory.
- **Order service** on Port 8082, which handles creation of orders and communicates that with the product service.

each service has its own database.

## Tech Stack
- **Java 17**
- **Spring Boot 4.02** - REST API framework
- **Spring Data JPA** - Database abstraction layer
- **PostgreSQL** - Relational database
- **Gradle** - Build tool
- **Docker** - Container runtime for databases
- **Lombok** - Boilerplate reduction

## Features

- RESTful APIs for product and order management
- Inter-service communication via HTTP/REST
- Stock validation before order creation
- Automatic price calculation
- Independent databases per service
- Proper error handling for insufficient stock

## Getting Started

### 1. Clone the repository
```bash
git clone https://github.com/noahjit/microservices-order-system.git
cd microservices-order-system
```

### 2. Start PostgreSQL databases
```bash
# Product Service database (port 5432)
docker run --name postgres-product -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=productdb -p 5432:5432 -d postgres

# Order Service database (port 5433)
docker run --name postgres-order -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=orderdb -p 5433:5432 -d postgres
```

### 3. Run Product Service
```bash
cd product-service
./gradlew bootRun
```

Product Service will start on `http://localhost:8081`

### 4. Run Order Service (in a new terminal)
```bash
cd order-service
./gradlew bootRun
```

Order Service will start on `http://localhost:8082`

Then use Postman to test GET and POST requests and outcomes.

## Future Enhancements

- [ ] Dockerize both services with Dockerfiles
- [ ] Add docker-compose for one-command startup
- [ ] Implement Kafka for event-driven communication
- [ ] Add API documentation with Swagger/OpenAPI
- [ ] Implement proper exception handling with custom error responses
- [ ] Add unit and integration tests
- [ ] Deploy to AWS/Azure
- [ ] Add monitoring and logging (Spring Boot Actuator, ELK stack)
- [ ] Implement service discovery (Eureka)
- [ ] Add API Gateway


## Author

Noah - [GitHub](https://github.com/noahjit)