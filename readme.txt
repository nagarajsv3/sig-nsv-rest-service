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

****Hibernate Validator Validations****
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