RabbitMQ and Spring Boot

Before run:

https://hub.docker.com/_/rabbitmq/

docker pull rabbitmq

docker run -d --hostname my-rabbit --name [имя_приложения] -p 15672:15672 -p 5672:5672 rabbitmq:3-management

web manager:

http://localhost:15672/

login: guest
pass: guest
