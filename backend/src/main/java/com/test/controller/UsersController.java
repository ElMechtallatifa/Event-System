package com.test.controller;

import com.test.pojo.Users;
import com.test.response.Response;
import com.test.service.UsersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private UsersService usersService;

  
    /**
    
     * @return
     */
    @GetMapping("/query")
    public List<Users> queryAll(){
        return usersService.queryAll();
    }

    /**
     
     */
    @GetMapping("/query/{id}")
    public Users queryById(@PathVariable Integer id){
        return usersService.findById(id);
    }

    /**
   
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Response delete(@PathVariable Integer id){
        usersService.deleteById(id);
        Response response = new Response();
        response.setSuccess(true);
        return response;
    }

    /**
    
     * @param users
     * @return
     */
    @PostMapping("/insert")
    public int insert(@RequestBody Users users){
        return usersService.insert(users);
    }

    /**
    
     * @param users
     * @return
     */
    @PutMapping("/update")
    public Response update(@RequestBody Users users){
        if(users.getUserEmail()!=null){
            Response response = new Response();
            response.setSuccess(false);
            return response;
        }
        usersService.update(users);
        Response response = new Response();
        response.setSuccess(true);
        return response;
    }

    @PutMapping("/login")
    public int login(@RequestBody Users users){
        int id = usersService.login(users);
        return id;
    }


    //String User_Email, String User_Password



}
