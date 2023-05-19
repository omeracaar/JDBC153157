import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1-ADIM:driver'i kaydet
        Class.forName("org.postgresql.Driver");

        //2-ADIM:Database e baglanma
        Connection connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","dev_user","password");

        //3-ADIM:statment olusturulmasi:sorgularin DB ye iletilmesi ve calistirilmasi icin
        Statement st=connection.createStatement();

        System.out.println("Connection succes");

        //4-ADIM Sorgu olusturma/calistirma

        //ORNEK 1:"workers" adinda bir tablo olusturup "worjer_id,worker_name,salary" sutunlarini ekleyiniz.
 //       boolean sql1=st.execute("CREATE TABLE workers(workers_id INT, workers_name VARCHAR(50), salary REAL)");
 //       System.out.println("sql1:"+sql1);
        //CREATE TABLE IF NOT EXISTS: boyle bir tablo varsa elleme yoksa olustur

        //execute methodu boolen bir deger dondurur
        //DQL icin kullanilirsa: ResultSet alir,geriye TRUE olarak doner.
        //DDL icin kullanilirsa: ResultSet almadigi icin FALSE olarak doner.

        //ORNEK 2:"workers" tablosuna VARCHAR(20) tipinde "city" sutununu ekleyiniz.
//        boolean sql2=st.execute("ALTER TABLE workers ADD COLUMN city VARCHAR(20)");
//        System.out.println("sql2 = " + sql2);

        //ORNEK 3:"workers" tablosunu SCHEMAdan siliniz.
        String query="DROP TABLE IF EXISTS workers";
        st.execute(query);


        //5-ADIM:baglantiyi ve statement kapatma
        connection.close();
        st.close();







    }
}
