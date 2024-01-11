public class Notebook extends Product<Notebook> {
    int ram;
    int storage;
    double screenSize;

    public Notebook(String brand, String description, double unitPrice, double discount, int stock, int memory, double size, int ram) {
            super(brand, description, unitPrice, discount, stock, memory, size, ram);
        }
    }


