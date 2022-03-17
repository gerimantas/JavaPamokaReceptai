package db;

import db.entities.Ingridientai;
import db.entities.Receptas;

import java.sql.*;
import java.util.ArrayList;

public class DbVeiksmai {
    private static final String dbNuoroda = "jdbc:mysql://localhost:3306/receptai?serverTimezone=UTC&characterEncoding=utf8";
    private static final String dbUser = "root";
    private static final String dbPassword = "";


    public DbVeiksmai() {
    }

    /**
     * Metodas, kuris prisijungia prie duomenų bazės
     * @return Connection jungtis - grąžini prisijungimo prie duomenų bazės objektą (Connection)
     */
    public static Connection prisijungtiPrieDb() {
        Connection jungtis = null;
        try {
            jungtis = DriverManager.getConnection(dbNuoroda, dbUser, dbPassword);
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("neprisijungė prie duombazės");
        }
        return jungtis;
    }

    /**
     * Metodas, kuris randa ingridientą pagal gautą pavadinimą. Jeigu yra keli ingridientai tokiu pavadinimu - grąžins paskutinį.
     * @param jungtis - Connection tipo objektas, kuris susieja Java su duombaze
     * @param pavadinimas - ieškomo ingridiento pavadinimas
     * @return grąžina rastą ingridienta (Ingridientas objektą)
     */
    public static Ingridientas ieskotiIngridientoPagalPav(Connection jungtis, String pavadinimas) {
        Ingridientas rastasIngridientas = null;

        try {
            String sqlUzklausa = "SELECT * FROM ingredientas WHERE pavadinimas = ?";
            PreparedStatement paruostukas = jungtis.prepareStatement(sqlUzklausa);
            paruostukas.setString(1, pavadinimas);

            ResultSet rezultatas = paruostukas.executeQuery();

            while (rezultatas.next()){
                rastasIngridientas = new Ingridientas(rezultatas.getInt("id"), rezultatas.getString("pavadinimas"), rezultatas.getInt("kalorijos_100g"), rezultatas.getDouble("kaina"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("nepavyko pasiekti duomenų");
        }
        return rastasIngridientas;
    }

    /**
     * Metodas, kuris randa receptus, kainuojančius nuo tam tikros kainos iki tam tikros kainos.
     * @param jungtis - Connection tipo objektas, kuris susieja Java su duombaze
     * @param pradineKaina kaina nuo kurios grąžinti receptus
     * @param galutineKaina kaina iki kurios grąžinti receptus
     * @return grąžina ArrayList'ą receptų, kurie yra nuo iki kainos.
     */
    public static ArrayList<Receptas> ieskotiReceptuPagalKainosIntervala(Connection jungtis, double pradineKaina, double galutineKaina) {
        ArrayList<Receptas> visiReceptai = new ArrayList<>();

        try {
            String sqlUzklausa = "SELECT * FROM receptas WHERE kaina > ? AND kaina < ?";
            PreparedStatement paruostukas = jungtis.prepareStatement(sqlUzklausa);
            paruostukas.setDouble(1, pradineKaina);
            paruostukas.setDouble(2, galutineKaina);

            ResultSet rezultatas = paruostukas.executeQuery();
            while (rezultatas.next()) {
                Receptas rastasReceptas = new Receptas(rezultatas.getInt("id"), rezultatas.getString("pavadinimas"), rezultatas.getString("nurodymai"), rezultatas.getInt("kalorijos_porc"), rezultatas.getDouble("kaina"));
                visiReceptai.add(rastasReceptas);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nepavyko gauti duomenų");
        }
        return visiReceptai;
    }

    public static ArrayList<Ingridientai> gautiIngridientus(Connection jungtis, String sqlUzklausa) {
        ArrayList<Ingridientai> visiIngridientai = new ArrayList<>();
        try {
            PreparedStatement paruostukas = jungtis.prepareStatement(sqlUzklausa);
            ResultSet rezultatas = paruostukas.executeQuery();

            while (rezultatas.next()) {
                int id = rezultatas.getInt("id");
                String pavadinimas = rezultatas.getString("pavadinimas");
                int kalorijos_100g = rezultatas.getInt("kalorijos_100g");
                double kaina = rezultatas.getDouble("kaina");

                Ingridientai vienasIngridientas = new Ingridientai(id, pavadinimas, kalorijos_100g, kaina);
                visiIngridientai.add(vienasIngridientas);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("nepavyko gauti duomenų");
        }

        return visiIngridientai;
    }

}
