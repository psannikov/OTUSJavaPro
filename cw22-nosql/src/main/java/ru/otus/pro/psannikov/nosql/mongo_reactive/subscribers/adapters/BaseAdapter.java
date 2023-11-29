package ru.otus.pro.psannikov.nosql.mongo_reactive.subscribers.adapters;

import com.mongodb.Function;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

class BaseAdapter<P, S> implements Publisher<P>, Subscriber<S> {

    private final Function<S, P> convert;
    private Subscription subscription;
    private Subscriber<? super P> subscriber;

    protected BaseAdapter(Function<S, P> convert, Publisher<S> publisher) {
        this.convert = convert;
        publisher.subscribe(this);
    }

    // ---------- Publisher ----------

    @Override
    public void subscribe(Subscriber<? super P> subscriber) {
        this.subscriber = subscriber;
        subscriber.onSubscribe(subscription);
    }

    // ---------- Subscriber ----------

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
    }

    @Override
    public void onNext(S item) {
        subscriber.onNext(convert.apply(item));
    }

    @Override
    public void onError(Throwable e) {
        subscriber.onError(e);
    }

    @Override
    public void onComplete() {
        subscriber.onComplete();
    }

}
