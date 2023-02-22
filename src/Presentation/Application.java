package Presentation;

import java.sql.*;

public class Application {

    public static void main(String[] args) {


        //charger le pilote JDBC pour MYSQL
        try {

            Class.forName("com.mysql.jdbc.Driver");
            //Etablir la connexion avec la base donnée
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/GestionProduits","root","root");
            Statement stm  = connection.createStatement();
            ResultSet rs =stm.executeQuery("select * from ProduitS");
             ResultSetMetaData rsmd = rs.getMetaData();
            /*while(rs.next()){
                System.out.println(rs.getInt("ID")+"  "+rs.getString("Nom")+"  "+rs.getString("Description")+"  "+rs.getFloat("Prix")
                        +"  "+rs.getInt("Quantité"));
            }*/

            for (int i=1 ; i<= rsmd.getColumnCount() ; i++){
                System.out.print(rsmd.getColumnName(i)+ "   ");
            }
            System.out.println();

            while (rs.next()){
                for (int i=1 ; i<= rsmd.getColumnCount() ; i++){
                    System.out.print(rs.getString((rsmd.getColumnName(i)))+ "   ");
                }
                System.out.println();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }




}
