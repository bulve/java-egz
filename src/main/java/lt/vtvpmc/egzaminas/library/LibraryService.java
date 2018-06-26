package lt.vtvpmc.egzaminas.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LibraryService {

    @Autowired
    private LibraryRepo libraryRepo;

    public void createLibrary(Library library) {
        libraryRepo.save(library);
    }

    public List<Library> getLibraries() {
        return libraryRepo.findAll();
    }

    public Library getLibrary(Integer id) {
        return libraryRepo.getOne(id);
    }
}
