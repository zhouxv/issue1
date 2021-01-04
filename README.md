### 提交历史
增加了定级算分的工具类,修改了部分逻辑

接口调整.只提供有意义的接口.

增加了grouplevel和saglevel的dto

接口调整.只提供有意义的接口.

增加了grouplevel和saglevel的dto

1.增加Service层抽象接口:通过Id进行删除

2.impl层增加了相关实现

3.control层serviceController修改了逻辑

当删除一个service时,所有相关的数据的deleteState都会修改为0
(deleteState=1代表数据未删除.deleteState=0代表数据已删除)
