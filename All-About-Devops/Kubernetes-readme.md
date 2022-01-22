1)What is Kubernetes

A: https://kubernetes.io/docs/concepts/overview/what-is-kubernetes/

[2)**Clusters:**


A: Combination of master nodes and worker nodes to manage the load

Q) How to create kubernetes deployment for service ?
A) **kubectl create deployment** hello-world-rest-api --image=in28min/hello-world-rest-api:0.0.1.RELEASE

Q)How to expose the endpoint to the world?
A) **kubectl expose deployment** hello-world-rest-api --type=LoadBalancer --port=8080

Q) What is POD ? All you want to know :
A) https://www.youtube.com/watch?v=k0fzMZgpp14

Q)What happens if we delete pod?
A) Every pod is associated with replica set . Replica set maintains the dedicated pods
If we delete the pod then replica set will create the new one 

Q) What is the role of replica set ?
A) A ReplicaSet's purpose is to maintain a stable set of replica Pods running at any given time. As such, it is often used to guarantee the availability of a specified number of identical Pods.

Q)How deployment stage works in Kubernetes?
A) Let say RS is holding version 1 for 2 pods . Now we deploy an image version 2.
Now to achieve zero downtime deployments K8 will add one pod for version2 .Now the traffic
will be start roudting to ver2 as well.Simultaneously it will start scaling up the 
pod for ver2 and scaling down for ver1 so at the end 


Ver2 will have all the active pods service traffic and for ver1 the pods are scaled down

<img width="500" alt="Screenshot 2022-01-22 at 10 33 19 PM" src="https://user-images.githubusercontent.com/25060762/150648442-20e4d9eb-7455-4d6b-84ca-69eedb24f9ab.png">


Q)Kubernetes Architecture 
A) https://www.youtube.com/watch?v=cvziZliY-AI

1)K8 comprises of master node and worker node
In master, it has 
1)API server : whatever we do in K8 it goes via API server 
Its an entry point for K8 to operate on user commands

2)Scheduler : It schedules the workload on different nodescomp available 
It decides where to run which container 

3)Controller Manager : It takes the task of managing, scaling ,
replicas 

4)etcd: Its an distributed database that store the config 
for K8 . Whatever config changes are made it stores in DB


# **Commands:**


kubectl create deployment hello-world-rest-api --image=in28min/hello-world-rest-api:0.0.1.RELEASE

kubectl expose deployment hello-world-rest-api --type=LoadBalancer --port=8080

**Scale ReplicaSet**
kubectl scale deployment hello-world-rest-api --replicas=3

**Delete Kube Pod**
kubectl **delete** pod hello-world-rest-api-58ff5dd898-62l9d

kubectl autoscale deployment hello-world-rest-api --max=10 --cpu-percent=70

kubectl edit deployment hello-world-rest-api #minReadySeconds: 15

**Image deployment** 
kubectl set image deployment hello-world-rest-api hello-world-rest-api=in28min/hello-world-rest-api:0.0.2.RELEASE

gcloud container clusters get-credentials in28minutes-cluster --zone us-central1-a --project solid-course-258105

kubectl create deployment hello-world-rest-api --image=in28min/hello-world-rest-api:0.0.1.RELEASE

kubectl expose deployment hello-world-rest-api --type=LoadBalancer --port=8080

kubectl set image deployment hello-world-rest-api hello-world-rest-api=DUMMY_IMAGE:TEST

kubectl get events --sort-by=.metadata.creationTimestamp

kubectl set image deployment hello-world-rest-api hello-world-rest-api=in28min/hello-world-rest-api:0.0.2.RELEASE

kubectl get events --sort-by=.metadata.creationTimestamp

**Kube Master Node status**
kubectl get componentstatuses

kubectl get pods --all-namespaces

kubectl get events -> To get what all events have ocurred for example Pull image , asigming POD, scaling replicaset

kubectl get pods-> Gets all pods running . Pod is collection of container that runs on host
They are created by client and scheduled on host

kubectl get replicaset

kubectl get deployment

**Service**
kubectl get service

kubectl get pods -o wide

kubectl explain pods

kubectl get pods -o wide

kubectl describe pod hello-world-rest-api-58ff5dd898-9trh2

kubectl get replicasets

kubectl get replicaset

kubectl scale deployment hello-world-rest-api --replicas=3

kubectl get pods

kubectl get replicaset

kubectl get events

kubectl get events --sort.by=.metadata.creationTimestamp

kubectl get rs

kubectl get rs -o wide

kubectl set image deployment hello-world-rest-api hello-world-rest-api=DUMMY_IMAGE:TEST

kubectl get rs -o wide

kubectl get pods

kubectl describe pod hello-world-rest-api-85995ddd5c-msjsm

kubectl get events --sort-by=.metadata.creationTimestamp

kubectl set image deployment hello-world-rest-api hello-world-rest-api=in28min/hello-world-rest-api:0.0.2.RELEASE

kubectl get events --sort-by=.metadata.creationTimestamp

kubectl get pods -o wide

kubectl delete pod hello-world-rest-api-67c79fd44f-n6c7l

kubectl get pods -o wide

kubectl delete pod hello-world-rest-api-67c79fd44f-8bhdt

kubectl get componentstatuses

kubectl get pods --all-namespaces

gcloud auth login

kubectl version

gcloud container clusters get-credentials in28minutes-cluster --zone us-central1-a --project solid-course-258105

kubectl rollout history deployment hello-world-rest-api

kubectl set image deployment hello-world-rest-api hello-world-rest-api=in28min/hello-world-rest-api:0.0.3.RELEASE --record=true

kubectl rollout undo deployment hello-world-rest-api --to-revision=1

kubectl logs hello-world-rest-api-58ff5dd898-6ctr2

kubectl logs -f hello-world-rest-api-58ff5dd898-6ctr2

kubectl get deployment hello-world-rest-api -o yaml

kubectl get deployment hello-world-rest-api -o yaml > deployment.yaml

kubectl get service hello-world-rest-api -o yaml > service.yaml

kubectl apply -f deployment.yaml

kubectl get all -o wide

kubectl delete all -l app=hello-world-rest-api

kubectl get svc --watch

kubectl diff -f deployment.yaml

kubectl delete deployment hello-world-rest-api

kubectl get all -o wide

kubectl delete replicaset.apps/hello-world-rest-api-797dd4b5dc

kubectl get pods --all-namespaces

kubectl get pods --all-namespaces -l app=hello-world-rest-api

kubectl get services --all-namespaces

kubectl get services --all-namespaces --sort-by=.spec.type

kubectl get services --all-namespaces --sort-by=.metadata.name

kubectl cluster-info

kubectl cluster-info dump

kubectl top node

kubectl top pod

kubectl get services

kubectl get svc

kubectl get ev

kubectl get rs

kubectl get ns

kubectl get nodes

kubectl get no

kubectl get pods

kubectl get po

kubectl delete all -l app=hello-world-rest-api

kubectl get all

kubectl apply -f deployment.yaml

kubectl apply -f ../currency-conversion/deployment.yaml 

