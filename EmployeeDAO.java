package Task7.EmployeeDatabaseApp;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class EmployeeDAO {

        // Add Employee
        public void addEmployee(Employee emp) {
            String sql = "INSERT INTO employees (name, department, salary) VALUES (?, ?, ?)";
            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1,emp.getName());
                ps.setString(2, emp.getDepartment());
                  ps.setDouble(3,emp.getSalary());
                ps.executeUpdate();
                System.out.println("Employee added successfully!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Get All Employees
        public List<Employee> getAllEmployees() {
            List<Employee> employees = new ArrayList<>();
            String sql = "SELECT * FROM employees";
            try (Connection conn = DBConnection.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {
                 while (rs.next()) {
                    Employee emp = new Employee(
                             rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("department"),
                            rs.getDouble("salary")
                    );
                    employees.add(emp);
                }
              } catch (SQLException e) {
                e.printStackTrace();
            }
              return employees;
             }

        // Update Employee Salary
        public void updateEmployeeSalary(int id, double newSalary) {
            String sql = "UPDATE employees SET salary = ? WHERE id = ?";
            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setDouble(1, newSalary);
                ps.setInt(2, id);
                int rows = ps.executeUpdate();
                if (rows > 0)
                    System.out.println("Employee salary updated successfully!");
                else
                    System.out.println("Employee not found.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Delete Employee
        public void deleteEmployee(int id) {
            String sql = "DELETE FROM employees WHERE id = ?";
            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id);
                int rows = ps.executeUpdate();
                if (rows > 0)
                    System.out.println("Employee deleted successfully!");
                else
                    System.out.println(" Employee not found.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
