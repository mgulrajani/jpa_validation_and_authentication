Steps for learners — simple and small actions

1) Prerequisites 
- Install a JDK (LTS recommended, e.g. Temurin/OpenJDK 17 or 21).
- Git (optional) and an internet connection (Maven will download dependencies).
- Open Terminal.

2) Open the project in VS Code
- In Terminal run:
```bash
cd ~/Downloads/jpademo
code .
```

3) Quick tour of important files (open these in VS Code)
- Project build: pom.xml
- Spring Boot main: `com.neueda.JpademoApplication`
- Entity: `com.neueda.entities.Product`
- Repository: `com.neueda.repos.ProductRepository`
- Service: `com.neueda.services.ProductService` and `ProductServiceImpl`, (src/main/java/com/neueda/services/ProductServiceImpl.java)
- Controller: `com.neueda.controllers.ProductController`
- Config: application.properties
- Tests: JpademoApplicationTests.java


you can test it using swagger docs localhost:port/swagger-ui/index.html 

or you can run it in CLI

4) Make Maven wrapper executable (one time)
```bash
chmod +x mvnw
```

5) Build and run tests
```bash
./mvnw test
```

6) Run the application
```bash
./mvnw spring-boot:run
```
- App will start on port 7171 (see application.properties).

7) Try the API (new Terminal tab)
- Get all products:
```bash
curl -s http://localhost:7171/api/products
```
- Add a product:
```bash
curl -s -X POST http://localhost:7171/api/products \
  -H "Content-Type: application/json" \
  -d '{"name":"Pen","price":1.5}'
```

8) Open H2 console (in browser)
- URL: http://localhost:7171/h2-console
- JDBC URL: jdbc:h2:mem:salesdb
- User: sa (password blank)
- (See src/main/resources/application.properties)

9) Make a small code change (example)
- To change the default port edit application.properties.
- After editing, rebuild and rerun with the commands above.

10) Common troubleshooting (short)
- If mvnw fails: ensure chmod +x done and JDK installed; check JAVA_HOME.
- If Java version mismatch: change <java.version> in pom.xml or install the required JDK.
- If port in use: change server.port in application.properties.

That’s it — follow the steps, open the files linked above to learn how each part works, run the app, and call the endpoints.
