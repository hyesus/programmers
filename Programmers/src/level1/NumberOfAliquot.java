package level1;
/*
	[약수의 개수와 덧셈]
	두 정수 left와 right가 매개변수로 주어집니다. 
	left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.
	
	제한사항
	1 ≤ left ≤ right ≤ 1,000
	
	입출력 예
	left	right	result
	13		17		43
	24		27		52

 */
public class NumberOfAliquot {
	public static void main(String[] args) {
		int left = 13, right = 17;
		System.out.println(solution2(left, right));
	}
	
	public static int solution(int left, int right) {
		int answer = 0;
		
		for(int aliquot = 2, half = 0; left <= right; left++) {
			aliquot = 1; //자기자신 미리 포함
			half = left / 2;
			for(int i = 1; i <= half; i++) {
				if(left % i == 0) aliquot++;
			}
			answer += aliquot % 2 == 0 ? left : -left;
		}
		
		return answer;
    }
	
	public static int solution2(int left, int right) {
		int answer = 0;
		
		for(; left <= right; left++) {
			//제곱수는 약수의 개수가 홀수이고 제곱수가 아닌 경우는 약수의 개수가 짝수이다. 
			answer += left % Math.sqrt(left) == 0 ? -left : left;
		}
		
		return answer;
	}
}
