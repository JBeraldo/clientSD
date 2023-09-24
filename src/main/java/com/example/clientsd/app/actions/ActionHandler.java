package com.example.clientsd.app.actions;

import com.example.clientsd.app.data.login.LoginData;
import com.example.clientsd.app.packages.BasePackage;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ActionHandler {
    public BasePackage dispatch(String response_action) throws JsonProcessingException {
        //            case "pedido-edicao-usuario":
        //                return new BasePackage(response_action,login_data,false,null);
        //            case "listar-usuarios":
        //                return new BasePackage(response_action,login_data,false,null);
        //            case "edicao-usuario":
        //                return new BasePackage(response_action,login_data,false,null);
        //            case "excluir-usuario":
        //                return new BasePackage(response_action,login_data,false,null);
        //            case "login":
        //                return new BasePackage(response_action,login_data,false,null);
        //            case "logout":
        //                return new BasePackage(response_action,login_data,false,null);
        return switch (response_action) {
            case "login" -> {
                LoginData login_data = new LoginData(null,null);
                yield new BasePackage(response_action, login_data);
            }
            default -> new BasePackage(response_action, null);
        };
    }
}
