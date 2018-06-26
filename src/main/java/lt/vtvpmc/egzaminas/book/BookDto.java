package lt.vtvpmc.egzaminas.book;

import lombok.Data;
import lt.vtvpmc.egzaminas.library.Library;

import java.io.Serializable;


public class BookDto implements Serializable {

    private Library library;

    private String name;

    private String years;

    public BookDto(Library library, String name, String years) {
        this.library = library;
        this.name = name;
        this.years = years;
    }

    public BookDto() {
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }
}
