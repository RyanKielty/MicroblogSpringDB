package com.theironyard.controllers;

import com.theironyard.entities.Message;
import com.theironyard.services.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ryankielty on 1/21/17.
 */
@Controller
public class MicroblogSpringDbController {
    @Autowired
    MessageRepository messages;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        List<Message> messageList = (List<Message>) messages.findAll();
        model.addAttribute("name", session.getAttribute("userName"));
        model.addAttribute("messages", messageList);
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) throws Exception {
        if (userName == null || userName.isEmpty()) {
            throw new Exception("'Did you forget to pray today?...Go Back ... And Please Enter Your Name...");
        } else {
            session.setAttribute("userName", userName);
        }
        return "redirect:/";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String message(String text) {
        Message mess = new Message(text);
        messages.save(mess);
        return "redirect:/";
    }

    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String deleteMessage(int id) {
        messages.delete(id);
        return "redirect:/";
    }

    @RequestMapping(path = "/amend-message", method = RequestMethod.POST)
    public String editMessage(int id, String text) {
        Message mess = messages.findOne(id);
        mess.setText(text);
        messages.save(mess);
        return "redirect:/";
    }
}
