package com.example.simg.Models;

public class DtoInfoLogin {
   private String token;

   private  usuario usuario;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public DtoInfoLogin.usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(DtoInfoLogin.usuario usuario) {
        this.usuario = usuario;
    }


    public static class usuario{
       private String usuario;
       private  String password;

        public String getpassword() {
            return password;
        }

        public void setpassword(String password) {
            this.password = password;
        }

        public String getusuario() {
            return usuario;
        }

        public void setusuario(String usuario) {
            this.usuario = usuario;
        }
    }


}
