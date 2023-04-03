/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.johanes.sihape.controller;

import com.johanes.sihape.DB.ConnectionDB;
import com.johanes.sihape.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class ProductDAOImp implements ProductDAO {
    @Override
    public void insert(Product product) {
        try {
            Connection conDB =  ConnectionDB.getConnection();
            String sql = "INSERT INTO product_hp (productCategory,productName,price,qty) VALUES (?,?,?,?)";
            PreparedStatement ps = conDB.prepareStatement(sql);
            ps.setString(1, product.getProductCategory());
            ps.setString(2, product.getProductName());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getQty());
            ps.executeUpdate();
            System.out.println("Data has been saved");
        }  
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cannot insert into table");
        }
    }   

    @Override
    public void update(Product product) {
        try {
            Connection conDB =  ConnectionDB.getConnection();
            String sql = "UPDATE product_hp SET productCategory =?, productName=?, price=?, qty=? WHERE productId=?";
            PreparedStatement ps = conDB.prepareStatement(sql);
            ps.setString(1, product.getProductCategory());
            ps.setString(2, product.getProductName());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getQty());
            ps.setInt(5, product.getProductId());
            ps.executeUpdate();
            System.out.println("Data has been update");
        }  
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cannot update into table");
        }
    }   

    @Override
    public void delete(Product product) {
        try {
            Connection conDB =  ConnectionDB.getConnection();
            String sql = "DELETE FROM product_hp WHERE productId=?";
            PreparedStatement ps = conDB.prepareStatement(sql);
            ps.setInt(1, product.getProductId());
            ps.executeUpdate();
            System.out.println("Data has been delete");
        }  
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cannot delete into table");
        }
    }   

    @Override
    public Product getProduct(int productId) {
        Product product = new Product();
        try {
            Connection conDB = ConnectionDB.getConnection();
            String sql = "SELECT * FROM product_hp WHERE productId=?";
            PreparedStatement ps = conDB.prepareStatement(sql);
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                product.setProductId(rs.getInt("productId"));
                product.setProductCategory(rs.getString("productCategory"));
                product.setProductName(rs.getString("productName"));
                product.setPrice(rs.getInt("price"));
                product.setQty(rs.getInt("qty"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cannot get data from table by using productId");
        }
        return product;
    }

    @Override
    public List<Product> list() {
      
        List<Product> listProduct = new ArrayList<Product>();

        try{
            Connection conDB = ConnectionDB.getConnection();
            String sql = "SELECT * FROM product_hp";
            PreparedStatement ps = conDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductCategory(rs.getString("productCategory"));
                product.setProductName(rs.getString("productName"));
                product.setPrice(rs.getInt("price"));
                product.setQty(rs.getInt("qty"));
 
                listProduct.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cannot get data from table");
        }
        return listProduct;
    }
}
