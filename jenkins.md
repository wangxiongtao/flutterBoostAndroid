# 万商服Android端 Windows jenkins 配置

##  环境安装（Android+Flutter）

* Android:

  1.JDK 安装

* Flutter:

   1.环境安装参见官网(https://doc.flutterchina.club/get-started/install/)

## jenkins配置


   1.进入系统设置Configure System 添加全局属性

    * 键：ANDROID_HOME  值：AndroidSdk的安装目录

    * PATH  值：C:\Windows\System32;C:\Windows\System32\WindowsPowerShell\v1.0\;D:\flutter\flutter_windows_2.10.1-stable\flutter\bin;

    D:\flutter\flutter_windows_2.10.1-stable\flutter\bin是我电脑上的flutetr sdk的路径，替换自己的


 配置完类似图中这样

 ![配置](https://gitee.com/wangxiongtao/mark-down-img/raw/master/img/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20220812105709.png)
