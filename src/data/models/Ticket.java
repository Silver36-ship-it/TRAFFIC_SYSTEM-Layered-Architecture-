package data.models;

import exceptions.NoOffenceDetectedException;

import java.time.LocalDateTime;

public class Ticket {
    private int id;
    private Vehicle vehicle;
    private Offence offence;
    private boolean hasPaid;
    private Officer issuer;
    private LocalDateTime dateOfBooking;
    private LocalDateTime dateOfPayment;

    public Ticket(int id,Vehicle vehicle, Offence offence, Officer issuer) {
        this.id = id;
        this.vehicle = vehicle;
        this.offence = offence;
        this.issuer = issuer;
        this.hasPaid = false;
        this.dateOfBooking = LocalDateTime.now();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public Offence getOffence() {
        if(offence == null) {
            throw new NoOffenceDetectedException("No offence has been assigned to this ticket");
        }
        return offence;
    }
    public void setOffence(Offence offence) {
        this.offence = offence;
    }
    public boolean isHasPaid() {
        return hasPaid;
    }
    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
        if(hasPaid) {
            this.dateOfPayment= LocalDateTime.now();}
            else{
                this.dateOfPayment = null;
            }
    }
    public Officer getIssuer() {
        return issuer;
    }
    public void setIssuer(Officer issuer) {
        this.issuer = issuer;
    }
    public LocalDateTime getDateOfBooking() {
        return dateOfBooking;
    }
    public LocalDateTime getDateOfPayment() {
        return dateOfPayment;
    }
    public String toString(){
        return "Ticket{"+
                "id="+ id +
                ",vehicle="+ (vehicle != null? vehicle.getPlateNumber(): "Vehicle does not exist")+
                ", offence="+ (offence != null? offence.getOffenceDescription(): "None")+
                ", fine="+ (offence != null? String.valueOf(offence.getFineAmount()) : "0")+
                ", hasPaid="+ hasPaid +
                ", issuer=" + (issuer != null? issuer.getName(): "Unknown officer detected")+
                ", dateOfBooking=" + dateOfBooking+
                ", dateOfPayment=" + dateOfPayment+
                '}';

    }

}
