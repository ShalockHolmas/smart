public class Test {


    public static void main(String[] args) {
        String s = "0.375";
        s = s.replaceAll("[^0-9.]", "");
        System.out.println(Double.valueOf(s));
    }
    public void tt(){

    }
}
