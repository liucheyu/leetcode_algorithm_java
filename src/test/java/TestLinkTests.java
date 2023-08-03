import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class TestLinkTests {
    @Test
    void testLinkTest() {
        LinkedList s = new LinkedList();
        s.add(0);
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        s.add(5);
        s.add(6);
        s.add(7);

        s.remove(4);

        s.forEach(System.out::println);

    }
}
