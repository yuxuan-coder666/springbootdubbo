# SpringBoot-dubbo

![](https://img.shields.io/badge/build-passing-brightgreen) ![](https://img.shields.io/badge/JDK-1.8.0-orange) ![](https://img.shields.io/badge/SpringBoot-2.1.5.RELEASE-brightgreen) ![](https://img.shields.io/badge/license-MIT-blue)



## 项目简介

该项目集成了springboot和dubbo。下载即用，上手简单，极大的缩短了开发时间。开发时无需再次封装任何东西。开发者只需关注业务的实现。项目中有业务逻辑的demo实现，相信您一看就能明白。本项目完全适用中小型项目的开发工作。


其中springbootdubbo-commons是一个直接引用就可使用的插拔式工程。可直接作为`jar`包进行引用。该工程包含`SpringBoot`的基本组件及一些`公共的方法`，如`json转换`、`主键生成`、`日期转换`、`文件上传下载`等。
引用此工程的项目，无需在引用其他springboot组件，就可实现springboot项目所需的所有条件。且会根据生成的POJO创建相应的增删改查方法（增删改查支持批量处理）。在项目中不会生成冗余代码，也无需新建过多的类。代码中都有相应的注释及使用方法。

**目前项目中已成功集成dubbo(rpc调用)、logback(日志)、aop(AOP拦截器)、统一异常处理、JPA(强大的ORM框架)、mybatis(强大的ORM框架)、PageHelper(通用的Mybatis分页插件)、swagger(API接口管理测试)**
> 后续我会增加更多的内容，敬请期待。

## 开发环境
- JDK 1.8 +
- Maven 3.5 +
- IDEA或Eclipse，同时保证安装 lombok 插件
- Mysql 5.7 + (尽量保证使用 5.7 版本以上，因为 5.7 版本加了一些新特性，同时不向下兼容。本 工程里会尽量避免这种不兼容的地方，但还是建议尽量保证 5.7 版本以上)

## 运行方式
1. git clone 
2. 使用 IDEA 打开 clone 下来的项目
3. 在 IDEA 中 Maven Projects 的面板导入项目根目录下 的 pom.xml 文件
4. Maven Projects 找不到的童鞋，可以勾上 IDEA 顶部工具栏的 View -> Tool Buttons ，然后 Maven Projects 的面板就会出现在 IDEA 的右侧
5. 找到各个 Module 的 Application 类就可以运行各个 demo 了
6. 注意：每个 demo 均有详细的 README 配套，食用 demo 前记得先看看哦~
7. 注意：运行各个 demo 之前，有些是需要事先初始化数据库数据的，亲们别忘记了哦~

> 欢迎大家提出宝贵的建议。
