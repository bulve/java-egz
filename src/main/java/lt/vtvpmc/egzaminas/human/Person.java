package lt.vtvpmc.egzaminas.human;

import lombok.Data;
import lt.vtvpmc.egzaminas.book.Book;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Person extends Human {

    @OneToMany(mappedBy = "person")
    private List<Book> books;

    public Person() {
    }

    public Person(String firstName, String lastName, int age, List<Book> books) {
        super(firstName, lastName, age);
        this.books = books;
    }
}
