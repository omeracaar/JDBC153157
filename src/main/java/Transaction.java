import java.sql.*;

/*
Transaction:DB deki parcalanamaz(atomik) en kucuk islem
Birden fazla islem icin tek bir transaction olusturabiliriz.
Bu islemlerin tamami basarili bir sekilde gerceklesirse Transaction commit edilir
Bu islemlerin en az birinde problem olursa "rollback" ile transaction icindeki islemler iptal edilebilir.
 */
public class Transaction {
    public static void main(String[] args) throws Exception {
        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","dev_user","password");
        connection.setAutoCommit(false);

        try {


        //hesap no:1234 ten hesap no: 5678 e 1000$ para transferi olsun.
        String query="UPDATE hesaplar SET bakiye=bakiye+? WHERE hesap_no=?";

        PreparedStatement prepareStatement=connection.prepareStatement(query);

        prepareStatement.setDouble(1,-1000);
        prepareStatement.setInt(2,1234);
        prepareStatement.executeUpdate();

        //sistemsel hata olustu
        if (true){
            throw new Exception();//uygulama burada durur
        }

        prepareStatement.setDouble(1,1000);
        prepareStatement.setInt(2,5678);
        prepareStatement.executeUpdate();

        //islemler basarili ise
        connection.commit();
        prepareStatement.close();
        connection.close();
        }catch (Exception e){
            connection.rollback();
            System.out.println(e.getMessage());
        }

        //commit ten sonra rollback kullanilamaz



    }
}
