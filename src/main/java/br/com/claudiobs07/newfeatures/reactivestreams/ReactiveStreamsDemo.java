package br.com.claudiobs07.newfeatures.reactivestreams;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ReactiveStreamsDemo {

    private static final List<String> WEATHER_LIST = List.of("☁️", "☀️", "⛅", "🌧", "⛈️");

    public static void main(String[] args) throws InterruptedException {

        Supplier<? extends String> randomWeatherSupplier = () ->
                        WEATHER_LIST.get(new Random().nextInt(WEATHER_LIST.size())) + " " + (new Random().nextInt(90)) + "°F";

        PeriodicPublisher<String> weatherPublisher = new PeriodicPublisher<>(ForkJoinPool.commonPool(), 10,
                                                                             randomWeatherSupplier, 1, TimeUnit.SECONDS);

        weatherPublisher.subscribe(new AbstractSubscriber<>("Twitter Subscriber", (report) -> System.out.println("Twitting " + report)));

        weatherPublisher.subscribe(new AbstractSubscriber<>("Storage Subscriber", getStorageConsumer()));

        for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                weatherPublisher.submit(randomWeatherSupplier.get());
        }

        weatherPublisher.close();
    }


    private static Consumer<String> getStorageConsumer() {
        return (report) -> {
            try {
                Thread.sleep(1500);
                System.out.println("Storage " + report);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        };
    }

}
