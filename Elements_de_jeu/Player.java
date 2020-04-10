package sample;

import java.util.ArrayList;
import java.util.List;

public class Player {
    static List<Integer> list = new ArrayList<>();

    public static int score(int x){
        list.add(x);
        int res = 0;
        for (int i: list) {
            res += i;
        }
        return res;
    }



}
