package library.models;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookInstance implements Externalizable{
    private Book book;
    private UUID number;

    private List<Booking> bookingHistory;

    public Book getBook() {
        return book;
    }

    public BookInstance(Book book, UUID number) {
        this.book = book;
        this.number = number;

        bookingHistory = new ArrayList<>(32);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (!(obj instanceof BookInstance))
            return false;

        if (!(this.number.equals(((BookInstance) obj).number)))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return book + "@" + number;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(book);
        out.writeObject(number);
        out.writeUTF("vadim");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        this.book = (Book)in.readObject();
        this.number = (UUID) in.readObject();
        System.out.println(in.readUTF());
    }
}
