package sample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Vault {
    String filePath;

    private ArrayList<Password> passwords = new ArrayList<>();
    PrintWriter fWriter;
    Scanner fReader;

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

    public Vault(String filePath){
        this.filePath = filePath;
        try{
            this.fReader = new Scanner(new FileInputStream(this.filePath));
            while (this.fReader.hasNextLine()){
                if (fReader.nextLine().matches("<<Entry-Start")){
                    ArrayList<String> currentPass = new ArrayList<>();
                    while (!fReader.nextLine().matches("Entry-End>>")){
                        currentPass.add(fReader.nextLine());
                    }

                }
            }
        }catch (java.io.FileNotFoundException fnf){
            System.out.println("ERROR: File for vault not found.");
        }
    }

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
