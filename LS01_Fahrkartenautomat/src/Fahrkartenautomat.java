import java.util.Scanner;

class Fahrkartenautomat {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double zuZahlenderBetrag, eingezahlterGesamtbetrag, eingeworfeneMuenze, nochZuZahlen, ticketPreis = 0;
        int anzahlTickets = 0, rueckgabebetrag;
        byte selectedTicket;

        // Welcome-Screen
        System.out.println("Fahrkartenbestellvorgang:");
        System.out.println("========================");
        System.out.println();

        // Present ticket prices
        System.out.println("Wählen Sie ihre Wunschfahrkarte für Berlin AB aus:");
        System.out.println("\tKurzstrecke AB [2,00 EUR] (1)");
        System.out.println("\tEinzelfahrschein AB [3,00 EUR] (2)");
        System.out.println("\tTagesfahrkarte AB [8,80 EUR] (3)");
        System.out.println("\t4-Fahrten-Karte AB [9,40 EUR] (4)");
        System.out.println();

        // Prompt for ticket input
        while(true) {
            System.out.print("Ihre Wahl: ");
            selectedTicket = sc.nextByte();

            if(selectedTicket < 1 || selectedTicket > 4) {
                System.out.println("\t>> Falsche Eingabe <<");
            } else {
                break;
            }
        }

        // Set ticket price according to ticket selection
        switch (selectedTicket) {
            case 1:
                ticketPreis = 2.0;
                break;
            case 2:
                ticketPreis = 3.0;
                break;
            case 3:
                ticketPreis = 8.80;
                break;
            case 4:
                ticketPreis = 9.40;
                break;
        }

        // Ticketanzahl angeben
        while(true) {
            System.out.print("Anzahl der Tickets: ");
            anzahlTickets = sc.nextInt();

            if(anzahlTickets < 1 || anzahlTickets > 10) {
                System.out.println(" >> Wählen Sie bitte eine Anzahl von 1 bis 10 Tickets aus. <<");
            } else {
                break;
            }
        }

        zuZahlenderBetrag = anzahlTickets * ticketPreis;

        // Geldeinwurf
        eingezahlterGesamtbetrag = 0.0;
        nochZuZahlen = 0.0;
        while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
            nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
            System.out.printf("Noch zu zahlen: %.2f Euro\n", nochZuZahlen);
            System.out.print("Eingabe (mind. 5 Cent, höchstens 20 Euro): ");
            eingeworfeneMuenze = sc.nextDouble();

            //  5 Cent, 10 Cent, 20 Cent, 50 Cent, 1 Euro und 2 Euro entgegennimmt. Außerdem soll der 5 Euro-, 10 Euro- und 20 Euro-Scheine
            if(eingeworfeneMuenze != 0.05 && eingeworfeneMuenze != 0.1 && eingeworfeneMuenze != 0.2 && eingeworfeneMuenze != 0.5 && eingeworfeneMuenze != 1.0 && eingeworfeneMuenze != 2.0 && eingeworfeneMuenze != 5.0 && eingeworfeneMuenze != 10.0 && eingeworfeneMuenze != 20.0) {
                System.out.println(">> Kein gültiges Zahlungsmittel");
            } else {
                eingezahlterGesamtbetrag += eingeworfeneMuenze;
            }
        }

        // Fahrscheinausgabe
        System.out.println("\nFahrschein wird ausgegeben");
        for (int i = 0; i < 8; i++) {
            System.out.print("=");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n\n");

        // Rückgeldberechnung und -ausgabe
        rueckgabebetrag = (int) ((eingezahlterGesamtbetrag - zuZahlenderBetrag) * 100);
        if (rueckgabebetrag > 0.0) {
            System.out.printf("Der Rückgabebetrag in Höhe von %.2f Euro\n", ((double) rueckgabebetrag) / 100);
            System.out.println("wird in folgenden Münzen ausgezahlt:");

            while (rueckgabebetrag >= 200) { // 2-Euro-Münzen
                System.out.println("2 Euro");
                rueckgabebetrag = rueckgabebetrag - 200;
            }
            while (rueckgabebetrag >= 100) { // 1-Euro-Münzen
                System.out.println("1 Euro");
                rueckgabebetrag = rueckgabebetrag - 100;
            }
            while (rueckgabebetrag >= 50) { // 50-Cent-Münzen
                System.out.println("50 Cent");
                rueckgabebetrag = rueckgabebetrag - 50;
            }
            while (rueckgabebetrag >= 20) { // 20-Cent-Münzen
                System.out.println("20 Cent");
                rueckgabebetrag = rueckgabebetrag - 20;
            }
            while (rueckgabebetrag >= 10) { // 10-Cent-Münzen
                System.out.println("10 Cent");
                rueckgabebetrag = rueckgabebetrag - 10;
            }
            while (rueckgabebetrag >= 5) { // 5-Cent-Münzen
                rueckgabebetrag = rueckgabebetrag - 5;
            }
        }

        System.out.println("""

                Vergessen Sie nicht, den Fahrschein vor Fahrtantritt entwerten zu lassen!
                Wir wünschen Ihnen eine gute Fahrt.""");

        sc.close();
    }
}