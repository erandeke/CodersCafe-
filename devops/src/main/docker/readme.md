# **Commands**

**Docker version**
docker --version

**Run docker image** :
docker run -p 5000:5000 {repo}/hello-world-python:0.0.1.RELEASE

**Run docker on detached mode** :
docker run -d -p 5001:5000  {dockehub image}

**docker logs** :
dokcer logs -f {container-id}

**check images running on ur local**
docker images

**check container** 
docker container -ls

**More on docker-hub:**
https://docs.docker.com/docker-hub/



**Docker Architecture**
![img.png](img.png)

**Docker client** - Where docker commands are executed 

**Docker Daemon** - The process that is repsonsible for downloading/
running /checking local images 

**Container** : Once the image is downloaded from hub daemon is responsible 
for starting container 