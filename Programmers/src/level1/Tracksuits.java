package level1;
/*
	[체육복]
	점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 
	학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 
	예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.

	전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 
	체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
	
	제한사항
	전체 학생의 수는 2명 이상 30명 이하입니다.
	체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
	여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
	여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
	여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
	
	입출력 예
	n	lost	reserve		return
	5	[2, 4]	[1, 3, 5]	5
	5	[2, 4]	[3]			4
	3	[3]		[1]			2
 */
import java.util.Arrays;

public class Tracksuits {
	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2, 1, 2, 6, 2, 4, 3, 3};
		int[] resreve = {2, 1, 2, 6, 2, 4, 3, 3};
		System.out.println(solution(n, lost, resreve));
	}
	
	public static int solution(int n, int[] lost, int[] reserve) {
		int[] students = new int[n]; 
		
		Arrays.sort(lost);
		Arrays.sort(reserve);
		
		//도난당했을 경우 -1, 여벌이 있을경우 +1
		for(int l : lost) students[l - 1]--;
		for(int r : reserve) students[r - 1]++;
		
		for(int i = 0; i < n; i++) {
			if(students[i] < 0) {
				if(i != n - 1 && students[i + 1] > 0) {
					students[i]++;
					students[i + 1]--;					
				} else if (i != 0 && students[i - 1] > 0) {
					students[i]++;
					students[i - 1]--;					
				}
			}
		}
		
		int answer  = 0;
		for(int s : students) if(s >= 0) answer++;
		
		return answer;
    }
	
	public static int solution_ljh(int n, int[] lost, int[] reserve) {
		int answer=0;
		int cnt=0;
		int cnt2=0;
		
		for(int i=0; i<lost.length; i++) {
			for(int j=0; j<reserve.length;j++) {
				if(lost[i]==reserve[j]) {
					cnt++;
					lost[i]=-1;
					reserve[j]=-1;
					break;
				}
			}
		}
		
		//옷을 빌려주고 -1로 만들어 뒤의 학생에게 빌려주지 않게 한다.
		for(int i=0; i<lost.length; i++) {
			for(int j=0; j<reserve.length;j++) {
				if(lost[i]-1 == reserve[j] || lost[i]+1 == reserve[j]) {
					
					cnt2++;
					reserve[j]=-1;
					break;
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println("cnt2값 : "+cnt2);
		
		answer = n-lost.length+cnt+cnt2;
		
		System.out.println("리턴값 : "+answer);
        return answer;
	}
}
