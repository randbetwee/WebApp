## 整体框架

```
project
 |-src-- main
          |-DatabaseApplication.java   #主函数入口
          |-databaseApp 
                  |-entity             # 表格的模式
                  |-mapper             # 映射数据库操作方式，用于在程序中直接操作的接口
                  |-service            # 业务层，用于组织mapper中的操作的用法
                  |-controller         # 控制层，调用业务层完成相应操作并处理异常
                        |-exception    # 处理异常
                        |-implement    # 业务实际操作过程与接口
                  |-util               # 控制层，接受来自网页的数据进行响应处理
          |-resource
                  |-mapper             # 实际SQL语句存在的地方，通过mapper与上面的接口组成映射
 |-test                                # 各个模块测试的程序
```
 
## 已完成的Aspect

已经完成的方面由下面的标题为开头的源文件构成

* **User** 用于用户注册与登录
     * 控制层 已完成
     * 业务层 已完成
     * 持久层 已完成
     * 前端   NO

* **Exhibition** 该模块用于展示信息

* **Comment and rank** 该模块用于评论与评分
