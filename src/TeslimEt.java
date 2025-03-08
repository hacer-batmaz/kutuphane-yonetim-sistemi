import java.util.Scanner;

public class TeslimEt implements IIslemler{
    @Override
    public void islem(Kutuphane kutuphane, Kullanici kullanici) {
        Scanner sc = new Scanner(System.in);

        System.out.println(kullanici.getName() + " kullanıcısının ödünç aldığı kitaplar:");
        for (Kitap kitap : kullanici.getOduncAlinanKitaplar()) {
            System.out.println("- " + kitap.getBaslik());
        }

        if (kullanici.getOduncAlinanKitaplar().isEmpty()) {
            System.out.println("Hata: Teslim edilecek ödünç kitap bulunamadı!");
            System.exit(0); //kod sonlanır
        }

        System.out.print("Teslim etmek istediğiniz kitabın adını giriniz: ");
        String kitapAdi = sc.nextLine();

        Kitap teslimEdilecekKitap = null;
        for (Kitap kitap : kullanici.getOduncAlinanKitaplar()) {
            if (kitap.getBaslik().equalsIgnoreCase(kitapAdi)) {
                teslimEdilecekKitap = kitap;
                break;
            }
        }

        if (teslimEdilecekKitap == null) {
            System.out.println("Hata: Girdiğiniz isimde ödünç alınan bir kitap bulunamadı!");
            System.exit(0); //kod sonlanır
        }

        kullanici.getOduncAlinanKitaplar().remove(teslimEdilecekKitap);
        kutuphane.kitapEkle(teslimEdilecekKitap);

        System.out.println("Başarıyla teslim edildi: " + teslimEdilecekKitap.getBaslik());
    }
}