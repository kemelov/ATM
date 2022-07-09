import java.sql.SQLOutput;
import java.util.Scanner;

public class ATM {

    public int
            summary = 0,
            inStock = 10000,
            Scanner;
    public String
            coMessage = "Введите сумму: " + "           (Чтобы закончть операцию, нажмите '0')",
            ciMessage = "Вставьте деньги: " + "           (Чтобы закончть операцию, нажмите '0')",
            notes = "Cписок имеющихся купюр: ",
            rNotes = "Принимаемые купюры: ",
            composition = "";
    public Scanner Enter = new Scanner(System.in);


    public ATM() {
    }

    public void InStock(int som) {
        notes = notes +"\n" + som +" сом";
        rNotes = rNotes +"\n" + som +" сом";
    }

    public void cashOut() {
        System.out.println(coMessage);
        Scanner = Enter.nextInt();
        switch (Scanner) {
            case 100, 200, 500, 1000, 2000:
                while (Scanner != 0) {
                    summary = summary + Scanner;
                    if (summary >= inStock) {
                        System.out.println("Превышен лимит получаемой суммы: " + inStock);
                        break;
                    } else {
                        composition = composition + Scanner + ".";
                        System.out.println("Итого: " + summary +" (" + composition + ")" + " " + "\n");
                        cashOut();
                    }
                }
            case 0:
                if (summary > 0) {
                    System.out.println("Операция завершена." + "\n" + "" + "Итого: " + summary + ", " + "(" + composition + ")" + " " + "\n" + "");
                    summary = 0;
                    composition = "";
                    Start();
                } else {
                    System.out.println("Операция завершена." + "\n" + "");
                    Start();
                }
            default:
                System.out.println("У нас нет таких купюр!" + "\n" + "" + "\n" + notes + "\n" + "");
                cashOut();
        }
    }

    public void cashIn() {
        System.out.println(ciMessage);
        Scanner = Enter.nextInt();
        switch (Scanner) {
            case 100, 200, 500, 1000, 2000:
                while (Scanner != 0) {
                    summary = summary + Scanner;
                    composition = composition + Scanner + ". ";
                    System.out.println("Итого: " + summary + " (" + composition + ")" + "\n");
                    cashIn();
                }
            case 0:
                if (summary > 0) {
                    System.out.println("Операция завершена." + "\n" + "" + "Итого: " + summary + ", " + "(" + composition + ")"+ "\n");
                    summary = 0;
                    composition = "";
                    Start();
                } else if (summary == 0) {
                    System.out.println("Операция завершена.");
                    Start();
                }
            default:
                System.out.println("Мы не принимаем такие купюры!" + "\n" + "\n" + notes + "\n");
                cashIn();
        }
    }





    //Переменные и метод для проверки пин-кода

    int pin = 2554;
    int attempts = 3;
    String pinCheck = "Введите пин-код";

    public void pinCheck() {
        System.out.println(pinCheck + " (4 цифр; " + attempts + " попытки)");
        Scanner = Enter.nextInt();
        if (Scanner != pin) {
            while (attempts != 1) {
                attempts = attempts - 1;
                System.out.println("Ошибка!");
                pinCheck();
            }
            System.out.println("У вас не осталось попыток");
        } else {
            Start();
        }
    }


    //Метод, который срабатывает после успешного ввода пин-кода

    public void Start() {
        String start = "Получить деньги - 1 " + "\n" + "" + "Положить деньги - 2 ";
        System.out.println(start);

        Scanner Enter = new Scanner(System.in);
        int i = Enter.nextInt();

        switch (i) {
            case 1:
                System.out.println(notes + "\n" + "" + "\n" + "");
                cashOut();
            case 2:
                System.out.println(rNotes + "\n" + "" + "\n" + "");
                cashIn();
            default:
                System.out.println("Нет такой команды! " + "\n");
                Start();
        }
    }
}