package lt.vtvpmc.egzaminas.library;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lt.vtvpmc.egzaminas.book.Book;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Library implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToMany(mappedBy = "library")
    private List<Book> books;

    @Column(name = "library_name")
    private String name;

    private String location;

    public Library() {
    }

    public Library(int id, List<Book> books, String name, String location) {
        this.id = id;
        this.books = books;
        this.name = name;
        this.location = location;
    }
}
