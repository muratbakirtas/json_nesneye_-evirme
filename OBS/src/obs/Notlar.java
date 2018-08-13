package obs;

import java.util.ArrayList;

public class Notlar {



    private Double vizeler  ;

    private Double fnal;
    private Double ort;



    public Notlar(double vize, double aFinal, double ort) {
this.vizeler=vize;
this.fnal=aFinal;
this.ort=ort;
    }

public Notlar(){}



    public Double getVizeler() {
        return vizeler;
    }

    public void setVizeler(Double vizeler) {
        this.vizeler = vizeler;
    }

    public Double getFnal() {
        return fnal;
    }

    public void setFnal(Double fnal) {
        this.fnal = fnal;
    }

    public Double getOrt() {
        return ort;
    }

    public void setOrt(Double ort) {
        this.ort = ort;
    }
}
