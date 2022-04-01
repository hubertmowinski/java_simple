import java.util.Scanner;

public class lab2_zad3 {
    public static int[][] transpozycja(int wiersze, int kolumny, int macierz[][])
    {
        int[][] nowa_macierz = new int[kolumny][wiersze];
        for(int i=0;i<=wiersze - 1;i++){
            for(int j=0;j<=kolumny - 1;j++){
                nowa_macierz[j][i] = macierz[i][j];
            }
        }
        return nowa_macierz;
    }

    public static int[][] mnozenie_przez_skalar(int wiersze, int kolumny, int macierz[][], int skalar)
    {
        int[][] nowa_macierz = new int[wiersze][kolumny];
        for(int i=0;i<=wiersze - 1;i++){
            for(int j=0;j<=kolumny - 1;j++){
                nowa_macierz[i][j] = macierz[i][j] * skalar;
            }
        }
        return nowa_macierz;
    }

    public static int[] mnozenie_przez_wektor(int wiersze, int kolumny, int macierz[][], int wektor[])
    {
        int[] nowy_wektor = new int[wiersze];
        for(int i=0;i<=wiersze - 1;i++){
            for(int j=0;j<=kolumny - 1;j++){
                nowy_wektor[i] += macierz[i][j] * wektor[j];
            }
        }
        return nowy_wektor;
    }

    public static void draw_macierz(int wiersze, int kolumny, int macierz[][])
    {
        int wydruk;
        for(int i=0;i<=wiersze - 1;i++) {
            for(int j=0;j<=kolumny - 1;j++) {
                wydruk = macierz[i][j];
                System.out.format("| %d |", wydruk);
            }
            System.out.println();
        }
    }

    public static void draw_wektor(int wiersze, int wektor[])
    {
        int wydruk;
        for(int i=0;i<= wiersze - 1;i++) {
                wydruk = wektor[i];
                System.out.format("| %d |", wydruk);
                System.out.println();
        }
    }

    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj rozmiar tablicy:");
        System.out.println("Podaj liczbe wierszy:");
        int wiersze = sc.nextInt();
        System.out.println("Podaj liczbe kolumn:");
        int kolumny = sc.nextInt();
        int[][] macierz = new int[wiersze][kolumny];
        int[] wektor = new int[kolumny];
        for(int i=0;i<=wiersze - 1;i++){
            for(int j=0;j<=kolumny - 1;j++){
                System.out.println("Podaj wartosc w komórce: [" + i + "]" + "[" + j + "]");
                macierz[i][j] = sc.nextInt();
                draw_macierz(wiersze, kolumny, macierz);
            }
        }
        System.out.println("Macierz: ");
        draw_macierz(wiersze, kolumny, macierz);

        System.out.println("Podaj skalar do przemnozenia:");
        int skalar = sc.nextInt();

        for(int i=0;i<=kolumny - 1;i++){
            System.out.println("Podaj wartosc  wektora do przemnozenia w komórce: [" + i + "]");
            wektor[i] = sc.nextInt();
            draw_wektor(kolumny, wektor);
        }

        int macierz_po_tranzycji[][] = transpozycja(wiersze, kolumny, macierz);
        System.out.println("Macierz po transpozycji: ");
        draw_macierz(kolumny, wiersze, macierz_po_tranzycji);

        int macierz_po_przemnozeniu_przez_skalar[][] = mnozenie_przez_skalar(wiersze, kolumny, macierz, skalar);
        System.out.println("Macierz po przemnozeniu przez skalar: ");
        draw_macierz(wiersze, kolumny, macierz_po_przemnozeniu_przez_skalar);

        int wektor_po_przemnozeniu[] = mnozenie_przez_wektor(wiersze, kolumny, macierz, wektor);
        System.out.println("Wynik przemnozenia macierzy przez wektor: ");
        draw_wektor(wiersze, wektor_po_przemnozeniu);
    }
}
