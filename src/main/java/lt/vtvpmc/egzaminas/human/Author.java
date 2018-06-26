package lt.vtvpmc.egzaminas.human;

import lombok.Data;
import lt.vtvpmc.egzaminas.book.Book;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@Entity
public class Author extends Human {

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    public Author() {
    }

    public Author(String firstName, String lastName, int age, List<Book> books) {
        super(firstName, lastName, age);
        this.books = books;
    }
}
