import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SetTestWithMap {
    public static void main(String[] args) {
        HashMap<String, Integer> b = new HashMap<String, Integer>();
        b.put("one", 1);
        //b.put("two", 2);
        b.put("three", 3);
        
        
        HashMap<String, Integer> a = new HashMap<String, Integer>();
        a.put("one", 1);
        a.put("two", 2);
        //a.put("three", 3);
        a.put("three", 7); //Map는 뒤에 다시 put을 하면 덮어쓴다.
        a.put("four", 4);
        
        System.out.println(a.get("one"));
        System.out.println(a.get("two"));
        System.out.println(a.get("three"));
        System.out.println(a.get("four"));
         
        iteratorUsingForEach(a,b);
        //iteratorUsingIterator(a);
        
        //A.addAll(B);
        //A.retainAll(B);
        //A.removeAll(B);
    }
    static void iteratorUsingForEach(HashMap mapA,HashMap mapB){
        Set<Map.Entry<String, Integer>> entriesA = mapA.entrySet();
        Set<Map.Entry<String, Integer>> entriesB = mapB.entrySet();
        
        System.out.println("size of mapA :"+mapA.size()+"size of mapB :"+mapB.size());
        
        entriesA.retainAll(entriesB);
        for (Map.Entry<String, Integer> entry : entriesA) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        
        System.out.println("size of mapA :"+mapA.size()+"size of mapB :"+mapB.size());
        //entriesA = mapA.entrySet();
        //entriesB = mapB.entrySet();
        
        
//        entriesA.retainAll(entriesB);
//        for (Map.Entry<String, Integer> entry : entriesA) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
//        System.out.println("size of mapA :"+mapA.size()+"size of mapB :"+mapB.size());
    }
    
    //map으로 다시 환원하는 구문
//    Map<Integer, String> map = new HashMap<Integer, String>();
//    //fill in map
//    Set<Entry<Integer, String>> set = map.entrySet();
//
//    Map<Integer, String> mapFromSet = new HashMap<Integer, String>();
//    for(Entry<Integer, String> entry : set)
//    {
//        mapFromSet.put(entry.getKey(), entry.getValue());
//    }
//    
    static void iteratorUsingIterator(HashMap map){
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> i = entries.iterator();
        while(i.hasNext()){
            Map.Entry<String, Integer> entry = i.next();
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
}
