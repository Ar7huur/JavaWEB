package Util;

public class Usuario {

    private String user;
    private String senha;
    private boolean flag = false;
    private int contN = 0, contL = 0;
    private char c;

    public Usuario(String user, String senha) {
        this.user = user;
        this.senha = senha;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isValido() {
        if (user.length() >= 6 && user.length() <= 8) {
            for (int i = 0; i < senha.length() && senha.length() <= 4; i++) {
                c = senha.charAt(i);
                if ((c >= '0') && (c <= '9')) {
                    contN++;
                }
                if ((c >= 'A') && (c <= 'Z') || (c >= 'a') && (c <= 'z'));
                contL++;
            }
            if (contN >= 1 && contL >= 1) {
                flag = true;
            }
        }
        return flag;
    }
}
