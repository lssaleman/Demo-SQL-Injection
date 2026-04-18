package org.demo;

public class UserDTO {
    private String nachname;
    private String vorname;
    private String bic;
    private String iban;
    private String pin;

    public UserDTO setNachname(String nachname) {
        this.nachname = nachname;
        return this;
    }

    public UserDTO setVorname(String vorname) {
        this.vorname = vorname;
        return this;
    }

    public UserDTO setBic(String bic) {
        this.bic = bic;
        return this;
    }

    public UserDTO setIban(String iban) {
        this.iban = iban;
        return this;
    }

    public UserDTO setPin(String pin) {
        this.pin = pin;
        return this;
    }

    public String getNachname() {
        return nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public String getBic() {
        return bic;
    }

    public String getIban() {
        return iban;
    }

    public String getPin() {
        return pin;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                ", nachname='" + nachname + '\'' +
                ", vorname='" + vorname + '\'' +
                ", bic='" + bic + '\'' +
                ", iban='" + iban + '\'' +
                ", pin='" + pin + '\'' +
                '}';
    }
}
