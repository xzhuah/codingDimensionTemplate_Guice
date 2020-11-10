package common.utils;

import com.google.inject.ImplementedBy;

/**
 * Created by Xinyu Zhu on 2020/11/9, 21:26
 * common.utils in codingDimensionTemplate
 */
@ImplementedBy(SingletonUtilsImpl.class)
public abstract class SingletonUtils {
    public String getAString() {
        return "Abstract SingletonUtils";
    }
}
