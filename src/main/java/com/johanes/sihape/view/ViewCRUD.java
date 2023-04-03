/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.johanes.sihape.view;

import com.johanes.sihape.controller.ProductDAOImp;
import com.johanes.sihape.model.Product;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author acer
 */
public class ViewCRUD {
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader); 
    static Scanner inputUser = new Scanner(System.in);   

    public static void showMenu() {
        System.out.println("\n========= MENU UTAMA SI PRODUK HP =========");
        System.out.println("1. Tampilkan Produk");
        System.out.println("2. Search Produk Berdasarkan ID Produk");
        System.out.println("3. Insert Produk");
        System.out.println("4. Update Produk");
        System.out.println("5. Delete Produk");
        System.out.println("0. Keluar");
        System.out.println("");
        System.out.print("PILIHAN> ");

        try {
            int pilihan = Integer.parseInt(input.readLine());

            switch (pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    showProduct();
                    break;
                case 2:
                    searchProduct();
                    break;
                case 3:
                    insertProduct();
                    break;
                case 4:
                    updateProduct();
                    break;
                case 5:
                    deleteProduct();
                    break;
                default:
                    System.out.println("Pilihan salah!");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void showProduct() {
        try {
            ProductDAOImp productDAO = new ProductDAOImp();
            List<Product> listProduct = productDAO.list();
            
            // Show
            System.out.println("\n+-----------------------------------------------------------------------------+");
            System.out.println("|                              DATA PRODUK HP                                   |");
            System.out.println("+-------------------------------------------------------------------------------+");
            System.out.println("+-------------------------------------------------------------------------------+");
            System.out.println("|  ID Produk  |  Kategori Produk  |  Nama Produk  |  Harga (Rp.)  |  Kuantitas  |");
            System.out.println("+-------------------------------------------------------------------------------+");

            for(Product product: listProduct)
            {
                int productId = product.getProductId();
                String productCategory = product.getProductCategory();
                String productName = product.getProductName();
                double price = product.getPrice();
                int qty = product.getQty();
                System.out.println(String.format("|  %d  | %s | %s | %.2f | %d  |", productId, productCategory, productName, price, qty));
            }    

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void searchProduct() {
        try {        
            // Ambil input dari user
            System.out.println("\n========= SEARCH PRODUK =========");
            System.out.println("ID Produk yang mau dicari: ");
            int productId = Integer.parseInt(input.readLine());

            // Search
            ProductDAOImp dao = new ProductDAOImp();
            Product productDAO = dao.getProduct(productId);
            int getProductId = productDAO.getProductId();
            String productCategory = productDAO.getProductCategory();
            String productName = productDAO.getProductName();
            double price = productDAO.getPrice();
            int qty = productDAO.getQty();

            System.out.println(String.format("ID Produk : %d ", getProductId));
            System.out.println(String.format("Kategori Produk : %s ", productCategory));
            System.out.println(String.format("Nama Produk : %s ", productName));
            System.out.println(String.format("Harga (Rp.): %.2f ", price));
            System.out.println(String.format("Kuantitas : %d ", qty));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void insertProduct() {
        try {
            // Ambil input dari user
            System.out.println("\n========= INSERT PRODUK =========");
            System.out.println("Kategori Produk : ");
            String productCategory = input.readLine().trim();
            System.out.println("Nama Produk : ");
            String productName = input.readLine().trim();
            System.out.println("Harga (Rp.) : ");
            double price = inputUser.nextDouble();
            System.out.println("Kuantitas : ");
            int qty = inputUser.nextInt();
 
            // Insert
            Product product = new Product();
            product.setProductCategory(productCategory);
            product.setProductName(productName);
            product.setPrice(price);
            product.setQty(qty);
        
            ProductDAOImp dao = new ProductDAOImp();
            dao.insert(product);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void updateProduct() {
        try {
            // Ambil input dari user
            System.out.println("\n========= UPDATE PRODUK =========");
            System.out.println("ID Produk  yang mau diupdate: ");
            int productId = Integer.parseInt(input.readLine());
            System.out.println("Kategori Produk : ");
            String productCategory = input.readLine().trim();
            System.out.println("Nama Produk : ");
            String productName = input.readLine().trim();
            System.out.println("Harga (Rp.) : ");
            double price = inputUser.nextDouble();
            System.out.println("Kuantitas : ");
            int qty = inputUser.nextInt();
 
            // Update
            Product product = new Product();
            product.setProductCategory(productCategory);
            product.setProductName(productName);
            product.setPrice(price);
            product.setQty(qty);
            product.setProductId(productId);
        
            ProductDAOImp dao = new ProductDAOImp();
            dao.update(product);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void deleteProduct() {
        try {
            // Ambil input dari user
            System.out.println("\n========= DELETE PRODUK =========");
            System.out.println("ID Produk yang mau didelete: ");
            int productId = Integer.parseInt(input.readLine());

            // Delete
            Product product = new Product();
            product.setProductId(productId);
            ProductDAOImp dao = new ProductDAOImp();
            dao.delete(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
}
