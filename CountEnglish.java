import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CountEnglish {
	private  BufferedInputStream bis;
	
	//Constructor
	private CountEnglish() throws IOException{
		File file = new File("usatoday.txt");
		this.bis = new BufferedInputStream(
				new FileInputStream(file));
	}
	//Destructor
	@Override
	protected void finalize() {
		if(this.bis != null) {
			try {
				this.bis.close();
			} catch (IOException e) {}
		}
	}
	public static void main(String[] args) throws IOException{
		CountEnglish ce = new CountEnglish();
		int [] array = new int[52];
		int number = 0, count = 0;
		while((number = ce.bis.read()) >= 0) {
			if(number >= 65 && number <= 90) {  //대문자라면
				array[number - 65]++;  count++;
			}else if(number >= 97 && number <=122) {   //소문자라면
				array[number - 71]++;  count++;
			}
		}
		ce.print(array);
		System.out.println("\n\nTotal Count = " + count);
	}
	private void print(int [] array) {
		int count = 0;
		for(int i = 0 ; i < 26 ; i++) {
			System.out.printf("%c = %d\t", (char)(i + 65), array[i]);
			count++;
			if(count % 5 == 0 ) System.out.println();
		}
		System.out.println();
		count = 0;
		for(int i = 26 ; i < array.length; i++) {
			System.out.printf("%c = %d\t", (char)(i + 71), array[i]);
			count++;
			if(count % 5 == 0 ) System.out.println();
		}
	}
}




