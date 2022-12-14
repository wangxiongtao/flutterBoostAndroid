# 万商服Android端 Windows jenkins 配置

##  环境安装（Android+Flutter）

* Android:

  1.AndroidSdk 安装，下载地址（https://pan.baidu.com/s/1uDKGiWw4S2x0n8rUuwAYWw?pwd=85rn）

* Flutter:

   1.环境安装参见官网(https://doc.flutterchina.club/get-started/install/)

## jenkins配置


   1.进入系统设置Configure System页面 添加全局属性

    * 键：ANDROID_HOME  值：AndroidSdk的安装目录

    * 键：PATH  值：C:\Windows\System32;C:\Windows\System32\WindowsPowerShell\v1.0\;D:\flutter\flutter_windows_2.10.1-stable\flutter\bin;

    D:\flutter\flutter_windows_2.10.1-stable\flutter\bin是我电脑上的flutetr sdk的路径，替换自己的


 配置完类似图中这样

 ![配置](https://gitee.com/wangxiongtao/mark-down-img/raw/master/img/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20220812105709.png)

  2.进入全局Global Tool Configuration页面 配置Gradle

    * name：随意填写 我这里填写的是 gradle-6.7.1-all
    * GRADLE_HOME：填写Gradle的目录地址
      Gradle的下载地址见网盘

![地址](https://gitee.com/wangxiongtao/mark-down-img/raw/master/img/Gradle_20220812140136.png)

2.创建任务 这里需要创建两个任务Android项目的任务和Flutter项目的任务，然后进入分别配置这两个任务

    Flutter项目任务配置

       1. 设置自定义工作空间 我这里设置 E:\JekinsWorkSpace\wanda\merchant_flutter 你可以替换成你的

       2.源码管理 git地址：http://gitlab.wanda.cn/beyonds/fontend/app/merchant_platform/flutter/merchant_flutter.git 分支 dev

       3.增加构建步骤 选择Execute Windows batch command，填写命令flutter pub get

  ![](https://gitee.com/wangxiongtao/mark-down-img/raw/master/img/build20220812142516.png)

        4.构建后的操作 选择Build other projects，填写要构建的项目 既就是Android项目任务的名字。
        因为必须要等flutter构建完 才能构建Android任务，完成打包，所以这里配置这个方便打包，否则就是需要
        构建完flutter任务后，再去手动构建Android任务


 ![](https://gitee.com/wangxiongtao/mark-down-img/raw/master/img/build_after20220812142817.png)

    Android 项目任务配置

        1. 设置自定义工作空间 我这里设置 E:\JekinsWorkSpace\wanda\merchant_platform 你可以替换成你的,
        这里注意！！！ 一定要和flutter项目任务在一个根目录下，我这里都放在E:\JekinsWorkSpace\wanda\这个根目录下了

        2.源码管理 git地址：http://gitlab.wanda.cn/beyonds/fontend/app/merchant_platform/android/merchant_platform.git 分支 dev_mvvm

        3.增加构建步骤 选择Invoke Gradle script，配置Gradle Version 选择之前配置Gradle的名称即可
        填写Task命令 clean assembleDev --stacktrace  --debug
![](https://gitee.com/wangxiongtao/mark-down-img/raw/master/img/task_20220812150704.png)



  ## 打包后上传蒲公英

  安装蒲公英插件（ https://www.pgyer.com/doc/view/jenkins_plugin ）

  配置Android项目任务的构建后的操作 选择 Upload to pgyer with apiV2

  pgyer api_key：f6c6b80f09ab397accd793dc22275549

  scandir：${WORKSPACE}/app/build/outputs/apk/dev

  file wildcard： *.apk


打包流程： 构建flutter项目任务就可以，构建完会自动构建Android 项目任务 ，然后上传蒲公英
