package dz3;

public class Userinfo {
    String userLastName;
    String userFirstName;
    String userPatronymicName;
    String birthDate;
    Long telephoneNumber;
    Character userSex;

    public Userinfo(String userLastName, String userFirstName, String userPatronymicName, String birthDate, Long telephoneNumber, Character userSex){
        this.userLastName = userLastName;
        this.userFirstName = userFirstName;
        this.userPatronymicName = userPatronymicName;
        this.birthDate = birthDate;
        this.telephoneNumber = telephoneNumber;
        this.userSex = userSex;
    }

    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Long getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(Long telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserPatronymicName() {
        return userPatronymicName;
    }

    public void setUserPatronymicName(String userPatronymicName) {
        this.userPatronymicName = userPatronymicName;
    }

    public Character getUserSex() {
        return userSex;
    }

    public void setUserSex(Character userSex) {
        this.userSex = userSex;
    }

    @Override
    public String toString(){
        return getUserLastName() + " " + getUserFirstName() + " " + getUserPatronymicName() + " " + getBirthDate() + " " + getTelephoneNumber() + " " + getUserSex() + "\n";  
    }
}
