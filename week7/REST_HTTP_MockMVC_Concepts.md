# HTTP Request/Response, RESTful Web Services & MockMVC Concepts - Week 7

## 1. HTTP Request and Response
The **Hypertext Transfer Protocol (HTTP)** is the foundation of data communication for the World Wide Web. It functions as a request-response protocol in the client-server computing model.

### HTTP Request
An HTTP request is sent by a client (e.g., a web browser or Postman) to a server to initiate an action.
- **Request Line:** Contains the Method (`GET`, `POST`, `PUT`, `DELETE`), Request-URI (e.g., `/hello`), and HTTP version (e.g., `HTTP/1.1`).
- **Headers:** Key-value pairs providing metadata about the request.
  - `Host`: Domain name of the server (e.g., `www.example.com`).
  - `User-Agent`: Information about the client software making the request.
  - `Accept`: Content types the client expects (e.g., `application/json`).
- **Body (Payload):** Present in `POST`/`PUT` requests containing the data to be sent.

### HTTP Response
The server responds to the client's request with an HTTP response.
- **Status Line:** Contains the HTTP version, Status Code (e.g., `200`, `404`), and Reason Phrase (e.g., `OK`, `Not Found`).
- **Headers:** Metadata returned by the server.
  - `Content-Type`: The MIME type of the body (e.g., `text/plain`, `application/json`, `text/html`).
  - `Content-Length`: Size of the response body.
- **Body (Payload):** The actual content requested (e.g., HTML text, JSON string, image bytes).

---

## 2. Need and Benefits of RESTful Web Services
**REST (REpresentational State Transfer)** is an architectural style for providing interoperability between computer systems on the Internet. Web services conforming to the REST architectural style are called RESTful Web Services.

### Benefits:
- **Client-Server Separation:** UI concerns are separate from data storage concerns.
- **Stateless:** Each request from client to server must contain all the information necessary to understand the request.
- **Lightweight & Fast:** Typically uses JSON instead of bulky XML (like SOAP).
- **Scalable & Maintainable:** Servers do not store client state, making scaling much easier.
- **Uniform Interface:** Utilizes standard HTTP methods (`GET` for fetching, `POST` for creating, `PUT` for updating, `DELETE` for removing).

---

## 3. Spring Boot Web - `@RestController`
Spring provides the `@RestController` annotation to define RESTful controllers. It is a convenience annotation that combines `@Controller` and `@ResponseBody`.

### Annotations:
- **`@RestController`:** Marks a class as a web controller handling REST requests.
- **`@RequestMapping` / `@GetMapping`:** Maps HTTP requests to handler methods.
- **`@PathVariable`:** Extracts values from the URI path (e.g., `/countries/{code}`).

### JSON Transformation:
When a handler method returns a Java object (e.g., `Country` or `List<Country>`), Spring's `HttpMessageConverter` (specifically Jackson) automatically serializes it into a JSON response.

---

## 4. End-to-End Testing with MockMVC
**MockMVC** provides support for Spring MVC testing. It encapsulates all web application beans and makes them available for testing without needing to start a real HTTP server (like Tomcat).

### Key Components:
- **`@AutoConfigureMockMvc`:** Automatically configures the `MockMvc` instance for the test environment.
- **`mockMvc.perform(get("/uri"))`:** Simulates an HTTP GET request to the specified URI.
- **`andExpect(status().isOk())`:** Asserts the expected HTTP status code (e.g., 200).
- **`andExpect(jsonPath("$.fieldName").value("value"))`:** Validates specific JSON attributes in the response payload.
