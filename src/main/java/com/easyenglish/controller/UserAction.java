package com.easyenglish.controller;

import com.easyenglish.dto.Grade;
import com.easyenglish.dto.TextVideo;
import com.easyenglish.dto.User;
import com.easyenglish.dto.VideoEnglish;
import com.easyenglish.exception.ErrorCodeConstant;
import com.easyenglish.service.GradeService;
import com.easyenglish.service.TextVideoService;
import com.easyenglish.service.UserService;
import com.easyenglish.service.VideoEnglishService;
import com.easyenglish.utils.md5.MD5Util;
import com.easyenglish.utils.regex.RegexUtils;
import com.easyenglish.vo.Page;
import com.easyenglish.vo.PageResult;
import com.easyenglish.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

@RequestMapping("user")
@Controller
public class UserAction extends BaseAction {
    @Autowired
    private UserService userService;

    @Autowired
    private TextVideoService textVideoService;

    @Autowired
    private VideoEnglishService videoEnglishService;



    @Autowired
    private GradeService gradeService;

    @ResponseBody
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public Result login(String username, String inputPassword, String validateCode, HttpServletRequest request) {

//        if(request.getSession().getAttribute("user")!=null){
//            return Result.falseResult(ErrorCodeConstant.E00011.getMessage(),
//                    ErrorCodeConstant.E00011.getCode());
//        }

        if(StringUtils.isBlank(username)){
            return Result.falseResult(ErrorCodeConstant.E00009.getMessage(),
                    ErrorCodeConstant.E00009.getCode());
        }

        if(StringUtils.isBlank(inputPassword)){
            return Result.falseResult(ErrorCodeConstant.E00010.getMessage(),
                    ErrorCodeConstant.E00010.getCode());
        }

        if(StringUtils.isBlank(validateCode)){
            return Result.falseResult(ErrorCodeConstant.E00006.getMessage(),
                    ErrorCodeConstant.E00006.getCode());
        }


        //账户名格式验证
        String usernameRegEx = "^[0-9A-Za-z]{6,20}$";
//        System.out.println(Pattern.matches(regEx, content));
        boolean usernameMatch = Pattern.matches(usernameRegEx, username);
        if(!usernameMatch){
            return Result.falseResult(ErrorCodeConstant.E00013.getMessage(),
                    ErrorCodeConstant.E00013.getCode());
        }


        //验证码判断

        String verifyCode = (String) request.getSession().getAttribute("verifyCode");

        if(!verifyCode.endsWith(validateCode)){
            return Result.falseResult(ErrorCodeConstant.E00007.getMessage(),
                    ErrorCodeConstant.E00007.getCode());
        }






        User user = userService.selectByUsername(username);

        if(user==null){
            return Result.falseResult(ErrorCodeConstant.E00005.getMessage(),
                    ErrorCodeConstant.E00005.getCode());
        }else{
            String password = user.getPassword();
            boolean isCorrect =  MD5Util.verify(inputPassword,password);
            if(isCorrect){
                request.getSession().setAttribute("user",user);
                return new Result(true,
                        ErrorCodeConstant.E00001.getMessage(),
                        ErrorCodeConstant.E00001.getCode());
            }else{
                return Result.falseResult(ErrorCodeConstant.E00005.getMessage(),
                        ErrorCodeConstant.E00005.getCode());
            }

        }
    }

    @ResponseBody
    @RequestMapping(value = "/userLogout", method = RequestMethod.POST)
    public Result logout(HttpServletRequest request) {
        request.getSession().setAttribute("user",null);
        return Result.trueResult(ErrorCodeConstant.E00012.getMessage(),ErrorCodeConstant.E00012.getCode());
    }


