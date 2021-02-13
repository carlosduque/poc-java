package o.avro;

import o.Serializer;
import o.beans.Author;
import o.beans.Book;
import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class AvroSerializer implements Serializer {

    private Schema schema = null;

    public AvroSerializer(String schema) {
        if (null == schema || schema.isEmpty())
            throw new IllegalArgumentException("Schema cant be null nor empty");

        try {
            this.schema = new Schema.Parser().parse(new File(schema));
        } catch (Exception e) {
            System.err.println("Exception parsing schema: " + schema);
        }
    }

    @Override
    public void serialize(Author author, File out) {
        GenericRecord record = new GenericData.Record(schema);

        record.put("name", author.getName());
        record.put("lastname", author.getLastname());
        record.put("books", author.getBooks());

        DatumWriter<GenericRecord> writer = new GenericDatumWriter<GenericRecord>(schema);
        //DataFileWriter<GenericRecord> fileWriter = new DataFileWriter<GenericRecord>(writer);

        try (DataFileWriter<GenericRecord> fileWriter = new DataFileWriter<GenericRecord>(writer);) {
            fileWriter.create(schema, out);
            fileWriter.append(record);
        } catch (IOException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public Author deserialize(final File in) {
        DatumReader<GenericRecord> reader = new GenericDatumReader<GenericRecord>(schema);
        GenericRecord record = null;
        try (DataFileReader<GenericRecord> fileReader = new DataFileReader<GenericRecord>(in, reader);) {
            while (fileReader.hasNext()) {
                // Reuse user object by passing it to next(). This saves us from
                // allocating and garbage collecting many objects for files with
                // many items.
                record = fileReader.next(record);
            }
        } catch (IOException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        String name = record.get("name").toString();
        String lastname = record.get("lastname").toString();
        List<Book> books = (List<Book>) record.get("books");
        Author author = new Author(name, lastname, books);
        return author;
    }
}
