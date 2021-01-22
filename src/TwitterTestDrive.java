import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TwitterTestDrive {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		int cases = sc.nextInt();
		Tags tag = new Tags(); 
		while (cases -- >= 0) {
			String tweet = sc.nextLine();
			//System.out.println(tweet);
			Pattern pat = Pattern.compile("#\\w+");
			Matcher match = pat.matcher(tweet);
			while (match.find()) {
				tag.addtag(match.group());
			}
		}
		tag.printTopTenTags();
	}
}
