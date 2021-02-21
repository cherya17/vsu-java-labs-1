import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    private Container container;
    private int size;
    private int[] data;

    @BeforeEach
    void setUp() {
        container = new Container(new int[] {1, 2, 3});
        size = container.getSize();
        data = container.getData();
    }

    @AfterEach
    void tearDown() {
        container = null;
    }

    @Test
    void add() {
        container.add(1);
        assertEquals(size + 1, container.getSize());
        int[] newData = new int[size + 1];
        container.copy(data, newData);
        newData[size + 1] = 1;
        assertArrayEquals(newData, container.getData());
    }

    @Test
    void getSize() {
    }

    @Test
    void getData() {
    }
}