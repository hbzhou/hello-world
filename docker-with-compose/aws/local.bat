@echo off

if ""%1"" == ""pull"" goto doPull

if ""%1"" == ""up"" (
  if ""%2"" == ""--create-volume"" (
    echo docker volume create --name=bpmwebapps
    docker volume create --name=bpmwebapps
  )
)

echo docker-compose -f docker-compose.ecs-local.yml %*
docker-compose -f docker-compose.ecs-local.yml %*

goto end

:doPull
ecs-cli pull 608014515287.dkr.ecr.us-east-1.amazonaws.com/a206171-ds2-poc-camunda-bpm-platform-ee:7.12.3.1
ecs-cli pull 608014515287.dkr.ecr.us-east-1.amazonaws.com/a206171-ds2-poc-camunda-optimize-ee:2.7.0
ecs-cli pull 608014515287.dkr.ecr.us-east-1.amazonaws.com/a206171-ds2-poc-camunda-h2db:0.0.1
ecs-cli pull 608014515287.dkr.ecr.us-east-1.amazonaws.com/a206171-ds2-poc-camunda-optes:6.6.2
ecs-cli pull 608014515287.dkr.ecr.us-east-1.amazonaws.com/a206171-ds2-poc-camunda-models:latest

goto end

:end
