import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class OduncAl implements IIslemler{
    @Override
    public void islem(Kutuphane kutuphane, Kullanici kullanici) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ödünç almak istediğiniz kitabın bilgileriniz giriniz.");
        System.out.print("Kitabın adı: ");
        String kitapAdi = sc.nextLine();

        //diziyi stream nesnesine donusturduk ve bu sekilde arama yaptik
        boolean found = Arrays.stream(new ArrayList[]{kutuphane.kitapIsimleri}).anyMatch(kitap -> kitap.equals(kitapAdi));

        if (found) {
            System.out.println(kitapAdi + " adlı kitap bulundu. Lütfen 2 hafta içerisinde teslim ediniz.");
        } else {
            System.out.println(kitapAdi + " adlı kitap bulunamadı ya da başkası tarafından ödünç alındı.");
        }

        System.exit(0); //kod sonlanır
    }
}