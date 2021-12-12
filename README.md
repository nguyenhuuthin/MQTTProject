# MQTTProject
### Giao thức subscribe:
C>>hello broker  
S>>200 hello client
C>>sub/location/sensorA
### Giao thức publisher:
C>>hello broker  
S>>200 hello client
C>>pub/location/sensorA
S>>210 ok
Tư đây client liên tục gửi dữ liệu về cho server.