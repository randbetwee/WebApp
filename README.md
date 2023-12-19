## 整体框架

```
project
 |-src-- main
          |-databaseApp 
                  |-config             # 拦截器的控制
                  |-intercepter        # 拦截器
                  |-entity             # 表格的模式
                  |-mapper             # 映射数据库操作方式，用于在程序中直接操作的接口
                  |-service            # 业务层，用于组织mapper中的操作的用法
                  |-controller         # 控制层，调用业务层完成相应操作并处理异常
                        |-exception    # 处理异常
                        |-implement    # 业务实际操作过程与接口
                  |-util               # 控制层，接受来自网页的数据进行响应处理
                  |-DatabaseApplication.java   #主函数入口
          |-resource
                  |-mapper             # 实际SQL语句存在的地方，通过mapper与上面的接口组成映射
 |-test                                # 各个模块测试的程序
```
 
## 已完成的Aspect

已经完成的方面由下面的标题为开头的源文件构成

* **User** 用于用户注册与登录

* **Vehicle(exhibition)** 该模块用于展示信息，实现首页相册，有详情页和分类查询展示

* **Comment and rank** 该模块用于评论与评分

* **photowall** 该模块用于用户上传图片和管理员审核图片

## 域名与接口

所有返回类型和参数类型可以在entity中找到，有注释。

### `/`  主页面
展示所有Vehicle的概览信息，向上传一个List，类型与函数前面定义一致，下面不再赘述
```
public JsonResult<List<Vehicle>> first_page()
```

### `/{vid}`  某个vehicle的详细信息页面
```
public JsonResult<Vehicle> detail_page(@PathVariable("vid") Integer vid)
```
### `/{vid}/photowall`  某个vehicle的照片墙，建议跟上面那个页面一起拉起显示在同一个页面
```
public JsonResult<List<PhotoWall>> showPhotoWall(@PathVariable("vid") Integer vid)
```
### `/{vid}/commentpage` 某个vehicle的评论页，建议和上面的页面一起拉起显示在同一个页面
```
public JsonResult<List<Comment>> showComment(@PathVariable("vid") Integer vid)
```
### `/{vid}/comment` 发起评论，传入一个Comment结构体的数据类，进行评论
```
public JsonResult<Void> commentrequest(Comment c)
```
### `/rank`  显示排行榜
```
public JsonResult<List<Vehicle>> sendRank()
```
### `/type/{cate}`   按类进行分类查询
```
public JsonResult<List<Vehicle>> search_by_cate(@PathVariable("cate") String cate)
```
### `/nation/{Nat}`    按国家进行分类查询
```
public JsonResult<List<Vehicle>> search_by_nat(@PathVariable("Nat") String Nat)
```
### `/user/reg`      用户注册
```
public JsonResult<Void> reg(String user,String password,String email)
```
### `/user/login`    用户登录
```
public JsonResult<User> login(int UserID,String password,HttpSession session)
```
### `/admin/auditview`  管理员的审核视图，发一些未经审核的图片到页面
```public JsonResult<List<PhotoWall>> auditView()
```
### `/admin/audit`    管理员的审核操作，传入某个图片的地址和id
```
public JsonResult<Void> AuditPhoto(int id,String address)
```
### `/upload/photo`     用户上传图片
```
public JsonResult<String> upload_Photo(MultipartFile uploadFile,int vid,HttpServletRequest request)
```

### `/upload/vehicle`  用户上传新载具
```
public JsonResult<Void> upload(Vehicle vec)
```