package obs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.Gson;

public class dao2 {

    static Connection connection;
    private Gson gson = null;

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "12345");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }


    public String getirTumListe() {
        List<Ogrenciler> hepsi = new ArrayList();

        JsonObject jsonObject = new JsonObject();

        try {
            Connection connection = getConnection();
            Connection connection1 = getConnection();
            Connection connection2 = getConnection();
            Statement st = null;
            Statement st1;
            Statement st2;
            gson = new GsonBuilder().create();
            st = connection.createStatement();
            st1 = connection1.createStatement();
            st2 = connection2.createStatement();
            String que = "SELECT * from ogrenciler";
            ResultSet rs = st.executeQuery(que);
            while (rs.next()) {
                Ogrenciler ogr = new Ogrenciler();
                ogr.setOgrİd(rs.getInt("ogrID"));

                ogr.setOgrAdi(rs.getString("ogrAdi"));
                ogr.setOgrCinsiyet(rs.getString("ogrCinsiyet"));
                String que1 = "SELECT * from dersialanogrenciler a join dersler d on d.dersID=a.dersID  where ogrID =" + rs.getInt("ogrID");
                ResultSet rs1 = st1.executeQuery(que1);
                ArrayList<Ders> dersList = new ArrayList<>();
                while (rs1.next()) {
                    Ders ders = new Ders();
                    ders.setId(rs1.getInt("dersID"));
                    ders.setName(rs1.getString("dersAdi"));
                    String que2 = "SELECT * FROM notlar n join dersler a on n.dersID=a.dersID where ogrID=" + rs.getInt("ogrID");
                    ResultSet rs2 = st2.executeQuery(que2);
                    ArrayList<Notlar> notlar = new ArrayList<>();
                    while (rs2.next()) {
                        Notlar not = new Notlar();
                        not.setVizeler(rs2.getDouble("vize"));
                        not.setFnal(rs2.getDouble("final"));
                        not.setOrt(rs2.getDouble("ort"));
                        notlar.add(not);
                        ders.setNotlar(notlar);
                        break;
                    }

                    dersList.add(ders);

                }
                ogr.setDersListesi(dersList);
                hepsi.add(ogr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JsonArray jarray = gson.toJsonTree(hepsi).getAsJsonArray();
        jsonObject = new JsonObject();
        jsonObject.add("hepsi", jarray);


        return jarray.toString();
    }


}

