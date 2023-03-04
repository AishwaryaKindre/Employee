package com.saksoft.CurdOpt;

public class ServiceLayer {
	
	private DBManager db;
	public ServiceLayer() {
		db=new DBManager();
		
	}
//Select	
	public void selectData() {
		db.selectRecords();
	}
//Insert	
	public void InsertData(int id, String first_Name, String Last_Name, String Email, int Age) {
		String cmd="INSERT INTO Employee (id, first_Name, Last_Name, Email, Age)"
				+ " VALUES ('"+id+"','"+first_Name+"','"+Last_Name+"','"+Email+"','"+Age+"')";
		if(db.RecordManipulation(cmd))
			System.out.println("			Record save successfully!			");
		else
			System.out.println("Record has not saved");
	}
//Update
	public void UpdateData(int id, int Age) {
		String cmd="update Employee set Age='"+Age+"'where id='"+id+"'";
		if(db.RecordManipulation(cmd))
			System.out.println("	*********Record updated successfully!!**********			");
		else
			System.out.println("Record has not updated ");
	}
//Delete
	public void DeleteData(int id) {
		String cmd="delete from Employee where id='"+id+"'";
		if(db.RecordManipulation(cmd))
			System.out.println("	*********Record updated successfully!!**********			");
		else
			System.out.println("Record has not updated ");
	}

}
