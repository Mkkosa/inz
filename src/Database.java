
import org.omg.PortableInterceptor.INACTIVE;

import javax.xml.datatype.Duration;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Database {
    private static Connection connect = null;
    private static Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;
    private static Date date = new Date();

    public Database() {
        if (connect()) {
            try {
                statement = connect.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Brak polaczenia z baza danych");
        }
    }

    public boolean connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/?" + "user=root&password=haslo-root-a");
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public static void deletePlace (int i){
        int count = 0;
        int id = 0;
        int error = 0;
        try {
            resultSet = statement.executeQuery("SELECT MAX(miejsce_id) FROM parking.miejsca_parkingowe");
            resultSet.next();
            id = resultSet.getInt("MAX(miejsce_id)");
            while (count<i) {
                resultSet = statement.executeQuery("SELECT * FROM parking.miejsca_parkingowe WHERE miejsce_id ="+ id +" ");
                resultSet.next();
                if (resultSet.getString(2) == null){
                    PreparedStatement prepStmt = connect.prepareStatement("DELETE FROM parking.miejsca_parkingowe " + "WHERE miejsce_ID = ? ;");
                    prepStmt.setString(1, Integer.toString(id));
                    prepStmt.execute();
                    count++;
                } else{
                    count++;
                    error++;
                }
                id--;
            }
            resultSet = statement.executeQuery("SELECT COUNT(miejsce_id) FROM parking.miejsca_parkingowe");
            resultSet.next();
            String temp = Integer.toString(resultSet.getInt("COUNT(miejsce_id)"));
            System.out.print(temp);
            setDataDane(2, temp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertPlace (int i){
        int count =1;
        int id = 1;
        try {
            while(count<=i) {
                resultSet = statement.executeQuery("SELECT * FROM parking.miejsca_parkingowe WHERE miejsce_id="+id+";");
                if (!resultSet.isBeforeFirst()){
                PreparedStatement prepStmt = connect.prepareStatement("INSERT INTO parking.miejsca_parkingowe " + "VALUES (?, NULL, NULL)");
                prepStmt.setInt(1, id);
                prepStmt.execute();
                count++;
                }
                id++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static int countEmptyPlace (){
        int count = 0;
        try {
            resultSet = statement.executeQuery("SELECT * FROM parking.miejsca_parkingowe;");
            while (resultSet.next()) {
                if (resultSet.getString(2) == null){

                    count++;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static String getDataDane (int i){
        String string = "true";
        try {
            resultSet = statement.executeQuery("SELECT * FROM parking.dane;");
            resultSet.next();
            string = resultSet.getString(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return string;
    }

    public static void setDataDane (int i, String string){
        if (i == 2) {
            try {
                PreparedStatement prepStmt = connect.prepareStatement("UPDATE parking.dane SET ilosc_miejsc = ? " + " WHERE ID = 1;");
                prepStmt.setString(1, string);
                prepStmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (i == 3) {
            try {
                PreparedStatement prepStmt = connect.prepareStatement("UPDATE parking.dane SET taryfa_dzien = ? " + " WHERE ID = 1;");
                prepStmt.setString(1, string);
                prepStmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (i == 4) {
            try {
                PreparedStatement prepStmt = connect.prepareStatement("UPDATE parking.dane SET taryfa_noc = ? " + " WHERE ID = 1;");
                prepStmt.setString(1, string);
                prepStmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getData (String carId){
        int id = 1;
        boolean flag = true;

        while (flag){
            try {
                resultSet = statement.executeQuery("SELECT * FROM parking.miejsca_parkingowe WHERE miejsce_id="+id+";");
                flag = resultSet.next();
                String plate = resultSet.getString("n_rej");
                if (plate == null){
                    flag = false;
                }else{
                    id++;
                }


            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = dateFormat.format(date);
            PreparedStatement prepStmt = connect.prepareStatement("UPDATE parking.miejsca_parkingowe SET n_rej = ?, godzina_przy = ? " + " WHERE miejsce_id = ?;");
            prepStmt.setString(1, carId);
            prepStmt.setString(2, dateString);
            prepStmt.setString(3, Integer.toString(id));
            prepStmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Integer.toString(id);
    }

    public int getNumberOfRows() {
        try {
            resultSet = statement.executeQuery("SELECT COUNT(*) FROM parking.miejsca_parkingowe;");
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            return 0;
        }
    }

    public static String[] getPriceAndTime (String dateArg){

        String [] data = new String[3];
        int[] hours = new int[24];
        for (int i=0; i<24; i++) hours[i]=0;
        int sum =0;
        try {
            resultSet = statement.executeQuery("SELECT * FROM parking.historia;");
            while (resultSet.next()) {
                Date dateIn = resultSet.getTimestamp("data_przyjazdu");
                Date dateOut = resultSet.getTimestamp("data_wyjazdu");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String dateStrIn = dateFormat.format(dateIn);
                String dateStrOut = dateFormat.format(dateOut);

                dateFormat = new SimpleDateFormat("HH");
                String timeStrin = dateFormat.format(dateIn);
                String timeStrout = dateFormat.format(dateOut);
                System.out.println(dateStrIn.compareTo(dateArg)<0);
                System.out.println(dateStrOut.compareTo(dateArg)>0);


                int price = resultSet.getInt("zaplata");
                if (dateStrIn.equals(dateStrOut)) {
                    if (dateStrIn.equals(dateArg)){

                        sum = sum + price;

                        for (int i=Integer.parseInt(timeStrin); i<=Integer.parseInt(timeStrout); i++){
                            hours[i]++;
                        }
                    }
                } else if (dateArg.equals(dateStrOut)){
                    sum = sum + price;

                    for (int i=0; i<=Integer.parseInt(timeStrout); i++){
                        hours[i]++;
                    }
                } else if (dateArg.equals(dateStrIn)) {
                    for (int i=Integer.parseInt(timeStrin); i<=23; i++){
                        hours[i]++;
                    }
                } else if (dateStrIn.compareTo(dateArg)<0 && dateStrOut.compareTo(dateArg)>0){
                    for (int i=0; i<24; i++){
                        hours[i]++;
                    }
                }

            }


        } catch (SQLException e) {
            return null;
        }
        int temp=0;
        for (int i=0; i<24; i++){
            if (temp < hours[i]){
                temp = hours[i];
                data[1] = String.valueOf(i);
            } else if (temp == hours[i]){
                data[1] = data[1] + ", " + String.valueOf(i);
            }
        }

        for (int i=0; i<24; i++){
            System.out.println(hours[i]);
            if (temp > hours[i]){
                temp = hours[i];
                data[2] = String.valueOf(i);
            } else if (temp == hours[i]){
                data[2] = data[2] + ", " + String.valueOf(i);

            }
        }

        data[0] = Integer.toString(sum);
        System.out.println(data[0]);
        System.out.println(data[1]);
        System.out.println(data[2]);
        return data;

    }

    public Object[][] getDate() {
        Object[][] date = new Object[getNumberOfRows()][4];

        try {
            resultSet = statement.executeQuery("SELECT * FROM parking.miejsca_parkingowe;");
            while (resultSet.next()) {
                int id = resultSet.getInt("miejsce_ID");
                String plate = resultSet.getString("n_rej");
                Date dateIn = resultSet.getTimestamp("godzina_przy");

                date[resultSet.getRow() - 1][0] = id;
                date[resultSet.getRow() - 1][1] = plate;
                date[resultSet.getRow() - 1][2] = dateIn;

                if (date[resultSet.getRow() - 1][2] != null) {
                    Date currentDate = new Date();
                    date[resultSet.getRow() - 1][3] = (currentDate.getTime() - ((Date) date[resultSet.getRow() - 1][2]).getTime()) / 3600000;
                }
            }
        } catch (SQLException e) {
            return null;
        }

        return date;
    }

    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
}
