package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Kamil Seweryn
 */

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    @Autowired
    private DbService dbService;

    public String buildTrelloCardEmail(String message) {
        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/tasks_frontend_local");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("goodbye_message", "Thank you for visit my " + adminConfig.getAppName() + "!");
        context.setVariable("company_details", "created by " + adminConfig.getCompanyName());
        context.setVariable("company_phone", "Call to us " + adminConfig.getCompanyPhone());
        context.setVariable("show_button", false);
        context.setVariable("is_friend", false);
        context.setVariable("adminConfig", adminConfig);
        context.setVariable("application_functionality", functionality);
        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    public String buildNumberOfTasksMail(String message) {
        List<String> tasks = new ArrayList<>();
        dbService.getAllTasks().stream().forEach(task -> tasks.add(task.getTitle()));

        String button = "Visit My Task Board!";
        boolean isEmptyList = tasks.isEmpty();
        if(isEmptyList) {
            button = "Add new tasks!";
        }

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/tasks_frontend_local");
        context.setVariable("preview_message", "Daily list of Your tasks in Trello");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("button", button);
        context.setVariable("show_button", true);
        context.setVariable("is_empty_list", isEmptyList);
        context.setVariable("tasks_list", tasks);
        context.setVariable("goodbye_message", "Thank you for visit " + adminConfig.getAppName() + "!");
        context.setVariable("company_details", "created by " + adminConfig.getCompanyName());
        context.setVariable("company_phone", "Call to us " + adminConfig.getCompanyPhone());
        context.setVariable("adminConfig", adminConfig);
        return templateEngine.process("mail/number-tasks-mail", context);
    }
}