package br.com.andersonsilva.controllers;

import br.com.andersonsilva.model.User;
import br.com.andersonsilva.model.WeatheForecast;
import br.com.andersonsilva.repository.UserRepository;
import br.com.andersonsilva.service.WeatheForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    WeatheForecastService weatheForecastService;

    @GetMapping("/weathe")
    public ResponseEntity<WeatheForecast> teste(){
        WeatheForecast weatheForecast=this.weatheForecastService.getWeatheForecast();
        return ResponseEntity.ok(weatheForecast);
    }



    @GetMapping("/{id}")
    public User user(@PathVariable("id") Long id){
        Optional<User> userFind = this.userRepository.findById(id);

        if(userFind.isPresent()){
            return userFind.get();
        }else {
            return null;
        }
    }
    @PostMapping("/")
    public User user(@RequestBody  User user){
        return this.userRepository.save(user);

    }
    @GetMapping("/list")
    public List<User> list(){

        return this.userRepository.findAll();
    }
    @GetMapping("/list/{id}")
    public List<User> listMoreThan(@PathVariable("id") Long id){

        return this.userRepository.findByIdGreaterThan(id);
    }
    @GetMapping("/findByName/{name}")
    public List<User> findByName(@PathVariable("name") String name){
        System.out.println(name);
        return this.userRepository.findByNameIgnoreCase(name);
    }

}
