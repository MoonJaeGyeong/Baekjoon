import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        List<Person> person = new ArrayList<>();
        Person me = new Person(0, 0);

        for (int repeat = 0; repeat < N; repeat++) {
            int votes = Integer.parseInt(br.readLine());
            if(repeat == 0){
                me.votes = votes;
                person.add(me);
                continue;
            }

            Person voter = new Person(repeat, votes);
            person.add(voter);

        }
        Collections.sort(person);

        while (person.get(0).index != 0) {
            Person current = person.get(0);
            current.votes = current.votes - 1;
            me.votes = me.votes + 1;
            person.add(current);
            Collections.sort(person);
            answer++;
        }

        System.out.println(answer);
    }

    static class Person implements Comparable<Person> {
        int index;
        int votes;


        public Person(int index, int votes) {
            this.index = index;
            this.votes = votes;
        }

        @Override
        public int compareTo(Person other) {

            if (this.votes == other.votes) {
                return Integer.compare(other.index, this.index);
            }

            return Integer.compare(other.votes, this.votes);

        }

    }
}

