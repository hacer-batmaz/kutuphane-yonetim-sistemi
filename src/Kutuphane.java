import java.util.ArrayList;

public class Kutuphane {
    public String kutupIsim;
    ArrayList<Kullanici> kullanicilar = new ArrayList<Kullanici>();
    ArrayList<String> kullaniciIsimleri = new ArrayList<String>();
    ArrayList<Kitap> kitaplar = new ArrayList<Kitap>();
    ArrayList<String> kitapIsimleri = new ArrayList<String>();


    public Kutuphane(String kutupName) {
        this.kutupIsim = kutupName;
    }

    @Override
    public String toString() {
        return "Kutuphane{" +
                "kullanicilar=" + kullanicilar +
                ", kullaniciIsimleri=" + kullaniciIsimleri +
                ", kitaplar=" + kitaplar +
                ", kitapIsimleri=" + kitapIsimleri +
                '}';
    }

    public void goruntule(Kitap kitap) {
        System.out.println("Kitap adı: " + kitap.getBaslik());
        System.out.println("Yazar adı: " + kitap.getYazar());
        System.out.println("Sayfa sayısı: " + kitap.getSayfaSayisi());
        System.out.println("Basım yılı: " + kitap.getBasimYili());
    }

    public void KullaniciEkle(Kullanici kullanici) {
        kullanicilar.add(kullanici);
        kullaniciIsimleri.add(kullanici.getName());
    }

    public void kitapEkle(Kitap kitap) {
        kitaplar.add(kitap);
        kitapIsimleri.add(kitap.getBaslik());
    }

    public void kitapSil(Kitap kitap) {
        kitaplar.remove(kitap);
        kitapIsimleri.remove(kitap.getBaslik());
    }

    public int giris(String phoneNumber, String email) { //kullanicilar listesinde boyle bir eleman varsa elemanin idex ini dondurur
        int n = -1;
        for (Kullanici kullanici : kullanicilar) {
            if (kullanici.getPhoneNumber().matches(phoneNumber) && kullanici.getEmail().matches(email)){
                n = kullanicilar.indexOf(kullanici);
                break;
            }
        }
        return n;
    }

    public Kullanici getKullanici(int n) {
        return kullanicilar.get(n);
    }
}