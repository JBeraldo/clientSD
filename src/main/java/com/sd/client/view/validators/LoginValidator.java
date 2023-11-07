package com.sd.client.view.validators;

public class LoginValidator extends Validator {
    public  static ValidationResponse validate(String password,String email) {
//        if(password.length() < 6){
//            return new ValidationResponse("Aviso","Senha inválida","A senha precisa possuir ao menos 6 caractéres");
//        }
        if(!ValidateHelper.isValidEmail(email)){
            return new ValidationResponse("Aviso","Email inválido","Verifique seu email");
        }
        if(!validateEmpty(email,password)){
            return new ValidationResponse("Aviso","Preencha todos os campos","Preencha todos os campos");
        }
        return new ValidationResponse();
    }
    protected static boolean validateEmpty(String email,String password){
        if(email == null || email.isEmpty()) return false;
        return password != null && !password.isEmpty();
    }
}
