@echo off
set currentEnv=dev
set minutes=2

if ""%1"" == ""demo"" (
  set currentEnv=demo
)

if NOT ""%2"" == """" (
  set taskId=%2
  echo taskId=%taskId%
  goto doLog
)

if ""%2"" == """" (
  echo aws ecs list-tasks --cluster a206171-camunda-ee-%currentEnv%-cluster
  aws ecs list-tasks --cluster a206171-camunda-ee-%currentEnv%-cluster
)

:doUsage
echo Usage:  log [env] [taskid] [minutes]
goto end


:doLog
if NOT ""%3"" == """" (
  set minutes=%3
)
echo ecs-cli logs -c a206171-camunda-ee-%currentEnv%-cluster --container-name a20617-poc-%currentEnv%-camundabpm-service  --task-id  %taskId% --since %minutes% -t
ecs-cli logs  -c a206171-camunda-ee-%currentEnv%-cluster --container-name a20617-poc-%currentEnv%-camundabpm-service  --task-id  %taskId% --since %minutes% -t

rem echo ecs-cli logs -c a206171-camunda-ee-%currentEnv%-cluster --container-name a20617-poc-%currentEnv%-camundaopt-service  --task-id  %taskId% --since %minutes% -t
rem ecs-cli logs -c a206171-camunda-ee-%currentEnv%-cluster --container-name a20617-poc-%currentEnv%-camundaopt-service  --task-id  %taskId% --since %minutes% -t
goto end

:end
