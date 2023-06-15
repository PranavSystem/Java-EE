package pojos;

import java.time.LocalDate;

import javax.persistence.*;

@Entity 	// Mandatory to tell hibernate that this is standalone entity, life cycle to be managed by hibernate
@Table(name="employee") 	// to assign table name	
public class Employees {
	@Id    // primary key constraint
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_id")
	private Integer empId;
	@Column(name= "first_name", length=20)
	private String firstName;
	@Column(name = "last_name", length=20)
	private String lastName;
	@Column(unique = true)
	private String email;
	@Column(length=10,nullable = false)
	private String password;
	@Transient
	private String confirmPassword;
	@Column(name="join_date")
	private LocalDate joinDate;
	@Enumerated(EnumType.STRING)
	@Column(name="emp_type")
	private EmployeesType employeeType;
	@Column
	private Double salary;
	@Lob
	private byte[] image;
	
	public Employees(String firstName, String lastName, String email, String password, String confirmPassword,
			LocalDate doj, EmployeesType employeeType, Double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.joinDate = doj;
		this.employeeType = employeeType;
		this.salary = salary;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public LocalDate getDob() {
		return joinDate;
	}
	public void setDob(LocalDate doj) {
		this.joinDate = doj;
	}
	public EmployeesType getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(EmployeesType employeeType) {
		this.employeeType = employeeType;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Integer getEmpId() {
		return empId;
	}
	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "Employees [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", confirmPassword=" + confirmPassword + ", dob=" + joinDate + ", employeeType=" + employeeType
				+ ", salary=" + salary + "]";
	}
	
	
	
	
	
	
}
