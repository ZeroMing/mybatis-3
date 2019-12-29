package org.mybatis.leolee;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * @description: 拦截器示例
 * @author: 李明
 * @company: 朴新教育
 * @version:
 * @date: 2019/6/5 17:45
 */
@Intercepts({
        @Signature(type = Executor.class,method = "query", args = {
                MappedStatement.class, Object.class, RowBounds.class,
                ResultHandler.class }),
        //@Signature(type= ResultSetHandler.class,method="handleResultSets",args= Statement.class)
})
public class LeoLeePlugin implements Interceptor {


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("执行测试拦截器链......");
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        // 包装类
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
