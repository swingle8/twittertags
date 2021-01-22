import java.util.ArrayList;
import java.util.HashMap;

public class Tags {
	private HashMap<String, Integer> map = new HashMap<String, Integer>();
	private ArrayList<String> list = new ArrayList<String>();
	
	public void addtag (String tag) {
		if (! map.containsKey(tag))
			map.put(tag, 0);
		increaseCount(tag);
		putInTopTen(tag);
	}
	
	private void increaseCount (String tag) {
		int count = map.get(tag) + 1;
		map.put(tag, count);
	}
	
	private void putInTopTen (String tag) {
		int len = list.size();
		if (len < 10 && ! list.contains(tag)) {
			list.add(tag);
		}
		else if (len == 10 && ! list.contains(tag)) {
			String prevTag = list.get(9);
			int prevcount = map.get(prevTag);
			if (prevcount < map.get(tag)) {
				list.remove(9);
				list.add(9, tag);
			}
		}
		else if (list.contains(tag)) {
			int currIndex = list.indexOf(tag);
			
			while (currIndex > 0 && map.get(list.get(currIndex - 1)) < map.get(tag)) {
				String prevTag = list.get(currIndex - 1);
				list.remove(currIndex - 1);
				list.add(currIndex - 1, tag);
				list.remove(currIndex);
				list.add(currIndex, prevTag);
				currIndex = currIndex - 1 ;
			}
		}
		
	}
	
	public void printTopTenTags () {
		for (String s : list) {
			System.out.println(s + " : " + map.get(s));
		}
	}
}
