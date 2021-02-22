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
        data = new int[container.getCapacity()];
        for (int i = 0; i < size; i++) {
            data[i] = container.getItem(i);
        }
    }

    @AfterEach
    void tearDown() {
        container = null;
    }

    @Test
    void push() {
        container.push(1);
        assertEquals(size + 1, container.getSize());

        for (int i = 0; i < size; i++) {
            assertEquals(data[i], container.getItem(i));
        }

        assertEquals(1, container.getItem(size));
    }

    @Test
    void insert() {

        // start of container
        insertStep(111, 0);

        // middle of container
        insertStep(222, 2);

        // end of container
        insertStep(333, size - 1);
        insertStep(444, size);
    }

    void insertStep(int num, int index) {
        container.insert(num, index);
        assertEquals(size + 1, container.getSize());

        assertEquals(num, container.getItem(index));

        for (int i = 0; i < index; i++) {
            assertEquals(data[i], container.getItem(i));
        }

        for (int i = index + 1; i < size + 1; i++) {
            assertEquals(data[i - 1], container.getItem(i));
        }

        container.copy(container.getData(), data);
        size = container.getSize();
    }

    @Test
    void remove() {
        int index = 1;
        container.remove(index);

        assertEquals(size - 1, container.getSize());
        for (int i = 0; i < index; i++) {
            assertEquals(data[i], container.getItem(i));
        }
        for (int i = index; i < size - 1; i++) {
            assertEquals(data[i + 1], container.getData()[i]);
        }
    }

    @Test
    void  getIndex() {
        assertEquals(0, container.getIndex(1));
        assertEquals(1, container.getIndex(2));
        assertEquals(2, container.getIndex(3));
        assertEquals(-1, container.getIndex(555));
    }

    @Test
    void getItem() {
        assertEquals(1, container.getItem(0));
        assertEquals(2, container.getItem(1));
        assertEquals(3, container.getItem(2));
    }

    @Test
    void count() {
        assertEquals(1, container.count(2));
        container.push(2);
        assertEquals(2, container.count(2));

        assertEquals(0, container.count(12));
    }

    @Test
    void copy() {
        Container newContainer = new Container(container.getCapacity());
        container.copy(data, newContainer.getData());

        for (int i = 0; i < size; i++) {
            assertEquals(data[i], newContainer.getItem(i));
        }
    }
}