package ru.bmstu.lab01.task_54;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;
/** Тесты задачи 54 */
class Task54Test {
    @Test
    void normal() {
        assertEquals(15, Task54.solve(new int[][] {{1,2,3},{4,5,6},{7,8,9}}));
    }
    @Test
    void one() {
        assertEquals(-8, Task54.solve(new int[][] {{-8}}));
    }
    @Test
    void negative() {
        assertEquals(-6, Task54.solve(new int[][] {{-1,2},{3,-5}}));
    }
    @Test
    void large() {
        assertEquals(4294967294L, Task54.solve(new int[][] {{Integer.MAX_VALUE,0},{0,Integer.MAX_VALUE}}));
    }
    @Test void badShape() {
        assertThrows(IllegalArgumentException.class, () -> Task54.solve(null));
        assertThrows(IllegalArgumentException.class, () -> Task54.solve(new int[][] {{1, 2}}));
        assertThrows(IllegalArgumentException.class, () -> Task54.solve(new int[][] {{1, 2}, null}));
    }
    @Test
    void console() {
        checkIO("3 3\n1 2 3\n4 5 6\n7 8 9\n", "15\n");
    }
    private void checkIO(String input, String expected) {
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        try (PrintStream out = new PrintStream(buf, true, StandardCharsets.UTF_8)) {
            Task54.run(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)), out);
        }
        assertEquals(expected.replace("\n", System.lineSeparator()), buf.toString(StandardCharsets.UTF_8));
    }
}
