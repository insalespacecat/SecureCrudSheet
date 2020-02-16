package com.crud.sheet.web;


import com.crud.sheet.Worker;
import com.crud.sheet.data.WorkerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/")
public class HomeController {

    private WorkerRepository workerRepository;

    @Autowired
    HomeController(WorkerRepository workerRepository){
        this.workerRepository = workerRepository;
    }

    @GetMapping("/home")
    public String mainPageViewer(Model model){
        model.addAttribute("worker", new Worker());
        return "home";
    }
    @GetMapping("/view")
    @ResponseBody
    public String findAllWorkers(){
        return "<html>" + workerRepository.findAll().toString() +
                "<br/><form method=\"get\" action=\"home\"><input type=\"submit\" value=\"Return\"></form></html>";
    }
    @PostMapping("/add")
    public String addWorker(Model model, @ModelAttribute Worker worker){
        workerRepository.save((Worker) model.getAttribute("worker"));
        model.addAttribute("worker", new Worker());
        return "home";
    }
    @PostMapping("/remove")
    public String removeWorker(Model model, @ModelAttribute Worker worker){
        Worker workerFilled = (Worker) model.getAttribute("worker");
        workerRepository.delete(workerFilled);
        return "home";
    }
    @PostMapping("/deleteAll")
    public String deleteAll(){
        workerRepository.deleteAll();
        return "redirect:/home";
    }
}
