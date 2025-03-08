import java.util.ArrayList;

public abstract class Kullanici {
    private String name;
    private String email;
    private String phoneNumber;
    protected IIslemler[] iIslemler;
    private ArrayList<Kitap> oduncAlinanKitaplar = new ArrayList<>();

    public abstract void menu(Kutuphane kutuphane, Kullanici kullanici);

    public Kullanici() {}
    public Kullanici(String name) {
        this.name = name;
    }

    public Kullanici(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Kullanıcı{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public ArrayList<Kitap> getOduncAlinanKitaplar() {
        return oduncAlinanKitaplar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}