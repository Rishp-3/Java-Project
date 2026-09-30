public class GenericClassDemo {

    // A generic class: <T> is a placeholder for a type, decided when the object is created
    static class Box<T> {
        private T content;

        void set(T content) {
            this.content = content;
        }

        T get() {
            return content;
        }
    }

    // A generic class with two type parameters
    static class Pair<K, V> {
        K key;
        V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + " = " + value;
        }
    }

    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello Generics");
        System.out.println(stringBox.get());

        Box<Integer> intBox = new Box<>();
        intBox.set(123);
        System.out.println(intBox.get());

        // Without generics we'd need Object and manual casting - generics give compile-time safety
        Pair<String, Integer> pair = new Pair<>("Age", 22);
        System.out.println(pair);
    }
}
