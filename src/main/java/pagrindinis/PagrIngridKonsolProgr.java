package pagrindinis;

import db.DbVeiksmai;
import db.entities.Receptas;
import ivedimas.KonsolesIvedimas;

import java.util.ArrayList;

public class PagrIngridKonsolProgr {

    String pavadinimas = "?";
    Receptas rastasRIgridientas = DbVeiksmai.ieskotiIngridientoPagalPav(jungtis, pavadinimas);
        System.out.println("rastasIngridientas = " + rastasIngridientas);


    ArrayList<Receptas> ingridientaiPagalKaina = DbVeiksmai.ieskotiReceptuPagalKainosIntervala(jungtis, 1.00, 9);
        ingridientaiPagalKaina.forEach(System.out::println);


        System.out.println("-------------------------------------------");
        KonsolesIvedimas.pasirinkimoMeniu(jungtis);


}
