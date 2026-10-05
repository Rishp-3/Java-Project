# Ticket Booking System

## 📌 Topic
Movie ticket booking simulation jisme seats ka 2D array hota hai, seats book/cancel hote hain aur multiple threads ke saath bhi overbooking nahi hoti.

## 🎯 What You Will Learn

- 2D array se seat map
- Seat booking logic
- `synchronized` se thread-safety
- Cancel aur available seats

## 💻 Code

```java
public class TicketBookingSystem {

    static class Theatre {
        private final boolean[][] seats = new boolean[3][4];

        synchronized boolean book(int row, int col, String who) {
            if (seats[row][col]) {
                System.out.println(who + ": Seat " + label(row, col) + " already booked");
                return false;
            }
            seats[row][col] = true;
            System.out.println(who + ": Booked " + label(row, col));
            return true;
        }

        synchronized boolean cancel(int row, int col) {
            if (!seats[row][col]) return false;
            seats[row][col] = false;
            System.out.println("Cancelled " + label(row, col));
            return true;
        }

        private String label(int row, int col) {
            return "" + (char) ('A' + row) + (col + 1);
        }

        synchronized int available() {
            int c = 0;
            for (boolean[] r : seats) for (boolean s : r) if (!s) c++;
            return c;
        }

        void show() {
            for (int i = 0; i < seats.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < seats[i].length; j++) {
                    sb.append(seats[i][j] ? "[X] " : "[ ] ");
                }
                System.out.println((char) ('A' + i) + " " + sb);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Theatre t = new Theatre();

        t.book(0, 0, "Rishabh");
        t.book(0, 1, "Amit");
        t.book(0, 0, "Neha");
        t.cancel(0, 1);
        t.show();
        System.out.println("Available: " + t.available());

        Thread[] users = new Thread[5];
        for (int i = 0; i < users.length; i++) {
            users[i] = new Thread(() -> t.book(2, 3, Thread.currentThread().getName()));
            users[i].setName("User" + i);
        }
        for (Thread u : users) u.start();
        for (Thread u : users) u.join();

        System.out.println("Available after race: " + t.available());
    }
}
```

> 💡 Note: Demo ke liye values code me hi di gayi hain. Last 5 threads ka order har run me alag ho sakta hai, par seat `C4` sirf ek hi user ko milti hai.

## 🧠 Explanation

### `boolean[][] seats`
`true` = booked, `false` = khali. Row = A, B, C aur column = 1 se 4.

### `synchronized book()`
5 threads ek hi seat (C4) book karne aayein to sirf ek ko mile. Baaki ko `already booked` message milta hai.

### `label()`
Row/column index ko `A1`, `B3` jaise seat naam me badalta hai.

## ▶️ Output

```text
Rishabh: Booked A1
Amit: Booked A2
Neha: Seat A1 already booked
Cancelled A2
A [X] [ ] [ ] [ ] 
B [ ] [ ] [ ] [ ] 
C [ ] [ ] [ ] [ ] 
Available: 11
User0: Booked C4
User2: Seat C4 already booked
User4: Seat C4 already booked
User1: Seat C4 already booked
User3: Seat C4 already booked
Available after race: 10
```

## 🔑 Important Points

- Without `synchronized` do threads ek hi seat book kar sakte hain (race condition).
- Real systems me database transactions aur locks seats ko protect karte hain.
- Seat map ko `ReentrantReadWriteLock` ya `ConcurrentHashMap` se bhi bana sakte hain.

## 📝 Practice

1. Ek saath multiple seats book karne ka option jodo.
2. Ticket price (row ke hisab se) jodo.
3. Booking ID generate karo.
4. Booking history rakho.

## 🚀 Challenge

Theatre me `Show` class jodo (alag shows ke alag seat maps).
