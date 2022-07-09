import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ATM mainATM = new ATM();

        mainATM.InStock(100);
        mainATM.InStock(200);
        mainATM.InStock(500);
        mainATM.InStock(1000);
        mainATM.InStock(2000);

        mainATM.pinCheck();
    }
}
