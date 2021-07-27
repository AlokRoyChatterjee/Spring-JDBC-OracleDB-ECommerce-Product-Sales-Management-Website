package ecommercesales;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	
	@Autowired
	private SalesDAO dao;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<ECommerceProduct> listSale = dao.list();
		model.addAttribute("listSale", listSale);
	    return "index";
	}
	
	@RequestMapping("/new")
	public String showNewForm(Model model) {
	    ECommerceProduct product = new ECommerceSale();
	    model.addAttribute("sale", product);
	     
	    return "addingproduct";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("sale") ECommerceProduct product) {
	    dao.save(product);
	     
	    return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("changeproduct");
	    ECommerceProduct product = dao.get(id);
	    mav.addObject("sale", product);
	     
	    return mav;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("sale") ECommerceProduct product) {
	    dao.update(product);
	     
	    return "redirect:/";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable(name = "id") int id) {
	    dao.delete(id);
	    return "redirect:/";       
	}	
}
