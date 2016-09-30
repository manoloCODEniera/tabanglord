// no error checking version, no exception throws

public class Date {
	
	private int year;
	private int month;
	private int day;
	

	public Date(){
		this.year = 1000;
		this.month = 1;
		this.day = 1;
		
	}
	
	public Date(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public int getYear(){
		return year;
	}
	
	public int getMonth(){
		return month;
	}
	
	public int getDay(){
		return day;
	}
	
	public void setYear(int year){
		this.year = year;
	}
	
	public void setMonth(int month){
		this.month = month;
	}
	
	public void setDay(int day){
		this.day = day;
	}
	
	public void setDate(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public String toString(){
		String ans ="";
		if(day < 10 )
			ans += "0";
		ans += day + "/";
		if(month < 10 )
			ans += "0";
		ans += month + "/";
		ans += year;
		return ans;
	}
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Test constructor and toString()
	      Date d1 = new Date(2016, 4, 6);
	      System.out.println(d1);  // toString()
	 
	      // Test Setters and Getters
	      d1.setYear(2012);
	      d1.setMonth(12);
	      d1.setDay(23);
	      System.out.println(d1);  // run toString() to inspect the modified instance
	      System.out.println("Year is: " + d1.getYear());
	      System.out.println("Month is: " + d1.getMonth());
	      System.out.println("Day is: " + d1.getDay());
	 
	      // Test setDate()
	      d1.setDate(2988, 1, 2);
	      System.out.println(d1);  // toString()


	}

}
