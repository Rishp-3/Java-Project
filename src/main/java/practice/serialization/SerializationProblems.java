package practice.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/** Module 21 - Serialization: turning objects into bytes and back, transient fields, deep copies. */
public final class SerializationProblems {
    private SerializationProblems() {}

    /** Problem 1: a class whose password must NOT be written out (transient). */
    public static class User implements Serializable {
        private static final long serialVersionUID = 1L;
        public final String name;
        public final transient String password;
        public final int[] scores;

        public User(String name, String password, int[] scores) {
            this.name = name;
            this.password = password;
            this.scores = scores;
        }
    }

    /** Problem 2: serialise any Serializable object to bytes. */
    public static byte[] toBytes(Serializable obj) throws IOException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        try (ObjectOutputStream out = new ObjectOutputStream(bytes)) {
            out.writeObject(obj);
        }
        return bytes.toByteArray();
    }

    /** Problem 3: read an object back, checking it is the type you expect. */
    public static <T> T fromBytes(byte[] data, Class<T> type) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(data))) {
            return type.cast(in.readObject());
        }
    }

    /** Problem 4: deep copy through a serialisation round trip. */
    public static <T extends Serializable> T deepCopy(T original, Class<T> type) throws IOException, ClassNotFoundException {
        return fromBytes(toBytes(original), type);
    }

    /** An object that is deliberately NOT serialisable. */
    public static class Unserializable {
        public final int x = 1;
    }

    /** Holder to show that one non-serialisable field breaks the whole object graph. */
    @SuppressWarnings("serial") // the non-serialisable field is the whole point of this example
    public static class Wrapper implements Serializable {
        private static final long serialVersionUID = 1L;
        public final Unserializable inner = new Unserializable();
    }
}
