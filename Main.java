package Task7.EmployeeDatabaseApp;

import java.util.List;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
            EmployeeDAO dao = new EmployeeDAO();
            Scanner sc = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n=== Employee Database App ===");
                System.out.println("1. Add Employee");
                System.out.println("2. View All Employees");
                System.out.println("3. Update Employee Salary");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        sc.nextLine(); // consume newline
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter department: ");
                        String dept = sc.nextLine();
                        System.out.print("Enter salary: ");
                        double sal = sc.nextDouble();
                        dao.addEmployee(new Employee(name, dept, sal));
                        break;

                    case 2:
                        List<Employee> list = dao.getAllEmployees();
                        if (list.isEmpty())
                            System.out.println("No employees found!");
                        else
                            list.forEach(System.out::println);
                        break;

                    case 3:
                        System.out.print("Enter employee ID: ");
                        int id = sc.nextInt();
                        System.out.print("Enter new salary: ");
                        double newSal = sc.nextDouble();
                        dao.updateEmployeeSalary(id, newSal);
                        break;

                    case 4:
                        System.out.print("Enter employee ID to delete: ");
                        int delId = sc.nextInt();
                        dao.deleteEmployee(delId);
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
            } while (choice != 5);

            sc.close();
        }
    }


