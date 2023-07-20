package API;

import API.objects.CreateTask;
import API.objects.IdTask;
import io.restassured.response.Response;

import static API.methods.Task.CREATE_TASK;
import static API.methods.Task.REMOVE_TASK;
import static envs.PropertyEnv.API_TOKEN;
import static envs.PropertyEnv.API_USERNAME;

public class TaskApi extends BaseApi {
    public String createTaskRequiredParams(String taskTitle, Integer projectId) {
        CreateTask args = CreateTask.builder()
                .title(taskTitle)
                .project_id(projectId)
                .build();

        BodyArgs bodyArgs = BodyArgs.builder()
                .params(args)
                .method(CREATE_TASK)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);
        BodyResult bodyResult = response.as(BodyResult.class);
        return bodyResult.getResult().toString();
    }

    public boolean removeTask(Integer IdTask) {
        BodyArgs bodyArgs = BodyArgs.builder()
                .params(new IdTask(IdTask))
                .method(REMOVE_TASK)
                .build();
        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);
        return (boolean) response.as(BodyResult.class).getResult();
    }
}

