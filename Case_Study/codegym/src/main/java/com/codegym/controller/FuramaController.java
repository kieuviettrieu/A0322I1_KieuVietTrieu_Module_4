package com.codegym.controller;

import com.codegym.model.ServiceType;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.model.facitily.Service;
import com.codegym.model.person.Customer;
import com.codegym.model.person.Employee;
import com.codegym.service.contract.IAttachServiceService;
import com.codegym.service.contract.IContractDetailService;
import com.codegym.service.contract.IContractService;
import com.codegym.service.facitily.IServiceService;
import com.codegym.service.person.customer.ICustomerService;
import com.codegym.service.person.employee.IEmployeeService;
import com.codegym.service.util.inter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/furama")
public class FuramaController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IServiceService serviceService;

    @Autowired
    private IContractService contractService;

    @Autowired
    private IDivisionService divisionService;

    @Autowired
    private IEducationDegreeService educationDegreeService;

    @Autowired
    private IPositionService positionService;

    @Autowired
    private IRentTypeService rentTypeService;

    @Autowired
    private IServiceTypeService serviceTypeService;

    @Autowired
    private IAttachServiceService attachServiceService;

    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping
    public String home()
    {
        return "/home";
    }

    @GetMapping("/service")
    public String service()
    {
        return "/service/service";
    }

    @GetMapping("/list-customer")
    public ModelAndView listCustomer(@PageableDefault(value = 5) Pageable pageable)
    {
        ModelAndView modelAndView=new ModelAndView("customer/list");
        modelAndView.addObject("customers",customerService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/list-employee")
    public ModelAndView listEmployee(@PageableDefault(value = 5) Pageable pageable)
    {
        ModelAndView modelAndView=new ModelAndView("employee/list");
        modelAndView.addObject("employees",employeeService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditCustomer(@PathVariable Integer id) {
        Customer customer=customerService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("customerTypes",customerTypeService.findAll());
        return modelAndView;
    }

    @GetMapping("/edit-employee/{id}")
    public ModelAndView showEditEmployee(@PathVariable Integer id) {
        Employee employee=employeeService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("employee/edit");
        modelAndView.addObject("employee", employee);
        modelAndView.addObject("positions",positionService.findAll());
        modelAndView.addObject("divisions",divisionService.findAll());
        modelAndView.addObject("educationDegrees",educationDegreeService.findAll());
        return modelAndView;
    }

    //code chuc nang luu sau khi edit
    @PostMapping("/edit-customer")
    public ModelAndView editCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("customerTypes",customerTypeService.findAll());
        modelAndView.addObject("message", "Save customer successfully");
        return modelAndView;
    }

    @PostMapping("/edit-employee")
    public ModelAndView editEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("employee/edit");
        modelAndView.addObject("employee", employee);
        modelAndView.addObject("positions",positionService.findAll());
        modelAndView.addObject("divisions",divisionService.findAll());
        modelAndView.addObject("educationDegrees",educationDegreeService.findAll());
        modelAndView.addObject("message", "Save employee successfully");
        return modelAndView;
    }


    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteCustomer(@PathVariable Integer id) {
        Customer customer=customerService.findById(id).get();

        ModelAndView modelAndView = new ModelAndView("customer/delete");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/delete-customer")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.remove(customer.getId());
        return "redirect:/furama/list-customer";
    }

    @PostMapping("/delete-employee")
    public String deleteEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.remove(employee.getId());
        return "redirect:/furama/list-employee";
    }

    //chuc nang tim kiem customer va employee
    @PostMapping("/search-name-customer")
    public ModelAndView listSearchNameCustomer(@ModelAttribute("nameSearch") String nameSearch, @PageableDefault(value = 5) Pageable pageable)
    {
        ModelAndView modelAndView=new ModelAndView("customer/list");
        modelAndView.addObject("nameSearch",nameSearch);
        modelAndView.addObject("customers",customerService.listSearchByName(nameSearch,pageable));
        return modelAndView;
    }

    @PostMapping("/search-name-employee")
    public ModelAndView listSearchNameEmployee(@ModelAttribute("nameSearch") String nameSearch, @PageableDefault(value = 5) Pageable pageable)
    {
        ModelAndView modelAndView=new ModelAndView("employee/list");
        modelAndView.addObject("nameSearch",nameSearch);
        modelAndView.addObject("employees",employeeService.listSearchByName(nameSearch,pageable));
        return modelAndView;
    }

    @GetMapping("/delete-employee/{id}")
    public ModelAndView showDeleteEmployee(@PathVariable Integer id) {
        Employee employee=employeeService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("employee/delete");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }


    @GetMapping("/create-customer")
    public ModelAndView showCreateCustomer()
    {
        ModelAndView modelAndView=new ModelAndView("customer/create");
        modelAndView.addObject("customer",new Customer());
        modelAndView.addObject("customerTypes",customerTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("customerTypes",customerTypeService.findAll());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }

    @GetMapping("/create-employee")
    public ModelAndView showCreateEmployee()
    {
        ModelAndView modelAndView=new ModelAndView("employee/create");
        modelAndView.addObject("employee",new Employee());
        modelAndView.addObject("positions",positionService.findAll());
        modelAndView.addObject("divisions",divisionService.findAll());
        modelAndView.addObject("educationDegrees",educationDegreeService.findAll());
        return modelAndView;
    }

    @PostMapping("/create-employee")
    public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("employee/create");
        modelAndView.addObject("positions",positionService.findAll());
        modelAndView.addObject("divisions",divisionService.findAll());
        modelAndView.addObject("educationDegrees",educationDegreeService.findAll());
        modelAndView.addObject("message", "New employee created successfully");
        return modelAndView;
    }

    @GetMapping("/create-contract")
    public ModelAndView showCreateContract()
    {
        ModelAndView modelAndView=new ModelAndView("contract/create_contract");
        modelAndView.addObject("contract",new Contract());
        modelAndView.addObject("services",serviceService.findAll());
        modelAndView.addObject("customers",customerService.findAll());
        modelAndView.addObject("employees",employeeService.findAll());
        return modelAndView;
    }

    @PostMapping("/create-contract")
    public ModelAndView saveContract(@ModelAttribute("contract") Contract contract) {
        contractService.save(contract);
        ModelAndView modelAndView = new ModelAndView("contract/create_contract");
        modelAndView.addObject("contract",new Contract());
        modelAndView.addObject("services",serviceService.findAll());
        modelAndView.addObject("customers",customerService.findAll());
        modelAndView.addObject("employees",employeeService.findAll());
        modelAndView.addObject("message", "New contract created successfully");
        return modelAndView;
    }

    @GetMapping("/create-room")
    public ModelAndView showCreateRoom()
    {
        ModelAndView modelAndView=new ModelAndView("service/create_room");
        modelAndView.addObject("room",new Service());
        ServiceType serviceType=null;
        for (ServiceType serviceType1: serviceTypeService.findAll())
        {
            if(serviceType1.getServiceTypeName().equals("Room"))
            {
                serviceType=serviceType1;
                break;
            }
        }

        modelAndView.addObject("serviceType",serviceType);
        modelAndView.addObject("rentTypes",rentTypeService.findAll());
        return modelAndView;
    }

    @GetMapping("/create-house")
    public ModelAndView showCreateHouse()
    {
        ModelAndView modelAndView=new ModelAndView("service/create_house");
        modelAndView.addObject("house",new Service());
        ServiceType serviceType=null;
        for (ServiceType serviceType1: serviceTypeService.findAll())
        {
            if(serviceType1.getServiceTypeName().equals("House"))
            {
                serviceType=serviceType1;
                break;
            }
        }

        modelAndView.addObject("serviceType",serviceType);
        modelAndView.addObject("rentTypes",rentTypeService.findAll());
        return modelAndView;
    }

    @GetMapping("/create-villa")
    public ModelAndView showCreateVilla()
    {
        ModelAndView modelAndView=new ModelAndView("service/create_villa");
        modelAndView.addObject("villa",new Service());
        ServiceType serviceType=null;
        for (ServiceType serviceType1: serviceTypeService.findAll())
        {
            if(serviceType1.getServiceTypeName().equals("Villa"))
            {
                serviceType=serviceType1;
                break;
            }
        }

        modelAndView.addObject("serviceType",serviceType);
        modelAndView.addObject("rentTypes",rentTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/create-room")
    public ModelAndView saveRoom(@ModelAttribute("room") Service room) {
        serviceService.save(room);
        ModelAndView modelAndView=new ModelAndView("service/create_room");
        modelAndView.addObject("room",new Service());
        ServiceType serviceType=null;
        for (ServiceType serviceType1: serviceTypeService.findAll())
        {
            if(serviceType1.getServiceTypeName().equals("Room"))
            {
                serviceType=serviceType1;
                break;
            }
        }

        modelAndView.addObject("serviceType",serviceType);
        modelAndView.addObject("rentTypes",rentTypeService.findAll());
        modelAndView.addObject("message", "New room created successfully");
        return modelAndView;
    }

    @PostMapping("/create-house")
    public ModelAndView saveHouse(@ModelAttribute("house") Service house) {
        serviceService.save(house);
        ModelAndView modelAndView=new ModelAndView("service/create_house");
        modelAndView.addObject("house",new Service());
        ServiceType serviceType=null;
        for (ServiceType serviceType1: serviceTypeService.findAll())
        {
            if(serviceType1.getServiceTypeName().equals("House"))
            {
                serviceType=serviceType1;
                break;
            }
        }

        modelAndView.addObject("serviceType",serviceType);
        modelAndView.addObject("rentTypes",rentTypeService.findAll());
        modelAndView.addObject("message", "New house created successfully");
        return modelAndView;
    }

    @PostMapping("/create-villa")
    public ModelAndView saveVilla(@ModelAttribute("villa") Service villa) {
        serviceService.save(villa);
        ModelAndView modelAndView=new ModelAndView("service/create_villa");
        modelAndView.addObject("villa",new Service());
        ServiceType serviceType=null;
        for (ServiceType serviceType1: serviceTypeService.findAll())
        {
            if(serviceType1.getServiceTypeName().equals("Villa"))
            {
                serviceType=serviceType1;
                break;
            }
        }

        modelAndView.addObject("serviceType",serviceType);
        modelAndView.addObject("rentTypes",rentTypeService.findAll());
        modelAndView.addObject("message", "New villa created successfully");
        return modelAndView;
    }

    @GetMapping("/create-contract-detail")
    public ModelAndView showCreateContractDetail()
    {
        ModelAndView modelAndView=new ModelAndView("contract/create_contractdetail");
        modelAndView.addObject("contractDetail",new ContractDetail());

        modelAndView.addObject("attachServices",attachServiceService.findAll());
        modelAndView.addObject("contracts",contractService.findAll());
        return modelAndView;
    }

    @PostMapping("/create-contract-detail")
    public ModelAndView saveContractDetail(@ModelAttribute("contractDetail") ContractDetail contractDetail) {
        contractDetailService.save(contractDetail);
        ModelAndView modelAndView=new ModelAndView("contract/create_contractdetail");
        modelAndView.addObject("contractDetail",new ContractDetail());

        modelAndView.addObject("attachServices",attachServiceService.findAll());
        modelAndView.addObject("contracts",contractService.findAll());
        modelAndView.addObject("message", "New contract detail created successfully");
        return modelAndView;
    }

}
