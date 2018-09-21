package seeto.c2.artoria.us.myapplication.UI.QM;

import java.util.ArrayList;

public class KMP {
    int[] getPi(String p){
        int n = p.length();
        int j=0;
        int[] pi = new int[n];
        for(int i=1; i<n; i++){
            while(j > 0 && p.charAt(i) != p.charAt(j)) j = pi[j-1];
            if(p.charAt(i) == p.charAt(j)) pi[i] = ++j;
        }
        return pi;
    }

    ArrayList<Integer> kmp(String s, String p){
        ArrayList<Integer> ret = new ArrayList<>();
        int[] pi = getPi(p);
        int n = s.length();
        int m = p.length();
        int j = 0;
        for(int i=0; i<n; i++){
            while(j>0 && s.charAt(i) != p.charAt(j)) j = pi[j-1];
            if(s.charAt(i) == p.charAt(j)){
                if(j == m-1){
                    ret.add(i-m+1);
                    j = pi[j];
                }else{
                    j++;
                }
            }
        }
        return ret;
    }
}