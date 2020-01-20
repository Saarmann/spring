package course.jse.jdbc.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import course.jse.jdbc.labs.Cd;
import course.jse.jdbc.utils.DbUtils;
import course.jse.jdbc.utils.ProjectUtils;

public class CustomerDao {
	
	public void createCustomer (Customer customer) {
		
		 Connection conn =null;
			
			try{
				conn =ProjectUtils.createConnection();
	        
	            Statement cmd = conn.createStatement ();	 		
		        
	            String sql = "INSERT INTO `customer` "
		        		+ "( `customer_name`, " 
		        		+ "`registration_code`, "
		        		+ "`vat_no`, "
		        		+ "`address`, "
		        		+ "`city`, "
		        		+ "`state`, "
		        		+ "`country`, "
		        		+ "`zip`, "
		        		+ "`customer_email`, "
		        		+ "`contact`, "
		        		+ "`payment_term`) "
		        		+ "VALUES("
		        		+ "'"+customer.getCustomerName()+"', "
		        		+ "'"+customer.getRegistrationCode()+"', "
		        		+ "'"+customer.getVatNo()+"', "				
						+ "'"+customer.getAddress()+"', "
						+ "'"+customer.getCity()+"', "
						+ "'"+customer.getState()+"', "
						+ "'"+customer.getCountry()+"', "
						+ "'"+customer.getZip()+"', "
						+ "'"+customer.getCustomerEmail()+"', "
						+ "'"+customer.getContact()+"', "
						+ customer.getPaymentTerm()+") ";
							        
	            cmd.executeUpdate(sql);
		        	            
	        }
	        catch (Exception e){
	           
	        	System.err.println ("Impossible to connect to Database");
	        	 e.printStackTrace();            
	        }
	        finally {
	           ProjectUtils.closeConnection(conn);         
	        }
		
	}
	
	public List <Customer> showCustomers () {
		Connection conn = null;
		Customer found = null;
		List <Customer> customerList = new ArrayList<>();
					
		try{
				
			conn =ProjectUtils.createConnection();
			
			Statement cmd = conn.createStatement();
			String sql = "SELECT * FROM customer";
					
			ResultSet res = cmd.executeQuery(sql);
				
			while (res.next()) {
			
			found = new Customer(sql, sql, sql, sql, sql, sql, sql, sql, sql, sql, 0);
			found.setId(res.getInt("id"));
			found.setCustomerName(res.getString("customer_name"));
			found.setRegistrationCode(res.getString("registration_code"));
			found.setVatNo(res.getString("vat_no"));
			found.setCountry(res.getString("country"));
			found.setAddress(res.getString("address"));
			found.setCity(res.getString("city"));
			found.setState(res.getString("state"));
			found.setZip(res.getString("zip"));
			found.setCustomerEmail(res.getString("customer_email"));
			found.setContact(res.getString("contact"));
			found.setPaymentTerm(res.getInt("payment_term"));
						
			customerList.add(found);
		}

		}

		catch (Exception e) {

			System.err.println("Impossible to connect to Database");
			e.printStackTrace();

		} finally {
			ProjectUtils.closeConnection(conn);    
		}
		return customerList;
	}
		
	public Customer editCustomer (Customer customer, int id) {
		
		 Connection conn =null;
			
			try{
				conn =ProjectUtils.createConnection();
	        
	            Statement cmd = conn.createStatement ();	 		
		        
	            String sql = "UPDATE customer SET customer_name= " + "'"+customer.getCustomerName()+"'," 
	            + " vat_no= " + "'"+customer.getVatNo()+"',"
	            + " address= " + "'"+customer.getAddress()+"',"
	            + " city= " + "'"+customer.getCity()+"',"
	            + " state= " + "'"+customer.getState()+"',"
	            + " country= " + "'"+customer.getCountry()+"',"
	            + " zip= " + "'"+customer.getZip()+"',"
	            + " customer_email= " + "'"+customer.getCustomerEmail()+"',"          
	            + " contact= " + "'"+customer.getContact()+"',"
	            + " payment_term= " + "'"+customer.getPaymentTerm()+"'"
	            + " where id= " +id;
	            		
							        
	            cmd.executeUpdate(sql);
		        	            
	        }
	        catch (Exception e){
	           
	        	System.err.println ("Impossible to connect to Database");
	        	 e.printStackTrace();            
	        }
	        finally {
	           ProjectUtils.closeConnection(conn);         
	        }
			return null;
					
	}
	
	public void createUserPrepStatement() {
		
		Connection conn = null;

        try
        {
           
            conn = ProjectUtils.createConnection();            
            System.out.println ("Connected to Database...");
            
            PreparedStatement pstQueryArtistAndQuantity = conn.prepareStatement("INSERT INTO customer (customer_name,registration_code,vat_no,address,city,state,country,zip,customer_email,contact,payment_term)" + 
            		            																	"VALUES (?,?,?,?,?,?,?,?,?,?,?)"); 
            
            pstQueryArtistAndQuantity.setString(1, "Kühne + Nagel");
            pstQueryArtistAndQuantity.setString(2, "12151564564");
            pstQueryArtistAndQuantity.setString(3, "DE25454646");
            pstQueryArtistAndQuantity.setString(4, "Street 55");
            pstQueryArtistAndQuantity.setString(5, "Helsinki");
            pstQueryArtistAndQuantity.setString(6, "Helsinki");
            pstQueryArtistAndQuantity.setString(7, "Finland");
            pstQueryArtistAndQuantity.setString(8, "545454");
            pstQueryArtistAndQuantity.setString(9, "nagel@kyhne.fi");
            pstQueryArtistAndQuantity.setString(10, "+387888888");
            pstQueryArtistAndQuantity.setInt(11, 21);
            
	        pstQueryArtistAndQuantity.executeUpdate();
	 	            
        }
        catch (Exception e){
        	e.printStackTrace();            
        }
        finally {
        	ProjectUtils.closeConnection(conn);       
        }
                       

	}
		
	public void updateUserPrepStatement(Customer customer, int id) {
		
		Connection conn = null;

        try
        {
           
            conn = ProjectUtils.createConnection();            
            System.out.println ("Connected to Database...");
            
            PreparedStatement sql = conn.prepareStatement("UPDATE customer SET customer_name = ?,vat_no = ?,address = ?,city = ?,state = ?,country = ?,zip = ?,customer_email = ?,contact = ?,payment_term = ? where id = ?");
            		            																	 
            sql.setString(1, customer.getCustomerName());
            sql.setString(2, customer.getVatNo());
            sql.setString(3, customer.getAddress());
            sql.setString(4, customer.getCity());
            sql.setString(5, customer.getState());
            sql.setString(6, customer.getCountry());
            sql.setString(7, customer.getZip());
            sql.setString(8, customer.getCustomerEmail());
            sql.setString(9, customer.getContact());
            sql.setInt(10, customer.getPaymentTerm());
            sql.setInt(11, id);
            
            sql.executeUpdate();
	 	            
        }
        catch (Exception e){
        	e.printStackTrace();            
        }
        finally {
        	ProjectUtils.closeConnection(conn);       
        }
                        

	}
		
	
}
