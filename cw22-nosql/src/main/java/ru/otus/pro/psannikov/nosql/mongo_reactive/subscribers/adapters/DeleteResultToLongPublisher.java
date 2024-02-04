package ru.otus.pro.psannikov.nosql.mongo_reactive.subscribers.adapters;

import com.mongodb.client.result.DeleteResult;
import org.reactivestreams.Publisher;

final class DeleteResultToLongPublisher extends BaseAdapter<Long, DeleteResult> {

    public DeleteResultToLongPublisher(Publisher<DeleteResult> publisher) {
        super(DeleteResult::getDeletedCount, publisher);
    }

}
