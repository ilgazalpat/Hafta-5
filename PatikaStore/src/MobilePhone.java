public class MobilePhone extends Product<MobilePhone>{
    private String colour;

    public MobilePhone(String brand, String description, double unitPrice, double discount, int stock, int memory, double size, int ram, String colour) {
        super(brand, description, unitPrice, discount, stock, memory, size, ram);
        this.colour = colour;
    }


    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}