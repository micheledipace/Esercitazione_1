import myPackage.Enumerativi.CAMBIO;
import myPackage.Enumerativi.CARBURANTE;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Automobile a1 = new Automobile();
        System.out.println(a1); //a1.toString() viene fatto in automatico perché metodo intrinseco alla classe Automobili
        a1.setProprietario("Giuseppe Verdi");
        a1.setTarga("1234567");
        System.out.println(a1);
        Automobile a2 = new Automobile("Giuseppe Verdi", "1234567", "fiat", CARBURANTE.BENZINA, CAMBIO.AUTOMATICO, 5, 2009, "gennaio");
        System.out.println(a2.equals(a1));
    }
}
