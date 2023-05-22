package DataBase;

import java.sql.*;

public class JDBClass {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc";

        String username = "root";
        String password = "";

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,username,password);

            Statement stmt=con.createStatement();

            ResultSet resultSet = stmt.executeQuery("select * from carte_adolescenti");

            while(resultSet.next()){
                System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getInt(5) + " " + resultSet.getInt(6)+ " " + resultSet.getBoolean(7)+ " " + resultSet.getBoolean(8)+ " " + resultSet.getBoolean(9)+ " " + resultSet.getBoolean(10)+ " " + resultSet.getBoolean(11));

            }

            //CRUD pe tabela carte_adolescenti

            //Create

            stmt.executeUpdate("insert into carte_adolescenti values(106,'Twilight','Stephenie Meyer','CARTONATA',300,2005,false,true,true,true,true)");

            System.out.println(" ");
            //Read

            resultSet = stmt.executeQuery("select * from carte_adolescenti");

            while(resultSet.next()){
                System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getInt(5) + " " + resultSet.getInt(6)+ " " + resultSet.getBoolean(7)+ " " + resultSet.getBoolean(8)+ " " + resultSet.getBoolean(9)+ " " + resultSet.getBoolean(10)+ " " + resultSet.getBoolean(11));

            }

            //Update

            stmt.executeUpdate("update carte_adolescenti set titlu = 'Twilight 2' where id = 106");

            System.out.println(" ");

            //Read

            resultSet = stmt.executeQuery("select * from carte_adolescenti");

            while(resultSet.next()){
                System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getInt(5) + " " + resultSet.getInt(6)+ " " + resultSet.getBoolean(7)+ " " + resultSet.getBoolean(8)+ " " + resultSet.getBoolean(9)+ " " + resultSet.getBoolean(10)+ " " + resultSet.getBoolean(11));

            }

            //Delete

            stmt.executeUpdate("delete from carte_adolescenti where id = 106");

            System.out.println(" ");

            //Read

            resultSet = stmt.executeQuery("select * from carte_adolescenti");

            while(resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4) + " " + resultSet.getInt(5) + " " + resultSet.getInt(6) + " " + resultSet.getBoolean(7) + " " + resultSet.getBoolean(8) + " " + resultSet.getBoolean(9) + " " + resultSet.getBoolean(10) + " " + resultSet.getBoolean(11));

            }
            //CRUD pe tabela carte_adulti

            //Create

            stmt.executeUpdate("insert into carte_adulti values(107,'The Notebook','Stephenie Meyer','CARTONATA',300,2005,false,'FANTASY',true)");

            System.out.println(" ");

            //Read

            resultSet = stmt.executeQuery("select * from carte_adulti");

            while(resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4) + " " + resultSet.getInt(5) + " " + resultSet.getInt(6) + " " + resultSet.getBoolean(7) + " " + resultSet.getString(8) + " " + resultSet.getBoolean(9));
            }

            System.out.println(" ");

            //Update

            stmt.executeUpdate("update carte_adulti set titlu = 'The Notebook 2' where id = 107");

            //Read

            resultSet = stmt.executeQuery("select * from carte_adulti");

            while(resultSet.next()){
                System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getInt(5) + " " + resultSet.getInt(6)+ " " + resultSet.getBoolean(7)+ " " + resultSet.getString(8)+ " " + resultSet.getBoolean(9));

            }

            System.out.println(" ");

            //Delete

            stmt.executeUpdate("delete from carte_adulti where id = 0");
            stmt.executeUpdate("delete from carte_adulti where id = 107");

            System.out.println(" ");

            //Read

            resultSet = stmt.executeQuery("select * from carte_adulti");

            while(resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4) + " " + resultSet.getInt(5) + " " + resultSet.getInt(6) + " " + resultSet.getBoolean(7) + " " + resultSet.getString(8) + " " + resultSet.getBoolean(9));
            }

            //CRUD pe tabela carte_copii

            //Create

            stmt.executeUpdate("insert into carte_copii values(108,'Catelusul','Maria Farago','CARTONATA',30,2005,false,'4-7 ani',false)");

            System.out.println(" ");

            //Read

            resultSet = stmt.executeQuery("select * from carte_copii");

            while(resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4) + " " + resultSet.getInt(5) + " " + resultSet.getInt(6) + " " + resultSet.getBoolean(7) + " " + resultSet.getString(8) + " " + resultSet.getBoolean(9));
            }

            System.out.println(" ");

            //Update

            stmt.executeUpdate("update carte_copii set titlu = 'Catelusul 2' where id = 108");

            //Read

            resultSet = stmt.executeQuery("select * from carte_copii");

            while(resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4) + " " + resultSet.getInt(5) + " " + resultSet.getInt(6) + " " + resultSet.getBoolean(7) + " " + resultSet.getString(8) + " " + resultSet.getBoolean(9));
            }

            System.out.println(" ");

            //Delete

            stmt.executeUpdate("delete from carte_copii where id = 108");

            System.out.println(" ");

            //Read

            resultSet = stmt.executeQuery("select * from carte_copii");

            while(resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4) + " " + resultSet.getInt(5) + " " + resultSet.getInt(6) + " " + resultSet.getBoolean(7) + " " + resultSet.getString(8) + " " + resultSet.getBoolean(9));
            }

            //CRUD pe tabela bibliotecar

            //Create

            stmt.executeUpdate("insert into bibliotecar values('Maria','Popescu', 45, 10,true, true)");

            System.out.println(" ");

            //Read

            resultSet = stmt.executeQuery("select * from bibliotecar");

            while(resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3) + " " + resultSet.getInt(4) + " " + resultSet.getBoolean(5) + " " + resultSet.getBoolean(6));
            }

            System.out.println(" ");

            //Update

            stmt.executeUpdate("update bibliotecar set nume = 'Mariana' where nume = 'Maria'");

            //Read

            resultSet = stmt.executeQuery("select * from bibliotecar");

            while(resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3) + " " + resultSet.getInt(4) + " " + resultSet.getBoolean(5) + " " + resultSet.getBoolean(6));
            }

            System.out.println(" ");

            //Delete

            stmt.executeUpdate("delete from bibliotecar where nume = 'Mariana'");

            System.out.println(" ");

            //Read

            resultSet = stmt.executeQuery("select * from bibliotecar");

            while(resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3) + " " + resultSet.getInt(4) + " " + resultSet.getBoolean(5) + " " + resultSet.getBoolean(6));
            }

            //CRUD pe tabela paznic

            //Create

            stmt.executeUpdate("insert into paznic values('Ion','Popescu', 45, 10,'PRIMA')");

            System.out.println(" ");

            //Read

            resultSet = stmt.executeQuery("select * from paznic");

            while(resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3) + " " + resultSet.getInt(4) + " " + resultSet.getString(5));
            }

            System.out.println(" ");

            //Update

            stmt.executeUpdate("update paznic set nume = 'Marian' where nume = 'Ion'");

            //Read

            resultSet = stmt.executeQuery("select * from paznic");

            while(resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3) + " " + resultSet.getInt(4) + " " + resultSet.getString(5));
            }

            System.out.println(" ");

            //Delete

            stmt.executeUpdate("delete from paznic where nume = 'Marian'");

            System.out.println(" ");

            //Read

            resultSet = stmt.executeQuery("select * from paznic");

            while(resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3) + " " + resultSet.getInt(4) + " " + resultSet.getString(5));
            }




            con.close();

        }
        catch (Exception e) {
           System.out.println(e);
        }
    }
}
