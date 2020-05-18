package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Book {
   @Id
   @GeneratedValue (strategy = GenerationType.AUTO)
   private Long id;

    private String title;
    private String ibn;
    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
               inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;

    public Book() {
    }

    public Book(String title, String ibn, Set<Author> authors) {
        this.title = title;
        this.ibn = ibn;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIbn() {
        return ibn;
    }

    public void setIbn(String ibn) {
        this.ibn = ibn;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
