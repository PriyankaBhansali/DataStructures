package testpack;

public class StructurePrint {

	public static void main(String[] args) {

		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();   
		}
		for(int x = 1; x <= (4+1) ; x++) {
			System.out.print("*");
		}
		System.out.println();   
		for(int v = 4; v >= 1; v--) {
			for(int q = 1; q <= v; q++) {
				System.out.print("*");
			}
			System.out.println();   
		}  
		
		System.out.println();
		System.out.println();
		
		for(int i = 1; i <= 5; i++) {
			if(i%2==0)
				continue;
			for(int j = 1; j <= i; j++) {
				System.out.print("$");
			}
			System.out.println();   
		}
		
		System.out.println();
		System.out.println();

		for(int i=1;i<7;i++) {
			for(int j=1;j<7;j++){

				if(j>i){
					System.out.println();
					break;
				} 
				System.out.print((i*j) + "  "); 
			}
		}
	}
}
