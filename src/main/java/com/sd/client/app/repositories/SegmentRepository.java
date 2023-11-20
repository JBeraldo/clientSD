package com.sd.client.app.repositories;

import com.sd.client.app.base.BaseRepository;
import com.sd.client.app.base.PackageData;
import com.sd.client.app.exceptions.ResponseErrorException;
import com.sd.client.app.models.Segment;
import com.sd.client.app.packages.BasePackage;
import com.sd.client.app.packages.BaseResponse;
import com.sd.client.app.packages.data.segment.*;
import com.sd.client.app.storage.LoggedUser;

import java.io.IOException;
import java.util.ArrayList;

public class SegmentRepository extends BaseRepository {

    public SegmentRepository() {
        super();
    }

    public String create(Segment new_point){
        PackageData data = new CreateSegmentRequestData(new_point, LoggedUser.token());
        BasePackage request = new BasePackage("cadastro-segmento",data);
        String json = request.toString();
        app.getOut().println(json);
        return waitCreateResponse();
    }

    private String waitCreateResponse() {
        try {
            app.read();
        } catch (IOException | ResponseErrorException e) {
            return "point/create_segment.fxml";
        }
        return "menu/menu_admin.fxml";
    }

    public String update(Segment updated_point){
        PackageData data = new EditSegmentRequestData(updated_point,LoggedUser.token());
        BasePackage request = new BasePackage("edicao-segmento",data);
        String json = request.toString();
        app.getOut().println(json);
        return waitUpdateResponse();
    }

    private String waitUpdateResponse() {
        try {
            app.read();
        } catch (IOException | ResponseErrorException e) {
            return "point/create_segment.fxml";
        }
        return AuthRepository.isCurrentUserAdmin() ? "menu/menu_admin.fxml" : "menu/menu_user.fxml";
    }

    public ArrayList<Segment> get(){
        PackageData data = new GetSegmentRequestData(LoggedUser.token());
        BasePackage request = new BasePackage("listar-segmentos",data);
        String json = request.toString();
        app.getOut().println(json);
        return waitGetResponse();
    }

    private ArrayList<Segment> waitGetResponse() {
        BaseResponse<GetSegmentPackageData> response;
        String response_data;
        try {
            response_data = app.read();
            response = BaseResponse.fromJson(response_data, GetSegmentPackageData.class);
            return (ArrayList<Segment>) response.getData().getSegments();
        } catch (IOException | ResponseErrorException e) {
            super.handleErrors(e);
            return new ArrayList<>();
        }
    }

    public void destroy(Segment point){
        PackageData data = new DeleteSegmentRequestData(LoggedUser.token(),point.getId());
        BasePackage request = new BasePackage("excluir-segmento",data);
        String json = request.toString();
        app.getOut().println(json);
        try {
            app.read();
        } catch (IOException | ResponseErrorException e) {
            super.handleErrors(e);
        }
    }

    public Segment find(Long id){
        PackageData data = new DeleteSegmentRequestData(LoggedUser.token(),id);
        BasePackage request = new BasePackage("pedido-edicao-segmento",data);
        String json = request.toString();
        app.getOut().println(json);
        return waitFindResponse();
    }

    private Segment waitFindResponse() {
        BaseResponse<FindSegmentPackageData> response;
        String response_data;
        try {
            response_data = app.read();
            response = BaseResponse.fromJson(response_data, FindSegmentPackageData.class);
            return response.getData().getSegment();
        } catch (IOException | ResponseErrorException e) {
            super.handleErrors(e);
            return new Segment();
        }
    }
}
