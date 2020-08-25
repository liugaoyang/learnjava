package com.javaguide.learnjava;

import com.javaguide.learnjava.enums.HumanEnum;
import com.javaguide.learnjava.netty.NettyClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootTest
class LearnjavaApplicationTests {



    @Test
    void contextLoads() {
    }
    @Test
    void testArrayList(){
        /*String[] array = new String[2];
        array[0] = "1";
        array[1] = "2";
        System.out.println("返回1"+array.length);
        array = Arrays.copyOf(array,4);
        array[3] = "3";
        System.out.println("返回2"+array.length);*/
        List<Long> list = new ArrayList<>();
        list.add(1l);
        list.add(20l);
        list.add(11l);
        list.add(10l);
        System.out.println("zuida:"+ Collections.max(list));

    }
    @Test
    void testfailfast(){
        List<String> list=new ArrayList<>();
        for (int i = 0; i <6 ; i++) {
            list.add(String.valueOf(i));
        }
        /*for (int i=0;i<list.size();i++) {
            if(list.get(i).equals("2")){
                list.remove(i);
            }
        }*/
        for (String s:list) {
            if(s.equals("0")){
                list.set(0,"9");
            }
        }

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String s= iterator.next();
            if(s.equals("3")){
                iterator.remove();
            }
        }
        System.out.println("failfast:"+list);
    }

    @Test
    void testEnum(){
        HumanEnum humanEnum1 = HumanEnum.MAN;
        HumanEnum humanEnum2 = HumanEnum.WOMEN;
        System.out.println("第一个人是"+humanEnum2.getName());
        System.out.println(new Date((new Date()).getTime() + 600000));
    }
    @Test
    void testSet(){
        HashMap<Integer,Set<Integer>> map = new HashMap<>();
        Set<Integer> set=new HashSet<>();
        set.add(1);
        set.add(3);
        map.put(10001,set);
        Set<Integer> set2 =  map.get(10001);
        set2.add(5);
        System.out.println(map.get(10001));
    }

}
