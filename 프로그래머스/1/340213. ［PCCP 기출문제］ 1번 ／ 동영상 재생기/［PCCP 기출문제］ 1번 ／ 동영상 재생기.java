class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoMax = timeToSec(video_len);
        int curSec = timeToSec(pos);
        int opStartSec = timeToSec(op_start);
        int opEndSec = timeToSec(op_end);
        
        if(opStartSec <= curSec && curSec <= opEndSec){
            curSec = opEndSec;
        }
        
        for(String command : commands){
        
            //커맨드 실행
            if(command.equals("prev")){
                curSec -= 10;
                curSec = Math.max(curSec, 0);
            }
            
            if(command.equals("next")){
               curSec += 10;
                curSec = Math.min(curSec, videoMax);
            }
            
               
            if(opStartSec <= curSec && curSec <= opEndSec){
                curSec = opEndSec;
            }
            
        }
        
        String answer = secondToMin(curSec);
        return answer;
    }
    
    public int timeToSec(String time){
        int minute = Integer.parseInt(time.substring(0,2));
        int second = Integer.parseInt(time.substring(3,5));
        
        return minute * 60 + second;
    }
    
    public String secondToMin(int second){
        int min = second / 60;
        int sec = second % 60;
        String answer = "";
        
        if(min < 10){
            answer += "0" + min;
        }
        else {
            answer += min;
        }
        
        if(sec < 10){
            answer += ":" + "0" + sec;
        }
        else {
            answer += ":" + sec;
        }
        
        return answer;
    }
    
}