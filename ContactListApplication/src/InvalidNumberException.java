public class InvalidNumberException extends Throwable {
    public InvalidNumberException(String s) {
        super(s);
    }

    @Override
    public String toString() {
        System.out.println(super.toString());
        return null;
    }
}
