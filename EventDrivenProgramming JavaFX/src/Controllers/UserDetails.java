package Controllers;

public class UserDetails {
    private String userName;
    private String firstName;
    private String lastName;
    private String civilStatus;
    private String gender;
    private String DateOfBirth;
    private String ID;
    private String contactNumber;
    private String eMail;

    public UserDetails(String userName, String firstName, String lastName, String civilStatus, String gender, String dateOfBirth, String ID, String contactNumber, String eMail) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.civilStatus = civilStatus;
        this.gender = gender;
        this.DateOfBirth = dateOfBirth;
        this.ID = ID;
        this.contactNumber = contactNumber;
        this.eMail = eMail;
    }

    public String getUserName() {
        return userName;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getID() {
        return ID;
    }

    public String geteMail() {
        return eMail;
    }
}
