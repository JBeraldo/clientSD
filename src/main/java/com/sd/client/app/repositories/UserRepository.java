package com.sd.client.app.repositories;

import com.sd.client.app.base.BaseRepository;
import com.sd.client.app.base.ResponseData;
import com.sd.client.app.exceptions.ResponseErrorException;
import com.sd.client.app.packages.BaseResponse;
import com.sd.client.app.packages.data.user.*;
import com.sd.client.app.models.User;
import com.sd.client.app.packages.BasePackage;
import com.sd.client.app.storage.LoggedUser;

import java.io.IOException;
import java.util.ArrayList;

public class UserRepository extends BaseRepository {
    public UserRepository() {
        super();
    }

    public String create(User new_usr){
        ResponseData data = new CreateUserRequestData(new_usr, LoggedUser.token());
        BasePackage request = new BasePackage("cadastro-usuario",data);
        String json = request.toString();
        app.getOut().println(json);
        return waitCreateResponse();
    }

    private String waitCreateResponse() {
        try {
            app.read();
        } catch (IOException | ResponseErrorException e) {
            return "user/create_user.fxml";
        }
        return "menu/menu_admin.fxml";
    }

    public String update(User updated_usr){
        updated_usr.setType(AuthRepository.isCurrentUserAdmin() ? updated_usr.getType() : null);
        ResponseData data = new EditUserRequestData(updated_usr, LoggedUser.token());
        String action = AuthRepository.isCurrentUserAdmin() ? "edicao-usuario" : "autoedicao-usuario";
        BasePackage request = new BasePackage(action,data);
        String json = request.toString();
        app.getOut().println(json);
        return waitUpdateResponse();
    }

    private String waitUpdateResponse() {
        try {
            app.read();
        } catch (IOException | ResponseErrorException e) {
            return "user/create_user.fxml";
        }
        return AuthRepository.isCurrentUserAdmin() ? "menu/menu_admin.fxml" : "menu/menu_user.fxml";
    }

    public ArrayList<User> get(){
        ResponseData data = new GetUserRequestData(LoggedUser.token());
        BasePackage request = new BasePackage("listar-usuarios",data);
        String json = request.toString();
        app.getOut().println(json);
        return waitGetResponse();
    }

    private ArrayList<User> waitGetResponse() {
        BaseResponse<GetUserResponseData> response;
        String response_data;
        try {
            response_data = app.read();
            response = BaseResponse.fromJson(response_data, GetUserResponseData.class);
            return response.getData().getUsers();
        } catch (IOException | ResponseErrorException e) {
            super.handleErrors(e);
            return new ArrayList<>();
        }
    }

    public void destroy(User user){
        ResponseData data = new DeleteUserRequestData(LoggedUser.token(),user.getId());
        BasePackage request = new BasePackage("excluir-usuario",data);
        String json = request.toString();
        app.getOut().println(json);
        waitDeleteResponse();
    }

    private void waitDeleteResponse() {
        try {
            app.read();
        } catch (IOException | ResponseErrorException e) {
            super.handleErrors(e);
        }
    }

    public User find(Long id){
        ResponseData data = new FindUserRequestData(LoggedUser.token(),id);
        BasePackage request = new BasePackage("pedido-edicao-usuario",data);
        String json = request.toString();
        app.getOut().println(json);
        return waitFindResponse();
    }

    public User findSelf(){
        ResponseData data = new FindSelfUserRequestData(LoggedUser.token());
        BasePackage request = new BasePackage("pedido-proprio-usuario",data);
        String json = request.toString();
        app.getOut().println(json);
        return waitFindResponse();
    }

    private User waitFindResponse() {
        BaseResponse<FindUserResponseData>    response;
        String response_data;
        try {
            response_data = app.read();
            response = BaseResponse.fromJson(response_data,FindUserResponseData.class);
            return response.getData().getUser();
        } catch (IOException | ResponseErrorException e) {
            super.handleErrors(e);
            return new User();
        }
    }
}
