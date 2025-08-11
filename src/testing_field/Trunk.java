package testing_field;

import testing_field.entities.Filing;
import java.nio.file.*;

public class Trunk {

	public static void main(String[] args) {

		String path = System.getProperty("user.dir");
		
		System.out.println(path);
		
		try {
			Filing create = new Filing();
			create.createRepo(path+"/testDir");
			
		}
		finally {
			
		}
		
		
		
		
		
		
	}

}
