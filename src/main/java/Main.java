public class Main {
    public static void main(String[] args) {
        Container C = new Container(new int[]{1, 2, 4, 5});
        Container nC = new Container(2);

        int[] tmp = new int[2];
        C.arrayCopy(C.getData(), tmp);

        System.out.println(C.toString());
        System.out.println(tmp[0]);
        System.out.println(tmp[1]);
    }
}