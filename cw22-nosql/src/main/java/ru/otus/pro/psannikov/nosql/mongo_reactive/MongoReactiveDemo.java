package ru.otus.pro.psannikov.nosql.mongo_reactive;

import ru.otus.pro.psannikov.nosql.domain.BookMongo;
import ru.otus.pro.psannikov.nosql.mongo_reactive.repository.BookRepository;
import ru.otus.pro.psannikov.nosql.mongo_reactive.subscribers.SetSubscriber;
import ru.otus.pro.psannikov.nosql.mongo_reactive.subscribers.SingleSubscriber;
import ru.otus.pro.psannikov.nosql.mongo_reactive.subscribers.SubscriberFactory;

/*
 * 1. docker pull mongo
 * 2. docker run -p 27017:27017 --name mongo -d mongo:latest
 */
public class MongoReactiveDemo {

    private static final String HOST_NAME = "localhost";
    private static final int PORT = 27017;

    private static final String DATABASE_NAME = "library";

    public static void main(String... args) throws Exception {
        try (MongoReactiveClient reactiveClient = MongoReactiveClient.create(HOST_NAME, PORT)) {
            reactiveClient.useDatabase(DATABASE_NAME);
            foo(reactiveClient);
            reactiveClient.deleteDatabase();
        }
    }

    private static void foo(MongoReactiveClient reactiveClient) throws InterruptedException {
        printDatabaseNames(reactiveClient);

        BookRepository bookRepository = new BookRepository(reactiveClient);
        bookRepository.createCollection();

        printCollections(reactiveClient);

        BookMongo book = BookMongo.builder()
                        .title("Effective Java")
                        .author("Joshua Bloch")
                        .subject("Programming")
                        .build();

        String id = insertBook(book, bookRepository);
        insertBook(BookMongo.builder()
                       .title("Design Patterns")
                       .author("Erich Gamma")
                       .subject("Programming")
                       .build(), bookRepository);

        printAllBooks(bookRepository);

        BookMongo updateBook = book.toBuilder()
                              .id(id)
                              .publisher("O'Reilly")
                              .build();
        updateBook(updateBook, bookRepository);

        printAllBooks(bookRepository);
        findAllByTitle(book, bookRepository);
        deleteAllByTitle(book, bookRepository);

        bookRepository.deleteCollection();
    }

    private static void printDatabaseNames(MongoReactiveClient reactiveClient) {
        System.out.println("+++ Existed databases:");
        SetSubscriber<String> subscriber = SubscriberFactory.setSubscriber("DatabaseName");
        reactiveClient.getDatabaseNames().subscribe(subscriber);
        subscriber.getItems().forEach(System.out::println);
    }

    private static void printCollections(MongoReactiveClient reactiveClient) {
        System.out.format("\nExisted collections in database '%s':\n", reactiveClient.getCurrentDatabasedName());
        SetSubscriber<String> subscriber = SubscriberFactory.setSubscriber("Collections");
        reactiveClient.getCollectionNames().subscribe(subscriber);
        subscriber.getItems().forEach(System.out::println);
    }

    private static String insertBook(BookMongo book, BookRepository bookRepository) throws InterruptedException {
        SingleSubscriber<String> subscriber = SubscriberFactory.singleSubscriber("InsertBook");
        bookRepository.insert(book).subscribe(subscriber);
        String id = subscriber.getItem();
        System.out.format("\nInsert book id = '%s'\n", id);
        return id;
    }

    private static void printAllBooks(BookRepository bookRepository) {
        System.out.format("\nBooks in collection '%s':\n", ru.otus.pro.psannikov.nosql.mongo.repository.BookRepository.COLLECTION_NAME);
        SetSubscriber<BookMongo> subscriber = SubscriberFactory.setSubscriber("FindAll");
        bookRepository.findAll().subscribe(subscriber);
        subscriber.getItems().forEach(System.out::println);
    }

    private static void updateBook(BookMongo book, BookRepository bookRepository) {
        System.out.format("\nUpdate book id = '%s':\n", book.getId());
        SingleSubscriber<Boolean> subscriber = SubscriberFactory.singleSubscriber("UpdateBook");
        bookRepository.update(book).subscribe(subscriber);
        boolean updated = subscriber.getItem();
    }

    private static void findAllByTitle(BookMongo book, BookRepository bookRepository) {
        System.out.format("\nBooks in collection '%s' with title '%s':\n",
                ru.otus.pro.psannikov.nosql.mongo.repository.BookRepository.COLLECTION_NAME, book.getTitle());
        SetSubscriber<BookMongo> subscriber = SubscriberFactory.setSubscriber("FindAllByTitle");
        bookRepository.findAllByTitle(book.getTitle()).subscribe(subscriber);
        subscriber.getItems().forEach(System.out::println);
    }

    private static void deleteAllByTitle(BookMongo book, BookRepository bookRepository) {
        SingleSubscriber<Long> subscriber = SubscriberFactory.singleSubscriber("DeleteBook");
        bookRepository.deleteAllByTitle(book.getTitle()).subscribe(subscriber);
        long totalRemoved = subscriber.getItem();
        System.out.format("\nTotal %d documents were removed\n", totalRemoved);
    }

}
