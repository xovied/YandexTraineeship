/*
https://contest.yandex.ru/contest/57286/problems/B/
*/
import java.util.Scanner;

public class YandexTrainee2 {
    public static void main(String[] args) {
        // Ввод
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String[] words = new String[N];
        int Q = in.nextInt();
        int[] pos = new int[Q];
        String[] prefix = new String[Q];
        for (int i = 0; i < N; i++)
        {
            words[i] = in.next();
        }
        for (int i = 0; i < Q; i++)
        {
            pos[i] = in.nextInt();
            prefix[i] = in.next();
        }
        
        // Начало работы
        for (int i = 0; i < Q; i++)
        {
            int ans = -1;
            int x = binarySearchOfFirst(words, prefix[i]);
            if ( prfx(words[x], prefix[i]) )
            {
                if (x + pos[i] - 1 < words.length)
                {
                    if ( prfx(words[x+pos[i]-1], prefix[i]))
                    {
                        ans = x + pos[i];
                    }
                }
            }
            
            System.out.println(ans);
        }
        
    }
    
    static boolean prfx(String a, String b)
    {
        if (a.length() < b.length()) return false;
        
        boolean res = true;
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
       
        for (int i = 0; i < bb.length; i++)
        {
            if (aa[i] != bb[i])
            {
                res = false;
                break;
            }
        }
        return res;
    }
    
    private static int binarySearchOfFirst(String[] words, String prefix) {
        int index = -1;
        
        int low = 0;
        int high = words.length-1;
        
        if (prefix.compareTo(words[high]) > 0)
            return index;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int x = prefix.compareTo(words[mid]);
            if (x > 0)
                low = mid + 1;
            else if (x < 0)
                high = mid - 1;
            else
                {
                    index = mid;
                    break;
                }
        }
        if (index == -1) index = low;
        return index;
    }
}