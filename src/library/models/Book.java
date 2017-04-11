package library.models;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

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

    public void print(){
        System.out.println(Book.class.getCanonicalName());
        for (Method met :
                this.getClass().getMethods()) {
            System.out.println(met.getName());
            System.out.println(met.getReturnType().getName());
            for (Parameter param:
                 met.getParameters()) {
                System.out.println(param.getName() + " " + param.getType().getName());
            }
            System.out.println(met.getModifiers());
        }
        try {
            for (Field field :
                    Class.forName("library.models.Book").getFields()) {
                System.out.println(field.getName());
                System.out.println(field.getType().getName());
                System.out.println(field.isAccessible());

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

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

    public String getClassXml(){
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = null;
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("Book");
            Element fieldsElement = doc.createElement("Fields");
            Element methodsElement = doc.createElement("Methods");

            doc.appendChild(rootElement);
            rootElement.appendChild(fieldsElement);
            rootElement.appendChild(methodsElement);

            Class c = this. getClass();
            Field[] f = this.getClass().getDeclaredFields();
            for (Field field :
                    this.getClass().getDeclaredFields()) {
                Element el = doc.createElement("Field");
                el.setAttribute("Name", field.getName());
                fieldsElement.appendChild(el);
            }

            for (Method met :
                    this.getClass().getMethods()) {
                Element el = doc.createElement("Method");
                el.setAttribute("Name", met.getName());
                methodsElement.appendChild(el);
            }




            TransformerFactory transformerFactory =
                    TransformerFactory.newInstance();
            Transformer transformer =
                    transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            StreamResult consoleResult =
                    new StreamResult(System.out);
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, consoleResult);

        } catch (Exception ex){

        }
        return "";
    }

}
