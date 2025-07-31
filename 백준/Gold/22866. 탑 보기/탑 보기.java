import java.util.*;

class Building {
	int index;
	int height;
	
	Building(int index, int height){
		this.index = index;
		this.height = height;
	}
}

class Main{
	
	static Building[] buildings;
	static int[][] answer; // 0 보이는 빌딩 수, 1 최소 인덱스
	
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        buildings = new Building[N];
        answer = new int[N][2];
        Stack<Building> buildingStack = new Stack<>();
        
        for(int index=0; index<N; index++) {
        	int height = sc.nextInt();
        	Building building = new Building(index + 1, height);
        	buildings[index] = building;
        	answer[index][1] = Integer.MAX_VALUE;
        }
       
        
        for(int idx=1; idx<N; idx++) {
        	buildingStack.add(buildings[idx-1]);
        	
            int prevH = buildingStack.peek().height;
        	int curH = buildings[idx].height;
        	int cnt = 0;
        	
        	
        	if(curH < prevH) { // 보이는 경우
        		
        		answer[idx][0] += buildingStack.size();
        		if(answer[idx][1] > buildingStack.peek().index) {
        			answer[idx][1] = buildingStack.peek().index;
        		}
        		
        	} else if(buildingStack.peek().index != buildings[idx].index) { // 안보이는 경우
        		
        		while(!buildingStack.isEmpty() && curH >= buildingStack.peek().height) {
        			buildingStack.pop(); // 안보이는 스택 다 버리기
        		}
        		
        		if(!buildingStack.isEmpty()) {
        			answer[idx][0] += buildingStack.size();
            		if(answer[idx][1] > buildingStack.peek().index && cnt == 0) {
            			answer[idx][1] = buildingStack.peek().index;
            			cnt++;
            		}
        		}
        		
        		
        	}
        }
        
        buildingStack.clear();
        for(int idx=N-2; idx>=0; idx--) {
        	buildingStack.add(buildings[idx+1]);
        	
            int prevH = buildingStack.peek().height;
        	int curH = buildings[idx].height;
        	int cnt = 0;
        	
        	if(curH < prevH) { // 보이는 경우
        		
        		answer[idx][0] += buildingStack.size();
        		if(cnt == 0 && Math.abs(answer[idx][1] - (idx + 1)) > Math.abs(buildingStack.peek().index - (idx+1))) {
        			answer[idx][1] = buildingStack.peek().index;
        			cnt++;
        		}
        		
        	} else if(buildingStack.peek().index != buildings[idx].index) { // 안보이는 경우
        		while(!buildingStack.isEmpty() && curH >= buildingStack.peek().height) {
        			buildingStack.pop(); // 안보이는 스택 다 버리기
        		}
        		
        		if(!buildingStack.isEmpty()) {
        			answer[idx][0] += buildingStack.size();
        			
            		if(cnt == 0 && Math.abs(answer[idx][1] - (idx + 1)) > Math.abs(buildingStack.peek().index - (idx+1))) {
            			answer[idx][1] = buildingStack.peek().index;
            			cnt++;
            		}
        		}
        		
        	}
        }
        
        for(int[] building : answer) {
        	if(building[0] == 0) {
        		System.out.println(building[0]);
        	}
        	
        	else {
        		System.out.println(building[0] + " " + building[1]);
        	}
        }
    }
}
