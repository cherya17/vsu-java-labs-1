public class Main {
    public static void main(String[] args) {
        Container C = new Container(new int[]{1, 2, 4, 5});
        C.push(33);
        C.insert(35, 2);
        for (int i = 0; i < C.getSize(); i++) {
            System.out.println(C.getData()[i]);
        }

    }
}