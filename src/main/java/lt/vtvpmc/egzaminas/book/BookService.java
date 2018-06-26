package lt.vtvpmc.egzaminas.book;


import lt.vtvpmc.egzaminas.library.Library;
import lt.vtvpmc.egzaminas.library.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private LibraryRepo libraryRepo;

    public void createBook(BookDto bookDto) {

        Book book = new Book();
        book.setYears(bookDto.getYears());
        book.setName(bookDto.getName());
        bookRepo.save(book);
    }

    public List<Book> getBooks() {
        return bookRepo.findAll();
    }

    public BookDto getBook(String id) {
        Book book = bookRepo.getOne(Integer.valueOf(id));
        BookDto bookDto = new BookDto(book.getLibrary(), book.getName(), book.getYears());
        return new BookDto(book.getLibrary(), book.getName(), book.getYears());
    }

    public void addBookToLibrary(int book_id, int library_id) {
        Book book = bookRepo.getBook(book_id);
        book.setLibrary(libraryRepo.getOne(library_id));
    }

    public void createBookOnLibrary(Book book, Integer library_id) {
        Book newBook = bookRepo.save(book);
        newBook.setLibrary(libraryRepo.getOne(library_id));
    }
}
