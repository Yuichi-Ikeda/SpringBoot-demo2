package com.example.demo2;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Controller
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/")
    public String home(@ModelAttribute Todo todo) {
        return "form";
    }

    @PostMapping("/form")
    public String result(@Validated
                        @ModelAttribute Todo todo, 
                        BindingResult result){
        if(result.hasErrors()){
          return "form";
        }
        
        todoRepository.save(todo);
        return "result";
    }
}