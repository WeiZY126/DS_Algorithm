package Algorithm.Demo05greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Greedy {
    public static void main(String[] args) throws Exception {
        //创建广播电台，放到Map
        Map<String, HashSet<String>> broadCasts = new HashMap<>();
        //放入各个电台放入broadCasts
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadCasts.put("k1", hashSet1);
        broadCasts.put("k2", hashSet2);
        broadCasts.put("k3", hashSet3);
        broadCasts.put("k4", hashSet4);
        broadCasts.put("k5", hashSet5);

        HashSet<String> allAreas = new HashSet<String>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        //创建ArrayList，存放选择的电台集合
        ArrayList<String> selects = new ArrayList<>();

        //创建一个临时的集合，遍历过程中存放电台和还没有覆盖的交集
        HashSet<String> temp = new HashSet<>();

        //定义maxkey，保存在一次遍历过程中能够覆盖最大地区电台key
        String maxKey = null;
        while (!allAreas.isEmpty()){
            maxKey = null;
            temp.clear();
            for (String key : broadCasts.keySet()) {
                HashSet<String> areas = broadCasts.get(key);
                temp.addAll(areas);
                //求temp和Allareas集合的交集,会赋给temp
                temp.retainAll(allAreas);
                //如果当前集合包含未覆盖地区的数量比maxKey指向的集合未覆盖地区还要多
                if (temp.size()>0&&(maxKey==null||temp.size()>broadCasts.get(maxKey).size()))
                    maxKey = key;
            }
            if (maxKey!=null){
                selects.add(maxKey);
                allAreas.remove(broadCasts.get(maxKey));
            }
        }
    }
}
