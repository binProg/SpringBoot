package com.demo01.config;

import com.demo01.bean.Pet;
import com.demo01.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 1. 配置类中使用@Bean标注在方法上给容器注册组件，默认是单实例的
 * 2. 配置类本身也是组件
 * 3. proxyBeanMethods: 代理bean的方法
 *      Full(全配置 true）: 保持组件单实例
 *      Lite（轻量级 false）
 *      有组件依赖：FUll
 *      无组件依赖：Lite
 */
@Configuration(proxyBeanMethods = false) //告诉springboot这是一个配置类 == 配置文件
public class Myconfig {

    /**
     * 外部无论对配置类中的这个组件注册方法调用多少次，获取的都是之前注册到容器中的单实例对象
     * @return
     */
    @Bean //给容器添加组件。以方法名为组件的id，返回类型就是组件的类型。返回的值，就是组件在容器中的实列
    public User user01(){
        User zhangsan = new User("zhangsan",18);
        zhangsan.setPet(tomcatPet());//如果proxyBeanMethod是true，则容器中的pet就是zhangsan的pet，组件依赖是正确的
        return zhangsan;
    }

    @Bean("tom")
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }
}
