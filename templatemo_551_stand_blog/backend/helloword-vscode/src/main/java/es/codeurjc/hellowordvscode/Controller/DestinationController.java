package es.codeurjc.hellowordvscode.Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
import es.codeurjc.hellowordvscode.Services.DestinationService;

@Controller
public class DestinationController {



    @Autowired
    private DestinationRepository destinations;
    
    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private DestinationService destinationService;
   

    @GetMapping("/moreDestinations/{page}")
    public String getDestinations(Model model, @PathVariable Integer page) {
       
        List <Destination> destiantionsList = destinations.findAll(PageRequest.of(page,10)).getContent();

        model.addAttribute("destinations", destiantionsList);
        return "showDestination";
        
    }
    @RequestMapping("/destination/{name}")
    public String getDestination(Model model, @PathVariable String name){
        Destination destination = destinationRepository.findByName(name)
            .orElseThrow(() -> new EntityNotFoundException("El destino con nombre " + name + " no existe."));
        model.addAttribute("destination", destination);
        return "destination";
    }
    @RequestMapping("destination/pdf/{name}")
    public ResponseEntity<byte[]> createPDF(@PathVariable String name){
        String outputFilePath = "document.pdf";
        
        Optional<Destination> destination = this.destinations.findByName(name);
        
        try{
            //Crear un nuevo documento PDF
            PdfWriter writer = new PdfWriter(outputFilePath);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document doc = new Document(pdfDoc);
            //Agregar el texto
            Paragraph para = new Paragraph(destination.get().getLargeInformation());
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
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=document.pdf") .contentType(MediaType.APPLICATION_PDF) .body(bytes);

        } catch(FileNotFoundException e){
            e.printStackTrace();
            //https://springhow.com/spring-boot-pdf-generation/
        }
        return null;
        
    }

    @GetMapping("/destino")
	public String destino(Model model) {
		return "destino";
	}
	

	
	@PostMapping("/destino")
	public String showDestination(@RequestParam(name = "nombre") String nombre, Model model) {
	  Optional<Destination> destination = destinationRepository.findByName(nombre);
	  model.addAttribute("destino", destination);
	  return "destino";
	}

    @GetMapping("/addDestination")
	public String showAgregarDestinos() {
		return "addDestination";
	}
	
	@PostMapping("/addDestination")
	public String agregarDestinos(Model model, @RequestParam String name, @RequestParam String information, RedirectAttributes redirectAttrs) throws IOException {
		Destination destino = new Destination();
		destino.setName(name);
		destino.setInformation(information);
		destinationRepository.save(destino);
		model.addAttribute("nuevoDestino", destino);
    	redirectAttrs.addFlashAttribute("message", "Destino añadido con éxito");
    	return "redirect:/admin";
	}

    /*@GetMapping("/editarDestinos/{name}")
	public String editarDestino(Model model, @PathVariable String name) {
  		Optional<Destination> destino = destinationService.findByName(name);
  		if (destino.isPresent()) {
    		model.addAttribute("destino", destino.get());
   	 		return "editarDestino";
  		} else {
    		return "error";
  		}
	}

	@PostMapping("/editarDestinos")
	public String editarDestinosProceso(Model model, Destination destino, boolean removeImage,MultipartFile imageField) throws IOException, SQLException {

		//updateImage(destination, removeImage, imageField);

		destinationService.save(destino);

		model.addAttribute("destinoName", destino.getName());

		return "redirect:/editarDestinos/"+destino.getName();
	}*/


    



    
}
