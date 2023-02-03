public class Passanger {
    private String name;
    private String id;
    String source;

    private String destination;
    private int platformNumber;
    private float travelFare;
    private String paymentMethod;
    private String token;
    private boolean payed;

    public Passanger(String name, String id, String source) {
        this.name = name;
        this.id = id;
        this.source= source;
    }

    public boolean getPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public float getTravelFare() {
        return travelFare;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public String getSource() {
        return source;
    }

    public int getPlatformNumber() {
        return platformNumber;
    }

    public String getToken() {
        return token;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setPlatformNumber(int platformNumber) {
        this.platformNumber = platformNumber;
    }

    public void setTravelFare(float travelFare) {
        this.travelFare = travelFare;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
