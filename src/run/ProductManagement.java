package run;

import business.IProduct;
import business.Product;
import business.util.InputMethods;

import java.util.List;

public class ProductManagement {

    private static final Product designProduct = new Product();

    public static void main(String[] args) {
        while (true) {
            System.out.println("""
                    ****************PRODUCT-MANAGER-MENU***************
                    1. Nhập số sản phẩm và nhập thông tin sản phẩm [15 điểm]
                    2. Hiển thị thông tin các sản phẩm [15 điểm]
                    3. Sắp xếp sản phẩm [15 điểm]
                    4. Xóa sản phẩm theo mã sản phẩm [10 điểm]
                    5. Tìm kiếm sản phẩm theo tên sản phẩm [10 điểm]
                    6. Thay đổi trạng thái của sản phẩm theo mã sản phẩm [10 điểm]
                    7. Thoát [05 điểm]
                    """);

            System.out.println("nhap vao lua chon cua ban");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:addNewProduct();
                    break;
                case 2:displayAll();
                    break;
                case 3:sort();
                    break;
                case 4:deleteByID();
                    break;
                case 5:findByName();
                    break;
                case 6:updateStatus();
                    break;
                case 7:
                    break;
                default:
                    System.err.println("Moi ban nhap dung theo yeu cau");
            }
            if (choice == 7) {
                return;
            }
        }
    }

    protected static void addNewProduct() {

        System.out.println("nhap vao so san pham can them");
        int count = InputMethods.getInteger();
        for (int i = 0; i < count; i++) {
            System.out.println("nhap thong tin cho san pham thu " + (i + 1));
            Product product = new Product();
            product.inputData();
            designProduct.addNewProduct(product);
        }
        System.out.println("da them thanh cong");

    }

    protected static void displayAll() {
        List<Product> list = designProduct.findAll();
        if (list.isEmpty()) {
            System.err.println("danh sách trống");
        } else {
            System.out.println("danh sách sản phẩm");
            list.forEach(Product::displayData);
        }
    }

    protected static void sort() {
        System.out.println("nhap lua chon ban muon sap xep");
        System.out.println("1.Tên (Tăng)");
        System.out.println("2.Tên (giam)");
        System.out.println("3.gia (Tăng)");
        System.out.println("4.gia (Giam)");
        System.out.println("5.Lai (Tăng)");
        System.out.println("6.Lai (giam)");
        byte choice = InputMethods.getByte();
        switch (choice) {
            case 1:
                List<Product> list1 = designProduct.sortByName1();
                list1.forEach(Product::displayData);
                break;
            case 2:
                List<Product> list2 = designProduct.sortByName2();
                list2.forEach(Product::displayData);
                break;
            case 3:
                List<Product> list3 = designProduct.sortByExportPrice1();
                list3.forEach(Product::displayData);
                break;
            case 4:
                List<Product> list4 = designProduct.sortByExportPrice2();
                list4.forEach(Product::displayData);
                break;
            case 5:
                List<Product> list5 = designProduct.sortByInterest1();
                list5.forEach(Product::displayData);
                break;
            case 6:
                List<Product> list6 = designProduct.sortByInterest2();
                list6.forEach(Product::displayData);
                break;

            default:
                System.err.println("ket qua k hop le");
                break;
        }

    }

    protected static void deleteByID(){
        System.out.println("nhap vao id can tim");
        int id = InputMethods.getInteger();
        Product product= designProduct.findByID(id);
        if(product==null){
            System.err.println("khong tim thay san pham");
        }else{
            product.deleteProductById(id);
            System.out.println("xoa thanh cong");
        }
    }

    protected static void findByName(){
        System.out.println("nhap vao ten can tim");
        String name =InputMethods.getString();
        Product product= designProduct.findByName(name);
        if(product==null){
            System.err.println("khong tim thay san pham");
        }else{
            product.displayData();
        }
    }

    protected static void updateStatus(){
        System.out.println("nhap vao id can thay doi trang thai");
        int id = InputMethods.getInteger();
        Product product= designProduct.findByID(id);
        if(product==null){
            System.err.println("khong tim thay san pham");
        }else{
            product.updateStatusById(product);
            System.out.println("cap nhat thanh cong");
        }
    }
}
