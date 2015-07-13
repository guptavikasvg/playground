
public class ModuloTest {

	public static void main(String[] args) {
		System.out.println((-5)%10);
		System.out.println(-13%10);
		System.out.println(-10%10);
		System.out.println(0%10);
	}
    
	int modulo(int n, int p) {
		if (n > 0) return n%p;
		
		return p - ((-n) % p);
	}
}
