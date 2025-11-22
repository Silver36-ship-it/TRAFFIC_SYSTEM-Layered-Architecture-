package trafficSystemPackage.data.models;

public enum Offence {
    ONE_WAY("Keep it Simple,you should maintain one way", 10000),
    DRUNK_DRIVING("Drinking while driving is a higher sin than adultery",15000),
    NO_SEAT_BELT("Sitting pretty with no seat belt is not pretty",20000),
    OVER_SPEEDING("Better to be Slow than to be sorry",15000);

    private String offenceDescription;
    private int fineAmount;
    Offence(String offenceDescription, int fineAmount) {
        this.offenceDescription = offenceDescription;
        this.fineAmount = fineAmount;


    }
    public String getOffenceDescription() {
        return  offenceDescription;
    }
    public int getFineAmount() {
        return fineAmount;
    }
}
