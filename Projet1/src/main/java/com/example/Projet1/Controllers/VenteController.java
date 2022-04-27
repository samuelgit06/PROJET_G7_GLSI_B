package com.example.Projet1.Controllers;

import com.example.Projet1.Models.Vente;
import com.example.Projet1.Services.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_PDF_VALUE;

@RequestMapping("/Vente")
public class VenteController {
    @Autowired
    private VenteService venteService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private  Facture facture ;

    @GetMapping("/Index")
    public List<Vente> afficherVente(){return venteService.showAllVente();}

    @GetMapping("/Create")
    public List<Client> showCreate(){ return  clientService.showAllClient();}

    @PostMapping("/Save")
    public Vente save(@RequestBody Vente vente){
        return venteService.saveVente(vente);
    }

    @GetMapping("/Edit/{id}")
    public Vente showEdit (@PathVariable("id") int id ){return venteService.selectedVente(id);}

    @GetMapping("Delete/{id}")
    public void deleteVente (@PathVariable("id") int id ){venteService.deleteVente(id);}

    @GetMapping("/Facture/{id}")
    public void exportToPDF(@PathVariable("id") int id, HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType(APPLICATION_PDF_VALUE);
        DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd_HHmmss");
        String currentDateTime = dateFormat.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=facture_"+currentDateTime+".pdf";
        response.setHeader(headerKey, headerValue);

        facture.export(response, id);
    }
}
