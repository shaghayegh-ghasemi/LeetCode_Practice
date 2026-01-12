import java.util.ArrayList;
import java.util.Arrays;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids){
        ArrayList<Integer> list = new ArrayList<>();

        for(int asteroid: asteroids){
            if(asteroid > 0) list.add(asteroid);
            else{
                while (!list.isEmpty() && list.getLast() > 0 && list.getLast() < Math.abs(asteroid)){
                    list.removeLast();
                }

                if(!list.isEmpty() && list.getLast() == Math.abs(asteroid)) list.removeLast();
                else if (list.isEmpty() || list.getLast() < 0) {
                    list.add(asteroid);
                }
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args){
        AsteroidCollision solution = new AsteroidCollision();

        int[][] tests = {
                {5,10,-5},
                {8,-8},
                {10,2,-5},
                {-2,-1,1,2},
                {1,-2,-2,-2},
                {2,1,-1,-2},
                {3,5,-2,-5,6},
                {}
        };

        int[][] expected = {
                {5,10},
                {},
                {10},
                {-2,-1,1,2},
                {-2,-2,-2},
                {},
                {3,6},
                {}
        };

        for (int i = 0; i < tests.length; i++){
            int[] out = solution.asteroidCollision(tests[i]);
            System.out.println("Input:    " + Arrays.toString(tests[i]));
            System.out.println("Output:   " + Arrays.toString(out));
            System.out.println("Expected: " + Arrays.toString(expected[i]));
            System.out.println();
        }
    }


}

// problem description: https://leetcode.com/problems/asteroid-collision/description/