package chapter_05;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author liuxin
 * @version Id: Book.java, v 0.1 2018/9/29 2:16 PM
 */
@Component
@PropertySource(value = "bookinfo.properties",encoding="utf-8")
public class Book {

    @Value(value = "${book_name}")
    String bookName;

    @Value(value = "${author}")
    String author;

    @Value(value = "${price}")
    Double price;

    @Value(value ="${describe}")
    String describe;

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", describe='" + describe + '\'' +
                '}';
    }



}
