import java.util.ArrayList;
import java.util.List;

public class ObserverPatternDemo {

    // Observer: when one object (the Subject) changes state, all its dependents
    // (Observers) are notified automatically. Used in event systems, GUIs, pub/sub.
    interface Observer {
        void update(String news);
    }

    static class NewsAgency {
        private final List<Observer> subscribers = new ArrayList<>();

        void subscribe(Observer observer) {
            subscribers.add(observer);
        }

        void unsubscribe(Observer observer) {
            subscribers.remove(observer);
        }

        void publishNews(String news) {
            System.out.println("\n[NewsAgency] Publishing: " + news);
            for (Observer observer : subscribers) {
                observer.update(news);
            }
        }
    }

    static class NewsChannel implements Observer {
        private final String name;

        NewsChannel(String name) {
            this.name = name;
        }

        @Override
        public void update(String news) {
            System.out.println(name + " received breaking news: " + news);
        }
    }

    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        NewsChannel cnn = new NewsChannel("CNN");
        NewsChannel bbc = new NewsChannel("BBC");
        NewsChannel local = new NewsChannel("Local News");

        agency.subscribe(cnn);
        agency.subscribe(bbc);
        agency.subscribe(local);

        agency.publishNews("Java 25 has been released!");

        agency.unsubscribe(local);
        agency.publishNews("Stock markets hit an all-time high.");
    }
}
