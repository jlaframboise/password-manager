package sample;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Vault {

    private ArrayList<Password> passwords = new ArrayList<>();
    PrintWriter fWriter;

    public ArrayList<Password> getPasswords() {
        return passwords;
    }

    public void addPassword(Password password) {
        this.passwords.add(password);
    }

    public Password getPassword(int index){
        return getPasswords().get(index);
    }

    public Vault(){    }

    public void saveVault(String filePath){
        try {
            this.fWriter = new PrintWriter(new FileOutputStream(filePath));
            for (Password p : passwords){
                fWriter.println(p.toString());
            }
            fWriter.close();
        } catch (IOException ie) {
            ie.printStackTrace();
            System.out.println("Error in saving the vault!");
        }



    }
}
