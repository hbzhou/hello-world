
# Developer Manual

## Deploy to demo/dev environment

### Files in the project

- `ecs-params.yml` will be used as ecs related params that can't be defined at `docker-compose.yml` when run `ecs-cli compose up`

- `docker-compose.yml` will be used as default file when run `ecs-cli compose up`, the command will use `docker-compose.yml` and `ecs-params.yml`.

- `docker-compose.ecs-local.yml` will be used for local test `docker-compose up`

- `deploy-demo.bat` is used to one command to deploy to AWS ECS FARGATE

- `mannual` folder just record the information about manually create dev environment

- `h2db` folder store the `Dockerfile` and h2 db related file to build a docker image that satisfy our requirement

- `cawemo` folder is the docker-compose file provided by camunda, however, we still don't have plan to deploy `cawemo` to AWS

- `camundabpm` folder store the `Dockerfile` to create our bpm platform image based on camunda provided image

### Environment Information

#### Local environment (Windows)

Login AWS with `cloud-tool-fr`, for example:

```
cloud-tool-fr --region us-east-1 --profile default login --account-id "608014515287" --role "human-role/200016-PowerUser" --username "MGMT\MC268807"
```

> Replace `MGMT\MC268807` with your account

Pull images from AWS ECR with `local pull`, It may take one hour or more to pull docker images.

Run `local up` to start up local environment that is defined as `docker-compose.ecs-local.yml`, first time to run suggest to run with `local up --create-volume`.

