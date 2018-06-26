package lt.vtvpmc.egzaminas.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/library")
@CrossOrigin(value = "*")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping
    private void createBook(@RequestBody Library library){
        libraryService.createLibrary(library);
    };

    @GetMapping
    private List<Library> getLibraries(){
        return libraryService.getLibraries();
    }

    @GetMapping(value = "/{id}")
    private Library getBook(@PathVariable final Integer id){
        return libraryService.getLibrary(id);
    }

}
