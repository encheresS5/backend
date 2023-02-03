package encheres.backoffice.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import encheres.backoffice.format.Data;
import encheres.backoffice.models.Categorie;
import encheres.backoffice.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategorieController {
    @Autowired
    CategorieService categorieService;
    //creating a get mapping that retrieves all the Categorie detail from the database
    @GetMapping("/listeCategories")
    private String getAllCategories(Model model) {
        model.addAttribute("categories", categorieService.getAllCategories());
        model.addAttribute("page", "insertionProduit");
        return "index";
    }
    //creating a get mapping that retrieves the detail of a specific categories
    @GetMapping("/{categorieid}")
    private String getCategories(@PathVariable("categorieid") int categorieid, Model model)
    {
        model.addAttribute("categorie", categorieService.getCategoriesById(categorieid));
        model.addAttribute("page", "categorie_update");
        return "index";
    }
    //creating a delete mapping that deletes a specified categories
    @DeleteMapping("/{categorieid}")
    private void delete(@PathVariable("categorieid") int categorieid)
    {
        categorieService.delete(categorieid);
    }
    //creating post mapping that post the categorie detail in the database
    @PostMapping("/new")
    private String save(@RequestParam(name = "libelle") String libelle, Model model)
    {
        Categorie categorie = new Categorie();
        categorie.setLibelle(libelle);
        categorieService.saveOrUpdate(categorie);
        return getAllCategories(model);
    }
    //creating put mapping that updates the categorie detail
    @PutMapping("/{categorieid}")
    private String update(@RequestParam(name = "libelle") String libelle, @PathVariable("categorieid") int id, Model model)
    {
        Categorie categorie = new Categorie();
        categorie.setLibelle(libelle);
        categorie.setIdCategorie(id);
        categorieService.saveOrUpdate(categorie);
        return getAllCategories(model);
    }

    @GetMapping("/toForm")
    private String toForm(Model model) {
        model.addAttribute("page", "categorie_add");
        return "index";
    }

}
