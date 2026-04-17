import java.util.Scanner;

public class SensorTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Erstellen eines Sensor-Objekts
        System.out.print("Geben Sie den Standort des Sensors ein: ");
        String standort = scanner.nextLine();
        
        System.out.print("Geben Sie die Typbezeichnung des Sensors ein: ");
        String typbezeichnung = scanner.nextLine();

        // Der Sensor hat 24 Messwerte für einen Tag (24 Stunden)
        Sensor sensor = new Sensor(standort, typbezeichnung, 24);

        // Einlesen der Temperaturmessdaten
        sensor.einlesenTemperaturMessdaten();

        // Berechnung des Mittelwerts
        double mittelwert = sensor.berechneMittelwert();
        System.out.println("Der Mittelwert der Temperaturen ist: " + mittelwert);

        // Berechnung der Standardabweichung
        double standardabweichung = sensor.berechneStandardabweichung();
        System.out.println("Die Standardabweichung der Temperaturen ist: " + standardabweichung);

        // Berechnung der Anzahl der Werte, die mehr als 10 Grad vom Mittelwert abweichen
        int abweichungen = sensor.berechneAbweichungenVon10Grad();
        System.out.println("Anzahl der Werte, die um mehr als 10 Grad vom Mittelwert abweichen: " + abweichungen);
        
        scanner.close();
    }
}

