package common.utils;

import com.google.inject.Singleton;

import java.util.Random;

/**
 * Created by Xinyu Zhu on 2020/11/9, 21:22
 * common.utils in codingDimensionTemplate
 */
@Singleton
public class SingletonUtilsImpl extends SingletonUtils {

    private String randomInt;

    public SingletonUtilsImpl() {
        // Generate a random int to show the effect of singleton
        Random rand = new Random();
        rand.setSeed(rand.nextInt());
        randomInt = String.valueOf(rand.nextInt(1000));
    }

    @Override
    public String getAString() {
        return "Example String:" + randomInt;
    }

    public static void main(String[] args) {
        // You should not use this, this just show that you can do this
        // but you shouldn't, use injector to get instance instead
        SingletonUtils singletonUtils = new SingletonUtilsImpl();
        SingletonUtils singletonUtils2 = new SingletonUtilsImpl();

        // Singleton Annotation does not really make it Singleton
        // it just ensure that guice will always use the same instance
        // You can still create multiple instance by yourself
        System.out.println(singletonUtils.getAString());
        System.out.println(singletonUtils2.getAString());
    }
}
