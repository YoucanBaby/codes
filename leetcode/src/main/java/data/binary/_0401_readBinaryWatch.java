package data.binary;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.binary
 * @Author: xuyifang
 * @CreateTime: 2021-06-21 19:43
 * @Description:
 */
public class _0401_readBinaryWatch {

    public static void main(String[] args) {

    }


    public List<String> readBinaryWatch(int turnedOn) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
                    String res = String.format("%d:%02d", i, j);
                    list.add(res);
                }
            }
        }
        return list;
    }
}
