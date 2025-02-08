import java.util.Scanner;

public class Shopping {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int countX = 0;
        int countY = 0;
        int countZ = 0;
        double[][] haracteristiki = new double[100][100];
        double[] saveVes = new double[100];

        double shirina;
        double vysota;
        double ves1Cronsh = 50;
        double ves1Karnis = 900;
        double ves1Tkan = 710;
        int countCronsh;
        double vesIzdelGR;
        double vesIzdelKG;
        int corobTkan = 100;

        while (true) {
            System.out.println("Здравствуйте Геннадий Юрьевич! Выберите одну из команд (1-4):");
            System.out.println("1. Посчитать вес изделия.");
            System.out.println("2. Показать историю изделий.");
            System.out.println("3. Очистить историю изделий.");
            System.out.println("4. Завершить работу программы.");
            int command = scanner.nextInt();

            switch (command) {

                case 1:
                    System.out.println("Введите ширину изделия (в метрах): ");
                    shirina = scanner.nextDouble();
                    haracteristiki[countX][countY++] = shirina;
                    System.out.println("Введите высоту изделия (в метрах): ");
                    vysota = scanner.nextDouble();

                    haracteristiki[countX++][countY] = vysota;

                    if (shirina > 1.6) {
                        countCronsh = 4;

                    } else {
                        countCronsh = 3;

                    }

                    int vesKarnis = (int) (ves1Karnis * shirina);
                    int vesTkan = (int) ((ves1Tkan * (shirina * vysota)) / 2);
                    vesIzdelGR = vesKarnis + vesTkan + (countCronsh * ves1Cronsh) + corobTkan;
                    vesIzdelKG = (double) (vesIzdelGR / 1000);

                    System.out.println(shirina + " * " + vysota + " вес в граммах: " + vesIzdelGR + ". Вес в килограммах: " + vesIzdelKG);
                     saveVes[countZ++]= vesIzdelKG;

                    break;

                case 2:
                        for (int x = 0; x < 100; x++) {
                            for (int y = 0; y < 100; y++) {
                                
                                if(haracteristiki[x][y] == 0) continue;
                                if (haracteristiki[x][y+1] == 0) continue;
                                
                                if (y == 99) {
                                    break;
                                } else {
                                    System.out.println(haracteristiki[x][y] + " * " + haracteristiki[x][y + 1] + ". Вес (в кг): " + saveVes[x]);
                                }
                            }
                        }
                    break;

                case 3:

                    for (int x = 0; x < 100; x++) {
                        for (int y = 0; y < 100; y++) {

                            haracteristiki[x][y] = 0.0;
                        }
                    }
                    break;

                case 4:
                    return;
            }
        }
    }
}
