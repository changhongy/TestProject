package crm.daomin;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	private String bid;
	private String bookname;
	private String bookcategory;
	private Date uptime;
	private double price;
	private int hot;
	private String realBookname;
	
	/**  
	* 构造方法名: Book  
	* @param bid
	* @param bookname
	* @param bookcategory
	* @param uptime
	* @param price    
	*/
	public Book(String bid, String bookname, String bookcategory, Date uptime, double price) {
		super();
		this.bid = bid;
		this.bookname = bookname;
		this.bookcategory = bookcategory;
		this.uptime = uptime;
		this.price = price;
	}
	
	
}
