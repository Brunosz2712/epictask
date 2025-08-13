package br.com.fiap.epictask.task;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String index(Model model) {
        var tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "index";
    }

    @GetMapping("/form")
    public String form() {
        return "form";
    }

    @PostMapping("/form")
    public String create(Task task, RedirectAttributes redirect) { //sesseion
        taskService.save(task);
        redirect.addFlashAttribute("message", "Tarefa Cadastrada com Sucesso!");
        return "redirect:/task"; //301
    }


}
