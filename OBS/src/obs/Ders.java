package obs;


import java.util.ArrayList;


public class Ders {
    private int id;
    private String name;
    private ArrayList<Notlar> notlar=new ArrayList();



    public Ders(int id, String name) {
        this.id = id;
        this.name = name;


    }

    public Ders() {
        this.notlar = new ArrayList<>();


    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void notEkle (Notlar n){this.notlar.add(n);}






    public ArrayList<Notlar> getNotlar() {
        return notlar;
    }

    public void setNotlar(ArrayList<Notlar> notlar) {
        this.notlar = notlar;
    }
}




