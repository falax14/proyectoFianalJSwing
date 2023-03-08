package Datos;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class C_emDB {
    private final String ALGORITHM = "AES";
    private final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
    private final String SECRET_KEY = "lJu4vqAarqqdgSkarCpU1OuNPLpxp6Ve";
    private final String FILE_NAME = "config.dat";

    public void saveData(String server, String name, String user, String pass) {
        try {
            // Cifra los datos utilizando AES
            SecretKey secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
            Cipher cipher = null;
            cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] serverBytes = cipher.doFinal(server.getBytes());
            byte[] nameBytes = cipher.doFinal(name.getBytes());
            byte[] userBytes = cipher.doFinal(user.getBytes());
            byte[] passBytes = cipher.doFinal(pass.getBytes());

            // Guarda los datos cifrados en el archivo "config.dat"
            FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(serverBytes);
            out.writeObject(nameBytes);
            out.writeObject(userBytes);
            out.writeObject(passBytes);
            out.close();
            fileOut.close();
            JOptionPane.showMessageDialog(null, "Datos guardados con éxito");

        } catch (NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException |
                 IOException | InvalidKeyException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar datos:\n" + e.getMessage());
            throw new RuntimeException(e);
        }

    }


    public String[] readData() throws Exception {
        // Recupera los datos cifrados del archivo "config.dat"
        FileInputStream fileIn = new FileInputStream(FILE_NAME);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        byte[] serverBytes = (byte[]) in.readObject();
        byte[] nameBytes = (byte[]) in.readObject();
        byte[] userBytes = (byte[]) in.readObject();
        byte[] passBytes = (byte[]) in.readObject();
        in.close();
        fileIn.close();

        // Descifra los datos utilizando AES
        SecretKey secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        String server = new String(cipher.doFinal(serverBytes));
        String name = new String(cipher.doFinal(nameBytes));
        String user = new String(cipher.doFinal(userBytes));
        String pass = new String(cipher.doFinal(passBytes));

        // Utilizar los datos descifrados
        //System.out.println("Server: " + server + "\nName: " + name + "\nUser: " + user + "\nPass: " + pass);

        return new String[]{server, name, user, pass};


    }

}

