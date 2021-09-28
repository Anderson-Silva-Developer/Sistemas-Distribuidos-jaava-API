package br.com.andersonsilva.controllers;

import br.com.andersonsilva.model.User;
import br.com.andersonsilva.model.WeatheForecast;
import br.com.andersonsilva.repository.UserRepository;
import br.com.andersonsilva.service.WeatheForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/search")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    WeatheForecastService weatheForecastService;

    @GetMapping("/weather/{country}/{state}")
    public ResponseEntity<WeatheForecast> search(@PathVariable("country") String country,@PathVariable("state") String state) throws IOException {
        System.out.println("state "+state+"  country "+country);
        WeatheForecast weatheForecast=this.weatheForecastService.getWeatherForecast(country,state);
        return ResponseEntity.ok(weatheForecast);
    }
    @GetMapping("/t/{sms}")
    public void sendSMS(@PathVariable("sms") String sms){
        System.out.println("ok"+sms);
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
