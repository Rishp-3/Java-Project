package practice.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/** Module 22 - Annotations: custom annotations plus a tiny reflection-based validator. */
public final class AnnotationProblems {
    private AnnotationProblems() {}

    /** Sample model using the annotations. */
    public static class SignUpForm {
        @NotBlank public String username;
        @Range(min = 18, max = 120) public int age;
        @NotBlank(message = "email is required") public String email;

        public SignUpForm(String username, int age, String email) {
            this.username = username;
            this.age = age;
            this.email = email;
        }
    }

    /** Problem 1: validate an object by reading its field annotations; returns human-readable errors. */
    public static List<String> validate(Object target) throws IllegalAccessException {
        List<String> errors = new ArrayList<>();
        for (Field f : target.getClass().getDeclaredFields()) {
            Object value = f.get(target);
            NotBlank nb = f.getAnnotation(NotBlank.class);
            if (nb != null && (value == null || value.toString().isBlank())) {
                errors.add(f.getName() + " " + nb.message());
            }
            Range r = f.getAnnotation(Range.class);
            if (r != null) {
                int v = (Integer) value;
                if (v < r.min() || v > r.max()) errors.add(f.getName() + " must be between " + r.min() + " and " + r.max());
            }
        }
        return errors;
    }

    /** Problem 2: count methods carrying a given annotation (works for any annotation type). */
    public static int countAnnotatedMethods(Class<?> type, Class<? extends Annotation> annotation) {
        int count = 0;
        for (Method m : type.getDeclaredMethods()) {
            if (m.isAnnotationPresent(annotation)) count++;
        }
        return count;
    }

    /** Sample class for problem 2 using a built-in annotation. */
    public static class Legacy {
        @Deprecated public void oldA() { }
        @Deprecated public void oldB() { }
        public void current() { }
    }
}
