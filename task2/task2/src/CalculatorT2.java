import java.util.*;

public class CalculatorT2 {
    public static void main(String[] args){
        char grade;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Subjects: ");
        int n= sc.nextInt();
        int totalM=0;
        for(int i=0; i<n; i++){
            System.out.print("Enter your Marks for subject "+ (i+1)+" (out of 100): ");
            int marks= sc.nextInt();
            totalM+=marks;
        }

        double avg= totalM / n;

        if(avg>=90){
            grade='A';
        }else if(avg >= 80) {
            grade='B';
        } else if(avg >= 70) {
            grade='C';
        } else if(avg >= 60) {
            grade='D';
        } else if(avg >= 50) {
            grade='E';
        } else{
            grade='F';
        }

        System.out.println("Gardecard: ");
        System.out.println("Total marks out of "+ n*100 +" is: " + totalM);
        System.out.println("Average Percentage : "+avg+ " %");
        System.out.println("Grade : "+ grade);
        System.out.println("Thank You!");
    }
}
