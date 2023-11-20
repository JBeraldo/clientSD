package com.sd.client.app.repositories;

import com.sd.client.app.base.BaseRepository;
import com.sd.client.app.base.PackageData;
import com.sd.client.app.exceptions.ResponseErrorException;
import com.sd.client.app.models.Point;
import com.sd.client.app.models.User;
import com.sd.client.app.packages.BasePackage;
import com.sd.client.app.packages.BaseResponse;
import com.sd.client.app.packages.data.point.*;
import com.sd.client.app.packages.data.user.*;
import com.sd.client.app.storage.LoggedUser;

import java.io.IOException;
import java.util.ArrayList;

public class PointRepository extends BaseRepository {

    public PointRepository() {
        super();
    }

    public String create(Point new_point){
        PackageData data = new CreatePointRequestData(new_point, LoggedUser.token());
        BasePackage request = new BasePackage("cadastro-ponto",data);
        String json = request.toString();
        app.getOut().println(json);
        return waitCreateResponse();
    }

    private String waitCreateResponse() {
        try {
            app.read();
        } catch (IOException | ResponseErrorException e) {
            return "point/create_point.fxml";
        }
        return "menu/menu_admin.fxml";
    }

    public String update(Point updated_point){
        PackageData data = new EditPointRequestData(updated_point,LoggedUser.token());
        BasePackage request = new BasePackage("edicao-ponto",data);
        String json = request.toString();
        app.getOut().println(json);
        return waitUpdateResponse();
    }

    private String waitUpdateResponse() {
        try {
            app.read();
        } catch (IOException | ResponseErrorException e) {
            return "point/create_point.fxml";
        }
        return AuthRepository.isCurrentUserAdmin() ? "menu/menu_admin.fxml" : "menu/menu_user.fxml";
    }

    public ArrayList<Point> get(){
        PackageData data = new GetPointRequestData(LoggedUser.token());
        BasePackage request = new BasePackage("listar-pontos",data);
        String json = request.toString();
        app.getOut().println(json);
        return waitGetResponse();
    }

    private ArrayList<Point> waitGetResponse() {
        BaseResponse<GetPointPackageData> response;
        String response_data;
        try {
            response_data = app.read();
            response = BaseResponse.fromJson(response_data, GetPointPackageData.class);
            return response.getData().getPoints();
        } catch (IOException | ResponseErrorException e) {
            super.handleErrors(e);
            return new ArrayList<>();
        }
    }

    public void destroy(Point point){
        PackageData data = new DeletePointRequestData(LoggedUser.token(),point.getId());
        BasePackage request = new BasePackage("excluir-ponto",data);
        String json = request.toString();
        app.getOut().println(json);
        try {
            app.read();
        } catch (IOException | ResponseErrorException e) {
            super.handleErrors(e);
        }
    }

    public Point find(Long id){
        PackageData data = new DeletePointRequestData(LoggedUser.token(),id);
        BasePackage request = new BasePackage("pedido-edicao-ponto",data);
        String json = request.toString();
        app.getOut().println(json);
        return waitFindResponse();
    }

    private Point waitFindResponse() {
        BaseResponse<FindPointPackageData> response;
        String response_data;
        try {
            response_data = app.read();
            response = BaseResponse.fromJson(response_data, FindPointPackageData.class);
            return response.getData().getPonto();
        } catch (IOException | ResponseErrorException e) {
            super.handleErrors(e);
            return new Point();
        }
    }
}
