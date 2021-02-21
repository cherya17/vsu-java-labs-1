public class Main {
    public static void main(String[] args) {
        Container C = new Container(new int[]{1, 2, 4, 5});
        C.add(33);
        C.add(35);
        C.remove(0);
        for (int i = 0; i < C.getSize(); i++) {
            System.out.println(C.getData()[i]);
        }

    }
}