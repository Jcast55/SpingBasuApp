package mx.com.gm.web;

import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Credito;
import mx.com.gm.domain.Persona;
import mx.com.gm.servicio.CreditoService;
import mx.com.gm.servicio.PersonaService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@Slf4j
public class ControladorInicio {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private CreditoService creditoService;

    @GetMapping()
    public String inicio(@AuthenticationPrincipal User user, Model model) {

        return "index";
    }

    @GetMapping("/vehiculo")
    public String inicioVehiculo(@AuthenticationPrincipal User user) {
        return "vehiculo";
    }
    /* ------ trabajador -------- */


    @GetMapping("/trabajador")
    public String inicioTrabajador(@AuthenticationPrincipal User user, Model model) {
        List<Persona> personas = personaService.listarPersonas();
        List<Credito> creditos = creditoService.getAllCredito();
        List<Credito> creditosMostrar = new ArrayList<>();
        for (Credito credito : creditos) {
            // fecha
            if (new Date().before(credito.getFechaFinal())) {
                // Por cantidad
                if (credito.getTotalF() > 700) {
                    creditosMostrar.add(credito);
                }
            }
        }
        model.addAttribute("creditosM", creditosMostrar);
        model.addAttribute("personas", personas);
        return "trabajador";
    }



    /* ------ fin -------- */

    @GetMapping("/gasto")
    public String inicioGasto(@AuthenticationPrincipal User user) {
        return "gasto";
    }

    @GetMapping("/credito")
    public String iniciocredito(@AuthenticationPrincipal User user) {
        return "credito";
    }

    @GetMapping("/cobro")
    public String inicioCobro(@AuthenticationPrincipal User user) {
        return "cobro";
    }

    @GetMapping("/ruta")
    public String inicioRuta(@AuthenticationPrincipal User user) {
        return "ruta";
    }

    @GetMapping("/admin")
    public String inicioAdmin(@AuthenticationPrincipal User user) {
        return "admin";
    }

    @GetMapping("/reporte")
    public String inicioReporte(@AuthenticationPrincipal User user) {
        return "reporte";
    }

    @GetMapping("/cliente")
    public String inicioCliente(@AuthenticationPrincipal User user) {
        return "cliente";
    }

    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(@PathVariable("idPersona") long idPersona) {
        personaService.eliminar(personaService.findByIdPersona(idPersona));
        return "redirect:/";
    }
}
