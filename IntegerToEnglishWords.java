package LeetCode;
// Microsoft, Amazon, Oracle, Zoho
//273
import java.util.*;
public class IntegerToEnglishWords {
    public String numberToWords(int num) {
//        int numOfDigits = numOfDigits(num);
        if(num == 0){
            return "Zero";
        }
        String ans = "";
        ans+= createString((num/1000000000),"Billion");
        ans+= createString((num/1000000)%1000,"Million");
        ans+= createString((num/1000)%1000,"Thousand");
        ans+= createString((num%1000),"");

        return ans;
    }
    private String createString(int num, String suffix){
        String[] ones = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] tens = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

        String s = "";
        if(num>19 && num<100){
            s += tens[num/10] + " "+ ones[num%10];
        }else if(num>=100){
            s += ones[num/100]+" Hundred "+createString(num%100,"");
        }
        else{
            s += ones[num];
        }
        if(num>0){
            s += suffix;
        }
        return s;

    }

    public static void main(String[] args) {
        IntegerToEnglishWords num = new IntegerToEnglishWords();
        System.out.println(num.numberToWords(100));
    }

}
