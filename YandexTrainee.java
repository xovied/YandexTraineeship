/* 
https://contest.yandex.ru/contest/57286/problems/
Дан текст из строчных английских букв, пробелов и запятых. 
Пусть len равно максимальной длине слова в тексте, умноженной на 3
Вам необходимо отформатировать текст следующим образом:
в каждой строке должно быть не более len символов
запятая «приклеивается» к слову перед ней, то есть должна находиться на одной строке с ним
перед запятой пробел не ставится 
после запятой пробел ставится, если она не является последним символом строки
если слово не входит на строку i, строка i заканчивается, 
а слово будет записано на строке 
(i+1)
последним символом в любой строке должна быть буква или запятая
Формат ввода
В единственной строке ввода находится строка w
1≤∣w∣≤10 из строчных английских букв, запятых и пробелов.

Гарантируется, что:

в тексте между любыми двумя запятыми есть непустое слово
текст начинается с буквы
в тексте нет двух пробелов подряд

Ex1
Input:
once upon a time, in a land far far away lived a princess , whose beauty was yet unmatched
Output:
once upon a time, in a land
far far away lived a
princess, whose beauty was
yet unmatched

Ex2
Input:
a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,yandex
Output:
a, b, c, d, e, f,
g, h, i, j, k, l,
m, n, o, p, yandex
*/

import java.util.Scanner;

public class YandexTrainee {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine(); 
        
        String[] strs = input.split(",");
        String sum = "";
        int i;
        for (i = 0; i < (strs.length); i++)
        {
            strs[i] =  strs[i].trim() + ", ";
            sum += strs[i];
        }
        
        i--;
        if ((input.toCharArray())[input.length()-1] != ',')
        {
            sum = sum.substring(0, sum.length()-2);
        }
        
        String[] words = sum.split(" ");
        
        int len = 0;
        for(i = 0; i < words.length; i++)
        {
            int tmp = words[i].length();
            if (words[i].indexOf(',') != -1) tmp--;
            len = len < tmp ? tmp : len;
        }
        
        int longLen = len*3;
        String currentString = "";
        for(i = 0; i < words.length; i++)
        {
            if (currentString.length() + words[i].length() <= longLen)
            {
                currentString += words[i] + " ";
            }
            else
            {
                System.out.println(currentString.substring(0, currentString.length()-1));
                currentString = words[i] + " ";
            }
        }
        System.out.println(currentString.substring(0, currentString.length()-1));
    }
}