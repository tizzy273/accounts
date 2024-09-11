# **Account Service**

The **Account Service** is a microservice for managing customer accounts. It provides endpoints for creating accounts, retrieving accounts, and fetching customer information. The service uses an in-memory **H2** database and is fully tested with **JUnit** and **Cucumber**. API documentation is available through [Swagger](https://app-accounts-0434b53c81ce.herokuapp.com/swagger-ui/index.html#/).

To run locally, you need to clone the repository to your machine and run the project using a Maven-compatible compiler.


## **Continuous Integration and Deployment**
The project follows the Gitflow workflow with two main branches:

- **develop**: Active development happens here.
- **main**: Production-ready code.

**GitHub Actions** automates the CI/CD pipeline in the **.github/workflows**  directory

Every push to the main branch triggers a deploy to Heroku.

---

## **Features**
- **Create Account**
- **Retrieve Account**
- **Get Customer Information**

If you want to test the APIs, you can use this [Postman Collection](https://drive.google.com/file/d/1A-4dQmyNdi9y4_ANZQVg8-IRzQFar8w9/view?usp=sharing) for both Local and Development environment


---

## **Technologies**
- **Java 21** and **Spring Boot**
- **H2 Database** (In-memory)
- **JUnit** and **Cucumber** (Testing)
- **Swagger** (API Documentation)
- **GitHub Actions** (CI/CD)
- **Heroku** (Deployment)

---

## **Database**
The service uses an in-memory **H2** database
