# daeve
daeve hackday project

Software / Libraries installation
---------------------------------
- Install MongoDB -
- Docker
	$ docker pull mongo
	$ docker run -p 27017:27017 -d mongo
	
OR 
- Brew

    brew install mongodb

- Create a directory for storing data

   sudo mkdir -p /data/db

    sudo chmod 777 /data/db

- Set JAVA_HOME in ~/bash_profile (ex: /Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home)


Starting database service and queue service
-------------------------------------------

- run command "mongod" to start the database service
    mongod
    
- Open MongoDB Shell

    Start a terminal for your mongo shell

    Run the command (make sure you put the name of the database)
  
    mongo --shell

- Goto below folder and Start queue service

    cd /usr/local/Cellar/rabbitmq/3.6.6/sbin
    
    ./rabbitmq-server

Test
----
Run integration tests 
	UserActionSuggestionsControllerIT and  UserNavigationDataControllerIT in your IDE 
Or 	
	mvn verify

Or 	Test with curl

Run DaeveApplication

- Get (test on browser)

http://localhost:8080/api/suggestions?username=user@user.com

- Post

copy below content in file /tmp/navigation_log_request.txt

{"username" : "Amila", "urlPattern" : "/pexa_web/login.html", "subscriberType" : "sponsermanager", "subscriberId" : "1233", "workspaceId" : "133/1567", "sessionId" : "12321322"}

curl -X POST -d `cat /tmp/navigation_log_request.txt` http://localhost:8080/api/log-navigation-data?UserNavigationData --header 'Content-Type: application/json' --header 'Accept: application/json'
