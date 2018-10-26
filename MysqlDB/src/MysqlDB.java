import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;


/*
 * HW3 MySQL - JDBC
 * Saurav Das, sdas31
 * U of Illinois Chicago
 * CS480, Fall 2018
 */


public class MysqlDB {

    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3333/CS480HW3";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "****";

    private static Connection conn = null;
    private static Statement stmt = null;

    public static void Connect()
    {
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void Disconnect()
    {
        System.out.println("Disconnected");
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void CourseTable() throws FileNotFoundException, IOException
    {
        System.out.println("Trying to insert data into 'Course' table.....");
        int error = 0;

        String sql = "INSERT INTO Course VALUES(?,?,?,?)";

        //accessing Course.csv file
        BufferedReader br = new BufferedReader(new FileReader("src/Course.csv"));

        String line = "";
        //skipping header of the file
        line=br.readLine();

        while ( (line=br.readLine()) != null)
        {
            String[] values = line.split(",");
            try {
                PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
                ps.setString(1, values[0]);
                ps.setString(2, values[1]);
                ps.setString(3, values[2]);
                ps.setString(4, values[3]);
                ps.executeUpdate();
            } catch (SQLException ex) {
                error = 1;
                System.out.println(ex);
            }
        }
        if(error == 0){System.out.println("Data inserted into 'Course' table successfully");}
    }

    public static void CourseVsFacultyTable() throws FileNotFoundException, IOException
    {
        System.out.println("Trying to insert data into 'CourseVsFaculty' table.....");
        int error = 0;

        String sql = "INSERT INTO CourseVsFaculty VALUES(?,?)";

        //accessing CourseVsFaculty.csv file
        BufferedReader br = new BufferedReader(new FileReader("src/CourseVsFaculty.csv"));

        String line = "";
        //skipping header of the file
        line=br.readLine();

        while ( (line=br.readLine()) != null)
        {
            String[] values = line.split(",");
            try {
                PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
                ps.setString(1, values[0]);
                ps.setString(2, values[1]);
                ps.executeUpdate();
            } catch (SQLException ex) {
                error = 1;
                System.out.println(ex);
            }
        }
        if(error == 0){System.out.println("Data inserted into 'CourseVsFaculty' table successfully");}
    }

    public static void CourseVsStudentTable() throws FileNotFoundException, IOException
    {
        System.out.println("Trying to insert data into 'CourseVsStudent' table.....");
        int error = 0;

        String sql = "INSERT INTO CourseVsStudent VALUES(?,?)";

        //accessing CourseVsStudent.csv file
        BufferedReader br = new BufferedReader(new FileReader("src/CourseVsStudent.csv"));

        String line = "";
        //skipping header of the file
        line=br.readLine();

        while ( (line=br.readLine()) != null)
        {
            String[] values = line.split(",");
            try {
                PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
                ps.setString(1, values[0]);
                ps.setString(2, values[1]);
                ps.executeUpdate();
            } catch (SQLException ex) {
                error = 1;
                System.out.println(ex);
            }
        }
        if(error == 0){System.out.println("Data inserted into 'CourseVsStudent' table successfully");}
    }

    public static void DepartmentTable() throws FileNotFoundException, IOException
    {
        System.out.println("Trying to insert data into 'Department' table.....");
        int error = 0;

        String sql = "INSERT INTO Department VALUES(?,?,?,?,?)";

        //accessing department.csv file
        BufferedReader br = new BufferedReader(new FileReader("src/Department.csv"));

        String line = "";
        //skipping header of the file
        line=br.readLine();

        while ( (line=br.readLine()) != null)
        {
            String[] values = line.split(",");
            try {
                PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
                ps.setString(1, values[0]);
                ps.setString(2, values[1]);
                ps.setString(3, values[2]);
                ps.setString(4, values[3]);
                ps.setString(5, values[4]);
                ps.executeUpdate();
            } catch (SQLException ex) {
                error = 1;
                System.out.println(ex);
            }
        }
        if(error == 0){System.out.println("Data inserted into 'Department' table successfully");}
    }

    public static void FacultyTable() throws FileNotFoundException, IOException
    {
        System.out.println("Trying to insert data into 'Faculty' table.....");
        int error = 0;

        String sql = "INSERT INTO Faculty VALUES(?,?,?,?,?,?)";

        //accessing Faculty.csv file
        BufferedReader br = new BufferedReader(new FileReader("src/Faculty.csv"));

        String line = "";
        //skipping header of the file
        line=br.readLine();

        while ( (line=br.readLine()) != null)
        {
            String[] values = line.split(",");
            try {
                PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
                ps.setString(1, values[0]);
                ps.setString(2, values[1]);
                ps.setString(3, values[2]);
                ps.setString(4, values[3]);
                ps.setString(5, values[4]);
                ps.setString(6, values[5]);
                ps.executeUpdate();
            } catch (SQLException ex) {
                error = 1;
                System.out.println(ex);
            }
        }
        if(error == 0){System.out.println("Data inserted into 'Faculty' table successfully");}
    }

    public static void StudentTable() throws FileNotFoundException, IOException
    {
        System.out.println("Trying to insert data into 'Student' table.....");
        int error = 0;

        String sql = "INSERT INTO Student VALUES(?,?,?,?,?,?)";

        //accessing student.csv file
        BufferedReader br = new BufferedReader(new FileReader("src/Student.csv"));

        String line = "";
        //skipping header of the file
        line=br.readLine();

        while ( (line=br.readLine()) != null)
        {
            String[] values = line.split(",");
            try {
                PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
                ps.setString(1, values[0]);
                ps.setString(2, values[1]);
                ps.setString(3, values[2]);
                ps.setString(4, values[3]);
                ps.setString(5, values[4]);
                ps.setString(6, values[5]);
                ps.executeUpdate();
            } catch (SQLException ex) {
                error = 1;
                System.out.println(ex);
            }
        }
        if(error == 0){System.out.println("Data inserted into 'Student' table successfully");}
    }

    public static void ProjectTable() throws FileNotFoundException, IOException
    {
        System.out.println("Trying to insert data into 'Project' table.....");
        int error = 0;

        String sql = "INSERT INTO Project VALUES(?,?,?)";

        //accessing project.csv file
        BufferedReader br = new BufferedReader(new FileReader("src/Project.csv"));

        String line = "";
        //skipping header of the file
        line=br.readLine();

        while ( (line=br.readLine()) != null)
        {
            String[] values = line.split(",");
            try {
                PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
                ps.setString(1, values[0]);
                ps.setString(2, values[1]);
                ps.setString(3, values[2]);
                ps.executeUpdate();
            } catch (SQLException ex) {
                error = 1;
                System.out.println(ex);
            }
        }
        if(error == 0){System.out.println("Data inserted into 'Project' table successfully");}
    }

    public static void main(String[] args) throws IOException
    {
        System.out.println("Trying to connect CS480HW3 database.....");
        Connect();
        CourseTable();
        CourseVsFacultyTable();
        CourseVsStudentTable();
        DepartmentTable();
        FacultyTable();
        StudentTable();
        ProjectTable();
        Disconnect();
    }
}
