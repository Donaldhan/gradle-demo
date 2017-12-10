[gradle offical](https://gradle.org/)  
[Gradle教程](http://www.yiibai.com/gradle/)   
[groovy offical](http://www.groovy-lang.org/)  
[Groovy教程](https://www.w3cschool.cn/groovy)  
[github bulidship](https://github.com/eclipse/buildship/blob/master/docs/user/Installation.md)

# 引言

* [安装gradle eclipse 插件buildship](#安装gradle eclipse 插件buildship)
* [jar依赖](#jar依赖)
* [项目执行](#项目执行)

本项目用于简单测试gradle项目管理工具。在测试项目前，要先安装装gradle eclipse 插件buildship。
## 安装gradle eclipse 插件buildship
在创建gradle项目的过程中，如果在线安装失败的话，可以在eclipse的Marketplace软件库中安装指定的buildship插件即可。
安装完插件到Windows-peference中配置gradle的安装目录和gradle用户目录 *D:.gradle* 文件夹，这个和maven的 *.m2* 文件夹
的作用相同。gradle项目的jar包一般在用户目录的 *caches* 下，我的是在D:\.gradle\caches\modules-2\files-2.1目录下。
## jar依赖
如果想要找到gradle项目依赖的jar的gradle依赖形式可以到[maven中心仓库](http://mvnrepository.com/)中，像搜索jar包的
maven依赖一样，搜索gradle的jar依赖，复制到gradle的项目的 *build.gradle* 配置文件中。
我们以 *spring-beans* 为例：

```
// https://mvnrepository.com/artifact/org.springframework/spring-beans
compile group: 'org.springframework', name: 'spring-beans', version: '4.3.13.RELEASE'
```
添加到项目的gradle构建配置文件 *build.gradle* 中
如下：

```
// In this section you declare the dependencies for your production and test code
dependencies {
    // The production code uses the SLF4J logging API at compile time
    //compile 'org.slf4j:slf4j-api:1.7.21'
    compile 'org.slf4j:slf4j-log4j12:1.7.21'
    // https://mvnrepository.com/artifact/org.apache.commons/commons-lang3
	compile group: 'org.apache.commons', name: 'commons-lang3', version: '3.0'
    // https://mvnrepository.com/artifact/org.springframework/spring-beans
    compile group: 'org.springframework', name: 'spring-beans', version: '4.3.13.RELEASE'
    // Declare the dependency for your favourite test framework you want to use in your tests.
    // TestNG is also supported by the Gradle Test task. Just change the
    // testCompile dependency to testCompile 'org.testng:testng:6.8.1' and add
    // 'test.useTestNG()' to your build script.
    testCompile 'junit:junit:4.12'
}
```

可以简写如 *slf4j-log4j12* 一样:

```
compile 'org.slf4j:slf4j-log4j12:1.7.21'
```

针对项目依赖下载慢的问题我们可以更换仓库地址具体如下

```
allprojects {
    repositories {
        maven{ url 'http://maven.aliyun.com/nexus/content/groups/public/'}
    }
}
```
上面的配置只能解决当前项目的依赖慢的问题，如果要解决全局的问题，参考如下链接：
[gradle更换仓库 解决下载速度慢问题](http://www.jianshu.com/p/ac4b7302200b)

# 项目执行
gradle不会自动下载jar依赖，这一点比maven好多了，maven自动检测pom是否有变化，如果依赖没有写完，就保存maven插件就会下在相应的jar包，很容易出问题，gradle这一点做的很好，jar的依赖下载需要手动更新项目，具体为：    
右击项目，*Gradle->Refresh Gradle Project* 。   

执行项目，可以先执行以下Gradle test，已检查项目的编译问题，具体如下：  
*Run As -> Gradle Test*
