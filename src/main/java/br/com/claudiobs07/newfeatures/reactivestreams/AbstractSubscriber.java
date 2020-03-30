package br.com.claudiobs07.newfeatures.reactivestreams;

import java.util.concurrent.Flow;
import java.util.function.Consumer;

public class AbstractSubscriber<T> implements Flow.Subscriber<T> {

    private Flow.Subscription subscription;
    private String            name;
    private Consumer<T>       consumer;

    public AbstractSubscriber(String name, Consumer<T> consumer) {
	this.name = name;
	this.consumer = consumer;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
	System.out.println(name + " subscribed!");
	this.subscription = subscription;
	subscription.request(1);
    }

    @Override
    public void onNext(T item) {
	consumer.accept(item);
	subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
	System.err.println(name + " got an error: " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
	System.out.println(name + " completed.");
    }

}
