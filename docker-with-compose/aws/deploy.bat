@echo off

set lanuchType=FARGATE
set currentEnv=dev

if ""%1"" == ""demo"" (
  set currentEnv=demo
)

set defaultProjectName=a206171-camunda-ee-%currentEnv%-taskdef
set defaultDBProjectName=a206171-camunda-ee-%currentEnv%-h2db
set defaultClusterName=a206171-camunda-ee-%currentEnv%-cluster
set dockerComposeFile=docker-compose-%currentEnv%.yml
set ecsParamsFile=ecs-params-%currentEnv%.yml
set dbDockerComposeFile=db-docker-compose-%currentEnv%.yml
set dbEcsParamsFile=db-ecs-params-%currentEnv%.yml

echo defaultProjectName: %defaultProjectName%
echo defaultDBProjectName: %defaultDBProjectName%
echo defaultClusterName: %defaultClusterName%
echo dockerComposeFile: %dockerComposeFile%

set bpmComposeSericeCommand=ecs-cli compose -f %dockerComposeFile% --ecs-params %ecsParamsFile% -p %defaultProjectName% service
set dbComposeServiceCommad=ecs-cli compose -f %dbDockerComposeFile% --ecs-params %dbEcsParamsFile% -p %defaultDBProjectName%  service

rem current do not support EC2
if ""%2"" == ""EC2"" (
  set lanuchType=EC2
)
if ""%3"" == ""EC2"" (
  set lanuchType=EC2
)
if ""%4"" == ""EC2"" (
  set lanuchType=EC2
)

echo ecs-cli configure -c %defaultClusterName% -r us-east-1 --default-launch-type %lanuchType%
ecs-cli configure -c %defaultClusterName% -r us-east-1 --default-launch-type %lanuchType%

if ""%2"" == ""up"" goto doUp
if ""%2"" == ""down"" goto doDown
if ""%2"" == ""status"" goto doStatus
if ""%2"" == ""ps"" goto doStatus
if ""%2"" == ""stop"" goto doStop
if ""%2"" == ""start"" goto doStart

if ""%2"" == ""db"" (
    if ""%3"" == ""up"" (
      goto doH2Up
    )
    if ""%3"" == ""down"" (
      goto doH2Down
    )
    if ""%3"" == ""status"" (
      goto doH2Status
    )
    if ""%3"" == ""ps"" (
      goto doH2Status
    )
)
goto doUsage

:doUsage
echo Usage:  deploy [env] ( commands ... )
echo commands:
echo   up                Service up in the AWS cloud
echo   down              Down the running service in the AWS cloud, and also delete the service
echo   status, ps        Check the task status for camunda in AWS
echo   start             Starts one copy of each of the containers on an existing ECS service by setting the desired count to 1 (only if the current desired count is 0)
echo   stop              Stops the running tasks that belong to the service created with the compose project. This command updates the desired count of the service to 0.
echo   db up             Up run a h2 db, notice that after run a h2 db, need change the ip address in docker-compose.yml
echo   db down           Down a h2 db instance
echo   db status, ps     Check h2 db status
goto end

:doStart
if ""%1"" == ""--force"" goto doForceStart
goto doNormalStart

:doNormalStart
echo %bpmComposeSericeCommand% start
%bpmComposeSericeCommand% start
goto doStatus

:doForceStart
echo %bpmComposeSericeCommand% start --force-deployment
%bpmComposeSericeCommand% start --force-deployment
goto doStatus

:doStop
echo %bpmComposeSericeCommand% stop
%bpmComposeSericeCommand% stop
goto doStatus

:doUp
echo up command is danger, it will recreate the service and all data will lost
set upContinue=n
set /p upContinue=n continue to recreate ECS service [y/n] (default - %upContinue%)?:
if ""%upContinue%"" == ""n"" goto end
echo %bpmComposeSericeCommand% up --launch-type %lanuchType% --create-log-groups
%bpmComposeSericeCommand% up --launch-type %lanuchType% --create-log-groups
goto doStatus

:doDown
echo %bpmComposeSericeCommand% down
%bpmComposeSericeCommand% down
goto doStatus

:doStatus
echo %bpmComposeSericeCommand% ps
%bpmComposeSericeCommand% ps
goto end

:doH2Up
echo up command is danger, it will recreate the service and all data will lost
set upContinue=n
set /p upContinue=n continue to recreate ECS service [y/n] (default - %upContinue%)?:
if ""%upContinue%"" == ""n"" goto end
echo %dbComposeServiceCommad% up --launch-type %lanuchType% --create-log-groups
%dbComposeServiceCommad% up --launch-type %lanuchType% --create-log-groups
goto doH2Status

:doH2Down
echo down command is danger, it will recreate the service and all data will be lost
set downContinue=n
set /p downContinue=n continue to recreate ECS service [y/n] (default - %downContinue%)?:
if ""%downContinue%"" == ""n"" goto end
%dbComposeServiceCommad% down
%dbComposeServiceCommad% down
goto doH2Status

:doH2Status
echo %dbComposeServiceCommad% ps
%dbComposeServiceCommad% ps

:end
