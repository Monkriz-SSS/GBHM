package homeWorkLesson4;

import java.util.Random;
import java.util.Scanner;

public class MainClass {

    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static boolean checkWin(char symb) {

        return (checkHorizontalWin(symb) || checkVerticalWin(symb) || checkPositiveDiagonalWin(symb)
                || checkNegativeDiagonalWin(symb) || checkSmallPositiveDiagonalWin(symb) || checkSmallNegativeDiagonalWin(symb));

    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x = 0, y = 0;

        do {
            if (aiTurnHorizontal() || aiTurnVertical() || aiTurnPositiveDiagonal() || aiTurnNegativeDiagonal() || aiTurnSmallPositiveDiagonal() || aiTurnSmallNegativeDiagonal()) {
                return;
            }
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }


    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean checkHorizontalWin(char symb) {
        int checkDots = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb) {
                    checkDots++;
                } else {
                    checkDots = 0;
                }
                if (checkDots == DOTS_TO_WIN) {
                    return true;
                }
            }
            checkDots = 0;
        }
        return false;
    }

    public static boolean checkVerticalWin(char symb) {
        int checkDots = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == symb) {
                    checkDots++;
                } else {
                    checkDots = 0;
                }
                if (checkDots == DOTS_TO_WIN) {
                    return true;
                }
            }
            checkDots = 0;
        }
        return false;
    }

    public static boolean checkPositiveDiagonalWin(char symb) {
        int checkDots = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == j) {
                    if (map[i][j] == symb) {
                        checkDots++;
                    } else checkDots = 0;
                }
            }
        }

        if (checkDots == DOTS_TO_WIN) {
            return true;
        } else checkDots = 0;
        return false;
    }

    public static boolean checkNegativeDiagonalWin(char symb) {
        int checkDots = 0;
        int count = 0;

        for (int i = SIZE - 1; i >= 0; i--) {
            if (map[i][count] == symb) {
                checkDots++;
            } else checkDots = 0;
            count++;
        }

        if (checkDots == DOTS_TO_WIN) {
            return true;
        } else checkDots = 0;
        return false;
    }

    public static boolean checkSmallPositiveDiagonalWin(char symb) {
        int checkDots = 0;
        for (int i = SIZE - DOTS_TO_WIN; i > 0; i--) {
            int count = i;
            for (int j = 0; j < SIZE - 1; j++) {
                if (map[count][j] == symb) {
                    checkDots++;
                    if (checkDots == DOTS_TO_WIN) {
                        return true;
                    }
                } else checkDots = 0;
                if (count < SIZE - 1) {
                    count++;
                }
            }
        }

        for (int i = SIZE - DOTS_TO_WIN; i > 0; i--) {
            int count = i;
            for (int j = 0; j < SIZE - 1; j++) {
                if (map[j][count] == symb) {
                    checkDots++;
                    if (checkDots == DOTS_TO_WIN) {
                        return true;
                    }
                } else checkDots = 0;
                if (count < SIZE - 1) {
                    count++;
                }
            }

        }
        return false;
    }

    public static boolean checkSmallNegativeDiagonalWin(char symb) {
        int checkDots = 0;
        int temp = SIZE - 2;
        for (int j = 0; j < SIZE - DOTS_TO_WIN; j++) {
            int count = 0;
            for (int i = temp; i >= 0; i--) {
                if (map[i][count] == symb) {
                    checkDots++;
                } else checkDots = 0;
                if (count <= SIZE) {
                    count++;
                }
                if (checkDots == DOTS_TO_WIN) {
                    return true;
                }
            }

            if (temp >= 0) {
                temp--;
            }
        }
        checkDots = 0;
        int temp2 = SIZE - DOTS_TO_WIN;
        for (int j = 0; j < SIZE - DOTS_TO_WIN; j++) {
            int count2 = SIZE - 1;
            for (int i = temp2; i < SIZE; i++) {
                if (map[count2][i] == symb) {
                    checkDots++;
                } else checkDots = 0;
                if (checkDots == DOTS_TO_WIN) {
                    return true;
                }
                if (count2 > 0) {
                    count2--;
                }
            }
            if (checkDots == DOTS_TO_WIN) {
                return true;
            } else checkDots = 0;
            if (temp2 < SIZE) {
                temp2--;
            }
        }
        return false;

    }

    public static boolean aiTurnHorizontal() {
        int checkDots = 0;
        int count = 0;
        Outer:
        for (int i = 0; i < SIZE; i++) {
            Inner:
            for (int j = 0; j < SIZE; j++) {
                if (checkDots == DOTS_TO_WIN / 2 && map[i][j] == DOT_O) {
                    checkDots = 0;
                    continue Inner;
                } else if (checkDots >= DOTS_TO_WIN / 2) {
                    if (map[i][j] == DOT_O && j - DOTS_TO_WIN >= 0 && map[i][j - 4] == DOT_EMPTY) {
                        map[i][j - 4] = DOT_O;
                        System.out.println("Компьютер походил в точку " + (j - 4 + 1) + " " + (i + 1));
                        return true;
                    }
                    if (map[i][j] == DOT_EMPTY) {
                        map[i][j] = DOT_O;
                        System.out.println("Компьютер походил в точку " + (j + 1) + " " + (i + 1));
                        return true;
                    }
                }
                if (map[i][j] == DOT_X) {
                    checkDots++;
                }

            }
            checkDots = 0;
        }


        for (int i = SIZE - 1; i >= 0; i--) {
            Inner:
            for (int j = SIZE - 1; j >= 0; j--) {
                if (checkDots == DOTS_TO_WIN / 2 && map[i][j] == DOT_O) {
                    checkDots = 0;
                    continue Inner;
                } else if (checkDots >= DOTS_TO_WIN / 2) {
                    if (map[i][j] == DOT_EMPTY) {
                        map[i][j] = DOT_O;
                        System.out.println("Компьютер походил в точку " + (j + 1) + " " + (i + 1));
                        return true;
                    }
                }
                if (map[i][j] == DOT_X) {
                    checkDots++;
                } else {
                    checkDots = 0;
                }
                if (checkDots == DOTS_TO_WIN) {
                    return true;
                }
            }
            checkDots = 0;
        }

        return false;
    }

    public static boolean aiTurnVertical() {
        int checkDots = 0;
        OUTER:
        for (int i = 0; i < SIZE; i++) {
            Inner:
            for (int j = 0; j < SIZE; j++) {
                if (checkDots == DOTS_TO_WIN / 2 && map[j][i] == DOT_O) {
                    checkDots = 0;
                    continue Inner;
                } else if (checkDots >= DOTS_TO_WIN / 2) {
                    if (map[j][i] == DOT_EMPTY) {
                        map[j][i] = DOT_O;
                        System.out.println("Компьютер походил в точку " + (j + 1) + " " + (i + 1));
                        return true;
                    }
                }
                if (map[j][i] == DOT_X) {
                    checkDots++;
                }
            }
            checkDots = 0;
        }
        OUTER:
        for (int i = 0; i < SIZE; i++) {
            Inner:
            for (int j = SIZE - 1; j >= 0; j--) {
                if (checkDots == DOTS_TO_WIN / 2 && map[j][i] == DOT_O) {
                    checkDots = 0;
                    continue Inner;
                } else if (checkDots >= DOTS_TO_WIN / 2) {
                    if (map[j][i] == DOT_EMPTY) {
                        map[j][i] = DOT_O;
                        System.out.println("Компьютер походил в точку " + (j + 1) + " " + (i + 1));
                        return true;
                    }
                }
                if (map[j][i] == DOT_X) {
                    checkDots++;
                }
            }
            checkDots = 0;
        }
        return false;
    }

    public static boolean aiTurnPositiveDiagonal() {
        int checkDots = 0;
        for (int i = 0; i < SIZE; i++) {
            Inner:
            for (int j = 0; j < SIZE; j++) {
                if (i == j) {
                    if (checkDots == DOTS_TO_WIN / 2 && map[i][j] == DOT_O) {
                        checkDots = 0;
                        continue Inner;
                    } else if (checkDots >= DOTS_TO_WIN / 2) {
                        if (map[i][j] == DOT_EMPTY) {
                            map[i][j] = DOT_O;
                            System.out.println("Компьютер походил в точку " + (j + 1) + " " + (i + 1));
                            return true;
                        }
                    }


                    if (map[i][j] == DOT_X) {
                        checkDots++;
                    }
                }
            }
        }

        checkDots = 0;
        for (int i = SIZE - 1; i >= 0; i--) {
            Inner:
            for (int j = SIZE - 1; j >= 0; j--) {
                if (i == j) {
                    if (checkDots == DOTS_TO_WIN / 2 && map[i][j] == DOT_O) {
                        checkDots = 0;
                        continue Inner;
                    } else if (checkDots >= DOTS_TO_WIN / 2) {
                        if (map[i][j] == DOT_EMPTY) {
                            map[i][j] = DOT_O;
                            System.out.println("Компьютер походил в точку " + (j + 1) + " " + (i + 1));
                            return true;
                        }
                    }


                    if (map[i][j] == DOT_X) {
                        checkDots++;
                    }
                }
            }
        }

        return false;
    }

    public static boolean aiTurnNegativeDiagonal() {
        int checkDots = 0;
        int count = 0;

        for (int i = SIZE - 1; i >= 0; i--) {
            if (checkDots == DOTS_TO_WIN / 2 && map[count][i] == DOT_O) {
                checkDots = 0;
                continue;
            } else if (checkDots >= DOTS_TO_WIN / 2) {
                if (map[count][i] == DOT_EMPTY) {
                    map[count][i] = DOT_O;
                    System.out.println("Компьютер походил в точку " + (i + 1) + " " + (count + 1));
                    return true;
                }
            }
            if (map[count][i] == DOT_X) {
                checkDots++;
            }
            count++;
        }
        checkDots = 0;
        count = 0;

        for (int i = SIZE - 1; i >= 0; i--) {
            if (checkDots == DOTS_TO_WIN / 2 && map[i][count] == DOT_O) {
                checkDots = 0;
                continue;
            } else if (checkDots >= DOTS_TO_WIN / 2) {
                if (map[i][count] == DOT_EMPTY) {
                    map[i][count] = DOT_O;
                    System.out.println("Компьютер походил в точку " + (i + 1) + " " + (count + 1));
                    return true;
                }
            }
            if (map[i][count] == DOT_X) {
                checkDots++;
            }
            count++;
        }


        return false;
    }

    public static boolean aiTurnSmallPositiveDiagonal() {
        int checkDots = 0;
        for (int i = SIZE - DOTS_TO_WIN; i > 0; i--) {
            int count = i;
            Inner:
            for (int j = 0; j < SIZE - 1; j++) {
                if (checkDots == DOTS_TO_WIN / 2 && map[count][j] == DOT_O) {
                    checkDots = 0;
                    continue Inner;
                } else if (checkDots >= DOTS_TO_WIN / 2) {
                    if (map[count][j] == DOT_EMPTY) {
                        map[count][j] = DOT_O;
                        System.out.println("Компьютер походил в точку " + (j + 1) + " " + (j + 1));
                        return true;
                    }
                }
                if (map[count][j] == DOT_X) {
                    checkDots++;
                }
                if (count < SIZE - 1) {
                    count++;
                }
            }
            checkDots = 0;
        }


        for (int i = SIZE - DOTS_TO_WIN; i > 0; i--) {
            int count = i;
            Inner:
            for (int j = 0; j < SIZE - 1; j++) {
                if (checkDots == DOTS_TO_WIN / 2 && map[j][count] == DOT_O) {
                    checkDots = 0;
                    continue Inner;
                } else if (checkDots >= DOTS_TO_WIN / 2) {
                    if (map[j][count] == DOT_EMPTY) {
                        map[j][count] = DOT_O;
                        System.out.println("Компьютер походил в точку " + (count + 1) + " " + (j + 1));
                        return true;
                    }
                }
                if (map[j][count] == DOT_X) {
                    checkDots++;
                }
                if (count < SIZE - 1) {
                    count++;
                }
            }
            checkDots = 0;
        }
        return false;
    }

    public static boolean aiTurnSmallNegativeDiagonal() {
        int checkDots = 0;
        int temp = SIZE - 2;
        for (int j = 0; j < SIZE - DOTS_TO_WIN; j++) {
            int count = 0;
            Inner:
            for (int i = temp; i >= 0; i--) {
                if (checkDots == DOTS_TO_WIN / 2 && map[i][count] == DOT_O) {
                    checkDots = 0;
                    continue Inner;
                } else if (checkDots >= DOTS_TO_WIN / 2) {
                    if (map[i][count] == DOT_EMPTY) {
                        map[i][count] = DOT_O;
                        System.out.println("Компьютер походил в точку " + (j + 1) + " " + (j + 1));
                        return true;
                    }
                }
                if (map[i][count] == DOT_X) {
                    checkDots++;
                    if (checkDots == DOTS_TO_WIN) {
                        return true;
                    }
                } else checkDots = 0;
                if (count <= SIZE) {
                    count++;
                }
            }

            if (temp >= 0) {
                temp--;
            }
        }

        checkDots = 0;
        int temp2 = SIZE - DOTS_TO_WIN;
        for (int j = 0; j < SIZE - DOTS_TO_WIN; j++) {
            int count2 = SIZE - 1;
            Inner:
            for (int i = temp2; i < SIZE; i++) {
                if (checkDots == DOTS_TO_WIN / 2 && map[count2][i] == DOT_O) {
                    checkDots = 0;
                    continue Inner;
                } else if (checkDots >= DOTS_TO_WIN / 2) {
                    if (map[count2][i] == DOT_EMPTY) {
                        map[count2][i] = DOT_O;
                        System.out.println("Компьютер походил в точку " + (j + 1) + " " + (j + 1));
                        return true;
                    }
                }
                if (map[count2][i] == DOT_X) {
                    checkDots++;
                    if (checkDots == DOTS_TO_WIN) {
                        return true;
                    }
                } else checkDots = 0;
                if (count2 > 0) {
                    count2--;
                }
            }

            if (temp2 < SIZE) {
                temp2--;
            }
        }
        return false;
    }
}