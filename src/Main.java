/*
  Лабораторна робота №4: Успадкування в Java
  Варіант 6: Товари

  Суперклас: Product
  Підкласи: FoodProduct, ElectronicProduct, ClothingProduct

  Спільні члени (винесені в Product):
    - Поля: name, price
    - Метод: printProductInfo()
    - Гетери: getName(), getPrice()

  Специфічні члени підкласів:
    - FoodProduct: shelfLifeDays, printShelfLife()
    - ElectronicProduct: warrantyMonths, printWarranty()
    - ClothingProduct: size, printSize()
 */

// СУПЕРКЛАС (Базовий клас)
class Product {
    private final String name;
    private final double price;

    public Product(String name, double price) {
        System.out.println("-> Конструктор суперкласу Product");
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void printProductInfo() {
        System.out.println("Товар: " + name + " | Ціна: " + price + " грн");
    }
}

// ПІДКЛАС 1: Продукти харчування
class FoodProduct extends Product {
    private final int shelfLifeDays;

    public FoodProduct(String name, double price, int shelfLifeDays) {
        super(name, price); // Виклик конструктора суперкласу
        System.out.println("-> Конструктор підкласу FoodProduct");
        this.shelfLifeDays = shelfLifeDays;
    }

    public void printShelfLife() {
        System.out.println("Термін придатності (" + getName() + "): " + shelfLifeDays + " днів");
    }
}

// ПІДКЛАС 2: Електроніка
class ElectronicProduct extends Product {
    private final int warrantyMonths;

    public ElectronicProduct(String name, double price, int warrantyMonths) {
        super(name, price);
        System.out.println("-> Конструктор підкласу ElectronicProduct");
        this.warrantyMonths = warrantyMonths;
    }

    public void printWarranty() {
        System.out.println("Гарантійний термін (" + getName() + "): " + warrantyMonths + " міс.");
    }
}

// ПІДКЛАС 3: Одяг (Додатковий підклас)
class ClothingProduct extends Product {
    private final String size;

    public ClothingProduct(String name, double price, String size) {
        super(name, price);
        System.out.println("-> Конструктор підкласу ClothingProduct");
        this.size = size;
    }

    public void printSize() {
        System.out.println("Розмір одягу (" + getName() + "): " + size);
    }
}

// ТОЧКА ВХОДУ (Демонстрація)
public class Main {
    static void main(String[] args) {
        System.out.println("=== 1. Перевірка порядку виклику конструкторів ===");
        FoodProduct milk = new FoodProduct("Молоко 2.5%", 42.50, 7);
        System.out.println();

        ElectronicProduct laptop = new ElectronicProduct("Ноутбук ASUS", 32999.00, 24);
        System.out.println();

        ClothingProduct hoodie = new ClothingProduct("Худі Oversize", 1200.00, "L");
        System.out.println();

        System.out.println("=== 2. Робота методів об'єктів ===");

        // Демонстрація FoodProduct
        milk.printProductInfo(); // Успадкований метод
        milk.printShelfLife();   // Власний метод
        System.out.println();

        // Демонстрація ElectronicProduct
        laptop.printProductInfo();
        laptop.printWarranty();
        System.out.println();

        // Демонстрація ClothingProduct
        hoodie.printProductInfo();
        hoodie.printSize();
        System.out.println("Демонстрація getPrice(): " + hoodie.getPrice() + " грн");
    }
}