package ra.entity;

import java.util.Date;

public class Laptop {
    private String laptopId;
    private String laptopName;
    private String description;
    private int ram;
    private double weight;
    private Date createAt;
    private double laptopPrice;
    private int typeId;
    private boolean isDeleted;
    //Constructor

    public Laptop() {
    }

    public Laptop(String laptopId, String laptopName, String decription, int ram, double weight, double laptopPrice, int typeId, boolean isDeleted) {
        this.laptopId = laptopId;
        this.laptopName = laptopName;
        this.description = decription;
        this.ram = ram;
        this.weight = weight;
        this.laptopPrice = laptopPrice;
        this.typeId = typeId;
        this.isDeleted = isDeleted;
    }
    //Getter and Setter

    public String getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(String laptopId) {
        this.laptopId = laptopId;
    }

    public String getLaptopName() {
        return laptopName;
    }

    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }

    public String getDecription() {
        return description;
    }

    public void setDecription(String decription) {
        this.description = decription;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public double getLaptopPrice() {
        return laptopPrice;
    }

    public void setLaptopPrice(double laptopPrice) {
        this.laptopPrice = laptopPrice;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
    //toString()

    @Override
    public String toString() {
        return "Mã laptop: "+this.laptopId+"\nTên laptop: "+this.laptopName+"\nMô tả: "+this.description+
                "\nRAM: "+this.ram+"\nCân nặng: "+this.weight+"\nGiá laptop: "+
                this.laptopPrice+"\nMã loại laptop: "+this.typeId+"\nTrạng thái đã xoá: "+this.isDeleted+"\n";
    }
}
