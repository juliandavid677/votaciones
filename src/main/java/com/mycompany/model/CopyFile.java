/*
 * Clase que copia la imagen cargada
 */
package com.mycompany.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Julián Parra 
 * @author Germán García
 */
public class CopyFile {

    /**
     * Variable que se encarga de guarda la ruta donde se guarda la imagen
     */
    private String destination;

    /**
     * Set para guardar la ruta donde quedaran las imagenes
     */
    public CopyFile() {
        this.destination = "C:\\Users\\shhin\\Desktop\\votaciones\\src\\main\\webapp\\resources\\images\\";        
    }

    /**
     * Metodo donde  se guarda la imagen
     * @param fileName nombre de la imagen
     * @param in peso de la imagen
     * @return enviar nombre de la imagen
     */
    public String copyFile(String fileName, InputStream in) {
        String enviar = null;
        try {
            System.out.println(destination);
            OutputStream out = new FileOutputStream(new File(destination + fileName));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
            System.out.println("El archivo se ha creado con éxito!");

            DateFormat dateFormat = new SimpleDateFormat("yyyy–MM–dd HH_mm_ss");
            Date date = new Date();
            String ruta1 = destination + fileName;
            String ruta2 = destination + dateFormat.format(date) + "–" + fileName;
            System.out.println("Archivo: " + ruta1 + " Renombrado a: " + ruta2);
            File archivo = new File(ruta1);
            archivo.renameTo(new File(ruta2));
            enviar = dateFormat.format(date) + "–" + fileName;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }    
        return enviar;
    }
}
