package db.entities;

public class Ingridientai {
    int id;
    String pavadinimas;
    int kalorijos_100g;
    double kaina;

    public Ingridientai() {
    }

    public Ingridientai(int id, String pavadinimas, int kalorijos_100g, double kaina) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.kalorijos_100g = kalorijos_100g;
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

    public int getKalorijos_100g() {
        return kalorijos_100g;
    }

    public void setKalorijos_100g(int kalorijos_100g) {
        this.kalorijos_100g = kalorijos_100g;
    }

    public double getKaina() {
        return kaina;
    }

    public void setKaina(double kaina) {
        this.kaina = kaina;
    }

    @Override
    public String toString() {
        return "Ingridientai{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", kalorijos_100g=" + kalorijos_100g +
                ", kaina=" + kaina +
                '}';
    }
}


