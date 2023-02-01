public class InvalidFileNameException extends Throwable {
    public InvalidFileNameException(String s) {
        super(s);
    }

    @Override
    public String toString() {
        System.out.println(super.toString());
        return null;
    }
}
