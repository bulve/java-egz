package lt.vtvpmc.egzaminas.human;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/human")
@CrossOrigin(value = "*")
public class HumanController {

    @Autowired
    private HumanService humanService;

    @GetMapping(value = "/persons")
    private List<Person> getPersons(){
        return humanService.getPersons();
    }

    @PostMapping
    private void addHuman(@RequestBody Human human){
        humanService.addHuman(human);
    }

    @GetMapping(value = "/person/{id}")
    private Person getPerson(@PathVariable final Integer id){
        return humanService.getPerson(id);
    }
//
//    @PostMapping(value = "/{person_id}/book/{book_id}")
//    private void addBook(@PathVariable final Integer person_id, @PathVariable final Integer book_id){
//        humanService.addBook(person_id, book_id);
//    }
//
//    @PostMapping(value = "/{person_id}/remove/book/{book_id}")
//    private void removeBook(@PathVariable final Integer person_id, @PathVariable final Integer book_id){
//        humanService.removeBook(person_id, book_id);
//    }
//
    @GetMapping(value = "/authors")
    private List<Author> getAuthors(){
        return humanService.getAuthors();
    }
//
//    @PostMapping
//    private void addAuthors(@RequestBody Author author){
//        humanService.addAuthor(author);
//    }
//
//    @GetMapping(value = "/{id}")
//    private Author getAuthor(@PathVariable final Integer id){
//        return humanService.getAuthor(id);
//    }



}
