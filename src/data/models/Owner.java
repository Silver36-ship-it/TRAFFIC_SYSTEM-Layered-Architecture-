package data.models;

public class Owner {
    private String fullName;
    private String address;
    private String email;
    private String phoneNumber;
    private Gender gender;

    public Owner(String fullName, String address, String email, String phoneNumber, Gender gender) {
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public String toString(){
        return "Owner{" +
                "fullName='"+ fullName + '\''+
                ",address='" + address + '\''+
                ",email='"+ email+'\''+
                ",phoneNumber'"+ phoneNumber+'\''+
                ",gender'"+ gender+'\''+
                '}';

    }
}

