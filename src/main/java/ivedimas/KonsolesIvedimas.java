package ivedimas;

import db.DbVeiksmai;
import db.entities.Receptas;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class KonsolesIvedimas {
    private static final Scanner skaitytuvas = new Scanner(System.in);

    public KonsolesIvedimas() {
    }

    /**
     * Metodas, kuris administruoja konsolės įvedimo meniu. Iš pradžių išveda meniu pasirinkimus, tada nuskaito įvestą pasirinkimą ir pagal tą pasirinkimą paleidžia atitinkamą šios klasės metodą.
     * @param jungtis Connection tipo objektas, kuris susieja Java su duombaze
     */
    public static void pasirinkimoMeniu(Connection jungtis) {
        System.out.println("-- Pasirinkimo meniu --");
        System.out.println("Norėdami ieškoti ingridiento pagal pavadinimą, įveskite 1");
        System.out.println("Norėdami ieškoti ingridiento pagal kalorijų intervalą, įveskite 2");
        System.out.println("Norėdami ieškoti ingridiento pagal kainų intervalą, įveskite 3");

        int pasirinkimas = skaitytuvas.nextInt();

        switch (pasirinkimas) {
            case 1:
                ingridientoPagalPavadinimaRadimas(jungtis);
                break;
            case 2:
                ingridientoPagalKalorijuIntervalaRadimas(jungtis);
                break;
            case 3:
                ingridientoPagalKainuIntervalaRadimas(jungtis);
                break;
            default:
                System.out.println("Įvedėte blogą skaičių/pasirinkimą");
        }
    }


    /**
     * Metodas, kurį paleidžia, kai meniu pasirinkime buvo pasirinktas pirmas (1) pasirinkimas.
     * Šis metodas išveda nurodymus, jog įvesti ingridiento pavadinimą, nuskaito tą pavadinimą, paleidžia DbVeiksmai klasės metodą ir iš jo gautą receptą išveda į konsolę.
     * @param jungtis Connection tipo objektas, kuris susieja Java su duombaze
     */
    public static void IngridientoPagalPavadinimaRadimas(Connection jungtis) {
        System.out.println("Įveskite ingridiento pavadinimą, kurio ieškote");
        skaitytuvas.nextLine();
        String pavadinimas = skaitytuvas.nextLine();
        Ingridientas ieskomasIngridientas = DbVeiksmai.ieskotiIngridientasPagalPav(jungtis, pavadinimas);
        System.out.println("ieskomasIngridientas = " + ieskomasIngridientas);
    }

    /**
     * Metodas, kurį paleidžia, kai meniu pasirinkimas buvo antras (2)
     * Išveda nurodymus, jog įvesti intervalo pradinę ir galutinę kainą, jas nuskaito, paleidžia DbVeiksmai klasės metodą su jomis ir gautų receptų ArrayList'ą išveda į konsolę po vieną į eilutę
     * @param jungtis Connection tipo objektas, kuris susieja Java su duombaze
     */
    public static void ingridientoPagalKainuIntervalaRadimas(Connection jungtis) {
        System.out.println("Įveskite pradinę kainą: ");
        double pradineKaina = skaitytuvas.nextDouble();
        System.out.println("Įveskite galutinę kainą: ");
        double galutineKaina = skaitytuvas.nextDouble();

        ArrayList<Receptas> receptaiPagalKaina = DbVeiksmai.ieskotiReceptuPagalKainosIntervala(jungtis, pradineKaina, galutineKaina);
        receptaiPagalKaina.forEach(System.out::println);

    }
}
