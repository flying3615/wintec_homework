package assignment;

public class CountLoop {

	public static void main(String[] args) {
		int[] a = new int[500];
		for(int i=0;i<a.length;i++){
			a[i] = i;
		}

		int times = 0;
		for(int i=0;i<a.length;i++){
			for(int j=i+1;j<a.length;j++){
				times++;
			}
		}
		System.out.println("maximun compare times = "+times);
		System.out.println("maximun compare times = "+500*499/2);
		System.out.println("maximun compare times = "+500*501/2);
	}
}
