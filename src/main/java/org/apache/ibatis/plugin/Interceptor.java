/**
 *    Copyright 2009-2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.plugin;

import java.util.Properties;

/**
 * @author Clinton Begin
 */
public interface Interceptor {

  /**
   * 执行拦截逻辑的方法
   * @param invocation
   * @return
   * @throws Throwable
   */
  Object intercept(Invocation invocation) throws Throwable;

  /**
   * 返回增强的对象
   * @param target 被代理对象
   * @return 增强的target
   */
  Object plugin(Object target);

  /**
   * 获取property name="someProperty" 的值，得到配置文件的值
   * <plugins>
   *   <plugin interceptor="org.mybatis.example.LeoLeePlugin">
   *     <property name="someProperty" value="100"/>
   *   </plugin>
   * </plugins>
   * @param properties
   */
  void setProperties(Properties properties);

}
