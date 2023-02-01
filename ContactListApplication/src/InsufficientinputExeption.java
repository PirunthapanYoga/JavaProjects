public class InsufficientinputExeption extends Throwable {
    public InsufficientinputExeption(String s) {
        super(s);
    }

    public String toString() {
        System.out.println("--Insufficient Input--");
        return null;
    }
}
