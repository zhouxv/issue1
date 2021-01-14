### 提交历史

#### 2019.12.31 提交

+ 增加了定级算分的工具类,修改了部分逻辑.

#### 2020.01.04 1st提交

+ 接口调整:只提供有意义的接口;
+ 增加了grouplevel和saglevel的dto.

#### 2020.01.04 2nd提交

+ 增加Service层抽象接口:通过Id进行删除;
+ impl层增加了相关实现;
+ control层serviceController修改了逻辑.当删除一个service时,所有相关的数据的deleteState都会修改为0(deleteState=1代表数据未删除,deleteState=0代表数据已删除)

#### 2021.01.05 1st提交

+ 更新README.md:只是把每次提交的内容放上去了,排版还没做

#### 2021.01.05 2nd提交

+ 更新README.md:排版完成

#### 2021.01.05 3rd提交
方法修改
+ ConvertList类中修改static方法stringToDoubleList(),增加sout来帮助开发者观察函数内部.stringToDoubleList()、stringToDoubleArray()
  增加对传入字符串内容是否为数字的检验.
+ 由于数据库中sagLevel表中sResult、aResult、gResult的内容格式变化(由"1"->"0.98,0.83,0.81,0.79,1") ,CountSagLevel类中totalCount()
  和countFinalLevel()都要作相应修改.
+ CountIndexLevel类中indexLevel()中,因为有updateTestResult的需求,数组大小的检验变为8或9;循环中不再使用'+',而是使用StringBuffer.

#### 2021.01.14 提交
+ 前端文件导入src/main/resources/static
+ controller中TestResult和ServiceDetail增加了@RequestBody注解
+ 端口10080