
For a k3s kubernetes cluster, steps：
- provider image:
```shell
mvn package
docker build -f dockerfile_provider -t "127.0.0.1/provider:v0.0.1" .
docker save "127.0.0.1/provider:v0.0.1" -o provider_v001.tar
ctr -n k8s.io images import provider_v001.tar
```
- consumer image:
```shell
mvn package
docker build -f dockerfile_consumer -t "127.0.0.1/consumer:v0.0.1" .
docker save "127.0.0.1/consumer:v0.0.1" -o consumer_v001.tar
ctr -n k8s.io images import consumer_v001.tar
```
- apply provider: `kubectl apply -f provider.yaml`
- apply ServiceEntry: `kubectl apply -f serviceentry.yaml`
- apply EntryFilter: `kubectl apply -f entryfilter.yaml`
- apply consumer: `kubectl apply -f consumer.yaml`