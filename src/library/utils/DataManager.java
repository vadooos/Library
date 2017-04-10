package library.utils;

import library.models.Book;

import java.io.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class DataManager {
    public static void serializeToFile(Set<Book> books) {
        try(FileOutputStream fos = new FileOutputStream("books.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for(Book book : books)
                oos.writeObject(book);


        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Set<Book> deserialize() {
        Set<Book> books = new HashSet<>();
        try(FileInputStream fis = new FileInputStream("books.txt");
            ObjectInputStream ois = new ObjectInputStream(fis)) {

            Book book = null;
            while((book = (Book) ois.readObject()) != null) {
                books.add(book);
            }
        } catch(IOException ex) {
            //ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            return books;
        }



    }

    public static <T extends  Externalizable> void serializeExternal2(Set<T> set, String fileName){


            try(FileOutputStream fos = new FileOutputStream(fileName);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeInt(set.size());
                for(T element : set)
                    element.writeExternal(oos);
                    oos.flush();
            } catch(IOException ex) {
                ex.printStackTrace();
            }
    }

    public static void serializeExternal(Set<Book> books){
//        for (Book book :
//                books) {
//            book.writeExternal();

        try(FileOutputStream fos = new FileOutputStream("books.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeInt(books.size());
            for(Book book : books)
                book.writeExternal(oos);
            oos.flush();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Set<Book> deserializeExternal(){
        Set<Book> books = new HashSet<>();
        try(FileInputStream fis = new FileInputStream("books.txt");
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            int countBooks = ois.readInt();
            for (int i = 0; i < countBooks; i++){
                Book book = new Book();
                book.readExternal(ois);
                books.add(book);
            }

        } catch(IOException ex) {
            //ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            return books;
        }
    }

    public static <T extends  Externalizable> Set<T> deserializeExternal2(String fileName){
        Set<T> set = new HashSet<>();
        try(FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            int count = ois.readInt();
            for (int i = 0; i < count; i++){
                T element = (T) new Object();
                element.readExternal(ois);
                set.add(element);
            }

        } catch(IOException ex) {
            //ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            return set;
        }
    }


    public static <T extends  Externalizable, E> T universalDeserialize(Class objectClass, String fileName){
        //Set<E> container = new HashSet<>();
        //Method method = objectClass.getConstructors();
        Collection<E> container = (Collection<E>) new Object();
        try(FileInputStream fis = new FileInputStream("books.txt");
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            int count = ois.readInt();
            for (int i = 0; i < count; i++){
                T element = (T) new Object();
                element.readExternal(ois);
                container.add((E) element);
            }

        } catch(IOException ex) {
            //ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            return (T) new Object();
        }

    }


    public static <T extends  Externalizable> Set<T> universalDeserialize2( String fileName){
        //Set<E> container = new HashSet<>();
        //Method method = objectClass.getConstructors();
        Set<T> container = new HashSet<T>();
        try(FileInputStream fis = new FileInputStream("books.txt");
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            int count = ois.readInt();
            for (int i = 0; i < count; i++){
                T element = (T) new Object();
                element.readExternal(ois);
                container.add((T) element);
            }

        } catch(IOException ex) {
            //ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            return container;
        }

    }
}
