import java.util.Scanner;

public class NormalKullanici extends Kullanici {
    public NormalKullanici() {}

    public NormalKullanici(String name) {
        super(name);
        this.iIslemler = new IIslemler[] { // IIslemler[] dizisi olusturduk ve siniflari nesne olarak ekledik
                new KitapGoruntule(),
                new OduncAl(),
                new TeslimEt(),
                new Cikis()
        };
    }

    public NormalKullanici(String name, String email, String phoneNumber) {
        super(name, email, phoneNumber);
        this.iIslemler = new IIslemler[] {
                new KitapGoruntule(),
                new OduncAl(),
                new TeslimEt(),
                new Cikis()
        };
    }


    @Override
    public void menu(Kutuphane kutuphane, Kullanici kullanici) {
        System.out.println("1. Kitapları Görüntüle");
        System.out.println("2. Ödünç Kitap Al");
        System.out.println("3. Kitap Teslim Et");
        System.out.println("4. Çıkış ");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        this.iIslemler[n - 1].islem(kutuphane,kullanici);

        if (n == 1)
            new KitapGoruntule();
        else if (n == 2)
            new OduncAl();
        else if (n == 3)
            new TeslimEt();
        else
            new Cikis();
    }
}