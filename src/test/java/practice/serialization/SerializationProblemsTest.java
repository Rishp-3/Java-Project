package practice.serialization;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.NotSerializableException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import practice.serialization.SerializationProblems.User;

class SerializationProblemsTest {
    @Test void roundTripKeepsDataButNotTransientFields() throws Exception {
        User u = new User("rishabh", "s3cret", new int[] {1, 2, 3});
        User copy = SerializationProblems.fromBytes(SerializationProblems.toBytes(u), User.class);
        assertEquals("rishabh", copy.name);
        assertArrayEquals(new int[] {1, 2, 3}, copy.scores);
        assertNull(copy.password);
    }
    @Test void deepCopyIsIndependent() throws Exception {
        ArrayList<List<Integer>> original = new ArrayList<>();
        original.add(new ArrayList<>(List.of(1, 2)));
        ArrayList<List<Integer>> copy = copyOf(original);
        copy.get(0).add(3);
        assertEquals(List.of(1, 2), original.get(0));
        assertEquals(List.of(1, 2, 3), copy.get(0));
    }
    @SuppressWarnings("unchecked")
    private static ArrayList<List<Integer>> copyOf(ArrayList<List<Integer>> in) throws Exception {
        return SerializationProblems.deepCopy(in, (Class<ArrayList<List<Integer>>>) (Class<?>) ArrayList.class);
    }
    @Test void nonSerializableFieldFails() {
        assertThrows(NotSerializableException.class, () -> SerializationProblems.toBytes(new SerializationProblems.Wrapper()));
    }
    @Test void wrongTypeIsRejected() throws IOException {
        byte[] bytes = SerializationProblems.toBytes("just a string");
        assertThrows(ClassCastException.class, () -> SerializationProblems.fromBytes(bytes, Integer.class));
    }
}
