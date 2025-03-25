import myPackage.Enumerativi.CARBURANTE;
import myPackage.Enumerativi.CAMBIO;

import java.util.Objects;

public class Automobile {
    //attributi-campi della classe automobile
    private String proprietario;
    private String targa; //TODO: di esatti 7 caratteri
    private String casaAutomobilistica;
    private CARBURANTE tipoCarburante;
    private CAMBIO tipoCambio;
    private int numeroPosti;
    private String immatricolazione;

    //costruttore di default
    public Automobile() {
        proprietario = "";
        targa = "0000000";
        casaAutomobilistica = "";
        tipoCarburante = CARBURANTE.BENZINA;
        tipoCambio = CAMBIO.MANUALE;
        numeroPosti = 5;
        immatricolazione = "";
    }

    //costruttore parametrizzato
    public Automobile(
            String proprietario,
            String targa,
            String casaAutomobilistica,
            CARBURANTE tipoCarburante,
            CAMBIO tipoCambio,
            int numeroPosti,
            int anno,
            String mese) {
        //TODO: rendere i mesi un enumerativo
        this.proprietario = proprietario;
        if(targa.length() == 7){
            this.targa = targa;
        }else{
            this.targa = "0000000";
        }
        //(targa.length() == 7) ? this.targa = targa : this.targa = "0000000";
        this.casaAutomobilistica = casaAutomobilistica;
        this.tipoCarburante = tipoCarburante;
        this.tipoCambio = tipoCambio;
        this.numeroPosti = numeroPosti;
        immatricolazione = mese + "/" + anno;
    }

    //getter

    public String getProprietario() {
        return proprietario;
    }

    public String getImmatricolazione() {
        return immatricolazione;
    }

    //setter

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public void setImmatricolazione(int anno, String mese) {
        this.immatricolazione = mese + "/" + anno;
    }

    public void setTarga(String targa) {
        if(targa.length() == 7){
            this.targa = targa;
        }else{
            this.targa = "0000000";
        }
    }

    @Override // dobbiamo formattare la stringa e gestire la presenza degli enumerativi
    public String toString() {
        // come gestire gli enum:
        String tmp_cambio = switch (this.tipoCambio) { // questa scrittura del case é valida se
            // assegniamo solo stringhe per tutte le possibilitá date dall'enum, con una sola condizione
            case MANUALE -> "manuale";
            case AUTOMATICO -> "automatico";

        };
        String tmp_carburante = switch (this.tipoCarburante) { // questa scrittura del case é valida se
            // assegniamo solo stringhe per tutte le possibilitá date dall'enum, con una sola condizione
            case BENZINA -> "benzina";
            case DIESEL -> "diesel";
            case GPL -> "gpl";

        };
        // formattiamo il toString come desiderato
        return "+ proprietario:" + proprietario + '\n' +
                "+ targa:" + targa + '\n' +
                "+ casaAutomobilistica:" + casaAutomobilistica + '\n' +
                "+ tipoCarburante:" + tipoCarburante +
                "+ tipoCambio:" + tipoCambio +
                "+ numeroPosti:" + numeroPosti +
                "+ immatricolazione:" + immatricolazione + '\n';
    }
        //implementiamo una funzione che compari gli attributi di due oggetti appartenenti ad una stessa classe (Automobile)"
        public boolean equals(Object o) {
            if (this == o) {
                return true; //se le due variabili puntano allo stesso indirizzo di memoria é inutile eseguire la funzione;
            } else if (!(o instanceof Automobile)) { //l'instanceof fa un "casting" dell'oggetto;
                return false; //se l'oggetto o é di una classe diversa da Automobile, allora é impossibile compararli;
            } else {
                Automobile that = (Automobile)o; //definiamo con that l'oggetto o ("quello")
                return this.proprietario.equals(that.proprietario) && this.targa.equals(that.targa) && this.numeroPosti == that.numeroPosti;
            }
        }
        public int hashCode(){return Objects.hash(this.proprietario,this.targa);}
    }

