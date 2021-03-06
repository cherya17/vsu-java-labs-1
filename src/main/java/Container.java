import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Container {

    public static int MinCapacity = 10;
    private int DeltaCapacity = 2;

    private int data[];
    private int size;
    private int capacity;

    /**
     * <h3>Создаёт контейнер с минимальной вместимостью</h3>
     */
    public Container() {
        this.capacity = MinCapacity;
        this.size = 0;
        data = new int[capacity];
    }

    /**
     * <h3>Создаёт контейнер с заданной вместимостью</h3>
     * @param capacity вместимость контейнера для инициализации
     */
    public Container(int capacity) {
        this.capacity = Math.max(capacity, MinCapacity);
        this.size = 0;
        data = new int[capacity];
    }

    /**
     * <h3>Создаёт контейнер с заданными числами</h3>
     * @param data элементы для инициализации контейнера
     */
    public Container(@NotNull int[] data) {
        capacity = Math.max(data.length * DeltaCapacity, MinCapacity);
        size = data.length;
        this.data = new int[capacity];
        arrayCopy(data, this.data);
    }

    /**
     * <h3>Добавление элемента в контейнер</h3>
     * @param num число для добавления в контейнер
     */
    public void push(int num) {
        if (size + 1 >= capacity) {
            increaseContainer(capacity * DeltaCapacity);
        }
        data[size++] = num;
    }

    /**
     * <h3>Добавление элемента в контейнер по заданному индексу</h3>
     * @param num число для добавления в контейнер
     * @param index индекс по которому происходит добавление
     */
    public void insert(int num, int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (size + 1 >= capacity) {
            increaseContainer(capacity * DeltaCapacity);
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        size++;
        data[index] = num;
    }

    /**
     * <h3>Удаление элемента по заданному индексу</h3>
     * @param index индекс по которому удаляется элемент из контейнера
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[--size] = 0;
    }

    /**
     * <h3>Изменение максимальной вместимости контейнера</h3>
     * @param newCapacity новая вместимость контейнера
     */
    private void increaseContainer (int newCapacity) {
        capacity = newCapacity;
        int[] newData = new int[capacity];
        if (size > 0) {
            arrayCopy(data, newData);
        }
        data = newData;
    }



    /**
     * <h3>Копирование одного массива в другой не меняя размерность</h3>
     * @param source данные для копирования
     * @param destination куда копируются данные
     */
    public void arrayCopy (@NotNull int [] source, @NotNull int [] destination) {
        for (int i = 0; i < source.length && i < destination.length; i++) {
            destination[i] = source[i];
        }
    }

    /**
     *
     * @param value значение элемента по которому производится поиск
     * @return индекс первого элемента со значением value, если такого элемента нет, возвращает -1
     */
    public int getIndex(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) return i;
        }

        return -1;
    }

    /**
     *
     * @return представление data в виде строки
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            res.append(", ");
        }
        res.delete(res.length() - 2, res.length());
        res.append("]");
        return res.toString();
    }

    /**
     *
     * @param value значение элемента по которому производится поиск
     * @return количество элементов со значением value
     */
    public int count(int value) {
        int count = 0;

        for (int i = 0; i < size; i++) {
            if (data[i] == value) count++;
        }

        return count;
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
     * @return вместимость контейнера
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     *
     * @return массив элементов
     */
    public int[] getData() {
        int[] temp = new int [size];
        arrayCopy(data, temp);
        return temp;
    }
}
