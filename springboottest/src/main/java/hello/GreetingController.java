package hello;

import hello.data.Data;
import hello.entity.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;

@Controller
    public class GreetingController {

        @GetMapping("/greeting")
        public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
            model.addAttribute("name", name);
            model.addAttribute("data", Data.accounts);
            return "greeting";
        }

        @GetMapping("/remove")
        public String remove(@RequestParam(name = "id") String id, Model model){

            int size = Data.accounts.size();
            for (int i = 0; i <size ; i++) {
                if(Data.accounts.get(i).getId().equals(id)){
                    Data.accounts.remove(i);
                    break;
                }
            }

            model.addAttribute("data", Data.accounts);
            return "greeting";
        }

        @GetMapping("/edit")
        public String edit(@RequestParam(name = "id") String id, Model model){
            for (Account account:Data.accounts) {
                if(account.getId().equals(id)){
                    model.addAttribute("account", account);
                    break;
                }
            }
            return "editpage";
        }

        @PostMapping("/update")
        public String update(@ModelAttribute Account account, Model model){

            for (Account acc:Data.accounts) {
                if(account.getId().equals(acc.getId())){
                    int indx = Data.accounts.indexOf(acc);
                    Data.accounts.set(indx, account);
                    break;
                }

            }
            model.addAttribute("data", Data.accounts);

            return "greeting";
        }


    }


