
public class ArraysClass {
	
	public static class MyList{
		String[] store = new String[10];
		int size = 0;
		
		public void add(String s){
			store[size] = s;
			size += 1;
		}
		
		public int size() {
			return size;
		}
		
		public String get(int i){
			return store[i];
		}
		
		public void remove(int i){
			store[i]= null;
			size -= 1;
		}
	}
}