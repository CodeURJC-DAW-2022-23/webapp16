package es.codeurjc.hellowordvscode.Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import es.codeurjc.hellowordvscode.Entitys.Destination;
import es.codeurjc.hellowordvscode.Repositories.DestinationRepository;

@Controller
public class DestinationController {



    @Autowired
    private DestinationRepository destinations;
    
    
    @GetMapping("/")
    public Page<Destination> getDestinations(@RequestParam(required = false) Pageable page) {
       
            return destinations.findAll(PageRequest.of(0, 10));
        
    }
    @RequestMapping("/pdf/{id}")
    public ResponseEntity<byte[]> createPDF(@PathVariable long id){
        String outputFilePath = "document.pdf";
        
        Optional<Destination> destination = this.destinations.findById(id);
        
        try{
            //Crear un nuevo documento PDF
            PdfWriter writer = new PdfWriter(outputFilePath);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document doc = new Document(pdfDoc);
            //Agregar el texto
            Paragraph para = new Paragraph(destination.get().getInfoLarga());
            doc.add(para);
            //Guardar el documento
            doc.close();
            /* Setup Source and target I/O streams */
            //ByteArrayInputStream source = new ByteArrayInputStream();
            FileInputStream source = new FileInputStream(outputFilePath);
            //ByteArrayOutputStream target = new ByteArrayOutputStream();
            /* Call convert method */
            //HtmlConverter.convertToPdf(orderHtml, target, converterProperties);  
            /* extract output as bytes */
            byte[] bytes = null;
            try {
                bytes = source.readAllBytes();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                source.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //byte[] bytes = target.toByteArray();
            /* Send the response as downloadable PDF */
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=order.pdf") .contentType(MediaType.APPLICATION_PDF) .body(bytes);

        } catch(FileNotFoundException e){
            e.printStackTrace();
            //https://springhow.com/spring-boot-pdf-generation/
        }
        return null;
        
    }



    
}
