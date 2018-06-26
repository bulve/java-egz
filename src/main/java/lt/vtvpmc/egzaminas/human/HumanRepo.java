package lt.vtvpmc.egzaminas.human;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HumanRepo extends JpaRepository<Human, Integer> {
//

    @Query(nativeQuery = true, value = "SELECT * FROM HUMAN WHERE DTYPE = 'Author'")
    List<Author> findAllAuthors();

    @Query(nativeQuery = true, value = "SELECT * FROM HUMAN WHERE DTYPE = 'Person'")
    List<Person> findAllPersons();


//
//    List<Person> findAllPersons();
}
