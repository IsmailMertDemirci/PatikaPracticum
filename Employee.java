
public class Employee {
    private String name;
    private int salary;
    private int workHours;
    private int hireYear;

    public Employee() {
    }

    public Employee(String name, int salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public static void main(String[] args) {
        Employee workers1 = new Employee();
        workers1 = employee("Ali Can", 1250, 45, 2012);
        int bonus = bonus(workers1.workHours);
        int raiseSalary = raiseSalary(workers1.salary, workers1.hireYear);
        int tax = tax(workers1.salary, bonus, raiseSalary);
        printEmployees(workers1.name, workers1.salary, workers1.workHours, workers1.hireYear, bonus, raiseSalary, tax);
        System.out.println("**************");
        Employee workers2 = new Employee();
        workers2 = employee("Veli Can", 999, 50, 2010);
        bonus = bonus(workers2.workHours);
        raiseSalary = raiseSalary(workers2.salary, workers2.hireYear);
        tax = tax(workers2.salary, bonus, raiseSalary);
        printEmployees(workers2.name, workers2.salary, workers2.workHours, workers2.hireYear, bonus, raiseSalary, tax);
    }

    public static void printEmployees(String name, int salary, int workHours, int hireYear, int bonus, int raiseSalary, int tax) {
        System.out.println("Full Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("workHours: " + workHours);
        System.out.println("hireYear: " + hireYear);
        System.out.println("bonus: " + bonus);
        System.out.println("raiseSalary: " + raiseSalary);
        System.out.println("tax: " + tax);
        System.out.println("Total Salary: " + (salary + bonus + raiseSalary - tax));
    }

    private static int bonus(int workHours) {
        int hours = workHours - 40;
        if (hours > 0) {
            return hours * 30;
        }
        return 0;
    }

    public static Employee employee(String name, int salary, int workHours, int hireYear) {
        return new Employee(name, salary, workHours, hireYear);
    }

    public static int raiseSalary(int salary, int hireYear) {
        int year = 2021 - hireYear;
        if (year < 10) {
            return (int) (salary * (0.05));
        } else if (year < 20) {
            return (int) (salary * (0.1));
        } else {
            return (int) (salary * (0.15));
        }
    }

    public static int tax(int salary, int bonus, int raiseSalary) {
        int totalSalary = salary + bonus + raiseSalary;
        if (totalSalary < 1000) {
            return 0;
        } else {
            return (int) (totalSalary * (0.03));
        }
    }

}