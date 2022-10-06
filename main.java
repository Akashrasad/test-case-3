package com.java.main;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;  
import java.util.List;  
import java.util.Scanner;  

 
class Product   
    {  
        
         String id;  
         String pname;  
         int qty;  
         double price;  
        double totalPrice;  
           
       
        Product(String id, String pname, int qty, double price, double totalPrice)   
        {  
            this.id=id;  
            this.pname = pname;  
            this.qty = qty;  
            this.price = price;  
            this.totalPrice = totalPrice;  
        }  
            
            public String getId()   
                {  
                    return id;  
                }  
                public String getPname()   
                {  
                    return pname;  
                }  
                public int getQty()   
                {  
                    return qty;  
                }  
                public double getPrice()   
                {  
                    return price;  
                }  
                public double getTotalPrice()   
                {  
                    return totalPrice;  
                }  
                 
                public static void displayFormat()   
                {  
                    System.out.println("\n     Welcome to Mart shopping");
                    System.out.print("\nProduct ID \t\tName\t\tQuantity\t\tRate \t\t\t\tTotal Price\n");  
                     
                }  
                    
                public void display()   
                {  
                    System.out.format("   %-9s             %-9s      %5d               %9.2f                       %14.2f\n" ,id, pname, qty, price, totalPrice);  
                }  
    }  
public class main  
    {  
        public static void main(String args[])   
            {  
           
                String id = null;  
                String productName = null;  
                int quantity = 0;  
                double price = 0.0;  
                double totalPrice = 0.0;  
                double overAllPrice = 0.0;  
                double subtotal=0.0;  
                char choice = '\0';  
                int [] rate;
                int [] [] markets;
                markets=new int [2][2];
                System.out.println("V-Mart Shopping");
                markets[0][0]=101;
                System.out.println("101 washing machine");
                markets[0][1]=102;
                System.out.println("102 Ac ");
                markets[1][0]=103;
                System.out.println("103 mobile");
                markets[1][1]=104;
                System.out.println("104 computer");
              //  System.out.println("v mart");
                for(int i=0; i<markets.length;i++) {
                	for (int j=0; j<markets[i].length;j++) {
                		System.out.println(markets[i][j]);
                		System.out.println(" ");
                	}
                	System.out.println(" ");
                }
                
                
                Scanner scan = new Scanner(System.in);  
                
              
                System.out.print("Enter Customer Name: ");  
                String customername=scan.nextLine();  
              
                List<Product> product = new ArrayList<Product>();  
                do   
                    {  
                        
                        System.out.println("Enter the product details: ");  
                        System.out.print("Product ID: ");  
                        id = scan.nextLine();  
                        System.out.print("Product Name: ");  
                        productName = scan.nextLine();  
                        System.out.print("Quantity: ");  
                        quantity = scan.nextInt();  
                        System.out.print("Price of the product: ");  
                        price = scan.nextDouble();  
                        
                        totalPrice = price * quantity;  
                      
                        overAllPrice = overAllPrice + totalPrice;  
                       
                        product.add( new Product(id, productName, quantity, price, totalPrice) );  
                       
                        System.out.print("Want to add more items? (y or n): ");  
                       
                        choice = scan.next().charAt(0);  
                        
                        scan.nextLine();  
                    }   
                while (choice == 'y' || choice == 'Y');  
               
                Product.displayFormat();  
                for (Product p : product)   
                {  
                    p.display();  
                }  
                
                int total[]=new int[6];
        		String name[]=new String[6];
        		int i=0;
        		try
        		{
        			Class.forName("com.mysql.cj.jdbc.Driver");
        			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/product_info","root","root");
        			Statement statment=connection.createStatement();
        		ResultSet rs=statment.executeQuery("select * from product_info.cashier");
        		while(rs.next())
        		{
        			name[i]=rs.getString(2);
        			total[i]=rs.getInt(3)+rs.getInt(4)+rs.getInt(5);
        			System.out.println(rs.getInt(1)+rs.getInt(3)+rs.getInt(3)+rs.getInt(4)+rs.getInt(5));
        		}
        		}catch (Exception e) {
					// TODO: handle exception
				}

                System.out.println("Total Amount (Rs.) " +overAllPrice);  
                
               
                
                System.out.println("Subtotal "+subtotal);  
               
                
                System.out.println("Invoice Total " +(subtotal));  
                System.out.println("Thank You for Shopping!!");  
                System.out.println("Visit Again :-)");  
                
                scan.close();  
            }     
    }  