import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.*;

public class lab2_zad2{
    public static int check_result(String plansza_gry[][])
    {
        String wygrana_x[] = {"x","x","x"};
        String wygrana_o[] = {"o","o","o"};
        int wygrana = 0;
        String przekatna_backslash[] = {plansza_gry[0][0], plansza_gry[1][1], plansza_gry[2][2]};
        String przekatna_slash[] = {plansza_gry[0][2], plansza_gry[1][1], plansza_gry[2][0]};

        if(Arrays.equals(przekatna_slash, wygrana_x) || Arrays.equals(przekatna_backslash, wygrana_x)){
            return 1;
        }
        else if(Arrays.equals(przekatna_slash, wygrana_o) || Arrays.equals(przekatna_backslash, wygrana_o)){
            return 2;
        }

        for(int i=0; i<=2; i++){
                String kolumna[] = {plansza_gry[0][i], plansza_gry[1][i], plansza_gry[2][i]};

                if(Arrays.equals(plansza_gry[i], wygrana_x) || Arrays.equals(kolumna, wygrana_x)){
                    return 1;
                }
                else if(Arrays.equals(plansza_gry[i], wygrana_o) || Arrays.equals(kolumna, wygrana_o)){
                    return 2;
                }
        }
        return 0;
    }


    public static void draw_plansze(String plansza_gry[][])
    {
        for(int i=0;i<=2;i++) {
            System.out.println(plansza_gry[i][0] + ',' + plansza_gry[i][1] + ',' + plansza_gry[i][2]);
        }
    }

    public static boolean check_ruch(String pole_ruch)
    {
        String list_xo [] = {"x", "o"};
        for(String str: list_xo) {
            if(str.trim().contains(pole_ruch))
                return false;
        }
        return true;
    }

    public static void main (String args[])
    {
        Scanner sc = new Scanner(System.in);
        String plansza_gry[][] = {{"-", "-", "-"},{"-", "-", "-"},{"-", "-", "-"}};
        boolean max_liczba_ruchu = false;
        boolean zwyciestwo = false;
        boolean ruch_mozliwy = false;
        int ruch_wiersz_gracz_x = 0;
        int ruch_kolumna_gracz_x = 0;
        int ruch_wiersz_gracz_o = 0;
        int ruch_kolumna_gracz_o = 0;
        int wynik = 0;

        while(!max_liczba_ruchu || !zwyciestwo){
            draw_plansze(plansza_gry);
            while(!ruch_mozliwy) {
                System.out.println("Ruch gracza z X (wpisz licząc od górnego lewego rogu pozycje najpierw wiersz(0,1,2) potem kolumna (0,1,2)):");
                ruch_wiersz_gracz_x = sc.nextInt();
                ruch_kolumna_gracz_x = sc.nextInt();
                ruch_mozliwy = check_ruch(plansza_gry[ruch_wiersz_gracz_x][ruch_kolumna_gracz_x]);
                if(ruch_mozliwy == false){
                    System.out.println("Ruch niemożliwy do wykonania podaj inny ruch");
                }
            }
            plansza_gry[ruch_wiersz_gracz_x][ruch_kolumna_gracz_x] = "x";
            ruch_mozliwy = false;
            wynik = check_result(plansza_gry);
            if(wynik > 0){
                zwyciestwo = true;
                break;
            }
            draw_plansze(plansza_gry);
            while(!ruch_mozliwy) {
                System.out.println("Ruch gracza z o (wpisz licząc od górnego lewego rogu pozycje najpierw wiersz(0,1,2) potem kolumna (0,1,2)):");
                ruch_wiersz_gracz_o = sc.nextInt();
                ruch_kolumna_gracz_o = sc.nextInt();
                ruch_mozliwy = check_ruch(plansza_gry[ruch_wiersz_gracz_o][ruch_kolumna_gracz_o]);
                if(ruch_mozliwy == false){
                    System.out.println("Ruch niemożliwy do wykonania podaj inny ruch");
                }
            }
            plansza_gry[ruch_wiersz_gracz_o][ruch_kolumna_gracz_o] = "o";
            ruch_mozliwy = false;
            wynik = check_result(plansza_gry);
            if(wynik > 0){
                zwyciestwo = true;
                break;
            }
        }
        if (zwyciestwo == true){
            if(wynik == 1){
                System.out.println("Zwyciężył gracz x");
            }
            else if(wynik == 2){
                System.out.println("Zwyciężył gracz o");
            }
            else if(wynik == 0){
                System.out.println("BŁĄÐ!");
            }
        }
        if (zwyciestwo == false){
                System.out.println("REMIS");
        }
        draw_plansze(plansza_gry);
    }
}
