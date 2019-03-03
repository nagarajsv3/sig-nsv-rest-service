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