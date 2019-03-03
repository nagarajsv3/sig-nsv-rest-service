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
Validation Using Hibernate Validator
1. Add Hibernate Validator dependency to pom
        <dependency>
            <groupId>org.hibernate.validator</groupId>
            <artifactId>hibernate-validator</artifactId>
        </dependency>
2. Use Annotations like @NotNull, @Size, @Min, @Max
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;