public class HelloGoodbye {

    public static void main(String[] args) {
        final String name1 = args[0];
        final String name2 = args[1];
        System.out.println("Hello " + name1 + " and " + name2 + ".");
        System.out.println("Goodbye " + name2 + " and " + name1 + ".");
    }
}