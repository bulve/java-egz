package lt.vtvpmc.egzaminas.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lt.vtvpmc.egzaminas.human.Author;
import lt.vtvpmc.egzaminas.library.Library;
import lt.vtvpmc.egzaminas.human.Person;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue
    private int book_id;

    @ManyToOne(optional = true)
    @JsonIgnore
    private Library library;

    @ManyToOne
    @JsonIgnore
    private Person person;

    @Column(name = "naming")
    private String name;

    @Column(name = "year", length = 5)
    private String years;

    @ManyToMany
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "human_id",
                    referencedColumnName = "human_id"))
    private List<Author> authors;
}
