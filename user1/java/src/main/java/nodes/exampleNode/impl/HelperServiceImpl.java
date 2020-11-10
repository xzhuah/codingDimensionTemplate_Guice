package nodes.exampleNode.impl;

import com.google.inject.Singleton;

/**
 * Created by Xinyu Zhu on 2020/11/9, 21:07
 * nodes.exampleNode.impl in codingDimensionTemplate
 */
@Singleton
public class HelperServiceImpl implements nodes.exampleNode.HelperService {

    private static int seed = 0;
    private int dynamic;
    // Imagine this is a backend service needed in ExampleService
    public HelperServiceImpl() {
        // You can add Singleton annotation to this class and see what will happen
        seed += 1;
        dynamic = 0;
    }
    @Override
    public String getCurrentTimeInString() {
        dynamic += 1;
        return String.valueOf(seed + ":" + dynamic);
    }
}
