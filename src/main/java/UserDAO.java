import java.sql.*;

public class UserDAO {
    public boolean checkUserAndPass(String username, String password) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //Nødvendigt for Tomcat
            conn = DriverManager.getConnection("jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/IT3?"
                    + "user=IT3&password=IT3&allowMultiQueries=true");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM usertable WHERE username='" + username + "' AND password='" + password + "';");
            boolean next = resultSet.next();
            int anInt = resultSet.getInt(1);
            if (anInt == 1){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn!=null){
                conn.close();
            }
        }
        return false;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDAO userDAO = new UserDAO();
        if(userDAO.checkUserAndPass("bolette", "kodeord")){
            System.out.println("Brugernavn og kodeord korrekt");
        } else {
            System.out.println("Brugernavn og kodeord forkert");
        }
        if(userDAO.checkUserAndPass("brian", "kodeord")){
            System.out.println("Brugernavn og kodeord korrekt");
        } else {
            System.out.println("Brugernavn og kodeord forkert");
        }

    }

}
