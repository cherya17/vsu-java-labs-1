public class Container {

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
        size = data.length;
        this.data = new int[size];
        System.arraycopy(this.data, 0, data, 0, size);
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
