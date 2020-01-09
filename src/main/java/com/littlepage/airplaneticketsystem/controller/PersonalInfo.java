package com.littlepage.airplaneticketsystem.controller;

import com.littlepage.airplaneticketsystem.pojo.User;
import com.littlepage.airplaneticketsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * personal info
 */
@Controller
@RequestMapping("personalInfo")
public class PersonalInfo {

    /**
     * user service
     */
    @Autowired
    private UserService userService;

    /**
     * info page
     * @return
     */
    @RequestMapping("infoPage")
    public String personalInfo(){
        return "personalInfo";
    }

    /**
     * modify page
     * @return
     */
    @RequestMapping("modifyPage")
    public String modifyInfo(){
        return "modifyPersonalInfo";
    }

    /**
     * modify result page
     * @return
     */
    @RequestMapping("modifiyResult")
    public String modifyResult(){
        return "modifiyResult";
    }

    /**
     * modify process
     * @param sex user sex
     * @param age user age
     * @param identityNum user identityNum
     * @param address user address
     * @param mobileNum user mobileNum
     * @param attributes user attributes
     * @param session user session
     * @return the result of modify process
     */
    @RequestMapping("modifyProcess")
    public String modifyProcess(String sex, String age, String identityNum,
                                String address, String mobileNum,
                                RedirectAttributes attributes,
                                HttpSession session){
        if(!sex.equals("男")&&!sex.equals("女")){
            attributes.addFlashAttribute("modifymessage","性别必须为男或者女");
            return "redirect:/personalInfo/modifyPage";
        }
        if(!age.matches("\\d+")){
            attributes.addFlashAttribute("modifymessage","年龄必须为数字");
            return "redirect:/personalInfo/modifyPage";
        }
        if(!mobileNum.matches("\\d+")||mobileNum.length()!=11){
            attributes.addFlashAttribute("modifymessage","手机号码必须为11位有效数字");
            return "redirect:/personalInfo/modifyPage";
        }
        User user = (User) session.getAttribute("user");
        if(sex.equals("男")) user.setSex('M');
        else user.setSex('F');
        user.setAge(Integer.parseInt(age)).setIdentityNum(identityNum).setAddress(address).setMobileNum(mobileNum);
        boolean success = userService.updateUser(user);
        if(success) attributes.addFlashAttribute("message","修改成功");
        else attributes.addFlashAttribute("message","修改失败");
        return "redirect:/personalInfo/modifiyResult";
    }
}
