package lib;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PrepareStatement;

public class DemoDataBase {
	public void CurdOperations()
	{
		String continedata="";
		System.out.println("welcome");
		String connectionUrl="jdbc:mysql://localhost:3306?user=root&password=12345";
				do
				{
					System.out.println("select options given below");
					System.out.println("press 1 to select data \n press 2 to insert data \n press 3 to delete  data ");
					Scanner sc = new Scanner(System.in);
					var DataInput=sc.nextLine();
					switch (DataInput)
					{
						case '1':
							ResultSet resultSet =null;
							try(Connection connection =DriverManager.getConnection(connectionUrl);
									Statement statement = connection.createStatement();)
							{
								
								String selectSql ="select * from Student1" ;
								resultSet =statement.executeQuery(selectSql);
								while(resultSet.next())
								{
									var str =String.format("%s %s,",resultSet.getString(1),resultSet.getString(2));
								}
							}
							catch(SQLException e)
							{
								e.printStackTrace();
							}
							break;
							
						case '2':
							try(Connection connection = DriverManager.getConnection(connectionUrl))
							{
								System.out.println("enter student id:");
								var sid =sc.nextInt();
								System.out.println(sid);
								System.out.println("Enter Student Name");
								var sname=sc.nextLine();
								System.out.println(sname);
								System.out.println("Enter student Address");
								var saddress=sc.nextLine();
								System.out.println(saddress);
								System.out.println("Enter student Marks");
								var smarks=sc.nextInt();
								System.out.println(smarks);
								PreparedStatement stmt =connection.prepareStatement("insert into student1 values");
								stmt.setString(1, sid);
								stmt.setString(2, sname);
								stmt.setString(3, saddress);
								stmt.setString(4, smarks);
								stmt.executeUpdate();
								
								System.out.println("Data Entered successfully! ");
							}
							catch(SQLException e)
							{
								e.printStackTrace();
							}
							break;
							case '3':
							try(Connection connection = DriverManager.getConnection(connectionUrl);
									Statement stmt = connection.createStatement())
							{
								System.out.println("Enter an Id you want to delete: ");
								var ID = sc.nextLine();
								String delquery = "delete from student1 where student-id="+ID;
								stmt.executeUpdate(delquery);
								System.out.println("Data Deleted Succesfully!");
							}
							catch(SQLException e)
							{
								e.printStackTrace();
							}
							break;
							default:
								System.out.println("You have Selected Wrong Input!!");
								break;
					}
					System.out.println("Enter Y to continue: else press any other key to exit the program ");
					continuedata =sc.nextLine();
					if(continuedata.equals("y"))
					{
						System.out.println("you have Selected to Continue");
						
					}
					
				}while(continuedata.equals("Y"));
						System.out.println("You Have Exicuted the Program!!!");

		
	}

}