Wait few minutes, and then visit [http://lcoalhost:8080/camunda-welcome/index.html](http://localhost:8080/camunda-welcome/index.html)


#### DEV

Cluster Name: a206171-camunda-ee-dev-cluster

Task Definition Name: a206171-camunda-ee-dev-taskdef

Service Name: the same as task definition

Security Group:  sg-010f859f1a7b1506c

Subnet: subnet-23b5866a

Links:

[Camunda BPM Platform](http://a20617-camunda-ee-dev.fr-nonprod.aws.thomsonreuters.com:8080/camunda-welcome/index.html)

Username/password: demo/demo

[Optimize](http://a20617-camunda-ee-dev.fr-nonprod.aws.thomsonreuters.com:8090/#/)

Username/password: demo/demo

[H2 DB for Camunda BPM platform](http://a20617-camunda-ee-dev-db.fr-nonprod.aws.thomsonreuters.com:81)

Username/password: sa/sa

[Elasticsearch for Optimize](http://a20617-camunda-ee-dev-db.fr-nonprod.aws.thomsonreuters.com:9200/)

Username/password: N/A


#### DEMO

Cluster Name: a206171-camunda-ee-demo-cluster

Task Definition Name: a206171-camunda-ee-demo-taskdef

Service Name: the same as task definition

Security Group:  sg-010f859f1a7b1506c

Subnet: subnet-23b5866a

Links:

[Camunda BPM Platform](http://a20617-camunda-ee-demo.fr-nonprod.aws.thomsonreuters.com:8080/camunda-welcome/index.html)

Username/password: demo/demo

[Optimize](http://a20617-camunda-ee-demo.fr-nonprod.aws.thomsonreuters.com:8090/#/)

Username/password: demo/demo

[H2 DB for Camunda BPM platform](http://a20617-camunda-ee-demo-db.fr-nonprod.aws.thomsonreuters.com:81)

Username/password: sa/sa

[Elasticsearch for Optimize](http://a20617-camunda-ee-demo-db.fr-nonprod.aws.thomsonreuters.com:9200/)

Username/password: N/A

### Up and down the demo/dev environment bpm platfrom and optimize

- Use [cloud-tool-fr](https://confluence.refinitiv.com/display/IMAS/Install+cloud-tool-fr) to login:

  ```
  cloud-tool-fr --region us-east-1 --profile default login --account-id "608014515287" --role "human-role/200016-PowerUser" --username "MGMT\MC268807"
  ```
- Check whether there already exist some tasks in the cloud:

  ```
  deploy [demo|dev] status
  ```

- If no container running, run `deploy [demo|dev] up` to start services in the cloud.

  If there has some update on `docker-compose-[dev|demo].yml` and `ecs-params-[dev|demo].yml`, this command will stop old containers automatically and start new containers.

- Check the log of a specific task:

  `log demo` to check the task id

  `log demo [task-id]` to the log happen in last 2 minutes, if you want last 60 minutes, then `log demo [task-id] 60`

  > Can get task-id through `deploy [demo|dev] status`

- Need manually update Router53

  Update the record set `a20617-camunda-ee-[demo|dev]` under `fr-nonprod.aws.thomsonreuters.com`. Update the value to the public IP address the service running at.

  > Can get public IP through `deploy [demo|dev] status`


> About how to create a new cluster: ecs-cli up -c a206171-camunda-ee-dev-cluster --launch-type FARGATE -e

### Up and down h2db/elasticsearch

Check db service status:

```
deploy [demo|dev] db ps
```

Start a db service (Recreate db service all data will lost):

```
deploy [demo|dev] db up
```

Down a db service:

```
deploy [demo|dev] db down
```

Need manually update Router53：

Update the record set `a20617-camunda-ee-[demo|dev]-db` under `fr-nonprod.aws.thomsonreuters.com`. Update the value to the public IP address the service running at.

### Update a new business process war package

- Go to models directory and run the command in it's README.md to build a image with a new version

- Change the version in `docker-compose.yml-[demo|dev]` and `docker-compose.ecs-local.yml`

- Run `deploy [demo|dev] up`

### Check the log

```
log [env] [taskid] [minutes]
```

For example:

```
λ log demo
aws ecs list-tasks --cluster a206171-camunda-ee-demo-cluster
{
    "taskArns": [
        "arn:aws:ecs:us-east-1:608014515287:task/a206171-camunda-ee-demo-cluster/721920d64b144226b6bfbb7f89bf5e68",
        "arn:aws:ecs:us-east-1:608014515287:task/a206171-camunda-ee-demo-cluster/7fdc76e35d1b4eb294fb11fd12c9fb04"
    ]
}
Usage:  log [env] [taskid] [minutes]

D:\projects\POC\camunda-aws-latest (add-logs-bat)
λ log demo 721920d64b144226b6bfbb7f89bf5e68
taskId=721920d64b144226b6bfbb7f89bf5e68
ecs-cli logs --container-name a20617-poc-demo-camundabpm-service  --task-id  721920d64b144226b6bfbb7f89bf5e68 --since 2 -t
ecs-cli logs --container-name a20617-poc-demo-camundaopt-service  --task-id  721920d64b144226b6bfbb7f89bf5e68 --since 2 -t
2020-03-30T10:04:17+08:00       02:04:17.063 [Thread-9] INFO  o.c.o.s.e.i.s.VariableUpdateInstanceImportService - Refuse to add variable [creditor] from variable import adapter plugin. Variable has no process instance id.

2020-03-30T10:04:17+08:00       02:04:17.063 [Thread-9] INFO  o.c.o.s.e.i.s.VariableUpdateInstanceImportService - Refuse to add variable [invoiceNumber] from variable import adapter plugin. Variable has no process instance id.

2020-03-30T10:04:17+08:00       02:04:17.063 [Thread-9] INFO  o.c.o.s.e.i.s.VariableUpdateInstanceImportService - Refuse to add variable [amount] from variable import adapter plugin. Variable has no process instance id.
```

# Records about deploy Camunda into AWS
## Local Environment

- Login camunda environment

```shell
docker login registry.camunda.cloud
```

- Pull images from camumda private repository

```shell

# pull camunda enterprise version
docker pull registry.camunda.cloud/cambpm-ee/camunda-bpm-platform-ee:7.12.3

# pull camunda optimized
docker pull registry.camunda.cloud/optimize-ee/optimize:2.7.0

# pull camunda camewo
docker pull registry.camunda.cloud/cawemo-apiserver:1.1.1
docker pull registry.camunda.cloud/cawemo-webapp:1.1.1
docker pull registry.camunda.cloud/cawemo-garufa:1.1.1
```

- Tag camunda images as AWS ECS images

```
docker tag registry.camunda.cloud/cambpm-ee/camunda-bpm-platform-ee:7.12.3 608014515287.dkr.ecr.us-east-1.amazonaws.com/a206171-ds2-poc-camunda-bpm-platform-ee:7.12.3
ecs-cli push 608014515287.dkr.ecr.us-east-1.amazonaws.com/a206171-ds2-poc-camunda-bpm-platform-ee:7.12.3

docker tag registry.camunda.cloud/optimize-ee/optimize:2.7.0 608014515287.dkr.ecr.us-east-1.amazonaws.com/a206171-ds2-poc-camunda-optimize-ee:2.7.0
ecs-cli push 608014515287.dkr.ecr.us-east-1.amazonaws.com/a206171-ds2-poc-camunda-optimize-ee:2.7.0

docker tag registry.camunda.cloud/cawemo-apiserver:1.1.1 608014515287.dkr.ecr.us-east-1.amazonaws.com/a206171-ds2-poc-camunda-cawemo-apiserver:1.1.1
ecs-cli push 608014515287.dkr.ecr.us-east-1.amazonaws.com/a206171-ds2-poc-camunda-cawemo-apiserver:1.1.1

docker tag registry.camunda.cloud/cawemo-webapp:1.1.1 608014515287.dkr.ecr.us-east-1.amazonaws.com/a206171-ds2-poc-camunda-cawemo-webapp:1.1.1
ecs-cli push 608014515287.dkr.ecr.us-east-1.amazonaws.com/a206171-ds2-poc-camunda-cawemo-webapp:1.1.1

docker tag registry.camunda.cloud/cawemo-garufa:1.1.1 608014515287.dkr.ecr.us-east-1.amazonaws.com/a206171-ds2-poc-camunda-cawemo-garufa:1.1.1
ecs-cli push 608014515287.dkr.ecr.us-east-1.amazonaws.com/a206171-ds2-poc-camunda-cawemo-garufa:1.1.1

```

After run `docker inspect 608014515287.dkr.ecr.us-east-1.amazonaws.com/a206171-ds2-poc-camunda-bpm-platform-ee:7.12.3`

```
"ExposedPorts": {  
    "8000/tcp": {},
    "8080/tcp": {},
    "9404/tcp": {}
},               
"Env": [                                                                                                  
    "PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin",                                  
    "CAMUNDA_VERSION=7.12.3",                                                                             
    "DB_DRIVER=org.h2.Driver",                                                                            
    "DB_URL=jdbc:h2:./camunda-h2-dbs/process-engine;MVCC=TRUE;TRACE_LEVEL_FILE=0;DB_CLOSE_ON_EXIT=FALSE",
    "DB_USERNAME=sa",                                                                                     
    "DB_PASSWORD=",                                                                                       
    "DB_CONN_MAXACTIVE=20",                                                                               
    "DB_CONN_MINIDLE=5",                                                                                  
    "DB_CONN_MAXIDLE=20",                                                                                 
    "DB_VALIDATE_ON_BORROW=false",                                                                        
    "DB_VALIDATION_QUERY=SELECT 1",                                                                       
    "SKIP_DB_CONFIG=",                                                                                    
    "WAIT_FOR=",                                                                                          
    "WAIT_FOR_TIMEOUT=30",                                                                                
    "TZ=UTC",                                                                                             
    "DEBUG=false",                                                                                        
    "JAVA_OPTS=-Xmx768m -XX:MaxMetaspaceSize=256m",                                                       
    "JMX_PROMETHEUS=false",                                                                               
    "JMX_PROMETHEUS_CONF=/camunda/javaagent/prometheus-jmx.yml",                                          
    "JMX_PROMETHEUS_PORT=9404"                                                                            
],
```

## Manually create ECS

### Create a task definition

Task name: camunda-bpm-platform-ee-qing

### Create service

Service name: a20617-ds2-poc-camunda-ecs-service

VPC: vpc-0261f464
Subnet: subnet-23b5866a
Security group: a20617-ds2-poc-camunda-service-sg
Security group id: sg-010f859f1a7b1506c

No servcie discovery:
Namespace: a206171-poc-camunda-ee
Service Discovery name: a20617-ds2-poc-camunda-ecs-service
No autoscaling

https://console.aws.amazon.com/ecs/home?region=us-east-1#/clusters/a206171-camunda-ee-cluster/services/a20617-ds2-poc-camunda-ecs-service/tasks

How to get the public IP of the service:

For instance, visit https://console.aws.amazon.com/ecs/home?region=us-east-1#/clusters/a206171-camunda-ee-cluster/tasks/d54606a891634de188a7950f25cb28dd/details

### Create a cluster

a206171-camunda-ee-cluster

### Execute the task

camund-ee-securitygroup

awslogs-group: /ecs/camunda-bpm-platform-ee-qing
awslogs-stream-prefix: ecs
awslogs-region: us-east-1

Task Definition Name : camunda-bpm-platform-ee-qing

Service discovery name: a206171-camunda-ee-service

## Use ecs-cli create cluster and service

### Create a cluster

```
ecs-cli configure -c a206171-camunda-ee-demo-cluster -r us-east-1 --default-launch-type FARGATE
ecs-cli up -e
```

### ecs-cli compose create task definition

```
> ecs-cli compose -p a206171-camunda-ee-demo-taskdef create --launch-type FARGATE --create-log-groups
INFO[0003] Using ECS task definition                     TaskDefinition="a206171-camunda-ee-demo-taskdef:1"
INFO[0005] Created Log Group /ecs/a20617-poc-demo-camundaopt-service in us-east-1
INFO[0005] Created Log Group /ecs/a20617-poc-demo-camundabpm-service in us-east-1
```

> About how to deregister task definition: `aws ecs deregister-task-definition --task-definition camunda-aws:1`

[Deregistering Task Definition Revisions](https://docs.aws.amazon.com/AmazonECS/latest/developerguide/deregister-task-definition.html)

### ecs-cli compose service create service

```
> ecs-cli compose -p a206171-camunda-ee-demo-taskdef service create --launch-type FARGATE
INFO[0002] Using ECS task definition                     TaskDefinition="a206171-camunda-ee-demo-taskdef:1"
INFO[0003] Auto-enabling ECS Managed Tags
WARN[0003] Timeout was specified as zero. Service creation may not have completed yet.
WARN[0003] Timeout was specified as zero. Your service deployment may not have completed yet.
INFO[0003] Created an ECS service                        service=a206171-camunda-ee-demo-taskdef taskDefinition="a206171-camunda-ee-demo-taskdef:1"
```

### ecs-cli compose service up service

```
> ecs-cli compose -p a206171-camunda-ee-demo-taskdef service up --launch-type FARGATE
INFO[0003] Using ECS task definition                     TaskDefinition="a206171-camunda-ee-demo-taskdef:1"
INFO[0004] Updated ECS service successfully              desiredCount=1 force-deployment=false service=a206171-camunda-ee-demo-taskdef
INFO[0022] (service a206171-camunda-ee-demo-taskdef) has started 1 tasks: (task 8d89d5b8b5dc46d09bddf77c81196748).  timestamp="2020-03-25 09:32:15 +0000 UTC"
INFO[0055] Service status                                desiredCount=1 runningCount=1 serviceName=a206171-camunda-ee-demo-taskdef
INFO[0055] ECS Service has reached a stable state        desiredCount=1 runningCount=1 serviceName=a206171-camunda-ee-demo-taskdef
```

Then check the status with:

```
> ecs-cli compose -p a206171-camunda-ee-demo-taskdef service ps
Name                                                                                                 State    Ports                          TaskDefinition                     Health
a206171-camunda-ee-demo-cluster/8d89d5b8b5dc46d09bddf77c81196748/a20617-poc-demo-camundaopt-service  RUNNING  34.229.201.191:8090->8090/tcp  a206171-camunda-ee-demo-taskdef:1  UNKNOWN
a206171-camunda-ee-demo-cluster/8d89d5b8b5dc46d09bddf77c81196748/a20617-poc-demo-camundabpm-service  RUNNING  34.229.201.191:8080->8080/tcp  a206171-camunda-ee-demo-taskdef:1  UNKNOWN
```

Can stop the service:
```
> ecs-cli compose -p a206171-camunda-ee-demo-taskdef service down
INFO[0002] Updated ECS service successfully              desiredCount=0 force-deployment=false service=a206171-camunda-ee-demo-taskdef
INFO[0002] Service status                                desiredCount=0 runningCount=1 serviceName=a206171-camunda-ee-demo-taskdef
INFO[0019] Service status                                desiredCount=0 runningCount=0 serviceName=a206171-camunda-ee-demo-taskdef
INFO[0019] (service a206171-camunda-ee-demo-taskdef) has stopped 1 running tasks: (task 8d89d5b8b5dc46d09bddf77c81196748).  timestamp="2020-03-25 09:48:29 +0000 UTC"
INFO[0019] ECS Service has reached a stable state        desiredCount=0 runningCount=0 serviceName=a206171-camunda-ee-demo-taskdef
INFO[0019] Deleted ECS service                           service=a206171-camunda-ee-demo-taskdef
INFO[0019] ECS Service has reached a stable state        desiredCount=0 runningCount=0 serviceName=a206171-camunda-ee-demo-taskdef
```

### Router53

http://camunda-ee-demo.fr-nonprod.aws.thomsonreuters.com:8080/


## Other Knowledge

### Docker Compose

Run docker compose locally:

```
docker-compose -f docker-compose.ecs-local.yml up a20617-poc-demo-camundah2-service a20617-poc-demo-camundabpm-service
```

> notice: docker-compose.yml will be used by ecs-cli compose. docker-compose.ecs-local.yml is used for local test. They are different, for instance docker-compose.ecs-local.yml don't include logs related configuration. docker-compose.yml don't have link information because AWS ECS FARGATE don't support links.

### ecs-cli

#### ecs-cli configure -h

```
ecs-cli configure -c a206171-camunda-ee-cluster -r us-east-1
ecs-cli configure --default-launch-type FARGATE -c a206171-camunda-ee-cluster -r us-east-1
```

Can set some default value of the ecs-cli:

- `--cluster value, -c value`, Specifies the ECS cluster name to use. If the cluster does not exist, it is created when you try to add resources to it with the ecs-cli up command. [%ECS_CLUSTER%]
- `--region value, -r value`, Specifies the AWS region to use. If the AWS_REGION environment variable is set when ecs-cli configure is run, then the AWS region is set to the value of that environment variable. [%AWS_REGION%]
- `--config-name value`, Specifies the cluster configuration name to use for this configuration. (default: "default")
- `--cfn-stack-name value`,  [Optional] Specifies the name of AWS CloudFormation stack created on ecs-cli up. (default: "amazon-ecs-cli-setup-<cluster-name>")
- `--default-launch-type value`, [Optional] Specifies the type of tasks that you would like to run. Options: EC2 or FARGATE. Defaults to empty string if none provided.

#### ecs-cli ps -h

```shell
ecs-cli ps -cluster a206171-camunda-ee-cluster
```

This command will list `cluster name`, `State`, `Ports`, `TaskDefinition` and `Health`.

#### ecs-cli up -h

- `--capability-iam`, Acknowledges that this command may create IAM resources. Required if --instance-role is not specified. NOTE: Not applicable for launch type FARGATE or when creating an empty cluster.

- `--empty, -e`, [Optional] Specifies that an ECS cluster will be created with no resources.

- `--security-group value`, [Optional] Specifies a comma-separated list of existing security groups to associate with your container instances. If you do not specify a security group here, then a new one is created.

- `--cidr value`, [Optional] Specifies a CIDR/IP range for the security group to use for container instances in your cluster. This parameter is ignored if an existing security group is specified with the --security-group option. Defaults to 0.0.0.0/0.

- `--port value`, [Optional] Specifies a port to open on the security group to use for container instances in your cluster. This parameter is ignored if an existing security group is specified with the --security-group option. Defaults to port 80.

- `--subnets value`, [Optional] Specifies a comma-separated list of existing VPC Subnet IDs in which to launch your container instances. This option is required if you specify a VPC with the --vpc option.

- `--vpc value`,  [Optional] Specifies the ID of an existing VPC in which to launch your container instances. If you specify a VPC ID, you must specify a list of existing subnets in that VPC with the --subnets option. If you do not specify a VPC ID, a new VPC is created with two subnets.

- `--force, -f`, Optional] Forces the recreation of any existing resources that match your current configuration. This option is useful for cleaning up stale resources from previous failed attempts.

- `--tags value`, [Optional] Specify tags which will be added to AWS Resources created for your cluster. Specify in the format 'key1=value1,key2=value2,key3=value3'

- `--cluster value, -c value`, [Optional] Specifies the ECS cluster name to use. Defaults to the cluster configured using the configure command

- `--launch-type value`, [Optional] Specifies the launch type. Options: EC2 or FARGATE. Overrides the default launch type stored in your cluster configuration. Defaults to EC2 if a cluster configuration is not used.

- `--verbose, --debug`, [Optional] Increase the verbosity of command output to aid in diagnostics.

#### ecs-cli down -h

- `--force, -f`,  [Optional] Acknowledges that this command permanently deletes resources.

- `--cluster value, -c value`, [Optional] Specifies the ECS cluster name to use. Defaults to the cluster configured using the configure command

#### ecs-cli compose service -h

 Manage Amazon ECS services with docker-compose-style commands on an ECS cluster.

 Commands:

 - `create`,  Creates an ECS service from your compose file. The service is created with a desired count of 0, so no containers are started by this command.

 - `start`, Starts one copy of each of the containers on an existing ECS service by setting the desired count to 1 (only if the current desired count is 0).

 - `up`, Creates a new ECS service or updates an existing one according to your compose file. For new services or existing services with a current desired count of 0, the desired count for the service is set to 1. For existing services with non-zero desired counts, a new task definition is created to reflect any changes to the compose file and the service is updated to use that task definition. In this case, the desired count does not change.

 - `ps, list`, Lists all the containers in your cluster that belong to the service created with the compose project.

 - `stop`,  Stops the running tasks that belong to the service created with the compose project. This command updates the desired count of the service to 0.

 - `rm, delete, down`, Updates the desired count of the service to 0 and then deletes the service.

#### ecs-cli compose -h

```
ecs-cli compose command [command options] [arguments...]
```

Commands:

- `create`, Creates an ECS task definition from your compose file. Note that we do not recommend using plain text environment variables for sensitive information, such as credential data.

- `ps, list`, Lists all the containers in your cluster that were started by the compose project.

- `run`,  Starts all containers overriding commands with the supplied one-off commands for the containers.

- `start`, Starts a single task from the task definition created from your compose file.

- `stop, down`, Stops all the running tasks created by the compose project.

- `up`,  Creates an ECS task definition from your compose file (if it does not already exist) and runs one instance of that task on your cluster (a combination of create and start).

- `service`, Manage Amazon ECS services with docker-compose-style commands on an ECS cluster.

Options:

- `--file value, -f value`, Specifies one or more Docker compose files to use. Defaults to docker-compose.yml file, and an optional docker-compose.override.yml file. [%COMPOSE_FILE%]

- `--task-role-arn value`, [Optional] Specifies the short name or full Amazon Resource Name (ARN) of the IAM role that containers in this task can assume. All containers in this task are granted the permissions that are specified in this role.

- `--ecs-params value`, [Optional] Specifies ecs-params file to use. Defaults to ecs-params.yml file, if one exists.

- `--verbose, --debug`,  [Optional] Increase the verbosity of command output to aid in diagnostics.

- `--cluster value, -c value`, [Optional] Specifies the ECS cluster name to use. Defaults to the cluster configured using the configure command

#### ecs-cli logs -h

```
ecs-cli logs -c a206171-camunda-ee-cluster --task-id d54606a891634de188a7950f25cb28dd --since 2 -t
```

- `--cluster value, -c value`,  [Optional] Specifies the ECS cluster name to use. Defaults to the cluster configured using the configure command

- ` --task-id value`, Print the logs for this ECS Task.

- `--follow`, [Optional] Specifies if the logs should be streamed.

- `--filter-pattern value`,  [Optional] Substring to search for within the logs.

- `--since value`, [Optional] Returns logs newer than a relative duration in minutes. Can not be used with --start-time (default: 0)

- `--timestamps, -t`,  [Optional] Shows timestamps on each line in the log output.


#### ecs-cli local -h

This command can run ECS tasks locally.

```shell
ecs-cli local ps -all
ecs-cli local down -all
```

Commands:

- `create`, Creates a Compose file from an ECS task definition.

- `up`,  Runs containers locally from an ECS Task Definition. NOTE: Creates a docker-compose file in current directory and a ecs-local-network if one doesn't exist.

- `down`, Stops and removes a running ECS task. NOTE: Removes the ecs-local-network if it has no more running tasks.

- `ps`, Lists locally running ECS task containers.

Options:

- `--task-def-file value, -f value`, default task-definition.json. When use `create` command, means specifies the filename value that contains the task definition JSON to convert to a Docker Compose file. About how to create task definition, can refer to [Create Task Definition](https://docs.aws.amazon.com/AmazonECS/latest/developerguide/create-task-definition.html), about generate a template
  ```shell
  aws ecs register-task-definition --generate-cli-skeleton
  ```

- `--task-def-remote value, -t value`,  All running containers matching the task definition Amazon Resource Name (ARN) or family:revision value, when ue `create` command, means specifies the full Amazon Resource Name (ARN) or family:revision value of the task definition to convert to a Docker Compose file.
  ```
  ecs-cli local create --task-def-remote camunda-bpm-platform-ee-qing
  ```

- `--force` for `create`,  Overwrite output docker compose file if it exists. Default compose file is docker-compose.ecs-local.yml.

- `--output value, -o value` for `create`, Specifies the local filename value to write the Docker Compose file to. If one is not specified, the default is docker-compose.ecs-local.yml.

### AWS CLI ECS

[AWS CLI ECS Manuals](https://docs.aws.amazon.com/cli/latest/reference/ecs/index.html#cli-aws-ecs)

- Describe task definition `aws ecs describe-task-definition --task-definition camunda-bpm-platform-ee-qing`

- Service force deployment

  ```
  aws ecs update-service --cluster  a206171-camunda-ee-cluster --service a20617-ds2-poc-camunda-ecs-service --force-new-deployment
  ```

- To register a task definition with a JSON file

  ```
  aws ecs register-task-definition --cli-input-json file:///d:/task-definition.json
  ```

### H2 DB

H2 DB related configuration in camunda bpm platform is as followed:

```xml
<Resource name="jdbc/ProcessEngine"
              auth="Container"
              type="javax.sql.DataSource"
              factory="org.apache.tomcat.jdbc.pool.DataSourceFactory"
              uniqueResourceName="process-engine"
              driverClassName="org.h2.Driver"
              url="jdbc:h2:./camunda-h2-dbs/process-engine;MVCC=TRUE;TRACE_LEVEL_FILE=0;DB_CLOSE_ON_EXIT=FALSE"
              defaultTransactionIsolation="READ_COMMITTED"
              username="sa"  
              password="sa"
              maxActive="20"
              minIdle="5"
              maxIdle="20" />
```

To use our DB:

```shell
docker pull oscarfonts/h2
docker run -d -p 1521:1521 -p 81:81 -v /path/to/local/data_dir:/opt/h2-data --name=MyH2Instance oscarfonts/h2
```

> Run as a service, exposing ports 1521 (TCP database server) and 81 (web interface) and mapping DATA_DIR to host

### AWS Router53

- List host zones

```
aws route53 list-hosted-zones

Example output:
{                                                                
    "Id": "/hostedzone/Z26BO8UPU3EUN",                           
    "Name": "fr-nonprod.aws.thomsonreuters.com.",                
    "CallerReference": "68434F3D-B16C-8057-A165-CBB9256252C9",   
    "Config": {                                                  
        "Comment": "Public DNS Domain",                          
        "PrivateZone": false                                     
    },                                                           
    "ResourceRecordSetCount": 381                                
},                                                               
```

- List resource record sets

```
aws route53 list-resource-record-sets --hosted-zone-id Z26BO8UPU3EUN
```
