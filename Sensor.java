import java.util.Scanner;

public class Sensor {

    // Attribute der Klasse
    private double[] temperaturMessdaten;
    private String standort;
    private String typbezeichnung;

    // Überladener Konstruktor
    public Sensor(String standort, String typbezeichnung, int anzahlMessungen) {
        this.standort = standort;
        this.typbezeichnung = typbezeichnung;
        this.temperaturMessdaten = new double[24]; // Array für Temperaturmessungen
    }

    // Methode zum Einlesen der Temperaturmessdaten
    public void einlesenTemperaturMessdaten() {
      try (Scanner scanner = new Scanner(System.in)) {
        System.out.println("Bitte geben Sie die Temperaturmessdaten für einen Tag ein (24 Werte, jeweils eine pro Stunde):");
        for (int i = 0; i < temperaturMessdaten.length; i++) {
            System.out.print("Messung " + (i + 1) + ": ");
            temperaturMessdaten[i] = scanner.nextDouble();
        }
      }
    }

    // Methode zur Berechnung des Mittelwerts der Temperaturmessdaten
    public double berechneMittelwert() {
        double summe = 0;
        for (double temperatur : temperaturMessdaten) {
            summe += temperatur;
        }
        return summe / temperaturMessdaten.length;
    }

    // Methode zur Berechnung der Standardabweichung der Temperaturmessdaten
    public double berechneStandardabweichung() {
        double mittelwert = berechneMittelwert();
        double summeQuadratDifferenzen = 0;
        for (double temperatur : temperaturMessdaten) {
            summeQuadratDifferenzen += Math.pow(temperatur - mittelwert, 2);
        }
        return Math.sqrt(summeQuadratDifferenzen / temperaturMessdaten.length);
    }

    // Methode zur Berechnung, wie viele Werte um 10 Grad vom Durchschnitt abweichen
    public int berechneAbweichungenVon10Grad() {
        double mittelwert = berechneMittelwert();
        int abweichendeWerte = 0;
        for (double temperatur : temperaturMessdaten) {
            if (Math.abs(temperatur - mittelwert) >= 10) {
                abweichendeWerte++;
            }
        }
        return abweichendeWerte;
    }
}

