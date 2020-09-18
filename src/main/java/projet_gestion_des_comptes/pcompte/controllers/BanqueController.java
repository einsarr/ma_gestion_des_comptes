package projet_gestion_des_comptes.pcompte.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import projet_gestion_des_comptes.pcompte.models.Compte;
import projet_gestion_des_comptes.pcompte.models.Operation;
import projet_gestion_des_comptes.pcompte.services.IBanqueMetier;

import java.util.List;

@Controller
public class BanqueController {

    @Autowired
    private IBanqueMetier iBanqueMetier;
    @RequestMapping("/operations")
    public String index()
    {
        return "comptes";
    }
    @RequestMapping("/consulterCompte")
    public String consulter(Model model, String numCompte)
    {
        model.addAttribute("codeCompte",numCompte);
        try{
            Compte cp = iBanqueMetier.consulterCompte(numCompte);
            List<Operation> operations = iBanqueMetier.listeOperation(numCompte);
            model.addAttribute("listeOperations",operations);
            model.addAttribute("compte",cp);
        }catch (Exception e)
        {
            model.addAttribute("exception",e);
        }
        return "comptes";
    }
    @RequestMapping("/saveOperation")
    public String saveOperation(Model model,String typeOperation,String numCompte,double montant,String numCompte2)
    {
        try{
            if(typeOperation.equals("V")){
                iBanqueMetier.verser(numCompte,montant);
            }
            else if(typeOperation.equals("R"))
            {
                iBanqueMetier.retirer(numCompte,montant);
            }
            else {
                iBanqueMetier.virement(numCompte,numCompte2,montant);
            }
        }catch (Exception e){
            model.addAttribute("error",e);
            return "redirect:/consulterCompte?numCompte="+numCompte+"&error="+e.getMessage();
        }

        return "redirect:/consulterCompte?numCompte="+numCompte;
    }
}
