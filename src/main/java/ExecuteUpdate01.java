import java.sql.*;

public class ExecuteUpdate01 {
    public static void main(String[] args) throws SQLException {

        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","dev_user","password");
        Statement st=connection.createStatement();
        //executeUpdate:DML icin kullanilir:Datalari INSERT,UPDATE,DELETE
        //return:sorgudan etkilenen kayit sayisini dondurur.

        //ÖRNEK1:developers tablosunda maaşı ortalama maaştan az olanların maaşını 5111 olarak güncelleyiniz,
//        String query="UPDATE developers SET salary=5111 WHERE salary<(SELECT AVG(salary) FROM developers)";
//        int updated=st.executeUpdate(query);
//        System.out.println("Guncellenen kayit sayisi: "+updated);

        ResultSet resultSet=st.executeQuery("SELECT name,salary FROM developers");

        while (resultSet.next()){
            System.out.println(resultSet.getString("name")+"---"+resultSet.getDouble("salary"));
        }
        System.out.println();
        //ÖRNEK2:developers tablosuna yeni bir developer ekleyiniz.
        String query2="INSERT INTO developers(name,salary,prog_lang) VALUES('Omer',7000,'Phyton')";
        int inserted=st.executeUpdate(query2);
        System.out.println("eklenend kayit sayisi = " + inserted);

        ResultSet resultSet2=st.executeQuery("SELECT name,salary FROM developers");
        while (resultSet2.next()){
            System.out.println(resultSet2.getString("name")+"---"+resultSet2.getDouble("salary"));
        }

        //ORNEK3: developers tablosundan is'si 11 olani siliniz.
        String query3="DELETE FROM developers WHERE id=11";
        int deleted=st.executeUpdate(query3);
        System.out.println("deleted = " + deleted);

        st.close();
        connection.close();

        System.out.println("-------------ÖDEVV---------------");
        //1-Bölüm isimlerini, kampüslerini ve
        //her bir bölümde okuyan öğrencilerin en yüksek puanlarını listeleyiniz.
        //2-developers tablosundan prog_lang css olanları siliniz.
        //3-developers tablosundan prog_lang java olanları siliniz.


    }
}
