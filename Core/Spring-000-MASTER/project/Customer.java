package course.jse.jdbc.project;

import lombok.Data;

@Data
public class Customer {
	
	private int id;
	private String customerName;
	private String registrationCode;
	private String vatNo;
	private String address;
	private String city;
	private String state;
	private String country;
	private String zip;
	private String customerEmail;
	private String contact;
	private int paymentTerm;
	
	public Customer(String customerName, String registrationCode, String vatNo, String address, String city,
			String state, String country, String zip, String customerEmail, String contact, int paymentTerm) {
		
		this.customerName = customerName;
		this.registrationCode = registrationCode;
		this.vatNo = vatNo;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
		this.customerEmail = customerEmail;
		this.contact = contact;
		this.paymentTerm = paymentTerm;
	}
		
	
}

