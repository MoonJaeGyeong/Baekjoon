class Solution{
 public static String solution(String new_id) {
        String answer = "";
        String id = "";
        int dot_c = 0;
        if(new_id == null)
            new_id = "";

        new_id = new_id.toLowerCase(); // 1단계

        for(int i=0; i<new_id.length(); i++){
            char c = new_id.charAt(i);
            int asc = (int) c;
            if ( c == '.' && (i==0 || i == new_id.length()-1) ) // 4단계
                continue;

            if(c == '-' || c == '_' || c == '.'  || (asc >= 97 && asc <= 122) || (asc >= 48 && asc <= 57) ) {
                if(c == '.' )
                    dot_c++;
                else
                    dot_c = 0;

                if(dot_c >= 2 ) // 3단계
                    continue;
                else
                    id += c;
            }

        }
        int length = id.length();


        if(id == "" || id.equals(".") ) // 5단계
            id = "a";

        if(id.charAt(0) == '.')
            id = id.substring(1,id.length());

        if(length>=16) // 6단계
            id = id.substring(0,15);

        if(id.charAt(id.length()-1) == '.')
            id = id.substring(0,id.length()-1);

        while(id.length() < 3){ // 7단계
            id += id.substring(id.length()-1,id.length());
        }



        answer = id;
        return answer;
    }
    
}