public class Kitap {
    private String baslik;
    private String yazar;
    private String sayfaSayisi;
    private String basimYili;

    public Kitap() {
    }

    public Kitap(String baslik) {
        this.baslik = baslik;
    }

    public Kitap(String baslik, String yazar, String sayfaSayisi, String basimYili) {
        this.baslik = baslik;
        this.yazar = yazar;
        this.sayfaSayisi = sayfaSayisi;
        this.basimYili = basimYili;
    }

    @Override
    public String toString() {
        return "Kitap{" +
                "baslik='" + baslik + '\'' +
                ", yazar='" + yazar + '\'' +
                ", sayfaSayisi='" + sayfaSayisi + '\'' +
                ", basimYili='" + basimYili + '\'' +
                '}';
    }

    public String getBaslik() {
        return baslik;
    }

    public String getYazar() {
        return yazar;
    }

    public String getSayfaSayisi() {
        return sayfaSayisi;
    }

    public String getBasimYili() {
        return basimYili;
    }

}