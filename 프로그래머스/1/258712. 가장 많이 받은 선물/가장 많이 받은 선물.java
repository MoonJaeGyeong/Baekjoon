class Solution {
     public  int solution(String[] friends, String[] gifts){
        int friendsLength = friends.length;
        int giftExcel[][] = new int[friendsLength][friendsLength];
        int giftIndex[][] = new int[friendsLength][2];
        int max = -1;

        for(String gift : gifts){
            String sender = paraseString(gift)[0];
            String receiver = paraseString(gift)[1];

            int senderIndex = getIndex(friends,sender);
            int receiverIndex = getIndex(friends, receiver);

            giftIndex[senderIndex][1]++;
            giftIndex[receiverIndex][1]--;

            giftExcel[senderIndex][receiverIndex]++;
        }
        for(int i=0; i<giftExcel.length; i++){
            int giftNumber = 0;
            for(int j=0; j<giftExcel.length; j++){

                if(i!=j){
                    if(giftExcel[i][j] == giftExcel[j][i]){
                        if(giftIndex[i][1] > giftIndex[j][1]){
                            giftNumber++;
                        }
                    }
                    if(giftExcel[i][j] > giftExcel[j][i]){
                        giftNumber++;
                    }
                }
            }
            if(max < giftNumber){
                max = giftNumber;
            }
        }

        return max;
    }

    public  int getIndex(String[] friends, String s){
        int i = 0;
        for(String friend : friends){
            if(friend.equals(s)){
                break;
            }
            i++;
        }
        return i;
    }

    public  String[] paraseString(String gift){
        return gift.split(" ");
    }
}