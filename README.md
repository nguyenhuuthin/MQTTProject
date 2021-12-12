# MQTTProject
### Giao thức subscribe:
C>>hello broker  
S>>200  
C>>sub/location/sensorA  
S>>210  
C>>ready  
Từ đoạn này server sẽ gửi dữ liệu về cho client, mỗi khi có dữ liệu gửi vào topic.
### Giao thức publisher:
C>>hello broker  
S>>200  
C>>pub/location/sensorA  
S>>220  
Từ đây client liên tục gửi dữ liệu về cho server.