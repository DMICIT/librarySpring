package com.project.controllers;

import com.project.data.BookData;
import com.project.entities.Book;
import com.project.entities.User;
import com.project.enums.Role;
import com.project.forms.AdminAddLibrarianForm;
import com.project.forms.AdminEditBookForm;
import com.project.services.BookService;
import com.project.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController {

    private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

    @Resource
    private UserService userService;
    @Resource
    private BookService bookService;

    @GetMapping(value = "/admin-books")
    public String adminGetBook(HttpServletRequest request) {


        String sortParam = "id";
        String order = "asc";
        int pageSize = 7;
        int page = 1;

        if (request.getParameter("sort") != null){
            sortParam = request.getParameter("sort");
        }
        if (request.getParameter("order") != null){
            order= request.getParameter("order");
        }

        Sort sort = Sort.by(Sort.Direction.fromString(order), sortParam);
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        Pageable pageable = PageRequest.of(page, pageSize ,sort);
        Page<BookData> books = bookService.findAllBooks(pageable);
        request.setAttribute("booksData", books);

        return "admin-books";
    }

    @PostMapping(value = "/admin-delete-book")
    public String adminDeleteBooks(HttpServletRequest request) {
        int bookid = Integer.parseInt(request.getParameter("bookId"));
        Book book = new Book();
        book.setId(bookid);
        bookService.deleteBook(book);

        return "redirect:admin-books";
    }

    @GetMapping(value = "/admin-edit-book")
    public String adminBookEdit(HttpServletRequest request, AdminEditBookForm adminEditBookForm) {
        String id = request.getParameter("id");
        if (id != null) {
            int bookId = Integer.parseInt(id);
            BookData book = bookService.getBookById(bookId);
            adminEditBookForm.setBookId(book.getId());
            adminEditBookForm.setAuthor(book.getAuthor());
            adminEditBookForm.setBookName(book.getBookName());
            adminEditBookForm.setBookEdition(book.getBookEdition());
            adminEditBookForm.setReleaseDate(book.getReleaseDate().toString());
            adminEditBookForm.setCount(book.getCatalogData().getTotalQuantity());
            request.setAttribute("action", "edit");
        }
        return "admin-edit-book";
    }

    @PostMapping(value = "/admin-edit-book")
    public String adminEditBook(HttpServletRequest request, @Valid @ModelAttribute AdminEditBookForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()){
            return "admin-edit-book";
        }
        bookService.editBook(form);

        return "redirect:admin-books";
    }

    @GetMapping(value = "/admin-add-librarian")
    public String adminAddUserPage(AdminAddLibrarianForm adminAddLibrarianForm) {
        return "admin-add-user";
    }

    @PostMapping(value = "/admin-add-librarian")
    public String addLibrarianByAdmin( @Valid @ModelAttribute AdminAddLibrarianForm form, BindingResult errors) {

        if (errors.hasErrors()){
            return "admin-add-user";
        }
        Role role = Role.LIBRARIAN;
        User user = userService.createUserFromForm(form, role);

        return "redirect:admin-librarians";
    }

    @GetMapping(value = "/admin-users")
    public String adminUsers(HttpServletRequest request) {
        List<User> users = userService.getUsersByRole(Role.USER);
        request.setAttribute("users", users);
        request.setAttribute("role", Role.USER);
        return "admin-users";
    }
    @GetMapping(value = "/admin-librarians")
    public String adminLibrarians(HttpServletRequest request) {
        List<User> librarians = userService.getUsersByRole(Role.LIBRARIAN);
        request.setAttribute("users", librarians);
        request.setAttribute("role", Role.LIBRARIAN);
        return "admin-users";
    }


    @PostMapping(value = "/admin-delete-librarian")
    public String adminDeleteLibrarian(HttpServletRequest request)  {

       int userId = Integer.parseInt(request.getParameter("userId"));
       userService.deleteUser(userId);

       return "redirect:admin-librarians" ;
    }

    @PostMapping(value = "/admin-ban-user")
    public String adminBanUser(HttpServletRequest request){
        LOG.info("Ban page");
        int userId = Integer.parseInt(request.getParameter("userId"));
        userService.banUser(userId, true);
        return "redirect:admin-users" ;

    }

    @PostMapping(value = "/admin-unban-user")
    public String adminUnbanUser(HttpServletRequest request){
        int userId = Integer.parseInt(request.getParameter("userId"));
        userService.banUser(userId, false);
        return "redirect:admin-users" ;
    }


}


