# PayU Challenge
- Author: Edwin Hidalgo
- Role: Senior Software Engineer

# Content

1. [Execution]()
2. [Possible Future Improvements]()

# Execution:
## Building and Running the Project:

### Requirements:
- Have Java 11 (or higher) and Maven installed.

### Building the project:
- From the root of the project, run:
````shell
mvn clean install
````

- Run the application:
````shell
mvn spring-boot:run
````

The application will boot on port 8080 (by default).

## Testing the REST API:

- Exposing the endpoint:

  - URL: `http://localhost:8080/api/network/prioritize`
  - Method: `POST`
  - Header: `Content-Type: application/json`


- Example of request with Postman or curl:

```json
{
  "responseTimes": [20, 15, 100, 15, 50, 9],
  "costs": [50, 60, 30, 55, 40, 70],
  "criteria": "RESPONSE_TIME"
}
```

- Expected response:

```json
{
  "prioritizedNetworks": [5, 3, 1, 0, 4, 2]
}
```

## Running Unit Tests:

- From the project root, run:
```shell
mvn test
```

This will run the tests defined in **NetworkpriorizationApplicationTests.java**.

# Possible Future Improvements

## Advanced Validation:
Improve error handling and response messages to more robustly validate input data (e.g. using Spring annotated validations  [NotNull, Size, Valid]).

## Using Enum for Criteria:
Instead of handling the criteria as a text string, an enum could be used to avoid typos and facilitate the extension of new criteria.

## Swagger Documentation:
Integrate Swagger/OpenAPI to document and test the API.

## Metrics and Logging:
Include logs and metrics to monitor API performance (Logback on service and add Actuator with Micrometer).