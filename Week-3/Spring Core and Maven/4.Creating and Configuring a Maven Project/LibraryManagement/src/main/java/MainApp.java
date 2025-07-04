/*package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = (BookService) context.getBean("bookService");
        bookService.addBook("The Great Gatsby");
    }
}
*/
package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp{
    public static void main(String[] args) {

        // Load Spring container from XML config
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get BookService bean (DI should have injected BookRepository into it)
        BookService bookService = (BookService) context.getBean("bookService");

        // Test the service method
        bookService.addBook("To Kill a Mockingbird");
    }
}
