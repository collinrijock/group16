package Scrumtious.Group.Project.BrowsingSorting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class BooksService {

    @Autowired
    BooksRepository booksRepository;

    public Page<Books> getPages(int pageNumber, int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        return booksRepository.findAll(page);
    }

}
