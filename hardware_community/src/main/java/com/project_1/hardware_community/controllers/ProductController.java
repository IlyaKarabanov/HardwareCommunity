package com.project_1.hardware_community.controllers;

import com.project_1.hardware_community.domain.Cpu;
import com.project_1.hardware_community.domain.Gpu;
import com.project_1.hardware_community.domain.Product;
import com.project_1.hardware_community.domain.Ram;
import com.project_1.hardware_community.repositories.CpuRepository;
import com.project_1.hardware_community.repositories.GpuRepository;
import com.project_1.hardware_community.repositories.ProductRepository;
import com.project_1.hardware_community.repositories.RamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CpuRepository cpuRepository;
    @Autowired
    private GpuRepository gpuRepository;
    @Autowired
    private RamRepository ramRepository;



    @GetMapping
    public String add(Model model) {

        return "productPage";
    }

    @GetMapping("{productId}")
    public String productEditForm(@PathVariable Integer productId, Model model) {

        model.addAttribute("currentProduct", productRepository.findById(productId));
        return "productEdit";
    }

    @GetMapping("/addPage")
    public String addPage(/*Model model*/) {
        /*Cpu cpu = new Cpu();
        model.addAttribute("cpu", cpu);*/

        return "addPage";
    }

    @GetMapping("/cpu")
    public String cpuList(Model model) {

        model.addAttribute("cpuList", cpuRepository.findAll());

        return "productPage";
    }

    @GetMapping("/gpu")
    public String gpuList(Model model) {

        model.addAttribute("gpuList", gpuRepository.findAll());

        return "productPage";
    }

    @GetMapping("/ram")
    public String ramList(Model model) {

        model.addAttribute("ramList", ramRepository.findAll());

        return "productPage";
    }

    @GetMapping("/search")
    public String searchPage(Model model) {

        model.addAttribute("searchResults", productRepository.findAll());

        return "productPage";
    }

    @PostMapping("addNewProduct")
    public String addNewProduct(/*@RequestParam String brand, @RequestParam String name, Model model*/) {
        /*Product product = new Product(brand, name);

        productRepository.save(product);

        Iterable<Product> products = productRepository.findAll();

        model.addAttribute("products", products);*/

        return "productPage";
    }

    @PostMapping("search")
    public String search() {

        return "redirect:/product";
    }

    @PostMapping("deleteAll")
    public String deleteAll() {

        //productRepository.deleteAll();

        return "redirect:/product";
    }

    @PostMapping("addCpu")
    public String addCpu(@RequestParam String brandCpu,
                         @RequestParam String nameCpu,
                         @RequestParam String socket,
                         @RequestParam String coreQuantity,
                         @RequestParam String core,
                         @RequestParam String threadQuantity,
                         @RequestParam String frequency) {
        boolean formValidity = true;

        if(brandCpu.isEmpty()) {
            formValidity = false;
        }
        if(nameCpu.isEmpty()) {
            formValidity = false;
        }
        if(socket.isEmpty()) {
            formValidity = false;
        }
        if(coreQuantity.isEmpty()) {
            formValidity = false;
        }
        if(core.isEmpty()) {
            formValidity = false;
        }
        if(threadQuantity.isEmpty()) {
            formValidity = false;
        }
        if(frequency.isEmpty()) {
            formValidity = false;
        }

        if(formValidity) {
            Cpu cpu = new Cpu(brandCpu, nameCpu, socket, core, coreQuantity, threadQuantity, frequency);
            cpuRepository.save(cpu);
        }

        return ("addPage");
    }

    @PostMapping("addGpu")
    public String addGpu(@RequestParam String brandGpu,
                         @RequestParam String nameGpu,
                         @RequestParam String memoryFrequency,
                         @RequestParam String frequencyGpu,
                         @RequestParam String memoryGpu,
                         @RequestParam String typeGpu) {
        boolean formValidity = true;

        if(brandGpu.isEmpty()) {
            formValidity = false;
        }
        if(nameGpu.isEmpty()) {
            formValidity = false;
        }
        if(memoryFrequency.isEmpty()) {
            formValidity = false;
        }
        if(frequencyGpu.isEmpty()) {
            formValidity = false;
        }
        if(memoryGpu.isEmpty()) {
            formValidity = false;
        }
        if(typeGpu.isEmpty()) {
            formValidity = false;
        }

        if(formValidity) {
            Gpu gpu = new Gpu(brandGpu,nameGpu,memoryFrequency, frequencyGpu, memoryGpu, typeGpu);
            gpuRepository.save(gpu);
        }

        return("addPage");
    }

    @PostMapping("addRam")
    public String addRam(@RequestParam String brandRam,
                         @RequestParam String nameRam,
                         @RequestParam String typeRam,
                         @RequestParam String memoryRam,
                         @RequestParam String frequencyRam) {
        boolean formValidity = true;

        if(brandRam.isEmpty()) {
            formValidity = false;
        }
        if(nameRam.isEmpty()) {
            formValidity = false;
        }
        if(typeRam.isEmpty()) {
            formValidity = false;
        }
        if(memoryRam.isEmpty()) {
            formValidity = false;
        }
        if(frequencyRam.isEmpty()) {
            formValidity = false;
        }

        if(formValidity) {
            Ram ram = new Ram(brandRam, nameRam, typeRam, memoryRam, frequencyRam);
            ramRepository.save(ram);
        }

        return ("addPage");
    }

    @PostMapping("editCpu")
    public String editCpu(@RequestParam String brandCpu,
                          @RequestParam String nameCpu,
                          @RequestParam String socket,
                          @RequestParam String core,
                          @RequestParam String coreQuantity,
                          @RequestParam String threadQuantity,
                          @RequestParam String frequency,
                          @RequestParam Integer cpuId) {
        boolean formValidity = true;

        Cpu cpu = cpuRepository.findById(cpuId);

        if(brandCpu.isEmpty() || brandCpu == cpu.getBrand()) {
            formValidity = false;
        }
        if(nameCpu.isEmpty() || nameCpu == cpu.getName()) {
            formValidity = false;
        }
        if(socket.isEmpty() || socket == cpu.getSocket()) {
            formValidity = false;
        }
        if(coreQuantity.isEmpty() || coreQuantity == cpu.getCoreQuantity()) {
            formValidity = false;
        }
        if(core.isEmpty() || core == cpu.getCore()) {
            formValidity = false;
        }
        if(threadQuantity.isEmpty() || threadQuantity == cpu.getThreadQuantity()) {
            formValidity = false;
        }
        if(frequency.isEmpty() || frequency == cpu.getFrequency()) {
            formValidity = false;
        }

        if(formValidity) {
            cpu.setBrand(brandCpu);
            cpu.setName(nameCpu);
            cpu.setSocket(socket);
            cpu.setCore(core);
            cpu.setCoreQuantity(coreQuantity);
            cpu.setThreadQuantity(threadQuantity);
            cpu.setFrequency(frequency);
            cpu.change();
        }

        cpuRepository.save(cpu);

        return "redirect:/product/" + cpuId;
    }
}