package lt.vtvpmc.egzaminas.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepo extends JpaRepository<Book, Integer> {


    @Query("select u from Book u where u.id = ?1")
    Book getBook(Integer id);
}
