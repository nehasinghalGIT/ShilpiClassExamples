import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MyOracleDBConn {
	
	public static Connection conn;
	
	public static Connection getConnection(){
		
		if (conn==null) {
			try {
				// Load The jdbc Driver
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "hr", "whiteboxqa");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return conn;	
	}
    public void getEmpData(){
    	try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select employee_id, salary from employees where department_id in (50, 80)");
			int count = 0;
		    
			while (rs.next()){
				count++;
				int emp_id = rs.getInt("Employee_Id");
				double salary = rs.getDouble("salary");
				System.out.println("EmpId: " + emp_id + "Salary :" + salary);
			}
			rs.close();
			System.out.println("Total number of records:"+ count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    // Employee Class - empId, salary, deptId
    public void getDeptData(){
    	try {
    		//String query = "select * from departments where location_id in (?,?) ";
    		String query = "insert into departments values (?,?,100,1800)";
			PreparedStatement st = conn.prepareStatement(query);
		
		    st.setInt(1, 1006);
		    st.setString(2, "Test2");
		    int ret = st.executeUpdate();
		    System.out.println("Rows updated : " + ret);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	public static void main(String[] args) {
		Connection conn = getConnection();
		MyOracleDBConn c = new MyOracleDBConn();
		c.getEmpData();
		c.getDeptData();
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
