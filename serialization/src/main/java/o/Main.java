package o;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import o.Serializer;
import o.avro.AvroSerializer;
import o.beans.Author;
import o.beans.Book;
import o.beans.Employee;
import org.codehaus.jackson.map.ObjectMapper;

public class Main {
    public static void main(String[] args) throws IOException {

        List<Book> books = new ArrayList<Book>(2);
        books.add(new Book("Black", 377));
        books.add(new Book("Bat", 443));
        Author author = new Author("Bruce", "Wayne", books);
        System.out.println(author);
        List<Serializer> serializers = new ArrayList<Serializer>();

        Serializer avro = new AvroSerializer("./serialization/src/main/resources/author.avsc");
        serializers.add(avro);

        System.out.println(":::serializing");
        for (Serializer s : serializers)
            s.serialize(author, new File("author.avro"));
        author = null;
        System.out.println("=====================");

        for (Serializer s : serializers)
            System.out.println(":::deserializing:: " + s.deserialize(new File("author.avro")));

        //Employee employee = new Employee("Anon", "Imo", new Date(), true);
        //System.out.println("employee: " + employee.toString());

        //ObjectMapper mapper = new ObjectMapper();
        //System.out.println("employee json: " + mapper.writeValueAsString(employee));

    }

}
