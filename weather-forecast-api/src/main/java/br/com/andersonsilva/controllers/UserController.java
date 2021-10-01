package br.com.andersonsilva.controllers;

import br.com.andersonsilva.error.EntityNotFoundException;
import br.com.andersonsilva.model.User;
import br.com.andersonsilva.model.WeatheForecast;
import br.com.andersonsilva.repository.UserRepository;
import br.com.andersonsilva.sendWeather.SendWeather;
import br.com.andersonsilva.service.WeatheForecastService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api_weatherForecast")
public class UserController {
    @Autowired
    WeatheForecastService weatheForecastService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/weather/{country}/{state}")
    public ResponseEntity<WeatheForecast> search(@PathVariable("country") String country, @PathVariable("state") String state) throws IOException {
        System.out.println("state " + state + "  country " + country);
        WeatheForecast weatheForecast = this.weatheForecastService.getWeatherForecast(country, state);
        if(weatheForecast!=null){
            return ResponseEntity.ok(weatheForecast);
        }else{
            throw new EntityNotFoundException("Weather not found");
        }

    }
     //EM FASE DE TESTE ENVIO DE MENSAGEM VIA WHATSAPP
//    @PostMapping("/{country}/{state}/{number}/{msm}")
//    public void sendSMS(@PathVariable("country") String country, @PathVariable("state") String state, @PathVariable("number") String number, @PathVariable("msm") String msm) throws JSONException, IOException {
//           try {
////               new SendWeather().sendMSM(country, state, number, msm);
//               SendWeather sendWeather=new SendWeather();
//
//
//           }catch (EntityNotFoundException e){
//               System.out.println(e.getMessage());
//
//           }
//
//    }

    ///user get
    @GetMapping("/{numberFone}/{passWord}")
    public ResponseEntity<User> searchUser(@PathVariable("numberFone") String numberFone, @PathVariable("passWord") String passWord) {
        User user = this.userRepository.findAllUser(numberFone, passWord);
        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            throw new EntityNotFoundException("User not found");
        }

    }

    ///user getall
    @GetMapping("/list")
    public List<User> searchUser() {
        return this.userRepository.findAll();
    }

    //user post
    @PostMapping("/add/")
    public String userAdd(@RequestBody User user) {
        try {
            User newUser = this.userRepository.save(user);
            return newUser.getNameUse();
        } catch (Exception e) {
            throw new EntityNotFoundException("Error not save");
        }
    }

    @DeleteMapping("/delete/{numberFone}/{passWord}")
    public ResponseEntity<User> userClear(@PathVariable("numberFone") String numberFone, @PathVariable("passWord") String passWord) throws Exception {
        User user = this.userRepository.findDelete(numberFone, passWord);
        if (user != null) {
            this.userRepository.delete(user);
            return ResponseEntity.ok().body(user);
        } else {
            throw new EntityNotFoundException("Error user not delete");
        }
    }

    @PutMapping("/update/{numberFone}/{passWord}")
    public ResponseEntity<User> UpdateUser(@PathVariable("numberFone") String numberFone, @PathVariable("passWord") String passWord, @RequestBody User neWuser) {

        this.userRepository.findUpdate(numberFone, passWord, neWuser.getNumberFone(), neWuser.getEmail(), neWuser.getNameUse(), neWuser.getPassWord());
        User nUser = this.userRepository.findUser(neWuser.getNumberFone(), neWuser.getPassWord());
        if (nUser != null) {
            return ResponseEntity.ok().body(nUser);
        } else {
            throw new EntityNotFoundException("Error user not update");
        }

    }
}



