package org.day1;

import org.GetInput;
import org.Line;

import java.util.ArrayList;
import java.util.Collections;

public class Main1Part1 {
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

        Collections.sort(leftSide);
        Collections.sort(rightSide);

        System.out.println(compareSides(leftSide, rightSide));
    }

    public static int compareSides(ArrayList<Integer> left, ArrayList<Integer> right){
        int sum = 0;

        for(int i = 0; i < left.size(); i++){
            sum += Math.abs(right.get(i) - left.get(i));
        }

        return sum;
    }
}
