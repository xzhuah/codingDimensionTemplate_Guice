package common;

import com.google.inject.AbstractModule;
import common.utils.SingletonUtils;
import common.utils.SingletonUtilsImpl;

/**
 * Created by Xinyu Zhu on 2020/11/9, 21:12
 * common in codingDimensionTemplate
 */
public class CommonModule extends AbstractModule {

    @Override
    protected void configure() {
        super.configure();
        // bind any service class here if you want to use inject on them
        // ExampleUtils is not expected to be used as a service, so we don't bind it here
        // SingletonUtils is expected to be used as a service, so we bind it here

        // bind(SingletonUtils.class).to(SingletonUtilsImpl.class);
        // But we already have @ImplementedBy(SingletonUtilsImpl.class) in the interface, which does the same thing
        // as binding it here, so we don't need to bind it, please choose your own style and use it consistently

        // For common layer, most of the class should not need to be bind

    }
}
