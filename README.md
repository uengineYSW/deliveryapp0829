# 

## Model
www.msaez.io/#/112850933/storming/deliveryapp0829

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- 고객
- 주문
- 배달
- 알림


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- 고객
```
 http :8088/customers id="id" name="name" phone="phone" address="address" totalPoints="totalPoints" 
```
- 주문
```
 http :8088/orders id="id" customerId="customerId" storeId="storeId" orderStatus="orderStatus" orderStatusType="orderStatusType" orderTime="orderTime" totalAmount="totalAmount" earnedPoints="earnedPoints" 
 http :8088/stores id="id" name="name" address="address" phone="phone" 
 http :8088/payments id="id" orderId="orderId" amount="amount" paymentMethod="paymentMethod" paymentStatus="paymentStatus" paymentStatusType="paymentStatusType" paymentTime="paymentTime" earnedPoints="earnedPoints" 
```
- 배달
```
 http :8088/deliveries id="id" orderId="orderId" riderId="riderId" pickupTime="pickupTime" deliveryStatus="deliveryStatus" deliveryStatusType="deliveryStatusType" 
 http :8088/riders id="id" name="name" phone="phone" currentLocation="currentLocation" 
```
- 알림
```
 http :8088/notifications id="id" customerId="customerId" orderId="orderId" message="message" notificationTime="notificationTime" 
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

