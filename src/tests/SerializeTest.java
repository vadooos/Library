package tests;



import library.models.Book;
import library.utils.DataManager;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;


import java.io.*;
import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Created by vadim on 10.04.2017.
 */
public class SerializeTest {
    private static DataManager dataManager;

    /*@Test
    public void testDeSerilizationBook(){
        File file = mock(File.class);
        FileReader fileReader = mock(FileReader.class);
        BufferedReader bufferedReader = mock(BufferedReader.class);

        StringBuilder stringBuilder = new StringBuilder();
        try(FileInputStream fis = new FileInputStream("books.txt");
            ObjectInputStream ois = new ObjectInputStream(fis)) {

            Set<Book> collection = dataManager.deserializeOne(bufferedReader.readLine());
            Book book = collection.iterator().next();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @BeforeClass
    public static void init(){

    }*/
}
