import java.util.Scanner;

public class Admin extends Kullanici{
    public Admin(String name) {
        super(name);
        this.iIslemler = new IIslemler[] {
                new KitapGoruntule(),
                new KitapEkle(),
                new KitapSil(),
                new Cikis()
        };
    }

    public Admin(String name, String email, String phoneNumber) {
        super(name, email, phoneNumber);
        this.iIslemler = new IIslemler[] {
                new KitapGoruntule(),
                new KitapEkle(),
                new KitapSil(),
                new Cikis()
        };
    }

    @Override
    public void menu(Kutuphane kutuphane, Kullanici kullanici) {
        System.out.println("1. Kitapları Görüntüle");
        System.out.println("2. Kitap Ekle");
        System.out.println("3. Kitap Sil");
        System.out.println("4. Çıkış");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        this.iIslemler[n-1].islem(kutuphane,kullanici);

        if (n == 1)
            new KitapGoruntule();
        else if (n == 2)
            new KitapEkle();
        else if (n == 3)
            new KitapSil();
        else
            new Cikis();
    }
}