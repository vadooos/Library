package library.utils;

import library.models.Book;
import sun.misc.IOUtils;

import java.io.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class DataManager {


//    public static Set<Book> deserializeExternal(){
//        Set<Book> books = new HashSet<>();
//        try(FileInputStream fis = new FileInputStream("books.txt");
//            ObjectInputStream ois = new ObjectInputStream(fis)) {
//            int countBooks = ois.readInt();
//            for (int i = 0; i < countBooks; i++){
//                Book book = new Book();
//                book.readExternal(ois);
//                books.add(book);
//            }
//
//        } catch(IOException ex) {
//            //ex.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            return books;
//        }
//    }
//
//    public static <T extends  Externalizable> Set<T> deserializeExternal2(String fileName){
//        Set<T> set = new HashSet<>();
//        try(FileInputStream fis = new FileInputStream(fileName);
//            ObjectInputStream ois = new ObjectInputStream(fis)) {
//            int count = ois.readInt();
//            for (int i = 0; i < count; i++){
//                T element = (T) new Object();
//                element.readExternal(ois);
//                set.add(element);
//            }
//
//        } catch(IOException ex) {
//            //ex.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            return set;
//        }
//    }
//
//
//
//    public static <T extends  Externalizable> Set<T> universalDeserialize2( String fileName) {
//        //Set<E> container = new HashSet<>();
//        //Method method = objectClass.getConstructors();
//        Set<T> container = new HashSet<T>();
//        try (FileInputStream fis = new FileInputStream("books.txt");
//             ObjectInputStream ois = new ObjectInputStream(fis)) {
//            int count = ois.readInt();
//            for (int i = 0; i < count; i++) {
//                T element = (T) new Object();
//                element.readExternal(ois);
//                container.add((T) element);
//            }
//
//        } catch (IOException ex) {
//            //ex.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            return container;
//        }
//    }
//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public static <T> void serializeToFile(T object, String filename) {
        try(FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(object);
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public static <T> T deserialize(T objectForType, String filename) {
        T object = null;
        try(InputStream is = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(is)) {
            object = (T) ois.readObject();
        } catch(IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            return object;
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


    public static<T extends Externalizable> void serializeExternal(Set<T> set, String fileName) {
        try(FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeInt(set.size());
            for(T t : set)
                t.writeExternal(oos);
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

}
