package orangeHRM;

public class Runner {
public static void main(String[] args) {
	OrangeHRM_Login_PF obj=new OrangeHRM_Login_PF();
	OrangeHRM_Dashboard ob=new OrangeHRM_Dashboard();
	
	obj.Login();
	ob.user_navigateto_myinfo_navigateTo_contactDetails();
	ob.user_navigateto_emergencyContact_updateDetails();
	ob.user_navigateto_dependants_updateDetails();
}
}
