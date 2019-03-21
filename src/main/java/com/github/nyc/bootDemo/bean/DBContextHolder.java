package com.github.nyc.bootDemo.bean;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 15:00 2019/3/21
 * @Description
 **/
import com.github.nyc.bootDemo.enums.DBTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class DBContextHolder {
    private static Logger logger = LoggerFactory.getLogger(DBContextHolder.class);

    private static final ThreadLocal<DBTypeEnum>  CONTEXT_HOLDER = new ThreadLocal<>();

    private static final AtomicInteger COUNTER = new AtomicInteger(-1);

    public static void set(DBTypeEnum dbType) {
        CONTEXT_HOLDER.set(dbType);
    }

    public static DBTypeEnum get() {
        return CONTEXT_HOLDER.get();
    }

    public  static void remove(){
        CONTEXT_HOLDER.remove();
    }

    public static void master() {
        set(DBTypeEnum.MASTER);
        logger.info("切换到master");
    }

    public static void slave() {
        //  轮询
        int index = COUNTER.getAndIncrement() % 2;
        if (COUNTER.get() > 9999) {
            COUNTER.set(-1);
        }
        if (index == 0) {
            set(DBTypeEnum.SLAVE1);
            logger.info("切换到slave1");
        }else {
            set(DBTypeEnum.SLAVE2);
            logger.info("切换到slave2");
        }
    }

}
