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
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
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
    public String adminGetBook(Model model,
                               @RequestParam(defaultValue = "id", name = "sort") String sortParam,
                               @RequestParam(defaultValue = "asc") String order,
                               @RequestParam(defaultValue = "7", name = "pageSize") Integer pageSize,
                               @RequestParam(defaultValue = "0", name = "page") Integer page) {

        Sort sort = Sort.by(Sort.Direction.fromString(order), sortParam);

        Pageable pageable = PageRequest.of(page, pageSize, sort);
        Page<BookData> books = bookService.findAllBooks(pageable);
        model.addAttribute("booksData", books);

        return "admin-books";
    }

    @PostMapping(value = "/admin-delete-book")
    public String adminDeleteBooks(@RequestParam(defaultValue = "0", name = "bookId") Integer bookId) {
        Book book = new Book();
        book.setId(bookId);
        bookService.deleteBook(book);

        return "redirect:admin-books";
    }

    @GetMapping(value = "/admin-edit-book")
    public String adminBookEdit(Model model, AdminEditBookForm adminEditBookForm,
                                @RequestParam(defaultValue = "0", name = "id") Integer id) {
        if (id != 0) {
            int bookId = id;
            BookData book = bookService.getBookById(bookId);
            adminEditBookForm.setBookId(book.getId());
            adminEditBookForm.setAuthor(book.getAuthor());
            adminEditBookForm.setBookName(book.getBookName());
            adminEditBookForm.setBookEdition(book.getBookEdition());
            adminEditBookForm.setReleaseDate(book.getReleaseDate().toString());
            adminEditBookForm.setCount(book.getCatalogData().getTotalQuantity());
            model.addAttribute("action", "edit");
        }
        return "admin-edit-book";
    }

    @PostMapping(value = "/admin-edit-book")
    public String adminEditBook(@Valid @ModelAttribute AdminEditBookForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
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
    public String addLibrarianByAdmin(@Valid @ModelAttribute AdminAddLibrarianForm form, BindingResult errors) {

        if (errors.hasErrors()) {
            return "admin-add-user";
        }
        Role role = Role.LIBRARIAN;
        User user = userService.createUserFromForm(form, role);

        return "redirect:admin-librarians";
    }

    @GetMapping(value = "/admin-users")
    public String adminUsers(Model model) {
        List<User> users = userService.getUsersByRole(Role.USER);
        model.addAttribute("users", users);
        model.addAttribute("role", Role.USER);
        return "admin-users";
    }

    @GetMapping(value = "/admin-librarians")
    public String adminLibrarians(Model model) {
        List<User> librarians = userService.getUsersByRole(Role.LIBRARIAN);
        model.addAttribute("users", librarians);
        model.addAttribute("role", Role.LIBRARIAN);
        return "admin-users";
    }


    @PostMapping(value = "/admin-delete-librarian")
    public String adminDeleteLibrarian(@RequestParam(defaultValue = "0", name = "userId") Integer userId) {

        userService.deleteUser(userId);

        return "redirect:admin-librarians";
    }

    @PostMapping(value = "/admin-ban-user")
    public String adminBanUser(@RequestParam(defaultValue = "0", name = "userId") Integer userId) {
        LOG.info("Ban page");
        userService.banUser(userId, true);
        return "redirect:admin-users";

    }

    @PostMapping(value = "/admin-unban-user")
    public String adminUnbanUser(@RequestParam(defaultValue = "0", name = "userId") Integer userId) {
        userService.banUser(userId, false);
        return "redirect:admin-users";
    }

}


