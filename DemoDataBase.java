package lib;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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
								
							}
					}
					
				}while(true);
	}

}
