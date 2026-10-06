package practice.annotations;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import practice.annotations.AnnotationProblems.SignUpForm;

class AnnotationProblemsTest {
    @Test void validFormHasNoErrors() throws Exception {
        assertTrue(AnnotationProblems.validate(new SignUpForm("rishabh", 25, "r@example.com")).isEmpty());
    }
    @Test void reportsEveryProblem() throws Exception {
        List<String> errors = AnnotationProblems.validate(new SignUpForm(" ", 12, null));
        assertEquals(List.of("username must not be blank", "age must be between 18 and 120", "email email is required"), errors);
    }
    @Test void customAnnotationDefaultsAndRetention() throws Exception {
        Range r = SignUpForm.class.getField("age").getAnnotation(Range.class);
        assertEquals(18, r.min());
        assertEquals(0, Range.class.getMethod("min").getDefaultValue());
    }
    @Test void countsAnnotatedMethods() {
        assertEquals(2, AnnotationProblems.countAnnotatedMethods(AnnotationProblems.Legacy.class, Deprecated.class));
        assertEquals(0, AnnotationProblems.countAnnotatedMethods(AnnotationProblems.Legacy.class, FunctionalInterface.class));
    }
}
