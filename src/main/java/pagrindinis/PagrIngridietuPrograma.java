package pagrindinis;

import db.DbVeiksmai;
import db.entities.Ingridientai;

import java.sql.Connection;
import java.util.ArrayList;

public class PagrIngridietuPrograma {
    public static void main(String[] args) {
        Connection jungtis = DbVeiksmai.prisijungtiPrieDb();

        ArrayList<Ingridientai> visiIngridientai = DbVeiksmai.gautiIngridientus(jungtis,"SELECT * FROM ingredientas");
        visiIngridientai.forEach(System.out::println);

        System.out.println("--------------");
        System.out.println("Ieskau pomidoro:");
        visiIngridientai = DbVeiksmai.gautiIngridientus(jungtis, "SELECT * FROM ingredientas WHERE pavadinimas = 'pomidoras'");
        visiIngridientai.forEach(System.out::println);
        System.out.println(jungtis);

        System.out.println("--------------");
        System.out.println("Ieskau kaloriju_100g nuo 100 iki 300:");
        visiIngridientai = DbVeiksmai.gautiIngridientus(jungtis, "SELECT * FROM ingredientas WHERE kalorijos_100g > 100 AND kalorijos_100g < 300");
        visiIngridientai.forEach(System.out::println);
        System.out.println(jungtis);

        System.out.println("--------------");
        System.out.println("Ieskau brangiausio ingridiento:");
        visiIngridientai = DbVeiksmai.gautiIngridientus(jungtis, "SELECT * FROM ingredientas WHERE kaina = (SELECT MAX(kaina) FROM ingredientas)");
//        SELECT * FROM ingredientas WHERE kaina=(SELECT MAX(kaina) FROM preke)

        visiIngridientai.forEach(System.out::println);
        System.out.println(jungtis);

        System.out.println("--------------");
        System.out.println("Ieskau brangesnio uz 9:");
        visiIngridientai = DbVeiksmai.gautiIngridientus(jungtis, "SELECT * FROM ingredientas WHERE kaina > 9");
        visiIngridientai.forEach(System.out::println);
        System.out.println(jungtis);
    }





}
