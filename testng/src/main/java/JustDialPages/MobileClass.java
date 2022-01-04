package JustDialPages;

public class MobileClass {
	public String mobileClass(String k) {
		String ans = null;
		if(k.equalsIgnoreCase("dc")) {
			ans = "+";
		}
		else if(k.equalsIgnoreCase("fe")) {
			ans = "(";
		}
		else if(k.equalsIgnoreCase("hg")) {
			ans = ")";
		}
		else if(k.equalsIgnoreCase("ba")) {
			ans = "-";
		}
		else if(k.equalsIgnoreCase("acb")) {
			ans = "0";
		}
		else if(k.equalsIgnoreCase("yz")) {
			ans = "1";
		}
		else if(k.equalsIgnoreCase("wx")) {
			ans = "2";
		}
		else if(k.equalsIgnoreCase("vu")) {
			ans = "3";
		}
		else if(k.equalsIgnoreCase("ts")) {
			ans = "4";
		}
		else if(k.equalsIgnoreCase("rq")) {
			ans = "5";
		}
		else if(k.equalsIgnoreCase("po")) {
			ans = "6";
		}
		else if(k.equalsIgnoreCase("nm")) {
			ans = "7";
		}
		else if(k.equalsIgnoreCase("lk")) {
			ans = "8";
		}
		else if(k.equalsIgnoreCase("ji")) {
			ans = "9";
		}
		return ans;
	}
}
