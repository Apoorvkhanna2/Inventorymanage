import java.util.*;

class Item {
    String name;
    int quantity;
    double price;

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Quantity: " + quantity + ", Price: " + price;
    }
}
 class InventoryManagementSystem {
    static Map<String, Item> inventory = new HashMap<>();

    public static void addItem(String name, int quantity, double price) {
        if (inventory.containsKey(name)) {
            Item existingItem = inventory.get(name);
            existingItem.quantity += quantity;  // Add to existing quantity
        } else {
            inventory.put(name, new Item(name, quantity, price));
        }
        System.out.println("Item added successfully.");
    }

    public static void viewInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("Inventory Details:");
        for (Item item : inventory.values()) {
            System.out.println(item);
        }
    }

    public static void updateItem(String name, int quantity, double price) {
        if (inventory.containsKey(name)) {
            Item item = inventory.get(name);
            item.quantity = quantity;
            item.price = price;
            System.out.println("Item updated successfully.");
        } else {
            System.out.println("Item not found in inventory.");
        }
    }

    public static void deleteItem(String name) {
        if (inventory.containsKey(name)) {
            inventory.remove(name);
            System.out.println("Item deleted successfully.");
        } else {
            System.out.println("Item not found in inventory.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Item");
            System.out.println("2. View Inventory");
            System.out.println("3. Update Item");
            System.out.println("4. Delete Item");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    addItem(name, quantity, price);
                    break;

                case 2:
                    viewInventory();
                    break;

                case 3:
                    System.out.print("Enter item name to update: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    updateItem(updateName, newQuantity, newPrice);
                    break;

                case 4:
                    System.out.print("Enter item name to delete: ");
                    String deleteName = scanner.nextLine();
                    deleteItem(deleteName);
                    break;

                case 5:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
