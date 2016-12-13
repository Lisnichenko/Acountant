package ua.andriy.acc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.andriy.acc.entities.*;
import ua.andriy.acc.entities.Enums.CounterpartyStatusEnum;
import ua.andriy.acc.repository.*;

import javax.validation.Valid;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Set;

/**
 * Created by andriy on 11/19/16.
 */
@Controller
public class CounterpartyController {
    protected static final String BASE_URL = "counterparty";

    @Autowired
    CounterpartyRepository counterpartyR;
    @Autowired
    DocumentRepository documentR;
    @Autowired
    AddressRepository addressR;
    @Autowired
    ContactsRepository contactsR;
    @Autowired
    FinanceRepository financeR;

    @RequestMapping(value = BASE_URL,method = RequestMethod.GET)
    public String getCounterpartyList(@RequestParam(value = "status",required = false) CounterpartyStatusEnum status,
                                      Model model){
        if (status != null){ model.addAttribute("counterparty", counterpartyR.findByStatus(status)); }
        else { model.addAttribute("counterparty", counterpartyR.findAll()); }
        return "counterparty_list";
    }

    @RequestMapping(value = BASE_URL+"/add",method = RequestMethod.GET)
    public String getCounterpartyNew(Model model){
        model.addAttribute("counterparty",new Counterparty());
        model.addAttribute("url","~/"+BASE_URL+"/add");
        return "counterparty_add";
    }

    @RequestMapping(value = BASE_URL+"/add",method = RequestMethod.POST)
    public String CounterpartySave(@Valid @ModelAttribute(value = "counterparty") Counterparty counterparty,
                                     BindingResult result,
                                     Model model){
        if(result.hasErrors()){
            //TODO: need to check and add logic if required
           // System.out.println("errors exists");
        }

        counterparty.setLastStatus(new Date());
        counterpartyR.save(counterparty);
        return "redirect:/" + BASE_URL;
    }

    @RequestMapping(value = BASE_URL+"/{id}",method = RequestMethod.GET)
    public String CounterpartyEdit(@PathVariable(value="id") Long id, Model model){
        Counterparty cp = counterpartyR.findOne(id);
        if (cp == null ){ cp = new Counterparty(); }

        model.addAttribute("counterparty",cp);
        model.addAttribute("url","~/"+BASE_URL+"/add");
        return "counterparty_add";
    }

    /*
    * Related All Actions, get/delete Objects
    * */
    @RequestMapping(value = BASE_URL+"/{id}/{action}",method = RequestMethod.GET)
    public String showActions(@PathVariable(value="id") Long id,
                                   @PathVariable(value="action") String action,
                                   Model model){
        Counterparty cp = counterpartyR.findOne(id);
        model.addAttribute("counterpartyId", id);
        if (cp == null ){
            return "redirect:/" + BASE_URL;
        }

        if(action.equals("document")){
            Set<Document> documents = documentR.findByCounterparty(cp);
            if(documents == null ) {return "redirect:/" + BASE_URL + "/" + id + "/" + action + "/add"; }
            model.addAttribute("document", documents);
        } else if(action.equals("address")){
            Set<Address> addresses = addressR.findByCounterparty(cp);
            if(addresses == null ) {return "redirect:/" + BASE_URL + "/" + id + "/" + action + "/add"; }
            model.addAttribute("address", addresses);
        } else if(action.equals("contacts")){
            Set<Contacts> contacts = contactsR.findByCounterparty(cp);
            if(contacts == null ) {return "redirect:/" + BASE_URL + "/" + id + "/" + action + "/add"; }
            model.addAttribute("contacts", contacts);
        } else if(action.equals("finance")){
            Set<Finance> finances = financeR.findByCounterparty(cp);
            if(finances == null ) {return "redirect:/" + BASE_URL + "/" + id + "/" + action + "/add"; }
            model.addAttribute("finance", finances);
        } else {
            return "redirect:/" + BASE_URL;
        }

        return action;
    }

    @RequestMapping(value = BASE_URL+"/{counterpartyId}/{action}/{actionId}/delete",method = RequestMethod.GET)
    public String deleteActions(@PathVariable(value="counterpartyId") Long counterpartyId,
                                 @PathVariable(value="action") String action,
                                 @PathVariable(value="actionId") Long actionId,
                                 Model model){
        if(action.equals("document")){ documentR.delete(actionId); }
        else if(action.equals("address")){ addressR.delete(actionId); }
        else if(action.equals("contacts")){ contactsR.delete(actionId); }
        else if(action.equals("finance")){ financeR.delete(actionId); }
        else { return "redirect:/" + BASE_URL; }
        return "redirect:/" + BASE_URL + "/"+ counterpartyId + "/"+action;
    }

