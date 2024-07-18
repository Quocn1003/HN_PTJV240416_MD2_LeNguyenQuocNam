package ra.run;

import ra.entity.Laptop;
import ra.entity.LaptopType;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    static ArrayList<LaptopType> laptopTypes = new ArrayList<>();
    static ArrayList<Laptop> laptops = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("***************LAPTOP-MANAGEMENT***************");
            System.out.println("1. QUản lý loại laptop.");
            System.out.println("2. QUản lý laptop.");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice;
            do {
                try{
                    choice = Integer.parseInt(sc.nextLine());
                    if(choice>3 ||choice<1){
                        System.out.print("Vui lòng nhập lựa chọn từ 1 đến 3: ");
                    }else break;
                }catch(Exception e){
                    System.out.println("Vui lòng nhập số!!!");
                    System.out.print("Lựa chọn của bạn: ");
                }
            }while(true);
            switch (choice){
                case 1:
                    managementLaptopTypes(sc);
                    break;
                case 2:
                    managementLaptops(sc);
                    break;
                case 3:
                    System.exit(0);
            }
        }while(true);
    }

    //Laptop Type Menu
    public static void managementLaptopTypes(Scanner sc){
        int choice;
        do {
            System.out.println("***************LAPTOP-TYPE-MENU***************");
            System.out.println("1. Hiển thị danh sách các loại laptop.");
            System.out.println("2. Thêm mới loại laptop.");
            System.out.println("3. Cập nhật thông tin loại laptop.");
            System.out.println("4. Xoá loại laptop.");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            do {
                try{
                    choice = Integer.parseInt(sc.nextLine());
                    if(choice>5 ||choice<1){
                        System.out.print("Vui lòng nhập lựa chọn từ 1 đến 5: ");
                    }else break;
                }catch(Exception e){
                    System.err.println("Vui lòng nhập số!!!");
                    System.out.print("Lựa chọn của bạn: ");
                }
            }while(true);
            switch (choice){
                case 1:
                    displayLaptopTypes();
                    break;
                case 2:
                    addLaptopType(sc);
                    break;
                case 3:
                    updateLaptopType(sc);
                    break;
                case 4:
                    deleteLaptopType(sc);
                    break;
                case 5:
                    System.exit(0);
            }
        }while (true);
    }
    //Hiển thị danh sách loại laptop
    private static void displayLaptopTypes(){
        System.out.println("Danh sách loại laptop: ");
        for(LaptopType type: laptopTypes){
            if(!type.isDeleted()){
                System.out.println(type);
            }
        }
    }
    //Thêm loại laptop
    private static void addLaptopType(Scanner sc){
        System.out.print("Nhập tên loại laptop: ");
        String typeName;
        boolean check;
        do {
            check=false;
            typeName = sc.nextLine();
            for(LaptopType type: laptopTypes){
                if(type.getTypeName().equals(typeName)){
                    System.out.println("Tên loại laptop đã tồn tại, Vui lòng nhập lại: ");
                    check =true;
                    break;
                }
            }
            if (!check){
                if(typeName.isEmpty()){
                    System.out.print("Tên loại laptop không được để trống! Vui lòng nhập lại: ");
                    check =true;
                }
            }
        }while (check);

        System.out.println("Nhập mô tả loại laptop: ");
        String description;
        do {
            description = sc.nextLine();
            if(description.isEmpty()){
                System.out.print("Mô tả loại laptop không được để trống! Vui lòng nhập lại: ");
            }else break;
        }while (true);

        int typeId = laptopTypes.size()+1;//tăng tự động
        LaptopType newType = new LaptopType(typeId,typeName,description,false);
        laptopTypes.add(newType);
        System.out.println("Thêm loại laptop thành công!");
    }
    //Cập nhật loại laptop
    private static void updateLaptopType(Scanner sc){
        System.out.println("Nhập mã loại laptop cần cập nhật: ");
        int typeId = Integer.parseInt(sc.nextLine());
        LaptopType typeToUpdate = null;
        for (LaptopType type : laptopTypes){
            if(type.getTypeId()== typeId){
                typeToUpdate = type;
                break;
            }
        }
        if (typeToUpdate==null){
            System.err.println("Không tìm thấy loại laptop!");
            return;
        }
        System.out.println("Thông tin loại laptop: ");
        displayLaptopTypes();
        System.out.println("Nhập tên mới (để trống nếu không muốn thay đổi):");
        String newName = sc.nextLine();
        System.out.println("Nhập mô tả mới (để trống nếu không muốn thay đổi):");
        String newDescription = sc.nextLine();
        if(!newName.isEmpty()){
            typeToUpdate.setTypeName(newName);
        }
        if(!newDescription.isEmpty()){
            typeToUpdate.setDescription(newDescription);
        }
        System.out.println("Cập nhật thông tin loại laptop thành công!");
    }
    //Xoá loại laptop
    private static void deleteLaptopType(Scanner sc){
        System.out.println("Nhập mã laptop cần xoá: ");
        int typeId = Integer.parseInt(sc.nextLine());
        LaptopType typeToDetele = null;
        for (LaptopType type : laptopTypes){
            if(type.getTypeId()== typeId){
                typeToDetele = type;
                break;
            }
        }
        if (typeToDetele==null){
            System.err.println("Không tìm thấy loại laptop!");
            return;
        }
        typeToDetele.setDeleted(false);
        System.out.println("Xoá loại laptop thành công!");
    }

    //Laptop Menu
    public static void managementLaptops(Scanner sc){
        int choice;
        do {
            System.out.println("***************LAPTOP-MENU***************");
            System.out.println("1. Danh sách laptop.");
            System.out.println("2. Thêm mới laptop.");
            System.out.println("3. Cập nhật thông tin laptop.");
            System.out.println("4. Xoá laptop.");
            System.out.println("5. Thống kê số lượng laptop theo từng loại");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            do {
                try{
                    choice = Integer.parseInt(sc.nextLine());
                    if(choice>6 ||choice<1){
                        System.out.print("Vui lòng nhập lựa chọn từ 1 đến 6: ");
                    }else break;
                }catch(Exception e){
                    System.err.println("Vui lòng nhập số!!!");
                    System.out.print("Lựa chọn của bạn: ");
                }
            }while(true);
            switch (choice){
                case 1:
                    displayLaptops();
                    break;
                case 2:
                    addLaptop(sc);
                    break;
                case 3:
                    updateLaptop(sc);
                    break;
                case 4:
                    deleteLaptop(sc);
                    break;
                case 5:
                    statisticalLaptop();
                    break;
                case 6:
                    System.exit(0);
            }
        }while (true);
    }

    private static void displayLaptops(){
        System.out.println("Danh sách laptop: ");
        for(Laptop laptop: laptops){
            if(!laptop.isDeleted()){
                System.out.println(laptop);
            }
        }
    }
    //Thêm loại laptop
    private static void addLaptop(Scanner sc){
        String laptopIdRegex = "[L\\d{4}]";
        System.out.println("Nhập mã laptop (định dạng L**** - * là các ký tự số): ");
        String laptopId;
        do {
            laptopId = sc.nextLine();
            if(!Pattern.matches(laptopIdRegex,laptopId)){
                System.out.println("Mã laptop không đúng định dạng, Vui lòng nhập lại: ");
            }else break;
        }while (true);
        System.out.print("Nhập tên laptop: ");
        String laptopName;
        boolean check;
        do {
            check=false;
            laptopName = sc.nextLine();
            for(Laptop laptop: laptops){
                if(laptop.getLaptopName().equals(laptopName)){
                    System.out.println("Tên laptop đã tồn tại, Vui lòng nhập lại: ");
                    check =true;
                    break;
                }
            }
            if (!check){
                if(laptopName.isEmpty()){
                    System.out.print("Tên laptop không được để trống! Vui lòng nhập lại: ");
                    check =true;
                }
            }
        }while (check);

        System.out.println("Nhập mô tả laptop: ");
        String description;
        do {
            description = sc.nextLine();
            if(description.isEmpty()){
                System.out.print("Mô tả laptop không được để trống! Vui lòng nhập lại: ");
            }else break;
        }while (true);

        System.out.println("Nhập bộ nhớ laptop: ");
        int ram;
        do {
            try{
                ram = Integer.parseInt(sc.nextLine());
                if(ram<=0){
                    System.out.println("Bộ nhớ phải lớn hơn 0! Vui lòng nhập lại: ");
                }else break;
            }catch (Exception e){
                System.out.println("Vui lòng nhập số:");
            }
        }while (true);

        System.out.println("Nhập cân nặng laptop: ");
        double weight;
        do {
            try{
                weight = Double.parseDouble(sc.nextLine());
                if(weight<=0){
                    System.out.println("Cân nặng phải lớn hơn 0! Vui lòng nhập lại: ");
                }else break;
            }catch (Exception e){
                System.out.println("Vui lòng nhập số:");
            }
        }while (true);

        System.out.println("Nhập giá tiền laptop: ");
        double price;
        do {
            try{
                price = Double.parseDouble(sc.nextLine());
                if(price<=0){
                    System.out.println("Giá tiền phải lớn hơn 0! Vui lòng nhập lại: ");
                }else break;
            }catch (Exception e){
                System.out.println("Vui lòng nhập số:");
            }
        }while (true);

        System.out.println("Danh sách mã loại laptop: ");
        for (LaptopType laptopType: laptopTypes){
            System.out.println(laptopType.tpyeIdList());
        }
        System.out.println("Nhập mã loại laptop: ");
        int typeId;
        do {
            try{
                typeId = Integer.parseInt(sc.nextLine());
                if (typeId<=0 || typeId>laptopTypes.size()){
                    System.out.println("Vui lòng nhập mã loại laptop trong danh sách: ");
                }else break;
            }catch(Exception e){
                System.out.println("Vui lòng nhập số!!!");
                System.out.print("Lựa chọn của bạn: ");
            }
        }while(true);

        Laptop newLaptop = new Laptop(laptopId,laptopName,description,ram,weight,price,typeId,false);
        laptops.add(newLaptop);
        System.out.println("Thêm laptop thành công!");
    }
    //Cập nhật loại laptop
    private static void updateLaptop(Scanner sc){
        String laptopIdRegex = "[L\\d{4}]";
        System.out.println("Nhập mã laptop cần cập nhật (định dạng L**** - * là các ký tự số): ");
        String laptopId;
        do {
            laptopId = sc.nextLine();
            if(!Pattern.matches(laptopIdRegex,laptopId)){
                System.out.println("Mã laptop không đúng định dạng, Vui lòng nhập lại: ");
            }else break;
        }while (true);

        Laptop laptopToUpdate = null;
        for (Laptop laptop : laptops){
            if(laptop.getLaptopId()== laptopId){
                laptopToUpdate = laptop ;
                break;
            }
        }
        if (laptopToUpdate==null){
            System.err.println("Không tìm thấy loại laptop!");
            return;
        }
        System.out.println("Nhập tên mới (để trống nếu không muốn thay đổi):");
        String newName = sc.nextLine();
        System.out.println("Nhập mô tả mới (để trống nếu không muốn thay đổi):");
        String newDescription = sc.nextLine();
        System.out.println("Nhập bộ nhớ mới (Nhập 0 nếu không muốn thay đổi):");
        int newRam = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập cân nặng mới (Nhập 0 nếu không muốn thay đổi):");
        double newWeight = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập giá tiền mới (Nhập 0 nếu không muốn thay đổi):");
        double newPrice = Double.parseDouble(sc.nextLine());
        if(!newName.isEmpty()){
            laptopToUpdate.setLaptopName(newName);
        }
        if(!newDescription.isEmpty()){
            laptopToUpdate.setDecription(newDescription);
        }
        if(newRam!=0){
            laptopToUpdate.setRam(newRam);
        }
        if(newWeight!=0){
            laptopToUpdate.setWeight(newWeight);
        }
        if(newPrice!=0){
            laptopToUpdate.setLaptopPrice(newPrice);
        }
        System.out.println("Cập nhật thông tin laptop thành công!");
    }
    //Xoá loại laptop
    private static void deleteLaptop(Scanner sc){
        String laptopIdRegex = "[L\\d{4}]";
        System.out.println("Nhập mã laptop cần cập nhật (định dạng L**** - * là các ký tự số): ");
        String laptopId;
        do {
            laptopId = sc.nextLine();
            if(!Pattern.matches(laptopIdRegex,laptopId)){
                System.out.println("Mã laptop không đúng định dạng, Vui lòng nhập lại: ");
            }else break;
        }while (true);

        Laptop laptopToDelete = null;
        for (Laptop laptop : laptops){
            if(laptop.getLaptopId()== laptopId){
                laptopToDelete = laptop ;
                break;
            }
        }
        if (laptopToDelete==null){
            System.err.println("Không tìm thấy laptop!");
            return;
        }
        laptopToDelete.setDeleted(false);
        System.out.println("Xoá loại laptop thành công!");
    }

    private static void statisticalLaptop(){

    }
}