    @ResponseBody
    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    public Result register(String username, String inputPassword, String confirmPassword, String name, String validateCode, String email, HttpServletRequest request) {
        if(request.getSession().getAttribute("user")!=null){
            return Result.falseResult(ErrorCodeConstant.E00011.getMessage(),
                    ErrorCodeConstant.E00011.getCode());
        }

        if(StringUtils.isBlank(username)){
            return Result.falseResult(ErrorCodeConstant.E00009.getMessage(),
                    ErrorCodeConstant.E00009.getCode());
        }

        if(StringUtils.isBlank(inputPassword)){
            return Result.falseResult(ErrorCodeConstant.E00010.getMessage(),
                    ErrorCodeConstant.E00010.getCode());
        }


        if(StringUtils.isBlank(confirmPassword)){
            return Result.falseResult(ErrorCodeConstant.E00010.getMessage(),
                    ErrorCodeConstant.E00010.getCode());
        }




        if(StringUtils.isBlank(validateCode)){
            return Result.falseResult(ErrorCodeConstant.E00006.getMessage(),
                    ErrorCodeConstant.E00006.getCode());
        }






        //账户名格式验证
        boolean usernameMatch = RegexUtils.isUsername(username);
        if(!usernameMatch){
            return Result.falseResult(ErrorCodeConstant.E00013.getMessage(),
                    ErrorCodeConstant.E00013.getCode());
        }


        User select = userService.selectByUsername(username);
        if(select!=null){
            return Result.falseResult(ErrorCodeConstant.E00017.getMessage(),
                    ErrorCodeConstant.E00017.getCode());
        }


        //邮箱格式验证
        boolean emailMatch = RegexUtils.isEmail(email);
        if(!emailMatch){
            return Result.falseResult(ErrorCodeConstant.E00014.getMessage(),
                    ErrorCodeConstant.E00014.getCode());
        }


        //密码格式验证
        boolean passwordMatch = RegexUtils.isPassword(inputPassword);
        if(!passwordMatch){
            return Result.falseResult(ErrorCodeConstant.E00015.getMessage(),
                    ErrorCodeConstant.E00015.getCode());
        }


        boolean confirmPasswordMatch = RegexUtils.isPassword(confirmPassword);
        if(!confirmPasswordMatch){
            return Result.falseResult(ErrorCodeConstant.E00015.getMessage(),
                    ErrorCodeConstant.E00015.getCode());
        }


        if(!confirmPassword.equals(inputPassword)){
            return Result.falseResult(ErrorCodeConstant.E00016.getMessage(),
                    ErrorCodeConstant.E00016.getCode());
        }



        String inputpassword  = MD5Util.generate(inputPassword);



        User user = new User();
        user.setUsername(username);

        user.setName(name);

        user.setPassword(inputpassword);
        user.setEmail(email);

        int insertSelective = userService.insertSelective(user);
        if(insertSelective>0){
            request.getSession().setAttribute("user",user);
            return new Result(true,
                    ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());
        }else{
            return Result.falseResult(ErrorCodeConstant.E00003.getMessage(),
                    ErrorCodeConstant.E00003.getCode());
        }

    }




