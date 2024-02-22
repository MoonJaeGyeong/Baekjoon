import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] subject = new String[20];
        String[][] text = new String[20][3];

        double scoreSum = 0;
        double subjectSum = 0;

        for(int i=0; i<subject.length; i++){
            subject[i] = scanner.nextLine();
            text[i] = subject[i].split(" ");
        }

        for(int i=0; i<20; i++){
            if(!text[i][2].equals("P")){
                double subjectCredit = Double.parseDouble(text[i][1]);
                subjectSum += subjectCredit;
                scoreSum += subjectCredit * Grade.getValueBySymbol(text[i][2]);
            }
        }

        System.out.println(scoreSum / subjectSum);

    }


}
enum Grade {
    A_PLUS("A+", 4.5),
    A_ZERO("A0", 4.0),
    B_PLUS("B+", 3.5),
    B_ZERO("B0", 3.0),
    C_PLUS("C+", 2.5),
    C_ZERO("C0", 2.0),
    D_PLUS("D+", 1.5),
    D_ZERO("D0", 1.0),
    F("F", 0.0);

    private static final Map<String, Double> gradeMap = new HashMap<>();

    static {
        for (Grade grade : Grade.values()) {
            gradeMap.put(grade.getSymbol(), grade.getValue());
        }
    }

    private final String symbol;
    private final double value;

    Grade(String symbol, double value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getValue() {
        return value;
    }

    public static double getValueBySymbol(String symbol){
        return gradeMap.get(symbol);
    }
}
