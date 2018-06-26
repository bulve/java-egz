package lt.vtvpmc.egzaminas.human;

import lt.vtvpmc.egzaminas.book.Book;
import lt.vtvpmc.egzaminas.book.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HumanService {

    @Autowired
    private HumanRepo humanRepo;

    @Autowired
    private BookRepo bookRepo;

    public List<Person> getPersons() {
        return humanRepo.findAllPersons();
    }

    public void addHuman(Human human) {
        humanRepo.save(human);
    }

    public Person getPerson(Integer id) {
        Person person = (Person)humanRepo.findOne(id);
        return new Person(person.getFirstName(), person.getLastName(), person.getAge(), person.getBooks());
    }
//
//    public void addBook(Integer person_id, Integer book_id) {
//        Book book = bookRepo.findOne(book_id);
//        book.setPerson(humanRepo.findOne(person_id));
//    }
//
//    public void removeBook(Integer person_id, Integer book_id) {
//        Person person = humanRepo.findOne(person_id);
//        Book book = bookRepo.findOne(book_id);
//        if(book.getPerson().equals(person)){
//            book.setPerson(null);
//        };
//    }

    public List<Author> getAuthors() {
        return humanRepo.findAllAuthors();
    }

//    public void addAuthor(Author author) {
//        humanRepo.save(author);
//    }
//
//    public Author getAuthor(Integer id) {
//        Author author = humanRepo.findOne(id);
//        return new Author( author.getFirstName(), author.getLastName(), author.getAge(), author.getBooks());
//    }
}
