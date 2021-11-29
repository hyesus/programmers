package level1;
/*
	[3진법 뒤집기]
	자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.

	제한사항
	n은 1 이상 100,000,000 이하인 자연수입니다.
	
	입출력 예
	n	result
	45	7
	125	229

 */
public class ReverseTernaryScale {
	public static void main(String[] args) {
		int n = 125;
		System.out.println(solution(n));
		System.out.println(solution2(n));
	}
	
	public static int solution(int n) {
		int answer = 0;
		
		StringBuilder sb = new StringBuilder();
		if(n >= 3) {
			while(n > 0) {
				sb.append(n%3);
				n /= 3; 
			}
		} else {
			return n;
		}
		
		for(int i = sb.length() - 1, idx = sb.length() - 1; i >= 0; i--) {
			answer += (sb.charAt(idx - i) - 48) * Math.pow(3, i);
		}
		
		return answer;
    }
	
	public static int solution2(int n) {
		StringBuilder sb = new StringBuilder();
		if(n >= 3) {
			while(n > 0) {
				sb.append(n%3);
				n /= 3; 
			}
		} else {
			return n;
		}
		
		return Integer.parseInt(sb.toString(), 3);
	}
}
