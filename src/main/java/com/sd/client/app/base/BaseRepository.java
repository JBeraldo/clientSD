package com.sd.client.app.base;

import com.sd.client.app.App;
import com.sd.client.app.repositories.AppRepository;
import com.sd.client.view.validators.ValidationResponse;
import com.sd.client.view.validators.Validator;

public class BaseRepository {
    protected App app;
    protected void handleErrors(Exception e){
        Validator.errorAlert(new ValidationResponse(e.getMessage(),true));
    }

    public BaseRepository() {
        this.app = AppRepository.getApp();
    }

}
