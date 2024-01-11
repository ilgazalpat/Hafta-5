import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        List<String> brandNames = new ArrayList<>(Arrays.asList("samsung","lenovo","apple",
                "huawei","casper","asus","hp","xioami","monster"));
        List<MobilePhone> phones = addPhones();
        List<Notebook> notebooks = addNotebook();
        int choose;
        boolean duration = true;
        while (duration){
            System.out.println("\n 0. Çıkış Yap" +"\n 1. Notebook İşlemleri" + "\n 2. Cep Telefonu İşlemleri" +
                    "\n 3. Marka Listele" + "\n 4. Ürün Ekle");
            System.out.print("Tercihinizi giriniz : ");
            choose = input.nextInt();
            switch (choose){
                case 0: {
                    duration = false;
                    break;
                }
                case 1: {
                    listedNotebook(notebooks);
                    break;
                }
                case 2: {
                    listedPhone(phones);
                    break;
                }
                case 3: {
                    listBrands(brandNames);
                    break;
                }
                case 4: {
                    addProduct(brandNames,phones,notebooks);
                    break;
                }
                default:{
                    System.out.println("Yeni bir tercih yapınız");
                }
            }
        }

    }
    private static List<MobilePhone> addPhones(){
        List<MobilePhone> phones = new ArrayList<>();
        phones.add(new MobilePhone("Samsung","GALAXY A51",3199.0,0,
                20,128,6.5,6,"Siyah"));
        phones.add(new MobilePhone("Apple","iPhone 11",7379.0,0,
                30,64,6.1,6,"Mavi"));
        phones.add(new MobilePhone("Xioami","Mi 14 pro",4012.0,0,
                50,128,6.5,12,"Beyaz"));
        return phones;
    }

    private static List<Notebook> addNotebook(){
        List<Notebook> notebooks = new ArrayList<>();
        notebooks.add(new Notebook("Huawei","Matebook 14",7000,
                15,55,512,14.0,16));
        notebooks.add(new Notebook("Lenova","V14 IGL",3699,
                10,30,1024,14.0,8));
        notebooks.add(new Notebook("Asus","Tut Gaming",8199.5,
                0,58,2048,15.6,32));
        return notebooks;
    }
    private static void listBrands(List<String> brandName){
        List<Brand> brands = new ArrayList<>();
        for (int i = 0 ; i < brandName.toArray().length ; i++){
            brands.add(new Brand(brandName.get(i)));
        }
        Collections.sort(brands);
        for (Brand b : brands){
            System.out.println("-" + b.getName().toUpperCase());
        }
    }
    private static void listedPhone(List<MobilePhone> phones) {
        System.out.format("%-5s %-8s %-25s %-14s %-10s %-10s %-10s %-10s%n", "|ID|", "|Brand|", "|Descp|", "|Price|", "|Memory|", "|Ram|", "|Size|", "|Colour|");
        System.out.println("---------------------------------------------------------------------------------------------------");
        for (MobilePhone p : phones) {
            System.out.format("%-5s %-8s %-25s %-14s %-10s %-10s %-10s %-10s%n", p.getId(), p.getBrand(), p.getDescription(), p.getUnitPrice() + " TL", p.getMemory() + " GB", p.getRam() + " GB", p.getSize() + "`", p.getColour());
        }
    }

    private static void listedNotebook(List<Notebook> notebooks){
        System.out.format("%-5s %-8s %-25s %-14s %-10s %-10s %-10s%n", "|ID|", "|Brand|", "|Descp|", "|Price|", "|Memory|", "|Ram|", "|Size|");
        System.out.println("---------------------------------------------------------------------------------------------------");
        for (Notebook n : notebooks){
            System.out.format("%-5s %-8s %-25s %-14s %-10s %-10s %-10s%n", n.getId(), n.getBrand(), n.getDescription(), n.getUnitPrice() + " TL", n.getMemory() + " GB", n.getRam() + " GB", n.getSize() + "`");
        }
    }
    public static void addProduct(List<String> brandNames, List<MobilePhone> phones, List<Notebook> notebooks ){


        System.out.print("Lütfen eklemek istediğiniz ürün türünü seçiniz \n 1. Cep Telefonu \n 2. Notebook \nTercihiniz : ");
        List<String> values = new ArrayList<>();
        int choose = input.nextInt();
        switch (choose){
            case 1: {
                String[] brands = new String[]{"Marka", "Model", "Fiyat", "İndirim", "Stok", "Hafıza", "Boyut", "Pil", "Ram", "Renk"};
                for (String brand : brands) {
                    System.out.print(brand + " : ");
                    String value = input.next();
                    while (brand.equals("Brand") && !brandNames.contains(value.toLowerCase())) {
                        System.out.print(brand + " -> tekrar girin : ");
                        value = input.next();
                    }
                    values.add(value);
                }
                phones.add(new MobilePhone(values.get(0).toUpperCase(), values.get(1).toUpperCase(),
                        Double.parseDouble(values.get(2)), Double.parseDouble(values.get(3)),
                        Integer.parseInt(values.get(4)), Integer.parseInt(values.get(5)),
                        Double.parseDouble(values.get(6)), Integer.parseInt(values.get(7)), values.get(9)));
                break;
            }
            case 2: {
                String[] brands = new String[]{"Marka", "Model", "Fiyat", "İndirim", "Stok", "Hafıza", "Boyut", "Ram"};
                for (String brand : brands){
                    System.out.println(brand + " : ");
                    String value = input.next();
                    while (brand.equals("Brand") && !brandNames.contains(value.toLowerCase())){
                        System.out.print(brand + " -> tekrar giriniz : ");
                        value = input.next();
                    }
                    values.add(value);
                }
                notebooks.add(new Notebook(values.get(0).toUpperCase(),values.get(1).toUpperCase(),
                        Double.parseDouble(values.get(2)),Double.parseDouble(values.get(3)),
                        Integer.parseInt(values.get(4)), Integer.parseInt(values.get(5)),
                        Double.parseDouble(values.get(6)),Integer.parseInt(values.get(7))));
            }
        }
    }
}