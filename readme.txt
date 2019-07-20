1. Rest Service using @RestController, @RestMapping & @RequestParam
2. Lombok usuage
        <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok-maven-plugin -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok-maven-plugin</artifactId>
            <version>1.18.0.0</version>
        </dependency>

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
3. maven spring-boot:run

***********Spring Data JPA & H2***********
1. Add below dependencies in pom.xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <!--h2 database for development purpose-->
        <!-- https://mvnrepository.com/artifact/com.h2database/h2 -->
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>

2. Add below properties in application.properties
# H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2
# Datasource
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver

3. Create Entity Class, Repository Interface

***********Hibernate Validator Validations***********
Gives 400 Bad Request By default

Validation Using Hibernate Validator
1. Add Hibernate Validator dependency to pom
        <dependency>
            <groupId>org.hibernate.validator</groupId>
            <artifactId>hibernate-validator</artifactId>
        </dependency>
2. Use Annotations like @Valid in the controller & @NotNull, @Size, @Min, @Max on domain/entity
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

2019-03-03 10:52:15.496  WARN 7248 --- [nio-8090-exec-2] .w.s.m.s.DefaultHandlerExceptionResolver : Resolved
 [org.springframework.web.bind.MethodArgumentNotValidException: Validation failed for argument at index 0 in method:
  private com.nsv.jsmbaba.domain.Person com.nsv.jsmbaba.controller.PersonController.createPerson(com.nsv.jsmbaba.domain.Person),
   with 1 error(s): [Field error in object 'person' on field 'age': rejected value [1]; codes
   [Min.person.age,Min.age,Min.int,Min]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable:
   codes [person.age,age]; arguments []; default message [age],18]; default message [must be greater than or equal to 18]] ]

********Custom Exception Handler********
Create a ControllerAdvice for the Controller
Throw exception in the Controller. ControllerAdvice catches and responds to request


***********Consuming Rest Service using RestTemplate*************
1. @JsonIgnoreProperties from the Jackson JSON processing library to indicate that any properties not bound
in this type should be ignored.
2. In order for you to directly bind your data to your custom types, you need to specify the variable name
exact same as the key in the JSON Document returned from the API. In case your variable name and key in JSON doc
are not matching, you need to use @JsonProperty annotation to specify the exact key of JSON document.
3. Jackson JSON processing library is in the classpath, RestTemplate will use it (via a message converter)
to convert the incoming JSON data into a Quote object
4. standard system properties http.proxyHost and http.proxyPort to values appropriate for your environment if you are behind corporate proxy
5. applicationContext.getBeanDefinitionNames() gives all the bean names provided by spring boot.

********Spring Boot Testing***********
https://www.baeldung.com/spring-boot-testing
https://blog.zenika.com/2013/01/15/spring-mvc-test-framework/
https://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-rest-api/

1. Refer GreetingControllerTest
The MockMvc comes from Spring Test and allows you, via a set of convenient builder classes,
to send HTTP requests into the DispatcherServlet and make assertions about the result.
Note the use of the @AutoConfigureMockMvc together with @SpringBootTest to inject a MockMvc instance.
Having used @SpringBootTest we are asking for the whole application context to be created.

********Spring Boot Integrated Testing***********
1. Refer GreetingControllerITTest
2. The embedded server is started up on a random port by virtue of the
 webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
 and the actual port is discovered at runtime with the @LocalServerPort

1. Build & Run the spring boot app using maven command prompt
mvn package && java -jar target/sig-nsv-rest-service-0.0.1-SNAPSHOT.jar

*********Spring Boot Actuator*********
1. spring-boot-starter-actuator provides actuator/health, actuator/info, actuator.
2. There is also a /actuator/shutdown endpoint, but it’s only visible by default via JMX.
To enable it as an HTTP endpoint, add management.endpoints.shutdown.enabled=true to your application.properties file.
3. Spring Boot Actuator defaults to run on port 8080. By adding an application.properties file, you can override that setting.
server.port: 8090
management.server.port: 9001
management.server.address: 127.0.0.1

Refer GreetingControllerManagementITTest for test

*********Spring Boot Logging*********
Spring Boot provides Logback
logging.level.org.springframework.*=INFO
logging.level.<yourpackage>=INFO
logging.file=logs/filename.log
