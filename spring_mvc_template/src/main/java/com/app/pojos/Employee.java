package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;//all specs Java EE supplied

@Entity 
@Table(name = "emps")
public class Employee extends BaseEntity {

	@Column(name = "first_name", length = 20) 
	private String firstName;
	@Column(name = "last_name", length = 20)
	private String lastName;
	@Column(length = 30, unique = true) 
	private String email;
	@Column(length = 20, nullable = false) 
	private String password;
	@Transient 
	private String confirmPassword;
	@Column(name = "join_date")
	private LocalDate joinDate;
	@Enumerated(EnumType.STRING) 
	@Column(length = 20)
	private EmploymentType type;
	private double salary;
	@Lob 
	private byte[] image;
	// Employee *----->1 Department
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "dept_id",nullable = false)
	private Department assignedDept;
	//many to many bi dir Employee *---->* Project , inverse side
	@ManyToMany(mappedBy = "empSet")
	private Set<Project> projects=new HashSet<>();
	private AdhaarCard card;
	//Emp 1----*Skills(String)
	@ElementCollection
	@CollectionTable(name = "emp_skills",joinColumns = @JoinColumn(name="emp_id"))
	@Column(name="skill_name",length = 30)
	private List<String> skills;
	//Employee --- PaymentOption (eg creditcard , gpay....) : collection of embeddables
	@ElementCollection
	@CollectionTable(name="payment_options",joinColumns = @JoinColumn(name="emp_id"))
	private List<PaymentOption> paymentOptions=new ArrayList<>();

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String firstName, String lastName, String email, String password, String confirmPassword,
			LocalDate joinDate, EmploymentType type, double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.joinDate = joinDate;
		this.type = type;
		this.salary = salary;
	}

	// additional overloaded ctor : to be used in JPQL ctor expression
	public Employee(String firstName, String lastName, double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public EmploymentType getType() {
		return type;
	}

	public void setType(EmploymentType type) {
		this.type = type;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Department getAssignedDept() {
		return assignedDept;
	}

	public void setAssignedDept(Department assignedDept) {
		this.assignedDept = assignedDept;
	}
	

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + getId() + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", joinDate=" + joinDate + ", type=" + type + ", salary=" + salary + "]";
	}
	

	public AdhaarCard getCard() {
		return card;
	}

	public void setCard(AdhaarCard card) {
		this.card = card;
	}
	

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	

	public List<PaymentOption> getPaymentOptions() {
		return paymentOptions;
	}

	public void setPaymentOptions(List<PaymentOption> paymentOptions) {
		this.paymentOptions = paymentOptions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	

}
