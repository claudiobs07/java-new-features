package br.com.claudiobs07.newfeatures.reactivestreams;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ReactiveStreamsDemo {

    public static void main(String[] args) throws InterruptedException {
        Supplier<? extends String> randomWeatherSupplier = () -> List.of("☁️", "☀️", "⛅", "🌧", "⛈️").get(new Random().nextInt(5)) + " "
                + (new Random().nextInt(90)) + "°F";

//        PeriodicPublisher<String> weatherPublisher = new PeriodicPublisher<String>(ForkJoinPool.commonPool(), 10,
//                randomWeatherSupplier,
//                1, TimeUnit.SECONDS);

        SubmissionPublisher<String> weatherPublisher = new SubmissionPublisher<>();

        weatherPublisher.subscribe(new AbstractSubscriber<>("Twitter Subscriber",
                (report) -> {
                    System.out.println("Twitting " + report);
                }));

        weatherPublisher.subscribe(new AbstractSubscriber<>("Storage Subscriber",
                (report) -> {
                    try {
                        Thread.sleep(1500);
                        System.out.println("Storage " + report);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }));

        for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                weatherPublisher.submit(randomWeatherSupplier.get());
        }

        weatherPublisher.close();
    }

    public static class AbstractSubscriber<T> implements Flow.Subscriber<T> {
        private Flow.Subscription subscription;
        private String name;
        private Consumer<T> consumer;

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
    };




    /**
     * Example from the JavaDoc for java.util.concurrent.SubmissionPublisher<T>
     */
    public static class PeriodicPublisher<T> extends SubmissionPublisher<T> {
        final ScheduledFuture<?> periodicTask;
        final ScheduledExecutorService scheduler;

        PeriodicPublisher(Executor executor, int maxBufferCapacity, Supplier<? extends T> supplier, long period,
                          TimeUnit unit) {
            super(executor, maxBufferCapacity);
            scheduler = new ScheduledThreadPoolExecutor(1);
            periodicTask = scheduler.scheduleAtFixedRate(() -> submit(supplier.get()), 0, period, unit);
        }

        public void close() {
            periodicTask.cancel(false);
            scheduler.shutdown();
            super.close();
        }
    }

}
