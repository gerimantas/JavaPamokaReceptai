package db.entities;

public class Receptas {
    int id;
    String pavadinimas;
    String nurodymai;
    int kalorijosPorc;
    double kaina;

    public Receptas() {
    }

    public Receptas(int id, String pavadinimas, String nurodymai, int kalorijosPorc, double kaina) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.nurodymai = nurodymai;
        this.kalorijosPorc = kalorijosPorc;
        this.kaina = kaina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public String getNurodymai() {
        return nurodymai;
    }

    public void setNurodymai(String nurodymai) {
        this.nurodymai = nurodymai;
    }

    public int getKalorijosPorc() {
        return kalorijosPorc;
    }

    public void setKalorijosPorc(int kalorijosPorc) {
        this.kalorijosPorc = kalorijosPorc;
    }

    public double getKaina() {
        return kaina;
    }

    public void setKaina(double kaina) {
        this.kaina = kaina;
    }


    @Override
    public String toString() {
        return "Receptai{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", nurodymai='" + nurodymai + '\'' +
                ", kalorijosPorc=" + kalorijosPorc +
                ", kaina=" + kaina +
                '}';
    }
}
