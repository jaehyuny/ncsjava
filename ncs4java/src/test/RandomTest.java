package test;

import java.util.HashMap;
import java.util.Iterator;

public class RandomTest {
	static final int REPETITION = 100;
	 
    public static void main(String[] args) {
        // A�� ����ġ�� �ٸ� ���� �� ��� �Ѵ�.
        String[] data = { "A", "A", "B", "C" };
 
        HashMap map = new HashMap();
 
        for (int i = 0; i < REPETITION; i++) {
        	String temp = getRandArr(data);    // �迭�� ����� �� �� �ϳ��� ��ȯ�Ѵ�(����)
            if (map.containsKey(temp)) {
                Integer value = (Integer) map.get(temp);
                map.put(temp, new Integer(value.intValue() + 1));
            } else {
                map.put(temp, new Integer(1));
            }
        }
 
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            Integer value = (Integer) map.get(key);
            int intValue = value.intValue();
            System.out.println(key + " : " + printGraph('#', intValue) + intValue);
        }
    }
 
    private static String printGraph(char ch, int value) {
        char[] bar = new char[value];
 
        for (int i = 0; i < bar.length; i++) {
            bar[i] = ch;
        }
 
        return new String(bar);
    }
 
    private static String getRandArr(String[] arr) {
        return arr[getRand(arr.length - 1)]; // �迭�� ����� �� �� �ϳ��� ��ȯ�Ѵ�.
    }
 
    private static int getRand(int n) {
        return getRand(0, n);
    }
 
    private static int getRand(int from, int to) {
        return (int) (Math.random() * (Math.abs(to - from) + 1)) + Math.min(from, to);
    }
 
}


