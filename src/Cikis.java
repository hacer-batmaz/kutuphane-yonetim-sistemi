public class Cikis implements  IIslemler{
    @Override
    public void islem(Kutuphane kutuphane, Kullanici kullanici) {
        System.out.println(kutuphane.kutupIsim + " sistemindeki " + kullanici + " hesaptan çıkış yaptı!");
        System.exit(0); //kod sonlanır
    }
}