    @RequestMapping(value = BASE_URL+"/{id}/{action}/add",method = RequestMethod.GET)
    public String newAction(@PathVariable(value="id") Long counterpartyId,
                            @PathVariable(value="action") String action,
                            Model model){
        if(action.equals("document")){ model.addAttribute("document", new Document());}
        else if(action.equals("address")){ model.addAttribute("address", new Address()); }
        else if(action.equals("contacts")){ model.addAttribute("contacts", new Contacts()); }
        else if(action.equals("finance")){ model.addAttribute("finance", new Finance()); }
        else { return "redirect:/" + BASE_URL; }
        model.addAttribute("url","~/"+BASE_URL+"/"+ counterpartyId +"/"+ action +"/add");
        return action + "_add";
    }

    @RequestMapping(value = BASE_URL+"/{id}/{action}/{actionId}/edit",method = RequestMethod.GET)
    public String editAction(@PathVariable(value="id") Long counterpartyId,
                            @PathVariable(value="action") String action,
                            @PathVariable(value="actionId") Long actionId,
                            Model model){
        if(action.equals("document")){ model.addAttribute("document", documentR.findOne(actionId));}
        else if(action.equals("address")){ model.addAttribute("address", addressR.findOne(actionId)); }
        else if(action.equals("contacts")){ model.addAttribute("contacts", contactsR.findOne(actionId)); }
        else if(action.equals("finance")){ model.addAttribute("finance", financeR.findOne(actionId)); }
        else { return "redirect:/" + BASE_URL; }
        if(model.asMap().get(action) == null){
            return "redirect:/" + BASE_URL + "/"+ counterpartyId + "/" + action;
        }
        model.addAttribute("url","~/"+BASE_URL+"/"+ counterpartyId +"/"+ action +"/add");
        return action + "_add";
    }
    // Related DOCUMENTS
    @RequestMapping(value = BASE_URL+"/{id}/document/add",method = RequestMethod.POST)
    public String documentSave(@Valid @ModelAttribute(value = "document") Document document,
                               @PathVariable(value="id") Long counterpartyId,
                                   BindingResult result,
                                   Model model){
        if(result.hasErrors()){
            //TODO: need to check and add logic if required
            return "document_add";
        }
        Counterparty cp = counterpartyR.findOne(counterpartyId);
        document.setCounterparty(cp);
        documentR.save(document);
        return "redirect:/" + BASE_URL + "/"+ counterpartyId + "/document";
    }
    // Related ADDRESS
    @RequestMapping(value = BASE_URL+"/{id}/address/add",method = RequestMethod.POST)
    public String addressSave(@Valid @ModelAttribute(value = "address") Address address,
                               @PathVariable(value="id") Long counterpartyId,
                               BindingResult result,
                               Model model){
        if(result.hasErrors()){
            //TODO: need to check and add logic if required
            return "address_add";
        }
        Counterparty cp = counterpartyR.findOne(counterpartyId);
        address.setCounterparty(cp);
        addressR.save(address);
        return "redirect:/" + BASE_URL + "/"+ counterpartyId + "/address";
    }
    // Related CONTACTS
    @RequestMapping(value = BASE_URL+"/{id}/contacts/add",method = RequestMethod.POST)
    public String contactsSave(@Valid @ModelAttribute(value = "contacts") Contacts contacts,
                              @PathVariable(value="id") Long counterpartyId,
                              BindingResult result,
                              Model model){
        if(result.hasErrors()){
            //TODO: need to check and add logic if required
            return "contacts_add";
        }
        Counterparty cp = counterpartyR.findOne(counterpartyId);
        contacts.setCounterparty(cp);
        contactsR.save(contacts);
        return "redirect:/" + BASE_URL + "/"+ counterpartyId + "/contacts";
    }
    // Related FINANCE
    @RequestMapping(value = BASE_URL+"/{id}/finance/add",method = RequestMethod.POST)
    public String financeSave(@Valid @ModelAttribute(value = "finance") Finance finance,
                              @PathVariable(value="id") Long counterpartyId,
                              BindingResult result,
                              Model model){
        if(result.hasErrors()){
            //TODO: need to check and add logic if required
            return "finance_add";
        }
        Counterparty cp = counterpartyR.findOne(counterpartyId);
        finance.setCounterparty(cp);
        financeR.save(finance);
        return "redirect:/" + BASE_URL + "/"+ counterpartyId + "/finance";
    }

}