import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class SILab2Test {

    @Test
    public void testEveryStatement() {
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, "123"));

        Item invalid = new Item("", 1, 100, 0);
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(invalid), "123"));

        Item valid1 = new Item("A", 5, 400, 0.1);
        assertEquals(-30 + 5 * 400 * 0.9, SILab2.checkCart(List.of(valid1), "1234567812345678"));

        Item valid2 = new Item("B", 2, 100, 0);
        assertEquals(200, SILab2.checkCart(List.of(valid2), "1234567812345678"));

        Item invalidCard = new Item("C", 1, 100, 0);
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(invalidCard), "123ABC"));
    }

    @Test
    public void testMultipleCondition() {
        Item a = new Item("A", 1, 500, 0);
        Item b = new Item("B", 1, 100, 0.2);
        Item c = new Item("C", 15, 100, 0);
        Item d = new Item("D", 1, 100, 0);

        assertTrue(SILab2.checkCart(List.of(a), "1234567812345678") < 500);
        assertTrue(SILab2.checkCart(List.of(b), "1234567812345678") < 100);
        assertTrue(SILab2.checkCart(List.of(c), "1234567812345678") < 1500);
        assertEquals(100, SILab2.checkCart(List.of(d), "1234567812345678"));
    }
}
