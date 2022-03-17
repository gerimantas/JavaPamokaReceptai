package pagrindinis;

import db.DbVeiksmai;
import db.entities.Receptas;
import ivedimas.KonsolesIvedimas;

import java.sql.Connection;
import java.util.ArrayList;

public class PagrindinePrograma {
    public static void main(String[] args) {
        Connection jungtis = DbVeiksmai.prisijungtiPrieDb();

        //
        String pavadinimas = "Bulvių košė";
        Receptas rastasReceptas = DbVeiksmai.ieskotiReceptoPagalPav(jungtis, pavadinimas);
        System.out.println("rastasReceptas = " + rastasReceptas);

        //
        ArrayList<Receptas> receptaiPagalKaina = DbVeiksmai.ieskotiReceptuPagalKainosIntervala(jungtis, 1.00, 9);
        receptaiPagalKaina.forEach(System.out::println);


        System.out.println("-------------------------------------------");
        KonsolesIvedimas.pasirinkimoMeniu(jungtis);
    }
}
