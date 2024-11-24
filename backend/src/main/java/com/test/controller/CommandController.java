package com.test.controller;

import com.test.pojo.Command;
import com.test.pojo.Event;
import com.test.pojo.Users;
import com.test.response.Response;
import com.test.service.EventService;
import com.test.service.UsersService;
import com.test.service.CommandService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/command")
public class CommandController {
    @Autowired
    private CommandService commandService;

    @GetMapping("/query")
    public List<Command> queryAll(){
        return commandService.queryAll();
    }

  
    @GetMapping("/query/{id}")
    public Command queryById(@PathVariable Integer id){
        return commandService.findById(id);
    }

    /**
     
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Response delete(@PathVariable Integer id){
        commandService.deleteById(id);
        Response response = new Response();
        response.setSuccess(true);
        return response;
    }

    /**
     
     * @param command
     * @return
     */
    @PostMapping("/insert")
    public int insert(@RequestBody Command command){
        return commandService.insert(command);
    }

    /**
 
     * @param command
     * @return
     */
    @PutMapping("/update")
    public Response update(@RequestBody Command command){
        commandService.update(command);
        Response response = new Response();
        response.setSuccess(true);
        return response;
    }
}
