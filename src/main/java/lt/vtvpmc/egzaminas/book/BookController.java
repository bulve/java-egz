package lt.vtvpmc.egzaminas.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/book")
@CrossOrigin(value = "*")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    private void createBook(@RequestBody BookDto bookDto){
        bookService.createBook(bookDto);
    };

    @PostMapping(value = "/library/{library_id}")
    private void createBookOnLibrary(@RequestBody Book book, @PathVariable final Integer library_id){
        bookService.createBookOnLibrary(book, library_id);
    }

    @PostMapping(value = "/{book_id}/library/{library_id}")
    private void addBookToLibrary(@PathVariable final int book_id, @PathVariable final int library_id){
        bookService.addBookToLibrary(book_id, library_id);
    };

    @GetMapping
    private List<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping(value = "/{id}")
    private BookDto getBook(@PathVariable final String id){
        return bookService.getBook(id);
    }


}
