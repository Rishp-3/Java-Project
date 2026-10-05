# Observer Pattern in Java

## 📌 Topic
Observer pattern me ek object (Subject) ke badalne par uske saare dependent objects (Observers) ko automatically khabar mil jati hai. YouTube subscribe/notification iska example hai.

## 🎯 What You Will Learn

- Observer pattern kya hai
- Subject aur Observer interface
- Subscribe, unsubscribe aur notify
- Loose coupling

## 💻 Code

```java
import java.util.ArrayList;
import java.util.List;

interface Subscriber {
    void update(String video);
}

class Channel {
    private final String name;
    private final List<Subscriber> subscribers = new ArrayList<>();

    Channel(String name) { this.name = name; }

    void subscribe(Subscriber s) { subscribers.add(s); }
    void unsubscribe(Subscriber s) { subscribers.remove(s); }

    void upload(String video) {
        System.out.println(name + " uploaded: " + video);
        for (Subscriber s : subscribers) {
            s.update(video);
        }
    }
}

class User implements Subscriber {
    private final String name;

    User(String name) { this.name = name; }

    public void update(String video) {
        System.out.println("  " + name + " got notification: " + video);
    }
}

public class Observer {
    public static void main(String[] args) {
        Channel channel = new Channel("JavaWithRishabh");

        User a = new User("Amit");
        User b = new User("Neha");

        channel.subscribe(a);
        channel.subscribe(b);
        channel.upload("Java OOP Tutorial");

        channel.unsubscribe(a);
        channel.upload("Java Collections Tutorial");
    }
}
```

## 🧠 Explanation

### `Subscriber (Observer)`
Interface jisme `update()` method hai. Jo bhi khabar chahta hai wo ise implement karta hai.

### `Channel (Subject)`
Subscribers ki list rakhta hai aur `upload()` par sabko notify karta hai.

### `subscribe / unsubscribe`
Runtime par observers ko jod ya hata sakte hain.

## ▶️ Output

```text
JavaWithRishabh uploaded: Java OOP Tutorial
  Amit got notification: Java OOP Tutorial
  Neha got notification: Java OOP Tutorial
JavaWithRishabh uploaded: Java Collections Tutorial
  Neha got notification: Java Collections Tutorial
```

## 🔑 Important Points

- Channel ko ye nahi pata ki subscriber kaun hai, bas `Subscriber` interface pata hai (loose coupling).
- Examples: GUI button listeners, event systems, notifications, stock price alerts.
- Java ka purana `Observable`/`Observer` deprecated hai, apna interface ya `PropertyChangeListener` use karo.

## 📝 Practice

1. Weather station banao jo temperature badalne par displays update kare.
2. Stock price observer banao.
3. Subscriber ko lambda se banao.
4. Unsubscribe ke baad notification na aaye verify karo.

## 🚀 Challenge

`Newsletter` Subject banao jisme `Email` aur `SMS` observers ho.
