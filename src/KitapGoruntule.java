import java.util.Scanner;

public class KitapGoruntule  implements IIslemler{
    @Override
    public void islem(Kutuphane kutuphane, Kullanici kullanici) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Görüntülemek istediğiniz kitabın adını giriniz:");
        String kitapAdi = sc.nextLine();
        Kitap kitap = new Kitap(kitapAdi);

        if (!kutuphane.kitapIsimleri.contains(kitapAdi)) {
            System.out.println(kitapAdi + " adlı kitap kütüphanede bulunmamaktadır.");
        } else {
            System.out.println(kitapAdi + " kitabının özellikleri görüntüleniyor:");
            kutuphane.goruntule(kitap);
        }

        System.exit(0); //kod sonlanır
    }
}