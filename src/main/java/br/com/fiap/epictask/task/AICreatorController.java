package br.com.fiap.epictask.task;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/AI")
@RequiredArgsConstructor
public class AICreatorController {

    private final AICreatorService aiCreatorService;
    private final MessageSource messageSource;

    public AICreatorController(MessageSource messageSource) {
        this.messageSource = messageSource;
        aiCreatorService = null;
    }

    @GetMapping
    public String index(Model model){
        var tasks = aiCreatorService.getAllAICreators();
        model.addAttribute("AICreators", aiCreatorService);
        return "index";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("AICreator", new AICreator());
        return "form";
    }

    @PostMapping("/form")
    public String create(@Valid AICreator aiCreator, BindingResult result, RedirectAttributes redirect ){ //biding

        if(result.hasErrors()) return "form";

        var message = messageSource.getMessage("aiCreator.create.success", null, LocaleContextHolder.getLocale());
        aiCreatorService.save(aiCreator);
        redirect.addFlashAttribute("message", message);
        return "redirect:/AI"; //301
    }
}
