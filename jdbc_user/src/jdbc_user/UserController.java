package jdbc_user;

import java.util.Scanner;

public class UserController {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		User user = new User();
		UserCRUD usercrud = new UserCRUD();
		System.out.println("Welcome user !!!\n Enter 1 for Signup \n Enter 2 for Login \n Enter 3 for Exit");
		
		
		switch (scanner.nextInt()) {
		case 1: {
			System.out.println("Enter id");
			int id = scanner.nextInt();
			System.out.println("Enter name");
			String name = scanner.next();
;
			System.out.println("Enter phone");
			long phone = scanner.nextLong();
			
			System.out.println("Enter email");
			String email = scanner.next();
			System.out.println("Enter password");
			String password = scanner.next();
			
			user.setId(id);
			user.setName(name);
			user.setPhone(phone);
			user.setEmail(email);
			user.setPassword(password);
			usercrud.signUp(user);
			break;
			
			
		}
		case 2:{
			System.out.println("Enter email");
			String email = scanner.next();
			System.out.println("Enter password");
			String password = scanner.next();
			usercrud.logIn(email,password);
			
			break;
			
			
		}
		default:{
			System.out.println("Exit");break;
		}
		
		}
		

	}

}
