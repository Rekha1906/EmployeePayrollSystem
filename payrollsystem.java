import java.util.*;

class Employee {
    int id;
    String name;
    double basicSalary;

    Employee(int id, String name, double basicSalary) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    double hra() {
        return basicSalary * 0.20;
    }

    double da() {
        return basicSalary * 0.10;
    }

    double pf() {
        return basicSalary * 0.08;
    }

    double tax() {
        return basicSalary * 0.05;
    }

    double grossSalary() {
        return basicSalary + hra() + da();
    }

    double netSalary() {
        return grossSalary() - (pf() + tax());
    }

    void display() {
        System.out.println("\nID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("HRA: " + hra());
        System.out.println("DA: " + da());
        System.out.println("PF: " + pf());
        System.out.println("Tax: " + tax());
        System.out.println("Gross Salary: " + grossSalary());
        System.out.println("Net Salary: " + netSalary());
        System.out.println("---------------------------");
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> list = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n==== EMPLOYEE PAYROLL SYSTEM ====");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Basic Salary: ");
                    double salary = sc.nextDouble();

                    list.add(new Employee(id, name, salary));
                    System.out.println("Employee Added Successfully!");
                    break;

                case 2:
                    if (list.isEmpty()) {
                        System.out.println("No employees found.");
                    } else {
                        for (Employee e : list) {
                            e.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    boolean found = false;

                    for (Employee e : list) {
                        if (e.id == searchId) {
                            e.display();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}