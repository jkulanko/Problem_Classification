import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int cat = in.nextInt();
        HashMap<String,Integer> h = new HashMap();
        ArrayList<ArrayList<String>> a = new  ArrayList<ArrayList<String>>();
        String[] s = new String[cat];

        in.nextLine();
        for(int i = 0;i<cat;i++){
            ArrayList<String> b = new ArrayList();
            String[] c = in.nextLine().split(" ");
            s[i] = c[0];

            int n = Integer.parseInt(c[1]);
            for(int j = 0; j <n;j++) {
                b.add(c[j+2]);
            }
            a.add(b);

        }
        StringBuilder p = new StringBuilder("");
        while(in.hasNextLine()){
            p.append(" "+in.nextLine());
            //in.nextLine();
        }
String[] st = p.toString().split(" ");

        for(int i = 0;i<st.length;i++){
            if(!h.containsKey(st[i])){
                h.put(st[i],1);
            }
            else
            {
                h.put(st[i],h.get(st[i])+1);
            }
        }
        HashMap<String,Integer> hash = new HashMap<>();
        int max = 0;
        for(int i = 0;i<cat;i++){
            int count = 0;
            for(int j = 0; j<a.get(i).size();j++){
               count+= h.getOrDefault(a.get(i).get(j),0);
              //System.out.println(a.get(i).get(j));
            }
            hash.put(s[i],count);
           max =  Math.max(max, count);
           // System.out.println(max);
        }
        ArrayList<String> e = new ArrayList<>();
        for(String Key:hash.keySet()){
            if(hash.get(Key)==max)
                e.add(Key);

        }
        Collections.sort(e);
        for(int i = 0; i<e.size();i++){
            System.out.println(e.get(i));
        }
    }
}
