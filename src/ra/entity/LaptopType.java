package ra.entity;

public class LaptopType {
    private int typeId;
    private String typeName;
    private String description;
    private boolean isDeleted;
    //Construction

    public LaptopType() {
    }

    public LaptopType(int typeId, String typeName, String description, boolean isDeleted) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.description = description;
        this.isDeleted = isDeleted;
    }
    //Getter and Setter

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    //danh sách mã loại laptop
    public  String tpyeIdList(){
        return "Mã loại laptop: "+this.typeId+"\nTên loại laptop: "+this.typeName+"\n";
    }

    //toString()
    @Override
    public String toString() {
        return "Mã loại laptop: "+this.typeId+"\nTên loại laptop: "+this.typeName+
                "\nMô tả: "+ this.description +"\nTrạng thái đã xoá: "+this.isDeleted+"\n";
    }

}
