package ro.uvt.services;

import org.springframework.stereotype.Service;
import ro.uvt.models.Book;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class BookService {
    private final BooksRepository booksRepository;

    public BookService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public Book saveBook(Book book){
        return booksRepository.save(book);
    }

    public Book getBook(Long id){
        Optional<Book> optionalBook = booksRepository.findById(Math.toIntExact(id));

        if(optionalBook.isPresent()){
            return optionalBook.get();
        }
        return null;
    }
}
