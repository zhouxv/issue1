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