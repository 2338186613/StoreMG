package ShoppingSystem.idea;
import java.util.*;

import ShoppingSystem.DataBase.User;

public class Common {
	private static Scanner scan=new Scanner(System.in);
	//判断是否继续
	public static boolean ifOpt(String opt) {
		if(opt.equals("y")||opt.equals("Y")){
			return true;
		}else if(opt.equals("n")||opt.equals("N")) {
			return false;
		}else {
			System.out.println("输入错误！默认选择“N”");
			return false;
		}
	}
	//用户登录或管理员操作码错误输入次数
	public static int numOpt(int num) {
		if(scan.hasNextInt()) {
			return num;
		}else {
			System.out.println("输入错误！还剩下"+num+"次机会");
		}
		return num;
	}
	//返回停留
	public static void lock() {
		System.out.print("\n输入任何值返回:");
		while(scan.next()!=null) {
			break;
		}
	}
	//判断用户是否登录
	public static boolean LoginChecking(User user) {
		if(user.getAccount()==null) {
			return false;
		}
		return true;
	}
}
