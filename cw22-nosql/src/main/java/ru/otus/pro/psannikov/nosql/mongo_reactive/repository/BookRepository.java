package ru.otus.pro.psannikov.nosql.mongo_reactive.repository;

import com.mongodb.BasicDBObject;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.reactivestreams.client.FindPublisher;
import lombok.RequiredArgsConstructor;
import ru.otus.pro.psannikov.nosql.domain.BookMongo;
import ru.otus.pro.psannikov.nosql.mongo_reactive.MongoReactiveClient;
import ru.otus.pro.psannikov.nosql.mongo_reactive.subscribers.adapters.AdapterFactory;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.reactivestreams.Publisher;

@RequiredArgsConstructor
public class BookRepository {

    public static final String COLLECTION_NAME = "books";

    private final MongoReactiveClient reactiveClient;

    public void createCollection() {
        reactiveClient.createCollection(COLLECTION_NAME);
    }

    public void deleteCollection() {
        reactiveClient.deleteCollection(COLLECTION_NAME);
    }

    public Publisher<String> insert(BookMongo book) {
        Document document = new Document()
                .append("title", book.getTitle())
                .append("author", book.getAuthor())
                .append("subject", book.getSubject())
                .append("publisher", book.getPublisher());

        return reactiveClient.insertOne(document, COLLECTION_NAME);
    }

//    public boolean update(Book book) {
//        BasicDBObject update = new BasicDBObject()
//                .append("title", book.getTitle())
//                .append("author", book.getAuthor())
//                .append("subject", book.getSubject())
//                .append("publisher", book.getPublisher());
//
//        UpdateResult res = reactiveClient.updateOne(book.getId(), update, COLLECTION_NAME);
//        return res.getMatchedCount() == 1;
//    }

    public Publisher<Boolean> update(BookMongo book) {
        BasicDBObject update = new BasicDBObject()
                .append("title", book.getTitle())
                .append("author", book.getAuthor())
                .append("subject", book.getSubject())
                .append("publisher", book.getPublisher());

        Publisher<UpdateResult> publisher = reactiveClient.updateOne(book.getId(), update, COLLECTION_NAME);
        return AdapterFactory.booleanPublisher(publisher, 1);
    }

    public FindPublisher<BookMongo> findAll() {
        return AdapterFactory.findPublisher(reactiveClient.find(COLLECTION_NAME),
                                            BookRepository::createBook);
    }

    public FindPublisher<BookMongo> findAllByTitle(String title) {
        Bson filter = Filters.eq("title", title);
        return AdapterFactory.findPublisher(reactiveClient.find(filter, COLLECTION_NAME),
                                            BookRepository::createBook);
    }

    public Publisher<Long> deleteAllByTitle(String title) {
        Bson filter = Filters.eq("title", title);
        Publisher<DeleteResult> publisher = reactiveClient.delete(filter, COLLECTION_NAME);
        return AdapterFactory.longPublisher(publisher);
    }

    private static BookMongo createBook(Document document) {
        Object id = document.get("_id");

        return BookMongo.builder()
                   .id(id instanceof ObjectId ? ((ObjectId) id).toHexString() : String.valueOf(id))
                   .title(document.getString("title"))
                   .author(document.getString("author"))
                   .subject(document.getString("subject"))
                   .publisher(document.getString("publisher"))
                   .build();
    }

}
