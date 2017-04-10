package library.models;

import java.io.*;

public class Book implements Serializable, Externalizable {
    private String author;
    private String title;
    private int year;
    private String isbn;
    private static long serialVersionUID = 2L;

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Book(String author, String title, int year, String isbn) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.isbn = isbn;
    }

    public Book(){

    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (!(obj instanceof Book))
            return false;

        if (!this.isbn.equals(((Book) obj).isbn))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return author + "@" + title + "@" + year + "@" + isbn;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(author);
        out.writeUTF(title);
        out.writeInt(year);
        out.writeObject(isbn);
        out.writeUTF("vadim");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.author = (String) in.readUTF();
        this.title = (String) in.readUTF();
        this.year = in.readInt();
        this.isbn = (String) in.readObject();
        System.out.println(in.readUTF());
    }
}
