package practice.packages.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/** Lives in the SAME package as TextUtil, so it can also test the package-private normalize(). */
class TextUtilTest {
    @Test void titleCase() {
        assertEquals("Hello World", TextUtil.titleCase("  hELLO    wORLD "));
        assertEquals("", TextUtil.titleCase("   "));
    }
    @Test void slugify() {
        assertEquals("hello-world", TextUtil.slugify("Hello,  World!"));
        assertEquals("java-17-rocks", TextUtil.slugify(" Java 17 Rocks "));
    }
    @Test void packagePrivateNormalize() {
        assertEquals("a b c", TextUtil.normalize("  a   b \t c "));
    }
}
