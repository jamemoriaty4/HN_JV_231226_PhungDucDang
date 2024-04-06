package business;

import business.util.IOFile;
import business.util.InputMethods;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Product implements IProduct, Serializable {
    private static List<Product> products = new ArrayList<>() ;


    private int productID;
    private String productName, title, descriptions;
    private float importPrice, exportPrice, interest;
    private boolean productStatus;

    public Product() {
    }

    public Product(int productID, String productName, String title, String descriptions, float importPrice, float exportPrice, float interest, boolean productStatus) {
        this.productID = productID;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.productStatus = productStatus;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {

        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }


    @Override
    public void inputData() {

        System.out.println("nhap Id cho san pham");
        this.productID = InputMethods.getInteger();
        System.out.println("nhap ten san pham");
        this.productName = InputMethods.getString();
        System.out.println("nhap tieu de san pham");
        this.title = InputMethods.getString();
        System.out.println("nhap mieu ta cho san pham");
        this.descriptions = InputMethods.getString();
        System.out.println("nhap gia nhap khau ");
        this.importPrice = InputMethods.getFloat();
        while (importPrice < 0) {
            System.out.println("nhap lai gia nhap khau ");
            this.importPrice = InputMethods.getFloat();
        }
        System.out.println("nhap gia ban ");
        this.exportPrice = InputMethods.getFloat();

        System.out.println("nhap trang thai cua san pham");
        this.productStatus = InputMethods.getBoolean();

this.interest = exportPrice-importPrice;
    }

    @Override
    public void displayData() {
        System.out.printf("|ID: %-4s | Name: %-15s | Title: %-10s | Decrip: %-15s | IMP: %-9s| EXP: %-9s |Interest: %-9s| Status: %-7s | \n", productID, productName, title, descriptions, importPrice, exportPrice, interest, productStatus ? "hoat dong" : "khong hd");
    }

    public void addNewProduct(Product product) {
        products.add(product);

    }

    public List<Product> findAll() {
        return products;
    }

    public List<Product> sortByName1() {
        return products.stream().sorted(Comparator.comparing(Product::getProductName)).toList();
    }

    public List<Product> sortByName2() {
        return products.stream().sorted((o1, o2) -> o2.getProductName().compareTo(o1.getProductName())).toList();
    }

    public List<Product> sortByExportPrice1() {
        return products.stream().sorted(Comparator.comparing(Product::getExportPrice)).toList();
    }

    public List<Product> sortByExportPrice2() {
        return products.stream().sorted(Comparator.comparingDouble(Product::getExportPrice)).toList();
    }

    public List<Product> sortByInterest1() {
        return products.stream().sorted(Comparator.comparing(Product::getInterest)).toList();
    }

    public List<Product> sortByInterest2() {
        return products.stream().sorted(Comparator.comparingDouble(Product::getInterest)).toList();
    }

    public Product findByID(int id) {
        return products.stream().filter(p -> p.getProductID() == id).findFirst().orElse(null);
    }

    public void deleteProductById(int id) {
        products.remove(findByID(id));

    }

    public Product findByName(String name) {
        return products.stream().filter(p -> Objects.equals(p.getProductName(), name)).findFirst().orElse(null);
    }


    public void updateStatusById(Product product) {
        if (product.isProductStatus()) {
            product.setProductStatus(false);
        } else {
            product.setProductStatus(true);
        }

    }
}
