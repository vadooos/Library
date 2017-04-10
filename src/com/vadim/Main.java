package com.vadim;

import library.Library;
import library.models.Book;
import library.models.Booking;
import library.models.Reader;
import library.utils.DataManager;

import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();

        for(Book book : DataManager.deserialize())
            library.buyBook(book.getTitle(), book.getAuthor(), book.getIsbn(), 1, book.getYear());
        //Set<Book> bookSet = DataManager.deserializeExternal2("books.txt");//

        //Set<Book> bookSet = null;
        //bookSet =  DataManager.universalDeserialize2( "");






        Reader john = new Reader("John", "Connor", "Androidovich", 12345678);
        Reader sara = new Reader("Sara", "Connor", "Human", 12345679);

        //library.buyBook("Intro to Java", "Schildt", "1241241ada", 5, 2017);
        //library.buyBook("How to hack Pentagon", "Snowden", "54524dfh", 5, 2015);

        library.takeBook("John", "Connor", "Androidovich", 12345678,
                "Intro to Java");
        library.takeBook("Sara", "Connor", "Human", 12345679,
                "How to hack Pentagon");

        library.returnBook("John", "Connor", "Androidovich", 12345678,
                "Intro to Java");

        library.showAllData();

        DataManager.serializeToFile(library.getCatalog());
        //DataManager.serializeExternal(library.getCatalog());
        //DataManager.serializeExternal2(library.getCatalog(), "books.txt");


    }
}
