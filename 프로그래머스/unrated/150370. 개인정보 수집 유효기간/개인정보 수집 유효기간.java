

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

     class Solution {
        public  int[] solution(String today, String[] terms, String[] privacies) {

            HashMap<String, Integer> term = new HashMap<>();
            LocalDate todayDate = LocalDate.parse(today.replace(".", "-"));
            String[] end = new String[privacies.length];
            int k =0;

            for(int i=0; i<terms.length; i++){
                String[] person = terms[i].split("\\s"); // 사람 이름과 기간
                int month = Integer.parseInt(person[1]);
                term.put(person[0], month);
            }

            for(int i=0; i<privacies.length; i++){
                String[] sp = privacies[i].split("\\s"); // 등록 날짜와 사람

                LocalDate date = LocalDate.parse(sp[0].replace(".", "-"));
                int month = term.get(sp[1]);

                date=date.plusMonths(month);
                date=date.minusDays(1);

                end[i] = date.toString();
            }
            ArrayList<Integer> result = new ArrayList<>();

            for(int i=0; i<end.length; i++){
                LocalDate date = LocalDate.parse(end[i].replace(".", "-"));
                k++;
                if(date.isBefore(todayDate))
                    result.add(k);
            }

            int[] answer = new int[result.size()];
            for(int i=0; i<result.size(); i++)
                answer[i] = result.get(i);

            return answer;
        }


     
    }