    @ResponseBody
    @RequestMapping(value = "/selectTextVideoByPrimaryKey", method = RequestMethod.GET)
    public Result selectTextVideoByPrimaryKey(Integer tvId){
        TextVideo selectByPrimaryKey = textVideoService.selectByPrimaryKey(tvId);

        if(tvId==null){
            return Result.falseResult(ErrorCodeConstant.E00002.getMessage(),
                    ErrorCodeConstant.E00002.getCode());
        }

        if (selectByPrimaryKey!=null) {
            return new Result(true,selectByPrimaryKey,ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }



    @ResponseBody
    @RequestMapping(value = "/selectTextVideoByKeyWordByPage", method = RequestMethod.GET)
    public Result selectTextVideoByKeyWordByPage(String keyWord, Page page){
        PageResult<TextVideo> selectByKeyWord = textVideoService.selectByKeyWordByPage(keyWord,page);


        if (selectByKeyWord!=null&&selectByKeyWord.getData().size()>0) {
            return new Result(true,selectByKeyWord, ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        }

        if (selectByKeyWord!=null&&selectByKeyWord.getData().size()==0) {
            return new Result(false, ErrorCodeConstant.E00004.getMessage(),
                    ErrorCodeConstant.E00004.getCode());

        }
        else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }


    @ResponseBody
    @RequestMapping(value = "/selectAllTextVideoByGradeByPage", method = RequestMethod.GET)
    public Result selectAllTextVideoByGradeByPage( Integer gradeId,Page page){
        System.out.println(gradeId);
        PageResult<TextVideo> selectAllByPage = textVideoService.selectAllByGradeByPage(gradeId,page);



        if (selectAllByPage!=null&&selectAllByPage.getData().size()>0) {
            return new Result(true,selectAllByPage, ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        }

        if (selectAllByPage!=null&&selectAllByPage.getData().size()==0) {
            return new Result(false, ErrorCodeConstant.E00004.getMessage(),
                    ErrorCodeConstant.E00004.getCode());

        }
        else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }


    @ResponseBody
    @RequestMapping(value = "/selectAllTextVideoByTextBookByPage", method = RequestMethod.GET)
    public Result selectAllTextVideoByTextBookByPage(Integer textbook,Page page){
        PageResult<TextVideo> selectAllByPage = textVideoService.selectAllByTextBookByPage(textbook,page);



        if (selectAllByPage!=null&&selectAllByPage.getData().size()>0) {
            return new Result(true,selectAllByPage, ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        }

        if (selectAllByPage!=null&&selectAllByPage.getData().size()==0) {
            return new Result(false, ErrorCodeConstant.E00004.getMessage(),
                    ErrorCodeConstant.E00004.getCode());

        }
        else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }





    @ResponseBody
    @RequestMapping(value = "/selectTextVideoByTitle", method = RequestMethod.GET)
    public Result selectTextVideoByTitle( String title,Page page) {
        TextVideo textVideo = textVideoService.selectTextVideoByTitle(title,page);
        if (textVideo!=null) {
            return new Result(true,textVideo,ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }


    @ResponseBody
    @RequestMapping(value = "/selectAllTextVideoByPage", method = RequestMethod.GET)
    public Result selectAllTextVideoByPage(Page page) {
        PageResult<TextVideo> selectAllByPage = textVideoService.selectAllByPage(page);
        if (selectAllByPage != null) {
            return new Result(true, selectAllByPage,
                    ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }


    @ResponseBody
    @RequestMapping(value = "/isUserLogin", method = RequestMethod.POST)
    public Result isUserLogin(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }else{
            return new Result(true, user,ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());
        }

    }




    @RequestMapping(value="/authCode")
    public void getAuthCode(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int width = 63;
        int height = 37;
        Random random = new Random();
        //设置response头信息
        //禁止缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        //生成缓冲区image类
        BufferedImage image = new BufferedImage(width, height, 1);
        //产生image类的Graphics用于绘制操作
        Graphics g = image.getGraphics();
        //Graphics类的样式
        g.setColor(this.getRandColor(200, 250));
        g.setFont(new Font("Times New Roman",0,28));
        g.fillRect(0, 0, width, height);
        //绘制干扰线
        for(int i=0;i<40;i++){
            g.setColor(this.getRandColor(130, 200));
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            g.drawLine(x, y, x + x1, y + y1);
        }

        //绘制字符
        String verifyCode = "";
        for(int i=0;i<4;i++){
            String rand = String.valueOf(random.nextInt(10));
            verifyCode = verifyCode + rand;
            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            g.drawString(rand, 13*i+6, 28);
        }
        //将字符保存到session中用于前端的验证
        request.getSession().setAttribute("verifyCode", verifyCode);


        g.dispose();

        ImageIO.write(image, "JPEG", response.getOutputStream());
        response.getOutputStream().flush();
    }

    //创建颜色
    Color getRandColor(int fc,int bc){
        Random random = new Random();
        if(fc>255)
            fc = 255;
        if(bc>255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r,g,b);
    }
    /**
     * 进行验证用户的验证码是否正确
     * @param //value 用户输入的验证码
     * @param //request HttpServletRequest对象
     * @return 一个String类型的字符串。格式为：<br/>
     *                     {"res",boolean},<br/>
     *                 如果为{"res",true}，表示验证成功<br/>
     *                 如果为{"res",false}，表示验证失败
     *
     */
/*    @RequestMapping(value="/validate")
    @ResponseBody
    public String validate(String value,HttpServletRequest request){
        String valueCode=(String)request.getSession().getAttribute("strCode");
        Map map=new HashMap();
        if(valueCode!=null){
            if(valueCode.equals(value)){
                map.put("res", true);
                return new Gson().toJson(map);
            }
        }
        map.put("res", false);
        return new Gson().toJson(map);
    }*/


        public Result selectAllGrades(){
            List<Grade> grades = gradeService.selectAll();
            if(grades!=null){
                return new Result(true, grades,
                        ErrorCodeConstant.E00001.getMessage(),
                        ErrorCodeConstant.E00001.getCode());

            } else {
                return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                        ErrorCodeConstant.E00000.getCode());
            }
        }





    @ResponseBody
    @RequestMapping(value = "/selectVideoEnglishByPrimaryKey", method = RequestMethod.GET)
    public Result selectVideoEnglishByPrimaryKey(Integer tvId){
        VideoEnglish selectByPrimaryKey = videoEnglishService.selectByPrimaryKey(tvId);

        if(tvId==null){
            return Result.falseResult(ErrorCodeConstant.E00002.getMessage(),
                    ErrorCodeConstant.E00002.getCode());
        }

        if (selectByPrimaryKey!=null) {
            return new Result(true,selectByPrimaryKey,ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }



    @ResponseBody
    @RequestMapping(value = "/selectVideoEnglishByKeyWordByPage", method = RequestMethod.GET)
    public Result selectVideoEnglishByKeyWordByPage( String keyWord,Page page){
        PageResult<VideoEnglish> selectByKeyWord = videoEnglishService.selectByKeyWordByPage(keyWord,page);


        if (selectByKeyWord!=null&&selectByKeyWord.getData().size()>0) {
            return new Result(true,selectByKeyWord, ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        }

        if (selectByKeyWord!=null&&selectByKeyWord.getData().size()==0) {
            return new Result(false, ErrorCodeConstant.E00004.getMessage(),
                    ErrorCodeConstant.E00004.getCode());

        }
        else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }


    @ResponseBody
    @RequestMapping(value = "/selectAllVideoEnglishByGradeByPage", method = RequestMethod.GET)
    public Result selectAllVideoEnglishByGradeByPage( Integer gradeId,Page page){
        System.out.println(gradeId);
        PageResult<VideoEnglish> selectAllByPage = videoEnglishService.selectAllByGradeByPage(gradeId,page);



        if (selectAllByPage!=null&&selectAllByPage.getData().size()>0) {
            return new Result(true,selectAllByPage, ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        }

        if (selectAllByPage!=null&&selectAllByPage.getData().size()==0) {
            return new Result(false, ErrorCodeConstant.E00004.getMessage(),
                    ErrorCodeConstant.E00004.getCode());

        }
        else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }


    @ResponseBody
    @RequestMapping(value = "/selectAllVideoEnglishByTextBookByPage", method = RequestMethod.GET)
    public Result selectAllVideoEnglishByTextBookByPage(Integer textbook,Page page){
        PageResult<VideoEnglish> selectAllByPage = videoEnglishService.selectAllByTextBookByPage(textbook,page);



        if (selectAllByPage!=null&&selectAllByPage.getData().size()>0) {
            return new Result(true,selectAllByPage, ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        }

        if (selectAllByPage!=null&&selectAllByPage.getData().size()==0) {
            return new Result(false, ErrorCodeConstant.E00004.getMessage(),
                    ErrorCodeConstant.E00004.getCode());

        }
        else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }





    @ResponseBody
    @RequestMapping(value = "/selectVideoEnglishByTitle", method = RequestMethod.GET)
    public Result selectVideoEnglishByTitle( String title,Page page) {
        VideoEnglish videoEnglish = videoEnglishService.selectVideoEnglishByTitle(title,page);
        if (videoEnglish!=null) {
            return new Result(true,videoEnglish,ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }


    @ResponseBody
    @RequestMapping(value = "/selectAllVideoEnglishByPage", method = RequestMethod.GET)
    public Result selectAllVideoEnglishByPage(Page page) {
        PageResult<VideoEnglish> selectAllByPage = videoEnglishService.selectAllByPage(page);
        if (selectAllByPage != null) {
            return new Result(true, selectAllByPage,
                    ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }








}
