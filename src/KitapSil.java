import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class KitapSil implements IIslemler{
    @Override
    public void islem(Kutuphane kutuphane, Kullanici kullanici) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Silinecek kitabın bilgilerini giriniz.");
        System.out.print("Kitabın adı: ");
        String kitapAdi = sc.nextLine();
        System.out.print("Kitabın yazarı: ");
        String yazar = sc.nextLine();
        System.out.print("Sayfa sayısı: ");
        String sayfaSayisi = sc.nextLine();
        System.out.print("Basım yılı: ");
        String basimYili = sc.nextLine();

        //diziyi stream nesnesine donusturduk ve bu sekilde arama yaptik
        boolean found = Arrays.stream(new ArrayList[]{kutuphane.kitapIsimleri}).anyMatch(kitap -> kitap.equals(kitapAdi));

        if (found) {
            kutuphane.kitapSil(new Kitap(kitapAdi,yazar,sayfaSayisi,basimYili));
            System.out.println(kitapAdi + " adlı kitap kütüphaneden başarıyla silindi.");
        } else {
            System.out.println("Silmek istediğiniz " + kitapAdi + " adlı kitap kütüphanede mevcut değil.");
        }

        System.exit(0); //kod sonlanır
    }
}