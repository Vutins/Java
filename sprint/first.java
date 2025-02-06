import java.util.Scanner;

public class Shopping {

    public static void main(String[] args) {

        System.out.println("Вас приветствует список покупок!");

        int currentListSize = 8;
        String[] shoppingList = new String[currentListSize];
        int productCount = 0;
        String product;
        int actionNumber;

        Scanner scanner = new Scanner(System.in);


        while (true) {

            System.out.println("Выберите одну из команд:");
            System.out.println("1. Добавить товар в список");
            System.out.println("2. Отобразить список");
            System.out.println("3. Очистить список");
            System.out.println("4. Завершить программу");

            actionNumber = scanner.nextInt();

            switch (actionNumber) {

                case 1:

                    if (productCount == shoppingList.length) {

                        int newListSize = productCount * 2;
                        String[] newShoppingList = new String[newListSize];

                        for (int i = 0; i < shoppingList.length ; i++) {

                            newShoppingList[i] = shoppingList[i];
                        }
                        shoppingList = newShoppingList;
                        currentListSize = newListSize;
                    }


                    System.out.println("Введите название товара:");
                    product = scanner.next();
                    boolean productAlreadyExist = false;

                    for (int i = 0; i < shoppingList.length;i++) {

                        if(product.equals(shoppingList[i])) {
                            productAlreadyExist = true;
                            break;
                        }

                    }
                    if (productAlreadyExist) {

                        System.out.println("Такой товар уже есть в списке!");

                    } else {

                        shoppingList[productCount++] = product;
                        System.out.println("Товар " + product + " добавлен в список под номером " + productCount );
                    }
                    break;

                case 2:

                    for (int i = 0; i < productCount; i++) {
                        System.out.println(i + 1 + ". " + shoppingList[i]);
                    }
                    break;

                case 3:

                    for (int i = 0; i < shoppingList.length; i++){

                        shoppingList[i] = null;
                    }

                    productCount = 0;
                    System.out.println("Список очищен");
                    break;

                case 4:

                    return;

                default:

                    System.out.println("Неизвестная команда!");
            }

        }
    }
}
