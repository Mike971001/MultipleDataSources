package com.demo.list;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: 今天不加班
 * @date: 2024/4/3 13:16:26
 * @description: 测试list去重的方法 参考：https://developer.aliyun.com/article/1038691
 */
@Slf4j
public class ListTest {

    /**
     * 准备的原始list
     */
    private static List<Integer> originList = new ArrayList<>();

    static {
        originList.addAll(Lists.list(1,1,2,3,3,3,4,5,6,7,7,8,8,9,9,9));
    }

    @Test
    @DisplayName("1:使用java8新特性stream进行List去重 （distinct()方法）")
    public void distinctMethod1(){
        //转换为stream流
        List<Integer> targetList = originList.stream()
                // 调用去重方法
                .distinct()
                // 转换为List返回
                .collect(Collectors.toList());
        log.info("原来的list数据: {}",originList);
        log.info("去重后list数据: {}",targetList);
    }

    @Test
    @DisplayName("2:借助Set的特性进行去重（set和list转换去重 ）")
    public void distinctMethod2(){
        // 判断条件, 判断原始的list不为空
        final boolean judgment = null != originList && originList.size() >0 ;
        // 目标输出的结果list
        List<Integer> targetList = new ArrayList<>();
        if (judgment){
            // 中间用来去重的Set 中间变量
            Set<Integer> targetSet = new HashSet<Integer>();
            // 全部添加到set,set会自动去重
            targetSet.addAll(originList);
            // 将去重后的set直接放入目标list中，就可以直接完成去重的工作
            targetList.addAll(targetSet);
        }

        log.info("原来的list数据: {}",originList);
        log.info("去重后list数据: {}",targetList);
    }

    @Test
    @DisplayName("3：遍历List集合,将元素添加到另一个List集合中")
    public void distinctMethod3() {
        // 结果的目标对象
        ArrayList<Integer> targetList = new ArrayList<>();
        // 遍历原始的list
        for (Integer originInteger : originList) {
            // 判断目标List中是否包含原来List中的元素，没有添加。
            if (!targetList.contains(originInteger)){
                targetList.add(originInteger);
            }
        }
        // 输出结果
        log.info("原来的list数据: {}",originList);
        log.info("去重后list数据: {}",targetList);
    }

    @Test
    @DisplayName("4，利用set集合特性保持顺序一致去重,方法2的升级版本")
    public void distinctMethod4(){
        // set优化方法1
        List<Integer> targetList = new ArrayList<>(new TreeSet<>(originList));

        // set优化方法2
        List<Integer> targetList1= new ArrayList<>(new LinkedHashSet<>(originList));

        log.info("原来的list数据: {}",originList);
        log.info("set优化方法1输出结果: {}",targetList);
        log.info("set优化方法2输出结果: {}",targetList1);
    }

    @Test
    @DisplayName("5，使用list自身方法remove()–>不推荐")
    public void distinctMethod5(){
        log.info("原来的list数据: {}",originList);

        // 首先判断集合不为空,开始循环的前后比较
        final boolean judgment = originList != null && originList.size() > 0;
        // 条件成立
        if (judgment){
            for (int i = 0; i < originList.size(); i++) {
                for (int j = 0; j < originList.size() - 1; j++) {
                    // 开始前后比较 前(i)后(j)如果相同移除后面的元素.list本来就是有序的。但是这个方法的效率太低了
                    if (originList.get(i).equals(originList.get(j))) {
                        originList.remove(j);
                    }
                }
            }
        }
        // 输出结果
        log.info("去重后list数据: {}",originList);
    }
}
