package dn.codegym.crm.controller;

import dn.codegym.crm.dto.ProductDTO;
import dn.codegym.crm.entity.ClassRoom;
import dn.codegym.crm.entity.Product;
import dn.codegym.crm.repository.ProductRepository;
import dn.codegym.crm.service.ClassRoomService;
import dn.codegym.crm.service.ProductService;
import dn.codegym.crm.validator.ProductDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ClassRoomService classRoomService;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDTOValidator productDTOValidator;

    @InitBinder
    protected void initBinder(WebDataBinder dataBinder) {
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        if (target.getClass() == ProductDTO.class) {
            dataBinder.setValidator(productDTOValidator);
        }
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("product", new ProductDTO());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveProduct(@Valid @ModelAttribute("product") ProductDTO productDTO,
                             BindingResult result,
                             RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "product/create";
        }
        productService.create(productDTO);
        redirect.addFlashAttribute("message", "New product created successfully!");
        return "redirect:/products/list";
    }

    @GetMapping("/list")
    public ModelAndView listProducts(@RequestParam("name") Optional<String> name, Pageable pageable) {
        Page<Product> products;
        ModelAndView modelAndView = new ModelAndView("product/list");
        if (name.isPresent()) {
            products = productService.findAllByDeletedIsFalseAndNameContaining(name.get(), pageable);
            modelAndView.addObject("name", name.get());
            if (products.getTotalElements() == 0) {
                modelAndView.addObject("message", "Product name not found!");
            }
        } else {
            products = productService.findAllByDeletedIsFalse(pageable);
        }
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable String id) {
        ProductDTO productDTO = productService.findById(id);
        if (productDTO != null) {
            ModelAndView modelAndView = new ModelAndView("product/edit");
            modelAndView.addObject("product", productDTO);
            return modelAndView;
        } else {
            return new ModelAndView("error404");
        }
    }

    @GetMapping("/{id}/classes")
    public ModelAndView showClassesByProduct(@PathVariable String id, Pageable pageable) {
        Page<ClassRoom> classRooms = classRoomService.findAllByDeletedIsFalseAndIdCourse(productRepository.findById(id).orElse(null),pageable);
        if (classRooms != null) {
            ModelAndView modelAndView = new ModelAndView("product/classListView");
            modelAndView.addObject("classes", classRooms);
            return modelAndView;
        } else {
            return new ModelAndView("error404");
        }
    }

    @PostMapping("/edit")
    public String updateProduct(@Valid @ModelAttribute("product") ProductDTO productDTO,
                               BindingResult result,
                               RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "product/edit";
        }
        productService.update(productDTO);
        redirect.addFlashAttribute("message", "Product updated successfully!");
        return "redirect:/products/list";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable String id) {
        ProductDTO productDTO = productService.findById(id);
        if (productDTO != null) {
            ModelAndView modelAndView = new ModelAndView("product/delete");
            modelAndView.addObject("product", productDTO);
            return modelAndView;
        } else {
            return new ModelAndView("error404");
        }
    }

    @PostMapping("/delete")
    public String deleteProduct(@ModelAttribute("product") ProductDTO productDTO, RedirectAttributes redirect) {
        productService.delete(productDTO.getId());
        redirect.addFlashAttribute("message", "Product deleted successfully!");
        return "redirect:/products/list";
    }
}
