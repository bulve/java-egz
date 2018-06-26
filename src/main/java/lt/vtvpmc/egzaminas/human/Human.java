package lt.vtvpmc.egzaminas.human;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(include = JsonTypeInfo.As.PROPERTY, property = "type", use = com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Person.class, name = "human"),
        @JsonSubTypes.Type(value = Author.class, name = "author")
})
public abstract class Human {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int human_id;

    private String firstName;

    private String lastName;

    private int age;

    public Human() {
    }

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
