
public class Pair {
	private String first; // first member of pair
	private String second; // second member of pair

	public Pair(String first, String second) {
		this.first = first;
		this.second = second;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public void setSecond(String second) {
		this.second = second;
	}

	public String getFirst() {
		return first;
	}

	public String getSecond() {
		return second;
	}
	
	//ridefinisci il to string per la listview
	@Override
	public String toString() {
		return "(" + this.getFirst() +", " +this.getSecond() +")";
	}
}
