/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Leon Jr
 */
public class Dados {

    private String user="";
    private String senha="";
    private File f;
    private String nu = "", ns = "";

    /**
     * Método que escreve em um arquivo a senha e usuário do admnistrador
     *
     * @param user Usuario do adm
     * @param senha senha do adm
     * @throws IOException Exception se não encontrar o arquivo
     */
    public void escrever(String user, String senha) throws IOException {
        FileWriter w = new FileWriter(f);
        criptografia(user, senha);
        w.write(nu + "\n");
        w.write(ns);
        w.close();
    }

    /**
     * Método para ler o arquivo que contem os dados
     */
    public void ler() {
        String line = "";
        user="";
        senha="";
        f = new File("./dir/bin/cod.txt");

        try {
            FileReader fileReader = new FileReader(f);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            nu = bufferedReader.readLine();
            ns = bufferedReader.readLine();
            descriptografar(nu, ns);
        } catch (FileNotFoundException ex) {
            System.out.println("Erro io" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Erro io" + ex.getMessage());
        }
    }

    /**
     * Criptografa a senha e o usuario
     *
     * @param user User do adm
     * @param senha Senha do adm
     * @return Um boolean para verificação
     */
    public boolean criptografia(String user, String senha) {
        try {
            for (int i = 0; i < user.length(); i++) {
                if (user.charAt(i) == 'a' || user.charAt(i) == 'A') {
                    nu += "." + 9;
                }
                if (user.charAt(i) == 'b' || user.charAt(i) == 'B') {
                    nu += "." + 8;
                }
                if (user.charAt(i) == 'c' || user.charAt(i) == 'C') {
                    nu += "." + 7;
                }
                if (user.charAt(i) == 'd' || user.charAt(i) == 'D') {
                    nu += "." + 6;
                }
                if (user.charAt(i) == 'e' || user.charAt(i) == 'E') {
                    nu += "." + 5;
                }
                if (user.charAt(i) == 'f' || user.charAt(i) == 'F') {
                    nu += "." + 4;
                }
                if (user.charAt(i) == 'g' || user.charAt(i) == 'G') {
                    nu += "." + 3;
                }
                if (user.charAt(i) == 'h' || user.charAt(i) == 'H') {
                    nu += "." + 2;
                }
                if (user.charAt(i) == 'i' || user.charAt(i) == 'I') {
                    nu += "." + 1;
                }
                if (user.charAt(i) == 'j' || user.charAt(i) == 'J') {
                    nu += "." + 0;
                }
                if (user.charAt(i) == 'k' || user.charAt(i) == 'K') {
                    nu += "." + 21;
                }
                if (user.charAt(i) == 'l' || user.charAt(i) == 'L') {
                    nu += "." + 22;
                }
                if (user.charAt(i) == 'm' || user.charAt(i) == 'M') {
                    nu += "." + 23;
                }
                if (user.charAt(i) == 'n' || user.charAt(i) == 'N') {
                    nu += "." + 24;
                }
                if (user.charAt(i) == 'o' || user.charAt(i) == 'O') {
                    nu += "." + 25;
                }
                if (user.charAt(i) == 'p' || user.charAt(i) == 'P') {
                    nu += "." + 26;
                }
                if (user.charAt(i) == 'q' || user.charAt(i) == 'Q') {
                    nu += "." + 27;
                }
                if (user.charAt(i) == 'r' || user.charAt(i) == 'R') {
                    nu += "." + 28;
                }
                if (user.charAt(i) == 's' || user.charAt(i) == 'S') {
                    nu += "." + 29;
                }
                if (user.charAt(i) == 't' || user.charAt(i) == 'T') {
                    nu += "." + 31;
                }
                if (user.charAt(i) == 'u' || user.charAt(i) == 'U') {
                    nu += "." + 32;
                }
                if (user.charAt(i) == 'v' || user.charAt(i) == 'V') {
                    nu += "." + 33;
                }
                if (user.charAt(i) == 'x' || user.charAt(i) == 'X') {
                    nu += "." + 34;
                }
                if (user.charAt(i) == 'y' || user.charAt(i) == 'Y') {
                    nu += "." + 35;
                }
                if (user.charAt(i) == 'z' || user.charAt(i) == 'Z') {
                    nu += "." + 36;
                }
                if (user.charAt(i) == '1') {
                    nu += ".z";
                }
                if (user.charAt(i) == '2') {
                    nu += ".y";
                }
                if (user.charAt(i) == '3') {
                    nu += ".x";
                }
                if (user.charAt(i) == '4') {
                    nu += ".w";
                }
                if (user.charAt(i) == '5') {
                    nu += ".v";
                }
                if (user.charAt(i) == '6') {
                    nu += ".u";
                }
                if (user.charAt(i) == '7') {
                    nu += ".t";
                }
                if (user.charAt(i) == '8') {
                    nu += ".s";
                }
                if (user.charAt(i) == '9') {
                    nu += ".r";
                }
                if (user.charAt(i) == '0') {
                    nu += ".q";
                }
            }
            for (int i = 0; i < senha.length(); i++) {
                if (senha.charAt(i) == 'a' || senha.charAt(i) == 'A') {
                    ns += "." + 9;
                }
                if (senha.charAt(i) == 'b' || senha.charAt(i) == 'B') {
                    ns += "." + 8;
                }
                if (senha.charAt(i) == 'c' || senha.charAt(i) == 'C') {
                    ns += "." + 7;
                }
                if (senha.charAt(i) == 'd' || senha.charAt(i) == 'D') {
                    ns += "." + 6;
                }
                if (senha.charAt(i) == 'e' || senha.charAt(i) == 'E') {
                    ns += "." + 5;
                }
                if (senha.charAt(i) == 'f' || senha.charAt(i) == 'F') {
                    ns += "." + 4;
                }
                if (senha.charAt(i) == 'g' || senha.charAt(i) == 'G') {
                    ns += "." + 3;
                }
                if (senha.charAt(i) == 'h' || senha.charAt(i) == 'H') {
                    ns += "." + 2;
                }
                if (senha.charAt(i) == 'i' || senha.charAt(i) == 'I') {
                    ns += "." + 1;
                }
                if (senha.charAt(i) == 'j' || senha.charAt(i) == 'J') {
                    ns += "." + 0;
                }
                if (senha.charAt(i) == 'k' || senha.charAt(i) == 'K') {
                    ns += "." + 21;
                }
                if (senha.charAt(i) == 'l' || senha.charAt(i) == 'L') {
                    ns += "." + 22;
                }
                if (senha.charAt(i) == 'm' || senha.charAt(i) == 'M') {
                    ns += "." + 23;
                }
                if (senha.charAt(i) == 'n' || senha.charAt(i) == 'N') {
                    ns += "." + 24;
                }
                if (senha.charAt(i) == 'o' || senha.charAt(i) == 'O') {
                    ns += "." + 25;
                }
                if (senha.charAt(i) == 'p' || senha.charAt(i) == 'P') {
                    ns += "." + 26;
                }
                if (senha.charAt(i) == 'q' || senha.charAt(i) == 'Q') {
                    ns += "." + 27;
                }
                if (senha.charAt(i) == 'r' || senha.charAt(i) == 'R') {
                    ns += "." + 28;
                }
                if (senha.charAt(i) == 's' || senha.charAt(i) == 'S') {
                    ns += "." + 29;
                }
                if (senha.charAt(i) == 't' || senha.charAt(i) == 'T') {
                    ns += "." + 31;
                }
                if (senha.charAt(i) == 'u' || senha.charAt(i) == 'U') {
                    ns += "." + 32;
                }
                if (senha.charAt(i) == 'v' || senha.charAt(i) == 'V') {
                    ns += "." + 33;
                }
                if (senha.charAt(i) == 'w' || senha.charAt(i) == 'W') {
                    ns += "." + 34;
                }
                if (senha.charAt(i) == 'x' || senha.charAt(i) == 'X') {
                    ns += "." + 35;
                }
                if (senha.charAt(i) == 'y' || senha.charAt(i) == 'Y') {
                    ns += "." + 36;
                }
                if (senha.charAt(i) == 'z' || senha.charAt(i) == 'Z') {
                    ns += "." + 37;
                }
                if (senha.charAt(i) == '1') {
                    ns += ".z";
                }
                if (senha.charAt(i) == '2') {
                    ns += ".y";
                }
                if (senha.charAt(i) == '3') {
                    ns += ".x";
                }
                if (senha.charAt(i) == '4') {
                    ns += ".w";
                }
                if (senha.charAt(i) == '5') {
                    ns += ".v";
                }
                if (senha.charAt(i) == '6') {
                    ns += ".u";
                }
                if (senha.charAt(i) == '7') {
                    ns += ".t";
                }
                if (senha.charAt(i) == '8') {
                    ns += ".s";
                }
                if (senha.charAt(i) == '9') {
                    ns += ".r";
                }
                if (senha.charAt(i) == '0') {
                    ns += ".q";
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao criptografar" + e.getMessage());
        }
        return true;
    }

    /**
     * Descriptografar a senha e o usuario
     *
     * @param nu User do adm criptografado
     * @param ns Senha do adm criptografado
     * @return Um boolean para verificação
     */
    public boolean descriptografar(String nu, String ns) {
        String l = "", li = "";
        nu+=".";
        ns+=".";
        try {
            for (int i = 0; i < nu.length(); i++) {
                if (nu.charAt(i) == '.') {
                    verificarUser(l);
                    user += "";
                    l = "";
                } else {
                        l += nu.charAt(i);

                    }
            }
            setUser(user);
            for (int i = 0; i < ns.length(); i++) {
                if (ns.charAt(i) == '.') {
                    verificarSenha(li);
                    senha += "";
                    li = "";
                } else {
                        li += ns.charAt(i);

                     
                }
            }
            setSenha(senha);
        } catch (Exception e) {
            System.out.println("Erro ao descriptografar" + e.getMessage());
        }
        return true;
    }
     /**
     * Método que verifica a entrada de um caracter criptografado
     * @param l Caracter criptografado
     */
    private void verificarUser(String l){
        
                if ("9".equals(l)) {
                    user += "a";
                }
                if ("8".equals(l)) {
                    user += "b";
                }
                if ("7".equals(l)) {
                    user += "c";
                }
                if ("6".equals(l)) {
                    user += "d";
                }
                if ("5".equals(l)) {
                    user += "e";
                }
                if ("4".equals(l)) {
                    user += "f";
                }
                if ("3".equals(l)) {
                    user += "g";
                }
                if ("2".equals(l)) {
                    user += "h";
                }
                if ("1".equals(l)) {
                    user += "i";
                }
                if ("0".equals(l)) {
                    user += "j";
                }
                if ("21".equals(l)) {
                    user += "k";
                }
                if ("22".equals(l)) {
                    user += "l";
                }
                if ("23".equals(l)) {
                    user += "m";
                }
                if ("24".equals(l)) {
                    user += "n";
                }
                if ("25".equals(l)) {
                    user += "o";
                }
                if ("26".equals(l)) {
                    user += "p";
                }
                if ("27".equals(l)) {
                    user += "q";
                }
                if ("28".equals(l)) {
                    user += "r";
                }
                if ("29".equals(l)) {
                    user += "s";
                }
                if ("31".equals(l)) {
                    user += "t";
                }
                if ("32".equals(l)) {
                    user += "u";
                }
                if ("33".equals(l)) {
                    user += "v";
                }
                if ("34".equals(l)) {
                    user += "w";
                }
                if ("35".equals(l)) {
                    user += "x";
                }
                if ("36".equals(l)) {
                    user += "y";
                }
                if ("37".equals(l)) {
                    user += "z";
                }
                if ("z".equals(l)) {
                    user += "1";
                }
                if ("y".equals(l)) {
                    user += "2";
                }
                if ("x".equals(l)) {
                    user += "3";
                }
                if ("w".equals(l)) {
                    user += "4";
                }
                if ("v".equals(l)) {
                    user += "5";
                }
                if ("u".equals(l)) {
                    user += "6";
                }
                if ("t".equals(l)) {
                    user += "7";
                }
                if ("s".equals(l)) {
                    user += "8";
                }
                if ("r".equals(l)) {
                    user += "9";
                }
                if ("q".equals(l)) {
                    user += "0";
                }
    }
    /**
     * Método que verifica a entrada de um caracter criptografado
     * @param li Caracter criptografado
     */
    private void verificarSenha(String li){
            
                if (li.equals("9")) {
                    senha += "a";
                }
                if ("8".equals(li)) {
                    senha += "b";
                }
                if ("7".equals(li)) {
                    senha += "c";
                }
                if ("6".equals(li)) {
                    senha += "d";
                }
                if ("5".equals(li)) {
                    senha += "e";
                }
                if ("4".equals(li)) {
                    senha += "f";
                }
                if ("3".equals(li)) {
                    senha += "g";
                }
                if ("2".equals(li)) {
                    senha += "h";
                }
                if ("1".equals(li)) {
                    senha += "i";
                }
                if ("0".equals(li)) {
                    senha += "j";
                }
                if ("21".equals(li)) {
                    senha += "k";
                }
                if ("22".equals(li)) {
                    senha += "l";
                }
                if ("23".equals(li)) {
                    senha += "m";
                }
                if ("24".equals(li)) {
                    senha += "n";
                }
                if ("25".equals(li)) {
                    senha += "o";
                }
                if ("26".equals(li)) {
                    senha += "p";
                }
                if ("27".equals(li)) {
                    senha += "q";
                }
                if ("28".equals(li)) {
                    senha += "r";
                }
                if ("29".equals(li)) {
                    senha += "s";
                }
                if ("31".equals(li)) {
                    senha += "t";
                }
                if ("32".equals(li)) {
                    senha += "u";
                }
                if ("33".equals(li)) {
                    senha += "v";
                }
                if ("34".equals(li)) {
                    senha += "w";
                }
                if ("35".equals(li)) {
                    senha += "x";
                }
                if ("36".equals(li)) {
                    senha += "y";
                }
                if ("37".equals(li)) {
                    senha += "z";
                }
                if ("z".equals(li)) {
                    senha += "1";
                }
                if ("y".equals(li)) {
                    senha += "2";
                }
                if ("x".equals(li)) {
                    senha += "3";
                }
                if ("w".equals(li)) {
                    senha += "4";
                }
                if ("v".equals(li)) {
                    senha += "5";
                }
                if ("u".equals(li)) {
                    senha += "6";
                }
                if ("t".equals(li)) {
                    senha += "7";
                }
                if ("s".equals(li)) {
                    senha += "8";
                }
                if ("r".equals(li)) {
                    senha += "9";
                }
                if ("q".equals(li)) {
                    senha += "0";
                }
    }
    /**
     * Construtor do arquivo
     */
    public Dados() {
        f = new File("dir\\bin\\cod.txt");
    }

    public String getUser() {

        ler();
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

}
