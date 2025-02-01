public class Practicum {

    public static void main(String[] args) {
        String coffeeType = "Капучино";
        switch (coffeeType) {
            case "Капучино":
                System.out.println("Приготовлено эспрессо.");
                System.out.println("Добавлено молоко.");
                break;
            case "Американо":
                System.out.println("Приготовлено эспрессо.");
                System.out.println("Добавлена вода.");
                break;
            case "Эспрессо":
                System.out.println("Приготовлено эспрессо.");
                break;
            default:
                System.out.println("Такой тип кофе я не готовлю!");
        }
    }
}
