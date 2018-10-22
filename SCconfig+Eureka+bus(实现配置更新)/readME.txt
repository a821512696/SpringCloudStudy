
config-client 在 Ereka注册中心  找到服务 config-server;
从中获取信息。 

多加一个bus-amqp 基于rabbitmq 对变化后的配置信息进行拉取并且告诉client.
（一个client 发送http://host:port/actuator/bus-refresh后，其他client一同更新了）


详情见项目的readMe 和注释。