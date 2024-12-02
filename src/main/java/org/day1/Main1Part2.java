package org.day1;

import org.GetInput;
import org.Line;

import java.util.ArrayList;

public class Main1Part2 {
    public static void main(String[] args) {
        GetInput getInput;

        try {
            getInput = new GetInput("input_day1.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ArrayList<Integer> leftSide = new ArrayList<>();
        ArrayList<Integer> rightSide = new ArrayList<>();

        for(Line line: getInput.getLines()){
            String[] splitLine = line.getInput().split(" {3}");
            leftSide.add(Integer.valueOf(splitLine[0]));
            rightSide.add(Integer.valueOf(splitLine[1]));
        }

        System.out.println(getSimilarityScore(leftSide, rightSide));
    }

    public static int getSimilarityScore(ArrayList<Integer> left, ArrayList<Integer> right){
        int sum = 0;

        for(int i: left){
            int occurences = 0;
            for(int j: right){
                if(i == j){
                    occurences++;
                }
            }
            sum += i * occurences;
        }

        return sum;
    }
}
