package com.demo01;

import com.demo01.bean.Pet;
import com.demo01.bean.User;
import com.demo01.config.Myconfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        //1. IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //2.查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        //3. 从容器里获取组件
        Pet tom01 = run.getBean("tom", Pet.class);
        Pet tom02 = run.getBean("tom", Pet.class);
        System.out.println("组件: "+(tom01==tom02));

        Myconfig myconfig = run.getBean(Myconfig.class);
        System.out.println(myconfig);

        User user = myconfig.user01();
        User user1 = myconfig.user01();
        System.out.println(user == user1);
    }
}
