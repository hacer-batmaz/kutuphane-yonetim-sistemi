import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Kutuphane kutuphane;

    public static void main(String[] args) {
        kutuphane = new Kutuphane("Millet Kütüphanesi");

        Admin admin = new Admin("Mahmut Hoca", "admin@kutuphane.com", "123789");
        NormalKullanici normalKullanici = new NormalKullanici("Kemal Sunal", "kullanici@example.com", "456123");
        kutuphane.KullaniciEkle(admin);
        kutuphane.KullaniciEkle(normalKullanici);

        Kitap kitap1 = new Kitap("1984", "George Orwell","352","2000");
        Kitap kitap2 = new Kitap("Suç ve Ceza", "Fyodor Dostoyevski","704","1866");
        kutuphane.kitapEkle(kitap1);
        kutuphane.kitapEkle(kitap2);

        System.out.println(kutuphane.kutupIsim + " Yönetim Sistemine Hoş Geldiniz!");
        System.out.println("0. Çıkış\n1. Giriş\n2. Yeni Kullanıcı");


        int num = -1;
        do {
            System.out.print("Seçiminizi yapın: ");
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                sc.nextLine(); // Satır sonu karakterini temizle
            } else {
                System.out.println("Geçerli bir sayı giriniz!");
                sc.nextLine(); // Hatalı girişi temizle
                continue;
            }

            switch (num) {
                case 0: new Cikis(); System.exit(0); break;
                case 1: giris(); break;
                case 2: yeniKullanici(); break;
                default: System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        } while (num != 0);

        sc.close();

    }

    public static void giris() {
        System.out.print("Telefon numaranızı giriniz: ");
        if (!sc.hasNextLine()) { // Girişin kapanıp kapanmadığını kontrol et
            System.out.println("Giriş akışı kapalı! Programdan çıkılıyor.");
            System.exit(0); //kod sonlanır
        }
        String phoneNumber = sc.nextLine();

        System.out.print("Email giriniz: ");
        if (!sc.hasNextLine()) {
            System.out.println("Giriş akışı kapalı! Programdan çıkılıyor.");
            System.exit(0); //kod sonlanır
        }
        String email = sc.nextLine();

        int n = kutuphane.giris(phoneNumber, email);

        if (n != -1) {
            Kullanici kullanici = kutuphane.getKullanici(n);
            kullanici.menu(kutuphane,kullanici);
        } else {
            System.out.println("Hata: Kullanıcı Mevcut Değil!");
            System.exit(0); //kod sonlanır
        }
    }

    public static void yeniKullanici() {
        System.out.print("Adınızı giriniz: ");
        if (!sc.hasNextLine()) return;
        String name = sc.nextLine();

        if (!nameKontrol(name)) {
            throw new IllegalArgumentException("Hata: İsim en az 5 karakterden oluşmalı!");
        }

        System.out.print("Telefon numaranızı giriniz: ");
        if (!sc.hasNextLine()) return;
        String phoneNumber = sc.nextLine();

        if (!phoneNumberKontrol(phoneNumber)) {
            throw new IllegalArgumentException("Hata: Telefon numarası 6 rakamdan oluşmalı!");
        }

        System.out.print("Email giriniz: ");
        if (!sc.hasNextLine()) return;
        String email = sc.nextLine();

        if (!emailKontrol(email)) {
            throw new IllegalArgumentException("Hata: Email formatı 'ornek@example.com' olamlı!");
        }

        System.out.println("1. Admin\n2. Normal Kullanıcı");

        int n2 = -1;
        while (true) {
            if (sc.hasNextInt()) {
                n2 = sc.nextInt();
                sc.nextLine(); // Enter karakterini temizle
                if (n2 == 1 || n2 == 2) {
                    break;
                } else {
                    System.out.println("Geçersiz seçim! 1 veya 2 giriniz.");
                }
            } else {
                System.out.println("Geçerli bir seçim giriniz (1 veya 2).");
                sc.nextLine(); // Hatalı girdiyi temizle
            }
        }

        Kullanici kullanici;
        if (n2 == 1) {
            kullanici = new Admin(name, email, phoneNumber);
        } else {
            kullanici = new NormalKullanici();
        }

        kutuphane.KullaniciEkle(kullanici);
        kullanici.menu(kutuphane, kullanici);
    }

    private static boolean nameKontrol(String name) {
        return name != null && name.matches("[a-zA-Z]+") && name.length() <= 32; //en fazla 32 karakter, sadece harf
    }

    private static boolean phoneNumberKontrol(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("\\d{6}"); //6 rakamdan olusmali
    }

    private static boolean emailKontrol(String email) {
        return email != null && email.matches("^[a-zA-Z0-9._%+-]+@example\\\\.com$"); //...@example.com formati
    }
}