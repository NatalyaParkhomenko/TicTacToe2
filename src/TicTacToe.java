import java.util.*;

public class TicTacToe {
    static final char SIGN_X = 'x';
    static final char SIGN_0 = '0';
    static final char SIGN_EMPTY = ' ';
    static char[][] table;
    Scanner sc;


    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }

    TicTacToe() {                         // конструктор: ініціализація полей
        sc = new Scanner(System.in);
        table = new char[3][3];          // таблиця с розмірами 3 на 3
        initTable();  // ініціалізація табліци
    }

    static void initTable() {  // начальное заполенение таблици
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                table[row][col] = SIGN_EMPTY;
                System.out.print("[" + table[row][col] + "]");
            }
            System.out.println();
        }
    }

    static void play() {
        while (true) {
            manWalk();
            showTable();
            if (checkWin(SIGN_X)) {
                System.out.println("Vu vuigrali!");
                break;
            }
            if (isFullTable()) {
                System.out.println("Tablica zapolnena polnostu.");
                break;
            }
            AIMove();
            showTable();
            if (checkWin(SIGN_0)) {
                System.out.println("Pobeda za mashinoy");
                break;
            }
            if (isFullTable()) {
                System.out.println("Tablica zapolnena polnostu.");
                break;
            }
        }
    }


    static void manWalk () {    // ходит человек
        int x;
        int y;
        do {
            System.out.println("Vvedite X i Y (1...3):");
            x = new Scanner(System.in).nextInt() - 1;
            y = new Scanner(System.in).nextInt() - 1;
        } while (!isCellValid(x, y));
        table[x][y] = SIGN_X;
    }

    static boolean isCellValid ( int x, int y){   // правильние ли координати
        if (x < 0 || x > 2 || y < 0 || y > 2) {
            System.out.println("Chislo ne iz diapazona (1...3)");
            return false;
        }
        if (table[x][y] != SIGN_EMPTY) {
            System.out.println("Yacheyka zanyata.");
            return false;
        }
        return true;
    }
    static void showTable () {    // вивод таблици
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print("[" + table[row][col] + "]");
            }
            System.out.println();
        }
    }
    static boolean checkWin ( char symbol){   // проверка виіграша
        for (int i = 0; i < 3; i++) {
            if ((table[i][0] == symbol && table[i][1] == symbol && table[i][2] == symbol)
                    || (table[0][i] == symbol && table[1][i] == symbol && table[2][i] == symbol))
                return true;
        }
        if ((table[0][0] == symbol && table[1][1] == symbol && table[2][2] == symbol)
                || (table[2][0] == symbol && table[1][1] == symbol && table[0][2] == symbol))
            return true;
        return false;
    }
    static boolean isFullTable () {        // заполнена ли таблица полностью?
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (table[row][col] == SIGN_EMPTY)
                    return false;
            }
        }
        return true;

    }
    static void AIMove () {   //ходит машина
        int x;
        int y;
        System.out.println("IA move");
        do {
            x = new Random().nextInt(2);
            y = new Random().nextInt(2);
        } while (!isCellValid(x, y));
        table[x][y] = SIGN_0;
    }
}









