import java.util.Scanner;

public class Shopping {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = 0;
        double[] saveShirina = new double[100];
        double[] saveVysota = new double[100];
        double[] saveVesZakaza = new double[100];
        double shirina;
        double vysota;
        int ves1Cronsh = 50;
        int ves1Karnis = 900;
        int ves1Tkan = 710;
        int countCronsh;
        int vesIzdelGR;
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
                    saveShirina[count++] = shirina;
                    System.out.println("Введите высоту изделия (в метрах): ");
                    vysota = scanner.nextDouble();
                    saveVysota[count++] = vysota;

                    if (shirina > 1.6) {
                        countCronsh = 4;

                    } else {
                        countCronsh = 3;

                    }

                    int vesKarnis = (int) (ves1Karnis * shirina);
                    int vesTkan = (int) ((ves1Tkan * (shirina * vysota)) / 2);
                    vesIzdelGR = vesKarnis + vesTkan + (countCronsh * ves1Cronsh) + corobTkan;
                    vesIzdelKG = vesIzdelGR / 1000;
                    System.out.println(shirina + " * " + vysota + " вес в граммах: " + vesIzdelGR + ". Вес в килограммах: " + vesIzdelKG);
                    break;

                case 2:

                    for (int i = 0; i < 100; i++) {

                        if (saveShirina != null && saveVysota != null && saveVesZakaza != null) {

                            System.out.println((i + 1) + ". " + saveShirina[i] + " * " + saveVysota[i] + ". Вес заказа: " + saveVesZakaza[i]);
                        }
                    }

                    break;

                case 3:

                    for (int i = 0; i < 100; i++) {

                        saveShirina[i] = Double.parseDouble(null);
                        saveVysota[i] = Double.parseDouble(null);
                        saveVesZakaza[i] = Double.parseDouble(null);
                    }
                    break;

                case 4:

                    return;
            }
        }
    }
}
