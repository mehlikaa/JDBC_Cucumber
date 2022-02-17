

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
    public class Jdbc1Query01_bilgi {
        public static void main(String[] args) throws ClassNotFoundException, SQLException {
            // 1) ilgili driver'i yuklemeliyiz. tv nin fisini tak, mesela baska alet
            // calismasin, ne calisacagini bilsin
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2) baglanti olusturmaliyiz uydu sifrelerini girmeliyiz
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root",
                    "1234");
            // 3) SQL komutlari icin bir statement nesnesi olustur her kanal icin kumanda da
            // yer ayarlamak
            Statement st = con.createStatement();
            // SQL ifadeleri yazabilir ve calistirabiliriz kumanda da 1 e basarim trt1 gelir
            ResultSet veri = st.executeQuery("SELECT isim, maas FROM personel WHERE id=123456789");
            // 5) sonuclari aldik ve isledik
            while (veri.next()) {
                System.out.println(veri.getString("isim") + veri.getInt("maas"));
                System.out.println("Personel Adi:" + veri.getString(1) + "Maas:" + veri.getInt(2));
            }
            // 6) olusturulan nesneleri bellekten kaldiralim
            con.close();
            st.close();
            veri.close();
        }
    }

