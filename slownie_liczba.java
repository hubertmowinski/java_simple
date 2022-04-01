import java.io.*;
import java.lang.*;

public class lab2_zad1 {
    public static void main (String args[])
    {
    int liczba = - 28;
    String slownie = "";
    String slownie_dziesiatki;
    String slownie_jednosci;

    if(liczba < 0){
        slownie = "minus " + slownie;
        liczba *= -1;
    }
    int dziesiatki = (int) Math.floor(liczba / 10);
    slownie_dziesiatki = switch (dziesiatki){
        case 1 -> "";
        case 2 -> "dwadzieścia ";
        case 3 -> "trzydzieści ";
        case 4 -> "czterdzieści ";
        case 5 -> "pięćdziesiąt ";
        case 6 -> "sześćdziesiąt ";
        case 7 -> "siedemdziesiąt ";
        case 8 -> "osiemdziesiąt ";
        case 9 -> "dziewięćdziesiąt ";
        case 10 -> "sto ";
        default -> "Error";
    };

    slownie += slownie_dziesiatki;
    int jednosci = liczba - dziesiatki * 10;

    if (dziesiatki == 1)
    {
        slownie_jednosci = switch (jednosci){
            case 0 -> "dziesięć";
            case 1 -> "jedenaście";
            case 2 -> "dwanaście";
            case 3 -> "trzynaście";
            case 4 -> "czternaście";
            case 5 -> "piętnaście";
            case 6 -> "szesnaście";
            case 7 -> "siedemnaście";
            case 8 -> "osiemnaście";
            case 9 -> "dziewiętnaście";
            default -> "Error";
        };
    }
    else{
    slownie_jednosci = switch (jednosci){
        case 0 -> "";
        case 1 -> "jeden";
        case 2 -> "dwa";
        case 3 -> "trzy";
        case 4 -> "cztery";
        case 5 -> "pięc";
        case 6 -> "sześć";
        case 7 -> "siedem";
        case 8 -> "osiem";
        case 9 -> "dziewięć";
        default -> "Error";
    };
    }
    slownie += slownie_jednosci;
    System.out.println(slownie);
    }
}
