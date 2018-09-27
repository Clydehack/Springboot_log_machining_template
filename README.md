# Springboot_log_machining_template


# 主要目的：对原始日志数据进行二次处理

## 目前产生的日志是不同线程混杂在一起的：
## 16:40:51.371 [Thread-1]  INFO  maindemo.test.LogbackDemo - threada1:begin
## 16:40:51.375 [Thread-5]  INFO  maindemo.test.LogbackDemo - threada5:begin
## 16:40:51.375 [Thread-2]  INFO  maindemo.test.LogbackDemo - threada2:end

## 写个小服务处理一下先让日志变成这样：
## 16:40:51.371 [Thread-1]  INFO  maindemo.test.LogbackDemo - threada1:begin
## 16:40:51.374 [Thread-1]  INFO  maindemo.test.LogbackDemo - threada1:end
## 16:40:51.374 [Thread-2]  INFO  maindemo.test.LogbackDemo - threada2:begin
## 16:40:51.375 [Thread-2]  INFO  maindemo.test.LogbackDemo - threada2:end
## 16:40:51.375 [Thread-5]  INFO  maindemo.test.LogbackDemo - threada5:begin
## 16:40:51.375 [Thread-5]  INFO  maindemo.test.LogbackDemo - threada5:end


# 次要目的：
## 按时间存库里，再提供几个给前端调用的接口：
## 这样可以在前端快速查看和定位到日志数据


# 次要目的：
## 每星期压缩一次原始日志文件
## 每半年压缩一下半年产生的原始日志文件压缩包