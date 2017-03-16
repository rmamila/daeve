# daeve
daeve hackday project

Software / Libraries installation
---------------------------------
- Install MongoDB
    brew install mongodb

- Create a directory for storing data
    mkdir -t /data/db

    sudo chmod 777 /data/db

- Set JAVA_HOME in ~/bash_profile (ex: /Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home)


Starting database service and queue service
-------------------------------------------

- run command "mongod" to start the database service
    mongod

- Goto below folder and Start queue service
    cd /usr/local/Cellar/rabbitmq/3.6.6/sbin
    ./rabbitmq-server

Test
——--

Run DaeveApplication

Get (test on browser)
http://localhost:8080/api/suggestions?username=chaminda
