For a k3s kubernetes cluster, steps：
- provider image:
```shell
mvn package
docker build --platform=linux/amd64 -f dockerfile_provider -t "127.0.0.1/captain/springboot-provider-test:v0.0.1" .
docker save "127.0.0.1/captain/springboot-provider-test:v0.0.1" -o provider_v001.tar
ctr -n k8s.io images import provider_v001.tar
```
- consumer image:
```shell
mvn package
docker build --platform=linux/amd64 -f dockerfile_consumer -t "127.0.0.1/captain/springboot-consumer-test:v0.0.1" .
docker save "127.0.0.1/captain/springboot-consumer-test:v0.0.1" -o consumer_v001.tar
ctr -n k8s.io images import consumer_v001.tar
```
- apply euraki: `kubectl apply -f euraki.yaml`
- apply provider: `kubectl apply -f provider.yaml`
- apply consumer: `kubectl apply -f consumer.yaml`

测试：
- provider: curl "http://xxx:9000/provider/curl"
- consumer: curl "http://xxx:9070/consumer/curl"