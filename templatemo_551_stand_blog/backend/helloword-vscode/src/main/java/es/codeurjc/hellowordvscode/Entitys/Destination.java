package es.codeurjc.hellowordvscode.Entitys;

import java.io.Console;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.util.*;

import javax.persistence.*;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import org.springframework.beans.factory.annotation.Autowired;

import es.codeurjc.hellowordvscode.Repositories.TripRepository;

@Entity
public class Destination {


    public Destination(){}

    public Destination(String name, String information, String infoLarga) {
        this.name = name;
        this.information=information;
        this.infoLarga=infoLarga;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;//Destination name
    private String information;//summary of destination
    private int mean;//valoration average for a destination

    @Lob
    private String infoLarga;//description of destination

    @OneToMany (cascade = CascadeType.ALL, mappedBy="destination")   
    private List<Trip> trip_list;

    @Lob
    private Blob foto;

    public int getMean(){
        return mean;
    }

    public void setMean(int numero){
        this.mean=numero;
    }

    public String getInfoLarga() {
        return infoLarga;
    }

    public void setInfoLarga(String infoLarga) {
        this.infoLarga = infoLarga;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public List<Trip> getTrip_list() {
        return trip_list;
    }

    public void setTrip_list(List<Trip> trip_list) {
        this.trip_list = trip_list;
    }

    public String getName(){
        return name;
    }

    public String getInformation(){
        return information;
    }

    public void setInformation(String information) {
        this.information=information;
    }

    public void setId(long l) {
    }

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }

    public void createPDF(){
        String outputFilePath = "document.pdf";
        try{
            //Crear un nevo documento PDF
            PdfWriter writer = new PdfWriter(outputFilePath);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document doc = new Document(pdfDoc);
            //Agregar el texto
            Paragraph para = new Paragraph(getInfoLarga());
            doc.add(para);
            //Guardar el documento
            doc.close();
        } catch(FileNotFoundException e){
            //System.out.println("Error creating PDF");
        }
    }

}
