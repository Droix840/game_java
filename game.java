package games.memoryGame;

import java.util.Scanner;
import java.util.Random;

class Tov{
    int cordinateRow;
    int cordinateColumn;
}
public class game{
    public static Starting gameStart;
    static final Scanner scanner = new Scanner(System.in);
    static final Random random = new Random();
    static Cod kod = new Cod();
    public static Tov tov = new Tov();
    static int column = 0;
    public static void main(String [] args) throws InterruptedException{
        kod();
        boolean key = false;
        if (gameStart == Starting.START) {
            key = true;
            keyToLoading(key);
            comon();
        } else if (gameStart == Starting.STOP){
            keyToLoading(key);
        }
        
    }
    public static void comon() throws InterruptedException{
        String[][] palya = new String[10][10];
        int rand = random.nextInt(0,9);
        boolean next = true;
        int randomGameNumber = random.nextInt(10);
        String elemChar = "o";
        palyaInic(palya, randomGameNumber, elemChar, next);
        draw(palya);
        Thread.sleep(5000);
        next = false;
        palyaInic(palya, randomGameNumber, elemChar, next);
        draw(palya);
        System.out.print("melyik kordinátán volt az 'o':");
        System.out.print("x: ");int xCor = scanner.nextInt();
        System.out.print("y: ");int yCor = scanner.nextInt();
        boolean corditEdit;
        if (xCor == tov.cordinateColumn && yCor == tov.cordinateRow) {
            corditEdit = true;
        } else {
            corditEdit = false;
        }
        System.out.println(corditEdit);
    }
    static void keyToLoading(boolean key)throws InterruptedException{
        if (key) {
            loading();
        } else {
            System.out.println("Helytelen kód");
        }
    }
    static void draw(String[][] palya){
        for (int i = 0;i < palya.length;i++) {
            for (int j = 0;j < palya[i].length;j++){
                System.out.print(palya[i][j]);
            }
            System.out.println();
        }

    }
    static int palyaInic(String[][] palya, int rand, String elemChar,boolean next){
        if (next) {
            for (int i = 0;i < palya.length;i++) {
                for (int j = 0;j < palya[i].length;j++) {
                    if (i == rand && j == rand){
                        palya[i][j] = elemChar;
                        tov.cordinateColumn = i + 1;
                        tov.cordinateRow = j + 1;
                    } else {
                        palya[i][j] = "x";
                    }
                }
            }
        } else {
            for (int i = 0;i < palya.length;i++) {
                for (int j = 0;j < palya[i].length;j++) {
                    palya[i][j] = " ";
                }
            }
        }
        return tov.cordinateColumn + tov.cordinateRow;
    }
    static void loading()throws InterruptedException{
        int id = 0;
        int rand = random.nextInt(1, 10);
        int randd = rand * 100;
        for (int i = 0;i <= 10;i++) {
            System.out.println(id + "%");
            Thread.sleep(randd);
            id+=10;
        }
    }
    static Starting kod(){
        System.out.print("Start cod: ");
        int cod = scanner.nextInt();
        if (cod == kod.memor_cod) {
            gameStart = Starting.START;
        } else {
            gameStart = Starting.STOP;
        }
        return gameStart;
    }
}
