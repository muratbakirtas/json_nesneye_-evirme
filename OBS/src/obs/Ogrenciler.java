package obs;

import java.util.ArrayList;

public class Ogrenciler {
    private String ogrAdi;
    private int ogrİd;
    private String ogrCinsiyet;
    private ArrayList<Ders> dersListesi=new ArrayList();




    public Ogrenciler(int ogrİd,String ogrAdi,String ogrCinsiyet){
        this.ogrİd=ogrİd;
        this.ogrAdi=ogrAdi;
        this.ogrCinsiyet=ogrCinsiyet;

    }

    public Ogrenciler() {

    }


    public int getOgrİd() {
        return ogrİd;
    }

    public String getOgrAdi() {
        return ogrAdi;
    }

    public String getOgrCinsiyet() {
        return ogrCinsiyet;
    }

    public void setOgrAdi(String ogrAdi) {
        this.ogrAdi = ogrAdi;
    }

    public void setOgrCinsiyet(String ogrCinsiyet) {
        this.ogrCinsiyet = ogrCinsiyet;
    }

    public void setOgrİd(int ogrİd) {
        this.ogrİd = ogrİd;
    }


    public ArrayList<Ders> getDersListesi() {
        return dersListesi;
    }

    public void setDersListesi(ArrayList<Ders> dersListesi) {
        this.dersListesi = dersListesi;
    }

}

