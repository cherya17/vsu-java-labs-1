import java.util.Arrays;

public class Container {

    // TODO: добавить константу для изменения capacity

    private int data[];
    private int size;
    private int capacity;

    public static int MinCapacity = 10;

    /**
     * Создаёт контейнер с минимальной вместимостью
     */
    public Container() {
        this.capacity = MinCapacity;
        this.size = 0;
        data = new int[capacity];
    }

    /**
     *
     * @param capacity вместимость контейнера для инициализации
     */
    public Container(int capacity) {
        this.capacity = Math.max(capacity, MinCapacity);
        this.size = 0;
        data = new int[capacity];
    }

    /**
     *
     * @param data элементы для инициализации контейнера
     */
    public Container(int[] data) {
        capacity = Math.max(data.length + 10, MinCapacity);
        size = data.length;
        this.data = new int[capacity];
        copy(data, this.data);
    }

    /**
     * Добавление элемента в контейнер
     * @param num число для добавления в контейнер
     */
    public void add(int num) {
        if (size + 1 >= capacity) {
            increaseContainer(capacity + 10);
        }
        data[size++] = num;
    }

    /**
     * Изменение максимальной вместимости контейнера
     * @param newCapacity новая вместимость контейнера
     */
    private void increaseContainer (int newCapacity) {
        capacity = newCapacity;
        int[] newData = new int[capacity];
        if (size > 0) {
            copy(data, newData);
        }
        data = newData;
    }


    /**
     * Копирование одного массива в другой
     * @param source данные для копирования
     * @param data куда копируются данные
     */
    private void copy (int [] source, int [] data) {
        if (source.length > data.length) {
            data = new int [source.length];
        }

        for (int i = 0; i < source.length; i++) {
            data[i] = source[i];
        }
    }

    /**
     *
     * @param index индекс по которому получается значение
     * @return значение по заданному индексу
     */
    public int getItem(int index) {
        return data[index];
    }

    /**
     *
     * @return размер контейнера
     */
    public int getSize() {
        return size;
    }

    /**
     *
     * @return массив элементов
     */
    public int[] getData() {
        return data;
    }
}
