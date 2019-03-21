package com.github.nyc.bootDemo.bean;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 15:01 2019/3/21
 * @Description
 **/
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

public class MyRoutingDataSource extends AbstractRoutingDataSource {
    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        return DBContextHolder.get();
    }

}
